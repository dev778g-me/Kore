//[korelibrary](../../index.md)/[com.dev.korelibrary.components.buttons](index.md)/[GhostIconButton](-ghost-icon-button.md)

# GhostIconButton

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [GhostIconButton](-ghost-icon-button.md)(onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true,<br>&nbsp;&nbsp;&nbsp;&nbsp;shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = CircleShape,<br>&nbsp;&nbsp;&nbsp;&nbsp;interactionSource: [MutableInteractionSource](https://developer.android.com/reference/kotlin/androidx/compose/foundation/interaction/MutableInteractionSource.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

A low-emphasis transparent IconButton use this composable for very low priority actions / optional actiions in the screen

#### Parameters

common

| | |
|---|---|
| onClick | the action to perform when this component is clicked |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to GhostIconButton |
| enabled | controls the enabled state of this component. When `false`, this component will not respond to user input [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| shape | the shape of the GhostIconButton [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| interactionSource | the [MutableInteractionSource](https://developer.android.com/reference/kotlin/androidx/compose/foundation/interaction/MutableInteractionSource.html) representing the stream of interactions for this Composable |
| content | the content of the Icon, typically an Icon [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |