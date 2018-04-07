[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [kotlinx.coroutines.experimental.channels.ReceiveChannel](./index.md)

### Extensions for kotlinx.coroutines.experimental.channels.ReceiveChannel

| Name | Summary |
|---|---|
| [consumeEachWithStats](consume-each-with-stats.md) | `suspend fun <E> ReceiveChannel<`[`E`](consume-each-with-stats.md#E)`>.consumeEachWithStats(action: suspend (`[`E`](consume-each-with-stats.md#E)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [pipe](pipe.md) | `suspend fun <T> ReceiveChannel<`[`T`](pipe.md#T)`>.pipe(destination: SendChannel<`[`T`](pipe.md#T)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Creates a message pipe between an upstream [Channel](#) and a terminating downstream [SendChannel](#).`fun <E, V> ReceiveChannel<`[`E`](pipe.md#E)`>.pipe(destination: `[`TransformChannel`](../-transform-channel.md)`<`[`E`](pipe.md#E)`, `[`V`](pipe.md#V)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): ReceiveChannel<`[`V`](pipe.md#V)`>`<br>Creates a message pipe between an upstream [Channel](#) and an intermediate downstream [TransformChannel](../-transform-channel.md). |
| [stats](stats.md) | `val <T> ReceiveChannel<`[`T`](stats.md#T)`>.stats: `[`ChannelStats`](../-channel-stats/index.md) |
