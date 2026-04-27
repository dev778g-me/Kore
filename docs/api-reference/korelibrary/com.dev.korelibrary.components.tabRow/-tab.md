//[korelibrary](../../index.md)/[com.dev.korelibrary.components.tabRow](index.md)/[Tab](-tab.md)

# Tab

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [Tab](-tab.md)(isSelected: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true,<br>&nbsp;&nbsp;&nbsp;&nbsp;contentPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = TabRowDefaults.defaultTabPadding,<br>&nbsp;&nbsp;&nbsp;&nbsp;iconPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = TabRowDefaults.defaultIconPaddingValues,<br>&nbsp;&nbsp;&nbsp;&nbsp;shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = TabRowDefaults.defaultTabShape,<br>&nbsp;&nbsp;&nbsp;&nbsp;selectedContentColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) = KoreTheme.colorScheme.onPrimary,<br>&nbsp;&nbsp;&nbsp;&nbsp;unselectedContentColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) = KoreTheme.colorScheme.onBackGround,<br>&nbsp;&nbsp;&nbsp;&nbsp;icon: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

A Tab is an individual interactive element within a Tab Row that represents a distinct, selectable panel of content or a specific view.

#### Parameters

common

| | |
|---|---|
| isSelected | the boolean state which decides tab selected nature [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| onClick | the callback to be invoked when this tab is clicked |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied on the tab |
| enabled | the boolean state which decides tab enabled nature [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| contentPadding | the contentPadding values of the tab [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) |
| iconPadding | the iconPadding values of the tab [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) |
| shape | the shape of the Tab |
| selectedContentColor | the selectedContentColor of the tab i.e. color of the content when tab is selected [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| unselectedContentColor | the unselectedContentColor of the tab i.e. color of the content when tab is not selected [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| icon | the icon of the tab [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |
| content | the content of the tab [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |