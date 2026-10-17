package com.dev.themebuilder

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.dev.themebuilder.ui.ThemeApp
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val body = document.body ?: return

    // The Astro host (/create) sets data-theme from the site's stored preference.
    // When absent, the app follows the system theme.
    val siteTheme = document.documentElement?.getAttribute("data-theme")

    ComposeViewport(body) {
        ThemeApp(initialDark = siteTheme?.let { it == "dark" })
    }
}
