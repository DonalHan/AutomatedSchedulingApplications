package ie.nci.distributedsystems.server;

import ie.nci.distributedsystems.task_deletion_service.TaskDeletionServiceImpl;
import ie.nci.distributedsystems.task_management_service.TaskManagementServerImpl;
import ie.nci.distributedsystems.task_update_service.TaskUpdateServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class MainServer
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Server server = ServerBuilder.forPort(50021)
                .addService(new TaskManagementServerImpl())
//                .addService(new TaskDeletionServiceImpl())
//                .addService(new TaskUpdateServiceImpl())
                .build();

        server.start();
        System.out.println("Server started on port " + server.getPort());
        server.awaitTermination();
    }
}










