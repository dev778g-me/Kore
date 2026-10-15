package com.dev.codesamples.samples.stepper

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.stepper.Stepper
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Minus
import com.phosphor.icons.regular.Plus

// <sample id="stepper-basic">
@Composable
fun BasicStepperSample() {
    var quantity by remember { mutableStateOf(1) }
    Stepper(
        label = {
            Text(
                text = quantity.toString(),
                textStyle = KoreTheme.typography.heading3
            )
        },
        decrementButton = {
            GhostIconButton(
                onClick = { if (quantity > 1) quantity-- },
                enabled = quantity > 1
            ) {
                Icon(imageVector = PhIcons.Regular.Minus, contentDescription = "Decrease")
            }
        },
        incrementIcon = {
            GhostIconButton(
                onClick = { quantity++ }
            ) {
                Icon(imageVector = PhIcons.Regular.Plus, contentDescription = "Increase")
            }
        }
    )
}
// <sample/>
