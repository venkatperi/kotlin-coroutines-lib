[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental.util](../index.md) / [FS](index.md) / [createWriter](./create-writer.md)

# createWriter

`fun createWriter(file: Path, vararg options: OpenOption, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): SendChannel<`[`ByteBuffer`](http://docs.oracle.com/javase/6/docs/api/java/nio/ByteBuffer.html)`>`

Returns a [SendChannel](#) for the given [file](create-writer.md#com.vperi.kotlinx.coroutines.experimental.util.FS.Companion$createWriter(java.nio.file.Path, kotlin.Array((java.nio.file.OpenOption)), kotlin.coroutines.experimental.CoroutineContext)/file) for writing

