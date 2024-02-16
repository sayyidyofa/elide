/*
 * Copyright (c) 2024 Elide Technologies, Inc.
 *
 * Licensed under the MIT license (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   https://opensource.org/license/mit/
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under the License.
 */

// automatically generated by the FlatBuffers compiler, do not modify

package elide.page

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class Context : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : Context {
        __init(_i, _bb)
        return this
    }
    val meta : elide.page.Context_.Metadata? get() = meta(elide.page.Context_.Metadata())
    fun meta(obj: elide.page.Context_.Metadata) : elide.page.Context_.Metadata? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val styles : elide.page.Context_.Styles? get() = styles(elide.page.Context_.Styles())
    fun styles(obj: elide.page.Context_.Styles) : elide.page.Context_.Styles? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val fonts : elide.page.Context_.Fonts? get() = fonts(elide.page.Context_.Fonts())
    fun fonts(obj: elide.page.Context_.Fonts) : elide.page.Context_.Fonts? {
        val o = __offset(8)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val scripts : elide.page.Context_.Scripts? get() = scripts(elide.page.Context_.Scripts())
    fun scripts(obj: elide.page.Context_.Scripts) : elide.page.Context_.Scripts? {
        val o = __offset(10)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val manifest : elide.page.Context_.AppManifest? get() = manifest(elide.page.Context_.AppManifest())
    fun manifest(obj: elide.page.Context_.AppManifest) : elide.page.Context_.AppManifest? {
        val o = __offset(12)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val etag : elide.page.Context_.DynamicETag? get() = etag(elide.page.Context_.DynamicETag())
    fun etag(obj: elide.page.Context_.DynamicETag) : elide.page.Context_.DynamicETag? {
        val o = __offset(14)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    fun cookie(j: Int) : elide.page.Context_.Cookie? = cookie(elide.page.Context_.Cookie(), j)
    fun cookie(obj: elide.page.Context_.Cookie, j: Int) : elide.page.Context_.Cookie? {
        val o = __offset(16)
        return if (o != 0) {
            obj.__assign(__indirect(__vector(o) + j * 4), bb)
        } else {
            null
        }
    }
    val cookieLength : Int
        get() {
            val o = __offset(16); return if (o != 0) __vector_len(o) else 0
        }
    fun header(j: Int) : elide.page.Context_.ResponseHeader? = header(elide.page.Context_.ResponseHeader(), j)
    fun header(obj: elide.page.Context_.ResponseHeader, j: Int) : elide.page.Context_.ResponseHeader? {
        val o = __offset(18)
        return if (o != 0) {
            obj.__assign(__indirect(__vector(o) + j * 4), bb)
        } else {
            null
        }
    }
    val headerLength : Int
        get() {
            val o = __offset(18); return if (o != 0) __vector_len(o) else 0
        }
    fun vary(j: Int) : String? {
        val o = __offset(20)
        return if (o != 0) {
            __string(__vector(o) + j * 4)
        } else {
            null
        }
    }
    val varyLength : Int
        get() {
            val o = __offset(20); return if (o != 0) __vector_len(o) else 0
        }
    val language : String?
        get() {
            val o = __offset(22)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val languageAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(22, 1)
    fun languageInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 22, 1)
    val hints : elide.page.Context_.ClientHints? get() = hints(elide.page.Context_.ClientHints())
    fun hints(obj: elide.page.Context_.ClientHints) : elide.page.Context_.ClientHints? {
        val o = __offset(24)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    fun featurePolicy(j: Int) : String? {
        val o = __offset(26)
        return if (o != 0) {
            __string(__vector(o) + j * 4)
        } else {
            null
        }
    }
    val featurePolicyLength : Int
        get() {
            val o = __offset(26); return if (o != 0) __vector_len(o) else 0
        }
    val framingPolicy : Int
        get() {
            val o = __offset(28)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    val contentTypeNosniff : Boolean
        get() {
            val o = __offset(30)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val cdnPrefix : webutil.html.types.TrustedResourceUrlProto? get() = cdnPrefix(webutil.html.types.TrustedResourceUrlProto())
    fun cdnPrefix(obj: webutil.html.types.TrustedResourceUrlProto) : webutil.html.types.TrustedResourceUrlProto? {
        val o = __offset(32)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    fun dnsPrefetch(j: Int) : String? {
        val o = __offset(34)
        return if (o != 0) {
            __string(__vector(o) + j * 4)
        } else {
            null
        }
    }
    val dnsPrefetchLength : Int
        get() {
            val o = __offset(34); return if (o != 0) __vector_len(o) else 0
        }
    fun preconnect(j: Int) : String? {
        val o = __offset(36)
        return if (o != 0) {
            __string(__vector(o) + j * 4)
        } else {
            null
        }
    }
    val preconnectLength : Int
        get() {
            val o = __offset(36); return if (o != 0) __vector_len(o) else 0
        }
    val xssProtection : String?
        get() {
            val o = __offset(38)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val xssProtectionAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(38, 1)
    fun xssProtectionInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 38, 1)
    val referrerPolicy : Int
        get() {
            val o = __offset(40)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsContext(_bb: ByteBuffer): Context = getRootAsContext(_bb, Context())
        fun getRootAsContext(_bb: ByteBuffer, obj: Context): Context {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createContext(builder: FlatBufferBuilder, metaOffset: Int, stylesOffset: Int, fontsOffset: Int, scriptsOffset: Int, manifestOffset: Int, etagOffset: Int, cookieOffset: Int, headerOffset: Int, varyOffset: Int, languageOffset: Int, hintsOffset: Int, featurePolicyOffset: Int, framingPolicy: Int, contentTypeNosniff: Boolean, cdnPrefixOffset: Int, dnsPrefetchOffset: Int, preconnectOffset: Int, xssProtectionOffset: Int, referrerPolicy: Int) : Int {
            builder.startTable(19)
            addReferrerPolicy(builder, referrerPolicy)
            addXssProtection(builder, xssProtectionOffset)
            addPreconnect(builder, preconnectOffset)
            addDnsPrefetch(builder, dnsPrefetchOffset)
            addCdnPrefix(builder, cdnPrefixOffset)
            addFramingPolicy(builder, framingPolicy)
            addFeaturePolicy(builder, featurePolicyOffset)
            addHints(builder, hintsOffset)
            addLanguage(builder, languageOffset)
            addVary(builder, varyOffset)
            addHeader(builder, headerOffset)
            addCookie(builder, cookieOffset)
            addEtag(builder, etagOffset)
            addManifest(builder, manifestOffset)
            addScripts(builder, scriptsOffset)
            addFonts(builder, fontsOffset)
            addStyles(builder, stylesOffset)
            addMeta(builder, metaOffset)
            addContentTypeNosniff(builder, contentTypeNosniff)
            return endContext(builder)
        }
        fun startContext(builder: FlatBufferBuilder) = builder.startTable(19)
        fun addMeta(builder: FlatBufferBuilder, meta: Int) = builder.addOffset(0, meta, 0)
        fun addStyles(builder: FlatBufferBuilder, styles: Int) = builder.addOffset(1, styles, 0)
        fun addFonts(builder: FlatBufferBuilder, fonts: Int) = builder.addOffset(2, fonts, 0)
        fun addScripts(builder: FlatBufferBuilder, scripts: Int) = builder.addOffset(3, scripts, 0)
        fun addManifest(builder: FlatBufferBuilder, manifest: Int) = builder.addOffset(4, manifest, 0)
        fun addEtag(builder: FlatBufferBuilder, etag: Int) = builder.addOffset(5, etag, 0)
        fun addCookie(builder: FlatBufferBuilder, cookie: Int) = builder.addOffset(6, cookie, 0)
        fun createCookieVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startCookieVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun addHeader(builder: FlatBufferBuilder, header: Int) = builder.addOffset(7, header, 0)
        fun createHeaderVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startHeaderVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun addVary(builder: FlatBufferBuilder, vary: Int) = builder.addOffset(8, vary, 0)
        fun createVaryVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startVaryVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun addLanguage(builder: FlatBufferBuilder, language: Int) = builder.addOffset(9, language, 0)
        fun addHints(builder: FlatBufferBuilder, hints: Int) = builder.addOffset(10, hints, 0)
        fun addFeaturePolicy(builder: FlatBufferBuilder, featurePolicy: Int) = builder.addOffset(11, featurePolicy, 0)
        fun createFeaturePolicyVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startFeaturePolicyVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun addFramingPolicy(builder: FlatBufferBuilder, framingPolicy: Int) = builder.addInt(12, framingPolicy, 0)
        fun addContentTypeNosniff(builder: FlatBufferBuilder, contentTypeNosniff: Boolean) = builder.addBoolean(13, contentTypeNosniff, false)
        fun addCdnPrefix(builder: FlatBufferBuilder, cdnPrefix: Int) = builder.addOffset(14, cdnPrefix, 0)
        fun addDnsPrefetch(builder: FlatBufferBuilder, dnsPrefetch: Int) = builder.addOffset(15, dnsPrefetch, 0)
        fun createDnsPrefetchVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startDnsPrefetchVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun addPreconnect(builder: FlatBufferBuilder, preconnect: Int) = builder.addOffset(16, preconnect, 0)
        fun createPreconnectVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startPreconnectVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun addXssProtection(builder: FlatBufferBuilder, xssProtection: Int) = builder.addOffset(17, xssProtection, 0)
        fun addReferrerPolicy(builder: FlatBufferBuilder, referrerPolicy: Int) = builder.addInt(18, referrerPolicy, 0)
        fun endContext(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
