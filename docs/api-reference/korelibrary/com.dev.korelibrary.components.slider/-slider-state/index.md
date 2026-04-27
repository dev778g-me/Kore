//[korelibrary](../../../index.md)/[com.dev.korelibrary.components.slider](../index.md)/[SliderState](index.md)

# SliderState

[common]\
class [SliderState](index.md)(initialValue: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), onValueChange: ([Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), val valueRange: [ClosedFloatingPointRange](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.ranges/-closed-floating-point-range/index.html)&lt;[Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)&gt; = 0f..100f)

## Constructors

| | |
|---|---|
| [SliderState](-slider-state.md) | [common]<br>constructor(initialValue: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), onValueChange: ([Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), valueRange: [ClosedFloatingPointRange](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.ranges/-closed-floating-point-range/index.html)&lt;[Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)&gt; = 0f..100f) |

## Properties

| Name | Summary |
|---|---|
| [fraction](fraction.md) | [common]<br>val [fraction](fraction.md): [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html) |
| [onValueChange](on-value-change.md) | [common]<br>var [onValueChange](on-value-change.md): ([Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [range](range.md) | [common]<br>val [range](range.md): [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html) |
| [sliderValue](slider-value.md) | [common]<br>var [sliderValue](slider-value.md): [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html) |
| [sliderValueAnimatable](slider-value-animatable.md) | [common]<br>val [sliderValueAnimatable](slider-value-animatable.md): [Animatable](https://developer.android.com/reference/kotlin/androidx/compose/animation/core/Animatable.html)&lt;[Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), [AnimationVector1D](https://developer.android.com/reference/kotlin/androidx/compose/animation/core/AnimationVector1D.html)&gt; |
| [trackWidth](track-width.md) | [common]<br>var [trackWidth](track-width.md): [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html) |
| [valueRange](value-range.md) | [common]<br>val [valueRange](value-range.md): [ClosedFloatingPointRange](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.ranges/-closed-floating-point-range/index.html)&lt;[Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)&gt; |

## Functions

| Name | Summary |
|---|---|
| [animate](animate.md) | [common]<br>suspend fun [animate](animate.md)(fraction: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)) |
| [snapTo](snap-to.md) | [common]<br>suspend fun [snapTo](snap-to.md)(fraction: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)) |
| [updateNewValue](update-new-value.md) | [common]<br>fun [updateNewValue](update-new-value.md)(offsetX: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)): [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html) |