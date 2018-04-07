[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental](index.md) / [transform](./transform.md)

# transform

`fun <E, V> transform(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, capacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, parent: Job? = null, start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend `[`TransformScope`](-transform-scope/index.md)`<`[`E`](transform.md#E)`, `[`V`](transform.md#V)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`TransformCoroutine`](-transform-coroutine/index.md)`<`[`E`](transform.md#E)`, `[`V`](transform.md#V)`>`

Returns a [TransformChannel](-transform-channel.md).

Launches new coroutine that receives messages from its input channel
and sends transformed messages on its output channel.

The returned object is usually connected to other channels to form a directed graph.

Upstream channels can [send](#) messages to,
and downstream channels can [receive](#)
transformed messages from this coroutine.

### Parameters

`context` - context of the coroutine. The default value is [DefaultDispatcher](#).

`capacity` - capacity of the channel's buffer (no buffer by default).

`start` - coroutine start option. The default value is [CoroutineStart.DEFAULT](#).

`parent` - explicitly specifies the parent job, overrides job from the [context](transform.md#com.vperi.kotlinx.coroutines.experimental$transform(kotlin.coroutines.experimental.CoroutineContext, kotlin.Int, kotlinx.coroutines.experimental.Job, kotlinx.coroutines.experimental.CoroutineStart, kotlin.SuspendFunction1((com.vperi.kotlinx.coroutines.experimental.TransformScope((com.vperi.kotlinx.coroutines.experimental.transform.E, com.vperi.kotlinx.coroutines.experimental.transform.V)), kotlin.Unit)))/context) (if any).*

`block` - the transformation/coroutine code.