package ie.nci.distributedsystems.task_update_service;

import ie.nci.distributedsystems.task_management_service.Task;
import ie.nci.distributedsystems.taskrepository.TaskRepo;
import ie.nci.distributedsystems.taskrepository.TaskRepo.TaskTracker;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class TaskUpdateServiceImpl extends TaskUpdateServiceGrpc.TaskUpdateServiceImplBase
{
    /*A task repository constructor for this service implementation so that it works off the same repository instance as other services*/
    private final TaskRepo taskRepository; //Task repo instance variable
    public TaskUpdateServiceImpl(TaskRepo taskRepository) //Impl constructor linking it to the Task repo
    {
        this.taskRepository = taskRepository;
    }

    @Override
    public StreamObserver<UpdateTaskRequest> updateTasks(StreamObserver<UpdateTaskResponse> responseObserver)
    {
        StringBuilder statusMessages = new StringBuilder();
        return new StreamObserver<UpdateTaskRequest>()
        {
            @Override
            public void onNext(UpdateTaskRequest updateTaskRequest)
            {
                boolean isUpdated = taskRepository.updateTask(updateTaskRequest.getTask());
                int taskId = updateTaskRequest.getTask().getId();

                if (isUpdated)
                {
                    statusMessages.append("Task ID: ").append(taskId).append(" updated successfully.\n");
                }
                else
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
                String finalStatusMessage = statusMessages.toString();
                if (finalStatusMessage.isEmpty())
                {
                    finalStatusMessage = "No tasks were updated.";
                }

                UpdateTaskResponse response = UpdateTaskResponse.newBuilder()
                        .setStatus(finalStatusMessage)
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };

    }

    @Override
    public StreamObserver<GetTaskUpdatesRequest> getTaskUpdates(StreamObserver<GetTaskUpdatesResponse> responseObserver)
    {
        List<TaskTracker> taskTrackerList = new ArrayList<>();

        return new StreamObserver<GetTaskUpdatesRequest>() // This stream observer is used handle requests from the client of ID's to be tracked
        {
            @Override
            public void onNext(GetTaskUpdatesRequest getTaskUpdatesRequest)
            {
                TaskTracker taskTracker = new TaskTracker() // This task tracker is used to keep track of any update changes
                {
                    private int taskId; // any task tracker that is created is linked to a specidfic task ID
                    @Override
                    public void onTaskUpdated(Task updatedTask) //Once this task trackers method is called, it sends the task being updated back to the client
                    {
                        GetTaskUpdatesResponse response = GetTaskUpdatesResponse.newBuilder()
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
                taskTracker.setTaskId(getTaskUpdatesRequest.getTaskId());
                taskRepository.registerTaskTracker(taskTracker);
                taskTrackerList.add(taskTracker);
            }

            @Override
            public void onError(Throwable throwable)
            {
                System.out.println("Error: " + throwable.getMessage());
            }

            @Override
            public void onCompleted()
            {
                // Unregister all TaskTracker instances in the list
                for (TaskTracker taskTracker : taskTrackerList) {
                    taskRepository.unregisterTaskTracker(taskTracker);
                }
                responseObserver.onCompleted();
            }
        };
    }

}
