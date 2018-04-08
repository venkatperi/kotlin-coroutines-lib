[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental.sync](../index.md) / [CountDownLatch](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`CountDownLatch(count: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)``CountDownLatch(count: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, parent: Job? = null)`

Constructs a [CountDownLatch](index.md) initialized with the given count.

### Parameters

`count` - the number of times [countDown](count-down.md) must be invoked before
    [await](#) will not block.

**Constructor**
Constructs a [CountDownLatch](index.md) initialized with the given count.

