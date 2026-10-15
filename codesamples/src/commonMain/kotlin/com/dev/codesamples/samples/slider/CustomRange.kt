package com.dev.codesamples.samples.slider

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.slider.Slider
import com.dev.kore.components.text.Text


// <sample id="slider-custom-range">

@Composable
fun SliderCustomRangeSample() {
    var rating by remember { mutableStateOf(5f) }
    Column {
        Text("Rate your experience: ${rating.toInt()} / 10")
        Slider(
            value = rating,
            valueRange = 1f..10f,
            onValueChange = { rating = it }
        )
    }
}

// <sample/>
