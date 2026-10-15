package com.dev.codesamples.samples.modifierext

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.card.Card
import com.dev.kore.components.text.Text
import com.dev.kore.components.textFields.OutlinedTextField
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.modifiers.clearFocusOnTap
import com.dev.kore.utilities.modifiers.dashedBorder

// <sample id="modifierext-clear-focus-on-tap">
@Composable
fun ClearFocusOnTapSample() {
    var inputText by remember { mutableStateOf("") }
    Card(
        modifier = Modifier.height(400.dp).fillMaxWidth()
            .clearFocusOnTap()
            .dashedBorder(
                color = KoreTheme.colorScheme.backGroundVariant,
                shape = KoreTheme.shapes.sm
            )
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            OutlinedTextField(
                value = inputText,
                label = { Text("Enter Text here") },
                placeholder = { Text("Tap outside to clear focus") },
                onValueChange = { inputText = it }
            )
        }
    }
}
// <sample/>
