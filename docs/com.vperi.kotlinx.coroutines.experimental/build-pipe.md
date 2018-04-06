[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental](index.md) / [buildPipe](./build-pipe.md)

# buildPipe

`fun <E> buildPipe(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, source: ReceiveChannel<`[`E`](build-pipe.md#E)`>, destination: SendChannel<`[`E`](build-pipe.md#E)`>, start: CoroutineStart = CoroutineStart.DEFAULT, parent: Job? = null): `[`PipeCoroutine`](-pipe-coroutine/index.md)`<`[`E`](build-pipe.md#E)`>`