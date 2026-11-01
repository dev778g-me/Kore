package com.dev.kore.shared.components.selection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.dev.kore.components.checkbox.CheckBoxDefaults
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme

/**
 * CheckBox demos: states, labels, shapes, border widths and disabled.
 */
@Composable
fun CheckBoxDemo() {
    var checked by remember { mutableStateOf(true) }
    var unchecked by remember { mutableStateOf(false) }
    val labels = listOf("Email notifications", "Product updates", "Weekly digest")
    val selection = remember { mutableStateListOf(true, false, false) }

    DemoPage {
        DemoBlock(title = "States") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
                ) {
                    CheckBox(checked = checked, onCheckChange = { checked = it })
                    Text("Checked (interactive)", textStyle = KoreTheme.typography.body3)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
                ) {
                    CheckBox(checked = unchecked, onCheckChange = { unchecked = it })
                    Text("Unchecked (interactive)", textStyle = KoreTheme.typography.body3)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
                ) {
                    CheckBox(checked = true, onCheckChange = {})
                    Text("Checked", textStyle = KoreTheme.typography.body3)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
                ) {
                    CheckBox(checked = false, onCheckChange = {})
                    Text("Unchecked", textStyle = KoreTheme.typography.body3)
                }
            }
        }

        DemoBlock(title = "With label") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs)) {
                labels.forEachIndexed { index, label ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
                    ) {
                        CheckBox(
                            checked = selection[index],
                            onCheckChange = { selection[index] = it },
                        )
                        Text(label, textStyle = KoreTheme.typography.body3)
                    }
                }
            }
        }

        DemoBlock(title = "Disabled") {
            Row(horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CheckBox(checked = true, onCheckChange = {}, enabled = false)
                    Text("checked", textStyle = KoreTheme.typography.label2, color = KoreTheme.colorScheme.onBackGroundVariant)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CheckBox(checked = false, onCheckChange = {}, enabled = false)
                    Text("unchecked", textStyle = KoreTheme.typography.label2, color = KoreTheme.colorScheme.onBackGroundVariant)
                }
            }
        }

        DemoBlock(title = "Shapes") {
            Row(horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CheckBox(checked = true, onCheckChange = {}, shape = KoreTheme.shapes.xs)
                    Text("xs", textStyle = KoreTheme.typography.label2, color = KoreTheme.colorScheme.onBackGroundVariant)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CheckBox(checked = true, onCheckChange = {}, shape = KoreTheme.shapes.md)
                    Text("md", textStyle = KoreTheme.typography.label2, color = KoreTheme.colorScheme.onBackGroundVariant)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CheckBox(checked = true, onCheckChange = {}, shape = CircleShape)
                    Text("circle", textStyle = KoreTheme.typography.label2, color = KoreTheme.colorScheme.onBackGroundVariant)
                }
            }
        }

        DemoBlock(title = "Border width") {
            Row(horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CheckBox(checked = false, onCheckChange = {}, borderWidth = 1.dp)
                    Text("1dp", textStyle = KoreTheme.typography.label2, color = KoreTheme.colorScheme.onBackGroundVariant)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CheckBox(checked = false, onCheckChange = {}, borderWidth = 2.dp)
                    Text("2dp", textStyle = KoreTheme.typography.label2, color = KoreTheme.colorScheme.onBackGroundVariant)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CheckBox(checked = false, onCheckChange = {}, borderWidth = 3.dp)
                    Text("3dp", textStyle = KoreTheme.typography.label2, color = KoreTheme.colorScheme.onBackGroundVariant)
                }
            }
        }

        DemoBlock(title = "Live value") {
            Text(
                text = "checked = $checked · unchecked = $unchecked · selected = ${selection.count { it }} of ${selection.size}",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
        }
    }
}
