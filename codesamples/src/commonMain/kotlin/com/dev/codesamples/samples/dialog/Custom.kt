package com.dev.codesamples.samples.dialog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.buttons.ButtonDefaults
import com.dev.kore.components.buttons.GhostButton
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.dialog.AlertDialog
import com.dev.kore.components.dialog.DialogDefaults
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.WarningCircle


// <sample id="dialog-custom">

@Composable
fun CustomDialogSample(){
    var showDialog by remember { mutableStateOf(false) }
    VerticalStack {
        PrimaryButton(onClick = { showDialog = true }) {
            Text("Show Danger Dialog")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                icon = {
                    Icon(
                        imageVector = PhIcons.Regular.WarningCircle,
                        contentDescription = "Warning",
                        tint = KoreTheme.colorScheme.error
                    )
                },
                title = { Text("Delete Account") },
                description = {
                    Text("Are you absolutely sure? This action cannot be undone and all your data will be permanently wiped.")
                },
                dialogColors = DialogDefaults.alertDialogColors(
                    titleTextColors = KoreTheme.colorScheme.error,
                    descriptionTextColor = KoreTheme.colorScheme.onBackGround
                ),
                confirmButton = {
                    PrimaryButton(
                        onClick = { showDialog = false },
                        colors = ButtonDefaults.primaryButtonColors(containerColor = KoreTheme.colorScheme.error)
                    ) {
                        Text("Delete Permanently")
                    }
                },
                dismissButton = {
                    GhostButton(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}

// <sample/>
