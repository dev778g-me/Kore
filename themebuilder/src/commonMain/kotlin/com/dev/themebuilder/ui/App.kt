package com.dev.themebuilder.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.dev.themebuilder.ui.theme.BuilderTheme
import com.dev.themebuilder.ui.view.screens.HomeScreen

@Composable
@Preview
fun ThemeApp() {


    var isDark by remember { mutableStateOf(false) }

    BuilderTheme(
        isDark = isDark,
        content = {
            HomeScreen(
                isDark = isDark,
                onClick = {
                    isDark = !isDark
                }
            )
        }
    )
}