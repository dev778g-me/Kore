package com.dev.codesamples.samples.buttons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.text.Text

// <sample id="counter">
@Composable
fun CounterButtonSample() {
    var count by remember { mutableIntStateOf(0) }
    PrimaryButton(
        onClick = { count++ }
    ) {
        Text("Clicked $count times")
    }
}
// <sample/>
