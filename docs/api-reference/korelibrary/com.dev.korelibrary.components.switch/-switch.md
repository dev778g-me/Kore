//[korelibrary](../../index.md)/[com.dev.korelibrary.components.switch](index.md)/[Switch](-switch.md)

# Switch

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [Switch](-switch.md)(checked: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;onCheckChange: ([Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?,<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true,<br>&nbsp;&nbsp;&nbsp;&nbsp;checkThumbContent: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;unCheckedThumbContent: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;transitionSpec: [AnimatedContentTransitionScope](https://developer.android.com/reference/kotlin/androidx/compose/animation/AnimatedContentTransitionScope.html)&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt;.() -&gt; [ContentTransform](https://developer.android.com/reference/kotlin/androidx/compose/animation/ContentTransform.html) = SwitchDefaults.defaultTransitionSpec,<br>&nbsp;&nbsp;&nbsp;&nbsp;trackShape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = SwitchDefaults.defaultTrackShape,<br>&nbsp;&nbsp;&nbsp;&nbsp;thumbShape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = SwitchDefaults.defaultThumbShape,<br>&nbsp;&nbsp;&nbsp;&nbsp;thumbSize: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = SwitchDefaults.defaultSwitchSize,<br>&nbsp;&nbsp;&nbsp;&nbsp;switchTrackWidth: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = SwitchDefaults.defaultSwitchTrackWidth,<br>&nbsp;&nbsp;&nbsp;&nbsp;switchTrackHeight: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = SwitchDefaults.defaultSwitchHeight,<br>&nbsp;&nbsp;&nbsp;&nbsp;thumbPadding: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = SwitchDefaults.thumbPadding,<br>&nbsp;&nbsp;&nbsp;&nbsp;switchColors: [SwitchColors](-switch-colors/index.md) = SwitchDefaults.defaultSwitchColors(),<br>&nbsp;&nbsp;&nbsp;&nbsp;interactionSource: [MutableInteractionSource](https://developer.android.com/reference/kotlin/androidx/compose/foundation/interaction/MutableInteractionSource.html)? = null)

Switch allows users to toggle state of a single item on or off

#### Parameters

common

| | |
|---|---|
| checked | the [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) state that controls either switch is checked or not |
| onCheckChange | the callback that is called when the checked state changes |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to the switch |
| enabled | controls the enabled state of the switch if false the user will not able to interact with the switch |
| checkThumbContent | the content of the thumb when the switch is checked . |
| unCheckedThumbContent | the content of the thumb when the switch is unchecked. |
| trackShape | the shape of the switch Container [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| thumbSize | the shape of the switch thumb [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| switchTrackWidth | the width of the switch container [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) |
| switchTrackHeight | the height of the switch container. [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) |
| thumbPadding | the padding of the thumb from the switch container [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) |
| switchColors | the colors of the switch. Use [SwitchDefaults.defaultSwitchColors](-switch-defaults/default-switch-colors.md) to change the colors. |
| interactionSource | the interaction source of the switch. |