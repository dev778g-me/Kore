package com.dev.codesamples.samples.colorext

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.colors.blend

// <sample id="colorext-blend">
@Composable
fun BlendSample() {
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
// <sample/>
