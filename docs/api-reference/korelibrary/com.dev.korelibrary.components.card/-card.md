//[korelibrary](../../index.md)/[com.dev.korelibrary.components.card](index.md)/[Card](-card.md)

# Card

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [Card](-card.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = CardDefaults.defaultCardShape,<br>&nbsp;&nbsp;&nbsp;&nbsp;colors: [CardColors](-card-colors/index.md) = CardDefaults.defaultCardColors(),<br>&nbsp;&nbsp;&nbsp;&nbsp;elevation: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = CardDefaults.defaultCardElevation,<br>&nbsp;&nbsp;&nbsp;&nbsp;contentPaddingValues: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = CardDefaults.defaultCardContentPaddingValues,<br>&nbsp;&nbsp;&nbsp;&nbsp;content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[ColumnScope](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/ColumnScope.html).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

A container that groups related and action together

#### Parameters

common

| | |
|---|---|
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied on the Card |
| shape | the shape of the Card [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| colors | the colors of the Card [CardColors](-card-colors/index.md) |
| elevation | the elevation of the Card [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) |
| contentPaddingValues | the padding values of the contents inside the Card [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) |
| content | the content of the Card [Composable](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/ColumnScope.html) |