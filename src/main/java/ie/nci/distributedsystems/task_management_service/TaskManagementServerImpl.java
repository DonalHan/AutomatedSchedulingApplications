/*A simple server implementation for the Automated Scheduling Application that deals with adding reviewing tasks
* This implementation demonstrates Unary and Server Streaming services
* */
package ie.nci.distributedsystems.task_management_service;

import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

//Declaring the management implementation and extending the Impl class from the proto helper files
public class TaskManagementServerImpl extends TaskManagementServiceGrpc.TaskManagementServiceImplBase
{
    //Declaring a list to hold tasks added by the user
    List<Task> taskList = new ArrayList<>();
    int currentTopId = 0;
    @Override
    public void addTask(AddTaskRequest request, StreamObserver<AddTaskResponse> responseObserver)
    {
        Task newTask = request.getTask();
        currentTopId++;

        newTask = newTask.toBuilder()
                .setId(currentTopId)
                .build();

        taskList.add(newTask);

        AddTaskResponse taskResponse = AddTaskResponse.newBuilder()
                .setTaskId(newTask.getId())
                .build();

        responseObserver.onNext(taskResponse);
        responseObserver.onCompleted();

    }

    public void getTasksByDate(GetTasksByDateRequest request, StreamObserver<Task> responseObserver)
    {
        Date userTime = request.getDate();

        for (Task task: taskList)
        {
            if(userTime.equals(task.getDueDate()))
            {
                responseObserver.onNext(task);
            }
        }
        responseObserver.onCompleted();

    }

}
