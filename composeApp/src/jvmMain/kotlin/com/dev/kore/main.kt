package com.dev.kore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.dev.korelibrary.src.Components.Buttons.PrimaryButton

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Kore",
    ) {
        App()
    }
}