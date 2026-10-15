package com.dev.codesamples.samples.badge

import androidx.compose.runtime.Composable
import com.dev.kore.components.badge.PrimaryBadge
import com.dev.kore.components.text.Text


// <sample id="badge-primary">

@Composable
fun PrimaryBadgeSample(){
    PrimaryBadge(
        content = { Text("New Feature") }
    )
}

// <sample/>
