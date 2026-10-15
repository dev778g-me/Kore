package com.dev.codesamples.samples.modifierext

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.dev.kore.components.card.Card
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.colors.TailwindColors
import com.dev.kore.utilities.modifiers.dotBorder

// <sample id="modifierext-dot-border-brush">
@Composable
fun DotBorderBrushSample() {
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
// <sample/>
