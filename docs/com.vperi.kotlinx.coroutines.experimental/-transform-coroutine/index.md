[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [TransformCoroutine](./index.md)

# TransformCoroutine

`class TransformCoroutine<E, V> : AbstractCoroutine<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>, `[`TransformChannel`](../-transform-channel.md)`<`[`E`](index.md#E)`, `[`V`](index.md#V)`>, SendChannel<`[`E`](index.md#E)`>, ReceiveChannel<`[`V`](index.md#V)`>, `[`TransformScope`](../-transform-scope/index.md)`<`[`E`](index.md#E)`, `[`V`](index.md#V)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TransformCoroutine(parentContext: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)`, input: Channel<`[`E`](index.md#E)`>, output: Channel<`[`V`](index.md#V)`>, active: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [input](input.md) | `val input: Channel<`[`E`](index.md#E)`>` |
| [output](output.md) | `val output: Channel<`[`V`](index.md#V)`>` |

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
