package com.dev.kore

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.dev.kore.shared.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Kore",
    ) {
        App()
    }
}