[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental.util](../index.md) / [FS](index.md) / [createReader](./create-reader.md)

# createReader

`fun createReader(file: Path, vararg options: OpenOption, blockSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1024, allocator: (`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`ByteBuffer`](http://docs.oracle.com/javase/6/docs/api/java/nio/ByteBuffer.html)` = { ByteBuffer.allocate(it) }, capacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): ReceiveChannel<`[`ByteBuffer`](http://docs.oracle.com/javase/6/docs/api/java/nio/ByteBuffer.html)`>`

Returns a [ReceiveChannel](#) for the given [file](create-reader.md#com.vperi.kotlinx.coroutines.experimental.util.FS.Companion$createReader(java.nio.file.Path, kotlin.Array((java.nio.file.OpenOption)), kotlin.Int, kotlin.Function1((kotlin.Int, java.nio.ByteBuffer)), kotlin.Int, kotlin.coroutines.experimental.CoroutineContext)/file) for reading.

### Parameters

`file` - The file to read from

`options` - see [OpenOption](#)

`context` - the coroutine context

`blockSize` - Bytes per read.

`allocator` - Source of [ByteBuffer](http://docs.oracle.com/javase/6/docs/api/java/nio/ByteBuffer.html). Default is alloc as needed.