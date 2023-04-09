package ie.nci.distributedsystems.task_management_service;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: task.management_service.proto")
public final class TaskManagementServiceGrpc {

  private TaskManagementServiceGrpc() {}

  public static final String SERVICE_NAME = "taskmanagementservice.TaskManagementService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_management_service.AddTaskRequest,
      ie.nci.distributedsystems.task_management_service.AddTaskResponse> getAddTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddTask",
      requestType = ie.nci.distributedsystems.task_management_service.AddTaskRequest.class,
      responseType = ie.nci.distributedsystems.task_management_service.AddTaskResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_management_service.AddTaskRequest,
      ie.nci.distributedsystems.task_management_service.AddTaskResponse> getAddTaskMethod() {
    io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_management_service.AddTaskRequest, ie.nci.distributedsystems.task_management_service.AddTaskResponse> getAddTaskMethod;
    if ((getAddTaskMethod = TaskManagementServiceGrpc.getAddTaskMethod) == null) {
      synchronized (TaskManagementServiceGrpc.class) {
        if ((getAddTaskMethod = TaskManagementServiceGrpc.getAddTaskMethod) == null) {
          TaskManagementServiceGrpc.getAddTaskMethod = getAddTaskMethod = 
              io.grpc.MethodDescriptor.<ie.nci.distributedsystems.task_management_service.AddTaskRequest, ie.nci.distributedsystems.task_management_service.AddTaskResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "taskmanagementservice.TaskManagementService", "AddTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.nci.distributedsystems.task_management_service.AddTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.nci.distributedsystems.task_management_service.AddTaskResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TaskManagementServiceMethodDescriptorSupplier("AddTask"))
                  .build();
          }
        }
     }
     return getAddTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest,
      ie.nci.distributedsystems.task_management_service.Task> getGetTasksByDateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTasksByDate",
      requestType = ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest.class,
      responseType = ie.nci.distributedsystems.task_management_service.Task.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest,
      ie.nci.distributedsystems.task_management_service.Task> getGetTasksByDateMethod() {
    io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest, ie.nci.distributedsystems.task_management_service.Task> getGetTasksByDateMethod;
    if ((getGetTasksByDateMethod = TaskManagementServiceGrpc.getGetTasksByDateMethod) == null) {
      synchronized (TaskManagementServiceGrpc.class) {
        if ((getGetTasksByDateMethod = TaskManagementServiceGrpc.getGetTasksByDateMethod) == null) {
          TaskManagementServiceGrpc.getGetTasksByDateMethod = getGetTasksByDateMethod = 
              io.grpc.MethodDescriptor.<ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest, ie.nci.distributedsystems.task_management_service.Task>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "taskmanagementservice.TaskManagementService", "GetTasksByDate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.nci.distributedsystems.task_management_service.Task.getDefaultInstance()))
                  .setSchemaDescriptor(new TaskManagementServiceMethodDescriptorSupplier("GetTasksByDate"))
                  .build();
          }
        }
     }
     return getGetTasksByDateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TaskManagementServiceStub newStub(io.grpc.Channel channel) {
    return new TaskManagementServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TaskManagementServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TaskManagementServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TaskManagementServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TaskManagementServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TaskManagementServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addTask(ie.nci.distributedsystems.task_management_service.AddTaskRequest request,
        io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_management_service.AddTaskResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddTaskMethod(), responseObserver);
    }

    /**
     */
    public void getTasksByDate(ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest request,
        io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_management_service.Task> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTasksByDateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddTaskMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.nci.distributedsystems.task_management_service.AddTaskRequest,
                ie.nci.distributedsystems.task_management_service.AddTaskResponse>(
                  this, METHODID_ADD_TASK)))
          .addMethod(
            getGetTasksByDateMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest,
                ie.nci.distributedsystems.task_management_service.Task>(
                  this, METHODID_GET_TASKS_BY_DATE)))
          .build();
    }
  }

  /**
   */
  public static final class TaskManagementServiceStub extends io.grpc.stub.AbstractStub<TaskManagementServiceStub> {
    private TaskManagementServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskManagementServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskManagementServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskManagementServiceStub(channel, callOptions);
    }

    /**
     */
    public void addTask(ie.nci.distributedsystems.task_management_service.AddTaskRequest request,
        io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_management_service.AddTaskResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTasksByDate(ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest request,
        io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_management_service.Task> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetTasksByDateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TaskManagementServiceBlockingStub extends io.grpc.stub.AbstractStub<TaskManagementServiceBlockingStub> {
    private TaskManagementServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskManagementServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskManagementServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskManagementServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ie.nci.distributedsystems.task_management_service.AddTaskResponse addTask(ie.nci.distributedsystems.task_management_service.AddTaskRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddTaskMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ie.nci.distributedsystems.task_management_service.Task> getTasksByDate(
        ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetTasksByDateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TaskManagementServiceFutureStub extends io.grpc.stub.AbstractStub<TaskManagementServiceFutureStub> {
    private TaskManagementServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskManagementServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskManagementServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskManagementServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ie.nci.distributedsystems.task_management_service.AddTaskResponse> addTask(
        ie.nci.distributedsystems.task_management_service.AddTaskRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddTaskMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_TASK = 0;
  private static final int METHODID_GET_TASKS_BY_DATE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TaskManagementServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TaskManagementServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_TASK:
          serviceImpl.addTask((ie.nci.distributedsystems.task_management_service.AddTaskRequest) request,
              (io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_management_service.AddTaskResponse>) responseObserver);
          break;
        case METHODID_GET_TASKS_BY_DATE:
          serviceImpl.getTasksByDate((ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest) request,
              (io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_management_service.Task>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TaskManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TaskManagementServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ie.nci.distributedsystems.task_management_service.TaskManagement.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TaskManagementService");
    }
  }

  private static final class TaskManagementServiceFileDescriptorSupplier
      extends TaskManagementServiceBaseDescriptorSupplier {
    TaskManagementServiceFileDescriptorSupplier() {}
  }

  private static final class TaskManagementServiceMethodDescriptorSupplier
      extends TaskManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TaskManagementServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TaskManagementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TaskManagementServiceFileDescriptorSupplier())
              .addMethod(getAddTaskMethod())
              .addMethod(getGetTasksByDateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
