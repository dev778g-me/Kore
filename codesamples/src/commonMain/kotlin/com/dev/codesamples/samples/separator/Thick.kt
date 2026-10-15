package com.dev.codesamples.samples.separator

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.dev.kore.components.separators.HorizontalSeparator
import com.dev.kore.themes.KoreTheme

// <sample id="separator-thick">

@Composable
fun SeparatorThickSample() {
    HorizontalSeparator(
        thickness = 4.dp,
        separatorCap = StrokeCap.Square,
        color = KoreTheme.colorScheme.primary
    )
}

// <sample/>
