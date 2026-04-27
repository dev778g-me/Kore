//[korelibrary](../../index.md)/[com.dev.korelibrary.components.radio](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [RadioButtonColors](-radio-button-colors/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [RadioButtonColors](-radio-button-colors/index.md)(val selectedColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val unSelectedColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val disabledSelectedColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val disabledUnSelectedColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html))<br>defines all colors for radiobutton |
| [RadioButtonDefaults](-radio-button-defaults/index.md) | [common]<br>object [RadioButtonDefaults](-radio-button-defaults/index.md)<br>RadioButtonDefaults defines the default values for RadioButton |

## Functions

| Name | Summary |
|---|---|
| [RadioButton](-radio-button.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [RadioButton](-radio-button.md)(selected: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?,<br>&nbsp;&nbsp;&nbsp;&nbsp;enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true,<br>&nbsp;&nbsp;&nbsp;&nbsp;colors: [RadioButtonColors](-radio-button-colors/index.md) = RadioButtonDefaults.defaultRadioColors(),<br>&nbsp;&nbsp;&nbsp;&nbsp;interactionSource: [MutableInteractionSource](https://developer.android.com/reference/kotlin/androidx/compose/foundation/interaction/MutableInteractionSource.html)? = null)<br>Radio buttons let user select single options from a list of predefined options |