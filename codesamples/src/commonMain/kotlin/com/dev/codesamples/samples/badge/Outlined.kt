package com.dev.codesamples.samples.badge

import androidx.compose.runtime.Composable
import com.dev.kore.components.badge.OutlinedBadge
import com.dev.kore.components.text.Text


// <sample id="badge-outlined">

@Composable
fun OutlinedBadgeSample(){
    OutlinedBadge(
        content = { Text("Archived") }
    )
}

// <sample/>
