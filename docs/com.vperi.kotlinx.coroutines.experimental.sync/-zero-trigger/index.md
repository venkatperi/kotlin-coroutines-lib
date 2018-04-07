[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental.sync](../index.md) / [ZeroTrigger](./index.md)

# ZeroTrigger

`class ZeroTrigger : `[`AbstractTrigger`](../-abstract-trigger/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ZeroTrigger(initial: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, triggerInitially: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, parent: Job? = null)` |

### Functions

| Name | Summary |
|---|---|
| [test](test.md) | `fun test(block: () -> `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [decrement](../-abstract-trigger/decrement.md) | `fun decrement(): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [get](../-abstract-trigger/get.md) | `fun get(): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [increment](../-abstract-trigger/increment.md) | `fun increment(): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [set](../-abstract-trigger/set.md) | `fun set(v: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [awaitBlocking](../../com.vperi.kotlinx.coroutines.experimental/kotlinx.coroutines.experimental.-deferred/await-blocking.md) | `fun <T> Deferred<`[`T`](../../com.vperi.kotlinx.coroutines.experimental/kotlinx.coroutines.experimental.-deferred/await-blocking.md#T)`>.awaitBlocking(): `[`T`](../../com.vperi.kotlinx.coroutines.experimental/kotlinx.coroutines.experimental.-deferred/await-blocking.md#T) |
| [catch](../../com.vperi.kotlinx.coroutines.experimental.coroutine/kotlinx.coroutines.experimental.-job/catch.md) | `fun Job.catch(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, failure: suspend (`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [finally](../../com.vperi.kotlinx.coroutines.experimental.coroutine/kotlinx.coroutines.experimental.-job/finally.md) | `fun Job.finally(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, handler: suspend (`[`Result`](../../com.vperi.kotlinx.coroutines.experimental/-result/index.md)`<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [then](../../com.vperi.kotlinx.coroutines.experimental.coroutine/kotlinx.coroutines.experimental.-job/then.md) | `fun Job.then(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, successHandler: suspend () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, failureHandler: suspend (`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job`<br>`fun Job.then(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, success: suspend () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
