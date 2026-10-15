package com.dev.codesamples.samples.modifierext

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.dev.kore.components.card.Card
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.colors.TailwindColors
import com.dev.kore.utilities.modifiers.dashedBorder

// <sample id="modifierext-dashed-border-brush">
@Composable
fun DashedBorderBrushSample() {
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
// <sample/>
