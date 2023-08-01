// automatically generated by the FlatBuffers compiler, do not modify

package elide.vfs.File_.Fingerprint_

import com.google.flatbuffers.*
import java.nio.*

@Suppress("unused")
class FileFingerprint : Table() {

    fun __init(_i: Int, _bb: ByteBuffer) {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer): FileFingerprint {
        __init(_i, _bb)
        return this
    }
    fun crc32(j: Int): UByte {
        val o = __offset(4)
        return if (o != 0) {
            bb.get(__vector(o) + j * 1).toUByte()
        } else {
            0u
        }
    }
    val crc32Length: Int
        get() {
            val o = __offset(4)
            return if (o != 0) __vector_len(o) else 0
        }
    val crc32AsByteBuffer: ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun crc32InByteBuffer(_bb: ByteBuffer): ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    fun hash(j: Int): UByte {
        val o = __offset(6)
        return if (o != 0) {
            bb.get(__vector(o) + j * 1).toUByte()
        } else {
            0u
        }
    }
    val hashLength: Int
        get() {
            val o = __offset(6)
            return if (o != 0) __vector_len(o) else 0
        }
    val hashAsByteBuffer: ByteBuffer get() = __vector_as_bytebuffer(6, 1)
    fun hashInByteBuffer(_bb: ByteBuffer): ByteBuffer = __vector_in_bytebuffer(_bb, 6, 1)
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsFileFingerprint(
          _bb: ByteBuffer,
        ): FileFingerprint = getRootAsFileFingerprint(_bb, FileFingerprint())
        fun getRootAsFileFingerprint(_bb: ByteBuffer, obj: FileFingerprint): FileFingerprint {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createFileFingerprint(builder: FlatBufferBuilder, crc32Offset: Int, hashOffset: Int): Int {
            builder.startTable(2)
            addHash(builder, hashOffset)
            addCrc32(builder, crc32Offset)
            return endFileFingerprint(builder)
        }
        fun startFileFingerprint(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addCrc32(builder: FlatBufferBuilder, crc32: Int) = builder.addOffset(0, crc32, 0)
        fun createCrc32Vector(builder: FlatBufferBuilder, data: UByteArray): Int {
            builder.startVector(1, data.size, 1)
            for (i in data.size - 1 downTo 0) {
                builder.addByte(data[i].toByte())
            }
            return builder.endVector()
        }
        fun startCrc32Vector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(1, numElems, 1)
        fun addHash(builder: FlatBufferBuilder, hash: Int) = builder.addOffset(1, hash, 0)
        fun createHashVector(builder: FlatBufferBuilder, data: UByteArray): Int {
            builder.startVector(1, data.size, 1)
            for (i in data.size - 1 downTo 0) {
                builder.addByte(data[i].toByte())
            }
            return builder.endVector()
        }
        fun startHashVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(1, numElems, 1)
        fun endFileFingerprint(builder: FlatBufferBuilder): Int {
            val o = builder.endTable()
            return o
        }
    }
}
