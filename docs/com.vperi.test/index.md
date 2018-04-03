[kotlin-coroutines-lib](../index.md) / [com.vperi.test](./index.md)

## Package com.vperi.test

### Types

| Name | Summary |
|---|---|
| [Waiter](-waiter/index.md) | `open class Waiter` |

### Type Aliases

| Name | Summary |
|---|---|
| [WaiterBlock](-waiter-block.md) | `typealias WaiterBlock = suspend `[`Waiter`](-waiter/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Functions

| Name | Summary |
|---|---|
| [wait](wait.md) | `fun wait(time: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, count: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, block: `[`WaiterBlock`](-waiter-block.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
