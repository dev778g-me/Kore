package com.dev.themebuilder.ui.docs

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.accordion.Accordion
import com.dev.korelibrary.components.accordion.AccordionDefaults
import com.dev.korelibrary.components.icon.Icon
import com.dev.korelibrary.components.stack.VerticalStack
import com.dev.korelibrary.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.bold.CaretDownBold

@Composable
fun AccordionDocs(
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
    ) {
        DefaultMarkdownParser(
            content = """# Accordion 

An Accordion is a vertically stacked list of headers that user click to expand or collapse, revealing or hiding content panels. <br>

When to use Accordions :
- FAQ,
- Product Features
- Data filtering / Forms 

When not to avoid Accordion :
- Minimal Content 
- frequently accessed content
- Critical Information 

> For deeper reference, check out [Mobbin](https://mobbin.com/glossary/accordion) guide on accordions.

<figure><img src="showcases/accordion_showcase.png" alt="Accordion example image "><figcaption></figcaption></figure>



## Basic Example 


| Slot | Description |
|------|-------------|
| `header` | Always visible. Acts as the trigger. |
| `expandedContent` | Hidden by default. Revealed when expanded. |
| `trailingIcon` | Rendered horizontally alongside the header — typically an arrow or chevron icon. |

clicking the header toggles the `expaned` (hoisted) state, which shows or hides the `expandedContent`
"""
        )

        ComponentShowcase(
            code = """
var showAccordion by remember { mutableStateOf(false) }

Accordion(
    expanded = showAccordion,
    onExpand = {
        showAccordion = !showAccordion
    },
    header = {
        Text("Octopuses have three hearts and blue blood")
    },
    expandedContent = {
        Text(
            "Two hearts pump blood to the gills, while the third pumps it to the rest of the body."
        )
    },
    trailingIcon = {
        Icon(
            imageVector = PhIcons.Bold.CaretDownBold,
            contentDescription = "idk"
        )
    }
)

""".trimIndent(),
            content = {
                var showAccordion by remember { mutableStateOf(false) }
                Accordion(
                    expanded = showAccordion,
                    onExpand = {
                        showAccordion = !showAccordion
                    },
                    header = {
                        Text("Octopuses have three hearts and blue blood")
                    },
                    expandedContent = {
                        Text(
                            "Two hearts pump blood to the gills, while the third pumps it to the rest of the body."
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = PhIcons.Bold.CaretDownBold,
                            contentDescription = "idk"
                        )
                    }
                )
            }
        )

        DefaultMarkdownParser(
            content = """
## Styling

`Accordion` exposes several parameters to customize its appearance and layout.

### Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `expanded` | `Boolean` | — | Controls whether the content is visible. |
| `onExpand` | `() -> Unit` | — | Called when the header is clicked. |
| `modifier` | `Modifier` | `Modifier` | Applied to the root container. |
| `header` | `@Composable () -> Unit` | — | The always-visible trigger content. |
| `expandedContent` | `@Composable () -> Unit` | — | The content revealed when expanded. |
| `trailingIcon` | `@Composable () -> Unit` | — | Icon rendered on the right of the header. |
| `leadingIcon` | `@Composable () -> Unit` | `null` | Icon rendered on the left of the header. |
| `separator` | `Boolean` | `true` | Shows a divider between the header and expanded content. |
| `enterTransition` | `EnterTransition` | `AccordionDefaults.defaultExpandedContentEnterTransition` | Animation played when content expands. |
| `exitTransition` | `ExitTransition` | `AccordionDefaults.defaultExpandedContentExitTransition` | Animation played when content collapses. |
| `leadingIconAlignment` | `Alignment.Vertical` | `AccordionDefaults.defaultLeadingIconAlignment` | Vertical alignment of the leading icon. |
| `headerContentPaddingValues` | `PaddingValues` | `AccordionDefaults.defaultHeaderContentPadding` | Padding applied to the header slot. |
| `expandedContentPaddingValues` | `PaddingValues` | `AccordionDefaults.defaultExpandedContentPadding` | Padding applied to the expanded content slot. |

### Custom Transitions

You can override the default expand/collapse animations:
"""
        )

        ComponentShowcase(
            code = """
Accordion(
    expanded = showAccordion,
    onExpand = { showAccordion = !showAccordion },
    enterTransition = expandVertically(animationSpec = tween(400)),
    exitTransition = shrinkVertically(animationSpec = tween(400)),
    header = { Text("Octopuses have three hearts and blue blood") },
    expandedContent = {
        Text("Two hearts pump blood to the gills, while the third pumps it to the rest of the body.")
    },
    trailingIcon = {
        Icon(imageVector = PhIcons.Bold.CaretDownBold, contentDescription = null)
    }
)
""".trimIndent(),
            content = {
                var showAccordion by remember { mutableStateOf(false) }
                Accordion(
                    expanded = showAccordion,
                    onExpand = { showAccordion = !showAccordion },
                    enterTransition = expandVertically(animationSpec = tween(400)),
                    exitTransition = shrinkVertically(animationSpec = tween(400)),
                    header = { Text("Octopuses have three hearts and blue blood") },
                    expandedContent = {
                        Text("Two hearts pump blood to the gills, while the third pumps it to the rest of the body.")
                    },
                    trailingIcon = {
                        Icon(imageVector = PhIcons.Bold.CaretDownBold, contentDescription = null)
                    }
                )
            }
        )

        DefaultMarkdownParser(
            content = """
### Custom Padding

"""
        )

        ComponentShowcase(
            code = """
Accordion(
    expanded = showAccordion,
    onExpand = { showAccordion = !showAccordion },
    headerContentPaddingValues = PaddingValues(horizontal = 20.dp, vertical = 16.dp),
    expandedContentPaddingValues = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
    header = { Text("Octopuses have three hearts and blue blood") },
    expandedContent = {
        Text("Two hearts pump blood to the gills, while the third pumps it to the rest of the body.")
    },
    trailingIcon = {
        Icon(imageVector = PhIcons.Bold.CaretDownBold, contentDescription = null)
    }
)
""".trimIndent(),
            content = {
                var showAccordion by remember { mutableStateOf(false) }
                Accordion(
                    expanded = showAccordion,
                    onExpand = { showAccordion = !showAccordion },
                    headerContentPaddingValues = PaddingValues(horizontal = 20.dp, vertical = 16.dp),
                    expandedContentPaddingValues = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
                    header = { Text("Octopuses have three hearts and blue blood") },
                    expandedContent = {
                        Text("Two hearts pump blood to the gills, while the third pumps it to the rest of the body.")
                    },
                    trailingIcon = {
                        Icon(imageVector = PhIcons.Bold.CaretDownBold, contentDescription = null)
                    }
                )
            }
        )
    }
}