package com.dev.codesamples.samples.buttons

import androidx.compose.runtime.Composable
import com.dev.kore.components.buttons.GhostButton
import com.dev.kore.components.text.Text


// <sample id="ghost">

@Composable
fun GhostButtonSample(){
    GhostButton(
        onClick = { /* Cancel action */ }
    ) {
        Text("Cancel")
    }
}


// <sample/>