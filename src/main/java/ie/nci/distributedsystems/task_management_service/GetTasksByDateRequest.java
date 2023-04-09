// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: task_management_service.proto

package ie.nci.distributedsystems.task_management_service;

/**
 * Protobuf type {@code taskmanagementservice.GetTasksByDateRequest}
 */
public  final class GetTasksByDateRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:taskmanagementservice.GetTasksByDateRequest)
    GetTasksByDateRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetTasksByDateRequest.newBuilder() to construct.
  private GetTasksByDateRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetTasksByDateRequest() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetTasksByDateRequest(
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
            ie.nci.distributedsystems.task_management_service.Date.Builder subBuilder = null;
            if (date_ != null) {
              subBuilder = date_.toBuilder();
            }
            date_ = input.readMessage(ie.nci.distributedsystems.task_management_service.Date.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(date_);
              date_ = subBuilder.buildPartial();
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
    return ie.nci.distributedsystems.task_management_service.TaskManagement.internal_static_taskmanagementservice_GetTasksByDateRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ie.nci.distributedsystems.task_management_service.TaskManagement.internal_static_taskmanagementservice_GetTasksByDateRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest.class, ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest.Builder.class);
  }

  public static final int DATE_FIELD_NUMBER = 1;
  private ie.nci.distributedsystems.task_management_service.Date date_;
  /**
   * <code>.taskmanagementservice.Date date = 1;</code>
   */
  public boolean hasDate() {
    return date_ != null;
  }
  /**
   * <code>.taskmanagementservice.Date date = 1;</code>
   */
  public ie.nci.distributedsystems.task_management_service.Date getDate() {
    return date_ == null ? ie.nci.distributedsystems.task_management_service.Date.getDefaultInstance() : date_;
  }
  /**
   * <code>.taskmanagementservice.Date date = 1;</code>
   */
  public ie.nci.distributedsystems.task_management_service.DateOrBuilder getDateOrBuilder() {
    return getDate();
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
    if (date_ != null) {
      output.writeMessage(1, getDate());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (date_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getDate());
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
    if (!(obj instanceof ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest)) {
      return super.equals(obj);
    }
    ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest other = (ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest) obj;

    boolean result = true;
    result = result && (hasDate() == other.hasDate());
    if (hasDate()) {
      result = result && getDate()
          .equals(other.getDate());
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
    if (hasDate()) {
      hash = (37 * hash) + DATE_FIELD_NUMBER;
      hash = (53 * hash) + getDate().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest parseFrom(
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
  public static Builder newBuilder(ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest prototype) {
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
   * Protobuf type {@code taskmanagementservice.GetTasksByDateRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:taskmanagementservice.GetTasksByDateRequest)
      ie.nci.distributedsystems.task_management_service.GetTasksByDateRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ie.nci.distributedsystems.task_management_service.TaskManagement.internal_static_taskmanagementservice_GetTasksByDateRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ie.nci.distributedsystems.task_management_service.TaskManagement.internal_static_taskmanagementservice_GetTasksByDateRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest.class, ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest.Builder.class);
    }

    // Construct using ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest.newBuilder()
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
      if (dateBuilder_ == null) {
        date_ = null;
      } else {
        date_ = null;
        dateBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ie.nci.distributedsystems.task_management_service.TaskManagement.internal_static_taskmanagementservice_GetTasksByDateRequest_descriptor;
    }

    @java.lang.Override
    public ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest getDefaultInstanceForType() {
      return ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest.getDefaultInstance();
    }

    @java.lang.Override
    public ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest build() {
      ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest buildPartial() {
      ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest result = new ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest(this);
      if (dateBuilder_ == null) {
        result.date_ = date_;
      } else {
        result.date_ = dateBuilder_.build();
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
      if (other instanceof ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest) {
        return mergeFrom((ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest other) {
      if (other == ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest.getDefaultInstance()) return this;
      if (other.hasDate()) {
        mergeDate(other.getDate());
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
      ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private ie.nci.distributedsystems.task_management_service.Date date_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        ie.nci.distributedsystems.task_management_service.Date, ie.nci.distributedsystems.task_management_service.Date.Builder, ie.nci.distributedsystems.task_management_service.DateOrBuilder> dateBuilder_;
    /**
     * <code>.taskmanagementservice.Date date = 1;</code>
     */
    public boolean hasDate() {
      return dateBuilder_ != null || date_ != null;
    }
    /**
     * <code>.taskmanagementservice.Date date = 1;</code>
     */
    public ie.nci.distributedsystems.task_management_service.Date getDate() {
      if (dateBuilder_ == null) {
        return date_ == null ? ie.nci.distributedsystems.task_management_service.Date.getDefaultInstance() : date_;
      } else {
        return dateBuilder_.getMessage();
      }
    }
    /**
     * <code>.taskmanagementservice.Date date = 1;</code>
     */
    public Builder setDate(ie.nci.distributedsystems.task_management_service.Date value) {
      if (dateBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        date_ = value;
        onChanged();
      } else {
        dateBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.taskmanagementservice.Date date = 1;</code>
     */
    public Builder setDate(
        ie.nci.distributedsystems.task_management_service.Date.Builder builderForValue) {
      if (dateBuilder_ == null) {
        date_ = builderForValue.build();
        onChanged();
      } else {
        dateBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.taskmanagementservice.Date date = 1;</code>
     */
    public Builder mergeDate(ie.nci.distributedsystems.task_management_service.Date value) {
      if (dateBuilder_ == null) {
        if (date_ != null) {
          date_ =
            ie.nci.distributedsystems.task_management_service.Date.newBuilder(date_).mergeFrom(value).buildPartial();
        } else {
          date_ = value;
        }
        onChanged();
      } else {
        dateBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.taskmanagementservice.Date date = 1;</code>
     */
    public Builder clearDate() {
      if (dateBuilder_ == null) {
        date_ = null;
        onChanged();
      } else {
        date_ = null;
        dateBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.taskmanagementservice.Date date = 1;</code>
     */
    public ie.nci.distributedsystems.task_management_service.Date.Builder getDateBuilder() {
      
      onChanged();
      return getDateFieldBuilder().getBuilder();
    }
    /**
     * <code>.taskmanagementservice.Date date = 1;</code>
     */
    public ie.nci.distributedsystems.task_management_service.DateOrBuilder getDateOrBuilder() {
      if (dateBuilder_ != null) {
        return dateBuilder_.getMessageOrBuilder();
      } else {
        return date_ == null ?
            ie.nci.distributedsystems.task_management_service.Date.getDefaultInstance() : date_;
      }
    }
    /**
     * <code>.taskmanagementservice.Date date = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        ie.nci.distributedsystems.task_management_service.Date, ie.nci.distributedsystems.task_management_service.Date.Builder, ie.nci.distributedsystems.task_management_service.DateOrBuilder> 
        getDateFieldBuilder() {
      if (dateBuilder_ == null) {
        dateBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            ie.nci.distributedsystems.task_management_service.Date, ie.nci.distributedsystems.task_management_service.Date.Builder, ie.nci.distributedsystems.task_management_service.DateOrBuilder>(
                getDate(),
                getParentForChildren(),
                isClean());
        date_ = null;
      }
      return dateBuilder_;
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


    // @@protoc_insertion_point(builder_scope:taskmanagementservice.GetTasksByDateRequest)
  }

  // @@protoc_insertion_point(class_scope:taskmanagementservice.GetTasksByDateRequest)
  private static final ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest();
  }

  public static ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetTasksByDateRequest>
      PARSER = new com.google.protobuf.AbstractParser<GetTasksByDateRequest>() {
    @java.lang.Override
    public GetTasksByDateRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetTasksByDateRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetTasksByDateRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetTasksByDateRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ie.nci.distributedsystems.task_management_service.GetTasksByDateRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

