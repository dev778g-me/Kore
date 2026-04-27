//[korelibrary](../../index.md)/[com.dev.korelibrary.components.checkbox](index.md)/[CheckBox](-check-box.md)

# CheckBox

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [CheckBox](-check-box.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, checked: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), onCheckChange: ([Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = CheckBoxDefaults.defaultCheckBoxShape, borderWidth: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = CheckBoxDefaults.defaultCheckBoxBorderWidth, colors: [CheckBoxColors](-check-box-colors/index.md) = CheckBoxDefaults.defaultCheckBoxColors(), interactionSource: [MutableInteractionSource](https://developer.android.com/reference/kotlin/androidx/compose/foundation/interaction/MutableInteractionSource.html)? = null)

A CheckBox is an input control that allows user to select one or more options.

#### Parameters

common

| | |
|---|---|
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to CheckBox |
| checked | the current checked state of the CheckBox [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| onCheckChange | the callback invoked when the CheckBox is checked or unchecked |
| enabled | the enabled state of the CheckBox [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| shape | the shape of the CheckBox [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| colors | the colors of the CheckBox [CheckBoxColors](-check-box-colors/index.md) |
| interactionSource | the [MutableInteractionSource](https://developer.android.com/reference/kotlin/androidx/compose/foundation/interaction/MutableInteractionSource.html) representing the stream of Interactions |