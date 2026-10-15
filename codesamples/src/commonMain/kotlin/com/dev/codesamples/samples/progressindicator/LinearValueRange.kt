package com.dev.codesamples.samples.progressindicator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.dev.kore.components.progress.LinearProgressIndicator


// <sample id="progress-linear-value-range">

@Composable
fun LinearProgressValueRangeSample(){
    var currentStep by remember { mutableStateOf(2f) }
    LinearProgressIndicator(
        progress = currentStep,
        valueRange = 0f..5f,
        thickness = 8.dp
    )
}

// <sample/>
