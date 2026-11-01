package com.dev.kore.shared.screens.foundations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme

/**
 * Every semantic color role of the current scheme, with the color meant to be
 * drawn on top of it. Switching the app to dark mode flips all of them.
 */
@Composable
fun ColorsDemo() {
    val colors = KoreTheme.colorScheme

    DemoPage {
        ColorGroup(
            title = "Surfaces",
            colors = listOf(
                "background" to (colors.background to colors.onBackGround),
                "backGroundVariant" to (colors.backGroundVariant to colors.onBackGroundVariant),
                "surface" to (colors.surface to colors.onSurface),
                "surfaceBright" to (colors.surfaceBright to colors.onSurfaceBright),
            ),
        )

        ColorGroup(
            title = "Primary",
            colors = listOf(
                "primary" to (colors.primary to colors.onPrimary),
                "primaryContainer" to (colors.primaryContainer to colors.onPrimaryContainer),
            ),
        )

        ColorGroup(
            title = "Complementary",
            colors = listOf(
                "complementary" to (colors.complementary to colors.onComplementary),
                "complementaryContainer" to (colors.complementaryContainer to colors.onComplementaryContainer),
            ),
        )

        ColorGroup(
            title = "Status",
            colors = listOf(
                "success" to (colors.success to colors.onSuccess),
                "error" to (colors.error to colors.onError),
                "disabled" to (colors.disabled to colors.onDisabled),
            ),
        )

        DemoBlock(title = "transparent") {
            SwatchRow(
                label = "transparent",
                color = colors.transparent,
                onColor = colors.onBackGround,
            )
        }
    }
}

@Composable
private fun ColorGroup(
    title: String,
    colors: List<Pair<String, Pair<Color, Color>>>,
) {
    DemoBlock(title = title) {
        Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs)) {
            colors.forEach { (label, pair) ->
                SwatchRow(
                    label = label,
                    color = pair.first,
                    onColor = pair.second,
                )
            }
        }
    }
}

@Composable
private fun SwatchRow(
    label: String,
    color: Color,
    onColor: Color,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(KoreTheme.shapes.sm)
            .background(color)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = label,
            textStyle = KoreTheme.typography.label1,
            color = onColor,
            modifier = Modifier.weight(1f),
        )
        Text(
            text = color.describe(),
            textStyle = KoreTheme.typography.label2,
            color = onColor.copy(alpha = 0.8f),
        )
        Text(
            text = "Aa",
            textStyle = KoreTheme.typography.title2,
            color = onColor,
        )
    }
}

private fun Color.describe(): String {
    val argb = toArgb()
    val alpha = argb ushr 24
    val hex = argb.toUInt().toString(16).padStart(8, '0').uppercase().substring(2)
    val percent = alpha * 100 / 255
    return if (percent == 100) "#$hex" else "#$hex · $percent%"
}
