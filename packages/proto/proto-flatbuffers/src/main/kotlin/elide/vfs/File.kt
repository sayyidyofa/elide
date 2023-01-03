// automatically generated by the FlatBuffers compiler, do not modify

package elide.vfs

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class File : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : File {
        __init(_i, _bb)
        return this
    }
    val name : String?
        get() {
            val o = __offset(4)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val nameAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun nameInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    val size : ULong
        get() {
            val o = __offset(6)
            return if(o != 0) bb.getLong(o + bb_pos).toULong() else 0UL
        }
    val compressed : ULong
        get() {
            val o = __offset(8)
            return if(o != 0) bb.getLong(o + bb_pos).toULong() else 0UL
        }
    val offset : ULong
        get() {
            val o = __offset(10)
            return if(o != 0) bb.getLong(o + bb_pos).toULong() else 0UL
        }
    val tail : ULong
        get() {
            val o = __offset(12)
            return if(o != 0) bb.getLong(o + bb_pos).toULong() else 0UL
        }
    val encoding : Int
        get() {
            val o = __offset(14)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    val modified : google.protobuf.Timestamp? get() = modified(google.protobuf.Timestamp())
    fun modified(obj: google.protobuf.Timestamp) : google.protobuf.Timestamp? {
        val o = __offset(16)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val fileType : elide.vfs.File_.FileTypeSpec? get() = fileType(elide.vfs.File_.FileTypeSpec())
    fun fileType(obj: elide.vfs.File_.FileTypeSpec) : elide.vfs.File_.FileTypeSpec? {
        val o = __offset(18)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val fingerprint : elide.vfs.File_.FileFingerprint? get() = fingerprint(elide.vfs.File_.FileFingerprint())
    fun fingerprint(obj: elide.vfs.File_.FileFingerprint) : elide.vfs.File_.FileFingerprint? {
        val o = __offset(20)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    fun attributes(j: Int) : elide.vfs.File_.AttributesEntry? = attributes(elide.vfs.File_.AttributesEntry(), j)
    fun attributes(obj: elide.vfs.File_.AttributesEntry, j: Int) : elide.vfs.File_.AttributesEntry? {
        val o = __offset(22)
        return if (o != 0) {
            obj.__assign(__indirect(__vector(o) + j * 4), bb)
        } else {
            null
        }
    }
    val attributesLength : Int
        get() {
            val o = __offset(22); return if (o != 0) __vector_len(o) else 0
        }
    fun attributesByKey(key: String) : elide.vfs.File_.AttributesEntry? {
        val o = __offset(22)
        return if (o != 0) {
            elide.vfs.File_.AttributesEntry.__lookup_by_key(null, __vector(o), key, bb)
        } else {
            null
        }
    }
    fun attributesByKey(obj: elide.vfs.File_.AttributesEntry, key: String) : elide.vfs.File_.AttributesEntry? {
        val o = __offset(22)
        return if (o != 0) {
            elide.vfs.File_.AttributesEntry.__lookup_by_key(obj, __vector(o), key, bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsFile(_bb: ByteBuffer): File = getRootAsFile(_bb, File())
        fun getRootAsFile(_bb: ByteBuffer, obj: File): File {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createFile(builder: FlatBufferBuilder, nameOffset: Int, size: ULong, compressed: ULong, offset: ULong, tail: ULong, encoding: Int, modifiedOffset: Int, fileTypeOffset: Int, fingerprintOffset: Int, attributesOffset: Int) : Int {
            builder.startTable(10)
            addTail(builder, tail)
            addOffset(builder, offset)
            addCompressed(builder, compressed)
            addSize(builder, size)
            addAttributes(builder, attributesOffset)
            addFingerprint(builder, fingerprintOffset)
            addFileType(builder, fileTypeOffset)
            addModified(builder, modifiedOffset)
            addEncoding(builder, encoding)
            addName(builder, nameOffset)
            return endFile(builder)
        }
        fun startFile(builder: FlatBufferBuilder) = builder.startTable(10)
        fun addName(builder: FlatBufferBuilder, name: Int) = builder.addOffset(0, name, 0)
        fun addSize(builder: FlatBufferBuilder, size: ULong) = builder.addLong(1, size.toLong(), 0)
        fun addCompressed(builder: FlatBufferBuilder, compressed: ULong) = builder.addLong(2, compressed.toLong(), 0)
        fun addOffset(builder: FlatBufferBuilder, offset: ULong) = builder.addLong(3, offset.toLong(), 0)
        fun addTail(builder: FlatBufferBuilder, tail: ULong) = builder.addLong(4, tail.toLong(), 0)
        fun addEncoding(builder: FlatBufferBuilder, encoding: Int) = builder.addInt(5, encoding, 0)
        fun addModified(builder: FlatBufferBuilder, modified: Int) = builder.addOffset(6, modified, 0)
        fun addFileType(builder: FlatBufferBuilder, fileType: Int) = builder.addOffset(7, fileType, 0)
        fun addFingerprint(builder: FlatBufferBuilder, fingerprint: Int) = builder.addOffset(8, fingerprint, 0)
        fun addAttributes(builder: FlatBufferBuilder, attributes: Int) = builder.addOffset(9, attributes, 0)
        fun createAttributesVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startAttributesVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun endFile(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
