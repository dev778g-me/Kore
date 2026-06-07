package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.kore.components.card.Card
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.extensions.alignCenter
import com.dev.kore.utilities.extensions.alignEnd
import com.dev.kore.utilities.extensions.bold
import com.dev.kore.utilities.extensions.color
import com.dev.kore.utilities.extensions.extraBold
import com.dev.kore.utilities.extensions.extraLight
import com.dev.kore.utilities.extensions.italic
import com.dev.kore.utilities.extensions.letterSpacing
import com.dev.kore.utilities.extensions.light
import com.dev.kore.utilities.extensions.lineHeight
import com.dev.kore.utilities.extensions.medium
import com.dev.kore.utilities.extensions.normal
import com.dev.kore.utilities.extensions.semiBold
import com.dev.kore.utilities.extensions.size
import com.dev.kore.utilities.extensions.strikethrough
import com.dev.kore.utilities.extensions.underline

@Composable
fun TextStyleExtensionDocs(
    modifier: Modifier = Modifier,
) {
    VerticalStack(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp)
    ) {
        DefaultMarkdownParser(
            content = """# TextStyle

A set of extension functions on `TextStyle` to fluently apply typography properties like font weight, size, decoration, alignment, and color.

---

## Font Weight
"""
        )

        DefaultMarkdownParser(
            content = """### TextStyle.bold()

Sets the font weight to `FontWeight.Bold`.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Bold Text",
        textStyle = KoreTheme.typography.body1.bold()
    )
}""".trimIndent()
        ) {
            Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Bold Text",
                    textStyle = KoreTheme.typography.body1.bold()
                )
            }
        }

        DefaultMarkdownParser(
            content = """### TextStyle.extraBold()

Sets the font weight to `FontWeight.ExtraBold`.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Extra Bold Text",
        textStyle = KoreTheme.typography.body1.extraBold()
    )
}""".trimIndent()
        ) {
            Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Extra Bold Text",
                    textStyle = KoreTheme.typography.body1.extraBold()
                )
            }
        }

        DefaultMarkdownParser(
            content = """### TextStyle.semiBold()

Sets the font weight to `FontWeight.SemiBold`.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Semi Bold Text",
        textStyle = KoreTheme.typography.body1.semiBold()
    )
}""".trimIndent()
        ) {
            Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Semi Bold Text",
                    textStyle = KoreTheme.typography.body1.semiBold()
                )
            }
        }

        DefaultMarkdownParser(
            content = """### TextStyle.medium()

Sets the font weight to `FontWeight.Medium`.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Medium Weight Text",
        textStyle = KoreTheme.typography.body1.medium()
    )
}""".trimIndent()
        ) {
            Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Medium Weight Text",
                    textStyle = KoreTheme.typography.body1.medium()
                )
            }
        }

        DefaultMarkdownParser(
            content = """### TextStyle.light()

Sets the font weight to `FontWeight.Light`.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Light Weight Text",
        textStyle = KoreTheme.typography.body1.light()
    )
}""".trimIndent()
        ) {
            Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Light Weight Text",
                    textStyle = KoreTheme.typography.body1.light()
                )
            }
        }

        DefaultMarkdownParser(
            content = """### TextStyle.extraLight()

Sets the font weight to `FontWeight.ExtraLight`.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Extra Light Text",
        textStyle = KoreTheme.typography.body1.extraLight()
    )
}""".trimIndent()
        ) {
            Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Extra Light Text",
                    textStyle = KoreTheme.typography.body1.extraLight()
                )
            }
        }

        DefaultMarkdownParser(
            content = """### TextStyle.normal()

Sets the font weight to `FontWeight.Normal`.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Normal Weight Text",
        textStyle = KoreTheme.typography.body1.normal()
    )
}""".trimIndent()
        ) {
            Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Normal Weight Text",
                    textStyle = KoreTheme.typography.body1.normal()
                )
            }
        }

        DefaultMarkdownParser(
            content = """---

## Typography

### TextStyle.size()

Sets the `fontSize` of the text style.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Custom Sized Text",
        textStyle = KoreTheme.typography.body1.size(24.sp)
    )
}""".trimIndent()
        ) {
            Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Custom Sized Text",
                    textStyle = KoreTheme.typography.body1.size(24.sp)
                )
            }
        }

        DefaultMarkdownParser(
            content = """### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `size` | `TextUnit` | — | The target font size to apply to the text style. |

### TextStyle.letterSpacing()

Sets the `letterSpacing` of the text style.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Letter Spaced Text",
        textStyle = KoreTheme.typography.body1.letterSpacing(2.sp)
    )
}""".trimIndent()
        ) {
            Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Letter Spaced Text",
                    textStyle = KoreTheme.typography.body1.letterSpacing(2.sp)
                )
            }
        }

        DefaultMarkdownParser(
            content = """### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `spacing` | `TextUnit` | — | The amount of space to add between each letter. |

### TextStyle.lineHeight()

Sets the `lineHeight` of the text style.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Text with\ncustom line\nheight",
        textStyle = KoreTheme.typography.body1.lineHeight(32.sp)
    )
}""".trimIndent()
        ) {
            Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Text with\ncustom line\nheight",
                    textStyle = KoreTheme.typography.body1.lineHeight(32.sp)
                )
            }
        }

        DefaultMarkdownParser(
            content = """### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `height` | `TextUnit` | — | The height of each line of text. |

---

## Decoration

### TextStyle.strikethrough()

Applies a strikethrough line through the text.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Strikethrough Text",
        textStyle = KoreTheme.typography.body1.strikethrough()
    )
}""".trimIndent()
        ) {
            Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Strikethrough Text",
                    textStyle = KoreTheme.typography.body1.strikethrough()
                )
            }
        }

        DefaultMarkdownParser(
            content = """### TextStyle.underline()

Applies an underline below the text.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Underlined Text",
        textStyle = KoreTheme.typography.body1.underline()
    )
}""".trimIndent()
        ) {
            Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Underlined Text",
                    textStyle = KoreTheme.typography.body1.underline()
                )
            }
        }

        DefaultMarkdownParser(
            content = """### TextStyle.italic()

Sets the font style to `FontStyle.Italic`.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Italic Text",
        textStyle = KoreTheme.typography.body1.italic()
    )
}""".trimIndent()
        ) {
            Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Italic Text",
                    textStyle = KoreTheme.typography.body1.italic()
                )
            }
        }

        DefaultMarkdownParser(
            content = """---

## Color

### TextStyle.color()

Sets the `color` of the text style.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Colored Text",
        textStyle = KoreTheme.typography.body1.color(KoreTheme.colorScheme.primary)
    )
}""".trimIndent()
        ) {
            Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Colored Text",
                    textStyle = KoreTheme.typography.body1.color(KoreTheme.colorScheme.primary)
                )
            }
        }

        DefaultMarkdownParser(
            content = """### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `color` | `Color` | — | The color to apply to the text. |

---

## Alignment

### TextStyle.alignCenter()

Sets the text alignment to `TextAlign.Center`.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Centered Text",
        textStyle = KoreTheme.typography.body1.alignCenter(),
        modifier = Modifier.fillMaxWidth()
    )
}""".trimIndent()
        ) {
            Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Centered Text",
                    textStyle = KoreTheme.typography.body1.alignCenter(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        DefaultMarkdownParser(
            content = """### TextStyle.alignEnd()

Sets the text alignment to `TextAlign.End`.
"""
        )

        ComponentShowcase(
            code = """Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "End Aligned Text",
        textStyle = KoreTheme.typography.body1.alignEnd(),
        modifier = Modifier.fillMaxWidth()
    )
}""".trimIndent()
        ) {
            Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "End Aligned Text",
                    textStyle = KoreTheme.typography.body1.alignEnd(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
