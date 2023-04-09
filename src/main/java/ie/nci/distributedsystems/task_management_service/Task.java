// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: task.management_service.proto

package ie.nci.distributedsystems.task_management_service;

/**
 * Protobuf type {@code taskmanagementservice.Task}
 */
public  final class Task extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:taskmanagementservice.Task)
    TaskOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Task.newBuilder() to construct.
  private Task(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Task() {
    id_ = "";
    name_ = "";
    description_ = "";
    assignedUser_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Task(
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
            java.lang.String s = input.readStringRequireUtf8();

            id_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            description_ = s;
            break;
          }
          case 34: {
            com.google.protobuf.Timestamp.Builder subBuilder = null;
            if (dueDate_ != null) {
              subBuilder = dueDate_.toBuilder();
            }
            dueDate_ = input.readMessage(com.google.protobuf.Timestamp.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(dueDate_);
              dueDate_ = subBuilder.buildPartial();
            }

            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            assignedUser_ = s;
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
    return ie.nci.distributedsystems.task_management_service.TaskManagement.internal_static_taskmanagementservice_Task_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ie.nci.distributedsystems.task_management_service.TaskManagement.internal_static_taskmanagementservice_Task_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ie.nci.distributedsystems.task_management_service.Task.class, ie.nci.distributedsystems.task_management_service.Task.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object id_;
  /**
   * <code>string id = 1;</code>
   */
  public java.lang.String getId() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      id_ = s;
      return s;
    }
  }
  /**
   * <code>string id = 1;</code>
   */
  public com.google.protobuf.ByteString
      getIdBytes() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      id_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object name_;
  /**
   * <code>string name = 2;</code>
   */
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 2;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DESCRIPTION_FIELD_NUMBER = 3;
  private volatile java.lang.Object description_;
  /**
   * <code>string description = 3;</code>
   */
  public java.lang.String getDescription() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      description_ = s;
      return s;
    }
  }
  /**
   * <code>string description = 3;</code>
   */
  public com.google.protobuf.ByteString
      getDescriptionBytes() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      description_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DUE_DATE_FIELD_NUMBER = 4;
  private com.google.protobuf.Timestamp dueDate_;
  /**
   * <code>.google.protobuf.Timestamp due_date = 4;</code>
   */
  public boolean hasDueDate() {
    return dueDate_ != null;
  }
  /**
   * <code>.google.protobuf.Timestamp due_date = 4;</code>
   */
  public com.google.protobuf.Timestamp getDueDate() {
    return dueDate_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : dueDate_;
  }
  /**
   * <code>.google.protobuf.Timestamp due_date = 4;</code>
   */
  public com.google.protobuf.TimestampOrBuilder getDueDateOrBuilder() {
    return getDueDate();
  }

  public static final int ASSIGNED_USER_FIELD_NUMBER = 5;
  private volatile java.lang.Object assignedUser_;
  /**
   * <code>string assigned_user = 5;</code>
   */
  public java.lang.String getAssignedUser() {
    java.lang.Object ref = assignedUser_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      assignedUser_ = s;
      return s;
    }
  }
  /**
   * <code>string assigned_user = 5;</code>
   */
  public com.google.protobuf.ByteString
      getAssignedUserBytes() {
    java.lang.Object ref = assignedUser_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      assignedUser_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
    }
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, name_);
    }
    if (!getDescriptionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, description_);
    }
    if (dueDate_ != null) {
      output.writeMessage(4, getDueDate());
    }
    if (!getAssignedUserBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, assignedUser_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
    }
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, name_);
    }
    if (!getDescriptionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, description_);
    }
    if (dueDate_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getDueDate());
    }
    if (!getAssignedUserBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, assignedUser_);
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
    if (!(obj instanceof ie.nci.distributedsystems.task_management_service.Task)) {
      return super.equals(obj);
    }
    ie.nci.distributedsystems.task_management_service.Task other = (ie.nci.distributedsystems.task_management_service.Task) obj;

    boolean result = true;
    result = result && getId()
        .equals(other.getId());
    result = result && getName()
        .equals(other.getName());
    result = result && getDescription()
        .equals(other.getDescription());
    result = result && (hasDueDate() == other.hasDueDate());
    if (hasDueDate()) {
      result = result && getDueDate()
          .equals(other.getDueDate());
    }
    result = result && getAssignedUser()
        .equals(other.getAssignedUser());
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
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId().hashCode();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
    hash = (53 * hash) + getDescription().hashCode();
    if (hasDueDate()) {
      hash = (37 * hash) + DUE_DATE_FIELD_NUMBER;
      hash = (53 * hash) + getDueDate().hashCode();
    }
    hash = (37 * hash) + ASSIGNED_USER_FIELD_NUMBER;
    hash = (53 * hash) + getAssignedUser().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ie.nci.distributedsystems.task_management_service.Task parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.nci.distributedsystems.task_management_service.Task parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.nci.distributedsystems.task_management_service.Task parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.nci.distributedsystems.task_management_service.Task parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.nci.distributedsystems.task_management_service.Task parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.nci.distributedsystems.task_management_service.Task parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.nci.distributedsystems.task_management_service.Task parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ie.nci.distributedsystems.task_management_service.Task parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ie.nci.distributedsystems.task_management_service.Task parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ie.nci.distributedsystems.task_management_service.Task parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ie.nci.distributedsystems.task_management_service.Task parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ie.nci.distributedsystems.task_management_service.Task parseFrom(
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
  public static Builder newBuilder(ie.nci.distributedsystems.task_management_service.Task prototype) {
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
   * Protobuf type {@code taskmanagementservice.Task}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:taskmanagementservice.Task)
      ie.nci.distributedsystems.task_management_service.TaskOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ie.nci.distributedsystems.task_management_service.TaskManagement.internal_static_taskmanagementservice_Task_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ie.nci.distributedsystems.task_management_service.TaskManagement.internal_static_taskmanagementservice_Task_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ie.nci.distributedsystems.task_management_service.Task.class, ie.nci.distributedsystems.task_management_service.Task.Builder.class);
    }

    // Construct using ie.nci.distributedsystems.task_management_service.Task.newBuilder()
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
      id_ = "";

      name_ = "";

      description_ = "";

      if (dueDateBuilder_ == null) {
        dueDate_ = null;
      } else {
        dueDate_ = null;
        dueDateBuilder_ = null;
      }
      assignedUser_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ie.nci.distributedsystems.task_management_service.TaskManagement.internal_static_taskmanagementservice_Task_descriptor;
    }

    @java.lang.Override
    public ie.nci.distributedsystems.task_management_service.Task getDefaultInstanceForType() {
      return ie.nci.distributedsystems.task_management_service.Task.getDefaultInstance();
    }

    @java.lang.Override
    public ie.nci.distributedsystems.task_management_service.Task build() {
      ie.nci.distributedsystems.task_management_service.Task result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ie.nci.distributedsystems.task_management_service.Task buildPartial() {
      ie.nci.distributedsystems.task_management_service.Task result = new ie.nci.distributedsystems.task_management_service.Task(this);
      result.id_ = id_;
      result.name_ = name_;
      result.description_ = description_;
      if (dueDateBuilder_ == null) {
        result.dueDate_ = dueDate_;
      } else {
        result.dueDate_ = dueDateBuilder_.build();
      }
      result.assignedUser_ = assignedUser_;
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
      if (other instanceof ie.nci.distributedsystems.task_management_service.Task) {
        return mergeFrom((ie.nci.distributedsystems.task_management_service.Task)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ie.nci.distributedsystems.task_management_service.Task other) {
      if (other == ie.nci.distributedsystems.task_management_service.Task.getDefaultInstance()) return this;
      if (!other.getId().isEmpty()) {
        id_ = other.id_;
        onChanged();
      }
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (!other.getDescription().isEmpty()) {
        description_ = other.description_;
        onChanged();
      }
      if (other.hasDueDate()) {
        mergeDueDate(other.getDueDate());
      }
      if (!other.getAssignedUser().isEmpty()) {
        assignedUser_ = other.assignedUser_;
        onChanged();
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
      ie.nci.distributedsystems.task_management_service.Task parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ie.nci.distributedsystems.task_management_service.Task) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object id_ = "";
    /**
     * <code>string id = 1;</code>
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        id_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string id = 1;</code>
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string id = 1;</code>
     */
    public Builder setId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
     */
    public Builder clearId() {
      
      id_ = getDefaultInstance().getId();
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
     */
    public Builder setIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      id_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object name_ = "";
    /**
     * <code>string name = 2;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string name = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 2;</code>
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 2;</code>
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>string name = 2;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object description_ = "";
    /**
     * <code>string description = 3;</code>
     */
    public java.lang.String getDescription() {
      java.lang.Object ref = description_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        description_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string description = 3;</code>
     */
    public com.google.protobuf.ByteString
        getDescriptionBytes() {
      java.lang.Object ref = description_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        description_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string description = 3;</code>
     */
    public Builder setDescription(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      description_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string description = 3;</code>
     */
    public Builder clearDescription() {
      
      description_ = getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    /**
     * <code>string description = 3;</code>
     */
    public Builder setDescriptionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      description_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.Timestamp dueDate_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> dueDateBuilder_;
    /**
     * <code>.google.protobuf.Timestamp due_date = 4;</code>
     */
    public boolean hasDueDate() {
      return dueDateBuilder_ != null || dueDate_ != null;
    }
    /**
     * <code>.google.protobuf.Timestamp due_date = 4;</code>
     */
    public com.google.protobuf.Timestamp getDueDate() {
      if (dueDateBuilder_ == null) {
        return dueDate_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : dueDate_;
      } else {
        return dueDateBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Timestamp due_date = 4;</code>
     */
    public Builder setDueDate(com.google.protobuf.Timestamp value) {
      if (dueDateBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        dueDate_ = value;
        onChanged();
      } else {
        dueDateBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp due_date = 4;</code>
     */
    public Builder setDueDate(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (dueDateBuilder_ == null) {
        dueDate_ = builderForValue.build();
        onChanged();
      } else {
        dueDateBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp due_date = 4;</code>
     */
    public Builder mergeDueDate(com.google.protobuf.Timestamp value) {
      if (dueDateBuilder_ == null) {
        if (dueDate_ != null) {
          dueDate_ =
            com.google.protobuf.Timestamp.newBuilder(dueDate_).mergeFrom(value).buildPartial();
        } else {
          dueDate_ = value;
        }
        onChanged();
      } else {
        dueDateBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp due_date = 4;</code>
     */
    public Builder clearDueDate() {
      if (dueDateBuilder_ == null) {
        dueDate_ = null;
        onChanged();
      } else {
        dueDate_ = null;
        dueDateBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp due_date = 4;</code>
     */
    public com.google.protobuf.Timestamp.Builder getDueDateBuilder() {
      
      onChanged();
      return getDueDateFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Timestamp due_date = 4;</code>
     */
    public com.google.protobuf.TimestampOrBuilder getDueDateOrBuilder() {
      if (dueDateBuilder_ != null) {
        return dueDateBuilder_.getMessageOrBuilder();
      } else {
        return dueDate_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : dueDate_;
      }
    }
    /**
     * <code>.google.protobuf.Timestamp due_date = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
        getDueDateFieldBuilder() {
      if (dueDateBuilder_ == null) {
        dueDateBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getDueDate(),
                getParentForChildren(),
                isClean());
        dueDate_ = null;
      }
      return dueDateBuilder_;
    }

    private java.lang.Object assignedUser_ = "";
    /**
     * <code>string assigned_user = 5;</code>
     */
    public java.lang.String getAssignedUser() {
      java.lang.Object ref = assignedUser_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        assignedUser_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string assigned_user = 5;</code>
     */
    public com.google.protobuf.ByteString
        getAssignedUserBytes() {
      java.lang.Object ref = assignedUser_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        assignedUser_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string assigned_user = 5;</code>
     */
    public Builder setAssignedUser(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      assignedUser_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string assigned_user = 5;</code>
     */
    public Builder clearAssignedUser() {
      
      assignedUser_ = getDefaultInstance().getAssignedUser();
      onChanged();
      return this;
    }
    /**
     * <code>string assigned_user = 5;</code>
     */
    public Builder setAssignedUserBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      assignedUser_ = value;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:taskmanagementservice.Task)
  }

  // @@protoc_insertion_point(class_scope:taskmanagementservice.Task)
  private static final ie.nci.distributedsystems.task_management_service.Task DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ie.nci.distributedsystems.task_management_service.Task();
  }

  public static ie.nci.distributedsystems.task_management_service.Task getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Task>
      PARSER = new com.google.protobuf.AbstractParser<Task>() {
    @java.lang.Override
    public Task parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Task(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Task> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Task> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ie.nci.distributedsystems.task_management_service.Task getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

