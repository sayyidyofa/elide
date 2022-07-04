// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: elide/data/data.proto

package tools.elide.data;

public final class Data {
  private Data() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_data_DataFingerprint_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_data_DataFingerprint_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_data_DataContainer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_data_DataContainer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_data_CompressedData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_data_CompressedData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025elide/data/data.proto\022\004data\032\031elide/cry" +
      "pto/crypto.proto\"Y\n\017DataFingerprint\022#\n\004h" +
      "ash\030\001 \001(\0162\025.crypto.HashAlgorithm\022\014\n\004salt" +
      "\030\002 \001(\014\022\023\n\013fingerprint\030\003 \001(\014\"F\n\rDataConta" +
      "iner\022\013\n\003raw\030\001 \001(\014\022(\n\tintegrity\030\002 \003(\0132\025.d" +
      "ata.DataFingerprint\"\227\001\n\016CompressedData\022*" +
      "\n\013compression\030\001 \001(\0162\025.data.CompressionMo" +
      "de\022!\n\004data\030\002 \001(\0132\023.data.DataContainer\022\014\n" +
      "\004size\030\003 \001(\004\022(\n\tintegrity\030\004 \003(\0132\025.data.Da" +
      "taFingerprint*5\n\017CompressionMode\022\014\n\010IDEN" +
      "TITY\020\000\022\010\n\004GZIP\020\001\022\n\n\006BROTLI\020\002B\200\001\n\020tools.e" +
      "lide.dataH\001P\001Z&github.com/elide-tools/el" +
      "ide/data;data\330\001\001\370\001\001\242\002\003ELD\252\002\nElide.Data\272\002" +
      "\005Elide\302\002\003ELD\312\002\nElide\\Data\352\002\013Elide::Datab" +
      "\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          tools.elide.crypto.Crypto.getDescriptor(),
        });
    internal_static_data_DataFingerprint_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_data_DataFingerprint_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_data_DataFingerprint_descriptor,
        new java.lang.String[] { "Hash", "Salt", "Fingerprint", });
    internal_static_data_DataContainer_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_data_DataContainer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_data_DataContainer_descriptor,
        new java.lang.String[] { "Raw", "Integrity", });
    internal_static_data_CompressedData_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_data_CompressedData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_data_CompressedData_descriptor,
        new java.lang.String[] { "Compression", "Data", "Size", "Integrity", });
    tools.elide.crypto.Crypto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
