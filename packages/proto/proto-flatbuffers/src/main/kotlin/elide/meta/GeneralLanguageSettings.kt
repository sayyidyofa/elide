// automatically generated by the FlatBuffers compiler, do not modify

package elide.meta

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class GeneralLanguageSettings : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : GeneralLanguageSettings {
        __init(_i, _bb)
        return this
    }
    val enabled : Boolean
        get() {
            val o = __offset(4)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val disableCache : Boolean
        get() {
            val o = __offset(6)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsGeneralLanguageSettings(_bb: ByteBuffer): GeneralLanguageSettings = getRootAsGeneralLanguageSettings(_bb, GeneralLanguageSettings())
        fun getRootAsGeneralLanguageSettings(_bb: ByteBuffer, obj: GeneralLanguageSettings): GeneralLanguageSettings {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createGeneralLanguageSettings(builder: FlatBufferBuilder, enabled: Boolean, disableCache: Boolean) : Int {
            builder.startTable(2)
            addDisableCache(builder, disableCache)
            addEnabled(builder, enabled)
            return endGeneralLanguageSettings(builder)
        }
        fun startGeneralLanguageSettings(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addEnabled(builder: FlatBufferBuilder, enabled: Boolean) = builder.addBoolean(0, enabled, false)
        fun addDisableCache(builder: FlatBufferBuilder, disableCache: Boolean) = builder.addBoolean(1, disableCache, false)
        fun endGeneralLanguageSettings(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
