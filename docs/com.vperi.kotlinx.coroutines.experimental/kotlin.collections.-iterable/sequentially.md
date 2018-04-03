[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [kotlin.collections.Iterable](index.md) / [sequentially](./sequentially.md)

# sequentially

`fun <T : Job> `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`T`](sequentially.md#T)`>.sequentially(): ReceiveChannel<`[`T`](sequentially.md#T)`>`

Returns completed jobs from the given [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html) in
a sequentially manner.

