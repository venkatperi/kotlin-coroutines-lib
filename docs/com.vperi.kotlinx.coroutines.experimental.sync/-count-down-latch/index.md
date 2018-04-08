[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental.sync](../index.md) / [CountDownLatch](./index.md)

# CountDownLatch

`class CountDownLatch : `[`AbstractLatch`](../-abstract-latch/index.md)

A synchronization aid that allows one or more coroutines to wait
without blocking until a set of operations being performed in other
coroutines complete.

A [CountDownLatch](./index.md) is initialized with a given count. The
[await](#) methods block until the current count reaches zero due to
invocations of the [countDown](count-down.md) method, after which all waiting coroutines
are released and any subsequent invocations of await return immediately.

Example:

``` kotlin
val count = 9L
val latch = CountDownLatch(count)
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
| [&lt;init&gt;](-init-.md) | `CountDownLatch(count: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)``CountDownLatch(count: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, parent: Job? = null)`<br>Constructs a [CountDownLatch](./index.md) initialized with the given count. |

### Inherited Properties

| Name | Summary |
|---|---|
| [count](../-abstract-latch/count.md) | `val count: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [current](../-abstract-latch/current.md) | `val current: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [trigger](../-abstract-latch/trigger.md) | `val trigger: `[`AbstractTrigger`](../-abstract-trigger/index.md) |

### Functions

| Name | Summary |
|---|---|
| [countDown](count-down.md) | `fun countDown(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [awaitBlocking](../../com.vperi.kotlinx.coroutines.experimental/kotlinx.coroutines.experimental.-deferred/await-blocking.md) | `fun <T> Deferred<`[`T`](../../com.vperi.kotlinx.coroutines.experimental/kotlinx.coroutines.experimental.-deferred/await-blocking.md#T)`>.awaitBlocking(): `[`T`](../../com.vperi.kotlinx.coroutines.experimental/kotlinx.coroutines.experimental.-deferred/await-blocking.md#T) |
| [catch](../../com.vperi.kotlinx.coroutines.experimental.coroutine/kotlinx.coroutines.experimental.-job/catch.md) | `fun Job.catch(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, failure: suspend `[`AfterScope`](../../com.vperi.kotlinx.coroutines.experimental.coroutine/-after-scope/index.md)`.(`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [finally](../../com.vperi.kotlinx.coroutines.experimental.coroutine/kotlinx.coroutines.experimental.-job/finally.md) | `fun Job.finally(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, handler: suspend `[`AfterScope`](../../com.vperi.kotlinx.coroutines.experimental.coroutine/-after-scope/index.md)`.(`[`Result`](../../com.vperi.kotlinx.coroutines.experimental/-result/index.md)`<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [then](../../com.vperi.kotlinx.coroutines.experimental.coroutine/kotlinx.coroutines.experimental.-job/then.md) | `fun Job.then(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, successHandler: suspend `[`AfterScope`](../../com.vperi.kotlinx.coroutines.experimental.coroutine/-after-scope/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, failureHandler: suspend `[`AfterScope`](../../com.vperi.kotlinx.coroutines.experimental.coroutine/-after-scope/index.md)`.(`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job`<br>`fun Job.then(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, success: suspend `[`AfterScope`](../../com.vperi.kotlinx.coroutines.experimental.coroutine/-after-scope/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
