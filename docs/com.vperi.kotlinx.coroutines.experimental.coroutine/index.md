[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental.coroutine](./index.md)

## Package com.vperi.kotlinx.coroutines.experimental.coroutine

### Types

| Name | Summary |
|---|---|
| [AfterScope](-after-scope/index.md) | `interface AfterScope : CoroutineScope` |
| [JobWithReceiveChannel](-job-with-receive-channel/index.md) | `abstract class JobWithReceiveChannel<out E> : AbstractCoroutine<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>, ReceiveChannel<`[`E`](-job-with-receive-channel/index.md#E)`>` |
| [PipeCoroutine](-pipe-coroutine/index.md) | `class PipeCoroutine<E> : AbstractCoroutine<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>` |
| [PipeCoroutine2](-pipe-coroutine2/index.md) | `class PipeCoroutine2<out E, out V> : `[`JobWithReceiveChannel`](-job-with-receive-channel/index.md)`<`[`V`](-pipe-coroutine2/index.md#V)`>` |
| [TransformChannel](-transform-channel.md) | `interface TransformChannel<in E, out V> : SendChannel<`[`E`](-transform-channel.md#E)`>, ReceiveChannel<`[`V`](-transform-channel.md#V)`>`<br>External interface to a transform channel as seen by users of the channel. |
| [TransformCoroutine](-transform-coroutine/index.md) | `class TransformCoroutine<E, V> : AbstractCoroutine<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>, `[`TransformChannel`](-transform-channel.md)`<`[`E`](-transform-coroutine/index.md#E)`, `[`V`](-transform-coroutine/index.md#V)`>, SendChannel<`[`E`](-transform-coroutine/index.md#E)`>, ReceiveChannel<`[`V`](-transform-coroutine/index.md#V)`>, `[`TransformScope`](-transform-scope/index.md)`<`[`E`](-transform-coroutine/index.md#E)`, `[`V`](-transform-coroutine/index.md#V)`>` |
| [TransformScope](-transform-scope/index.md) | `interface TransformScope<out E, in V> : CoroutineScope`<br>Internal interface to a transform channel as seen by the transform function. |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [kotlinx.coroutines.experimental.Job](kotlinx.coroutines.experimental.-job/index.md) |  |
| [kotlinx.coroutines.experimental.channels.ReceiveChannel](kotlinx.coroutines.experimental.channels.-receive-channel/index.md) |  |

### Functions

| Name | Summary |
|---|---|
| [transform](transform.md) | `fun <E, V> transform(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, capacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, parent: Job? = null, start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend `[`TransformScope`](-transform-scope/index.md)`<`[`E`](transform.md#E)`, `[`V`](transform.md#V)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`TransformCoroutine`](-transform-coroutine/index.md)`<`[`E`](transform.md#E)`, `[`V`](transform.md#V)`>`<br>Returns a [TransformChannel](-transform-channel.md). |
