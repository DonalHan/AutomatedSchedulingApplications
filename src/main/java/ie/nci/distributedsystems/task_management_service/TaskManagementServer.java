package ie.nci.distributedsystems.task_management_service;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class TaskManagementServer
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Server server = ServerBuilder.forPort(50021)
                .build();

        server.start();
        System.out.println("Server started on port " + server.getPort());
        server.awaitTermination();
    }
}
