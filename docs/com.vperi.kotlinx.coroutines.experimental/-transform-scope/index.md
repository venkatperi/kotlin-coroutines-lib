[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [TransformScope](./index.md)

# TransformScope

`interface TransformScope<E, V> : CoroutineScope`

### Properties

| Name | Summary |
|---|---|
| [input](input.md) | `abstract val input: Channel<`[`E`](index.md#E)`>` |
| [output](output.md) | `abstract val output: Channel<`[`V`](index.md#V)`>` |

### Inheritors

| Name | Summary |
|---|---|
| [TransformCoroutine](../-transform-coroutine/index.md) | `class TransformCoroutine<E, V> : AbstractCoroutine<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>, `[`TransformChannel`](../-transform-channel.md)`<`[`E`](../-transform-coroutine/index.md#E)`, `[`V`](../-transform-coroutine/index.md#V)`>, SendChannel<`[`E`](../-transform-coroutine/index.md#E)`>, ReceiveChannel<`[`V`](../-transform-coroutine/index.md#V)`>, `[`TransformScope`](./index.md)`<`[`E`](../-transform-coroutine/index.md#E)`, `[`V`](../-transform-coroutine/index.md#V)`>` |
