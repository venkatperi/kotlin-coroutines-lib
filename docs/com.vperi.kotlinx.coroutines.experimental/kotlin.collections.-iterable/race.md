[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [kotlin.collections.Iterable](index.md) / [race](./race.md)

# race

`fun <T : Job> `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`T`](race.md#T)`>.race(): Deferred<`[`IndexedValue`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-indexed-value/index.html)`<`[`T`](race.md#T)`>>`

Returns a [Deferred](#) that completes with the index of the
first [Job](#) that completes (either successfully or exceptionally).

If the iterable is empty, the returned [Deferred](#) never
completes.

