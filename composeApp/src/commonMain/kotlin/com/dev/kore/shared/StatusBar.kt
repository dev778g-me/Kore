package com.dev.kore.shared

import androidx.compose.runtime.Composable

/**
 * Updates the system status bar appearance (light or dark) to match the
 * active theme of the showcase app.
 *
 * The implementation lives in the platform source sets so it can use the
 * Android window insets controller.
 */
@Composable
expect fun StatusBarAppearance(darkTheme: Boolean)
