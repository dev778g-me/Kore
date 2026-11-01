package com.dev.kore.shared.components.inputs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.components.textFields.OutlinedTextField
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Envelope
import com.phosphor.icons.regular.Eye
import com.phosphor.icons.regular.User

@Composable
fun TextFieldDemo() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("ada@kore.dev") }
    var invalidEmail by remember { mutableStateOf("ada@") }
    var password by remember { mutableStateOf("hunter2") }
    var showPassword by remember { mutableStateOf(false) }
    var bio by remember { mutableStateOf("") }
    var disabled by remember { mutableStateOf("Read only") }

    DemoPage {
        DemoBlock(title = "Basic") {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Full name") },
                placeholder = { Text("Ada Lovelace") },
                modifier = Modifier.fillMaxWidth(),
            )
        }

        DemoBlock(title = "With description and leading icon") {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                description = { Text("We only use it for receipts.") },
                leadingIcon = {
                    Icon(PhIcons.Regular.Envelope, contentDescription = null)
                },
                modifier = Modifier.fillMaxWidth(),
            )
        }

        DemoBlock(title = "Password with trailing action") {
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                visualTransformation = if (showPassword) {
                    androidx.compose.ui.text.input.VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    GhostIconButton(onClick = { showPassword = !showPassword }) {
                        Icon(
                            imageVector = PhIcons.Regular.Eye,
                            contentDescription = if (showPassword) "Hide password" else "Show password",
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
            )
        }

        DemoBlock(title = "Error") {
            OutlinedTextField(
                value = invalidEmail,
                onValueChange = { invalidEmail = it },
                label = { Text("Email") },
                isError = true,
                description = { Text("Enter a valid email address.") },
                modifier = Modifier.fillMaxWidth(),
            )
        }

        DemoBlock(title = "Multiline") {
            OutlinedTextField(
                value = bio,
                onValueChange = { bio = it },
                label = { Text("Bio") },
                placeholder = { Text("Tell us something about yourself") },
                minLines = 3,
                maxLines = 5,
                modifier = Modifier.fillMaxWidth(),
            )
        }

        DemoBlock(title = "Disabled and read only") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                OutlinedTextField(
                    value = disabled,
                    onValueChange = {},
                    label = { Text("Disabled") },
                    enabled = false,
                    modifier = Modifier.fillMaxWidth(),
                )
                OutlinedTextField(
                    value = disabled,
                    onValueChange = {},
                    label = { Text("Read only") },
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }

        DemoBlock(title = "Live value") {
            Text(
                text = "name = \"$name\" · email = \"$email\"",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
        }
    }
}
