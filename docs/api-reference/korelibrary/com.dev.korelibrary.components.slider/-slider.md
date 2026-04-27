//[korelibrary](../../index.md)/[com.dev.korelibrary.components.slider](index.md)/[Slider](-slider.md)

# Slider

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [Slider](-slider.md)(value: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;onValueChange: ([Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true,<br>&nbsp;&nbsp;&nbsp;&nbsp;valueRange: [ClosedFloatingPointRange](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.ranges/-closed-floating-point-range/index.html)&lt;[Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)&gt; = 0f..100f,<br>&nbsp;&nbsp;&nbsp;&nbsp;thickness: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = SliderDefaults.defaultSliderHeight,<br>&nbsp;&nbsp;&nbsp;&nbsp;shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = SliderDefaults.defaultSliderShape,<br>&nbsp;&nbsp;&nbsp;&nbsp;colors: [SliderColors](-slider-colors/index.md) = SliderDefaults.defaultSliderColors())

Slider allow user to make selection from a range of values

#### Parameters

common

| | |
|---|---|
| value | the current value of the slide [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html) |
| onValueChange | the callback that is called when the value changes i.e. when user slides the slider |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to the slider |
| enabled | the [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) value which decides the slider is enabled or not i.e. the user can slide or not if false the user can't interact with slider |
| valueRange | the value range of the slider i.e. the minimum and maximum value of the slider |
| thickness | the thickness of the slider [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) |
| shape | the shape of the slider [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| colors | the colors of the slider. Use [SliderDefaults.defaultSliderColors](-slider-defaults/default-slider-colors.md) to customize |