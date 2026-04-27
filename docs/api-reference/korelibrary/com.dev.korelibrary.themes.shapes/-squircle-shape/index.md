//[korelibrary](../../../index.md)/[com.dev.korelibrary.themes.shapes](../index.md)/[SquircleShape](index.md)

# SquircleShape

class [SquircleShape](index.md)(topStartCorner: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), topEndCorner: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), bottomStartCorner: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), bottomEndCorner: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), cornerSmoothing: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)) : [SquircleBasedShape](../-squircle-based-shape/index.md)

Creates a [SquircleBasedShape](../-squircle-based-shape/index.md).

#### Parameters

common

| | |
|---|---|
| topStartCorner | The top start corner radius defined as [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html). |
| topEndCorner | The top end corner radius defined as [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html). |
| bottomStartCorner | The bottom start corner radius defined as [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html). |
| bottomEndCorner | The bottom end corner radius defined as [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html). |
| cornerSmoothing | (0.55f - rounded corner shape, 1f - fully pronounced squircle). |

## Constructors

| | |
|---|---|
| [SquircleShape](-squircle-shape.md) | [common]<br>constructor(topStartCorner: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), topEndCorner: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), bottomStartCorner: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), bottomEndCorner: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), cornerSmoothing: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [bottomEnd](index.md#1966986353%2FProperties%2F618366653) | [common]<br>val [bottomEnd](index.md#1966986353%2FProperties%2F618366653): [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html) |
| [bottomStart](index.md#-1075495158%2FProperties%2F618366653) | [common]<br>val [bottomStart](index.md#-1075495158%2FProperties%2F618366653): [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html) |
| [cornerSmoothing](../-squircle-based-shape/corner-smoothing.md) | [common]<br>val [cornerSmoothing](../-squircle-based-shape/corner-smoothing.md): [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html) |
| [topEnd](index.md#-1123846061%2FProperties%2F618366653) | [common]<br>val [topEnd](index.md#-1123846061%2FProperties%2F618366653): [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html) |
| [topStart](index.md#751923820%2FProperties%2F618366653) | [common]<br>val [topStart](index.md#751923820%2FProperties%2F618366653): [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html) |

## Functions

| Name | Summary |
|---|---|
| [copy](index.md#-687837593%2FFunctions%2F618366653) | [common]<br>fun [copy](index.md#-687837593%2FFunctions%2F618366653)(all: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html)): [CornerBasedShape](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerBasedShape.html)<br>open override fun [copy](copy.md)(topStart: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), topEnd: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), bottomEnd: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html), bottomStart: [CornerSize](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerSize.html)): [SquircleShape](index.md) |
| [createOutline](index.md#-467427088%2FFunctions%2F618366653) | [common]<br>override fun [createOutline](index.md#-467427088%2FFunctions%2F618366653)(size: [Size](https://developer.android.com/reference/kotlin/androidx/compose/ui/geometry/Size.html), layoutDirection: [LayoutDirection](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/LayoutDirection.html), density: [Density](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Density.html)): [Outline](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Outline.html)<br>open override fun [createOutline](create-outline.md)(size: [Size](https://developer.android.com/reference/kotlin/androidx/compose/ui/geometry/Size.html), topStart: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), topEnd: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), bottomEnd: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), bottomStart: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), layoutDirection: [LayoutDirection](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/LayoutDirection.html)): [Outline](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Outline.html) |
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [lerp](index.md#1230018832%2FFunctions%2F618366653) | [common]<br>open override fun [lerp](index.md#1230018832%2FFunctions%2F618366653)(other: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, t: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)): [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)? |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |