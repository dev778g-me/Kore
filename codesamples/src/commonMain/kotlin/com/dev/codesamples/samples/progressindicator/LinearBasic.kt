package com.dev.codesamples.samples.progressindicator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.progress.LinearProgressIndicator


// <sample id="progress-linear-basic">

@Composable
fun LinearProgressBasicSample(){
    var currentProgress by remember { mutableStateOf(50f) }
    LinearProgressIndicator(
        progress = currentProgress
    )
}

// <sample/>
