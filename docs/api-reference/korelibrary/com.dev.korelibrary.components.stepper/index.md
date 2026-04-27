//[korelibrary](../../index.md)/[com.dev.korelibrary.components.stepper](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [StepperDefaults](-stepper-defaults/index.md) | [common]<br>object [StepperDefaults](-stepper-defaults/index.md)<br>StepperDefaults defines all the default values for [Stepper](-stepper.md) |

## Functions

| Name | Summary |
|---|---|
| [Stepper](-stepper.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [Stepper](-stepper.md)(label: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), decrementButton: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), incrementIcon: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, separator: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = StepperDefaults.defaultStepperShape, containerColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) = StepperDefaults.defaultContainerColor, border: [BorderStroke](https://developer.android.com/reference/kotlin/androidx/compose/foundation/BorderStroke.html)? = null, minLabelWidth: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = StepperDefaults.minimumLabelWidth, labelPaddingValues: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = StepperDefaults.defaultLabelPaddingValues, separatorPaddingValues: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = StepperDefaults.defaultSeparatorPaddingValues)<br>horizontal layout component that groups a decrement button, a central label, and an increment button. Use a `Stepper` when users need to make small, precise adjustments to a continuous or discrete |