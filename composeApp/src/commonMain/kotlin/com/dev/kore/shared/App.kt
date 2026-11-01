package com.dev.kore.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.dev.kore.motions.MotionConfig
import com.dev.kore.shared.StatusBarAppearance
import com.dev.kore.shared.navigation.KoreNavHost
import com.dev.kore.shared.theme.AppSettings
import com.dev.kore.shared.theme.AppTheme
import com.dev.kore.shared.theme.LocalAppSettings
import com.dev.kore.themes.IndicationType
import com.dev.kore.themes.KoreDefaults
import com.dev.kore.themes.KoreTheme

/**
 * The entry point of the Kore showcase app.
 *
 * Holds the only app wide state (theme mode, indication and motion presets)
 * and hands the rest over to the navigation graph.
 */
@Composable
fun App() {
    val systemIsDark = isSystemInDarkTheme()
    var isDark by remember { mutableStateOf(systemIsDark) }
    var indicationType by remember { mutableStateOf(IndicationType.Scale) }
    var pressScale by remember { mutableStateOf(KoreDefaults.defaultPressScale) }
    var motion by remember { mutableStateOf(MotionConfig.Balanced) }

    val settings = remember(isDark, indicationType, pressScale, motion) {
        AppSettings(
            isDark = isDark,
            indicationType = indicationType,
            pressScale = pressScale,
            motion = motion,
            onToggleDark = { isDark = !isDark },
            onIndicationChange = { indicationType = it },
            onPressScaleChange = { pressScale = it },
            onMotionChange = { motion = it },
        )
    }

    StatusBarAppearance(darkTheme = isDark)

    CompositionLocalProvider(LocalAppSettings provides settings) {
        AppTheme(
            darkTheme = isDark,
            indicationType = indicationType,
            pressScale = pressScale,
            motion = motion,
        ) {
            // The window background fills the whole screen, including the area
            // behind the system status bar, so the status bar follows the theme.
            Box(
                modifier = Modifier.fillMaxSize().background(KoreTheme.colorScheme.background),
            ) {
                KoreNavHost()
            }
        }
    }
}
