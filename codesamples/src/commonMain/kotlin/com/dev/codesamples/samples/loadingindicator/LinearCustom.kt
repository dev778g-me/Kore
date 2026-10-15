package com.dev.codesamples.samples.loadingindicator

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.dev.kore.components.loadingIndicator.LinearLoadingIndicator
import com.dev.kore.components.loadingIndicator.LoadingIndicatorDefaults


// <sample id="loading-linear-custom">

@Composable
fun LinearLoadingCustomSample(){
    LinearLoadingIndicator(
        thickness = 2.dp,
        cap = StrokeCap.Butt,
        colors = LoadingIndicatorDefaults.linearLoadingIndictorColors(
            trackColor = Color.Transparent,
            indicatorColor = Color.Green
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

// <sample/>
