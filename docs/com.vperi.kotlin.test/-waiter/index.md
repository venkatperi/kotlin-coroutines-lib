[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlin.test](../index.md) / [Waiter](./index.md)

# Waiter

`open class Waiter`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Waiter()` |

### Functions

| Name | Summary |
|---|---|
| [await](await.md) | `suspend fun await(time: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, count: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [blocking](blocking.md) | `fun blocking(time: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, count: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, block: suspend `[`Waiter`](./index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [resume](resume.md) | `suspend fun resume(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
