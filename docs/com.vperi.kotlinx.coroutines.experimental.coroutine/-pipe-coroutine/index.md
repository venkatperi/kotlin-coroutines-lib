[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental.coroutine](../index.md) / [PipeCoroutine](./index.md)

# PipeCoroutine

`class PipeCoroutine<E> : AbstractCoroutine<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PipeCoroutine(parentContext: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)`, source: ReceiveChannel<`[`E`](index.md#E)`>, destination: SendChannel<`[`E`](index.md#E)`>, active: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [destination](destination.md) | `val destination: SendChannel<`[`E`](index.md#E)`>` |
| [source](source.md) | `val source: ReceiveChannel<`[`E`](index.md#E)`>` |

### Functions

| Name | Summary |
|---|---|
| [cancel](cancel.md) | `fun cancel(cause: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onCancellation](on-cancellation.md) | `fun onCancellation(cause: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [catch](../kotlinx.coroutines.experimental.-job/catch.md) | `fun Job.catch(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, failure: suspend `[`AfterScope`](../-after-scope/index.md)`.(`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [finally](../kotlinx.coroutines.experimental.-job/finally.md) | `fun Job.finally(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, handler: suspend `[`AfterScope`](../-after-scope/index.md)`.(`[`Result`](../../com.vperi.kotlinx.coroutines.experimental/-result/index.md)`<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [resultAsync](../../com.vperi.kotlinx.coroutines.experimental/kotlinx.coroutines.experimental.-job/result-async.md) | `suspend fun Job.resultAsync(): `[`Result`](../../com.vperi.kotlinx.coroutines.experimental/-result/index.md)`<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>` |
| [then](../kotlinx.coroutines.experimental.-job/then.md) | `fun Job.then(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, successHandler: suspend `[`AfterScope`](../-after-scope/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, failureHandler: suspend `[`AfterScope`](../-after-scope/index.md)`.(`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job`<br>`fun Job.then(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, success: suspend `[`AfterScope`](../-after-scope/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
