[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental.sync](./index.md)

## Package com.vperi.kotlinx.coroutines.experimental.sync

### Types

| Name | Summary |
|---|---|
| [AbstractLatch](-abstract-latch/index.md) | `open class AbstractLatch : Deferred<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>` |
| [AbstractTrigger](-abstract-trigger/index.md) | `abstract class AbstractTrigger : CompletableDeferred<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>` |
| [CountDownLatch](-count-down-latch/index.md) | `class CountDownLatch : `[`AbstractLatch`](-abstract-latch/index.md)<br>A synchronization aid that allows one or more coroutines to wait without blocking until a set of operations being performed in other coroutines complete. |
| [CountingLatch](-counting-latch/index.md) | `class CountingLatch : `[`AbstractLatch`](-abstract-latch/index.md)<br>Like a [CountDownLatch](-count-down-latch/index.md) but the count can be increased via [countUp](-counting-latch/count-up.md) |
| [ZeroTrigger](-zero-trigger/index.md) | `class ZeroTrigger : `[`AbstractTrigger`](-abstract-trigger/index.md) |

### Functions

| Name | Summary |
|---|---|
| [withCountDown](with-count-down.md) | `suspend fun withCountDown(count: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, parent: Job? = null, block: suspend `[`CountDownLatch`](-count-down-latch/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`suspend fun withCountDown(count: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, parent: Job? = null, block: suspend `[`CountDownLatch`](-count-down-latch/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
