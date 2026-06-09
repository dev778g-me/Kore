package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.GhostButton
import com.dev.kore.components.separators.HorizontalDashedSeparator
import com.dev.kore.components.separators.HorizontalDottedDivider
import com.dev.kore.components.separators.HorizontalSeparator
import com.dev.kore.components.separators.VerticalDashedSeparator
import com.dev.kore.components.separators.VerticalDottedSeparator
import com.dev.kore.components.separators.VerticalSeparator
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme

@Composable
fun SeparatorDocs(
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
    ) {
        DefaultMarkdownParser(
            content = """# Separators

A Separator (often called a Divider) is a thin, structural line used to group related content or create clear visual distinctions between different sections of a layout. 

You can use Separators for:
- Dividing individual items within a continuous list or menu.
- Separating distinct structural sections of a screen (e.g., separating a header from the main content).
- Creating visual breaks in tightly packed data structures.

When not to use Separators:
- If standard whitespace, padding, or elevation is enough to establish a clear visual hierarchy (overusing separators can create unnecessary visual noise).


> For deeper reference check out [Mobbin](https://mobbin.com/glossary/divider) guide on Separator(Divider)

---

## Horizontal Separator

The `HorizontalSeparator` draws a line from left to right. By default, it fills the maximum width of its parent container.

### Basic Example 

<figure><img src="showcases/separatorShowcase/horizontal_separator.png" alt="Horizontal Separator"><figcaption></figcaption></figure>

"""
        )

        ComponentShowcase(
            code = """
Column(modifier = Modifier.fillMaxWidth()) {
    Text("Account Details", modifier = Modifier.padding(16.dp))
    
    // Default 1.dp horizontal line
    HorizontalSeparator()
    
    Text("Security Settings", modifier = Modifier.padding(16.dp))
}
""".trimIndent(),
            content = {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text("Account Details", modifier = Modifier.padding(16.dp))
                    HorizontalSeparator()
                    Text("Security Settings", modifier = Modifier.padding(16.dp))
                }
            }
        )

        DefaultMarkdownParser(
            content = """
### Parameters

Both the solid color and gradient brush overloads share these base parameters:

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | Applied to the root canvas of the separator. |
| `thickness` | `Dp` | `SeparatorDefaults.defaultSeparatorThickness` | The height/thickness of the horizontal line. |
| `separatorCap` | `StrokeCap` | `SeparatorDefaults.defaultSeparatorCap` | The visual treatment at the ends of the line (defaults to `Round`). |
| `color` | `Color` | `SeparatorDefaults.defaultSeparatorColor` | The solid color of the separator. |
| `brush` | `Brush` | — | *(Overload)* A gradient brush used instead of a solid color. |

---

## Vertical Separator

The `VerticalSeparator` draws a line from top to bottom. By default, it attempts to fill the maximum height of its parent container. 

*Tip: For `fillMaxHeight()` to work correctly, the parent `Row` must have a defined height. A common approach is setting the parent to `Modifier.height(IntrinsicSize.Min)`.*

### Basic Example

<figure><img src="showcases/separatorShowcase/vertical_separators.png" alt="Vertical Separator"><figcaption></figcaption></figure>

"""
        )

        ComponentShowcase(
            code = """
Row(
    modifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Min)
        .padding(vertical = 8.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly
) {
    GhostButton(onClick = { /* ... */ }) { 
        Text("Like") 
    }

    VerticalSeparator(
        modifier = Modifier.padding(vertical = 8.dp)
    )

    GhostButton(onClick = { /* ... */ }) { 
        Text("Comment") 
    }

    VerticalSeparator(
        modifier = Modifier.padding(vertical = 8.dp)
    )

    GhostButton(onClick = { /* ... */ }) { 
        Text("Share") 
    }
}
""".trimIndent(),
            content = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly
                ) {
                    GhostButton(onClick = { }) { 
                        Text("Like") 
                    }

                    VerticalSeparator(
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    GhostButton(onClick = { }) { 
                        Text("Comment") 
                    }

                    VerticalSeparator(
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    GhostButton(onClick = { }) { 
                        Text("Share") 
                    }
                }
            }
        )

        DefaultMarkdownParser(
            content = """
### Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | Applied to the root canvas of the separator. |
| `thickness` | `Dp` | `SeparatorDefaults.defaultSeparatorThickness` | The width/thickness of the vertical line. |
| `separatorCap` | `StrokeCap` | `SeparatorDefaults.defaultSeparatorCap` | The visual treatment at the ends of the line. |
| `color` | `Color` | `SeparatorDefaults.defaultSeparatorColor` | The solid color of the separator. |
| `brush` | `Brush` | — | *(Overload)* A gradient brush used instead of a solid color. |

---

## Horizontal Dotted Divider

The `HorizontalDottedDivider` draws a horizontal line of dots. Useful for subtle visual separation with a softer appearance.

"""
        )

        ComponentShowcase(
            code = """
HorizontalDottedDivider(
    dotRadius = 3.dp,
    dotGap = 6.dp,
    color = KoreTheme.colorScheme.primary
)
""".trimIndent(),
            content = {
                HorizontalDottedDivider(
                    dotRadius = 3.dp,
                    dotGap = 6.dp,
                    color = KoreTheme.colorScheme.primary
                )
            }
        )

        DefaultMarkdownParser(
            content = """
### Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | Applied to the root canvas. |
| `dotRadius` | `Dp` | `2.dp` | Radius of each dot. |
| `dotGap` | `Dp` | `4.dp` | Gap between dots. |
| `color` | `Color` | `backGroundVariant` | Solid color of the dots. |

---

## Horizontal Dashed Separator

The `HorizontalDashedSeparator` draws a dashed line from left to right. Customize dash length and gap between dashes.

"""
        )

        ComponentShowcase(
            code = """
HorizontalDashedSeparator(
    thickness = 2.dp,
    dashLength = 8.dp,
    dashGap = 4.dp,
    color = KoreTheme.colorScheme.primary
)
""".trimIndent(),
            content = {
                HorizontalDashedSeparator(
                    thickness = 2.dp,
                    dashLength = 8.dp,
                    dashGap = 4.dp,
                    color = KoreTheme.colorScheme.primary
                )
            }
        )

        DefaultMarkdownParser(
            content = """
### Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | Applied to the root canvas. |
| `thickness` | `Dp` | `1.dp` | Height of the separator. |
| `dashLength` | `Dp` | `4.dp` | Length of each dash. |
| `dashGap` | `Dp` | `4.dp` | Gap between dashes. |
| `separatorCap` | `StrokeCap` | `Round` | Treatment at dash ends. |
| `color` | `Color` | `backGroundVariant` | Solid color of the separator. |

---

## Vertical Dotted Divider

The `VerticalDottedDivider` draws a vertical line of dots from top to bottom.

"""
        )

        ComponentShowcase(
            code = """
Row(
    modifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Min)
        .padding(vertical = 8.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly
) {
    Text("A")
    VerticalDottedSeparator(
        dotRadius = 3.dp,
        dotGap = 6.dp,
        color = KoreTheme.colorScheme.primary
    )
    Text("B")
}
""".trimIndent(),
            content = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly
                ) {
                    Text("A")
                    VerticalDottedSeparator(
                        dotRadius = 3.dp,
                        dotGap = 6.dp,
                        color = KoreTheme.colorScheme.primary
                    )
                    Text("B")
                }
            }
        )

        DefaultMarkdownParser(
            content = """
### Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | Applied to the root canvas. |
| `dotRadius` | `Dp` | `2.dp` | Radius of each dot. |
| `dotGap` | `Dp` | `4.dp` | Gap between dots. |
| `color` | `Color` | `backGroundVariant` | Solid color of the dots. |

---

## Vertical Dashed Separator

The `VerticalDashedSeparator` draws a dashed line from top to bottom.

"""
        )

        ComponentShowcase(
            code = """
Row(
    modifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Min)
        .padding(vertical = 8.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly
) {
    Text("Left")
    VerticalDashedSeparator(
        thickness = 2.dp,
        dashLength = 6.dp,
        dashGap = 4.dp,
        color = KoreTheme.colorScheme.primary
    )
    Text("Right")
}
""".trimIndent(),
            content = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly
                ) {
                    Text("Left")
                    VerticalDashedSeparator(
                        thickness = 2.dp,
                        dashLength = 6.dp,
                        dashGap = 4.dp,
                        color = KoreTheme.colorScheme.primary
                    )
                    Text("Right")
                }
            }
        )

        DefaultMarkdownParser(
            content = """
### Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | Applied to the root canvas. |
| `thickness` | `Dp` | `1.dp` | Width of the separator. |
| `dashLength` | `Dp` | `4.dp` | Length of each dash. |
| `dashGap` | `Dp` | `4.dp` | Gap between dashes. |
| `separatorCap` | `StrokeCap` | `Round` | Treatment at dash ends. |
| `color` | `Color` | `backGroundVariant` | Solid color of the separator. |

---

## Styling

Your API allows for deep customization, including changing the line endings (`StrokeCap`) and applying rich gradients using Compose's `Brush` API.

### Thick, Custom Colored Line

<figure><img src="showcases/separatorShowcase/thick_separator.png" alt="Horizontal thick Separator"><figcaption></figcaption></figure>

"""
        )

        ComponentShowcase(
            code = """
HorizontalSeparator(
    thickness = 4.dp,
    separatorCap = StrokeCap.Square,
    color = KoreTheme.colorScheme.primary
)
""".trimIndent(),
            content = {
                HorizontalSeparator(
                    thickness = 4.dp,
                    separatorCap = StrokeCap.Square,
                    color = KoreTheme.colorScheme.primary
                )
            }
        )




        DefaultMarkdownParser(
            content = """
### Gradient Separator

Using the overloaded API, you can pass a `Brush` to create smooth, fading transitions. This is excellent for creating elegant, modern dividers that fade out at the edges.

Every separator variant  solid, dashed, and dotted, both horizontal and vertical  has a **brush overload** that accepts a `Brush` instead of a `Color`. This allows you to apply gradients for more polished visuals.

"""
        )

        ComponentShowcase(
            code = """
HorizontalDashedSeparator(
    thickness = 2.dp,
    dashLength = 8.dp,
    dashGap = 4.dp,
    brush = Brush.horizontalGradient(
        colors = listOf(Color.Transparent, KoreTheme.colorScheme.primary, Color.Transparent)
    )
)
""".trimIndent(),
            content = {
                HorizontalDashedSeparator(
                    thickness = 2.dp,
                    dashLength = 8.dp,
                    dashGap = 4.dp,
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color.Transparent, KoreTheme.colorScheme.primary, Color.Transparent)
                    )
                )
            }
        )

        ComponentShowcase(
            code = """
HorizontalDottedDivider(
    dotRadius = 3.dp,
    dotGap = 6.dp,
    brush = Brush.horizontalGradient(
        colors = listOf(Color.Transparent, KoreTheme.colorScheme.primary, Color.Transparent)
    )
)
""".trimIndent(),
            content = {
                HorizontalDottedDivider(
                    dotRadius = 3.dp,
                    dotGap = 6.dp,
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color.Transparent, KoreTheme.colorScheme.primary, Color.Transparent)
                    )
                )
            }
        )


    }
}