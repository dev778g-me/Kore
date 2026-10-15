package com.dev.codesamples.samples.dialog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.GhostButton
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.dialog.AlertDialog
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text


// <sample id="dialog-basic">

@Composable
fun BasicDialogSample(){
    var showDialog by remember { mutableStateOf(false) }
    VerticalStack(spacing = 16.dp) {
        PrimaryButton(onClick = { showDialog = true }) {
            Text("Discard Draft")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Discard draft?") },
                description = { Text("This will permanently delete your current progress. You cannot undo this action.") },
                confirmButton = {
                    PrimaryButton(onClick = { showDialog = false }) {
                        Text("Discard")
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
