package com.dev.themebuilder

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.dev.themebuilder.ui.ThemeApp
import kore.themebuilder.generated.resources.Res
import kore.themebuilder.generated.resources.icon_desktop
import org.jetbrains.compose.resources.painterResource
import java.awt.Desktop
import java.net.URI

fun main() = application {
    val appIcon = painterResource(resource = Res.drawable.icon_desktop)
    Window(
        state = rememberWindowState(
           placement = WindowPlacement.Maximized
        ),
        icon = appIcon,
        onCloseRequest = ::exitApplication,
        title = "Kore",
    ) {

        ThemeApp(
            onOpenUrl = { url ->
                try {
                    Desktop.getDesktop().browse(URI(url))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        )
    }
}
