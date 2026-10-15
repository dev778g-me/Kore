package com.dev.codesamples.samples.separator

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.kore.components.separators.HorizontalDottedDivider
import com.dev.kore.themes.KoreTheme

// <sample id="separator-gradient-dotted">

@Composable
fun SeparatorGradientDottedSample() {
    HorizontalDottedDivider(
        dotRadius = 3.dp,
        dotGap = 6.dp,
        brush = Brush.horizontalGradient(
            colors = listOf(Color.Transparent, KoreTheme.colorScheme.primary, Color.Transparent)
        )
    )
}

// <sample/>
