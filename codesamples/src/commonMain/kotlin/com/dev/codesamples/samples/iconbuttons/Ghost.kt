package com.dev.codesamples.samples.iconbuttons

import androidx.compose.runtime.Composable
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.icon.Icon
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Asterisk

// <sample id="iconbutton-ghost">
@Composable
fun GhostIconButtonSample() {
    GhostIconButton(
        onClick = { }
    ) {
        Icon(
            imageVector = PhIcons.Regular.Asterisk,
            contentDescription = "More Options"
        )
    }
}
// <sample/>
