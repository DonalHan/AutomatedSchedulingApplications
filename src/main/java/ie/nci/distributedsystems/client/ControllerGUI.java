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

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import java.net.InetAddress;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import java.awt.*;


public class ControllerGUI
{
    private static TaskManagementServiceGrpc.TaskManagementServiceBlockingStub blockingStub;
    private static TaskManagementServiceGrpc.TaskManagementServiceStub asyncStub;
    private static TaskDeletionServiceGrpc.TaskDeletionServiceBlockingStub blockingStubDeletion;
    private static TaskDeletionServiceGrpc.TaskDeletionServiceStub asyncStubDeletion;
    private static TaskUpdateServiceGrpc.TaskUpdateServiceStub asyncStubUpdate;
    private static boolean isConnected = false;
    public static void main(String[] args) throws InterruptedException, IOException
    {
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
        //Adding Service Listeners

        GrpcServiceListener grpcServiceListener = new GrpcServiceListener();

        jmdns.addServiceListener("_taskmanagement._tcp.local.", grpcServiceListener);
        jmdns.addServiceListener("_taskupdate._tcp.local.", grpcServiceListener);
        jmdns.addServiceListener("_taskdeletion._tcp.local.", grpcServiceListener);

        while (!isConnected)
        {
            Thread.sleep(1000);
        }

        // Add a new task
        Task newTask = Task.newBuilder()
                .setName("Test Task")
                .setDescription("This is a test task")
                .setDueDate(Date.newBuilder().setYear(2023).setMonth(4).setDay(12).build())
                .build();
        AddTaskResponse addTaskResponse = addTask(newTask);
        System.out.println("Task added: " + addTaskResponse.getTaskId());

        // Get tasks by date
        Date date = Date.newBuilder().setYear(2023).setMonth(4).setDay(12).build();
        List<Task> tasks = getTasksByDate(date);
        System.out.println("Tasks for " + date.toString() + ": " + tasks);

    }
    private static void setupGrpcConnection(ServiceInfo serviceInfo) throws InterruptedException
    {
        // Create the ManagedChannel using the discovered IP address and port number
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serviceInfo.getInetAddresses()[0].getHostAddress(), serviceInfo.getPort())
                .usePlaintext()
                .build();

        // Set up the gRPC stubs using the channel
        blockingStub = TaskManagementServiceGrpc.newBlockingStub(channel);
        asyncStub = TaskManagementServiceGrpc.newStub(channel);
        blockingStubDeletion = TaskDeletionServiceGrpc.newBlockingStub(channel);
        asyncStubDeletion = TaskDeletionServiceGrpc.newStub(channel);
        asyncStubUpdate = TaskUpdateServiceGrpc.newStub(channel);

        isConnected = true;

    }

    static class GrpcServiceListener implements ServiceListener
    {
        @Override
        public void serviceAdded(ServiceEvent serviceEvent)
        {
            System.out.println("Service added: " + serviceEvent.getInfo());
            serviceEvent.getDNS().requestServiceInfo(serviceEvent.getType(), serviceEvent.getName(), 1);
        }

        @Override
        public void serviceRemoved(ServiceEvent serviceEvent)
        {
            System.out.println("Service removed: " + serviceEvent.getInfo());
        }

        @Override
        public void serviceResolved(ServiceEvent serviceEvent)
        {
            System.out.println("Service resolved: " + serviceEvent.getInfo());
            ServiceInfo serviceInfo = serviceEvent.getInfo();

            // Set up the gRPC connection using the discovered service info
            try
            {
                setupGrpcConnection(serviceInfo);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
    private static AddTaskResponse addTask(Task task)
    {
        AddTaskRequest addTaskRequest = AddTaskRequest.newBuilder()
                .setTask(task)
                .build();
        return blockingStub.addTask(addTaskRequest);
    }

    private static List<Task> getTasksByDate(Date date) throws InterruptedException
    {
        CountDownLatch latch = new CountDownLatch(1);
        List<Task> tasks = new ArrayList<>();

        GetTasksByDateRequest dateRequest = GetTasksByDateRequest.newBuilder()
                .setDate(date)
                .build();

        StreamObserver<Task> streamDates = new StreamObserver<Task>()
        {
            @Override
            public void onNext(Task task)
            {
                tasks.add(task);
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
                latch.countDown();
            }
        };

        asyncStub.getTasksByDate(dateRequest, streamDates);
        latch.await(5, TimeUnit.SECONDS);

        return tasks;
    }

    private static GetTaskResponse getTask (int taskId)
    {
        GetTaskRequest taskRequest = GetTaskRequest.newBuilder()
                .setTaskId(taskId)
                .build();
        return  blockingStub.getTask(taskRequest);
    }
    private static DeleteTaskResponse deleteTask(int taskId)
    {
        DeleteTaskRequest deleteTaskRequest = DeleteTaskRequest.newBuilder()
                .setTaskId(taskId)
                .build();
        return blockingStubDeletion.deleteTask(deleteTaskRequest);
    }

    private static void deleteMultipleTasks(int[] taskIds) throws InterruptedException
    {
        CountDownLatch latch = new CountDownLatch(1);
        StreamObserver<DeleteTasksRequest> deleteTasksRequestStreamObserver = asyncStubDeletion.deleteTasks(new StreamObserver<DeleteTaskResponse>()
        {
            @Override
            public void onNext(DeleteTaskResponse deleteTaskResponse)
            {
                System.out.println(deleteTaskResponse.getStatus());
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
                System.out.println("Delete Service Completed");
                latch.countDown();
            }
        });

        for (int taskId : taskIds)
        {
            deleteTasksRequestStreamObserver.onNext(DeleteTasksRequest.newBuilder()
                    .setTaskId(taskId)
                    .build());
        }
        deleteTasksRequestStreamObserver.onCompleted();
        latch.await(5, TimeUnit.SECONDS);
    }

    private static void updateTasks(List<Task> tasksToUpdate) throws InterruptedException
    {
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<UpdateTaskRequest> updateTaskRequestStreamObserver = asyncStubUpdate.updateTasks(new StreamObserver<UpdateTaskResponse>()
        {
            @Override
            public void onNext(UpdateTaskResponse updateTaskResponse)
            {
                System.out.println("Update status: " + updateTaskResponse.getStatus());
            }

            @Override
            public void onError(Throwable throwable)
            {
                System.out.println("Error occurred: " + throwable.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted()
            {
                System.out.println("Update Service Completed");
                latch.countDown();
            }
        });

        for (Task taskUpdate : tasksToUpdate)
        {
            updateTaskRequestStreamObserver.onNext(UpdateTaskRequest.newBuilder()
                    .setTask(taskUpdate)
                    .build());
        }
        updateTaskRequestStreamObserver.onCompleted();
        latch.await(5, TimeUnit.SECONDS);
    }
    private static StreamObserver<GetTaskUpdatesRequest> getTaskUpdates(int taskIdToObserve)
    {
        GetTaskUpdatesRequest getTaskUpdatesRequest = GetTaskUpdatesRequest.newBuilder()
                .setTaskId(taskIdToObserve)
                .build();

        StreamObserver<GetTaskUpdatesRequest> updateRequestObserver = asyncStubUpdate.getTaskUpdates(new StreamObserver<GetTaskUpdatesResponse>()
        {
            @Override
            public void onNext(GetTaskUpdatesResponse getTaskUpdatesResponse)
            {
                System.out.println("Task updated: " + getTaskUpdatesResponse.getTask().toString());
            }

            @Override
            public void onError(Throwable throwable)
            {
                System.out.println("Error: " + throwable.getMessage());
            }

            @Override
            public void onCompleted()
            {
                System.out.println("Task update service completed.");
            }
        });

        // Sending the task ID to observe
        updateRequestObserver.onNext(getTaskUpdatesRequest);

        return updateRequestObserver;
    }

}

