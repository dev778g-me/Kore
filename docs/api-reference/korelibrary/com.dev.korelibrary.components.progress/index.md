//[korelibrary](../../index.md)/[com.dev.korelibrary.components.progress](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ProgressIndicatorColors](-progress-indicator-colors/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [ProgressIndicatorColors](-progress-indicator-colors/index.md)(val trackColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val progressColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)) |
| [ProgressIndicatorDefaults](-progress-indicator-defaults/index.md) | [common]<br>object [ProgressIndicatorDefaults](-progress-indicator-defaults/index.md) |

## Functions

| Name | Summary |
|---|---|
| [CircularProgressIndicator](-circular-progress-indicator.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [CircularProgressIndicator](-circular-progress-indicator.md)(progress: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, thickness: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = ProgressIndicatorDefaults.defaultCircularBarThickness, size: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = ProgressIndicatorDefaults.defaultCircularProgressBarSize, cap: [StrokeCap](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/StrokeCap.html) = ProgressIndicatorDefaults.defaultProgressBarCap, colors: [ProgressIndicatorColors](-progress-indicator-colors/index.md) = ProgressIndicatorDefaults.circularProgressColors())<br>A circular visual Indicator that represents actual progress of a task with a known time uses a horizontal line that fills as the progress of the task increases . |
| [LinearProgressIndicator](-linear-progress-indicator.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [LinearProgressIndicator](-linear-progress-indicator.md)(progress: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, thickness: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = ProgressIndicatorDefaults.defaultProgressBarThickness, cap: [StrokeCap](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/StrokeCap.html) = ProgressIndicatorDefaults.defaultProgressBarCap, colors: [ProgressIndicatorColors](-progress-indicator-colors/index.md) = ProgressIndicatorDefaults.barProgressColors())<br>A visual Indicator that represents actual progress of a task with a known time uses a horizontal line that fills as the progress of the task increases . |