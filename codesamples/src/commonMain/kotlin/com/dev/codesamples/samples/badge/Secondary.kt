package com.dev.codesamples.samples.badge

import androidx.compose.runtime.Composable
import com.dev.kore.components.badge.SecondaryBadge
import com.dev.kore.components.text.Text


// <sample id="badge-secondary">

@Composable
fun SecondaryBadgeSample(){
    SecondaryBadge(
        content = { Text("Processing") }
    )
}

// <sample/>
