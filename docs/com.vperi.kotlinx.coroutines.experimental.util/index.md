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
| [kotlinx.coroutines.experimental.channels.ReceiveChannel](kotlinx.coroutines.experimental.channels.-receive-channel/index.md) |  |
| [kotlinx.coroutines.experimental.channels.SendChannel](kotlinx.coroutines.experimental.channels.-send-channel/index.md) |  |

### Functions

| Name | Summary |
|---|---|
| [contents](contents.md) | `fun <T> contents(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, callback: suspend (`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](contents.md#T)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`TransformCoroutine`](../com.vperi.kotlinx.coroutines.experimental.coroutine/-transform-coroutine/index.md)`<`[`T`](contents.md#T)`, `[`T`](contents.md#T)`>` |
| [decodeUtf8](decode-utf8.md) | `fun decodeUtf8(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`TransformCoroutine`](../com.vperi.kotlinx.coroutines.experimental.coroutine/-transform-coroutine/index.md)`<`[`ByteBuffer`](http://docs.oracle.com/javase/6/docs/api/java/nio/ByteBuffer.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [nullActor](null-actor.md) | `suspend fun <T> nullActor(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): SendChannel<`[`T`](null-actor.md#T)`>` |
| [splitLines](split-lines.md) | `fun splitLines(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`TransformCoroutine`](../com.vperi.kotlinx.coroutines.experimental.coroutine/-transform-coroutine/index.md)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [tee](tee.md) | `fun <T> tee(listener: SendChannel<`[`T`](tee.md#T)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`TransformCoroutine`](../com.vperi.kotlinx.coroutines.experimental.coroutine/-transform-coroutine/index.md)`<`[`T`](tee.md#T)`, `[`T`](tee.md#T)`>` |
