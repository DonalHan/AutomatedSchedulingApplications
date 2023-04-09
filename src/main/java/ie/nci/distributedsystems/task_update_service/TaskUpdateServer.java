package ie.nci.distributedsystems.task_update_service;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class TaskUpdateServer
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Server server = ServerBuilder.forPort(50022)
                .build();

        server.start();
        System.out.println("Server started on port " + server.getPort());
        server.awaitTermination();
    }
}
