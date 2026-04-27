//[korelibrary](../../index.md)/[com.dev.korelibrary.components.card](index.md)/[OutlinedCard](-outlined-card.md)

# OutlinedCard

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [OutlinedCard](-outlined-card.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = CardDefaults.defaultCardShape,<br>&nbsp;&nbsp;&nbsp;&nbsp;colors: [CardColors](-card-colors/index.md) = CardDefaults.defaultOutlinedCardColors(),<br>&nbsp;&nbsp;&nbsp;&nbsp;borderStroke: [BorderStroke](https://developer.android.com/reference/kotlin/androidx/compose/foundation/BorderStroke.html) = CardDefaults.defaultOutlinedBorderStroke,<br>&nbsp;&nbsp;&nbsp;&nbsp;elevation: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = CardDefaults.defaultCardElevation,<br>&nbsp;&nbsp;&nbsp;&nbsp;contentPaddingValues: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = CardDefaults.defaultCardContentPaddingValues,<br>&nbsp;&nbsp;&nbsp;&nbsp;content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[ColumnScope](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/ColumnScope.html).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

A container with border that groups related contents and action together

#### Parameters

common

| | |
|---|---|
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied on the OutlinedCard |
| shape | the shape of the OutlinedCard [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| elevation | the elevation of the OutlinedCard [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) |
| contentPaddingValues | the paddingValues of the content inside the OutlinedCard [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) |
| content | the content of the OutlinedCard [Composable](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/ColumnScope.html) |