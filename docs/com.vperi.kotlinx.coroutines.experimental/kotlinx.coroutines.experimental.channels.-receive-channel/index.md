[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [kotlinx.coroutines.experimental.channels.ReceiveChannel](./index.md)

### Extensions for kotlinx.coroutines.experimental.channels.ReceiveChannel

| Name | Summary |
|---|---|
| [pipe](pipe.md) | `fun <T> ReceiveChannel<`[`T`](pipe.md#T)`>.pipe(destination: SendChannel<`[`T`](pipe.md#T)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun <E, V> ReceiveChannel<`[`E`](pipe.md#E)`>.pipe(destination: `[`TransformChannel`](../-transform-channel.md)`<`[`E`](pipe.md#E)`, `[`V`](pipe.md#V)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): ReceiveChannel<`[`V`](pipe.md#V)`>` |
