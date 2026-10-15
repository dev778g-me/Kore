package com.dev.codesamples.samples.iconbuttons

import androidx.compose.runtime.Composable
import com.dev.kore.components.buttons.OutlinedIconButton
import com.dev.kore.components.icon.Icon
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Asterisk

// <sample id="iconbutton-outlined">
@Composable
fun OutlinedIconButtonSample() {
    OutlinedIconButton(
        onClick = { },
    ) {
        Icon(
            imageVector = PhIcons.Regular.Asterisk,
            contentDescription = "Delete"
        )
    }
}
// <sample/>
