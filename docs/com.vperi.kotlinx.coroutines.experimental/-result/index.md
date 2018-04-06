[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [Result](./index.md)

# Result

`sealed class Result<out T>`

Represents the result of a Job/Deferred

### Types

| Name | Summary |
|---|---|
| [Failure](-failure/index.md) | `class Failure<out T> : `[`Result`](./index.md)`<`[`T`](-failure/index.md#T)`>` |
| [Success](-success/index.md) | `class Success<out T> : `[`Result`](./index.md)`<`[`T`](-success/index.md#T)`>` |

### Properties

| Name | Summary |
|---|---|
| [isFailure](is-failure.md) | `val isFailure: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isSuccess](is-success.md) | `val isSuccess: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Functions

| Name | Summary |
|---|---|
| [exceptionOrNull](exception-or-null.md) | `fun exceptionOrNull(): `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?` |
| [get](get.md) | `fun get(): `[`T`](index.md#T) |
| [getOrNull](get-or-null.md) | `fun getOrNull(): `[`T`](index.md#T)`?` |

### Inheritors

| Name | Summary |
|---|---|
| [Failure](-failure/index.md) | `class Failure<out T> : `[`Result`](./index.md)`<`[`T`](-failure/index.md#T)`>` |
| [Success](-success/index.md) | `class Success<out T> : `[`Result`](./index.md)`<`[`T`](-success/index.md#T)`>` |
