[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental](index.md) / [awaitCompletion](./await-completion.md)

# awaitCompletion

`suspend fun <T : Job> `[`T`](await-completion.md#T)`.awaitCompletion(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspends until job is complete. Calls [Deferred.await](#)
for [Deferred](#).

