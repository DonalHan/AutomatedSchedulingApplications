package ie.nci.distributedsystems.task_deletion_service;

import ie.nci.distributedsystems.task_management_service.TaskManagementServiceGrpc;
import io.grpc.stub.StreamObserver;

public class TaskDeletionServiceImpl extends TaskDeletionServiceGrpc.TaskDeletionServiceImplBase
{
    @Override
    public void deleteTask(DeleteTaskRequest request, StreamObserver<DeleteTaskResponse> responseObserver)
    {

    }

    @Override
    public StreamObserver<DeleteTasksRequest> deleteTasks(StreamObserver<DeleteTaskResponse> responseObserver)
    {
        return new StreamObserver<DeleteTasksRequest>()
        {
            @Override
            public void onNext(DeleteTasksRequest deleteTasksRequest)
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
