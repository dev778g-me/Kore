package com.dev.kore.shared.components.feedback

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.progress.CircularProgressIndicator
import com.dev.kore.components.progress.LinearProgressIndicator
import com.dev.kore.components.slider.Slider
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme

@Composable
fun ProgressIndicatorDemo() {
    var progress by remember { mutableStateOf(35f) }

    DemoPage {
        DemoBlock(title = "Linear") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier.fillMaxWidth(),
                )
                Text(
                    text = "${progress.toInt()}%",
                    textStyle = KoreTheme.typography.label2,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
            }
        }

        DemoBlock(title = "Circular") {
            Row(
                horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.md),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CircularProgressIndicator(progress = progress, size = 32.dp)
                CircularProgressIndicator(progress = progress, size = 48.dp)
                CircularProgressIndicator(progress = progress, size = 64.dp, thickness = 6.dp)
            }
        }

        DemoBlock(title = "Custom range") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                LinearProgressIndicator(
                    progress = 21f,
                    valueRange = 0f..30f,
                    modifier = Modifier.fillMaxWidth(),
                )
                Text(
                    text = "21 of 30 days",
                    textStyle = KoreTheme.typography.label2,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
            }
        }

        DemoBlock(title = "Boundaries") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                LinearProgressIndicator(progress = 0f, modifier = Modifier.fillMaxWidth())
                LinearProgressIndicator(progress = 100f, modifier = Modifier.fillMaxWidth())
            }
        }

        DemoBlock(title = "Drag to change") {
            Slider(
                value = progress,
                onValueChange = { progress = it },
            )
        }
    }
}
