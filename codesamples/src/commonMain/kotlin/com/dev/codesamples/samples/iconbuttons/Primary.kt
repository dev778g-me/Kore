package com.dev.codesamples.samples.iconbuttons

import androidx.compose.runtime.Composable
import com.dev.kore.components.buttons.PrimaryIconButton
import com.dev.kore.components.icon.Icon
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Plus

// <sample id="iconbutton-primary">
@Composable
fun PrimaryIconButtonSample() {
    PrimaryIconButton(
        onClick = { }
    ) {
        Icon(
            imageVector = PhIcons.Regular.Plus,
            contentDescription = "Add Item"
        )
    }
}
// <sample/>
