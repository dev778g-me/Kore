package com.dev.codesamples.samples.progressindicator

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.dev.kore.components.progress.CircularProgressIndicator
import com.dev.kore.components.progress.ProgressIndicatorDefaults
import com.dev.kore.themes.KoreTheme


// <sample id="progress-circular-custom">

@Composable
fun CircularProgressCustomSample(){
    CircularProgressIndicator(
        progress = 90f,
        size = 64.dp,
        thickness = 8.dp,
        cap = StrokeCap.Square,
        colors = ProgressIndicatorDefaults.circularProgressColors(
            trackColor = KoreTheme.colorScheme.backGroundVariant,
            progressColor = Color.Green
        )
    )
}

// <sample/>
