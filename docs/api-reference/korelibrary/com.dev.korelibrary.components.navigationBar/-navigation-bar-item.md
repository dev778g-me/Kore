//[korelibrary](../../index.md)/[com.dev.korelibrary.components.navigationBar](index.md)/[NavigationBarItem](-navigation-bar-item.md)

# NavigationBarItem

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [RowScope](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/RowScope.html).[NavigationBarItem](-navigation-bar-item.md)(selected: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;icon: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;label: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true,<br>&nbsp;&nbsp;&nbsp;&nbsp;indicatorShape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = NavigationBarDefaults.defaultNavigationItemShape,<br>&nbsp;&nbsp;&nbsp;&nbsp;iconLabelSpacing: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = NavigationBarDefaults.defaultIconLabelSpacing,<br>&nbsp;&nbsp;&nbsp;&nbsp;colors: [NavigationBarItemColor](-navigation-bar-item-color/index.md) = NavigationBarDefaults.defaultNavigationBarColors(),<br>&nbsp;&nbsp;&nbsp;&nbsp;interactionSource: [MutableInteractionSource](https://developer.android.com/reference/kotlin/androidx/compose/foundation/interaction/MutableInteractionSource.html) = remember { MutableInteractionSource() })

NavigationBarItem is an individual item within a [NavigationBar](-navigation-bar.md)

#### Parameters

common

| | |
|---|---|
| selected | the boolean state which decides item selected nature [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| onClick | the callback to be invoked when this item is clicked |
| icon | the icon of the item [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |
| label | the label of the item [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied on the item |
| enabled | the boolean state which decides item enabled nature [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| indicatorShape | the shape of the indicator [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| iconLabelSpacing | the spacing between icon and label [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) |
| colors | the colors of the item. Use [NavigationBarDefaults.defaultNavigationBarColors](-navigation-bar-defaults/default-navigation-bar-colors.md) to change colors |
| interactionSource | the interaction source of the item [MutableInteractionSource](https://developer.android.com/reference/kotlin/androidx/compose/foundation/interaction/MutableInteractionSource.html) |