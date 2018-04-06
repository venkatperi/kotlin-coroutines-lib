[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental](index.md) / [TransformChannel](./-transform-channel.md)

# TransformChannel

`interface TransformChannel<in E, out V> : SendChannel<`[`E`](-transform-channel.md#E)`>, ReceiveChannel<`[`V`](-transform-channel.md#V)`>`

### Extension Functions

| Name | Summary |
|---|---|
| [pipe](kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md) | `fun <T> ReceiveChannel<`[`T`](kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#T)`>.pipe(destination: SendChannel<`[`T`](kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#T)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun <E, V> ReceiveChannel<`[`E`](kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#E)`>.pipe(destination: `[`TransformChannel`](./-transform-channel.md)`<`[`E`](kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#E)`, `[`V`](kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#V)`>, context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher): ReceiveChannel<`[`V`](kotlinx.coroutines.experimental.channels.-receive-channel/pipe.md#V)`>` |

### Inheritors

| Name | Summary |
|---|---|
| [TransformCoroutine](-transform-coroutine/index.md) | `class TransformCoroutine<E, V> : AbstractCoroutine<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>, `[`TransformChannel`](./-transform-channel.md)`<`[`E`](-transform-coroutine/index.md#E)`, `[`V`](-transform-coroutine/index.md#V)`>, SendChannel<`[`E`](-transform-coroutine/index.md#E)`>, ReceiveChannel<`[`V`](-transform-coroutine/index.md#V)`>, `[`TransformScope`](-transform-scope/index.md)`<`[`E`](-transform-coroutine/index.md#E)`, `[`V`](-transform-coroutine/index.md#V)`>` |
