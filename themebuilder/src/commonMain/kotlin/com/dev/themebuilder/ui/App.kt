package com.dev.themebuilder.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.themebuilder.ui.theme.BuilderTheme
import com.dev.themebuilder.ui.view.BuilderScaffold
import com.dev.themebuilder.ui.viewmodel.ThemeViewModel

@Preview
@Composable
fun ThemeApp(initialDark: Boolean? = null) {
    val systemDark = isSystemInDarkTheme()
    var isDark by remember { mutableStateOf(initialDark ?: systemDark) }
    val viewModel: ThemeViewModel = viewModel { ThemeViewModel() }

    BuilderTheme(isDark = isDark, viewModel = viewModel) {
        BuilderScaffold(
            viewModel = viewModel,
            isDark = isDark,
            onThemeChange = { isDark = !isDark },
        )
    }
}
