//[korelibrary](../../index.md)/[com.dev.korelibrary.components.buttons](index.md)/[SecondaryIconButton](-secondary-icon-button.md)

# SecondaryIconButton

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [SecondaryIconButton](-secondary-icon-button.md)(onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = CircleShape, interactionSource: [MutableInteractionSource](https://developer.android.com/reference/kotlin/androidx/compose/foundation/interaction/MutableInteractionSource.html)? = null, secondaryIconButtonColors: [IconButtonColors](-icon-button-colors/index.md) = IconButtonDefaults.secondaryIconButtonColors(), content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

A medium-emphasis IconButton use this composable for actions that shouldn't draw much attention as PrimaryIconButton / secondaryActions

#### Parameters

common

| | |
|---|---|
| onClick | the action to perform when this component is clicked |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to SecondaryIconButton |
| enabled | controls the enabled state of this component. When `false`, this component will not respond to user input [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| shape | the shape of the SecondaryIconButton [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| interactionSource | the [MutableInteractionSource](https://developer.android.com/reference/kotlin/androidx/compose/foundation/interaction/MutableInteractionSource.html) representing the stream of interactions for this Composable |
| secondaryIconButtonColors | the colors of the SecondaryIconButtons [IconButtonColors](-icon-button-colors/index.md) |
| content | the content of the Icon, typically an Icon [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |