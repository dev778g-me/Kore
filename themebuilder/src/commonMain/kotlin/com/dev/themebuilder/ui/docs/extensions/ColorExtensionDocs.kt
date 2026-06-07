package com.dev.themebuilder.ui.docs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.unit.dp
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.colors.RadixColors
import com.dev.kore.themes.colors.TailwindColors
import com.dev.kore.themes.colors.blend
import com.dev.kore.themes.colors.toHexString
import kotlinx.coroutines.delay

@Composable
fun ColorExtensionDocs(
    modifier: Modifier = Modifier,
) {
    VerticalStack {
        DefaultMarkdownParser(
            content = """# Colors

Kore provides multiple color systems: utility extensions on `Color`, Tailwind CSS color palette, and Radix UI color scales.

---

## Color Extensions

### Color.blend()

Blends this color toward a target [blendColor] using linear interpolation.

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `blendColor` | `Color` | — | The target color to blend into. |
| `blendValue` | `Float` | `0.85f` | Blend amount in the range `0f..1f`. `0f` returns this color, `1f` returns `blendColor`. |
"""
        )

        ComponentShowcase(
            code = """Box(
    modifier = Modifier
        .size(200.dp)
        .background(
            KoreTheme.colorScheme.primary.blend(
                blendColor = Color.White,
                blendValue = 0.85f
            )
        )
)""".trimIndent()
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(
                        KoreTheme.colorScheme.primary.blend(
                            blendColor = Color.White,
                            blendValue = 0.85f
                        )
                    )
            )
        }

        DefaultMarkdownParser(
            content = """### Color.toHexString()

Converts the color to an ARGB hex string prefixed with `0x`.

```kotlin
val hex = Color.Red.toHexString() // "0xFFFF0000"
```

---

## Tailwind Colors

The `TailwindColors` object provides the complete Tailwind CSS color palette with 22 color families and 11 shades each (50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 950).

```kotlin
Card(
    containerColor = TailwindColors.Blue.swatch500
) {
    Text("Tailwind Blue 500")
}
```

You can also access Tailwind colors via `Color.Tailwind`.
"""
        )

        TailwindColorSwatches()

        DefaultMarkdownParser(
            content = """### Semantic Colors

| Color | Value |
|-------|-------|
| `TailwindColors.Black` | `Color(0xFF000000)` |
| `TailwindColors.White` | `Color(0xFFFFFFFF)` |
| `TailwindColors.Transparent` | `Color(0x00000000)` |

---

## Radix Colors

The `RadixColors` object provides the Radix UI color system with both light and dark variants for each color scale. Each scale has 12 steps with consistent semantic meaning:

| Steps | Usage |
|-------|-------|
| 1–2 | App / page backgrounds |
| 3–5 | Component backgrounds (default, hover, active) |
| 6–8 | Borders (subtle, normal, strong) |
| 9–10 | Solid fills (buttons, badges, tags) |
| 11–12 | Text & icons (low contrast, high contrast) |

```kotlin
// Light mode
val surface = RadixColors.Gray.light.step1

// Dark mode
val background = RadixColors.Gray.dark.step1
```
"""
        )

        RadixColorScaleSwatches()
    }
}

@Composable
private fun TailwindColorSwatches() {
    val families = listOf(
        "Slate" to TailwindColors.Slate,
        "Gray" to TailwindColors.Gray,
        "Zinc" to TailwindColors.Zinc,
        "Neutral" to TailwindColors.Neutral,
        "Stone" to TailwindColors.Stone,
        "Red" to TailwindColors.Red,
        "Orange" to TailwindColors.Orange,
        "Amber" to TailwindColors.Amber,
        "Yellow" to TailwindColors.Yellow,
        "Lime" to TailwindColors.Lime,
        "Green" to TailwindColors.Green,
        "Emerald" to TailwindColors.Emerald,
        "Teal" to TailwindColors.Teal,
        "Cyan" to TailwindColors.Cyan,
        "Sky" to TailwindColors.Sky,
        "Blue" to TailwindColors.Blue,
        "Indigo" to TailwindColors.Indigo,
        "Violet" to TailwindColors.Violet,
        "Purple" to TailwindColors.Purple,
        "Fuchsia" to TailwindColors.Fuchsia,
        "Pink" to TailwindColors.Pink,
        "Rose" to TailwindColors.Rose,
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        families.forEach { (name, swatch) ->
            TailwindSwatchRow(name = name, swatch = swatch)
        }
    }
}

@Composable
private fun TailwindSwatchRow(
    name: String,
    swatch: com.dev.kore.themes.colors.TailwindSwatch,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = name,
            textStyle = KoreTheme.typography.label2,
            modifier = Modifier.padding(bottom = 6.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            swatch.swatches.forEach { color ->
                ColorSwatchBox(
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    color = color
                )
            }
        }
    }
}

@Composable
private fun RadixColorScaleSwatches() {
    val isDark = isSystemInDarkTheme()

    val scales = listOf(
        "Gray" to if (isDark) RadixColors.Gray.dark else RadixColors.Gray.light,
        "Mauve" to if (isDark) RadixColors.Mauve.dark else RadixColors.Mauve.light,
        "Slate" to if (isDark) RadixColors.Slate.dark else RadixColors.Slate.light,
        "Sage" to if (isDark) RadixColors.Sage.dark else RadixColors.Sage.light,
        "Olive" to if (isDark) RadixColors.Olive.dark else RadixColors.Olive.light,
        "Sand" to if (isDark) RadixColors.Sand.dark else RadixColors.Sand.light,
        "Gold" to if (isDark) RadixColors.Gold.dark else RadixColors.Gold.light,
        "Bronze" to if (isDark) RadixColors.Bronze.dark else RadixColors.Bronze.light,
        "Brown" to if (isDark) RadixColors.Brown.dark else RadixColors.Brown.light,
        "Yellow" to if (isDark) RadixColors.Yellow.dark else RadixColors.Yellow.light,
        "Amber" to if (isDark) RadixColors.Amber.dark else RadixColors.Amber.light,
        "Orange" to if (isDark) RadixColors.Orange.dark else RadixColors.Orange.light,
        "Tomato" to if (isDark) RadixColors.Tomato.dark else RadixColors.Tomato.light,
        "Red" to if (isDark) RadixColors.Red.dark else RadixColors.Red.light,
        "Ruby" to if (isDark) RadixColors.Ruby.dark else RadixColors.Ruby.light,
        "Crimson" to if (isDark) RadixColors.Crimson.dark else RadixColors.Crimson.light,
        "Pink" to if (isDark) RadixColors.Pink.dark else RadixColors.Pink.light,
        "Plum" to if (isDark) RadixColors.Plum.dark else RadixColors.Plum.light,
        "Purple" to if (isDark) RadixColors.Purple.dark else RadixColors.Purple.light,
        "Violet" to if (isDark) RadixColors.Violet.dark else RadixColors.Violet.light,
        "Iris" to if (isDark) RadixColors.Iris.dark else RadixColors.Iris.light,
        "Indigo" to if (isDark) RadixColors.Indigo.dark else RadixColors.Indigo.light,
        "Blue" to if (isDark) RadixColors.Blue.dark else RadixColors.Blue.light,
        "Cyan" to if (isDark) RadixColors.Cyan.dark else RadixColors.Cyan.light,
        "Teal" to if (isDark) RadixColors.Teal.dark else RadixColors.Teal.light,
        "Jade" to if (isDark) RadixColors.Jade.dark else RadixColors.Jade.light,
        "Green" to if (isDark) RadixColors.Green.dark else RadixColors.Green.light,
        "Grass" to if (isDark) RadixColors.Grass.dark else RadixColors.Grass.light,
        "Lime" to if (isDark) RadixColors.Lime.dark else RadixColors.Lime.light,
        "Mint" to if (isDark) RadixColors.Mint.dark else RadixColors.Mint.light,
        "Sky" to if (isDark) RadixColors.Sky.dark else RadixColors.Sky.light,
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        scales.forEach { (name, scale) ->
            RadixScaleRow(name = name, scale = scale)
        }
    }
}

@Composable
private fun RadixScaleRow(
    name: String,
    scale: com.dev.kore.themes.colors.RadixScale,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = name,
            textStyle = KoreTheme.typography.label2,
            modifier = Modifier.padding(bottom = 6.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            scale.steps.forEach { color ->
                ColorSwatchBox(
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    color = color
                )
            }
        }
    }
}

@Composable
private fun ColorSwatchBox(
    modifier: Modifier = Modifier,
    color: Color,
) {
    var showCopied by remember { mutableStateOf(false) }

    LaunchedEffect(showCopied) {
        if (showCopied) {
            delay(1000)
            showCopied = false
        }
    }

    Box(
        modifier = modifier
            .clip(KoreTheme.shapes.sm)
            .clickable {
                copyToClipboard(color.toHexString())
                showCopied = true
            }
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = showCopied,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Text(
                text = "Copied!",
                textStyle = KoreTheme.typography.label1,
                color = if (color.luminance() > 0.5f) {
                    Color.Black
                } else {
                    Color.White
                }
            )
        }
    }
}
