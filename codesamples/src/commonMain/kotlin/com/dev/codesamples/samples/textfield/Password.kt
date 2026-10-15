package com.dev.codesamples.samples.textfield

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.components.textFields.OutlinedTextField
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Eye
import com.phosphor.icons.regular.Lock


// <sample id="textfield-password">

@Composable
fun TextFieldPasswordSample() {
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

// <sample/>
