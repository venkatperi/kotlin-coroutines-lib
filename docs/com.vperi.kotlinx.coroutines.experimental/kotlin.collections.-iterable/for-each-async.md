[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [kotlin.collections.Iterable](index.md) / [forEachAsync](./for-each-async.md)

# forEachAsync

`fun <T : Job> `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`T`](for-each-async.md#T)`>.forEachAsync(action: suspend (`[`T`](for-each-async.md#T)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Performs the given [action](for-each-async.md#com.vperi.kotlinx.coroutines.experimental$forEachAsync(kotlin.collections.Iterable((com.vperi.kotlinx.coroutines.experimental.forEachAsync.T)), kotlin.SuspendFunction1((com.vperi.kotlinx.coroutines.experimental.forEachAsync.T, kotlin.Unit)))/action) asynchronously on each element.

`@JvmName("indexedAsync") fun <T : Job, V : `[`IndexedValue`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-indexed-value/index.html)`<`[`T`](for-each-async.md#T)`>> `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`V`](for-each-async.md#V)`>.forEachAsync(action: suspend (`[`V`](for-each-async.md#V)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Performs the [action](for-each-async.md#com.vperi.kotlinx.coroutines.experimental$forEachAsync(kotlin.collections.Iterable((com.vperi.kotlinx.coroutines.experimental.forEachAsync.V)), kotlin.SuspendFunction1((com.vperi.kotlinx.coroutines.experimental.forEachAsync.V, kotlin.Unit)))/action) asynchronously on each element as an
[IndexedValue](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-indexed-value/index.html).

