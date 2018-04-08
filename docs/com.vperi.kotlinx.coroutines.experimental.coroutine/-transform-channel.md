[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental.coroutine](index.md) / [TransformChannel](./-transform-channel.md)

# TransformChannel

`interface TransformChannel<in E, out V> : SendChannel<`[`E`](-transform-channel.md#E)`>, ReceiveChannel<`[`V`](-transform-channel.md#V)`>`

External interface to a transform channel as seen by users of the channel.

A transform is made up of two
duplex [Channel](#)s (one input and one output) and a non-blocking
transforming function that transforms incoming messages.

From the outside ([TransformChannel](./-transform-channel.md), a transform channel appears as a [SendChannel](#)
on the input side and as a [ReceiveChannel](#) on the output side.

From the inside ([TransformScope](-transform-scope/index.md)) the transform channel appears as a
[ReceiveChannel](#) on the input side and a [SendChannel](#) for outputs.

### Parameters

`E` - data type on the input side

`V` - data type on the output side

### Extension Functions

| Name | Summary |
|---|---|
| [consumeEachWithStats](../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-receive-channel/consume-each-with-stats.md) | `suspend fun <E> ReceiveChannel<`[`E`](../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-receive-channel/consume-each-with-stats.md#E)`>.consumeEachWithStats(action: suspend (`[`E`](../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-receive-channel/consume-each-with-stats.md#E)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [drain](../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-receive-channel/drain.md) | `suspend fun <E> ReceiveChannel<`[`E`](../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-receive-channel/drain.md#E)`>.drain(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Suspends until all messages are consumed from the [ReceiveChannel](#) |
| [pipe](kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md) | `fun <T> ReceiveChannel<`[`T`](kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#T)`>.pipe(destination: SendChannel<`[`T`](kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#T)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): Job`<br>Creates a message pipe between an upstream [Channel](#) and a terminating downstream [SendChannel](#).`fun <E, V> ReceiveChannel<`[`E`](kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#E)`>.pipe(destination: `[`TransformChannel`](./-transform-channel.md)`<`[`E`](kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#E)`, `[`V`](kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#V)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null): `[`JobWithReceiveChannel`](-job-with-receive-channel/index.md)`<`[`V`](kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#V)`>`<br>Creates a message pipe between an upstream [Channel](#) and an intermediate downstream [TransformChannel](./-transform-channel.md). |
| [sendWithStats](../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-send-channel/send-with-stats.md) | `suspend fun <E> SendChannel<`[`E`](../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-send-channel/send-with-stats.md#E)`>.sendWithStats(element: `[`E`](../com.vperi.kotlinx.coroutines.experimental.util/kotlinx.coroutines.experimental.channels.-send-channel/send-with-stats.md#E)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [TransformCoroutine](-transform-coroutine/index.md) | `class TransformCoroutine<E, V> : AbstractCoroutine<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>, `[`TransformChannel`](./-transform-channel.md)`<`[`E`](-transform-coroutine/index.md#E)`, `[`V`](-transform-coroutine/index.md#V)`>, SendChannel<`[`E`](-transform-coroutine/index.md#E)`>, ReceiveChannel<`[`V`](-transform-coroutine/index.md#V)`>, `[`TransformScope`](-transform-scope/index.md)`<`[`E`](-transform-coroutine/index.md#E)`, `[`V`](-transform-coroutine/index.md#V)`>` |
