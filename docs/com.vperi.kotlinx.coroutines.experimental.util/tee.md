[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental.util](index.md) / [tee](./tee.md)

# tee

`fun <T> tee(listener: SendChannel<`[`T`](tee.md#T)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`TransformCoroutine`](../com.vperi.kotlinx.coroutines.experimental.coroutine/-transform-coroutine/index.md)`<`[`T`](tee.md#T)`, `[`T`](tee.md#T)`>`

Returns a [TransformChannel](#).

Acts as a pass through where messages on the input channel are
sent on the output channel, as well as to the provided [listener](#).

### Parameters

`listener` - Receives a copy of all messages sent to this coroutine

`context` - the coroutine context