[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental](./index.md)

## Package com.vperi.kotlinx.coroutines.experimental

### Types

| Name | Summary |
|---|---|
| [AbstractLatch](-abstract-latch/index.md) | `open class AbstractLatch : Deferred<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>` |
| [AbstractTrigger](-abstract-trigger/index.md) | `abstract class AbstractTrigger : CompletableDeferred<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>` |
| [AfterCoroutine](-after-coroutine/index.md) | `class AfterCoroutine<in E> : AbstractCoroutine<`[`E`](-after-coroutine/index.md#E)`>` |
| [ChannelStats](-channel-stats/index.md) | `class ChannelStats` |
| [CountDownLatch](-count-down-latch/index.md) | `class CountDownLatch : `[`AbstractLatch`](-abstract-latch/index.md)<br>A synchronization aid that allows one or more coroutines to wait without blocking until a set of operations being performed in other coroutines complete. |
| [CountingLatch](-counting-latch/index.md) | `class CountingLatch : `[`AbstractLatch`](-abstract-latch/index.md)<br>Like a [CountDownLatch](-count-down-latch/index.md) but the count can be increased via [countUp](-counting-latch/count-up.md) |
| [FS](-f-s/index.md) | `class FS`<br>Filesystem Helpers |
| [IndexedResult](-indexed-result/index.md) | `data class IndexedResult<out T>` |
| [PipeCoroutine](-pipe-coroutine/index.md) | `class PipeCoroutine<E> : AbstractCoroutine<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>, ReceiveChannel<`[`E`](-pipe-coroutine/index.md#E)`>, SendChannel<`[`E`](-pipe-coroutine/index.md#E)`>, `[`PipeScope`](-pipe-scope/index.md)`<`[`E`](-pipe-coroutine/index.md#E)`>` |
| [PipeScope](-pipe-scope/index.md) | `interface PipeScope<E> : CoroutineScope` |
| [Result](-result/index.md) | `sealed class Result<out T>`<br>Represents the result of a Job/Deferred |
| [TransformChannel](-transform-channel.md) | `interface TransformChannel<in E, out V> : SendChannel<`[`E`](-transform-channel.md#E)`>, ReceiveChannel<`[`V`](-transform-channel.md#V)`>`<br>External interface to a transform channel as seen by users of the channel. |
| [TransformCoroutine](-transform-coroutine/index.md) | `class TransformCoroutine<E, V> : AbstractCoroutine<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>, `[`TransformChannel`](-transform-channel.md)`<`[`E`](-transform-coroutine/index.md#E)`, `[`V`](-transform-coroutine/index.md#V)`>, SendChannel<`[`E`](-transform-coroutine/index.md#E)`>, ReceiveChannel<`[`V`](-transform-coroutine/index.md#V)`>, `[`TransformScope`](-transform-scope/index.md)`<`[`E`](-transform-coroutine/index.md#E)`, `[`V`](-transform-coroutine/index.md#V)`>` |
| [TransformScope](-transform-scope/index.md) | `interface TransformScope<out E, in V> : CoroutineScope`<br>Internal interface to a transform channel as seen by the transform function. |
| [ZeroTrigger](-zero-trigger/index.md) | `class ZeroTrigger : `[`AbstractTrigger`](-abstract-trigger/index.md) |

### Exceptions

| Name | Summary |
|---|---|
| [IndexedException](-indexed-exception/index.md) | `class IndexedException : `[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html) |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [java.nio.ByteBuffer](java.nio.-byte-buffer/index.md) |  |
| [kotlin.collections.Iterable](kotlin.collections.-iterable/index.md) |  |
| [kotlinx.coroutines.experimental.Deferred](kotlinx.coroutines.experimental.-deferred/index.md) |  |
| [kotlinx.coroutines.experimental.Job](kotlinx.coroutines.experimental.-job/index.md) |  |
| [kotlinx.coroutines.experimental.channels.ReceiveChannel](kotlinx.coroutines.experimental.channels.-receive-channel/index.md) |  |
| [kotlinx.coroutines.experimental.channels.SendChannel](kotlinx.coroutines.experimental.channels.-send-channel/index.md) |  |

### Properties

| Name | Summary |
|---|---|
| [failed](failed.md) | `val <T : Job> `[`T`](failed.md#T)`.failed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the job has completed exceptionally or has been cancelled. |
| [failureException](failure-exception.md) | `val <T : Job> `[`T`](failure-exception.md#T)`.failureException: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?`<br>Returns the failure exception |

### Functions

| Name | Summary |
|---|---|
| [contents](contents.md) | `fun <T> contents(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, callback: suspend (`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](contents.md#T)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`TransformCoroutine`](-transform-coroutine/index.md)`<`[`T`](contents.md#T)`, `[`T`](contents.md#T)`>` |
| [decodeUtf8](decode-utf8.md) | `fun decodeUtf8(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`TransformCoroutine`](-transform-coroutine/index.md)`<`[`ByteBuffer`](http://docs.oracle.com/javase/6/docs/api/java/nio/ByteBuffer.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [nullActor](null-actor.md) | `suspend fun <T> nullActor(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): SendChannel<`[`T`](null-actor.md#T)`>` |
| [resultOf](result-of.md) | `fun <T> resultOf(value: `[`T`](result-of.md#T)`): `[`Result`](-result/index.md)`<`[`T`](result-of.md#T)`>`<br>`fun resultOf(error: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`Result`](-result/index.md)`<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>`<br>`fun <T> resultOf(block: () -> `[`T`](result-of.md#T)`): `[`Result`](-result/index.md)`<`[`T`](result-of.md#T)`>` |
| [resultOfAsync](result-of-async.md) | `suspend fun <T> resultOfAsync(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, block: suspend () -> `[`T`](result-of-async.md#T)`): `[`Result`](-result/index.md)`<`[`T`](result-of-async.md#T)`>` |
| [splitLines](split-lines.md) | `fun splitLines(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`TransformCoroutine`](-transform-coroutine/index.md)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [tee](tee.md) | `fun <T> tee(listener: SendChannel<`[`T`](tee.md#T)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`TransformCoroutine`](-transform-coroutine/index.md)`<`[`T`](tee.md#T)`, `[`T`](tee.md#T)`>` |
| [transform](transform.md) | `fun <E, V> transform(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, capacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, parent: Job? = null, start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend `[`TransformScope`](-transform-scope/index.md)`<`[`E`](transform.md#E)`, `[`V`](transform.md#V)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`TransformCoroutine`](-transform-coroutine/index.md)`<`[`E`](transform.md#E)`, `[`V`](transform.md#V)`>`<br>Returns a [TransformChannel](-transform-channel.md). |
| [withCountDown](with-count-down.md) | `suspend fun withCountDown(count: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, parent: Job? = null, block: suspend `[`CountDownLatch`](-count-down-latch/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`suspend fun withCountDown(count: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, parent: Job? = null, block: suspend `[`CountDownLatch`](-count-down-latch/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
