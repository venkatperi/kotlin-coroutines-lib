[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [FS](index.md) / [createReader](./create-reader.md)

# createReader

`fun createReader(file: Path, vararg options: OpenOption, blockSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1024, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): ReceiveChannel<`[`ByteBuffer`](http://docs.oracle.com/javase/6/docs/api/java/nio/ByteBuffer.html)`>`

Returns a [ReceiveChannel](#) for the given [file](create-reader.md#com.vperi.kotlinx.coroutines.experimental.FS.Companion$createReader(java.nio.file.Path, kotlin.Array((java.nio.file.OpenOption)), kotlin.Int, kotlin.coroutines.experimental.CoroutineContext)/file) for reading
