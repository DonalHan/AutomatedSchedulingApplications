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
import io.grpc.*;

public class MainServer
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        TaskRepo taskRepository = new TaskRepo(); //Declaring a new task repository

        // Declaring service implementations with the shared task repository as the paramter
        TaskManagementServerImpl taskManagementService = new TaskManagementServerImpl(taskRepository);
        TaskDeletionServiceImpl taskDeletionService = new TaskDeletionServiceImpl(taskRepository);
        TaskUpdateServiceImpl taskUpdateService = new TaskUpdateServiceImpl(taskRepository);

        Server server = ServerBuilder.forPort(50021) //Building a server for each service to be added to
                .addService(taskManagementService) // adding the task management service to the server
                .addService(taskDeletionService) //adding the task deletion service to the server
                .addService(taskUpdateService) //adding the task update service to the server
                .intercept(new MetadataServerInterceptor())
                .build();//building the server

        server.start(); //start the server


        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost()); // Declaring a JmDNS instance

        // Create  ServiceInfo instances (type,name and unified port) for each service
        ServiceInfo taskManagementServiceInfo = ServiceInfo.create("_taskmanagement._tcp.local.", "TaskManagementService", 50021, "");
        ServiceInfo taskDeletionServiceInfo = ServiceInfo.create("_taskdeletion._tcp.local.", "TaskDeletionService", 50021, "");
        ServiceInfo taskUpdateServiceInfo = ServiceInfo.create("_taskupdate._tcp.local.", "TaskUpdateService", 50021, "");

        // Register each of the services with the jmDNS
        jmdns.registerService(taskManagementServiceInfo);
        jmdns.registerService(taskDeletionServiceInfo);
        jmdns.registerService(taskUpdateServiceInfo);

        System.out.println("Server started on port " + server.getPort()); //Inform the user the server has started
        server.awaitTermination(); //awaits a shutdown call


    }

    static class MetadataServerInterceptor implements ServerInterceptor
    {
        @Override
        public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, // Represents the call object for the server-side
                                                                     Metadata headers, // Contains the metadata received from the client
                                                                     ServerCallHandler<ReqT, RespT> next)
        {
            // Extract custom metadata
            String userRole = headers.get(Metadata.Key.of("user-role", Metadata.ASCII_STRING_MARSHALLER)); // Retrieves the custom metadata from the headers object
            System.out.println("Received user-role: " + userRole);

            // Continue processing the call
            return next.startCall(call, headers); // Starts the next interceptor or the actual server call, passing along the call object and headers
        }
    }




}










