package com.dev.kore.shared.components.actions

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.buttons.OutlinedIconButton
import com.dev.kore.components.buttons.PrimaryIconButton
import com.dev.kore.components.buttons.SecondaryIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Bell
import com.phosphor.icons.regular.Gear
import com.phosphor.icons.regular.Heart
import com.phosphor.icons.regular.Plus

@Composable
fun IconButtonsDemo() {
    DemoPage {
        DemoBlock(title = "Variants") {
            VariantRow {
                PrimaryIconButton(onClick = {}) {
                    Icon(PhIcons.Regular.Plus, contentDescription = "Add")
                }
                SecondaryIconButton(onClick = {}) {
                    Icon(PhIcons.Regular.Heart, contentDescription = "Favorite")
                }
                OutlinedIconButton(onClick = {}) {
                    Icon(PhIcons.Regular.Bell, contentDescription = "Notifications")
                }
                GhostIconButton(onClick = {}) {
                    Icon(PhIcons.Regular.Gear, contentDescription = "Settings")
                }
            }
        }

        DemoBlock(title = "Shapes") {
            VariantRow {
                PrimaryIconButton(onClick = {}) {
                    Icon(PhIcons.Regular.Plus, contentDescription = "Circle")
                }
                PrimaryIconButton(onClick = {}, shape = KoreTheme.shapes.sm) {
                    Icon(PhIcons.Regular.Plus, contentDescription = "Rounded square")
                }
                PrimaryIconButton(onClick = {}, shape = KoreTheme.shapes.xs) {
                    Icon(PhIcons.Regular.Plus, contentDescription = "Small rounded square")
                }
            }
        }

        DemoBlock(title = "Disabled") {
            VariantRow {
                PrimaryIconButton(onClick = {}, enabled = false) {
                    Icon(PhIcons.Regular.Plus, contentDescription = "Add")
                }
                SecondaryIconButton(onClick = {}, enabled = false) {
                    Icon(PhIcons.Regular.Heart, contentDescription = "Favorite")
                }
                OutlinedIconButton(onClick = {}, enabled = false) {
                    Icon(PhIcons.Regular.Bell, contentDescription = "Notifications")
                }
                GhostIconButton(onClick = {}, enabled = false) {
                    Icon(PhIcons.Regular.Gear, contentDescription = "Settings")
                }
            }
        }

        DemoBlock(title = "Inside a row of actions") {
            VariantRow {
                OutlinedIconButton(onClick = {}) {
                    Icon(PhIcons.Regular.Heart, contentDescription = "Like")
                }
                OutlinedIconButton(onClick = {}) {
                    Icon(PhIcons.Regular.Bell, contentDescription = "Notify")
                }
                GhostIconButton(
                    onClick = {},
                    modifier = Modifier.padding(start = 8.dp),
                ) {
                    Icon(PhIcons.Regular.Gear, contentDescription = "More")
                }
            }
        }
    }
}
