[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental.coroutine](../index.md) / [kotlinx.coroutines.experimental.channels.ReceiveChannel](index.md) / [pipe](./pipe.md)

# pipe

`suspend fun <T> ReceiveChannel<`[`T`](pipe.md#T)`>.pipe(destination: SendChannel<`[`T`](pipe.md#T)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Creates a message pipe between an upstream [Channel](#) and a terminating
downstream [SendChannel](#).

Launches a coroutine that [receives](#) messages from
an upstream [Channel](#) and [sends](#) them to a downstream
[Channel](#).

Waits until all messages are drained from the upstream [ReceiveChannel](#).

### Parameters

`context` - context of the coroutine. The default value is [DefaultDispatcher](#).

`destination` - the downstream [SendChannel](#).`fun <E, V> ReceiveChannel<`[`E`](pipe.md#E)`>.pipe(destination: `[`TransformChannel`](../-transform-channel.md)`<`[`E`](pipe.md#E)`, `[`V`](pipe.md#V)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): ReceiveChannel<`[`V`](pipe.md#V)`>`

Creates a message pipe between an upstream [Channel](#) and an intermediate
downstream [TransformChannel](../-transform-channel.md).

Launches a coroutine that [receives](#) messages from
the upstream [Channel](#) and [sends](#) them to the downstream
[SendChannel](#).

Returns the downstream [TransformChannel](../-transform-channel.md) as a [ReceiveChannel](#) for
further chaining.

### Parameters

`context` - context of the coroutine. The default value is [DefaultDispatcher](#).

`destination` - the downstream [TransformChannel](../-transform-channel.md).