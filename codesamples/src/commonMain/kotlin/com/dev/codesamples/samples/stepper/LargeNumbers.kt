package com.dev.codesamples.samples.stepper

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.stepper.Stepper
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Minus
import com.phosphor.icons.regular.Plus

// <sample id="stepper-large-numbers">
@Composable
fun LargeNumbersStepperSample() {
    var largeValue by remember { mutableStateOf(100) }
    Stepper(
        minLabelWidth = 64.dp,
        label = { Text(largeValue.toString(), textAlign = TextAlign.Center) },
        decrementButton = {
            GhostIconButton(
                onClick = { if (largeValue > 0) largeValue-- },
                enabled = largeValue > 0
            ) {
                Icon(imageVector = PhIcons.Regular.Minus, contentDescription = "Decrease")
            }
        },
        incrementIcon = {
            GhostIconButton(onClick = { largeValue++ }) {
                Icon(imageVector = PhIcons.Regular.Plus, contentDescription = "Increase")
            }
        }
    )
}
// <sample/>
