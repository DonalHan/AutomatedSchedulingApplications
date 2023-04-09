package ie.nci.distributedsystems.task_deletion_service;

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
 * <pre>
 * Add the Task Deletion Service definition-----
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: task_deletion_service.proto")
public final class TaskDeletionServiceGrpc {

  private TaskDeletionServiceGrpc() {}

  public static final String SERVICE_NAME = "taskdeletionservice.TaskDeletionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_deletion_service.DeleteTaskRequest,
      ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse> getDeleteTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTask",
      requestType = ie.nci.distributedsystems.task_deletion_service.DeleteTaskRequest.class,
      responseType = ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_deletion_service.DeleteTaskRequest,
      ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse> getDeleteTaskMethod() {
    io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_deletion_service.DeleteTaskRequest, ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse> getDeleteTaskMethod;
    if ((getDeleteTaskMethod = TaskDeletionServiceGrpc.getDeleteTaskMethod) == null) {
      synchronized (TaskDeletionServiceGrpc.class) {
        if ((getDeleteTaskMethod = TaskDeletionServiceGrpc.getDeleteTaskMethod) == null) {
          TaskDeletionServiceGrpc.getDeleteTaskMethod = getDeleteTaskMethod = 
              io.grpc.MethodDescriptor.<ie.nci.distributedsystems.task_deletion_service.DeleteTaskRequest, ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "taskdeletionservice.TaskDeletionService", "DeleteTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.nci.distributedsystems.task_deletion_service.DeleteTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TaskDeletionServiceMethodDescriptorSupplier("DeleteTask"))
                  .build();
          }
        }
     }
     return getDeleteTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_deletion_service.DeleteTasksRequest,
      ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse> getDeleteTasksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTasks",
      requestType = ie.nci.distributedsystems.task_deletion_service.DeleteTasksRequest.class,
      responseType = ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_deletion_service.DeleteTasksRequest,
      ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse> getDeleteTasksMethod() {
    io.grpc.MethodDescriptor<ie.nci.distributedsystems.task_deletion_service.DeleteTasksRequest, ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse> getDeleteTasksMethod;
    if ((getDeleteTasksMethod = TaskDeletionServiceGrpc.getDeleteTasksMethod) == null) {
      synchronized (TaskDeletionServiceGrpc.class) {
        if ((getDeleteTasksMethod = TaskDeletionServiceGrpc.getDeleteTasksMethod) == null) {
          TaskDeletionServiceGrpc.getDeleteTasksMethod = getDeleteTasksMethod = 
              io.grpc.MethodDescriptor.<ie.nci.distributedsystems.task_deletion_service.DeleteTasksRequest, ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "taskdeletionservice.TaskDeletionService", "DeleteTasks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.nci.distributedsystems.task_deletion_service.DeleteTasksRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TaskDeletionServiceMethodDescriptorSupplier("DeleteTasks"))
                  .build();
          }
        }
     }
     return getDeleteTasksMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TaskDeletionServiceStub newStub(io.grpc.Channel channel) {
    return new TaskDeletionServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TaskDeletionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TaskDeletionServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TaskDeletionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TaskDeletionServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Add the Task Deletion Service definition-----
   * </pre>
   */
  public static abstract class TaskDeletionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void deleteTask(ie.nci.distributedsystems.task_deletion_service.DeleteTaskRequest request,
        io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteTaskMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_deletion_service.DeleteTasksRequest> deleteTasks(
        io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getDeleteTasksMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDeleteTaskMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.nci.distributedsystems.task_deletion_service.DeleteTaskRequest,
                ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse>(
                  this, METHODID_DELETE_TASK)))
          .addMethod(
            getDeleteTasksMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ie.nci.distributedsystems.task_deletion_service.DeleteTasksRequest,
                ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse>(
                  this, METHODID_DELETE_TASKS)))
          .build();
    }
  }

  /**
   * <pre>
   * Add the Task Deletion Service definition-----
   * </pre>
   */
  public static final class TaskDeletionServiceStub extends io.grpc.stub.AbstractStub<TaskDeletionServiceStub> {
    private TaskDeletionServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskDeletionServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskDeletionServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskDeletionServiceStub(channel, callOptions);
    }

    /**
     */
    public void deleteTask(ie.nci.distributedsystems.task_deletion_service.DeleteTaskRequest request,
        io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_deletion_service.DeleteTasksRequest> deleteTasks(
        io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getDeleteTasksMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Add the Task Deletion Service definition-----
   * </pre>
   */
  public static final class TaskDeletionServiceBlockingStub extends io.grpc.stub.AbstractStub<TaskDeletionServiceBlockingStub> {
    private TaskDeletionServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskDeletionServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskDeletionServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskDeletionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse deleteTask(ie.nci.distributedsystems.task_deletion_service.DeleteTaskRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteTaskMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Add the Task Deletion Service definition-----
   * </pre>
   */
  public static final class TaskDeletionServiceFutureStub extends io.grpc.stub.AbstractStub<TaskDeletionServiceFutureStub> {
    private TaskDeletionServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskDeletionServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskDeletionServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskDeletionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse> deleteTask(
        ie.nci.distributedsystems.task_deletion_service.DeleteTaskRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteTaskMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELETE_TASK = 0;
  private static final int METHODID_DELETE_TASKS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TaskDeletionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TaskDeletionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DELETE_TASK:
          serviceImpl.deleteTask((ie.nci.distributedsystems.task_deletion_service.DeleteTaskRequest) request,
              (io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse>) responseObserver);
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
        case METHODID_DELETE_TASKS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.deleteTasks(
              (io.grpc.stub.StreamObserver<ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TaskDeletionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TaskDeletionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ie.nci.distributedsystems.task_deletion_service.TaskDeletion.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TaskDeletionService");
    }
  }

  private static final class TaskDeletionServiceFileDescriptorSupplier
      extends TaskDeletionServiceBaseDescriptorSupplier {
    TaskDeletionServiceFileDescriptorSupplier() {}
  }

  private static final class TaskDeletionServiceMethodDescriptorSupplier
      extends TaskDeletionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TaskDeletionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TaskDeletionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TaskDeletionServiceFileDescriptorSupplier())
              .addMethod(getDeleteTaskMethod())
              .addMethod(getDeleteTasksMethod())
              .build();
        }
      }
    }
    return result;
  }
}
