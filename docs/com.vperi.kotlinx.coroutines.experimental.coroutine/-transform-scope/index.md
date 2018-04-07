[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental.coroutine](../index.md) / [TransformScope](./index.md)

# TransformScope

`interface TransformScope<out E, in V> : CoroutineScope`

Internal interface to a transform channel as seen by the transform
function.

From the inside ([TransformScope](./index.md)) the transform channel appears as a
[ReceiveChannel](#) on the input side and a [SendChannel](#) for outputs.

### Parameters

`E` - data type on the input side

`V` - data type on the output side

### Properties

| Name | Summary |
|---|---|
| [input](input.md) | `abstract val input: ReceiveChannel<`[`E`](index.md#E)`>`<br>The input channel as a readable. |
| [output](output.md) | `abstract val output: SendChannel<`[`V`](index.md#V)`>`<br>The output channel as a writable |

### Inheritors

| Name | Summary |
|---|---|
| [TransformCoroutine](../-transform-coroutine/index.md) | `class TransformCoroutine<E, V> : AbstractCoroutine<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>, `[`TransformChannel`](../-transform-channel.md)`<`[`E`](../-transform-coroutine/index.md#E)`, `[`V`](../-transform-coroutine/index.md#V)`>, SendChannel<`[`E`](../-transform-coroutine/index.md#E)`>, ReceiveChannel<`[`V`](../-transform-coroutine/index.md#V)`>, `[`TransformScope`](./index.md)`<`[`E`](../-transform-coroutine/index.md#E)`, `[`V`](../-transform-coroutine/index.md#V)`>` |
