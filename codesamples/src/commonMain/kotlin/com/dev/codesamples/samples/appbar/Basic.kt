package com.dev.codesamples.samples.appbar

import androidx.compose.runtime.Composable
import com.dev.kore.components.appbar.Appbar
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.CaretLeft
import com.phosphor.icons.regular.DotsThreeVertical

// <sample id="appbar-basic">

@Composable
fun AppbarBasicSample() {
    Appbar(
        title = {
            Text("Kore")
        },
        navigationIcon = {
            GhostIconButton(
                onClick = { },
                content = {
                    Icon(
                        imageVector = PhIcons.Regular.CaretLeft,
                        contentDescription = ""
                    )
                }
            )
        },
        appBarAction = {
            GhostIconButton(
                onClick = { },
                content = {
                    Icon(
                        imageVector = PhIcons.Regular.DotsThreeVertical,
                        contentDescription = ""
                    )
                }
            )
        }
    )
}

// <sample/>
