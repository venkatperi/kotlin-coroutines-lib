[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental.util](index.md) / [nullActor](./null-actor.md)

# nullActor

`suspend fun <T> nullActor(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, capacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0): SendChannel<`[`T`](null-actor.md#T)`>`

Returns a [SendChannel](#).

Consumes all messages sent to it, ignoring them.

