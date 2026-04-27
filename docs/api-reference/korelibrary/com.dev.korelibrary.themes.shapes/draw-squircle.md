//[korelibrary](../../index.md)/[com.dev.korelibrary.themes.shapes](index.md)/[drawSquircle](draw-squircle.md)

# drawSquircle

[common]\
fun [DrawScope](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/drawscope/DrawScope.html).[drawSquircle](draw-squircle.md)(color: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), topLeft: [Offset](https://developer.android.com/reference/kotlin/androidx/compose/ui/geometry/Offset.html) = Offset.Zero, size: [Size](https://developer.android.com/reference/kotlin/androidx/compose/ui/geometry/Size.html), topLeftCorner: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), topRightCorner: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), bottomLeftCorner: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), bottomRightCorner: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), cornerSmoothing: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html) = 0.72f, style: [DrawStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/drawscope/DrawStyle.html) = Fill, alpha: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html) = 1.0f, colorFilter: [ColorFilter](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/ColorFilter.html)? = null, blendMode: [BlendMode](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/BlendMode.html) = DrawScope.DefaultBlendMode)

Draws a Squircle with the given [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html). Whether the Squircle is filled or stroked (or both) is controlled by [Paint.style](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Paint.html#style).

#### Parameters

common

| | |
|---|---|
| color | The color to be applied to the Squircle. |
| topLeft | Offset from the local origin of 0, 0 relative to the current translation. |
| size | Dimensions of the Squircle to draw. |
| topLeftCorner | The top left corner radius in pixels. |
| topRightCorner | The top right corner radius in pixels. |
| bottomLeftCorner | The bottom left corner radius in pixels. |
| bottomRightCorner | The bottom right corner radius in pixels. |
| cornerSmoothing | (0.55f - rounded corner shape, 1f - fully pronounced squircle). |
| alpha | Opacity to be applied to Squircle from 0.0f to 1.0f representing fully transparent to fully opaque respectively. |
| style | Specifies whether the Squircle is stroked or filled in. |
| colorFilter | ColorFilter to apply to the [color](draw-squircle.md) when drawn into the destination. |
| blendMode | Blending algorithm to be applied to the color. |

[common]\
fun [DrawScope](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/drawscope/DrawScope.html).[drawSquircle](draw-squircle.md)(brush: [Brush](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Brush.html), topLeft: [Offset](https://developer.android.com/reference/kotlin/androidx/compose/ui/geometry/Offset.html) = Offset.Zero, size: [Size](https://developer.android.com/reference/kotlin/androidx/compose/ui/geometry/Size.html), topLeftCorner: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), topRightCorner: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), bottomLeftCorner: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), bottomRightCorner: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), cornerSmoothing: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html) = 0.67f, style: [DrawStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/drawscope/DrawStyle.html) = Fill, alpha: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html) = 1.0f, colorFilter: [ColorFilter](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/ColorFilter.html)? = null, blendMode: [BlendMode](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/BlendMode.html) = DrawScope.DefaultBlendMode)

Draws a Squircle with the given [Brush](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Brush.html). Whether the Squircle is filled or stroked (or both) is controlled by [Paint.style](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Paint.html#style).

#### Parameters

common

| | |
|---|---|
| brush | The brush to be applied to the Squircle. |
| topLeft | Offset from the local origin of 0, 0 relative to the current translation. |
| size | Dimensions of the Squircle to draw. |
| topLeftCorner | The top left corner radius in pixels. |
| topRightCorner | The top right corner radius in pixels. |
| bottomLeftCorner | The bottom left corner radius in pixels. |
| bottomRightCorner | The bottom right corner radius in pixels. |
| cornerSmoothing | (0.55f - rounded corner shape, 1f - fully pronounced squircle). |
| alpha | Opacity to be applied to Squircle from 0.0f to 1.0f representing fully transparent to fully opaque respectively. |
| style | Specifies whether the Squircle is stroked or filled in. |
| colorFilter | ColorFilter to apply to the [brush](draw-squircle.md) when drawn into the destination. |
| blendMode | Blending algorithm to be applied to the color. |