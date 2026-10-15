package com.dev.codesamples.samples.radiobutton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.dev.kore.components.radio.RadioButton
import com.dev.kore.components.text.Text

// <sample id="radiobutton-basic">

@Composable
fun RadioButtonBasicSample() {
    val options = listOf("Standard", "Premium", "Enterprise")
    var selectedOption by remember { mutableStateOf(options[0]) }
    Column {
        options.forEach { text ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { selectedOption = text },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = text)
            }
        }
    }
}

// <sample/>
