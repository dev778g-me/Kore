package com.dev.themebuilder.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.korelibrary.themes.KoreColorScheme
import com.dev.korelibrary.themes.KoreDefaults
import com.dev.korelibrary.themes.KoreTheme
import com.dev.themebuilder.ui.models.ShapeType
import com.dev.themebuilder.ui.viewmodel.ThemeViewModel

val LocalThemeViewModel = compositionLocalOf<ThemeViewModel> { error("No ThemeViewModel provided") }

@Composable
fun BuilderTheme(
    isDark: Boolean = false,
    content: @Composable () -> Unit,
) {
    val viewModel: ThemeViewModel = viewModel { ThemeViewModel() }

    val provideShape by viewModel.provideShape.collectAsStateWithLifecycle()
    val provideSizes by viewModel.provideSizes.collectAsStateWithLifecycle()
    val builderLightScheme by viewModel.currentLightColorScheme.collectAsStateWithLifecycle()
    val builderDarkScheme by viewModel.currentDarkColorScheme.collectAsStateWithLifecycle()

    val shape = if (provideShape == ShapeType.RoundedRectangle) KoreDefaults.defaultShapes else KoreDefaults.defaultSquircleShapes

    CompositionLocalProvider(LocalThemeViewModel provides viewModel) {
        KoreTheme(
            shapes = shape,
            sizes = provideSizes,
            content = content,
            colorScheme = if (isDark) builderDarkScheme else builderLightScheme
        )
    }
}
