[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental.util](../index.md) / [FS](./index.md)

# FS

`class FS`

Filesystem Helpers

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `FS()`<br>Filesystem Helpers |

### Companion Object Functions

| Name | Summary |
|---|---|
| [createReader](create-reader.md) | `fun createReader(file: Path, vararg options: OpenOption, blockSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1024, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): ReceiveChannel<`[`ByteBuffer`](http://docs.oracle.com/javase/6/docs/api/java/nio/ByteBuffer.html)`>`<br>Returns a [ReceiveChannel](#) for the given [file](create-reader.md#com.vperi.kotlinx.coroutines.experimental.util.FS.Companion$createReader(java.nio.file.Path, kotlin.Array((java.nio.file.OpenOption)), kotlin.Int, kotlin.coroutines.experimental.CoroutineContext)/file) for reading |
| [createWriter](create-writer.md) | `fun createWriter(file: Path, vararg options: OpenOption, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): SendChannel<`[`ByteBuffer`](http://docs.oracle.com/javase/6/docs/api/java/nio/ByteBuffer.html)`>`<br>Returns a [SendChannel](#) for the given [file](create-writer.md#com.vperi.kotlinx.coroutines.experimental.util.FS.Companion$createWriter(java.nio.file.Path, kotlin.Array((java.nio.file.OpenOption)), kotlin.coroutines.experimental.CoroutineContext)/file) for writing |
