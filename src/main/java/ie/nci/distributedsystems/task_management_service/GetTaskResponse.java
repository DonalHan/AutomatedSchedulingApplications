// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: task_management_service.proto

package ie.nci.distributedsystems.task_management_service;

/**
 * Protobuf type {@code taskmanagementservice.GetTaskResponse}
 */
public  final class GetTaskResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:taskmanagementservice.GetTaskResponse)
    GetTaskResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetTaskResponse.newBuilder() to construct.
  private GetTaskResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetTaskResponse() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetTaskResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            ie.nci.distributedsystems.task_management_service.Task.Builder subBuilder = null;
            if (task_ != null) {
              subBuilder = task_.toBuilder();
            }
            task_ = input.readMessage(ie.nci.distributedsystems.task_management_service.Task.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(task_);
              task_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ie.nci.distributedsystems.task_management_service.TaskManagement.internal_static_taskmanagementservice_GetTaskResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ie.nci.distributedsystems.task_management_service.TaskManagement.internal_static_taskmanagementservice_GetTaskResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ie.nci.distributedsystems.task_management_service.GetTaskResponse.class, ie.nci.distributedsystems.task_management_service.GetTaskResponse.Builder.class);
  }

  public static final int TASK_FIELD_NUMBER = 1;
  private ie.nci.distributedsystems.task_management_service.Task task_;
  /**
   * <code>.taskmanagementservice.Task task = 1;</code>
   */
  public boolean hasTask() {
    return task_ != null;
  }
  /**
   * <code>.taskmanagementservice.Task task = 1;</code>
   */
  public ie.nci.distributedsystems.task_management_service.Task getTask() {
    return task_ == null ? ie.nci.distributedsystems.task_management_service.Task.getDefaultInstance() : task_;
  }
  /**
   * <code>.taskmanagementservice.Task task = 1;</code>
   */
  public ie.nci.distributedsystems.task_management_service.TaskOrBuilder getTaskOrBuilder() {
    return getTask();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (task_ != null) {
      output.writeMessage(1, getTask());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (task_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getTask());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ie.nci.distributedsystems.task_management_service.GetTaskResponse)) {
      return super.equals(obj);
    }
    ie.nci.distributedsystems.task_management_service.GetTaskResponse other = (ie.nci.distributedsystems.task_management_service.GetTaskResponse) obj;

    boolean result = true;
    result = result && (hasTask() == other.hasTask());
    if (hasTask()) {
      result = result && getTask()
          .equals(other.getTask());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasTask()) {
      hash = (37 * hash) + TASK_FIELD_NUMBER;
      hash = (53 * hash) + getTask().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ie.nci.distributedsystems.task_management_service.GetTaskResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTaskResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTaskResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTaskResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTaskResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTaskResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTaskResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTaskResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTaskResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTaskResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTaskResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTaskResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ie.nci.distributedsystems.task_management_service.GetTaskResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code taskmanagementservice.GetTaskResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:taskmanagementservice.GetTaskResponse)
      ie.nci.distributedsystems.task_management_service.GetTaskResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ie.nci.distributedsystems.task_management_service.TaskManagement.internal_static_taskmanagementservice_GetTaskResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ie.nci.distributedsystems.task_management_service.TaskManagement.internal_static_taskmanagementservice_GetTaskResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ie.nci.distributedsystems.task_management_service.GetTaskResponse.class, ie.nci.distributedsystems.task_management_service.GetTaskResponse.Builder.class);
    }

    // Construct using ie.nci.distributedsystems.task_management_service.GetTaskResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (taskBuilder_ == null) {
        task_ = null;
      } else {
        task_ = null;
        taskBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ie.nci.distributedsystems.task_management_service.TaskManagement.internal_static_taskmanagementservice_GetTaskResponse_descriptor;
    }

    @java.lang.Override
    public ie.nci.distributedsystems.task_management_service.GetTaskResponse getDefaultInstanceForType() {
      return ie.nci.distributedsystems.task_management_service.GetTaskResponse.getDefaultInstance();
    }

    @java.lang.Override
    public ie.nci.distributedsystems.task_management_service.GetTaskResponse build() {
      ie.nci.distributedsystems.task_management_service.GetTaskResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ie.nci.distributedsystems.task_management_service.GetTaskResponse buildPartial() {
      ie.nci.distributedsystems.task_management_service.GetTaskResponse result = new ie.nci.distributedsystems.task_management_service.GetTaskResponse(this);
      if (taskBuilder_ == null) {
        result.task_ = task_;
      } else {
        result.task_ = taskBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ie.nci.distributedsystems.task_management_service.GetTaskResponse) {
        return mergeFrom((ie.nci.distributedsystems.task_management_service.GetTaskResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ie.nci.distributedsystems.task_management_service.GetTaskResponse other) {
      if (other == ie.nci.distributedsystems.task_management_service.GetTaskResponse.getDefaultInstance()) return this;
      if (other.hasTask()) {
        mergeTask(other.getTask());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ie.nci.distributedsystems.task_management_service.GetTaskResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ie.nci.distributedsystems.task_management_service.GetTaskResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private ie.nci.distributedsystems.task_management_service.Task task_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        ie.nci.distributedsystems.task_management_service.Task, ie.nci.distributedsystems.task_management_service.Task.Builder, ie.nci.distributedsystems.task_management_service.TaskOrBuilder> taskBuilder_;
    /**
     * <code>.taskmanagementservice.Task task = 1;</code>
     */
    public boolean hasTask() {
      return taskBuilder_ != null || task_ != null;
    }
    /**
     * <code>.taskmanagementservice.Task task = 1;</code>
     */
    public ie.nci.distributedsystems.task_management_service.Task getTask() {
      if (taskBuilder_ == null) {
        return task_ == null ? ie.nci.distributedsystems.task_management_service.Task.getDefaultInstance() : task_;
      } else {
        return taskBuilder_.getMessage();
      }
    }
    /**
     * <code>.taskmanagementservice.Task task = 1;</code>
     */
    public Builder setTask(ie.nci.distributedsystems.task_management_service.Task value) {
      if (taskBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        task_ = value;
        onChanged();
      } else {
        taskBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.taskmanagementservice.Task task = 1;</code>
     */
    public Builder setTask(
        ie.nci.distributedsystems.task_management_service.Task.Builder builderForValue) {
      if (taskBuilder_ == null) {
        task_ = builderForValue.build();
        onChanged();
      } else {
        taskBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.taskmanagementservice.Task task = 1;</code>
     */
    public Builder mergeTask(ie.nci.distributedsystems.task_management_service.Task value) {
      if (taskBuilder_ == null) {
        if (task_ != null) {
          task_ =
            ie.nci.distributedsystems.task_management_service.Task.newBuilder(task_).mergeFrom(value).buildPartial();
        } else {
          task_ = value;
        }
        onChanged();
      } else {
        taskBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.taskmanagementservice.Task task = 1;</code>
     */
    public Builder clearTask() {
      if (taskBuilder_ == null) {
        task_ = null;
        onChanged();
      } else {
        task_ = null;
        taskBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.taskmanagementservice.Task task = 1;</code>
     */
    public ie.nci.distributedsystems.task_management_service.Task.Builder getTaskBuilder() {
      
      onChanged();
      return getTaskFieldBuilder().getBuilder();
    }
    /**
     * <code>.taskmanagementservice.Task task = 1;</code>
     */
    public ie.nci.distributedsystems.task_management_service.TaskOrBuilder getTaskOrBuilder() {
      if (taskBuilder_ != null) {
        return taskBuilder_.getMessageOrBuilder();
      } else {
        return task_ == null ?
            ie.nci.distributedsystems.task_management_service.Task.getDefaultInstance() : task_;
      }
    }
    /**
     * <code>.taskmanagementservice.Task task = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        ie.nci.distributedsystems.task_management_service.Task, ie.nci.distributedsystems.task_management_service.Task.Builder, ie.nci.distributedsystems.task_management_service.TaskOrBuilder> 
        getTaskFieldBuilder() {
      if (taskBuilder_ == null) {
        taskBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            ie.nci.distributedsystems.task_management_service.Task, ie.nci.distributedsystems.task_management_service.Task.Builder, ie.nci.distributedsystems.task_management_service.TaskOrBuilder>(
                getTask(),
                getParentForChildren(),
                isClean());
        task_ = null;
      }
      return taskBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:taskmanagementservice.GetTaskResponse)
  }

  // @@protoc_insertion_point(class_scope:taskmanagementservice.GetTaskResponse)
  private static final ie.nci.distributedsystems.task_management_service.GetTaskResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ie.nci.distributedsystems.task_management_service.GetTaskResponse();
  }

  public static ie.nci.distributedsystems.task_management_service.GetTaskResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetTaskResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetTaskResponse>() {
    @java.lang.Override
    public GetTaskResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetTaskResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetTaskResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetTaskResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ie.nci.distributedsystems.task_management_service.GetTaskResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
