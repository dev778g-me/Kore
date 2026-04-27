//[korelibrary](../../index.md)/[com.dev.korelibrary.components.listItem](index.md)/[ListTile](-list-tile.md)

# ListTile

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [ListTile](-list-tile.md)(title: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;leading: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;leadingAlignment: [Alignment.Vertical](https://developer.android.com/reference/kotlin/androidx/compose/ui/Alignment.Vertical.html) = ListTileDefaults.defaultLeadingAlignment,<br>&nbsp;&nbsp;&nbsp;&nbsp;overline: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;subtitle: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;trailing: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;trailingAlignment: [Alignment.Vertical](https://developer.android.com/reference/kotlin/androidx/compose/ui/Alignment.Vertical.html) = ListTileDefaults.defaultTrailingAlignment,<br>&nbsp;&nbsp;&nbsp;&nbsp;shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = ListTileDefaults.defaultListTileShape,<br>&nbsp;&nbsp;&nbsp;&nbsp;colors: [ListTileColors](-list-tile-colors/index.md) = ListTileDefaults.defaultListTileColors(),<br>&nbsp;&nbsp;&nbsp;&nbsp;contentPaddingValues: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = ListTileDefaults.defaultListItemPaddingValues)

ListTile is a composable that lets you display a list item,

#### Parameters

common

| | |
|---|---|
| title | the title of the list Item [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to the list item |
| onClick | called when user clicks the tile. if null the tile will not be interactable and will not have ripple effects |
| leading | the leading content (often an image or icon) of the list tile which will be placed before the title in the row [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |
| leadingAlignment | the vertical alignment of the leading content with respect to the row |
| overline | the overline content . it will appear over the title of the list tile [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |
| subtitle | the subtitle of the list tile . it will appear below the title |
| trailing | the trailing content (often a switch or icon button) of the list tile which will be placed after the title in the row [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |
| trailingAlignment | the vertical alignment of the trailing content with respect to the row |
| shape | the shape of the list tile [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| colors | the colors of the List tile . to change color use [ListTileDefaults.defaultListTileColors](-list-tile-defaults/default-list-tile-colors.md) |
| contentPaddingValues | the padding values of the all content from the container of the list tile |