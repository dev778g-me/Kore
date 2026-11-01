package com.dev.kore.shared.components.selection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.dev.kore.components.radio.RadioButton
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow
import com.dev.kore.themes.KoreTheme

@Composable
fun RadioButtonDemo() {
    val plans = listOf("Free", "Pro", "Team")
    var selected by remember { mutableStateOf(1) }

    DemoPage {
        DemoBlock(title = "States") {
            VariantRow {
                RadioButton(selected = true, onClick = {})
                RadioButton(selected = false, onClick = {})
                RadioButton(selected = true, onClick = {}, enabled = false)
                RadioButton(selected = false, onClick = {}, enabled = false)
            }
        }

        DemoBlock(title = "Single choice group") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs)) {
                plans.forEachIndexed { index, plan ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        RadioButton(
                            selected = selected == index,
                            onClick = { selected = index },
                        )
                        Text(plan)
                    }
                }
            }
        }

        DemoBlock(title = "Live value") {
            Text(
                text = "selected = ${plans[selected]}",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
        }
    }
}
