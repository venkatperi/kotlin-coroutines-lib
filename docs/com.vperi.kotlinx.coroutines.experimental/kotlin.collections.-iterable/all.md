[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [kotlin.collections.Iterable](index.md) / [all](./all.md)

# all

`fun <T : Job> `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`T`](all.md#T)`>.all(): Deferred<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>`

Returns a [Deferred](#) which completes successfully when all the
[Job](#)s in the [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html) complete successfully or
completes exceptionally with the reason of the first
[Job](#) that completes exceptionally.

If the [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html) is empty, the returned [Deferred](#)
completes immediately.

