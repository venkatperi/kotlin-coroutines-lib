[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental.coroutine](../index.md) / [JobWithReceiveChannel](./index.md)

# JobWithReceiveChannel

`abstract class JobWithReceiveChannel<out E> : AbstractCoroutine<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>, ReceiveChannel<`[`E`](index.md#E)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `JobWithReceiveChannel(parentContext: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)`, active: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, receiver: ReceiveChannel<`[`E`](index.md#E)`>)` |

### Functions

| Name | Summary |
|---|---|
| [cancel](cancel.md) | `open fun cancel(cause: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [drainAndJoin](drain-and-join.md) | `suspend fun drainAndJoin(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Properties

| Name | Summary |
|---|---|
| [stats](../../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-receive-channel/stats.md) | `val <T> ReceiveChannel<`[`T`](../../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-receive-channel/stats.md#T)`>.stats: `[`ChannelStats`](../../com.vperi.kotlinx.coroutines.experimental/-channel-stats/index.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [catch](../kotlinx.coroutines.experimental.-job/catch.md) | `fun Job.catch(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, failure: suspend `[`AfterScope`](../-after-scope/index.md)`.(`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [consumeEachWithStats](../../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-receive-channel/consume-each-with-stats.md) | `suspend fun <E> ReceiveChannel<`[`E`](../../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-receive-channel/consume-each-with-stats.md#E)`>.consumeEachWithStats(action: suspend (`[`E`](../../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-receive-channel/consume-each-with-stats.md#E)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [drain](../../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-receive-channel/drain.md) | `suspend fun <E> ReceiveChannel<`[`E`](../../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-receive-channel/drain.md#E)`>.drain(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Suspends until all messages are consumed from the [ReceiveChannel](#) |
| [finally](../kotlinx.coroutines.experimental.-job/finally.md) | `fun Job.finally(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, handler: suspend `[`AfterScope`](../-after-scope/index.md)`.(`[`Result`](../../com.vperi.kotlinx.coroutines.experimental/-result/index.md)`<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [pipe](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md) | `fun <T> ReceiveChannel<`[`T`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#T)`>.pipe(destination: SendChannel<`[`T`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#T)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): Job`<br>Creates a message pipe between an upstream [Channel](#) and a terminating downstream [SendChannel](#).`fun <E, V> ReceiveChannel<`[`E`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#E)`>.pipe(destination: `[`TransformChannel`](../-transform-channel.md)`<`[`E`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#E)`, `[`V`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#V)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null): `[`JobWithReceiveChannel`](./index.md)`<`[`V`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#V)`>`<br>Creates a message pipe between an upstream [Channel](#) and an intermediate downstream [TransformChannel](../-transform-channel.md). |
| [resultAsync](../../com.vperi.kotlinx.coroutines.experimental/kotlinx.coroutines.experimental.-job/result-async.md) | `suspend fun Job.resultAsync(): `[`Result`](../../com.vperi.kotlinx.coroutines.experimental/-result/index.md)`<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>` |
| [then](../kotlinx.coroutines.experimental.-job/then.md) | `fun Job.then(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, successHandler: suspend `[`AfterScope`](../-after-scope/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, failureHandler: suspend `[`AfterScope`](../-after-scope/index.md)`.(`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job`<br>`fun Job.then(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null, success: suspend `[`AfterScope`](../-after-scope/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |

### Inheritors

| Name | Summary |
|---|---|
| [PipeCoroutine2](../-pipe-coroutine2/index.md) | `class PipeCoroutine2<out E, out V> : `[`JobWithReceiveChannel`](./index.md)`<`[`V`](../-pipe-coroutine2/index.md#V)`>` |
