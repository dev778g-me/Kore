package com.dev.codesamples.samples.slider

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.slider.Slider
import com.dev.kore.components.text.Text


// <sample id="slider-basic">

@Composable
fun SliderBasicSample() {
    var sliderPosition by remember { mutableStateOf(50f) }
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Volume: ${sliderPosition.toInt()}%")
        Slider(
            value = sliderPosition,
            onValueChange = { newValue ->
                sliderPosition = newValue
            }
        )
    }
}

// <sample/>
