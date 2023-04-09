package ie.nci.distributedsystems.client;

import ie.nci.distributedsystems.task_management_service.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class ControllerGUI
{
    public static void main(String[] args) throws InterruptedException {
        //Channel/bridge------------------------------
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50021)
                .usePlaintext()
                .build();

        //Testing the task management -----------------
        //Stubs
        TaskManagementServiceGrpc.TaskManagementServiceBlockingStub blockingStub = TaskManagementServiceGrpc.newBlockingStub(channel);
        TaskManagementServiceGrpc.TaskManagementServiceStub asyncStub = TaskManagementServiceGrpc.newStub(channel);

        Task task = Task.newBuilder()
                .setAssignedUser("Donal Hanway")
                .setDescription("Clean the toilet and then the stairs")
                .setName("Clean house")
                .setDueDate(Date.newBuilder()
                        .setDay(24)
                        .setMonth(8)
                        .setYear(1991)
                        .build())
                .build();

        AddTaskRequest addTaskRequest = AddTaskRequest.newBuilder()
                        .setTask(task)
                        .build();


        AddTaskResponse addTaskResponse = blockingStub.addTask(addTaskRequest);
        System.out.println("Task added successfully. ID number:  " + addTaskResponse.getTaskId());

        //Server streaming impl--------------------
        Date newDate = Date.newBuilder()
            .setDay(24)
            .setMonth(8)
            .setYear(1991)
            .build();

        CountDownLatch latch = new CountDownLatch(1);

        GetTasksByDateRequest dateRequest = GetTasksByDateRequest.newBuilder()
                .setDate(newDate)
                .build();

        StreamObserver<Task> streamDates=  new StreamObserver<Task>()
        {
            @Override
            public void onNext(Task task)
            {
                System.out.println("Task: " + task.toString());
            }

            @Override
            public void onError(Throwable throwable)
            {
                throwable.printStackTrace();
                latch.countDown();
            }

            @Override
            public void onCompleted()
            {
                System.out.println("Stream completed.");
                latch.countDown();
            }
        };

        asyncStub.getTasksByDate(dateRequest, streamDates);
        latch.await(5, TimeUnit.SECONDS);

        System.out.println("Channel shutdown");
        channel.shutdownNow();
    }
}