package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.kore.components.buttons.SecondaryIconButton
import com.dev.kore.components.card.Card
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.listtile.ListTile
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.components.textFields.OutlinedTextField
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.colors.TailwindColors
import com.dev.kore.utilities.modifiers.blueprintGrid
import com.dev.kore.utilities.modifiers.clearFocusOnTap
import com.dev.kore.utilities.modifiers.dashedBorder
import com.dev.kore.utilities.modifiers.dotBorder
import com.dev.kore.utilities.modifiers.horizontalFadingEdges
import com.dev.kore.utilities.modifiers.magneticPull
import com.dev.kore.utilities.modifiers.noRippleClickable
import com.dev.kore.utilities.modifiers.scaleClickable
import com.dev.kore.utilities.modifiers.shimmer
import com.dev.kore.utilities.modifiers.verticalFadingEdges
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Plus

@Composable
fun ModifierExtensionDocs(
    modifier: Modifier = Modifier,
) {
    VerticalStack {
        DefaultMarkdownParser(
            content = """# Modifiers

set of custom modifiers to enhance composables with advanced interactions and animations.



## Modifier.dashedBorder()

A custom drawing modifier that paints a dashed border around the composable .
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.size(200.dp)
        .dashedBorder(
            color = KoreTheme.colorScheme.backGroundVariant,
            shape = KoreTheme.shapes.sm
        )
    ) {

    }""".trimIndent()
        ) {
            Card(
                modifier = Modifier.size(200.dp)
                    .dashedBorder(
                        color = KoreTheme.colorScheme.backGroundVariant,
                        shape = KoreTheme.shapes.sm
                    )
            ) { }
        }

        DefaultMarkdownParser(
            content = """### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `color` | `Color` | — | The color applied to the painted dashed segments of the border. |
| `thickness` | `Dp` | `1.dp` | The stroke width or thickness of the border line. |
| `dashLength` | `Dp` | `6.dp` | The visual length of each individual painted dash. |
| `gapLength` | `Dp` | `4.dp` | The length of the empty, transparent space between consecutive dashes. |
| `shape` | `Shape` | — | The exact geometric shape the dashed border should outline and follow. |

---

## Modifier.dashedBorder() (Brush Overload)

An extension of the dashed border modifier that accepts a `Brush` instead of a static `Color`. 

This overload allows you to apply linear, radial, or sweep gradients to your dashed borders.
"""
        )

        ComponentShowcase(
            code = """ Card(
    modifier = Modifier.size(200.dp)
        .dashedBorder(
            brush = Brush.verticalGradient(
                colors = listOf(
                    TailwindColors.Blue.swatch600,
                    TailwindColors.Rose.swatch600,
                )
            ),
            shape = KoreTheme.shapes.sm
        )
) {

}""".trimIndent()
        ) {
            Card(
                modifier = Modifier.size(200.dp)
                    .dashedBorder(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                TailwindColors.Blue.swatch600,
                                TailwindColors.Rose.swatch600,
                            )
                        ),
                        shape = KoreTheme.shapes.sm
                    )
            ) { }
        }

        DefaultMarkdownParser(
            content = """### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `brush` | `Brush` | — | The gradient brush (e.g., `Brush.linearGradient`) applied across the dashed segments of the border. |
| `thickness` | `Dp` | `1.dp` | The stroke width or thickness of the border line. |
| `dashLength` | `Dp` | `6.dp` | The visual length of each individual painted dash. |
| `gapLength` | `Dp` | `4.dp` | The length of the empty, transparent space between consecutive dashes. |
| `shape` | `Shape` | — | The exact geometric shape the dashed border should outline and follow. |

---

## Modifier.dotBorder()

A custom drawing modifier that paints a dotted line along the perimeter of a component. 
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.size(200.dp)
        .dotBorder(
            dotRadius = 1.5.dp,
            color = KoreTheme.colorScheme.backGroundVariant,
            shape = KoreTheme.shapes.sm
        )
) {

}""".trimIndent()
        ) {
            Card(
                modifier = Modifier.size(200.dp)
                    .dotBorder(
                        dotRadius = 1.5.dp,
                        color = KoreTheme.colorScheme.backGroundVariant,
                        shape = KoreTheme.shapes.sm
                    )
            ) { }
        }

        DefaultMarkdownParser(
            content = """### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `color` | `Color` | — | The color applied to the circular dots of the border. |
| `dotRadius` | `Dp` | `1.dp` | The radius of each individual dot. The total border thickness will be twice this value. |
| `gapLength` | `Dp` | `4.dp` | The length of the empty, transparent space between the edges of consecutive dots. |
| `shape` | `Shape` | — | The exact geometric shape (e.g., `RectangleShape`, `RoundedCornerShape`) the dotted border should outline and follow. |

---

## Modifier.dotBorder() (Brush Overload)

An extension of the dotted border modifier that accepts a `Brush` instead of a static `Color`. 

This overload allows you to map gradients smoothly across the individual dots.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.size(200.dp)
        .dotBorder(
            dotRadius = 1.5.dp,
            brush = Brush.verticalGradient(
                colors = listOf(
                    TailwindColors.Blue.swatch600,
                    TailwindColors.Rose.swatch600,
                )
            ),
            shape = KoreTheme.shapes.sm
        )
) {

}""".trimIndent()
        ) {
            Card(
                modifier = Modifier.size(200.dp)
                    .dotBorder(
                        dotRadius = 1.5.dp,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                TailwindColors.Blue.swatch600,
                                TailwindColors.Rose.swatch600,
                            )
                        ),
                        shape = KoreTheme.shapes.sm
                    )
            ) { }
        }

        DefaultMarkdownParser(
            content = """### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `brush` | `Brush` | — | The gradient brush (e.g., `Brush.sweepGradient`) applied smoothly across the circular dots. |
| `dotRadius` | `Dp` | `1.dp` | The radius of each individual dot. The total border thickness will be twice this value. |
| `gapLength` | `Dp` | `4.dp` | The length of the empty, transparent space between the edges of consecutive dots. |

---

## Modifier.scaleClickable()

A click modifier that animates the scale of the composable when it pressed.

the composable element shrinks or grows depending on the param `pressedScale` and upon release it returns to original scale .
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.size(200.dp)
       .scaleClickable(pressedScale = 0.85f, onClick = {/* Handle click */})
       .dashedBorder(
          color = KoreTheme.colorScheme.backGroundVariant,
          shape = KoreTheme.shapes.sm
    )
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Click to Scale")
    }
}""".trimIndent()
        ) {
            Card(
                modifier = Modifier.size(200.dp)
                    .scaleClickable(pressedScale = 0.85f, onClick = {})
                    .dashedBorder(
                        color = KoreTheme.colorScheme.backGroundVariant,
                        shape = KoreTheme.shapes.sm
                    )
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Click to Scale")
                }
            }
        }

        DefaultMarkdownParser(
            content = """### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `pressedScale` | `Float` | `0.95f` | The target scale factor applied to the component while it is actively being pressed. |
| `onClick` | `() -> Unit` | — | The callback to be invoked when the component is successfully clicked. |
| `role` | `Role?` | `null` | The semantic role of the clickable element (e.g., `Role.Button`), used by accessibility services. |
| `animationSpec` | `AnimationSpec<Float>?` | `null` | The animation configuration used to transition smoothly between the normal and pressed scale states. |
| `interactionSource` | `MutableInteractionSource?` | `null` | Hoisted stream of interactions (like press states) allowing you to observe or modify the interaction events. |

---

## Modifier.noRippleClickable()

A click modifier that registers touch and click events while completely suppressing the default ripple effect (or any other visual indication).
"""
        )

        ComponentShowcase(
            code = """ var clickCounter by remember { mutableStateOf(0) }
    Card(
        modifier = Modifier.size(200.dp)
            .noRippleClickable( onClick = {
                clickCounter ++
            })
            .dashedBorder(
                color = KoreTheme.colorScheme.backGroundVariant,
                shape = KoreTheme.shapes.sm
            )
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
             text ="Click to Increment\n${'$'}clickCounter",
             textAlign = TextAlign.Center,
             lineHeight = 20.sp
           )
        }
    }""".trimIndent()
        ) {
            var clickCounter by remember { mutableStateOf(0) }
            Card(
                modifier = Modifier.size(200.dp)
                    .noRippleClickable(onClick = { clickCounter++ })
                    .dashedBorder(
                        color = KoreTheme.colorScheme.backGroundVariant,
                        shape = KoreTheme.shapes.sm
                    )
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Click to Increment\n$clickCounter",
                        textAlign = TextAlign.Center,
                        lineHeight = 20.sp
                    )
                }
            }
        }

        DefaultMarkdownParser(
            content = """### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `onClick` | `() -> Unit` | — | The callback to be invoked when the component is clicked. |
| `enabled` | `Boolean` | `true` | Controls whether the component is interactive. If false, clicks are ignored. |
| `role` | `Role?` | `null` | The semantic role of the clickable element (e.g., `Role.Button`), used by accessibility services. |
| `interactionSource` | `MutableInteractionSource?` | `null` | Hoisted stream of interactions allowing you to observe or modify the interaction events. |

---

## Modifier.magneticPull()

A physics-based interaction modifier that creates a playful, spring-like effect. When a user touches and drags on the component, the element translates slightly toward the active pointer location, mimicking a magnetic attraction or a rubber-band tension.
"""
        )

        ComponentShowcase(
            code = """   Card(
    modifier = Modifier.size(200.dp)
        .magneticPull()
        .dashedBorder(
            color = KoreTheme.colorScheme.backGroundVariant,
            shape = KoreTheme.shapes.sm
        )
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Drag Me")
    }
}""".trimIndent()
        ) {
            Card(
                modifier = Modifier.size(200.dp)
                    .magneticPull()
                    .dashedBorder(
                        color = KoreTheme.colorScheme.backGroundVariant,
                        shape = KoreTheme.shapes.sm
                    )
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Drag Me")
                }
            }
        }

        DefaultMarkdownParser(
            content = """### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `pullStrength` | `Float` | `20f` | Determines the resistance of the magnetic pull. Higher values result in less movement towards the pointer. |

---

## Modifier.blueprintGrid()

A custom drawing modifier that renders a repeating dotted grid behind the component's content.
"""
        )

        ComponentShowcase(
            code = """   Card(
    modifier = Modifier.size(200.dp)
        .dashedBorder(
            color = KoreTheme.colorScheme.backGroundVariant,
            shape = KoreTheme.shapes.sm
        )
) {
    Box(modifier = Modifier.fillMaxSize().blueprintGrid(), contentAlignment = Alignment.Center) {

    }
}""".trimIndent()
        ) {
            Card(
                modifier = Modifier.size(200.dp)
                    .dashedBorder(
                        color = KoreTheme.colorScheme.backGroundVariant,
                        shape = KoreTheme.shapes.sm
                    )
            ) {
                Box(modifier = Modifier.fillMaxSize().blueprintGrid(), contentAlignment = Alignment.Center) { }
            }
        }

        DefaultMarkdownParser(
            content = """### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `gridSize` | `Dp` | `16.dp` | The spacing between the centers of each dot in the grid. |
| `dotRadius` | `Dp` | `1.dp` | The size (radius) of each individual dot. |
| `dotColor` | `Color` | `Color.Black` | The color applied to the drawn dots. |

---

## Modifier.shimmer()

A state indicator modifier that applies a continuous, sweeping shimmer animation across the component (shimmer effect or skeleton loading effect).
"""
        )

        ComponentShowcase(
            code = """ Card(
    modifier = Modifier.size(200.dp)
        .dashedBorder(
            color = KoreTheme.colorScheme.backGroundVariant,
            shape = KoreTheme.shapes.sm
        )
) {
    Box(modifier = Modifier.fillMaxSize().shimmer(shape = KoreTheme.shapes.sm), contentAlignment = Alignment.Center) {

    }
}""".trimIndent()
        ) {
            Card(
                modifier = Modifier.size(200.dp)
                    .dashedBorder(
                        color = KoreTheme.colorScheme.backGroundVariant,
                        shape = KoreTheme.shapes.sm
                    )
            ) {
                Box(modifier = Modifier.fillMaxSize().shimmer(shape = KoreTheme.shapes.sm), contentAlignment = Alignment.Center) { }
            }
        }

        DefaultMarkdownParser(
            content = """### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `colors` | `List<Color>?` | `null` | The colors used for the shimmer gradient. Defaults to a 3-step gradient using `KoreTheme` background variants. |
| `shape` | `Shape?` | `null` | The clipping shape for the shimmer background. Defaults to `KoreTheme.shapes.md`. |

---

## Modifier.clearFocusOnTap()

A utility modifier that clears the active focus state when the component is tapped.

This modifier is incredibly useful for form screens and input-heavy UIs. By applying it to a parent container (like a Box or Column), you can allow users to dismiss the software keyboard and drop focus from a TextField simply by tapping anywhere on the empty background space.
"""
        )

        ComponentShowcase(
            code = """ var inputText by remember { mutableStateOf("") }
    Card(
        modifier = Modifier.height(400.dp).fillMaxWidth()
            .clearFocusOnTap()
            .dashedBorder(
                color = KoreTheme.colorScheme.backGroundVariant,
                shape = KoreTheme.shapes.sm
            )
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            OutlinedTextField(
                value = inputText,
                label = {
                    Text("Enter Text here")
                },
                placeholder = {
                    Text("Tap outside to clear focus")
                },
                onValueChange = {
                    inputText = it
                }
            )
        }
    }""".trimIndent()
        ) {
            var inputText by remember { mutableStateOf("") }
            Card(
                modifier = Modifier.height(400.dp).fillMaxWidth()
                    .clearFocusOnTap()
                    .dashedBorder(
                        color = KoreTheme.colorScheme.backGroundVariant,
                        shape = KoreTheme.shapes.sm
                    )
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    OutlinedTextField(
                        value = inputText,
                        label = { Text("Enter Text here") },
                        placeholder = { Text("Tap outside to clear focus") },
                        onValueChange = { inputText = it }
                    )
                }
            }
        }

        DefaultMarkdownParser(
            content = """---

## Modifier.verticalFadingEdges()

A custom drawing modifier that applies a smooth, gradient fade to the top and bottom edges of a layout.

This is incredibly useful for scrollable lists (like LazyColumn or a vertically scrolling Column) to visually indicate to the user that there is more content to scroll through
"""
        )

        ComponentShowcase(
            code = """ LazyColumn(
    modifier = Modifier.height(400.dp)
        .verticalFadingEdges(0.1f)
) {
    items(30){
        ListTile(
            modifier = Modifier.padding(
                vertical = 2.dp
            ),
            leading = {
                Icon(
                    tint = KoreTheme.colorScheme.primary,
                    imageVector = PhIcons.Regular.Scroll,
                    contentDescription = null
                )
            },
            title = {
                Text("Scroll me")
            }
        )
    }
}""".trimIndent()
        ) {
            LazyColumn(
                modifier = Modifier.height(400.dp)
                    .verticalFadingEdges(0.1f)
            ) {
                items(30) {
                    ListTile(
                        modifier = Modifier.padding(vertical = 2.dp),
                        leading = {
                            Icon(
                                tint = KoreTheme.colorScheme.primary,
                                imageVector = PhIcons.Regular.Plus,
                                contentDescription = null
                            )
                        },
                        title = { Text("Scroll me") }
                    )
                }
            }
        }

        DefaultMarkdownParser(
            content = """###  Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `fadePercentage` | `Float` | `0.05f` | The percentage of the component's **height** to fade at the top and bottom (ranges from `0f` to `1f`). |
| `edgeColor` | `Color` | `Color.Transparent` | The color at the absolute top and bottom edges. Must have `0f` alpha for a true fade. |
| `solidColor` | `Color` | `Color.Black` | The color mask used for the fully visible center area. Must have `1f` alpha. |

---

## Modifier.horizontalFadingEdges()

A custom drawing modifier that applies a smooth, gradient fade to the left and right edges of a layout.

This is the perfect companion for carousels, LazyRow components, or horizontally scrolling rows to visually hint to the user that more content is available off-screen
"""
        )

        ComponentShowcase(
            code = """ LazyRow (
    modifier = Modifier
        .horizontalFadingEdges(0.1f)
) {
    items(30) {

        SecondaryIconButton(
            modifier = Modifier.padding(
                horizontal = 8.dp
            ),
            onClick = {}
        ) {
            Icon(
                tint = KoreTheme.colorScheme.primary,
                imageVector = PhIcons.Regular.Scroll,
                contentDescription = null
            )
        }
    }
 }""".trimIndent()
        ) {
            LazyRow(
                modifier = Modifier
                    .horizontalFadingEdges(0.1f)
            ) {
                items(30) {
                    SecondaryIconButton(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onClick = {}
                    ) {
                        Icon(
                            tint = KoreTheme.colorScheme.primary,
                            imageVector = PhIcons.Regular.Plus,
                            contentDescription = null
                        )
                    }
                }
            }
        }

        DefaultMarkdownParser(
            content = """###  Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `fadePercentage` | `Float` | `0.05f` | The percentage of the component's **width** to fade at the left and right edges (ranges from `0f` to `1f`). |
| `edgeColor` | `Color` | `Color.Transparent` | The color at the absolute left and right edges. Must have `0f` alpha for a true fade. |
| `solidColor` | `Color` | `Color.Black` | The color mask used for the fully visible center area. Must have `1f` alpha. |
"""
        )
    }
}
