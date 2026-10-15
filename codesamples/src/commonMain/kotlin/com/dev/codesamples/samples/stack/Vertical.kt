package com.dev.codesamples.samples.stack

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme

// <sample id="stack-vertical">

@Composable
fun StackVerticalSample() {
    VerticalStack(
        spacing = KoreTheme.sizes.md,
        horizontalAlignment = Alignment.Start
    ) {
        Text("User Profile", textStyle = KoreTheme.typography.heading3)
        Text("Manage your account settings below.")
        PrimaryButton(onClick = { }) {
            Text("Edit Profile")
        }
    }
}

// <sample/>
