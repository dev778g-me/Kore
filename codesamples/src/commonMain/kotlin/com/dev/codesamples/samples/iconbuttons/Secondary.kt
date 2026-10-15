package com.dev.codesamples.samples.iconbuttons

import androidx.compose.runtime.Composable
import com.dev.kore.components.buttons.SecondaryIconButton
import com.dev.kore.components.icon.Icon
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Asterisk

// <sample id="iconbutton-secondary">
@Composable
fun SecondaryIconButtonSample() {
    SecondaryIconButton(
        onClick = { }
    ) {
        Icon(
            imageVector = PhIcons.Regular.Asterisk,
            contentDescription = "Edit"
        )
    }
}
// <sample/>
