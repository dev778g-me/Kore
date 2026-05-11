package com.dev.themebuilder.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.dev.themebuilder.ui.theme.BuilderTheme
import com.dev.themebuilder.ui.view.navigation.BuilderNavHost

@Preview
@Composable
fun ThemeApp(
    onNavHostReady: suspend (NavController) -> Unit = {},
    onOpenUrl: (String) -> Unit = {}
) {
    var isDark by remember { mutableStateOf(false) }

    BuilderTheme(isDark = isDark) {
        BuilderNavHost(onNavHostReady, onOpenUrl)
    }
}
