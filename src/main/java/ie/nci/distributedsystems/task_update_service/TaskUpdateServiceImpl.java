package ie.nci.distributedsystems.task_update_service;

import ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse;
import ie.nci.distributedsystems.task_deletion_service.TaskDeletionServiceGrpc;
import ie.nci.distributedsystems.task_management_service.Task;
import ie.nci.distributedsystems.taskrepository.TaskRepo;
import io.grpc.stub.StreamObserver;

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
        return new StreamObserver<GetTaskUpdatesRequest>()
        {
            @Override
            public void onNext(GetTaskUpdatesRequest getTaskUpdatesRequest)
            {

            }

            @Override
            public void onError(Throwable throwable)
            {

            }

            @Override
            public void onCompleted()
            {

            }
        };
    }
}
