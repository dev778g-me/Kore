//[korelibrary](../../index.md)/[com.dev.korelibrary.components.buttons](index.md)/[OutlinedButton](-outlined-button.md)

# OutlinedButton

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [OutlinedButton](-outlined-button.md)(onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true,<br>&nbsp;&nbsp;&nbsp;&nbsp;contentPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = ButtonDefaults.defaultButtonPadding(),<br>&nbsp;&nbsp;&nbsp;&nbsp;colors: [ButtonColors](-button-colors/index.md) = ButtonDefaults.outlinedButtonColors(),<br>&nbsp;&nbsp;&nbsp;&nbsp;shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = ButtonDefaults.defaultButtonShape,<br>&nbsp;&nbsp;&nbsp;&nbsp;content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[RowScope](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/RowScope.html).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

OutlinedButton is a medium-emphasis button with a border around it for action which are less important or less prominent

#### Parameters

common

| | |
|---|---|
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to OutlinedButton |
| enabled | the boolean state which decides tab enabled nature [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| contentPadding | the contentPaddingValues of OutlinedButton [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) |
| colors | the colors of the OutlinedButton [ButtonColors](-button-colors/index.md) |
| shape | the shape of the button [shape](-outlined-button.md) |
| content | the content to be displayed on the OutlinedButton |