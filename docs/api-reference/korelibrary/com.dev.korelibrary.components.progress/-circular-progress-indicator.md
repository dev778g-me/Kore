//[korelibrary](../../index.md)/[com.dev.korelibrary.components.progress](index.md)/[CircularProgressIndicator](-circular-progress-indicator.md)

# CircularProgressIndicator

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [CircularProgressIndicator](-circular-progress-indicator.md)(progress: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, thickness: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = ProgressIndicatorDefaults.defaultCircularBarThickness, size: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = ProgressIndicatorDefaults.defaultCircularProgressBarSize, cap: [StrokeCap](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/StrokeCap.html) = ProgressIndicatorDefaults.defaultProgressBarCap, colors: [ProgressIndicatorColors](-progress-indicator-colors/index.md) = ProgressIndicatorDefaults.circularProgressColors())

A circular visual Indicator that represents actual progress of a task with a known time uses a horizontal line that fills as the progress of the task increases .

#### Parameters

common

| | |
|---|---|
| progress | the current progress of the task |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to the CircularProgressIndicator |
| thickness | the thickness of the CircularProgressIndicator |
| cap | the visual shape at the end of the line |
| colors | the colors of the CircularProgressIndicator |