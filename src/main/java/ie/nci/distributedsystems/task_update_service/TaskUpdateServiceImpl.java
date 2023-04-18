/*
 * A simple server implementation for the Automated Scheduling Application that deals with updating and tracking tasks
 * This service demonstrates Bi-Directional and Client Streaming services
 */

package ie.nci.distributedsystems.task_update_service;

import ie.nci.distributedsystems.task_management_service.Task;
import ie.nci.distributedsystems.taskrepository.TaskRepo;
import ie.nci.distributedsystems.taskrepository.TaskRepo.TaskTracker;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.List;

/*A service implementation for the server side which entails updating and subscribing to tasks*/
public class TaskUpdateServiceImpl extends TaskUpdateServiceGrpc.TaskUpdateServiceImplBase
{
    /*A task repository constructor for this service implementation so that it works off the same repository instance as other services*/
    private final TaskRepo taskRepository; //Task repo instance variable
    public TaskUpdateServiceImpl(TaskRepo taskRepository) //Impl constructor linking it to the Task repo
    {
        this.taskRepository = taskRepository;
    }

    /*An update tasks stream observer that handles multiple incoming tasks from the user and updates the repository with the task ID's respective information*/
    @Override
    public StreamObserver<UpdateTaskRequest> updateTasks(StreamObserver<UpdateTaskResponse> responseObserver)
    {
        StringBuilder statusMessages = new StringBuilder(); //String builder that returns the status of the updates back to the client
        return new StreamObserver<UpdateTaskRequest>() //Stream observer that handles all the incoming requests
        {
            @Override
            public void onNext(UpdateTaskRequest updateTaskRequest)
            {
                boolean isUpdated = taskRepository.updateTask(updateTaskRequest.getTask()); //validator to check if a task was updates, calling the task repo update functions
                int taskId = updateTaskRequest.getTask().getId(); //storing the task ID to find the task in the Repo later

                if (isUpdated) // if its updated, update the string builder accordingly
                {
                    statusMessages.append("Task ID: ").append(taskId).append(" updated successfully.\n");
                }
                else //if not, update the string builder
                {
                    statusMessages.append("Task ID: ").append(taskId).append(" not in the list.\n");
                }
            }

            @Override
            public void onError(Throwable throwable)
            {
                System.out.println("Error occurred: " + throwable.getMessage());
            }

            @Override
            public void onCompleted()
            {
                String finalStatusMessage = statusMessages.toString(); //Building a final message to send back with all the status
                if (finalStatusMessage.isEmpty()) //in case the string builder wasnt updated
                {
                    finalStatusMessage = "No tasks were updated.";
                }

                UpdateTaskResponse response = UpdateTaskResponse.newBuilder() //building a response
                        .setStatus(finalStatusMessage)
                        .build();

                responseObserver.onNext(response); //sending the response
                responseObserver.onCompleted(); //complete service
            }
        };

    }

    /*A service that is responsible for subscribing users to numerous tasks and receive updates if there is a change*/
    @Override
    public StreamObserver<GetTaskUpdatesRequest> getTaskUpdates(StreamObserver<GetTaskUpdatesResponse> responseObserver)
    {
        List<TaskTracker> taskTrackerList = new ArrayList<>();

        // This stream observer is used handle requests from the client of ID's to be tracked
        return new StreamObserver<GetTaskUpdatesRequest>()
        {
            @Override
            public void onNext(GetTaskUpdatesRequest getTaskUpdatesRequest)
            {
                TaskTracker taskTracker = new TaskTracker() // This task tracker is used to keep track of any update changes
                {
                    private int taskId; // any task tracker that is created is linked to a specific task ID
                    @Override
                    public void onTaskUpdated(Task updatedTask) //Once this task trackers method is called, it sends the task being updated back to the client
                    {
                        GetTaskUpdatesResponse response = GetTaskUpdatesResponse.newBuilder() //Build response
                                .setTask(updatedTask)
                                .build();
                        responseObserver.onNext(response);
                    }
                    @Override
                    public int getTaskId() //used to keep track of the ID being subscribed
                    {
                        return taskId;
                    }
                    public void setTaskId(int taskId) //used to set the task trackers ID variable
                    {
                        this.taskId = taskId;
                    }
                };
                taskTracker.setTaskId(getTaskUpdatesRequest.getTaskId()); //Set the new tracker ID as the ID of the task being tracked
                taskRepository.registerTaskTracker(taskTracker); //register the task tracker in the repo
                taskTrackerList.add(taskTracker); //add the task tracker
            }

            @Override
            public void onError(Throwable throwable)
            {
                System.out.println("Error: " + throwable.getMessage());
            }

            @Override
            public void onCompleted()
            {
                // Unregister all TaskTrackers/ cancel user subscriptions
                for (TaskTracker taskTracker : taskTrackerList)
                {
                    taskRepository.unregisterTaskTracker(taskTracker);
                }
                responseObserver.onCompleted(); //complete service
            }
        };
    }

}
