// automatically generated by the FlatBuffers compiler, do not modify

package elide.meta

import com.google.flatbuffers.*
import java.nio.*

@Suppress("unused")
class GuestSettingsStanza : Table() {

    fun __init(_i: Int, _bb: ByteBuffer) {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer): GuestSettingsStanza {
        __init(_i, _bb)
        return this
    }
    val lang: Int
        get() {
            val o = __offset(4)
            return if (o != 0) bb.getInt(o + bb_pos) else 0
        }
    val general: elide.meta.GeneralLanguageSettings? get() = general(elide.meta.GeneralLanguageSettings())
    fun general(obj: elide.meta.GeneralLanguageSettings): elide.meta.GeneralLanguageSettings? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val langSettings: elide.meta.GuestSettingsStanza_.LanguageSpecificSettings? get() = langSettings(elide.meta.GuestSettingsStanza_.LanguageSpecificSettings())
    fun langSettings(
      obj: elide.meta.GuestSettingsStanza_.LanguageSpecificSettings,
    ): elide.meta.GuestSettingsStanza_.LanguageSpecificSettings? {
        val o = __offset(8)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsGuestSettingsStanza(
          _bb: ByteBuffer,
        ): GuestSettingsStanza = getRootAsGuestSettingsStanza(_bb, GuestSettingsStanza())
        fun getRootAsGuestSettingsStanza(_bb: ByteBuffer, obj: GuestSettingsStanza): GuestSettingsStanza {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createGuestSettingsStanza(
          builder: FlatBufferBuilder,
          lang: Int,
          generalOffset: Int,
          langSettingsOffset: Int,
        ): Int {
            builder.startTable(3)
            addLangSettings(builder, langSettingsOffset)
            addGeneral(builder, generalOffset)
            addLang(builder, lang)
            return endGuestSettingsStanza(builder)
        }
        fun startGuestSettingsStanza(builder: FlatBufferBuilder) = builder.startTable(3)
        fun addLang(builder: FlatBufferBuilder, lang: Int) = builder.addInt(0, lang, 0)
        fun addGeneral(builder: FlatBufferBuilder, general: Int) = builder.addOffset(1, general, 0)
        fun addLangSettings(builder: FlatBufferBuilder, langSettings: Int) = builder.addOffset(2, langSettings, 0)
        fun endGuestSettingsStanza(builder: FlatBufferBuilder): Int {
            val o = builder.endTable()
            return o
        }
    }
}
