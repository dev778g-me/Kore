//[korelibrary](../../index.md)/[com.dev.korelibrary.components.loadingIndicator](index.md)/[CircularLoadingIndicator](-circular-loading-indicator.md)

# CircularLoadingIndicator

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [CircularLoadingIndicator](-circular-loading-indicator.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, size: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = LoadingIndicatorDefaults.defaultCircularLoadingSize, cap: [StrokeCap](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/StrokeCap.html) = LoadingIndicatorDefaults.defaultStrokeCap, thickness: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = LoadingIndicatorDefaults.defaultCircularLoadingIndicatorStrokeWidth, colors: [LoadingIndicatorColors](-loading-indicator-colors/index.md) = LoadingIndicatorDefaults.circularLoadingIndicatorColors())

A visual indicator that represents an ongoing task with an unspecified wait time . uses a circular indicator to signal the user that the app is working.

#### Parameters

common

| | |
|---|---|
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to LinearLoadingIndicator. |
| size | the size of CircularLoadingIndicator [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) |
| cap | the visual shape at the end of the progress line [StrokeCap](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/StrokeCap.html). |
| thickness | the thickness of the indicator [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) |
| colors | the colors of the indicator [LoadingIndicatorColors](-loading-indicator-colors/index.md) |