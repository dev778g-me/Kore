package com.dev.themebuilder.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dev.kore.themes.KoreDefaults
import com.dev.kore.themes.KoreTheme
import com.dev.themebuilder.ui.models.ShapeType
import com.dev.themebuilder.ui.viewmodel.ThemeViewModel


@Composable
fun BuilderTheme(
    isDark: Boolean = false,
    viewModel: ThemeViewModel,
    content: @Composable () -> Unit,
) {
    val provideShape by viewModel.provideShape.collectAsStateWithLifecycle()
    val provideSizes by viewModel.provideSizes.collectAsStateWithLifecycle()
    val builderLightScheme by viewModel.currentLightColorScheme.collectAsStateWithLifecycle()
    val builderDarkScheme by viewModel.currentDarkColorScheme.collectAsStateWithLifecycle()

    val shape = if (provideShape == ShapeType.RoundedRectangle) KoreDefaults.defaultShapes else KoreDefaults.defaultSmoothCornerShapes

        KoreTheme(
            shapes = shape,
            sizes = provideSizes,
            content = content,
            colorScheme = if (isDark) builderDarkScheme else builderLightScheme
        )

}
