//[korelibrary](../../index.md)/[com.dev.korelibrary.components.appbar](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [AppbarContents](-appbar-contents/index.md) | [common]<br>enum [AppbarContents](-appbar-contents/index.md) : [Enum](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-enum/index.html)&lt;[AppbarContents](-appbar-contents/index.md)&gt; |
| [AppBarDefaults](-app-bar-defaults/index.md) | [common]<br>object [AppBarDefaults](-app-bar-defaults/index.md) |

## Functions

| Name | Summary |
|---|---|
| [Appbar](-appbar.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [Appbar](-appbar.md)(title: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;navigationIcon: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;navigationIconAlignment: [Alignment.Vertical](https://developer.android.com/reference/kotlin/androidx/compose/ui/Alignment.Vertical.html) = Alignment.CenterVertically,<br>&nbsp;&nbsp;&nbsp;&nbsp;appBarAction: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[RowScope](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/RowScope.html).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;appBarAlignment: [Alignment.Vertical](https://developer.android.com/reference/kotlin/androidx/compose/ui/Alignment.Vertical.html) = Alignment.CenterVertically,<br>&nbsp;&nbsp;&nbsp;&nbsp;windowInsets: [WindowInsets](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/WindowInsets.html) = WindowInsets.statusBars,<br>&nbsp;&nbsp;&nbsp;&nbsp;contentPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = AppBarDefaults.defaultTopAppBarPadding,<br>&nbsp;&nbsp;&nbsp;&nbsp;minimumAppBarHeight: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = AppBarDefaults.defaultAppBarMinimumHeight,<br>&nbsp;&nbsp;&nbsp;&nbsp;elevation: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = AppBarDefaults.defaultAppBarElevation)<br>AppBar is the header component at the top of the screen that provides navigation & actions |