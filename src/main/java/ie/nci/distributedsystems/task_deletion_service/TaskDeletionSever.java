package ie.nci.distributedsystems.task_deletion_service;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class TaskDeletionSever
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Server server = ServerBuilder.forPort(50020)
                .build();

        server.start();
        System.out.println("Server started on port " + server.getPort());
        server.awaitTermination();
    }
}
