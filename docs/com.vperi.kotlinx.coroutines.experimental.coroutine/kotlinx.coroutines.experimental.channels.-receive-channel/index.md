[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental.coroutine](../index.md) / [kotlinx.coroutines.experimental.channels.ReceiveChannel](./index.md)

### Extensions for kotlinx.coroutines.experimental.channels.ReceiveChannel

| Name | Summary |
|---|---|
| [pipe](pipe.md) | `fun <T> ReceiveChannel<`[`T`](pipe.md#T)`>.pipe(destination: SendChannel<`[`T`](pipe.md#T)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): Job`<br>Creates a message pipe between an upstream [Channel](#) and a terminating downstream [SendChannel](#).`fun <E, V> ReceiveChannel<`[`E`](pipe.md#E)`>.pipe(destination: `[`TransformChannel`](../-transform-channel.md)`<`[`E`](pipe.md#E)`, `[`V`](pipe.md#V)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, parent: Job? = null): `[`JobWithReceiveChannel`](../-job-with-receive-channel/index.md)`<`[`V`](pipe.md#V)`>`<br>Creates a message pipe between an upstream [Channel](#) and an intermediate downstream [TransformChannel](../-transform-channel.md). |
