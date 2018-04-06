[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [kotlin.collections.Iterable](index.md) / [failed](./failed.md)

# failed

`fun <T : Job> `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`T`](failed.md#T)`>.failed(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): ReceiveChannel<`[`IndexedValue`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-indexed-value/index.html)`<`[`T`](failed.md#T)`>>`

Like [completed](completed.md), returns a [ReceiveChannel](#) that provides
only those jobs that have completed exceptionally or cancelled

