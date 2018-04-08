[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental](./index.md)

## Package com.vperi.kotlinx.coroutines.experimental

### Types

| Name | Summary |
|---|---|
| [ChannelStats](-channel-stats/index.md) | `class ChannelStats` |
| [IndexedResult](-indexed-result/index.md) | `data class IndexedResult<out T>` |
| [Result](-result/index.md) | `sealed class Result<out T>`<br>Represents the result of a Job/Deferred |

### Exceptions

| Name | Summary |
|---|---|
| [IndexedException](-indexed-exception/index.md) | `class IndexedException : `[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html) |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [kotlin.collections.Iterable](kotlin.collections.-iterable/index.md) |  |
| [kotlinx.coroutines.experimental.Deferred](kotlinx.coroutines.experimental.-deferred/index.md) |  |
| [kotlinx.coroutines.experimental.Job](kotlinx.coroutines.experimental.-job/index.md) |  |

### Properties

| Name | Summary |
|---|---|
| [failed](failed.md) | `val <T : Job> `[`T`](failed.md#T)`.failed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the job has completed exceptionally or has been cancelled. |
| [failureException](failure-exception.md) | `val <T : Job> `[`T`](failure-exception.md#T)`.failureException: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?`<br>Returns the failure exception |

### Functions

| Name | Summary |
|---|---|
| [resultOf](result-of.md) | `fun <T> resultOf(value: `[`T`](result-of.md#T)`): `[`Result`](-result/index.md)`<`[`T`](result-of.md#T)`>`<br>`fun resultOf(error: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`Result`](-result/index.md)`<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>`<br>`fun <T> resultOf(block: () -> `[`T`](result-of.md#T)`): `[`Result`](-result/index.md)`<`[`T`](result-of.md#T)`>` |
| [resultOfAsync](result-of-async.md) | `suspend fun <T> resultOfAsync(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, block: suspend () -> `[`T`](result-of-async.md#T)`): `[`Result`](-result/index.md)`<`[`T`](result-of-async.md#T)`>` |
