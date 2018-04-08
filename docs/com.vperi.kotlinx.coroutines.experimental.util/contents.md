[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental.util](index.md) / [contents](./contents.md)

# contents

`fun <T> contents(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, callback: suspend (`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](contents.md#T)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`TransformCoroutine`](../com.vperi.kotlinx.coroutines.experimental.coroutine/-transform-coroutine/index.md)`<`[`T`](contents.md#T)`, `[`T`](contents.md#T)`>`

Returns a [TransformChannel](#).

Messages sent to the input channel are transmitted on its output
channel. In addition, the transform also maintains a list of the
messages which are provided to the [callback](contents.md#com.vperi.kotlinx.coroutines.experimental.util$contents(kotlin.coroutines.experimental.CoroutineContext, kotlin.SuspendFunction1((kotlin.collections.List((com.vperi.kotlinx.coroutines.experimental.util.contents.T)), kotlin.Unit)))/callback) when the channel
closes.

Best used for debugging, since the list can grow indefinitely.

### Parameters

`callback` - Called when the input channel closes with a copy of
all messages sent to this transform.

`context` - the coroutine context