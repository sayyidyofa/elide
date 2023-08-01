// automatically generated by the FlatBuffers compiler, do not modify

package elide.assets.AssetBundle_

import com.google.flatbuffers.*
import java.nio.*

@Suppress("unused")
class RewriteMap : Table() {

    fun __init(_i: Int, _bb: ByteBuffer) {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer): RewriteMap {
        __init(_i, _bb)
        return this
    }
    val file: String?
        get() {
            val o = __offset(4)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val fileAsByteBuffer: ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun fileInByteBuffer(_bb: ByteBuffer): ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    fun map(
      j: Int,
    ): elide.assets.AssetBundle_.RewriteMap_.MapEntry? = map(elide.assets.AssetBundle_.RewriteMap_.MapEntry(), j)
    fun map(
      obj: elide.assets.AssetBundle_.RewriteMap_.MapEntry,
      j: Int,
    ): elide.assets.AssetBundle_.RewriteMap_.MapEntry? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(__vector(o) + j * 4), bb)
        } else {
            null
        }
    }
    val mapLength: Int
        get() {
            val o = __offset(6)
            return if (o != 0) __vector_len(o) else 0
        }
    fun mapByKey(key: String): elide.assets.AssetBundle_.RewriteMap_.MapEntry? {
        val o = __offset(6)
        return if (o != 0) {
            elide.assets.AssetBundle_.RewriteMap_.MapEntry.__lookup_by_key(null, __vector(o), key, bb)
        } else {
            null
        }
    }
    fun mapByKey(
      obj: elide.assets.AssetBundle_.RewriteMap_.MapEntry,
      key: String,
    ): elide.assets.AssetBundle_.RewriteMap_.MapEntry? {
        val o = __offset(6)
        return if (o != 0) {
            elide.assets.AssetBundle_.RewriteMap_.MapEntry.__lookup_by_key(obj, __vector(o), key, bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsRewriteMap(_bb: ByteBuffer): RewriteMap = getRootAsRewriteMap(_bb, RewriteMap())
        fun getRootAsRewriteMap(_bb: ByteBuffer, obj: RewriteMap): RewriteMap {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createRewriteMap(builder: FlatBufferBuilder, fileOffset: Int, mapOffset: Int): Int {
            builder.startTable(2)
            addMap(builder, mapOffset)
            addFile(builder, fileOffset)
            return endRewriteMap(builder)
        }
        fun startRewriteMap(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addFile(builder: FlatBufferBuilder, file: Int) = builder.addOffset(0, file, 0)
        fun addMap(builder: FlatBufferBuilder, map: Int) = builder.addOffset(1, map, 0)
        fun createMapVector(builder: FlatBufferBuilder, data: IntArray): Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startMapVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun endRewriteMap(builder: FlatBufferBuilder): Int {
            val o = builder.endTable()
            return o
        }
    }
}
