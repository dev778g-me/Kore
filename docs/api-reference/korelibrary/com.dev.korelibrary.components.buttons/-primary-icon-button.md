//[korelibrary](../../index.md)/[com.dev.korelibrary.components.buttons](index.md)/[PrimaryIconButton](-primary-icon-button.md)

# PrimaryIconButton

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [PrimaryIconButton](-primary-icon-button.md)(onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = CircleShape, interactionSource: [MutableInteractionSource](https://developer.android.com/reference/kotlin/androidx/compose/foundation/interaction/MutableInteractionSource.html)? = null, primaryIconButtonColors: [IconButtonColors](-icon-button-colors/index.md) = IconButtonDefaults.primaryIconButtonColors(), content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

A highly prominent IconButton use this composable for the primary tasks / important tasks on a screen

#### Parameters

common

| | |
|---|---|
| onClick | the action to perform when this component is clicked |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to PrimaryIconButton |
| enabled | controls the enabled state of this component. When `false`, this component will not respond to user input [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| shape | the shape of the PrimaryIconButton [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| interactionSource | the [MutableInteractionSource](https://developer.android.com/reference/kotlin/androidx/compose/foundation/interaction/MutableInteractionSource.html) representing the stream of interactions for this Composable |
| primaryIconButtonColors | the colors of the PrimaryIconButtons [IconButtonColors](-icon-button-colors/index.md) |
| content | the content of the ICon, typically an Icon [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |