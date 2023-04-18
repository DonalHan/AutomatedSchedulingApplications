/*
 * A simple server implementation for the Automated Scheduling Application that deals with deleting tasks
 * This service demonstrates Unary and Client Streaming services
 */
package ie.nci.distributedsystems.task_deletion_service;

import ie.nci.distributedsystems.taskrepository.TaskRepo;
import io.grpc.stub.StreamObserver;


public class TaskDeletionServiceImpl extends TaskDeletionServiceGrpc.TaskDeletionServiceImplBase
{
    /*A task repository constructor for this service implementation so that it works off the same repository instance as other services*/
    private final TaskRepo taskRepository; //Task repo instance variable
    public TaskDeletionServiceImpl(TaskRepo taskRepository) //Impl constructor linking it to the Task repo
    {
        this.taskRepository = taskRepository;
    }

    /*An unary function that takes in an ID and returns a status message*/
    @Override
    public void deleteTask(DeleteTaskRequest request, StreamObserver<DeleteTaskResponse> responseObserver)
    {
        int userId = request.getTaskId(); //storing the id
        boolean isDeleted = taskRepository.deleteTask(userId); //calling the task repos to delete the task from the repository, returns boolean

        // A ternary operator that populates the status in accordance with the previous boolean result
        String status = isDeleted ? "Task Deleted Successfully" : "Task is not in the list";

        DeleteTaskResponse response = DeleteTaskResponse.newBuilder() //building a response and populating it with the status
                .setStatus(status)
                .build();

        responseObserver.onNext(response); //sending the response to the client
        responseObserver.onCompleted(); //completing service
    }

    /*A client side streaming function that takes in multiple IDs and then deletes their corresponding tasks in the repo*/
    @Override
    public StreamObserver<DeleteTasksRequest> deleteTasks(StreamObserver<DeleteTaskResponse> responseObserver)
    {
        StringBuilder statusMessages = new StringBuilder(); //declaring a string builder to store the status of the deletions
        return new StreamObserver<DeleteTasksRequest>() //Stream observer handles the incoming requests
        {

            @Override
            public void onNext(DeleteTasksRequest deleteTasksRequest)
            {
                int taskId = deleteTasksRequest.getTaskId(); //storing the ID to be deleted
                boolean isDeleted = taskRepository.deleteTask(taskId); //sending the ID to the task repository and storing the boolean results when deleted or not

                if (isDeleted) //if its deleted, update the string builder
                {
                    statusMessages.append("Task ID: ").append(taskId).append(" deleted successfully.\n");
                }
                else //if its not, update the string builder accordingly
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
                String finalStatusMessage = statusMessages.toString(); //store the final status results
                if (finalStatusMessage.isEmpty()) //if the string builder is empty send back the following message
                {
                    finalStatusMessage = "No tasks were deleted.";
                }

                DeleteTaskResponse response = DeleteTaskResponse.newBuilder() //build the response and populate it with the string
                        .setStatus(finalStatusMessage)
                        .build();

                responseObserver.onNext(response); //send response to the client
                responseObserver.onCompleted(); //complete service

            }
        };
    }
}
