package com.dev.codesamples.samples.separator

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dev.kore.components.separators.HorizontalDashedSeparator
import com.dev.kore.themes.KoreTheme

// <sample id="separator-horizontal-dashed">

@Composable
fun HorizontalDashedSeparatorSample() {
    HorizontalDashedSeparator(
        thickness = 2.dp,
        dashLength = 8.dp,
        dashGap = 4.dp,
        color = KoreTheme.colorScheme.primary
    )
}

// <sample/>
