//[korelibrary](../../index.md)/[com.dev.korelibrary.components.buttons](index.md)/[PrimaryButton](-primary-button.md)

# PrimaryButton

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [PrimaryButton](-primary-button.md)(onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true,<br>&nbsp;&nbsp;&nbsp;&nbsp;contentPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = ButtonDefaults.defaultButtonPadding(),<br>&nbsp;&nbsp;&nbsp;&nbsp;colors: [ButtonColors](-button-colors/index.md) = ButtonDefaults.primaryButtonColors(),<br>&nbsp;&nbsp;&nbsp;&nbsp;shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = ButtonDefaults.defaultButtonShape,<br>&nbsp;&nbsp;&nbsp;&nbsp;content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[RowScope](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/RowScope.html).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Primary button is a highly prominent button for primary actions / actions which you want user to do

#### Parameters

common

| | |
|---|---|
| onClick | the callback to be invoked when PrimaryButton is clicked |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied on PrimaryButton |
| enabled | the boolean state which decides tab enabled nature [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| contentPadding | the contentPaddingValues of PrimaryButton [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) |
| colors | the colors of the buttons  [ButtonColors](-button-colors/index.md) |
| shape | the shape of the button  [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| content | the content to be displayed on the PrimaryButton [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |