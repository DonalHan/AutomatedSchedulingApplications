/*
* A simple server implementation for the Automated Scheduling Application that deals with adding reviewing tasks
* This implementation demonstrates Unary and Server Streaming services
*/
package ie.nci.distributedsystems.task_management_service;

import ie.nci.distributedsystems.taskrepository.TaskRepo;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.List;

//Declaring the management implementation and extending the Impl class from the proto helper files
public class TaskManagementServerImpl extends TaskManagementServiceGrpc.TaskManagementServiceImplBase
{
    /*A task repository constructor for this service implementation so that it works off the same repository instance */
    private final TaskRepo taskRepository; //Task repo instance variable
    public TaskManagementServerImpl(TaskRepo taskRepository) //Impl constructor linking it to the Task repo
    {
        this.taskRepository = taskRepository;
    }


    /*The task management methods to handle the requests and responses from the client-------------------*/
    /*Add task deals with adding a new task to the repository and returns the newly created ID for said task*/
    @Override
    public void addTask(AddTaskRequest request, StreamObserver<AddTaskResponse> responseObserver)
    {
        Task newTask = request.getTask(); //storing the request task for readability
        Task addedTask = taskRepository.addTask(newTask); //calling the task repo's addTask method to add the task to the list


        AddTaskResponse taskResponse = AddTaskResponse.newBuilder() //declaring a response to return the ID
                .setTaskId(addedTask.getId()) //setting the newly created ID in the response
                .build();

        responseObserver.onNext(taskResponse); //Returning the ID
        responseObserver.onCompleted(); //Completing the service
    }

    /*Get task by date takes in a date object from the client and returns all tasks that fall on this date*/
    public void getTasksByDate(GetTasksByDateRequest request, StreamObserver<Task> responseObserver)
    {
        Date userTime = request.getDate(); //Storing the request date for readability
        List<Task> tasksByDate = taskRepository.getTasksByDate(userTime); //Calling the task repos getTasksByDate and storing the returned tasks into a list
        for (Task task: tasksByDate) //Sending the stream of tasks back to the client
        {
            responseObserver.onNext(task);
        }
        responseObserver.onCompleted(); //Completing the service
    }

    /*A service function that is responsible for obtaining tasks based on ID*/
    @Override
    public void getTask(GetTaskRequest request, StreamObserver<GetTaskResponse> responseObserver)
    {
        int taskId = request.getTaskId(); //storing the ID
        Task task = taskRepository.getTask(taskId); //Getting the task from the repo

        if (task != null) //If it exists
        {
            GetTaskResponse getTaskResponse = GetTaskResponse.newBuilder() //build a response and add the task
                    .setTask(task)
                    .build();

            responseObserver.onNext(getTaskResponse); //send it to client
        }
        else //if the task is not in the list
        {
            responseObserver.onError(Status.NOT_FOUND //call an onError function with the description
                    .withDescription("Task with ID " + taskId + " not found")
                    .asRuntimeException());
        }

        responseObserver.onCompleted(); //complete service
    }


}
