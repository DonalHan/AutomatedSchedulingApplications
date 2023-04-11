package ie.nci.distributedsystems.task_update_service;

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
    comments = "Source: task_update_service.proto")
public final class TaskUpdateServiceGrpc {

  private TaskUpdateServiceGrpc() {}

  public static final String SERVICE_NAME = "taskupdateservice.TaskUpdateService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_update_service.UpdateTaskRequest,
      ie.nci.distributedsystems.task_update_service.UpdateTaskResponse> getUpdateTasksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTasks",
      requestType = ie.nci.distributedsystems.task_update_service.UpdateTaskRequest.class,
      responseType = ie.nci.distributedsystems.task_update_service.UpdateTaskResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_update_service.UpdateTaskRequest,
      ie.nci.distributedsystems.task_update_service.UpdateTaskResponse> getUpdateTasksMethod() {
    io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_update_service.UpdateTaskRequest, ie.nci.distributedsystems.task_update_service.UpdateTaskResponse> getUpdateTasksMethod;
    if ((getUpdateTasksMethod = TaskUpdateServiceGrpc.getUpdateTasksMethod) == null) {
      synchronized (TaskUpdateServiceGrpc.class) {
        if ((getUpdateTasksMethod = TaskUpdateServiceGrpc.getUpdateTasksMethod) == null) {
          TaskUpdateServiceGrpc.getUpdateTasksMethod = getUpdateTasksMethod = 
              io.grpc.MethodDescriptor.<ie.nci.distributedsystems.task_update_service.UpdateTaskRequest, ie.nci.distributedsystems.task_update_service.UpdateTaskResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "taskupdateservice.TaskUpdateService", "UpdateTasks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.nci.distributedsystems.task_update_service.UpdateTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.nci.distributedsystems.task_update_service.UpdateTaskResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TaskUpdateServiceMethodDescriptorSupplier("UpdateTasks"))
                  .build();
          }
        }
     }
     return getUpdateTasksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_update_service.GetTaskUpdatesRequest,
      ie.nci.distributedsystems.task_update_service.GetTaskUpdatesResponse> getGetTaskUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTaskUpdates",
      requestType = ie.nci.distributedsystems.task_update_service.GetTaskUpdatesRequest.class,
      responseType = ie.nci.distributedsystems.task_update_service.GetTaskUpdatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_update_service.GetTaskUpdatesRequest,
      ie.nci.distributedsystems.task_update_service.GetTaskUpdatesResponse> getGetTaskUpdatesMethod() {
    io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_update_service.GetTaskUpdatesRequest, ie.nci.distributedsystems.task_update_service.GetTaskUpdatesResponse> getGetTaskUpdatesMethod;
    if ((getGetTaskUpdatesMethod = TaskUpdateServiceGrpc.getGetTaskUpdatesMethod) == null) {
      synchronized (TaskUpdateServiceGrpc.class) {
        if ((getGetTaskUpdatesMethod = TaskUpdateServiceGrpc.getGetTaskUpdatesMethod) == null) {
          TaskUpdateServiceGrpc.getGetTaskUpdatesMethod = getGetTaskUpdatesMethod = 
              io.grpc.MethodDescriptor.<ie.nci.distributedsystems.task_update_service.GetTaskUpdatesRequest, ie.nci.distributedsystems.task_update_service.GetTaskUpdatesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "taskupdateservice.TaskUpdateService", "GetTaskUpdates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.nci.distributedsystems.task_update_service.GetTaskUpdatesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.nci.distributedsystems.task_update_service.GetTaskUpdatesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TaskUpdateServiceMethodDescriptorSupplier("GetTaskUpdates"))
                  .build();
          }
        }
     }
     return getGetTaskUpdatesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TaskUpdateServiceStub newStub(io.grpc.Channel channel) {
    return new TaskUpdateServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TaskUpdateServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TaskUpdateServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TaskUpdateServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TaskUpdateServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TaskUpdateServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_update_service.UpdateTaskRequest> updateTasks(
        io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_update_service.UpdateTaskResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getUpdateTasksMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_update_service.GetTaskUpdatesRequest> getTaskUpdates(
        io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_update_service.GetTaskUpdatesResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetTaskUpdatesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUpdateTasksMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ie.nci.distributedsystems.task_update_service.UpdateTaskRequest,
                ie.nci.distributedsystems.task_update_service.UpdateTaskResponse>(
                  this, METHODID_UPDATE_TASKS)))
          .addMethod(
            getGetTaskUpdatesMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ie.nci.distributedsystems.task_update_service.GetTaskUpdatesRequest,
                ie.nci.distributedsystems.task_update_service.GetTaskUpdatesResponse>(
                  this, METHODID_GET_TASK_UPDATES)))
          .build();
    }
  }

  /**
   */
  public static final class TaskUpdateServiceStub extends io.grpc.stub.AbstractStub<TaskUpdateServiceStub> {
    private TaskUpdateServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskUpdateServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskUpdateServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskUpdateServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_update_service.UpdateTaskRequest> updateTasks(
        io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_update_service.UpdateTaskResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getUpdateTasksMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_update_service.GetTaskUpdatesRequest> getTaskUpdates(
        io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_update_service.GetTaskUpdatesResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetTaskUpdatesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class TaskUpdateServiceBlockingStub extends io.grpc.stub.AbstractStub<TaskUpdateServiceBlockingStub> {
    private TaskUpdateServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskUpdateServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskUpdateServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskUpdateServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class TaskUpdateServiceFutureStub extends io.grpc.stub.AbstractStub<TaskUpdateServiceFutureStub> {
    private TaskUpdateServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskUpdateServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskUpdateServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskUpdateServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_UPDATE_TASKS = 0;
  private static final int METHODID_GET_TASK_UPDATES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TaskUpdateServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TaskUpdateServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPDATE_TASKS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.updateTasks(
              (io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_update_service.UpdateTaskResponse>) responseObserver);
        case METHODID_GET_TASK_UPDATES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getTaskUpdates(
              (io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_update_service.GetTaskUpdatesResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TaskUpdateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TaskUpdateServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ie.nci.distributedsystems.task_update_service.TaskUpdate.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TaskUpdateService");
    }
  }

  private static final class TaskUpdateServiceFileDescriptorSupplier
      extends TaskUpdateServiceBaseDescriptorSupplier {
    TaskUpdateServiceFileDescriptorSupplier() {}
  }

  private static final class TaskUpdateServiceMethodDescriptorSupplier
      extends TaskUpdateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TaskUpdateServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TaskUpdateServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TaskUpdateServiceFileDescriptorSupplier())
              .addMethod(getUpdateTasksMethod())
              .addMethod(getGetTaskUpdatesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
