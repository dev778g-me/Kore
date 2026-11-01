package com.dev.kore.shared.components.selection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.switch.Switch
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow
import com.dev.kore.themes.KoreTheme

@Composable
fun SwitchDemo() {
    var wifi by remember { mutableStateOf(true) }
    var bluetooth by remember { mutableStateOf(false) }
    val settings = remember { mutableStateListOf(true, false, true) }
    val labels = listOf("Wi-Fi", "Bluetooth", "Airplane mode")

    DemoPage {
        DemoBlock(title = "States") {
            VariantRow {
                Switch(checked = wifi, onCheckChange = { wifi = it })
                Switch(checked = bluetooth, onCheckChange = { bluetooth = it })
                Switch(checked = true, onCheckChange = {})
                Switch(checked = false, onCheckChange = {})
            }
        }

        DemoBlock(title = "Disabled") {
            VariantRow {
                Switch(checked = true, onCheckChange = {}, enabled = false)
                Switch(checked = false, onCheckChange = {}, enabled = false)
            }
        }

        DemoBlock(title = "Settings list") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                labels.forEachIndexed { index, label ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Text(label, modifier = Modifier.weight(1f))
                        Switch(
                            checked = settings[index],
                            onCheckChange = { settings[index] = it },
                        )
                    }
                }
            }
        }

        DemoBlock(title = "Live value") {
            Text(
                text = "Wi-Fi = $wifi · Bluetooth = $bluetooth",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
        }
    }
}
