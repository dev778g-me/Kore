//[korelibrary](../../index.md)/[com.dev.korelibrary.components.progress](index.md)/[LinearProgressIndicator](-linear-progress-indicator.md)

# LinearProgressIndicator

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [LinearProgressIndicator](-linear-progress-indicator.md)(progress: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;thickness: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = ProgressIndicatorDefaults.defaultProgressBarThickness,<br>&nbsp;&nbsp;&nbsp;&nbsp;cap: [StrokeCap](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/StrokeCap.html) = ProgressIndicatorDefaults.defaultProgressBarCap,<br>&nbsp;&nbsp;&nbsp;&nbsp;colors: [ProgressIndicatorColors](-progress-indicator-colors/index.md) = ProgressIndicatorDefaults.barProgressColors())

A visual Indicator that represents actual progress of a task with a known time uses a horizontal line that fills as the progress of the task increases .

#### Parameters

common

| | |
|---|---|
| progress | the current progress of the task |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to the LinearProgressIndicator |
| thickness | the thickness of the LinearProgressIndicator |
| cap | the visual shape at the end of the line |
| colors | the colors of the LinearProgressIndicator |