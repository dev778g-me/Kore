//[korelibrary](../../index.md)/[com.dev.korelibrary.components.appbar](index.md)/[Appbar](-appbar.md)

# Appbar

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [Appbar](-appbar.md)(title: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;navigationIcon: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;navigationIconAlignment: [Alignment.Vertical](https://developer.android.com/reference/kotlin/androidx/compose/ui/Alignment.Vertical.html) = Alignment.CenterVertically,<br>&nbsp;&nbsp;&nbsp;&nbsp;appBarAction: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[RowScope](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/RowScope.html).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;appBarAlignment: [Alignment.Vertical](https://developer.android.com/reference/kotlin/androidx/compose/ui/Alignment.Vertical.html) = Alignment.CenterVertically,<br>&nbsp;&nbsp;&nbsp;&nbsp;windowInsets: [WindowInsets](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/WindowInsets.html) = WindowInsets.statusBars,<br>&nbsp;&nbsp;&nbsp;&nbsp;contentPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = AppBarDefaults.defaultTopAppBarPadding,<br>&nbsp;&nbsp;&nbsp;&nbsp;minimumAppBarHeight: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = AppBarDefaults.defaultAppBarMinimumHeight,<br>&nbsp;&nbsp;&nbsp;&nbsp;elevation: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = AppBarDefaults.defaultAppBarElevation)

AppBar is the header component at the top of the screen that provides navigation & actions

#### Parameters

common

| | |
|---|---|
| title | the title of the appbar [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to the appbar |
| navigationIcon | the navigation icon of the appbar [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |
| navigationIconAlignment | the alignment of the navigation icon [Alignment.Vertical](https://developer.android.com/reference/kotlin/androidx/compose/ui/Alignment.Vertical.html) |
| appBarAction | the actions of the appbar [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |
| appBarAlignment | the alignment of the appbar actions [Alignment.Vertical](https://developer.android.com/reference/kotlin/androidx/compose/ui/Alignment.Vertical.html) |
| windowInsets | the window insets of the appbar [WindowInsets](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/WindowInsets.html) |
| contentPadding | the content padding of the appbar [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) |
| minimumAppBarHeight | the minimum height of the appbar [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) |
| elevation | the elevation of the appbar [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) |