//[korelibrary](../../index.md)/[com.dev.korelibrary.components.navigationBar](index.md)/[NavigationBar](-navigation-bar.md)

# NavigationBar

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [NavigationBar](-navigation-bar.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;containerColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) = KoreTheme.colorScheme.surface,<br>&nbsp;&nbsp;&nbsp;&nbsp;contentPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = NavigationBarDefaults.defaultNavigationBarPaddingValues,<br>&nbsp;&nbsp;&nbsp;&nbsp;content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[RowScope](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/RowScope.html).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

NavigationBar is bottom navigation that provides access to top-level destinations.

#### Parameters

common

| | |
|---|---|
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to NavigationBar |
| containerColor | the background color of the NavigationBar [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| contentPadding | the padding values of the NavigationBar [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) |
| content | the content of the NavigationBar [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |