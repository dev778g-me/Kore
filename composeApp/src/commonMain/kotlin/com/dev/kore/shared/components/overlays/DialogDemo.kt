package com.dev.kore.shared.components.overlays

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dev.kore.components.buttons.OutlinedButton
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.buttons.SecondaryButton
import com.dev.kore.components.dialog.AlertDialog
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Info
import com.phosphor.icons.regular.Warning

@Composable
fun DialogDemo() {
    var simple by remember { mutableStateOf(false) }
    var destructive by remember { mutableStateOf(false) }
    var informational by remember { mutableStateOf(false) }

    DemoPage {

            DemoBlock(title = "Simple confirmation") {
                PrimaryButton(onClick = { simple = true }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Text("Show dialog")
                }
            }

            DemoBlock(title = "Destructive action") {
                SecondaryButton(onClick = { destructive = true }, modifier = Modifier.align(Alignment.CenterHorizontally) ){
                    Text("Delete project")
                }
            }

            DemoBlock(title = "Informational") {
                OutlinedButton(onClick = { informational = true }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Text("What's new?")
                }
            }

            DemoBlock(title = "Variants at a glance") {
                VariantRow {
                    Text(
                        text = "Alert dialogs interrupt the flow for a decision that cannot be undone or that needs full attention.",
                        textStyle = KoreTheme.typography.body3,
                        color = KoreTheme.colorScheme.onBackGroundVariant,
                    )
                }
            }

    }

    if (simple) {
        AlertDialog(
            onDismissRequest = { simple = false },
            title = { Text("Discard draft?") },
            description = { Text("Your unsaved changes will be lost.") },
            dismissButton = {
                OutlinedButton(onClick = { simple = false }) {
                    Text("Cancel")
                }
            },
            confirmButton = {
                PrimaryButton(onClick = { simple = false }) {
                    Text("Discard")
                }
            },
        )
    }

    if (destructive) {
        AlertDialog(
            onDismissRequest = { destructive = false },
            title = { Text("Delete project?") },
            icon = {
                Icon(
                    imageVector = PhIcons.Regular.Warning,
                    contentDescription = null,
                    tint = KoreTheme.colorScheme.error,
                )
            },
            description = { Text("Every file, comment and deployment of this project will be removed. This cannot be undone.") },
            dismissButton = {
                OutlinedButton(onClick = { destructive = false }) {
                    Text("Cancel")
                }
            },
            confirmButton = {
                PrimaryButton(onClick = { destructive = false }) {
                    Text("Delete")
                }
            },
        )
    }

    if (informational) {
        AlertDialog(
            onDismissRequest = { informational = false },
            title = { Text("Kore 1.0") },
            icon = {
                Icon(PhIcons.Regular.Info, contentDescription = null)
            },
            description = { Text("The design system now ships 35 components, motion presets and a full type scale.") },
            confirmButton = {
                PrimaryButton(onClick = { informational = false }) {
                    Text("Got it")
                }
            },
        )
    }
}
