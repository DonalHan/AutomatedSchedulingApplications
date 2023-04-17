package ie.nci.distributedsystems.client;

import ie.nci.distributedsystems.task_deletion_service.DeleteTaskRequest;
import ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse;
import ie.nci.distributedsystems.task_deletion_service.DeleteTasksRequest;
import ie.nci.distributedsystems.task_deletion_service.TaskDeletionServiceGrpc;
import ie.nci.distributedsystems.task_management_service.*;
import ie.nci.distributedsystems.task_update_service.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import java.net.InetAddress;
import javax.jmdns.ServiceListener;
import javax.swing.*;

import static ie.nci.distributedsystems.client.AutomatedSchedulingApplicationGUI.taskInfo;


public class ControllerGUI
{
    /*Instantiating the stubs for the service requests*/
    private static TaskManagementServiceGrpc.TaskManagementServiceBlockingStub blockingStub; //blocking task management stub
    private static TaskManagementServiceGrpc.TaskManagementServiceStub asyncStub; //async task management stub
    private static TaskDeletionServiceGrpc.TaskDeletionServiceBlockingStub blockingStubDeletion; //unary task deletion stub
    private static TaskDeletionServiceGrpc.TaskDeletionServiceStub asyncStubDeletion; //async task deletion stub
    private static TaskUpdateServiceGrpc.TaskUpdateServiceStub asyncStubUpdate; //unary task management stub
    private static boolean isConnected = false; //validator to check is the channel and server are connected
    public static void main(String[] args) throws InterruptedException, IOException
    {
        /*jmDNS Implementation----------------------------------------------------------------------------------------*/
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost()); // creating a jmdns instance

        GrpcServiceListener grpcServiceListener = new GrpcServiceListener(); //instantiating a custom listener for each service

        jmdns.addServiceListener("_taskmanagement._tcp.local.", grpcServiceListener); //adding a listener for task management service
        jmdns.addServiceListener("_taskupdate._tcp.local.", grpcServiceListener); //adding a listener for task update service
        jmdns.addServiceListener("_taskdeletion._tcp.local.", grpcServiceListener); //adding a listener for deletion service

        while (!isConnected) //using the validator to wait for the connections
        {
            Thread.sleep(1000); //wait ten seconds
        }


        // Launch the GUI
        ControllerGUI controller = new ControllerGUI(); //instantiating the current controller class
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    // Try to set the aesthetic as the systems
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //matches the current look and feel of the system
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
                {
                    e.printStackTrace();
                }

                JFrame frame = new JFrame("Automated Scheduling Application"); //create a jframe OBJECT with the application name (ASA)
                frame.setContentPane(new AutomatedSchedulingApplicationGUI(controller).ASAMain); //set the previous Jframe object
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

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
    public static AddTaskResponse addTask(Task task)
    {
        AddTaskRequest addTaskRequest = AddTaskRequest.newBuilder()
                .setTask(task)
                .build();
        return blockingStub.addTask(addTaskRequest);
    }

    public static List<Task> getTasksByDate(Date date) throws InterruptedException
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

    public static GetTaskResponse getTask(int taskId)
    {
        GetTaskRequest taskRequest = GetTaskRequest.newBuilder()
                .setTaskId(taskId)
                .build();
        try
        {
            return blockingStub.getTask(taskRequest);
        }
        catch (StatusRuntimeException error)
        {
            if (error.getStatus().getCode() == Status.Code.NOT_FOUND)
            {
                return null;
            }
            throw error;
        }
    }

    public static DeleteTaskResponse deleteTask(int taskId)
    {
        DeleteTaskRequest deleteTaskRequest = DeleteTaskRequest.newBuilder()
                .setTaskId(taskId)
                .build();
        return blockingStubDeletion.deleteTask(deleteTaskRequest);
    }

    public static String deleteMultipleTasks(ArrayList<Integer> taskIds) throws InterruptedException
    {
        CountDownLatch latch = new CountDownLatch(1);
        StringBuilder status = new StringBuilder();

        StreamObserver<DeleteTasksRequest> deleteTasksRequestStreamObserver = asyncStubDeletion.deleteTasks(new StreamObserver<DeleteTaskResponse>()
        {
            @Override
            public void onNext(DeleteTaskResponse deleteTaskResponse)
            {
                status.append(deleteTaskResponse.getStatus()).append("\n");
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
        return status.toString();

    }

    public static String updateTasks(List<Task> tasksToUpdate) throws InterruptedException
    {
        CountDownLatch latch = new CountDownLatch(1);
        StringBuilder status = new StringBuilder();


        StreamObserver<UpdateTaskRequest> updateTaskRequestStreamObserver = asyncStubUpdate.updateTasks(new StreamObserver<UpdateTaskResponse>()
        {
            @Override
            public void onNext(UpdateTaskResponse updateTaskResponse)
            {
                status.append(updateTaskResponse.getStatus()).append("\n");
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
        return status.toString();
    }
    public static StreamObserver<GetTaskUpdatesRequest> getTaskUpdates(List<Integer> taskIdsToObserve, JPanel gui)
    {
        StreamObserver<GetTaskUpdatesRequest> updateRequestObserver = asyncStubUpdate.getTaskUpdates(new StreamObserver<GetTaskUpdatesResponse>() {
            @Override
            public void onNext(GetTaskUpdatesResponse getTaskUpdatesResponse) {
                String taskUpdateInfo = taskInfo(getTaskUpdatesResponse.getTask());
                SwingUtilities.invokeLater(() -> JOptionPane
                        .showMessageDialog(gui, taskUpdateInfo, "Task Update", JOptionPane.INFORMATION_MESSAGE));
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

        for (int taskIdToObserve : taskIdsToObserve)
        {
            GetTaskUpdatesRequest getTaskUpdatesRequest = GetTaskUpdatesRequest.newBuilder()
                    .setTaskId(taskIdToObserve)
                    .build();

            updateRequestObserver.onNext(getTaskUpdatesRequest);
        }

        return updateRequestObserver;
    }

    public void cancelTaskUpdates(StreamObserver<GetTaskUpdatesRequest> updateRequestObserver)
    {
        if (updateRequestObserver != null)
        {
            updateRequestObserver.onCompleted();
        }
    }





}

