[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [CoCountdownLatch](./index.md)

# CoCountdownLatch

`class CoCountdownLatch`

A synchronization aid that allows one or more coroutines to wait
without blocking until a set of operations being performed in other
coroutines complete.

A [CoCountdownLatch](./index.md) is initialized with a given count. The
[await](await.md) methods block until the current count reaches zero due to
invocations of the [countDown](count-down.md) method, after which all waiting coroutines
are released and any subsequent invocations of await return immediately.

Example:

```
val count = 9L
val latch = CoCountdownLatch(count)
val counter = AtomicLong(0)
runBlocking {
  (0 until count).forEach {
    async {
      delay(ThreadLocalRandom.current().nextInt(100, 500))
      counter.incrementAndGet()
      latch.countDown()
    }
  }
  latch.await()
  assertEquals(count, counter.get())
  println(counter.get())     //=> 9
}
```

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CoCountdownLatch(count: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`)`<br>Constructs a [CoCountdownLatch](./index.md) initialized with the given count. |

### Properties

| Name | Summary |
|---|---|
| [count](count.md) | `val count: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the number of times [countDown](count-down.md) must be invoked before     [await](await.md) will not block. |

### Functions

| Name | Summary |
|---|---|
| [await](await.md) | `suspend fun await(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Waits until the latch has counted down to zero without blocking. This suspending function is cancellable. |
| [cancel](cancel.md) | `fun cancel(cause: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If not already complete, [cancel](cancel.md) Cancels this latch with an optional cancellation [cause](cancel.md#com.vperi.kotlinx.coroutines.experimental.CoCountdownLatch$cancel(kotlin.Throwable)/cause). The result is `true` if this job was cancelled as a result of this invocation and `false` otherwise |
| [countDown](count-down.md) | `fun countDown(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Decrements the latch's count by one. If the count becomes zero, suspended coroutines waiting via [await](await.md) resume immediately. |
