package com.dev.codesamples.samples.separator

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dev.kore.components.separators.HorizontalDottedDivider
import com.dev.kore.themes.KoreTheme

// <sample id="separator-horizontal-dotted">

@Composable
fun HorizontalDottedSeparatorSample() {
    HorizontalDottedDivider(
        dotRadius = 3.dp,
        dotGap = 6.dp,
        color = KoreTheme.colorScheme.primary
    )
}

// <sample/>
