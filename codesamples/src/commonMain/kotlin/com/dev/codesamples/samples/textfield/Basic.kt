package com.dev.codesamples.samples.textfield

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.text.Text
import com.dev.kore.components.textFields.OutlinedTextField


// <sample id="textfield-basic">

@Composable
fun TextFieldBasicSample() {
    var email by remember { mutableStateOf("") }
    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Email Address") },
        placeholder = { Text("example@domain.com") }
    )
}

// <sample/>
