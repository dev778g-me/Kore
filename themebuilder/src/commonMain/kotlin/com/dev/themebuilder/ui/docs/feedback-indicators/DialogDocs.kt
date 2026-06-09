package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

@Composable
fun DialogDocs(
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp)
    ) {
        DefaultMarkdownParser(
            content = """# Alert Dialog

An Alert Dialog is a modal popup that overlays the main content to interrupt the user's workflow. It is used to communicate critical information or ask for a necessary decision before the user can proceed. 

When to use Alert Dialog:
- Destructive actions (e.g., deleting a file, permanently clearing data).
- Critical system-level errors or urgent alerts.
- When you require explicit user confirmation before proceeding with a task.

When to avoid Alert Dialog:
- Non-critical information that doesn't require immediate user action (use Snackbars or Toasts instead).
- Complex data entry, long forms, or deep configurations (use a Full-screen Dialog or Bottom Sheet).
- Repetitive, low-risk actions (avoids "dialog fatigue").

For deeper reference, check out [Mobbin](https://mobbin.com/glossary/dialog) guide on dialogs.



| Slot              | Description                                                                      |
|-------------------|----------------------------------------------------------------------------------|
| `*title`           | The title of the Dialog, usually a concise heading conveying the alert message.  |
| `icon`            | An optional icon displayed above the title to visually represent the intent.     |
| `description`     | The supporting text explaining the details or consequences of the alert.         |
| `*confirmButton`   | The primary action you want the user to execute (e.g., "OK", "Delete", "Save").  |
| `dismissButton`   | The secondary action to cancel or back out (e.g., "Cancel", "No").               |

## Basic Example

<figure><img src="showcases/dialogShowcase/dialog.png" alt="Alert Dialog example image "><figcaption></figcaption></figure>
To use an `AlertDialog`, you must hoist a boolean state to control its visibility.


"""
        )

        ComponentShowcase(
            code = """
var showDialog by remember { mutableStateOf(false) }

VerticalStack {
    PrimaryButton(onClick = { showDialog = true }) {
        Text("Discard Draft")
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Discard draft?") },
            description = { Text("This will permanently delete your current progress. You cannot undo this action.") },
            confirmButton = {
                PrimaryButton(onClick = { /* Handle discard logic */ showDialog = false }) {
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
""".trimIndent(),
            content = {
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
        )

        DefaultMarkdownParser(
            content = """
## Styling
AlertDialog exposes extensive parameters to customize its spacing, elevation, arrangement, and colors.

### Parameters

| Parameter                 | Type                             | Default                                       | Description                                                                 |
|---------------------------|----------------------------------|-----------------------------------------------|-----------------------------------------------------------------------------|
| `onDismissRequest`        | `() -> Unit`                     | —                                             | Callback triggered when dismissing the dialog (clicking outside/back).      |
| `modifier`                | `Modifier`                       | `Modifier`                                    | Applied to the dialog container `Box`.                                      |
| `dialogShape`             | `Shape`                          | `DialogDefaults.defaultDialogShape`           | The geometric shape of the dialog container (defaults to large rounded).    |
| `dialogColors`            | `DialogColors`                   | `DialogDefaults.alertDialogColors()`          | The colors applied to the container, title, description, and borders.       |
| `border`                  | `BorderStroke?`                  | `null`                                        | Optional border stroke around the dialog container.                         |
| `elevation`               | `Dp`                             | `DialogDefaults.defaultDialogElevation`       | The shadow elevation applied to the dialog window.                          |
| `dialogActionArrangement` | `Arrangement.Horizontal`         | `DialogDefaults.defaultActionArrangement`     | Alignment of the action buttons (defaults to end/right aligned).            |
| `dialogProperties`        | `DialogProperties`               | `DialogDefaults.defaultDialogProperties`      | System properties configuring platform-specific dialog behavior.            |
| `dialogSpacing`           | `DialogSpacing`                  | `DialogDefaults.defaultDialogSpacing()`       | Configures the vertical gaps between the icon, title, description & buttons.|
| `contentPadding`          | `PaddingValues`                  | `DialogDefaults.defaultDialogPaddingValues`   | Padding applied inside the dialog container around all content.             |

### Destructive Alert with Icon

For high-risk actions, it is common to include a warning icon and override the default text colors to indicate a destructive intent (like red/error colors).

<figure><img src="showcases/dialogShowcase/danger_dialog.png" alt="Danger Alert Dialog example image "><figcaption></figcaption></figure>
"""
        )

        ComponentShowcase(
            code = """
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
        titleTextColors = KoreTheme.colorScheme.error, // Highlight title in red
        descriptionTextColor = KoreTheme.colorScheme.onBackGround
    ),
    confirmButton = {
        PrimaryButton(
            onClick = { /* Delete Account */ },
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
""".trimIndent(),
            content = {
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
        )
    }
}