package com.dev.codesamples.samples.radiobutton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.radio.RadioButton

// <sample id="radiobutton-custom">

@Composable
fun RadioButtonCustomSample() {
    var isSelected by remember { mutableStateOf(true) }
    RadioButton(
        selected = isSelected,
        onClick = { isSelected = !isSelected }
    )
}

// <sample/>
