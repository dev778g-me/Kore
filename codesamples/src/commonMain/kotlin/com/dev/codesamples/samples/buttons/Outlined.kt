package com.dev.codesamples.samples.buttons

import androidx.compose.runtime.Composable
import com.dev.kore.components.buttons.OutlinedButton
import com.dev.kore.components.text.Text


// <sample id="outlined">

@Composable
fun OutlinedButtonSample(){
    OutlinedButton(
        onClick = { /* Delete action */ },
    ) {
        Text("Delete Permanently")
    }
}

// <sample/>