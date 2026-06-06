package com.dev.themebuilder.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dev.themebuilder.ui.theme.BuilderTheme
import com.dev.themebuilder.ui.view.navigation.BuilderNavHost
import com.dev.themebuilder.ui.viewmodel.ThemeViewModel

@Preview
@Composable
fun ThemeApp(
    onNavHostReady: suspend (NavController) -> Unit = {},
    onOpenUrl: (String) -> Unit = {}
) {

    val isDarkValue = isSystemInDarkTheme()
    var isDark by remember { mutableStateOf(isDarkValue) }
    val viewModel: ThemeViewModel = viewModel { ThemeViewModel() }

    BuilderTheme(isDark = isDark, viewModel = viewModel) {
        BuilderNavHost(
            viewModel = viewModel, onNavHostReady,
            onThemeChange = {
                isDark = !isDark
            },
            isDark = isDark,
            onOpenUrl = onOpenUrl
        )
    }
}
