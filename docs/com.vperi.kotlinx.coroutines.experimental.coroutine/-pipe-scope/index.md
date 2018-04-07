[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental.coroutine](../index.md) / [PipeScope](./index.md)

# PipeScope

`interface PipeScope<E> : CoroutineScope`

### Properties

| Name | Summary |
|---|---|
| [destination](destination.md) | `abstract val destination: SendChannel<`[`E`](index.md#E)`>` |
| [source](source.md) | `abstract val source: ReceiveChannel<`[`E`](index.md#E)`>` |

### Inheritors

| Name | Summary |
|---|---|
| [PipeCoroutine](../-pipe-coroutine/index.md) | `class PipeCoroutine<E> : AbstractCoroutine<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>, ReceiveChannel<`[`E`](../-pipe-coroutine/index.md#E)`>, SendChannel<`[`E`](../-pipe-coroutine/index.md#E)`>, `[`PipeScope`](./index.md)`<`[`E`](../-pipe-coroutine/index.md#E)`>` |
