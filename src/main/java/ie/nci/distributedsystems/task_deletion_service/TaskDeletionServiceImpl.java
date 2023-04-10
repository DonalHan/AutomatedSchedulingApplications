package ie.nci.distributedsystems.task_deletion_service;


import ie.nci.distributedsystems.task_management_service.TaskManagementServiceGrpc;
import ie.nci.distributedsystems.taskrepository.TaskRepo;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class TaskDeletionServiceImpl extends TaskDeletionServiceGrpc.TaskDeletionServiceImplBase
{
    /*A task repository constructor for this service implementation so that it works off the same repository instance as other services*/
    private final TaskRepo taskRepository; //Task repo instance variable
    public TaskDeletionServiceImpl(TaskRepo taskRepository) //Impl constructor linking it to the Task repo
    {
        this.taskRepository = taskRepository;
    }
    @Override
    public void deleteTask(DeleteTaskRequest request, StreamObserver<DeleteTaskResponse> responseObserver)
    {
        int userId = request.getTaskId();
        boolean isDeleted = taskRepository.deleteTask(userId);

        String status = isDeleted ? "Task Deleted Successfully" : "Task is not in the list";

        DeleteTaskResponse response = DeleteTaskResponse.newBuilder()
                .setStatus(status)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<DeleteTasksRequest> deleteTasks(StreamObserver<DeleteTaskResponse> responseObserver)
    {
        StringBuilder statusMessages = new StringBuilder();
        return new StreamObserver<DeleteTasksRequest>()
        {

            @Override
            public void onNext(DeleteTasksRequest deleteTasksRequest)
            {
                int taskId = deleteTasksRequest.getTaskId();
                boolean isDeleted = taskRepository.deleteTask(taskId);

                if (isDeleted)
                {
                    statusMessages.append("Task ID: ").append(taskId).append(" deleted successfully.\n");
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
                    finalStatusMessage = "No tasks were deleted.";
                }

                DeleteTaskResponse response = DeleteTaskResponse.newBuilder()
                        .setStatus(finalStatusMessage)
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();

            }
        };
    }
}
