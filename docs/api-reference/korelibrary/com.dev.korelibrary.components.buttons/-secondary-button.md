//[korelibrary](../../index.md)/[com.dev.korelibrary.components.buttons](index.md)/[SecondaryButton](-secondary-button.md)

# SecondaryButton

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [SecondaryButton](-secondary-button.md)(onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true,<br>&nbsp;&nbsp;&nbsp;&nbsp;contentPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = ButtonDefaults.defaultButtonPadding(),<br>&nbsp;&nbsp;&nbsp;&nbsp;colors: [ButtonColors](-button-colors/index.md) = ButtonDefaults.secondaryButtonColors(),<br>&nbsp;&nbsp;&nbsp;&nbsp;shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = ButtonDefaults.defaultButtonShape,<br>&nbsp;&nbsp;&nbsp;&nbsp;content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[RowScope](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/RowScope.html).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

SecondaryButton is a medium-emphasis button for action which are less important or less prominent

#### Parameters

common

| | |
|---|---|
| onClick | the callback invoked when the SecondaryButton is clicked |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to SecondaryButton |
| enabled | the boolean state which decides tab enabled nature [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| contentPadding | the contentPaddingValues of SecondaryButton [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) |
| colors | the colors of the SecondaryButton [ButtonColors](-button-colors/index.md) |
| shape | the shape of the button [shape](-secondary-button.md) |
| content | the content to be displayed on the SecondayButton |