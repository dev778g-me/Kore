package com.dev.kore.shared.components.selection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.checkbox.CheckBox
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow
import com.dev.kore.themes.KoreTheme

@Composable
fun CheckBoxDemo() {
    var checked by remember { mutableStateOf(true) }
    var unchecked by remember { mutableStateOf(false) }
    val labels = listOf("Email notifications", "Product updates", "Weekly digest")
    val selection = remember { mutableStateListOf(true, false, false) }

    DemoPage {
        DemoBlock(title = "States") {
            VariantRow {
                CheckBox(checked = checked, onCheckChange = { checked = it })
                CheckBox(checked = unchecked, onCheckChange = { unchecked = it })
                CheckBox(checked = true, onCheckChange = {})
                CheckBox(checked = false, onCheckChange = {})
            }
        }

        DemoBlock(title = "With label") {
            Column {
                labels.forEachIndexed { index, label ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        CheckBox(
                            checked = selection[index],
                            onCheckChange = { selection[index] = it },
                        )
                        Text(label)
                    }
                }
            }
        }

        DemoBlock(title = "Disabled") {
            VariantRow {
                CheckBox(checked = true, onCheckChange = {}, enabled = false)
                CheckBox(checked = false, onCheckChange = {}, enabled = false)
            }
        }

        DemoBlock(title = "Shapes") {
            VariantRow {
                CheckBox(
                    checked = true,
                    onCheckChange = {},
                    shape = KoreTheme.shapes.xs,
                )
                CheckBox(
                    checked = true,
                    onCheckChange = {},
                    shape = KoreTheme.shapes.md,
                )
                CheckBox(
                    checked = true,
                    onCheckChange = {},
                    shape = CircleShape,
                )
            }
        }

        DemoBlock(title = "Live value") {
            Text(
                text = "checked = $checked · unchecked = $unchecked · selected = ${selection.count { it }} of ${selection.size}",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
                modifier = Modifier.padding(top = 4.dp),
            )
        }
    }
}
