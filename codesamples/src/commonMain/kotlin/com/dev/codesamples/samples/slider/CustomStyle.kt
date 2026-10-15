package com.dev.codesamples.samples.slider

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.dev.kore.components.slider.Slider
import com.dev.kore.components.slider.SliderDefaults
import com.dev.kore.themes.KoreTheme


// <sample id="slider-custom-style">

@Composable
fun SliderCustomStyleSample() {
    var brightness by remember { mutableStateOf(75f) }
    Slider(
        value = brightness,
        onValueChange = { brightness = it },
        thickness = 12.dp,
        shape = RoundedCornerShape(100),
        colors = SliderDefaults.defaultSliderColors(
            enabledProgressColor = KoreTheme.colorScheme.complementary,
            enabledThumbColor = KoreTheme.colorScheme.onComplementary,
            enabledTrackColor = KoreTheme.colorScheme.complementaryContainer,
            disabledThumbColor = KoreTheme.colorScheme.disabled
        )
    )
}

// <sample/>
