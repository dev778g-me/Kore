package com.dev.codesamples.samples.separator

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.kore.components.separators.HorizontalDashedSeparator
import com.dev.kore.themes.KoreTheme

// <sample id="separator-gradient-dashed">

@Composable
fun SeparatorGradientDashedSample() {
    HorizontalDashedSeparator(
        thickness = 2.dp,
        dashLength = 8.dp,
        dashGap = 4.dp,
        brush = Brush.horizontalGradient(
            colors = listOf(Color.Transparent, KoreTheme.colorScheme.primary, Color.Transparent)
        )
    )
}

// <sample/>
