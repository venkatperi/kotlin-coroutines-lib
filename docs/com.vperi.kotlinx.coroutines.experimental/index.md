[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental](./index.md)

## Package com.vperi.kotlinx.coroutines.experimental

### Types

| Name | Summary |
|---|---|
| [AbstractLatch](-abstract-latch/index.md) | `open class AbstractLatch : Deferred<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>` |
| [AbstractTrigger](-abstract-trigger/index.md) | `abstract class AbstractTrigger : CompletableDeferred<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>` |
| [CountDownLatch](-count-down-latch/index.md) | `class CountDownLatch : `[`AbstractLatch`](-abstract-latch/index.md)<br>A synchronization aid that allows one or more coroutines to wait without blocking until a set of operations being performed in other coroutines complete. |
| [CountingLatch](-counting-latch/index.md) | `class CountingLatch : `[`AbstractLatch`](-abstract-latch/index.md)<br>Like a [CountDownLatch](-count-down-latch/index.md) but the count can be increased via [countUp](-counting-latch/count-up.md) |
| [ZeroTrigger](-zero-trigger/index.md) | `class ZeroTrigger : `[`AbstractTrigger`](-abstract-trigger/index.md) |

### Exceptions

| Name | Summary |
|---|---|
| [IndexedException](-indexed-exception/index.md) | `class IndexedException : `[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html) |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [kotlin.collections.Iterable](kotlin.collections.-iterable/index.md) |  |
| [kotlinx.coroutines.experimental.Deferred](kotlinx.coroutines.experimental.-deferred/index.md) |  |

### Properties

| Name | Summary |
|---|---|
| [failed](failed.md) | `val <T : Job> `[`T`](failed.md#T)`.failed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the job has completed exceptionally or has been cancelled. |
| [failureException](failure-exception.md) | `val <T : Job> `[`T`](failure-exception.md#T)`.failureException: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?`<br>Returns the failure exception |

### Functions

| Name | Summary |
|---|---|
| [awaitCompletion](await-completion.md) | `suspend fun <T : Job> `[`T`](await-completion.md#T)`.awaitCompletion(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Suspends until job is complete. Calls [Deferred.await](#) for [Deferred](#). |
