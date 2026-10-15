package com.dev.codesamples.samples.iconbuttons

import androidx.compose.runtime.Composable
import com.dev.kore.components.buttons.IconButtonDefaults
import com.dev.kore.components.buttons.PrimaryIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.colors.RadixColors
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Asterisk

// <sample id="iconbutton-custom">
@Composable
fun PrimaryIconButtonWithCustomShapeAndColors() {
    PrimaryIconButton(
        shape = KoreTheme.shapes.sm,
        onClick = {},
        primaryIconButtonColors = IconButtonDefaults.primaryIconButtonColors(
            iconButtonContainerColor = RadixColors.Orange.dark.step9,
            iconButtonContentColor = RadixColors.Orange.dark.step12
        )
    ) {
        Icon(imageVector = PhIcons.Regular.Asterisk, contentDescription = "")
    }
}
// <sample/>
