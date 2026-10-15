package com.dev.codesamples.samples.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.dev.kore.components.text.Text
import com.dev.kore.components.textFields.OutlinedTextField


// <sample id="textfield-multiline">

@Composable
fun TextFieldMultilineSample() {
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

// <sample/>
