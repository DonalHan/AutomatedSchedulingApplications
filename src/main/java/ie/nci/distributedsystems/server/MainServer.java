package ie.nci.distributedsystems.server;

import ie.nci.distributedsystems.task_deletion_service.TaskDeletionServiceImpl;
import ie.nci.distributedsystems.task_management_service.TaskManagementServerImpl;
import ie.nci.distributedsystems.task_update_service.TaskUpdateServiceImpl;
import ie.nci.distributedsystems.taskrepository.TaskRepo;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class MainServer
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        TaskRepo taskRepository = new TaskRepo(); //Declaring a new task repository

        // Declaring service implementations with the shared task repository
        TaskManagementServerImpl taskManagementService = new TaskManagementServerImpl(taskRepository);
        TaskDeletionServiceImpl taskDeletionService = new TaskDeletionServiceImpl(taskRepository);

        Server server = ServerBuilder.forPort(50021)
                .addService(taskManagementService)
                .addService(taskDeletionService)
                .build();

        server.start();
        System.out.println("Server started on port " + server.getPort());
        server.awaitTermination();
    }
}










