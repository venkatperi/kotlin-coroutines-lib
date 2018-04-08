[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental.util](../index.md) / [kotlinx.coroutines.experimental.channels.ReceiveChannel](./index.md)

### Extensions for kotlinx.coroutines.experimental.channels.ReceiveChannel

| Name | Summary |
|---|---|
| [consumeEachWithStats](consume-each-with-stats.md) | `suspend fun <E> ReceiveChannel<`[`E`](consume-each-with-stats.md#E)`>.consumeEachWithStats(action: suspend (`[`E`](consume-each-with-stats.md#E)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [drain](drain.md) | `suspend fun <E> ReceiveChannel<`[`E`](drain.md#E)`>.drain(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Suspends until all messages are consumed from the [ReceiveChannel](#) |
| [stats](stats.md) | `val <T> ReceiveChannel<`[`T`](stats.md#T)`>.stats: `[`ChannelStats`](../../com.vperi.kotlinx.coroutines.experimental/-channel-stats/index.md) |
