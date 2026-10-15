package com.dev.codesamples.samples.switch

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.dev.kore.components.switch.Switch


// <sample id="switch-custom-shape">

@Composable
fun SwitchCustomShapeSample() {
    var checked by remember { mutableStateOf(true) }
    Switch(
        checked = checked,
        onCheckChange = { checked = it },
        trackShape = RoundedCornerShape(4.dp),
        thumbShape = RoundedCornerShape(2.dp),
        switchTrackWidth = 60.dp,
        switchTrackHeight = 32.dp,
        thumbSize = 24.dp
    )
}

// <sample/>
