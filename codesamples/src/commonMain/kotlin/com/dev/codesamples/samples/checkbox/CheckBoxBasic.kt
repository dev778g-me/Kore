package com.dev.codesamples.samples.checkbox

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.checkbox.CheckBox

// <sample id="checkbox-basic">

@Composable
fun CheckBoxBasicSample() {
    var isChecked by remember { mutableStateOf(false) }
    CheckBox(
        checked = isChecked,
        onCheckChange = { isChecked = it }
    )
}

// <sample/>
