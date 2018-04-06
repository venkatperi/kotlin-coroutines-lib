[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [PipeCoroutine](./index.md)

# PipeCoroutine

`class PipeCoroutine<E> : AbstractCoroutine<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>, SendChannel<`[`E`](index.md#E)`>, ReceiveChannel<`[`E`](index.md#E)`>, `[`PipeScope`](../-pipe-scope/index.md)`<`[`E`](index.md#E)`>`

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
| [pipe](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md) | `fun <T> ReceiveChannel<`[`T`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#T)`>.pipe(destination: SendChannel<`[`T`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#T)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun <E, V> ReceiveChannel<`[`E`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#E)`>.pipe(destination: `[`TransformChannel`](../-transform-channel.md)`<`[`E`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#E)`, `[`V`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#V)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): ReceiveChannel<`[`V`](../kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#V)`>` |
| [resultAsync](../kotlinx.coroutines.experimental.-job/result-async.md) | `suspend fun Job.resultAsync(): `[`Result`](../-result/index.md)`<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>` |
