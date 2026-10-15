package com.dev.codesamples.samples.loadingindicator

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.dev.kore.components.loadingIndicator.CircularLoadingIndicator
import com.dev.kore.components.loadingIndicator.LoadingIndicatorDefaults
import com.dev.kore.themes.KoreTheme


// <sample id="loading-circular-custom">

@Composable
fun CircularLoadingCustomSample(){
    CircularLoadingIndicator(
        size = 72.dp,
        thickness = 8.dp,
        cap = StrokeCap.Square,
        colors = LoadingIndicatorDefaults.circularLoadingIndicatorColors(
            trackColor = KoreTheme.colorScheme.surface,
            indicatorColor = KoreTheme.colorScheme.primary
        )
    )
}

// <sample/>
