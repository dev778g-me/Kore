package com.dev.kore.shared.components.actions

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttonGroup.ButtonGroup
import com.dev.kore.components.buttonGroup.ClickableButtonItem
import com.dev.kore.components.buttonGroup.ToggleButtonItem
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.TextB
import com.phosphor.icons.regular.TextItalic
import com.phosphor.icons.regular.TextUnderline

@Composable
fun ButtonGroupDemo() {
    var bold by remember { mutableStateOf(true) }
    var italic by remember { mutableStateOf(false) }
    var underline by remember { mutableStateOf(false) }
    var alignment by remember { mutableStateOf(0) }

    DemoPage {
        DemoBlock(title = "Clickable items") {
            ButtonGroup {
                ClickableButtonItem(onClick = {}) {
                    Icon(PhIcons.Regular.TextB, contentDescription = null)
                }
                ClickableButtonItem(onClick = {}) {
                    Icon(PhIcons.Regular.TextItalic, contentDescription = null)
                }
                ClickableButtonItem(onClick = {}) {
                    Icon(PhIcons.Regular.TextUnderline, contentDescription = null)
                }
            }
        }

        DemoBlock(title = "Toggle items") {
            ButtonGroup {
                ToggleButtonItem(selected = bold, onClick = { bold = !bold }) {
                    Icon(PhIcons.Regular.TextB, contentDescription = "Bold")
                }
                ToggleButtonItem(selected = italic, onClick = { italic = !italic }) {
                    Icon(PhIcons.Regular.TextItalic, contentDescription = "Italic")
                }
                ToggleButtonItem(selected = underline, onClick = { underline = !underline }) {
                    Icon(PhIcons.Regular.TextUnderline, contentDescription = "Underline")
                }
            }
        }

        DemoBlock(title = "Single choice with labels") {
            ButtonGroup {
                listOf("Day", "Week", "Month").forEachIndexed { index, label ->
                    ToggleButtonItem(
                        selected = alignment == index,
                        onClick = { alignment = index },
                        showSeparator = index != 2,
                    ) {
                        Text(label, modifier = Modifier.padding(horizontal = 4.dp))
                    }
                }
            }
        }

        DemoBlock(title = "Disabled") {
            ButtonGroup {
                ClickableButtonItem(onClick = {}, enabled = false) {
                    Text("Left")
                }
                ClickableButtonItem(onClick = {}, enabled = false) {
                    Text("Center")
                }
                ClickableButtonItem(onClick = {}, enabled = false) {
                    Text("Right")
                }
            }
        }

        DemoBlock(title = "Custom shape") {
            ButtonGroup(shape = KoreTheme.shapes.xl) {
                ClickableButtonItem(onClick = {}) { Text("Cancel") }
                ClickableButtonItem(onClick = {}) { Text("Save") }
            }
        }
    }
}
