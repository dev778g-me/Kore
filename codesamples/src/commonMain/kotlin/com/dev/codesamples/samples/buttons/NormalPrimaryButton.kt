package com.dev.codesamples.samples.buttons

import androidx.compose.runtime.Composable
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.text.Text

// <sample id="primary">
@Composable
fun PrimaryButtonSample(){
    PrimaryButton(
        onClick = {}
    ){
        Text("Hello")
    }
}

// <sample/>

