package ie.nci.distributedsystems.client;

import ie.nci.distributedsystems.task_deletion_service.DeleteTaskRequest;
import ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse;
import ie.nci.distributedsystems.task_deletion_service.DeleteTasksRequest;
import ie.nci.distributedsystems.task_deletion_service.TaskDeletionServiceGrpc;
import ie.nci.distributedsystems.task_management_service.*;
import ie.nci.distributedsystems.task_update_service.*;
import io.grpc.*;
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
    private static ManagedChannel channel;
    private static List<ManagedChannel> managedChannels = new ArrayList<>();




    /*Main method responsible for starting up the GUI and linking all the functionality and communication*/
    public static void main(String[] args) throws InterruptedException, IOException
    {
        /*jmDNS Implementation----------------------------------------------------------------------------------------*/
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost()); // creating a jmdns instance

        GrpcServiceListener taskManagementListener = new GrpcServiceListener("_taskmanagement._tcp.local."); //instantiating a custom listener for task management service
        GrpcServiceListener taskUpdateListener = new GrpcServiceListener("_taskupdate._tcp.local."); //instantiating a custom listener for task update service
        GrpcServiceListener taskDeletionListener = new GrpcServiceListener("_taskdeletion._tcp.local."); //instantiating a custom listener for task deletion service

        jmdns.addServiceListener(taskManagementListener.getServiceType(), taskManagementListener); //adding a listener for task management service
        jmdns.addServiceListener(taskUpdateListener.getServiceType(), taskUpdateListener); //adding a listener for task update service
        jmdns.addServiceListener(taskDeletionListener.getServiceType(), taskDeletionListener); //adding a listener for deletion service

        while (!isConnected) //using the validator to wait for the connections
        {
            Thread.sleep(2000); //wait 2 seconds
        }


        /*Launch the GUI----------------------------------------------------------------------------------------------*/
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
                frame.setContentPane(new AutomatedSchedulingApplicationGUI(controller).ASAMain); //set the content of the previous Jframe object as an instance of the GUI's main panel
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //setting the close operation as exit on close
                frame.pack(); //size the frame in relation to the content in it
                frame.setVisible(true); //allows the interface to be displayed
            }
        });



    }


/*This method is responsible for connecting the client to the server using a channel, it also passes this channel to the stubs*/
    private static void setupGrpcConnection(ServiceInfo serviceInfo) throws InterruptedException
    {
        // Creating the ManagedChannel, the port and name is passed in from the discovered jmDNS services
        channel = ManagedChannelBuilder.forAddress(serviceInfo.getInetAddresses()[0].getHostAddress(), serviceInfo.getPort())
                .intercept(new MetadataClientInterceptor())
                .usePlaintext()
                .build();

        // Add the channel to the list
        managedChannels.add(channel);

        // Setting up the gRPC stubs using the channel
        blockingStub = TaskManagementServiceGrpc.newBlockingStub(channel);
        asyncStub = TaskManagementServiceGrpc.newStub(channel);
        blockingStubDeletion = TaskDeletionServiceGrpc.newBlockingStub(channel);
        asyncStubDeletion = TaskDeletionServiceGrpc.newStub(channel);
        asyncStubUpdate = TaskUpdateServiceGrpc.newStub(channel);

        isConnected = true; //The validator is now true
    }

    public static void shutdownChannels()
    {
        for (ManagedChannel channel : managedChannels)
        {
            channel.shutdown();
            try {
                if (!channel.awaitTermination(5, TimeUnit.SECONDS))
                {
                    channel.shutdownNow();
                    if (!channel.awaitTermination(5, TimeUnit.SECONDS))
                    {
                        System.err.println("Channel did not terminate");
                    }
                }
            }
            catch (InterruptedException e)
            {
                channel.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }




    /*Custom service listener class for jmDNS-----------------------------------------------------------------------------*/
    static class GrpcServiceListener implements ServiceListener //uses the service listener methods to discover the jmDNS services
    {
        private String serviceType; // storing the service typ

        public GrpcServiceListener(String serviceType) //constructor for each service listener that gets passed in
        {
            this.serviceType = serviceType;
        }

        public String getServiceType() //getter for the service type
        {
            return serviceType;
        }
        @Override
        public void serviceAdded(ServiceEvent serviceEvent) //discovers the services
        {
            System.out.println("Service added: " + serviceEvent.getInfo()); //print service info when found
            serviceEvent.getDNS().requestServiceInfo(serviceEvent.getType(), serviceEvent.getName(), 1); //obtaining the dns type, the name, and the timeout value
        }

        @Override
        public void serviceRemoved(ServiceEvent serviceEvent)
        {
            System.out.println("Service removed: " + serviceEvent.getInfo()); //print that a service has been removed
        }

        @Override
        public void serviceResolved(ServiceEvent serviceEvent)
        {
            System.out.println("Service resolved: " + serviceEvent.getInfo()); //print that a service has been resolved
            ServiceInfo serviceInfo = serviceEvent.getInfo(); // retrieve the info from the event being passed in

            if (serviceInfo.getType().equals(serviceType))
            {
                try //attempt to set up a gRPC connection using the jmDNS discovered info
                {
                    setupGrpcConnection(serviceInfo); //passing the info into the previous connection setup method (above)
                }
                catch (InterruptedException e) //if there's any interruption exceptions, catch them during the setup process
                {
                    throw new RuntimeException(e); //throw the caught exception
                }
            }

        }
    }

/*This is a metadata method that is responsible for putting forth calls with user role information, in this case: admin */
    static class MetadataClientInterceptor implements ClientInterceptor
    {
        @Override
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
                MethodDescriptor<ReqT, RespT> method, // Method descriptor for the gRPC request and responses being called
                CallOptions callOptions, // Contains details such as deadlines
                Channel next)
        {
            ClientCall<ReqT, RespT> call = next.newCall(method, callOptions); // Creates a new ClientCall with the method descriptor and call options

            return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(call) // Returns a new instance of SimpleForwardingClientCall
            {
                @Override // Indicates the following method overrides a method from a superclass or interface
                public void start(Listener<RespT> responseListener, Metadata headers)
                {
                    headers.put(Metadata.Key.of("user-role", Metadata.ASCII_STRING_MARSHALLER), "admin"); // Adds a custom metadata header to the headers object
                    super.start(responseListener, headers); // Calls the start method of the superclass to delegate the rest of the work to the original ClientCall
                }
            };
        }
    }


    /*Client side functioning utility methods for sending requests and handling responses to be connected to the GUI------*/

    // Adds task method, sends a task to the repository and receives the newly created ID for it
    public static AddTaskResponse addTask(Task task)
    {
        AddTaskRequest addTaskRequest = AddTaskRequest.newBuilder() //Builds task object from the task parameter
                .setTask(task)
                .build();
        return blockingStub.addTask(addTaskRequest); //use the stub to send the request and return the response (ID)
    }

    //Get task by date method, takes ina  date object and receives a stream of tasks that fall on that date
    public static List<Task> getTasksByDate(Date date) throws InterruptedException
    {
        CountDownLatch latch = new CountDownLatch(1); // A countdown latch that holds the application until the stream is finished
        List<Task> tasks = new ArrayList<>(); //storing the tasks in an array list

        GetTasksByDateRequest dateRequest = GetTasksByDateRequest.newBuilder() //Building a request with the passed in date parameter
                .setDate(date)
                .build();

        StreamObserver<Task> streamDates = new StreamObserver<Task>() //Declaring a stream observer to handle all the server responses that come back
        {
            @Override
            public void onNext(Task task) //On the next task that comes in
            {
                tasks.add(task); //add the task to the list
            }

            @Override
            public void onError(Throwable throwable) //if there's an error, throw it and release the latch
            {
                throwable.printStackTrace();
                latch.countDown(); //release the latch on the application
            }

            @Override
            public void onCompleted()//Stream completed/concluded
            {
                latch.countDown(); //When the stream has finished, take the application off the latch
            }
        };

        asyncStub.getTasksByDate(dateRequest, streamDates); // call the service and pass in the date and the stream observer
        latch.await(5, TimeUnit.SECONDS); //the latch waits for 5 seconds for the info to come back

        return tasks; //return the list of tasks retrieved from the service
    }


    //Get Task method, responsible for retrieving a task with a given ID
    public static GetTaskResponse getTask(int taskId)
    {
        GetTaskRequest taskRequest = GetTaskRequest.newBuilder() //Building a request with the passed in ID
                .setTaskId(taskId)
                .build();
        try //Try to call the service
        {
            return blockingStub.getTask(taskRequest);
        }
        catch (StatusRuntimeException error) //Catch any errors if the service fails to retrieve a task
        {
            if (error.getStatus().getCode() == Status.Code.NOT_FOUND) //If the task is not found
            {
                return null; //return a null object
            }
            throw error; //Throw the error
        }
    }


    //A method responsible for deleting tasks with a given ID
    public static DeleteTaskResponse deleteTask(int taskId)
    {
        DeleteTaskRequest deleteTaskRequest = DeleteTaskRequest.newBuilder() //Building a request based off the parameter ID passed in
                .setTaskId(taskId)
                .build();
        return blockingStubDeletion.deleteTask(deleteTaskRequest); //Call the service and return the response
    }


    //A method responsible for deleting multiple tasks based of a number of IDs
    public static String deleteMultipleTasks(ArrayList<Integer> taskIds) throws InterruptedException
    {
        CountDownLatch latch = new CountDownLatch(1); //Declaring a count-down latch to 'latch' or hold the program while the streams send requests and responses
        StringBuilder status = new StringBuilder(); // Declaring a string builder to hold the status of the deletion operations

        //Declaring a stream observer that sends a request and handles the response
        StreamObserver<DeleteTasksRequest> deleteTasksRequestStreamObserver = asyncStubDeletion.deleteTasks(new StreamObserver<DeleteTaskResponse>()
        {
            @Override
            public void onNext(DeleteTaskResponse deleteTaskResponse)
            {
                status.append(deleteTaskResponse.getStatus()).append("\n"); //Append to the string builder the status of the current task being deleted
            }

            @Override
            public void onError(Throwable throwable)
            {
                System.out.println("Error occurred: " + throwable.getMessage()); //print the error that occurred
                latch.countDown(); // take the application off the latch
            }

            @Override
            public void onCompleted()
            {
                System.out.println("Delete Service Completed"); //print when completed the stream
                latch.countDown(); //take the application off of the latch/hold
            }
        });

        for (int taskId : taskIds) //For loop that sends the multiple task Ids through the stream observer
        {
            deleteTasksRequestStreamObserver.onNext(DeleteTasksRequest.newBuilder()
                    .setTaskId(taskId)
                    .build());
        }
        deleteTasksRequestStreamObserver.onCompleted(); //complete the service
        latch.await(5, TimeUnit.SECONDS); //wait for the application to send the responses
        return status.toString(); //return the string builder with all the status messages

    }


    //A method for sending multiple task IDs as requests and updating their respective information
    public static String updateTasks(List<Task> tasksToUpdate) throws InterruptedException
    {
        CountDownLatch latch = new CountDownLatch(1); //Declaring a count-down latch to 'latch' or hold the program while the streams send requests and responses
        StringBuilder status = new StringBuilder(); // Declaring a string builder to hold the status of the deletion operations

        //Declaring a stream observer to send the requests and handle the responses from the server
        StreamObserver<UpdateTaskRequest> updateTaskRequestStreamObserver = asyncStubUpdate.updateTasks(new StreamObserver<UpdateTaskResponse>()
        {
            @Override
            public void onNext(UpdateTaskResponse updateTaskResponse)
            {
                status.append(updateTaskResponse.getStatus()).append("\n"); //add to the string builder the status of the given task update
            }

            @Override
            public void onError(Throwable throwable)
            {
                System.out.println("Error occurred: " + throwable.getMessage()); //print the error that occured
                latch.countDown(); // take the application off the latch
            }

            @Override
            public void onCompleted()
            {
                System.out.println("Update Service Completed"); //print service completed
                latch.countDown(); // take the application off the latch
            }
        });

        for (Task taskUpdate : tasksToUpdate) //for loop that send the multiple tasks updated to the server to update the repository
        {
            updateTaskRequestStreamObserver.onNext(UpdateTaskRequest.newBuilder() //building a new request with the updated task
                    .setTask(taskUpdate)
                    .build());
        }
        updateTaskRequestStreamObserver.onCompleted(); //complete when all  the tasks have been sent
        latch.await(5, TimeUnit.SECONDS); //hold the latch for 5 seconds while the stream sends information
        return status.toString(); //return all the statuses of the updated tasks
    }


    //A bidirectional service that tracks tasks for the user, it takes ID and a gui panel that displays live updates
    public static StreamObserver<GetTaskUpdatesRequest> getTaskUpdates(List<Integer> taskIdsToObserve, JPanel gui)
    {
        //A stream observer that deals with the update notification passed from the server
        StreamObserver<GetTaskUpdatesRequest> updateRequestObserver = asyncStubUpdate.getTaskUpdates(new StreamObserver<GetTaskUpdatesResponse>()
        {
            @Override
            public void onNext(GetTaskUpdatesResponse getTaskUpdatesResponse)
            {
                String taskUpdateInfo = taskInfo(getTaskUpdatesResponse.getTask()); //Retrieving the task that has been updated
                //using the Joption pane pop up to show the updated task with the gui that has been passed in as a parameter
                //The parameters passed in is the parent GUI, the display message, the message title, and the message type
                SwingUtilities.invokeLater(() -> JOptionPane
                        .showMessageDialog(gui, taskUpdateInfo, "Task Update", JOptionPane.INFORMATION_MESSAGE));

            }

            @Override
            public void onError(Throwable throwable)
            {
                System.out.println("Error: " + throwable.getMessage());//print the thrown error
            }

            @Override
            public void onCompleted() {
                System.out.println("Task update service completed."); //print on completed
            }
        });

        for (int taskIdToObserve : taskIdsToObserve) //Send multiple task ID requests to be tracked to the server
        {
            GetTaskUpdatesRequest getTaskUpdatesRequest = GetTaskUpdatesRequest.newBuilder() //Build requests
                    .setTaskId(taskIdToObserve)
                    .build();

            updateRequestObserver.onNext(getTaskUpdatesRequest); //send the IDs to the server
        }

        return updateRequestObserver; //return the observer
    }



    // A method that closes the stream observer from the last get updates method, it is responsible for cancelling update notifications
    public void cancelTaskUpdates(StreamObserver<GetTaskUpdatesRequest> updateRequestObserver)
    {
        if (updateRequestObserver != null)
        {
            updateRequestObserver.onCompleted(); //complete the service
        }
    }





}

