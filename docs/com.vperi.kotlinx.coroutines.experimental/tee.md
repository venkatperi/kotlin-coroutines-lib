[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental](index.md) / [tee](./tee.md)

# tee

`fun <T> tee(listener: SendChannel<`[`T`](tee.md#T)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`TransformCoroutine`](-transform-coroutine/index.md)`<`[`T`](tee.md#T)`, `[`T`](tee.md#T)`>`