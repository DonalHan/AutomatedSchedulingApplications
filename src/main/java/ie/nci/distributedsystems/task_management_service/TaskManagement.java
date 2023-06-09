// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: task_management_service.proto

package ie.nci.distributedsystems.task_management_service;

public final class TaskManagement {
  private TaskManagement() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_taskmanagementservice_Task_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_taskmanagementservice_Task_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_taskmanagementservice_Date_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_taskmanagementservice_Date_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_taskmanagementservice_AddTaskRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_taskmanagementservice_AddTaskRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_taskmanagementservice_AddTaskResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_taskmanagementservice_AddTaskResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_taskmanagementservice_GetTasksByDateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_taskmanagementservice_GetTasksByDateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_taskmanagementservice_GetTaskRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_taskmanagementservice_GetTaskRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_taskmanagementservice_GetTaskResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_taskmanagementservice_GetTaskResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\035task_management_service.proto\022\025taskman" +
      "agementservice\032\037google/protobuf/timestam" +
      "p.proto\"{\n\004Task\022\n\n\002id\030\001 \001(\005\022\014\n\004name\030\002 \001(" +
      "\t\022\023\n\013description\030\003 \001(\t\022-\n\010due_date\030\004 \001(\013" +
      "2\033.taskmanagementservice.Date\022\025\n\rassigne" +
      "d_user\030\005 \001(\t\"0\n\004Date\022\014\n\004year\030\001 \001(\005\022\r\n\005mo" +
      "nth\030\002 \001(\005\022\013\n\003day\030\003 \001(\005\";\n\016AddTaskRequest" +
      "\022)\n\004task\030\001 \001(\0132\033.taskmanagementservice.T" +
      "ask\"\"\n\017AddTaskResponse\022\017\n\007task_id\030\001 \001(\005\"" +
      "B\n\025GetTasksByDateRequest\022)\n\004date\030\001 \001(\0132\033" +
      ".taskmanagementservice.Date\"!\n\016GetTaskRe" +
      "quest\022\017\n\007task_id\030\001 \001(\005\"<\n\017GetTaskRespons" +
      "e\022)\n\004task\030\001 \001(\0132\033.taskmanagementservice." +
      "Task2\252\002\n\025TaskManagementService\022X\n\007AddTas" +
      "k\022%.taskmanagementservice.AddTaskRequest" +
      "\032&.taskmanagementservice.AddTaskResponse" +
      "\022]\n\016GetTasksByDate\022,.taskmanagementservi" +
      "ce.GetTasksByDateRequest\032\033.taskmanagemen" +
      "tservice.Task0\001\022X\n\007GetTask\022%.taskmanagem" +
      "entservice.GetTaskRequest\032&.taskmanageme" +
      "ntservice.GetTaskResponseBE\n1ie.nci.dist" +
      "ributedsystems.task_management_serviceB\016" +
      "TaskManagementP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
        }, assigner);
    internal_static_taskmanagementservice_Task_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_taskmanagementservice_Task_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_taskmanagementservice_Task_descriptor,
        new java.lang.String[] { "Id", "Name", "Description", "DueDate", "AssignedUser", });
    internal_static_taskmanagementservice_Date_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_taskmanagementservice_Date_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_taskmanagementservice_Date_descriptor,
        new java.lang.String[] { "Year", "Month", "Day", });
    internal_static_taskmanagementservice_AddTaskRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_taskmanagementservice_AddTaskRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_taskmanagementservice_AddTaskRequest_descriptor,
        new java.lang.String[] { "Task", });
    internal_static_taskmanagementservice_AddTaskResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_taskmanagementservice_AddTaskResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_taskmanagementservice_AddTaskResponse_descriptor,
        new java.lang.String[] { "TaskId", });
    internal_static_taskmanagementservice_GetTasksByDateRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_taskmanagementservice_GetTasksByDateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_taskmanagementservice_GetTasksByDateRequest_descriptor,
        new java.lang.String[] { "Date", });
    internal_static_taskmanagementservice_GetTaskRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_taskmanagementservice_GetTaskRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_taskmanagementservice_GetTaskRequest_descriptor,
        new java.lang.String[] { "TaskId", });
    internal_static_taskmanagementservice_GetTaskResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_taskmanagementservice_GetTaskResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_taskmanagementservice_GetTaskResponse_descriptor,
        new java.lang.String[] { "Task", });
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
