[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [kotlin.collections.Iterable](./index.md)

### Extensions for kotlin.collections.Iterable

| Name | Summary |
|---|---|
| [all](all.md) | `fun <T : Job> `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`T`](all.md#T)`>.all(): Deferred<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>`<br>Returns a [Deferred](#) which completes successfully when all the [Job](#)s in the [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html) complete successfully or completes exceptionally with the reason of the first [Job](#) that completes exceptionally. |
| [completed](completed.md) | `fun <T : Job> `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`T`](completed.md#T)`>.completed(): ReceiveChannel<`[`IndexedValue`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-indexed-value/index.html)`<`[`T`](completed.md#T)`>>`<br>Returns a [ReceiveChannel](#) which provides completed jobs from the [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html) in the order of completion. |
| [failed](failed.md) | `fun <T : Job> `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`T`](failed.md#T)`>.failed(): ReceiveChannel<`[`IndexedValue`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-indexed-value/index.html)`<`[`T`](failed.md#T)`>>`<br>Like [completed](completed.md), returns a [ReceiveChannel](#) that provides only those jobs that have completed exceptionally or cancelled |
| [forEachAsync](for-each-async.md) | `fun <T : Job> `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`T`](for-each-async.md#T)`>.forEachAsync(action: suspend (`[`T`](for-each-async.md#T)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Performs the given [action](for-each-async.md#com.vperi.kotlinx.coroutines.experimental$forEachAsync(kotlin.collections.Iterable((com.vperi.kotlinx.coroutines.experimental.forEachAsync.T)), kotlin.SuspendFunction1((com.vperi.kotlinx.coroutines.experimental.forEachAsync.T, kotlin.Unit)))/action) asynchronously on each element.`fun <T : Job, V : `[`IndexedValue`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-indexed-value/index.html)`<`[`T`](for-each-async.md#T)`>> `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`V`](for-each-async.md#V)`>.forEachAsync(action: suspend (`[`V`](for-each-async.md#V)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Performs the [action](for-each-async.md#com.vperi.kotlinx.coroutines.experimental$forEachAsync(kotlin.collections.Iterable((com.vperi.kotlinx.coroutines.experimental.forEachAsync.V)), kotlin.SuspendFunction1((com.vperi.kotlinx.coroutines.experimental.forEachAsync.V, kotlin.Unit)))/action) asynchronously on each element as an [IndexedValue](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-indexed-value/index.html). |
| [race](race.md) | `fun <T : Job> `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`T`](race.md#T)`>.race(): Deferred<`[`IndexedValue`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-indexed-value/index.html)`<`[`T`](race.md#T)`>>`<br>Returns a [Deferred](#) that completes with the index of the first [Job](#) that completes (either successfully or exceptionally). |
| [succeeded](succeeded.md) | `fun <T : Job> `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`T`](succeeded.md#T)`>.succeeded(): ReceiveChannel<`[`IndexedValue`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-indexed-value/index.html)`<`[`T`](succeeded.md#T)`>>`<br>Like [completed](completed.md), returns a [ReceiveChannel](#) that provides only those jobs that have completed successfully. |