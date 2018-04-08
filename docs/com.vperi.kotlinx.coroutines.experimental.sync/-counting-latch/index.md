[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental.sync](../index.md) / [CountingLatch](./index.md)

# CountingLatch

`class CountingLatch : `[`AbstractLatch`](../-abstract-latch/index.md)

Like a [CountDownLatch](../-count-down-latch/index.md) but the count can be increased
via [countUp](count-up.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CountingLatch(count: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)``CountingLatch(count: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, parent: Job? = null)`<br>Like a [CountDownLatch](../-count-down-latch/index.md) but the count can be increased via [countUp](count-up.md) |

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
| [countUp](count-up.md) | `fun countUp(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [awaitBlocking](../../com.vperi.kotlinx.coroutines.experimental/kotlinx.coroutines.experimental.-deferred/await-blocking.md) | `fun <T> Deferred<`[`T`](../../com.vperi.kotlinx.coroutines.experimental/kotlinx.coroutines.experimental.-deferred/await-blocking.md#T)`>.awaitBlocking(): `[`T`](../../com.vperi.kotlinx.coroutines.experimental/kotlinx.coroutines.experimental.-deferred/await-blocking.md#T) |
| [catch](../../com.vperi.kotlinx.coroutines.experimental.coroutine/kotlinx.coroutines.experimental.-job/catch.md) | `fun Job.catch(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, failure: suspend `[`AfterScope`](../../com.vperi.kotlinx.coroutines.experimental.coroutine/-after-scope/index.md)`.(`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [finally](../../com.vperi.kotlinx.coroutines.experimental.coroutine/kotlinx.coroutines.experimental.-job/finally.md) | `fun Job.finally(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, handler: suspend `[`AfterScope`](../../com.vperi.kotlinx.coroutines.experimental.coroutine/-after-scope/index.md)`.(`[`Result`](../../com.vperi.kotlinx.coroutines.experimental/-result/index.md)`<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [then](../../com.vperi.kotlinx.coroutines.experimental.coroutine/kotlinx.coroutines.experimental.-job/then.md) | `fun Job.then(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, successHandler: suspend `[`AfterScope`](../../com.vperi.kotlinx.coroutines.experimental.coroutine/-after-scope/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, failureHandler: suspend `[`AfterScope`](../../com.vperi.kotlinx.coroutines.experimental.coroutine/-after-scope/index.md)`.(`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job`<br>`fun Job.then(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, success: suspend `[`AfterScope`](../../com.vperi.kotlinx.coroutines.experimental.coroutine/-after-scope/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
