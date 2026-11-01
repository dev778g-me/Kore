package com.dev.kore.shared.components.inputs

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.buttons.OutlinedIconButton
import com.dev.kore.components.dropdown.DropDown
import com.dev.kore.components.dropdown.DropDownItem
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.separators.HorizontalSeparator
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Copy
import com.phosphor.icons.regular.DotsThreeVertical
import com.phosphor.icons.regular.PencilLine
import com.phosphor.icons.regular.ShareNetwork
import com.phosphor.icons.regular.Trash
import com.phosphor.icons.regular.User

@Composable
fun DropdownDemo() {
    var expanded by remember { mutableStateOf(false) }
    var lastAction by remember { mutableStateOf("none") }

    fun choose(action: String) {
        lastAction = action
        expanded = false
    }

    DemoPage {
        DemoBlock(title = "Context menu") {
            Box {
                OutlinedIconButton(onClick = { expanded = true }) {
                    Icon(PhIcons.Regular.DotsThreeVertical, contentDescription = "More options")
                }

                DropDown(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    DropDownItem(
                        title = { Text("My profile") },
                        onClick = { choose("My profile") },
                        leading = { Icon(PhIcons.Regular.User, contentDescription = null) },
                    )
                    DropDownItem(
                        title = { Text("Edit") },
                        onClick = { choose("Edit") },
                        leading = { Icon(PhIcons.Regular.PencilLine, contentDescription = null) },
                    )
                    DropDownItem(
                        title = { Text("Share") },
                        onClick = { choose("Share") },
                        leading = { Icon(PhIcons.Regular.ShareNetwork, contentDescription = null) },
                    )
                    HorizontalSeparator()
                    DropDownItem(
                        title = { Text("Delete") },
                        onClick = { choose("Delete") },
                        leading = { Icon(PhIcons.Regular.Trash, contentDescription = null) },
                    )
                }
            }
        }

        DemoBlock(title = "Plain actions") {
            var plainExpanded by remember { mutableStateOf(false) }
            var plainAction by remember { mutableStateOf("none") }

            Box {
                OutlinedIconButton(onClick = { plainExpanded = true }) {
                    Icon(PhIcons.Regular.DotsThreeVertical, contentDescription = "More options")
                }

                DropDown(
                    expanded = plainExpanded,
                    onDismissRequest = { plainExpanded = false },
                ) {
                    DropDownItem(
                        title = { Text("Copy link") },
                        onClick = {
                            plainAction = "Copy link"
                            plainExpanded = false
                        },
                    )
                    DropDownItem(
                        title = { Text("Duplicate") },
                        onClick = {
                            plainAction = "Duplicate"
                            plainExpanded = false
                        },
                    )
                    DropDownItem(
                        title = { Text("Disabled") },
                        onClick = {},
                        enabled = false,
                    )
                }
            }

            Text(
                text = "last action = $plainAction",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
        }

        DemoBlock(title = "Trailing icon") {
            var trailingExpanded by remember { mutableStateOf(false) }

            Box {
                GhostIconButton(onClick = { trailingExpanded = true }) {
                    Icon(PhIcons.Regular.Copy, contentDescription = "Open menu")
                }

                DropDown(
                    expanded = trailingExpanded,
                    onDismissRequest = { trailingExpanded = false },
                ) {
                    DropDownItem(
                        title = { Text("Copy") },
                        onClick = { trailingExpanded = false },
                        trailing = { Icon(PhIcons.Regular.Copy, contentDescription = null) },
                    )
                    DropDownItem(
                        title = { Text("Share") },
                        onClick = { trailingExpanded = false },
                        trailing = { Icon(PhIcons.Regular.ShareNetwork, contentDescription = null) },
                    )
                }
            }
        }

        DemoBlock(title = "Live value") {
            Text(
                text = "last action = $lastAction",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
        }
    }
}
