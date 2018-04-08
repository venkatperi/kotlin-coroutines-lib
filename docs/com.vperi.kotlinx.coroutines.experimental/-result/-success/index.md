[kotlin-coroutines-lib](../../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../../index.md) / [Result](../index.md) / [Success](./index.md)

# Success

`class Success<out T> : `[`Result`](../index.md)`<`[`T`](index.md#T)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Success(value: `[`T`](index.md#T)`)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [isFailure](../is-failure.md) | `val isFailure: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isSuccess](../is-success.md) | `val isSuccess: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | `operator fun invoke(): `[`T`](index.md#T) |

### Inherited Functions

| Name | Summary |
|---|---|
| [exceptionOrNull](../exception-or-null.md) | `fun exceptionOrNull(): `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?` |
| [get](../get.md) | `fun get(): `[`T`](../index.md#T) |
| [getOrNull](../get-or-null.md) | `fun getOrNull(): `[`T`](../index.md#T)`?` |
