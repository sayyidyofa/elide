//[graalvm](../../../index.md)/[elide.server.ssr](../index.md)/[ServerSSRRenderer](index.md)

# ServerSSRRenderer

[jvm]\
class [ServerSSRRenderer](index.md)(body: [BODY](../../../../../packages/server/kotlinx.html/-b-o-d-y/index.md), handler: [ElideController](../../../../../packages/server/server/elide.server.controller/-elide-controller/index.md), request: HttpRequest&lt;*&gt;, script: [JsRuntime.ExecutableScript](../../elide.runtime.graalvm/-js-runtime/-executable-script/index.md)) : [SuspensionRenderer](../../../../../packages/graalvm/elide.server/-suspension-renderer/index.md)&lt;[ByteArrayOutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/ByteArrayOutputStream.html)&gt; 

Renderer class which executes JavaScript via SSR and provides the resulting response to Micronaut.

## Constructors

| | |
|---|---|
| [ServerSSRRenderer](-server-s-s-r-renderer.md) | [jvm]<br>fun [ServerSSRRenderer](-server-s-s-r-renderer.md)(body: [BODY](../../../../../packages/server/kotlinx.html/-b-o-d-y/index.md), handler: [ElideController](../../../../../packages/server/server/elide.server.controller/-elide-controller/index.md), request: HttpRequest&lt;*&gt;, script: [JsRuntime.ExecutableScript](../../elide.runtime.graalvm/-js-runtime/-executable-script/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [render](render.md) | [jvm]<br>open suspend override fun [render](render.md)(): [ByteArrayOutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/ByteArrayOutputStream.html)<br>Render the attached [script](../../../../../packages/server/kotlinx.html/index.md) and return the resulting content as a [ByteArrayOutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/ByteArrayOutputStream.html), built from the result of [renderSuspendAsync](render-suspend-async.md). |
| [renderResponse](render-response.md) | [jvm]<br>suspend fun [renderResponse](render-response.md)(response: MutableHttpResponse&lt;[ByteArrayOutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/ByteArrayOutputStream.html)&gt;): MutableHttpResponse&lt;[ByteArrayOutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/ByteArrayOutputStream.html)&gt;<br>Render the attached [script](../../../../../packages/server/kotlinx.html/index.md) into a [ByteArrayOutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/ByteArrayOutputStream.html), and wrap it in a Micronaut MutableHttpResponse provided at [response](render-response.md). |
| [renderSuspendAsync](render-suspend-async.md) | [jvm]<br>suspend fun [renderSuspendAsync](render-suspend-async.md)(): Deferred&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;<br>Render the attached [script](../../../../../packages/server/kotlinx.html/index.md) with suspension support, and return the resulting content as a regular [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html). |
