package com.dev.codesamples.samples.buttons

import androidx.compose.runtime.Composable
import com.dev.kore.components.buttons.SecondaryButton
import com.dev.kore.components.text.Text


// <sample id="secondary">

@Composable
fun SecondaryButtonSample(){
    SecondaryButton(
        onClick = { /* Save as draft */ }
    ) {
        Text("Save as Draft")
    }
}

// <sample/>

