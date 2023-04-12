package ie.nci.distributedsystems.client;

import ie.nci.distributedsystems.task_deletion_service.DeleteTaskRequest;
import ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse;
import ie.nci.distributedsystems.task_deletion_service.DeleteTasksRequest;
import ie.nci.distributedsystems.task_deletion_service.TaskDeletionServiceGrpc;
import ie.nci.distributedsystems.task_management_service.*;
import ie.nci.distributedsystems.task_update_service.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;


public class ControllerGUI  {

    public static void main(String[] args) throws InterruptedException
    {

        //Channel/bridge------------------------------
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50021)
                .usePlaintext()
                .build();

        //Testing the task management -----------------
        //Stubs
        TaskManagementServiceGrpc.TaskManagementServiceBlockingStub blockingStub = TaskManagementServiceGrpc.newBlockingStub(channel);
        TaskManagementServiceGrpc.TaskManagementServiceStub asyncStub = TaskManagementServiceGrpc.newStub(channel);

        TaskDeletionServiceGrpc.TaskDeletionServiceBlockingStub blockingStubDeletion = TaskDeletionServiceGrpc.newBlockingStub(channel);
        TaskDeletionServiceGrpc.TaskDeletionServiceStub asyncStubDeletion = TaskDeletionServiceGrpc.newStub(channel);

        TaskUpdateServiceGrpc.TaskUpdateServiceStub asyncStubUpdate = TaskUpdateServiceGrpc.newStub(channel);

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

        //Server streaming impl - streaming multiple tasks by date--------------------
        Date newDate = Date.newBuilder()
                .setDay(24)
                .setMonth(8)
                .setYear(1991)
                .build();

        CountDownLatch latch = new CountDownLatch(1);

        GetTasksByDateRequest dateRequest = GetTasksByDateRequest.newBuilder()
                .setDate(newDate)
                .build();

        StreamObserver<Task> streamDates = new StreamObserver<Task>() {
            @Override
            public void onNext(Task task) {
                System.out.println("Task: " + task.toString());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Stream completed.");
                latch.countDown();
            }
        };

        asyncStub.getTasksByDate(dateRequest, streamDates);
        latch.await(5, TimeUnit.SECONDS);

        //Task deletion service------------------------------------------
        //Deleting a single task--------------------------------


        DeleteTaskRequest deleteTaskRequest = DeleteTaskRequest.newBuilder()
                .setTaskId(2)
                .build();

        DeleteTaskResponse deleteTaskResponse = blockingStubDeletion.deleteTask(deleteTaskRequest);
        System.out.println(deleteTaskResponse.getStatus());

        //Deleting multiple  tasks--------------------------------
        CountDownLatch latch2 = new CountDownLatch(1);
        StreamObserver<DeleteTasksRequest> deleteTasksRequestStreamObserver = asyncStubDeletion.deleteTasks(new StreamObserver<DeleteTaskResponse>() {
            @Override
            public void onNext(DeleteTaskResponse deleteTaskResponse) {
                System.out.println(deleteTaskResponse.getStatus());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
                latch2.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Delete Service Completed");
                latch2.countDown();
            }
        });

        int[] numbers = {1, 2, 3, 4, 5};
        for (int number : numbers) {
            deleteTasksRequestStreamObserver.onNext(DeleteTasksRequest.newBuilder()
                    .setTaskId(number)
                    .build());
        }
        deleteTasksRequestStreamObserver.onCompleted();
        latch2.await(5, TimeUnit.SECONDS);
        //get task updates----------------------------------

        int taskIdToObserve = 6; // The ID of the task you want to observe updates for
        GetTaskUpdatesRequest getTaskUpdatesRequest = GetTaskUpdatesRequest.newBuilder()
                .setTaskId(taskIdToObserve)
                .build();

        StreamObserver<GetTaskUpdatesRequest> updateRequestObserver = asyncStubUpdate.getTaskUpdates(new StreamObserver<GetTaskUpdatesResponse>() {
            @Override
            public void onNext(GetTaskUpdatesResponse getTaskUpdatesResponse) {
                System.out.println("Task updated: " + getTaskUpdatesResponse.getTask().toString());

            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Task update service completed.");
            }
        });

        // Sending the task ID to observe
        updateRequestObserver.onNext(getTaskUpdatesRequest);


        //Update tasks request-----------------------------------------------------------


        CountDownLatch latch3 = new CountDownLatch(1);

        StreamObserver<UpdateTaskRequest> updateTaskRequestStreamObserver = asyncStubUpdate.updateTasks(new StreamObserver<UpdateTaskResponse>() {
            @Override
            public void onNext(UpdateTaskResponse updateTaskResponse) {
                System.out.println("Update status: " + updateTaskResponse.getStatus());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error occurred: " + throwable.getMessage());
                latch3.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Update Service Completed");
                latch3.countDown();

            }
        });

        List<Task> tasksToUpdate = Arrays.asList(
                Task.newBuilder()
                        .setId(6)
                        .setName("Updated Task 6")
                        .build(),
                Task.newBuilder()
                        .setId(7)
                        .setName("Updated Task 7")
                        .build(),
                Task.newBuilder()
                        .setId(1)
                        .setName("Updated Task 8")
                        .build()
        );


        for (Task taskUpdate : tasksToUpdate) {
            updateTaskRequestStreamObserver.onNext(UpdateTaskRequest.newBuilder()
                    .setTask(taskUpdate)
                    .build());
        }
        updateTaskRequestStreamObserver.onCompleted();
        latch3.await(5, TimeUnit.SECONDS);


        updateRequestObserver.onCompleted();


        System.out.println("Channel shutdown");
        channel.shutdownNow();


    }


}

