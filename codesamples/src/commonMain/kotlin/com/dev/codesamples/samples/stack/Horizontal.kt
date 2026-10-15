package com.dev.codesamples.samples.stack

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dev.kore.components.buttons.GhostButton
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.stack.HorizontalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme

// <sample id="stack-horizontal">

@Composable
fun StackHorizontalSample() {
    HorizontalStack(
        modifier = Modifier.fillMaxWidth(),
        spacing = KoreTheme.sizes.sm,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GhostButton(onClick = { }) { Text("Cancel") }
        PrimaryButton(onClick = { }) { Text("Save Changes") }
    }
}

// <sample/>
