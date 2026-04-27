//[korelibrary](../../../index.md)/[com.dev.korelibrary.themes.shapes](../index.md)/[SquircleBasedShape](index.md)

# SquircleBasedShape

abstract class [SquircleBasedShape](index.md)(topStart: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), topEnd: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), bottomStart: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), bottomEnd: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), val cornerSmoothing: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)) : [CornerBasedShape](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerBasedShape.html)

Base class for creating a Squircle shape derived from a [CornerBasedShape](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerBasedShape.html) defined by four corners and a corner smoothing.

#### Parameters

common

| | |
|---|---|
| topStart | The top start corner radius defined as [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html). |
| topEnd | The top end corner radius defined as [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html). |
| bottomStart | The bottom start corner radius defined as [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html). |
| bottomEnd | The bottom end corner radius defined as [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html). |
| cornerSmoothing | (0.55f - rounded corner shape, 1f - fully pronounced squircle). |

#### Inheritors

| |
|---|
| [SquircleShape](../-squircle-shape/index.md) |

## Constructors

| | |
|---|---|
| [SquircleBasedShape](-squircle-based-shape.md) | [common]<br>constructor(topStart: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), topEnd: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), bottomStart: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), bottomEnd: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), cornerSmoothing: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [bottomEnd](../-squircle-shape/index.md#1966986353%2FProperties%2F618366653) | [common]<br>val [bottomEnd](../-squircle-shape/index.md#1966986353%2FProperties%2F618366653): [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html) |
| [bottomStart](../-squircle-shape/index.md#-1075495158%2FProperties%2F618366653) | [common]<br>val [bottomStart](../-squircle-shape/index.md#-1075495158%2FProperties%2F618366653): [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html) |
| [cornerSmoothing](corner-smoothing.md) | [common]<br>val [cornerSmoothing](corner-smoothing.md): [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html) |
| [topEnd](../-squircle-shape/index.md#-1123846061%2FProperties%2F618366653) | [common]<br>val [topEnd](../-squircle-shape/index.md#-1123846061%2FProperties%2F618366653): [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html) |
| [topStart](../-squircle-shape/index.md#751923820%2FProperties%2F618366653) | [common]<br>val [topStart](../-squircle-shape/index.md#751923820%2FProperties%2F618366653): [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html) |

## Functions

| Name | Summary |
|---|---|
| [copy](../-squircle-shape/index.md#-687837593%2FFunctions%2F618366653) | [common]<br>fun [copy](../-squircle-shape/index.md#-687837593%2FFunctions%2F618366653)(all: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html)): [CornerBasedShape](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerBasedShape.html)<br>abstract fun [copy](index.md#-960527653%2FFunctions%2F618366653)(topStart: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), topEnd: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), bottomEnd: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), bottomStart: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html)): [CornerBasedShape](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerBasedShape.html) |
| [createOutline](../-squircle-shape/index.md#-467427088%2FFunctions%2F618366653) | [common]<br>override fun [createOutline](../-squircle-shape/index.md#-467427088%2FFunctions%2F618366653)(size: [Size](https://developer.android.com/reference/kotlin/androidx/compose/ui/geometry/Size.html), layoutDirection: [LayoutDirection](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/LayoutDirection.html), density: [Density](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Density.html)): [Outline](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Outline.html)<br>abstract fun [createOutline](index.md#743168536%2FFunctions%2F618366653)(size: [Size](https://developer.android.com/reference/kotlin/androidx/compose/ui/geometry/Size.html), topStart: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), topEnd: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), bottomEnd: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), bottomStart: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), layoutDirection: [LayoutDirection](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/LayoutDirection.html)): [Outline](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Outline.html) |
| [lerp](../-squircle-shape/index.md#1230018832%2FFunctions%2F618366653) | [common]<br>open override fun [lerp](../-squircle-shape/index.md#1230018832%2FFunctions%2F618366653)(other: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, t: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)): [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)? |