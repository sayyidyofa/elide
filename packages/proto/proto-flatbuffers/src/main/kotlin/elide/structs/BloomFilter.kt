// automatically generated by the FlatBuffers compiler, do not modify

package elide.structs

import com.google.flatbuffers.*
import java.nio.*

@Suppress("unused")
class BloomFilter : Table() {

    fun __init(_i: Int, _bb: ByteBuffer) {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer): BloomFilter {
        __init(_i, _bb)
        return this
    }
    val algorithm: Int
        get() {
            val o = __offset(4)
            return if (o != 0) bb.getInt(o + bb_pos) else 0
        }
    val rounds: UInt
        get() {
            val o = __offset(6)
            return if (o != 0) bb.getInt(o + bb_pos).toUInt() else 0u
        }
    val count: ULong
        get() {
            val o = __offset(8)
            return if (o != 0) bb.getLong(o + bb_pos).toULong() else 0UL
        }
    val limit: ULong
        get() {
            val o = __offset(10)
            return if (o != 0) bb.getLong(o + bb_pos).toULong() else 0UL
        }
    fun layer(j: Int): elide.structs.BloomFilter_.FilterLayer? = layer(elide.structs.BloomFilter_.FilterLayer(), j)
    fun layer(obj: elide.structs.BloomFilter_.FilterLayer, j: Int): elide.structs.BloomFilter_.FilterLayer? {
        val o = __offset(12)
        return if (o != 0) {
            obj.__assign(__indirect(__vector(o) + j * 4), bb)
        } else {
            null
        }
    }
    val layerLength: Int
        get() {
            val o = __offset(12)
            return if (o != 0) __vector_len(o) else 0
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsBloomFilter(_bb: ByteBuffer): BloomFilter = getRootAsBloomFilter(_bb, BloomFilter())
        fun getRootAsBloomFilter(_bb: ByteBuffer, obj: BloomFilter): BloomFilter {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createBloomFilter(
          builder: FlatBufferBuilder,
          algorithm: Int,
          rounds: UInt,
          count: ULong,
          limit: ULong,
          layerOffset: Int,
        ): Int {
            builder.startTable(5)
            addLimit(builder, limit)
            addCount(builder, count)
            addLayer(builder, layerOffset)
            addRounds(builder, rounds)
            addAlgorithm(builder, algorithm)
            return endBloomFilter(builder)
        }
        fun startBloomFilter(builder: FlatBufferBuilder) = builder.startTable(5)
        fun addAlgorithm(builder: FlatBufferBuilder, algorithm: Int) = builder.addInt(0, algorithm, 0)
        fun addRounds(builder: FlatBufferBuilder, rounds: UInt) = builder.addInt(1, rounds.toInt(), 0)
        fun addCount(builder: FlatBufferBuilder, count: ULong) = builder.addLong(2, count.toLong(), 0)
        fun addLimit(builder: FlatBufferBuilder, limit: ULong) = builder.addLong(3, limit.toLong(), 0)
        fun addLayer(builder: FlatBufferBuilder, layer: Int) = builder.addOffset(4, layer, 0)
        fun createLayerVector(builder: FlatBufferBuilder, data: IntArray): Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startLayerVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun endBloomFilter(builder: FlatBufferBuilder): Int {
            val o = builder.endTable()
            return o
        }
    }
}
