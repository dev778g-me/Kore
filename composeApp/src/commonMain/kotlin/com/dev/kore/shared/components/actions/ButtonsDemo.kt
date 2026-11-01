package com.dev.kore.shared.components.actions

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.GhostButton
import com.dev.kore.components.buttons.OutlinedButton
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.buttons.SecondaryButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.ArrowRight
import com.phosphor.icons.regular.Plus

@Composable
fun ButtonsDemo() {
    DemoPage {
        DemoBlock(title = "Variants") {
            VariantRow {
                PrimaryButton(onClick = {}) { Text("Primary") }
                SecondaryButton(onClick = {}) { Text("Secondary") }
                OutlinedButton(onClick = {}) { Text("Outlined") }
                GhostButton(onClick = {}) { Text("Ghost") }
            }
        }

        DemoBlock(title = "With leading icon") {
            VariantRow {
                PrimaryButton(onClick = {}) {
                    Icon(
                        imageVector = PhIcons.Regular.Plus,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp),
                    )
                    Text("New item")
                }
                SecondaryButton(onClick = {}) {
                    Icon(
                        imageVector = PhIcons.Regular.Plus,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp),
                    )
                    Text("New item")
                }
            }
        }

        DemoBlock(title = "With trailing icon") {
            OutlinedButton(onClick = {}) {
                Text("Continue")
                Icon(
                    imageVector = PhIcons.Regular.ArrowRight,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 8.dp),
                )
            }
        }

        DemoBlock(title = "Disabled") {
            VariantRow {
                PrimaryButton(onClick = {}, enabled = false) { Text("Primary") }
                SecondaryButton(onClick = {}, enabled = false) { Text("Secondary") }
                OutlinedButton(onClick = {}, enabled = false) { Text("Outlined") }
                GhostButton(onClick = {}, enabled = false) { Text("Ghost") }
            }
        }

        DemoBlock(title = "Custom shapes") {
            VariantRow {
                PrimaryButton(onClick = {}, shape = KoreTheme.shapes.xs) { Text("xs") }
                PrimaryButton(onClick = {}, shape = KoreTheme.shapes.md) { Text("md") }
                PrimaryButton(onClick = {}, shape = KoreTheme.shapes.xl) { Text("xl") }
            }
        }
    }
}
