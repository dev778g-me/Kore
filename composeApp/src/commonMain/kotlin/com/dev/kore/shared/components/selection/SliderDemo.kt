package com.dev.kore.shared.components.selection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.dev.kore.components.slider.Slider
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme

@Composable
fun SliderDemo() {
    var volume by remember { mutableStateOf(40f) }
    var brightness by remember { mutableStateOf(75f) }
    var temperature by remember { mutableStateOf(21f) }

    DemoPage {
        DemoBlock(title = "Basic") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs)) {
                Text("Volume · ${volume.toInt()}%", textStyle = KoreTheme.typography.body2)
                Slider(
                    value = volume,
                    onValueChange = { volume = it },
                )
            }
        }

        DemoBlock(title = "Value range") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs)) {
                Text("Temperature · ${temperature.toInt()}°C", textStyle = KoreTheme.typography.body2)
                Slider(
                    value = temperature,
                    onValueChange = { temperature = it },
                    valueRange = 10f..30f,
                )
            }
        }

        DemoBlock(title = "Disabled") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs)) {
                Text("Brightness · ${brightness.toInt()}%", textStyle = KoreTheme.typography.body2)
                Slider(
                    value = brightness,
                    onValueChange = {},
                    enabled = false,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }

        DemoBlock(title = "Custom thickness and shape") {
            Slider(
                value = volume,
                onValueChange = { volume = it },
                thickness = KoreTheme.sizes.md,
                shape = KoreTheme.shapes.sm,
            )
        }
    }
}
