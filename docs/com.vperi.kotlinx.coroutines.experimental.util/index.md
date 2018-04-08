[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental.util](./index.md)

## Package com.vperi.kotlinx.coroutines.experimental.util

### Types

| Name | Summary |
|---|---|
| [FS](-f-s/index.md) | `class FS`<br>Filesystem Helpers |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [java.nio.ByteBuffer](java.nio.-byte-buffer/index.md) |  |
| [kotlin.String](kotlin.-string/index.md) |  |
| [kotlinx.coroutines.experimental.channels.ReceiveChannel](kotlinx.coroutines.experimental.channels.-receive-channel/index.md) |  |
| [kotlinx.coroutines.experimental.channels.SendChannel](kotlinx.coroutines.experimental.channels.-send-channel/index.md) |  |

### Functions

| Name | Summary |
|---|---|
| [contents](contents.md) | `fun <T> contents(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, callback: suspend (`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](contents.md#T)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`TransformCoroutine`](../com.vperi.kotlinx.coroutines.experimental.coroutine/-transform-coroutine/index.md)`<`[`T`](contents.md#T)`, `[`T`](contents.md#T)`>`<br>Returns a [TransformChannel](#). |
| [decodeUtf8](decode-utf8.md) | `fun decodeUtf8(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`TransformCoroutine`](../com.vperi.kotlinx.coroutines.experimental.coroutine/-transform-coroutine/index.md)`<`[`ByteBuffer`](http://docs.oracle.com/javase/6/docs/api/java/nio/ByteBuffer.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>Decodes incoming [ByteBuffer](http://docs.oracle.com/javase/6/docs/api/java/nio/ByteBuffer.html)s as utf8 encoded [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html). |
| [encodeUtf8](encode-utf8.md) | `fun encodeUtf8(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`TransformCoroutine`](../com.vperi.kotlinx.coroutines.experimental.coroutine/-transform-coroutine/index.md)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`ByteBuffer`](http://docs.oracle.com/javase/6/docs/api/java/nio/ByteBuffer.html)`>` |
| [nullActor](null-actor.md) | `suspend fun <T> nullActor(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, capacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0): SendChannel<`[`T`](null-actor.md#T)`>`<br>Returns a [SendChannel](#). |
| [produce](produce.md) | `fun <T> produce(items: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`T`](produce.md#T)`>): ReceiveChannel<`[`T`](produce.md#T)`>` |
| [splitLines](split-lines.md) | `fun splitLines(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, vararg delimiters: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = listOf("\n").toTypedArray(), ignoreCase: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`TransformCoroutine`](../com.vperi.kotlinx.coroutines.experimental.coroutine/-transform-coroutine/index.md)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>Splits each [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) into a sequence of strings around occurrences of the [delimiters](split-lines.md#com.vperi.kotlinx.coroutines.experimental.util$splitLines(kotlin.coroutines.experimental.CoroutineContext, kotlin.Array((kotlin.String)), kotlin.Boolean)/delimiters) and sends each of the generated strings as messages on its output. |
| [tee](tee.md) | `fun <T> tee(listener: SendChannel<`[`T`](tee.md#T)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`TransformCoroutine`](../com.vperi.kotlinx.coroutines.experimental.coroutine/-transform-coroutine/index.md)`<`[`T`](tee.md#T)`, `[`T`](tee.md#T)`>`<br>Returns a [TransformChannel](#). |
