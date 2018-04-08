[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental.coroutine](../index.md) / [TransformCoroutine](./index.md)

# TransformCoroutine

`class TransformCoroutine<E, V> : AbstractCoroutine<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>, `[`TransformChannel`](../-transform-channel.md)`<`[`E`](index.md#E)`, `[`V`](index.md#V)`>, SendChannel<`[`E`](index.md#E)`>, ReceiveChannel<`[`V`](index.md#V)`>, `[`TransformScope`](../-transform-scope/index.md)`<`[`E`](index.md#E)`, `[`V`](index.md#V)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TransformCoroutine(parentContext: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)`, input: Channel<`[`E`](index.md#E)`>, output: Channel<`[`V`](index.md#V)`>, active: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [input](input.md) | `val input: Channel<`[`E`](index.md#E)`>`<br>The input channel as a readable. |
| [output](output.md) | `val output: Channel<`[`V`](index.md#V)`>`<br>The output channel as a writable |

### Functions

| Name | Summary |
|---|---|
| [cancel](cancel.md) | `fun cancel(cause: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onCancellation](on-cancellation.md) | `fun onCancellation(cause: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [catch](../kotlinx.coroutines.experimental.-job/catch.md) | `fun Job.catch(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, failure: suspend (`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [consumeEachWithStats](../../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-receive-channel/consume-each-with-stats.md) | `suspend fun <E> ReceiveChannel<`[`E`](../../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-receive-channel/consume-each-with-stats.md#E)`>.consumeEachWithStats(action: suspend (`[`E`](../../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-receive-channel/consume-each-with-stats.md#E)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [finally](../kotlinx.coroutines.experimental.-job/finally.md) | `fun Job.finally(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, handler: suspend (`[`Result`](../../com.vperi.kotlinx.coroutines.experimental/-result/index.md)`<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [pipe](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md) | `suspend fun <T> ReceiveChannel<`[`T`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#T)`>.pipe(destination: SendChannel<`[`T`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#T)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Creates a message pipe between an upstream [Channel](#) and a terminating downstream [SendChannel](#).`fun <E, V> ReceiveChannel<`[`E`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#E)`>.pipe(destination: `[`TransformChannel`](../-transform-channel.md)`<`[`E`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#E)`, `[`V`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#V)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): ReceiveChannel<`[`V`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#V)`>`<br>Creates a message pipe between an upstream [Channel](#) and an intermediate downstream [TransformChannel](../-transform-channel.md). |
| [resultAsync](../../com.vperi.kotlinx.coroutines.experimental/kotlinx.coroutines.experimental.-job/result-async.md) | `suspend fun Job.resultAsync(): `[`Result`](../../com.vperi.kotlinx.coroutines.experimental/-result/index.md)`<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>` |
| [sendWithStats](../../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-send-channel/send-with-stats.md) | `suspend fun <E> SendChannel<`[`E`](../../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-send-channel/send-with-stats.md#E)`>.sendWithStats(element: `[`E`](../../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-send-channel/send-with-stats.md#E)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [then](../kotlinx.coroutines.experimental.-job/then.md) | `fun Job.then(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, successHandler: suspend () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, failureHandler: suspend (`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job`<br>`fun Job.then(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, success: suspend () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
