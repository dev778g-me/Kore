package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.components.textFields.OutlinedTextField
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Eye
import com.phosphor.icons.regular.Lock

@Composable
fun TextFieldDocs(
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp)
    ) {
        DefaultMarkdownParser(
            content = """# Outlined Text Field

An **Outlined Text Field** is a primary input component that allows users to enter and edit text. It features a visible border (outline) that clearly defines the hit area and structure of the input field, making it immediately recognizable as an interactive element.

> For deeper reference, see the [Material Design](https://m3.material.io/components/text-fields/overview) guidelines on text fields.

---

## When to Use

**Use** an Outlined Text Field for:
- Standard data entry forms (e.g., sign-up flows, shipping addresses)
- Short inputs like usernames, email addresses, and passwords
- Multi-line text areas (e.g., a "comments" section)

**Avoid** an Outlined Text Field when:
- The input needs to blend seamlessly into a surrounding layout (e.g., a search bar in a header)
- The UI space is too tight and the visual weight of the outline creates clutter

---

## Basic Example

| Slot            | Description                                                    |
|-----------------|----------------------------------------------------------------|
| `value`         | The current text string to display in the input field.         |
| `onValueChange` | The callback invoked when the user types or modifies the text. |

<figure><img src="showcases/textfieldShowcase/outlined_texfield.png" alt="Textfield example image "><figcaption></figcaption></figure>
"""
        )

        ComponentShowcase(
            code = """
var email by remember { mutableStateOf("") }

OutlinedTextField(
    value = email,
    onValueChange = { email = it },
    label = { Text("Email Address") },
    placeholder = { Text("example@domain.com") }
)
""".trimIndent(),
            content = {
                var email by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email Address") },
                    placeholder = { Text("example@domain.com") }
                )
            }
        )

        DefaultMarkdownParser(
            content = """
---

## Styling
Textfield exposes several parameters to customize its appearance and layou

### Parameters

| Parameter             | Type                          | Default                                   | Description                                                                               |
|-----------------------|-------------------------------|-------------------------------------------|-------------------------------------------------------------------------------------------|
| `modifier`            | `Modifier`                    | `Modifier`                                | Applied to the outer layout of the text field.                                            |
| `enabled`             | `Boolean`                     | `true`                                    | Controls interactive state. When `false`, the field ignores input.                        |
| `readOnly`            | `Boolean`                     | `false`                                   | When `true`, the field cannot be modified but can still be focused.                       |
| `textStyle`           | `TextStyle?`                  | `null`                                    | The typography style applied to the typed input text.                                     |
| `label`               | `@Composable (() -> Unit)?`   | `null`                                    | Text that sits inside the field and floats to the border when focused.                    |
| `placeholder`         | `@Composable (() -> Unit)?`   | `null`                                    | Hint text that appears when the field is empty and focused.                               |
| `leadingIcon`         | `@Composable (() -> Unit)?`   | `null`                                    | An optional icon displayed at the start (left) of the text field.                        |
| `trailingIcon`        | `@Composable (() -> Unit)?`   | `null`                                    | An optional icon displayed at the end (right) of the text field.                          |
| `description`         | `@Composable (() -> Unit)?`   | `null`                                    | Helper or error text displayed beneath the field.                                          |
| `isError`             | `Boolean`                     | `false`                                   | Visually highlights the field (border, label, etc.) to indicate a validation failure.     |
| `visualTransformation`| `VisualTransformation`        | `VisualTransformation.None`               | Alters the visual presentation of text (e.g., masking passwords).                        |
| `keyboardOptions`     | `KeyboardOptions`             | `KeyboardOptions.Default`                 | Configures the software keyboard (e.g., number pad vs. text).                            |
| `keyboardActions`     | `KeyboardActions`             | `KeyboardActions.Default`                 | Defines what software keyboard action keys (like "Done") do.                             |
| `singleLine`          | `Boolean`                     | `false`                                   | Forces the input to remain on one horizontal line.                                        |
| `maxLines`            | `Int`                         | `Int.MAX_VALUE`                           | Maximum visible lines before the internal text starts scrolling vertically.               |
| `minLines`            | `Int`                         | `1`                                       | Minimum height of the text field, defined by number of visible lines.                    |
| `shape`               | `Shape`                       | `TextFieldDefaults.defaultTextFieldShape` | The geometric shape applied to the boundary line of the text field.                      |
| `borderWidth`         | `OutlinedBorderWidth`         | `TextFieldDefaults.defaultBorderWidth()`  | The thickness of the outline border across different states.                              |
| `textFieldColors`     | `TextFieldColors`             | `TextFieldDefaults.outlinedTextFieldColors()` | Colors for all text, backgrounds, and borders across all states.                     |

---

### Password with Error Handling

The `leadingIcon`, `trailingIcon`, and `description` slots combine to create complex inputs with real-time validation feedback — ideal for password fields.

<figure><img src="showcases/textfieldShowcase/password_textfield.png"Password Textfield example image "><figcaption></figcaption></figure>
"""
        )

        ComponentShowcase(
            code = """
var password by remember { mutableStateOf("") }
val isError = password.isNotEmpty() && password.length < 8

OutlinedTextField(
    value = password,
    onValueChange = { password = it },
    label = { Text("Password") },
    leadingIcon = {
        Icon(imageVector = PhIcons.Regular.Lock, contentDescription = null)
    },
    trailingIcon = {
        Icon(imageVector = PhIcons.Regular.Eye, contentDescription = "Toggle visibility")
    },
    description = {
        if (isError) {
            Text("Password must be at least 8 characters.")
        } else {
            Text("Use a secure, unique password.")
        }
    },
    isError = isError,
    visualTransformation = PasswordVisualTransformation(),
    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
)
""".trimIndent(),
            content = {
                var password by remember { mutableStateOf("") }
                val isError = password.isNotEmpty() && password.length < 8
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    leadingIcon = {
                        Icon(imageVector = PhIcons.Regular.Lock, contentDescription = null)
                    },
                    trailingIcon = {
                        Icon(imageVector = PhIcons.Regular.Eye, contentDescription = "Toggle visibility")
                    },
                    description = {
                        if (isError) {
                            Text("Password must be at least 8 characters.")
                        } else {
                            Text("Use a secure, unique password.")
                        }
                    },
                    isError = isError,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
            }
        )

        DefaultMarkdownParser(
            content = """
### Multi-line Text Area

To create a text area suitable for notes or comments, set `singleLine = false` and provide a higher `minLines` value. This ensures the field starts out tall, signalling to users that a longer response is expected.


<figure><img src="showcases/textfieldShowcase/Custom_outlinedField.png" alt="Custom Textfield example image "><figcaption></figcaption></figure>
"""
        )

        ComponentShowcase(
            code = """
var bio by remember { mutableStateOf("") }

OutlinedTextField(
    value = bio,
    onValueChange = { bio = it },
    label = { Text("About Me") },
    singleLine = false,
    minLines = 4,
    maxLines = 10,
    modifier = Modifier.fillMaxWidth()
)
""".trimIndent(),
            content = {
                var bio by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = bio,
                    onValueChange = { bio = it },
                    label = { Text("About Me") },
                    singleLine = false,
                    minLines = 4,
                    maxLines = 10,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        )
    }
}