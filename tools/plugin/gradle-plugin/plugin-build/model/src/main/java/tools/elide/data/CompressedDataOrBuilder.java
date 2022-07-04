// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: elide/data/data.proto

package tools.elide.data;

public interface CompressedDataOrBuilder extends
    // @@protoc_insertion_point(interface_extends:data.CompressedData)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Compression mode applied to this data. If no compression is active, `IDENTITY` may be specified as a default.
   * </pre>
   *
   * <code>.data.CompressionMode compression = 1;</code>
   * @return The enum numeric value on the wire for compression.
   */
  int getCompressionValue();
  /**
   * <pre>
   * Compression mode applied to this data. If no compression is active, `IDENTITY` may be specified as a default.
   * </pre>
   *
   * <code>.data.CompressionMode compression = 1;</code>
   * @return The compression.
   */
  tools.elide.data.CompressionMode getCompression();

  /**
   * <pre>
   * Container holding the raw compressed data, and a fingerprint of the data in compressed form. This is unmodified raw
   * bytes, aside from being compressed by the algorithm specified by `compression`.
   * </pre>
   *
   * <code>.data.DataContainer data = 2;</code>
   * @return Whether the data field is set.
   */
  boolean hasData();
  /**
   * <pre>
   * Container holding the raw compressed data, and a fingerprint of the data in compressed form. This is unmodified raw
   * bytes, aside from being compressed by the algorithm specified by `compression`.
   * </pre>
   *
   * <code>.data.DataContainer data = 2;</code>
   * @return The data.
   */
  tools.elide.data.DataContainer getData();
  /**
   * <pre>
   * Container holding the raw compressed data, and a fingerprint of the data in compressed form. This is unmodified raw
   * bytes, aside from being compressed by the algorithm specified by `compression`.
   * </pre>
   *
   * <code>.data.DataContainer data = 2;</code>
   */
  tools.elide.data.DataContainerOrBuilder getDataOrBuilder();

  /**
   * <pre>
   * Size of the asset data before compression. To obtain the size of the data in compressed form, simply take the
   * length of the data field itself. This value is expressed in bytes.
   * </pre>
   *
   * <code>uint64 size = 3;</code>
   * @return The size.
   */
  long getSize();

  /**
   * <pre>
   * Holds an (optional) integrity fingerprint, calculated from the held data *before* compression, which maybe used to
   * verify the consistency of the data held by this container after de-compression.
   * </pre>
   *
   * <code>repeated .data.DataFingerprint integrity = 4;</code>
   */
  java.util.List<tools.elide.data.DataFingerprint> 
      getIntegrityList();
  /**
   * <pre>
   * Holds an (optional) integrity fingerprint, calculated from the held data *before* compression, which maybe used to
   * verify the consistency of the data held by this container after de-compression.
   * </pre>
   *
   * <code>repeated .data.DataFingerprint integrity = 4;</code>
   */
  tools.elide.data.DataFingerprint getIntegrity(int index);
  /**
   * <pre>
   * Holds an (optional) integrity fingerprint, calculated from the held data *before* compression, which maybe used to
   * verify the consistency of the data held by this container after de-compression.
   * </pre>
   *
   * <code>repeated .data.DataFingerprint integrity = 4;</code>
   */
  int getIntegrityCount();
  /**
   * <pre>
   * Holds an (optional) integrity fingerprint, calculated from the held data *before* compression, which maybe used to
   * verify the consistency of the data held by this container after de-compression.
   * </pre>
   *
   * <code>repeated .data.DataFingerprint integrity = 4;</code>
   */
  java.util.List<? extends tools.elide.data.DataFingerprintOrBuilder> 
      getIntegrityOrBuilderList();
  /**
   * <pre>
   * Holds an (optional) integrity fingerprint, calculated from the held data *before* compression, which maybe used to
   * verify the consistency of the data held by this container after de-compression.
   * </pre>
   *
   * <code>repeated .data.DataFingerprint integrity = 4;</code>
   */
  tools.elide.data.DataFingerprintOrBuilder getIntegrityOrBuilder(
      int index);
}
