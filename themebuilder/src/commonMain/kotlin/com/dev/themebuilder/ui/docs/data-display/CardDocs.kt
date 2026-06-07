package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.card.Card
import com.dev.kore.components.card.CardDefaults
import com.dev.kore.components.card.OutlinedCard
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme

@Composable
fun CardDocs(
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp)
    ) {
        DefaultMarkdownParser(
            content = """# Card 

A card is a container that groups related content and actions into a visually distinct unit.

When to use Card : 
- group related content
- interactive element
- collection or grids

When to avoid  Card :
- simple or minimal content
- large or complex layouts
- repetitive layouts


> For deeper reference, check out [Mobbin](https://mobbin.com/glossary/card) guide on Card.
## Basic Example

<figure><img src="showcases/cardShowcase/card_showcase.png" alt="Basic Card Example "><figcaption></figcaption></figure>


Because the `content` parameter provides a `ColumnScope`, any elements you place inside the Card will automatically stack vertically.

| Slot | Description |
|------|-------------|
| `content` | The core visual elements of the card. Arranged vertically by default. |

"""
        )

        ComponentShowcase(
            code = """
Card(
    modifier = Modifier.fillMaxWidth(),
    contentPaddingValues = PaddingValues(KoreTheme.sizes.md)
) {
    Text(
        text = "The Elder Scrolls V: Skyrim",
        color = KoreTheme.colorScheme.onBackGround,
        textStyle = KoreTheme.typography.title1
    )

    Spacer(modifier = Modifier.height(KoreTheme.sizes.sm))

    Text(
        text = "A dragon has returned to the ancient land of Skyrim. You are the Dragonborn  the only one who can absorb their souls and stop the apocalypse. Your legend begins now.",
        textStyle = KoreTheme.typography.body2
    )
}

""".trimIndent(),
            content = {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    contentPaddingValues = PaddingValues(KoreTheme.sizes.md)
                ) {
                    Text(
                        text = "The Elder Scrolls V: Skyrim",
                        color = KoreTheme.colorScheme.onBackGround,
                        textStyle = KoreTheme.typography.title1
                    )

                    Spacer(modifier = Modifier.height(KoreTheme.sizes.sm))

                    Text(
                        text = "A dragon has returned to the ancient land of Skyrim. You are the Dragonborn  the only one who can absorb their souls and stop the apocalypse. Your legend begins now.",
                        textStyle = KoreTheme.typography.body2
                    )
                }
            }
        )

        DefaultMarkdownParser(
            content = """
## Styling

The Card exposes several parameters to customize its elevation, shape, internal padding, and colors to fit different hierarchy needs.

### Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | Applied to the root container of the card. |
| `shape` | `Shape` | `CardDefaults.defaultCardShape` | Defines the clipping shape of the card (typically rounded corners). |
| `containerColor` | `Color` | `CardDefaults.defaultCardContainerColor` | The background color of the card container. |
| `contentColor` | `Color` | `CardDefaults.defaultCardContentColor` | The default color applied to content inside the card. |
| `elevation` | `Dp` | `CardDefaults.defaultCardElevation` | Controls the shadow cast by the card to communicate depth. |
| `contentAlignment` | `Alignment` | `Alignment.TopStart` | The vertical and horizontal alignment of content inside the card. |
| `contentPaddingValues` | `PaddingValues` | `CardDefaults.defaultCardContentPaddingValues` | The spacing applied internally between the card boundaries and the content. |
| `content` | `@Composable ColumnScope.() -> Unit` | — | The main content. Elements placed here are arranged vertically. |

## Outlined Card

If your screen is already complex and elevated shadows would create too much visual noise, use an `OutlinedCard`. This variant drops the heavy shadow and relies on a clean, customizable border stroke to define its boundaries.

### Basic Example

<figure><img src="showcases/cardShowcase/outlined_card.png" alt="Basic Outlined Card Example "><figcaption></figcaption></figure>



"""
        )

        ComponentShowcase(
            code = """
OutlinedCard(
    modifier = Modifier.fillMaxWidth(),
    contentPaddingValues = PaddingValues(KoreTheme.sizes.md)
) {
    Text(
        text = "Fus Ro Dah",
        color = KoreTheme.colorScheme.onBackGround,
        textStyle = KoreTheme.typography.title1
    )

    Spacer(modifier = Modifier.height(KoreTheme.sizes.xxs))

    Text(
        text = "The Thu'um — the ancient dragon language. Masters of the Voice can shout the very fabric of reality into submission.",
        textStyle = KoreTheme.typography.body2
    )
}
""".trimIndent(),
            content = {
                OutlinedCard(
                    modifier = Modifier.fillMaxWidth(),
                    contentPaddingValues = PaddingValues(KoreTheme.sizes.md)
                ) {
                    Text(
                        text = "Fus Ro Dah",
                        color = KoreTheme.colorScheme.onBackGround,
                        textStyle = KoreTheme.typography.title1
                    )

                    Spacer(modifier = Modifier.height(KoreTheme.sizes.xxs))

                    Text(
                        text = "The Thu'um — the ancient dragon language. Masters of the Voice can shout the very fabric of reality into submission.",
                        textStyle = KoreTheme.typography.body2
                    )
                }
            }
        )

        DefaultMarkdownParser(
            content = """
### Parameters

The `OutlinedCard` shares the same anatomy as the standard `Card`, but introduces a `borderStroke` parameter and uses a different default color scheme.

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | Applied to the root container of the card. |
| `shape` | `Shape` | `CardDefaults.defaultCardShape` | Defines the clipping shape of the card. |
| `containerColor` | `Color` | `CardDefaults.defaultOutlinedContainerColor` | The background color of the outlined card container. |
| `contentColor` | `Color` | `CardDefaults.defaultOutlinedContentColor` | The default color applied to content inside the card. |
| `borderStroke` | `BorderStroke` | `CardDefaults.defaultOutlinedBorderStroke` | The stroke drawn around the perimeter of the card container. |
| `elevation` | `Dp` | `CardDefaults.defaultCardElevation` | Controls shadow. Usually left at 0.dp for outlined variants. |
| `contentAlignment` | `Alignment` | `Alignment.TopStart` | The vertical and horizontal alignment of content inside the card. |
| `contentPaddingValues` | `PaddingValues` | `CardDefaults.defaultCardContentPaddingValues` | The spacing applied internally. |
| `content` | `@Composable ColumnScope.() -> Unit` | — | The main content. |

### Custom Border

You can easily override the `borderStroke` to emphasize the card, indicate a selection state, or match a specific brand color.

"""
        )

        ComponentShowcase(
            code = """
OutlinedCard(
    borderStroke = BorderStroke(width = 2.dp, color = KoreTheme.colorScheme.primary),
    modifier = Modifier.fillMaxWidth()
) {
    Text("Selected Item")
    Text("The thicker, colored border indicates this card is currently selected.")
}
""".trimIndent(),
            content = {
                OutlinedCard(
                    borderStroke = BorderStroke(width = 2.dp, color = KoreTheme.colorScheme.primary),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Selected Item", textStyle = KoreTheme.typography.title1, color = KoreTheme.colorScheme.primary)
                    Text("The thicker, colored border indicates this card is currently selected.")
                }
            }
        )
    }
}