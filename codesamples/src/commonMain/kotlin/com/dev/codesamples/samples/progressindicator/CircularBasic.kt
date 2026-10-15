package com.dev.codesamples.samples.progressindicator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.progress.CircularProgressIndicator


// <sample id="progress-circular-basic">

@Composable
fun CircularProgressBasicSample(){
    var currentProgress by remember { mutableStateOf(75f) }
    CircularProgressIndicator(
        progress = currentProgress
    )
}

// <sample/>
