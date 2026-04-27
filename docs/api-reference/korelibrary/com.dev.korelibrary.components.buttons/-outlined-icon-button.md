//[korelibrary](../../index.md)/[com.dev.korelibrary.components.buttons](index.md)/[OutlinedIconButton](-outlined-icon-button.md)

# OutlinedIconButton

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [OutlinedIconButton](-outlined-icon-button.md)(onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true,<br>&nbsp;&nbsp;&nbsp;&nbsp;shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = CircleShape,<br>&nbsp;&nbsp;&nbsp;&nbsp;interactionSource: [MutableInteractionSource](https://developer.android.com/reference/kotlin/androidx/compose/foundation/interaction/MutableInteractionSource.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;outlinedIconButtonColors: [IconButtonColors](-icon-button-colors/index.md) = IconButtonDefaults.outlinedIconButtonColors(),<br>&nbsp;&nbsp;&nbsp;&nbsp;border: [BorderStroke](https://developer.android.com/reference/kotlin/androidx/compose/foundation/BorderStroke.html) = BorderStroke(width = 1.dp,<br>&nbsp;&nbsp;&nbsp;&nbsp;color = if (enabled)outlinedIconButtonColors.outlinedBorderColor!! else outlinedIconButtonColors.disabledOutlinedBorderColor!!),<br>&nbsp;&nbsp;&nbsp;&nbsp;content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

A medium-emphasis IconButton with an outlined border use this composable for alternate actions or secondary actions

#### Parameters

common

| | |
|---|---|
| onClick | the action to perform when this component is clicked |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to OutlinedIconButton |
| enabled | controls the enabled state of this component. When `false`, this component will not respond to user input [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| shape | the shape of the OutlinedIconButton [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| interactionSource | the [MutableInteractionSource](https://developer.android.com/reference/kotlin/androidx/compose/foundation/interaction/MutableInteractionSource.html) representing the stream of interactions for this Composable |
| outlinedIconButtonColors | the colors of the OutlinedIconButtons [IconButtonColors](-icon-button-colors/index.md) |
| content | the content of the Icon, typically an Icon [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |