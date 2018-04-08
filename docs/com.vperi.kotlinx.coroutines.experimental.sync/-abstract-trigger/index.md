[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental.sync](../index.md) / [AbstractTrigger](./index.md)

# AbstractTrigger

`abstract class AbstractTrigger : CompletableDeferred<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AbstractTrigger(initial: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, parent: Job? = null)` |

### Functions

| Name | Summary |
|---|---|
| [decrement](decrement.md) | `fun decrement(): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [get](get.md) | `fun get(): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [increment](increment.md) | `fun increment(): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [set](set.md) | `fun set(v: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [test](test.md) | `abstract fun test(block: () -> `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [awaitBlocking](../../com.vperi.kotlinx.coroutines.experimental/kotlinx.coroutines.experimental.-deferred/await-blocking.md) | `fun <T> Deferred<`[`T`](../../com.vperi.kotlinx.coroutines.experimental/kotlinx.coroutines.experimental.-deferred/await-blocking.md#T)`>.awaitBlocking(): `[`T`](../../com.vperi.kotlinx.coroutines.experimental/kotlinx.coroutines.experimental.-deferred/await-blocking.md#T) |
| [catch](../../com.vperi.kotlinx.coroutines.experimental.coroutine/kotlinx.coroutines.experimental.-job/catch.md) | `fun Job.catch(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, failure: suspend `[`AfterScope`](../../com.vperi.kotlinx.coroutines.experimental.coroutine/-after-scope/index.md)`.(`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [finally](../../com.vperi.kotlinx.coroutines.experimental.coroutine/kotlinx.coroutines.experimental.-job/finally.md) | `fun Job.finally(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, handler: suspend `[`AfterScope`](../../com.vperi.kotlinx.coroutines.experimental.coroutine/-after-scope/index.md)`.(`[`Result`](../../com.vperi.kotlinx.coroutines.experimental/-result/index.md)`<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [then](../../com.vperi.kotlinx.coroutines.experimental.coroutine/kotlinx.coroutines.experimental.-job/then.md) | `fun Job.then(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, successHandler: suspend `[`AfterScope`](../../com.vperi.kotlinx.coroutines.experimental.coroutine/-after-scope/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, failureHandler: suspend `[`AfterScope`](../../com.vperi.kotlinx.coroutines.experimental.coroutine/-after-scope/index.md)`.(`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job`<br>`fun Job.then(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, success: suspend `[`AfterScope`](../../com.vperi.kotlinx.coroutines.experimental.coroutine/-after-scope/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |

### Inheritors

| Name | Summary |
|---|---|
| [ZeroTrigger](../-zero-trigger/index.md) | `class ZeroTrigger : `[`AbstractTrigger`](./index.md) |
