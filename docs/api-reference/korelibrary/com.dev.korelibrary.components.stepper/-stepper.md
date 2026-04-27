//[korelibrary](../../index.md)/[com.dev.korelibrary.components.stepper](index.md)/[Stepper](-stepper.md)

# Stepper

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [Stepper](-stepper.md)(label: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), decrementButton: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), incrementIcon: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, separator: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = StepperDefaults.defaultStepperShape, containerColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) = StepperDefaults.defaultContainerColor, border: [BorderStroke](https://developer.android.com/reference/kotlin/androidx/compose/foundation/BorderStroke.html)? = null, minLabelWidth: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = StepperDefaults.minimumLabelWidth, labelPaddingValues: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = StepperDefaults.defaultLabelPaddingValues, separatorPaddingValues: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = StepperDefaults.defaultSeparatorPaddingValues)

horizontal layout component that groups a decrement button, a central label, and an increment button. Use a `Stepper` when users need to make small, precise adjustments to a continuous or discrete

#### Parameters

common

| | |
|---|---|
| label | The central content displaying the current value, usually a `Text` composable. |
| decrementButton | The interactive component placed on the leading side, used to decrease the value. |
| incrementIcon | The interactive component placed on the trailing side, used to increase the value. |
| modifier | The [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to the stepper's outer container. |
| separator | If true, displays a vertical divider between the buttons and the central label. |
| shape | The geometric clipping shape of the stepper's outer container. |
| containerColor | The background color of the stepper container. |
| border | An optional border drawn around the outside of the stepper container. |
| minLabelWidth | The minimum width allocated for the [label](-stepper.md). Setting this prevents the buttons from shifting positions horizontally when the label text changes size (e.g., changing from &quot;9&quot; to &quot;10&quot;). |
| labelPaddingValues | The padding applied immediately around the [label](-stepper.md) content. |
| separatorPaddingValues | The vertical padding applied to the separators, controlling how close the divider lines get to the top and bottom edges of the container. |