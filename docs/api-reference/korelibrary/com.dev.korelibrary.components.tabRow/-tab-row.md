//[korelibrary](../../index.md)/[com.dev.korelibrary.components.tabRow](index.md)/[TabRow](-tab-row.md)

# TabRow

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [TabRow](-tab-row.md)(selectedIndex: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, contentPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = TabRowDefaults.defaultTabRowPaddingValues, tabSpacing: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = TabRowDefaults.defaultTabSpacing, shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = TabRowDefaults.defaultTabRowShape, containerColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) = KoreTheme.colorScheme.backGroundVariant, indicatorColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) = KoreTheme.colorScheme.primary, indicatorShape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = TabRowDefaults.defaultIndicatorShape, indicator: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)(tabPositions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[TabPosition](-tab-position/index.md)&gt;) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = { tabPositions -&gt;
        TabIndicator(tabPositions[selectedIndex], indicatorColor = indicatorColor, shape = indicatorShape)
    }, tabs: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

A Tab row is a horizontal container that allows user to switch between multiple tabs here all Tabs have Equal width by default

#### Parameters

common

| | |
|---|---|
| selectedIndex | the index of currentSelectedTab [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to TabRow |
| shape | the Shape of the TabRow [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| tabSpacing | the horizontal spacing between Tabs |
| indicatorColor | the color of the tab indicator i.e - which indicates the current selected tab visually [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| indicatorShape | the shape of the tab indicator [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| indicator | the Tab indicator [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |
| tabs | the tabs in teh tab row [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |