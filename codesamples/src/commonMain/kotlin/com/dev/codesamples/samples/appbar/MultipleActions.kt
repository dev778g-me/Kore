package com.dev.codesamples.samples.appbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dev.kore.components.appbar.Appbar
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Bell
import com.phosphor.icons.regular.CaretLeft
import com.phosphor.icons.regular.DotsThreeVertical

// <sample id="appbar-multiple-actions">

@Composable
fun AppbarMultipleActionsSample() {
    Appbar(
        title = { Text("Settings") },
        elevation = 8.dp,
        navigationIcon = {
            GhostIconButton(onClick = { }) {
                Icon(imageVector = PhIcons.Regular.CaretLeft, contentDescription = "Back")
            }
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
            GhostIconButton(
                onClick = { },
                content = {
                    Icon(
                        imageVector = PhIcons.Regular.Bell,
                        contentDescription = ""
                    )
                }
            )
        }
    )
}

// <sample/>
