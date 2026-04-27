//[korelibrary](../../index.md)/[com.dev.korelibrary.components.radio](index.md)/[RadioButton](-radio-button.md)

# RadioButton

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [RadioButton](-radio-button.md)(selected: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?, enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, colors: [RadioButtonColors](-radio-button-colors/index.md) = RadioButtonDefaults.defaultRadioColors(), interactionSource: [MutableInteractionSource](https://developer.android.com/reference/kotlin/androidx/compose/foundation/interaction/MutableInteractionSource.html)? = null)

Radio buttons let user select single options from a list of predefined options

#### Parameters

common

| | |
|---|---|
| selected | the [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) value which decides the radio is selected or not |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied on radioButton |
| onClick | the callback invoked when the radio button is clicked |
| enabled | the [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) value which decides the radio is enabled or not |
| colors | the colors of the radioButton [RadioButtonColors](-radio-button-colors/index.md) |
| interactionSource | the [MutableInteractionSource](https://developer.android.com/reference/kotlin/androidx/compose/foundation/interaction/MutableInteractionSource.html) of the radio button |