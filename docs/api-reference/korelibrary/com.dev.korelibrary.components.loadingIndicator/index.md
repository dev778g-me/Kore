//[korelibrary](../../index.md)/[com.dev.korelibrary.components.loadingIndicator](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [LoadingIndicatorColors](-loading-indicator-colors/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [LoadingIndicatorColors](-loading-indicator-colors/index.md)(val trackColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val indicatorColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)) |
| [LoadingIndicatorDefaults](-loading-indicator-defaults/index.md) | [common]<br>object [LoadingIndicatorDefaults](-loading-indicator-defaults/index.md) |

## Functions

| Name | Summary |
|---|---|
| [CircularLoadingIndicator](-circular-loading-indicator.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [CircularLoadingIndicator](-circular-loading-indicator.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, size: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = LoadingIndicatorDefaults.defaultCircularLoadingSize, cap: [StrokeCap](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/StrokeCap.html) = LoadingIndicatorDefaults.defaultStrokeCap, thickness: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = LoadingIndicatorDefaults.defaultCircularLoadingIndicatorStrokeWidth, colors: [LoadingIndicatorColors](-loading-indicator-colors/index.md) = LoadingIndicatorDefaults.circularLoadingIndicatorColors())<br>A visual indicator that represents an ongoing task with an unspecified wait time . uses a circular indicator to signal the user that the app is working. |
| [LinearLoadingIndicator](-linear-loading-indicator.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [LinearLoadingIndicator](-linear-loading-indicator.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, thickness: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = LoadingIndicatorDefaults.defaultLinearLoadingIndicatorStrokeWidth, cap: [StrokeCap](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/StrokeCap.html) = LoadingIndicatorDefaults.defaultStrokeCap, colors: [LoadingIndicatorColors](-loading-indicator-colors/index.md) = LoadingIndicatorDefaults.linearLoadingIndictorColors())<br>A visual indicator that represents an ongoing task with an unspecified wait time . uses a horizontal line to signal the user that the app is working. |