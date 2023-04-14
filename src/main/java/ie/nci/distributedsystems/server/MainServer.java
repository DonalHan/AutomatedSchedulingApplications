package ie.nci.distributedsystems.server;

import ie.nci.distributedsystems.task_deletion_service.TaskDeletionServiceImpl;
import ie.nci.distributedsystems.task_management_service.TaskManagementServerImpl;
import ie.nci.distributedsystems.task_update_service.TaskUpdateServiceImpl;
import ie.nci.distributedsystems.taskrepository.TaskRepo;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.net.InetAddress;

public class MainServer
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        TaskRepo taskRepository = new TaskRepo(); //Declaring a new task repository

        // Declaring service implementations with the shared task repository
        TaskManagementServerImpl taskManagementService = new TaskManagementServerImpl(taskRepository);
        TaskDeletionServiceImpl taskDeletionService = new TaskDeletionServiceImpl(taskRepository);
        TaskUpdateServiceImpl taskUpdateService = new TaskUpdateServiceImpl(taskRepository);

        Server server = ServerBuilder.forPort(50021)
                .addService(taskManagementService)
                .addService(taskDeletionService)
                .addService(taskUpdateService)
                .build();

        server.start();

        // Create a JmDNS instance
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

        // Create a ServiceInfo instance for each service
        ServiceInfo taskManagementServiceInfo = ServiceInfo.create("_taskmanagement._tcp.local.", "TaskManagementService", 50021, "");
        ServiceInfo taskDeletionServiceInfo = ServiceInfo.create("_taskdeletion._tcp.local.", "TaskDeletionService", 50021, "");
        ServiceInfo taskUpdateServiceInfo = ServiceInfo.create("_taskupdate._tcp.local.", "TaskUpdateService", 50021, "");

        // Register the services with JmDNS
        jmdns.registerService(taskManagementServiceInfo);
        jmdns.registerService(taskDeletionServiceInfo);
        jmdns.registerService(taskUpdateServiceInfo);

        System.out.println("Server started on port " + server.getPort());
        server.awaitTermination();
    }
}










