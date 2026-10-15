package com.dev.codesamples.samples.stack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.LockKey

// <sample id="stack-centered-form">

@Composable
fun StackCenteredFormSample() {
    VerticalStack(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(KoreTheme.colorScheme.surface),
        verticalAlignment = Alignment.CenterVertically,
        spacing = 16.dp
    ) {
        Icon(imageVector = PhIcons.Regular.LockKey, contentDescription = null)
        Text("Please log in to continue")
    }
}

// <sample/>
