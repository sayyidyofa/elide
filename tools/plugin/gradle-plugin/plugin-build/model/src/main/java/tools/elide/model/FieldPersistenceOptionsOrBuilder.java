// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: elide/model/model.proto

package tools.elide.model;

public interface FieldPersistenceOptionsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:model.FieldPersistenceOptions)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Field type, for special-case fields.
   * </pre>
   *
   * <code>.model.FieldType type = 1;</code>
   * @return The enum numeric value on the wire for type.
   */
  int getTypeValue();
  /**
   * <pre>
   * Field type, for special-case fields.
   * </pre>
   *
   * <code>.model.FieldType type = 1;</code>
   * @return The type.
   */
  tools.elide.model.FieldType getType();

  /**
   * <pre>
   * Summary for this field, which provides a narrative description. It should be suitable for use in external
   * circumstances, like documentation.
   * </pre>
   *
   * <code>string summary = 2;</code>
   * @return The summary.
   */
  java.lang.String getSummary();
  /**
   * <pre>
   * Summary for this field, which provides a narrative description. It should be suitable for use in external
   * circumstances, like documentation.
   * </pre>
   *
   * <code>string summary = 2;</code>
   * @return The bytes for summary.
   */
  com.google.protobuf.ByteString
      getSummaryBytes();

  /**
   * <pre>
   * This item is a timestamp, and we would like it to be automatically updated each time the model that contains it is
   * modified in underlying storage. The field should be read-only.
   * </pre>
   *
   * <code>bool stamp_update = 3;</code>
   * @return The stampUpdate.
   */
  boolean getStampUpdate();

  /**
   * <pre>
   * This item is a timestamp, and we would like it to be automatically set when the model is created. After that point,
   * we would like this field to be read-only.
   * </pre>
   *
   * <code>bool stamp_create = 4;</code>
   * @return The stampCreate.
   */
  boolean getStampCreate();

  /**
   * <pre>
   * This field should not allow writes, but rather produce its value dynamically. Fields marked in this manner cannot
   * be set by external code at any point in time.
   * </pre>
   *
   * <code>bool read_only = 5;</code>
   * @return The readOnly.
   */
  boolean getReadOnly();

  /**
   * <pre>
   * This field should allow writes when the model that contains it is written, but then, henceforth, the model should
   * not allow this field to be mutated.
   * </pre>
   *
   * <code>bool immutable = 6;</code>
   * @return The immutable.
   */
  boolean getImmutable();

  /**
   * <pre>
   * This field should always be explicitly listed with a value, even if it is set to the default value. This function
   * is especially useful for enums with default values, when there is a desire to have consistent indexes.
   * </pre>
   *
   * <code>bool explicit = 7;</code>
   * @return The explicit.
   */
  boolean getExplicit();

  /**
   * <pre>
   * Describes the visibility level of a given field in a tree of fields. This value applies recursively under message
   * fields on which it is applied. Depending on the visibility level active when data is deserialized or serialized,
   * certain data may be withheld corresponding to the invoking user or system's access level.
   * </pre>
   *
   * <code>.model.FieldVisibility visibility = 8;</code>
   * @return The enum numeric value on the wire for visibility.
   */
  int getVisibilityValue();
  /**
   * <pre>
   * Describes the visibility level of a given field in a tree of fields. This value applies recursively under message
   * fields on which it is applied. Depending on the visibility level active when data is deserialized or serialized,
   * certain data may be withheld corresponding to the invoking user or system's access level.
   * </pre>
   *
   * <code>.model.FieldVisibility visibility = 8;</code>
   * @return The visibility.
   */
  tools.elide.model.FieldVisibility getVisibility();

  /**
   * <pre>
   * Provided for backwards compatibility. Do not use.
   * </pre>
   *
   * <code>string description = 9 [deprecated = true];</code>
   * @deprecated model.FieldPersistenceOptions.description is deprecated.
   *     See elide/model/model.proto;l=256
   * @return The description.
   */
  @java.lang.Deprecated java.lang.String getDescription();
  /**
   * <pre>
   * Provided for backwards compatibility. Do not use.
   * </pre>
   *
   * <code>string description = 9 [deprecated = true];</code>
   * @deprecated model.FieldPersistenceOptions.description is deprecated.
   *     See elide/model/model.proto;l=256
   * @return The bytes for description.
   */
  @java.lang.Deprecated com.google.protobuf.ByteString
      getDescriptionBytes();
}
