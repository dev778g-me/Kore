package com.dev.themebuilder.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.korelibrary.themes.KoreColorScheme
import com.dev.korelibrary.themes.KoreDefaults
import com.dev.korelibrary.themes.KoreTheme
import com.dev.themebuilder.ui.model.ShapeType
import com.dev.themebuilder.ui.viewmodel.ThemeViewModel


@Composable
fun BuilderTheme(
    content : @Composable () -> Unit,
    isDark : Boolean = false
){

    val viewModel : ThemeViewModel = viewModel { ThemeViewModel() }

    val lightNeutralColors by viewModel.lightNeutralColors.collectAsStateWithLifecycle()

    val lightPrimaryColors by viewModel.lightPrimaryColors.collectAsStateWithLifecycle()

    val lightComplementaryColors by viewModel.lightComplementaryColors.collectAsStateWithLifecycle()

    val lightSuccessErrorColors by viewModel.lightSuccessErrorColors.collectAsStateWithLifecycle()

    val provideShape by viewModel.provideShape.collectAsStateWithLifecycle()

    val provideSizes by viewModel.provideSizes.collectAsStateWithLifecycle()

    val builderLightScheme by viewModel.currentLightColorScheme.collectAsStateWithLifecycle()


    val darkPrimaryColors by viewModel.darkPrimaryColors.collectAsStateWithLifecycle()

    val darkNeutralColors by viewModel.darkNeutralColors.collectAsStateWithLifecycle()

    val darkComplementaryColors by viewModel.darkComplementaryColors.collectAsStateWithLifecycle()

    val errorSuccessColors by viewModel.darkSuccessErrorColors.collectAsStateWithLifecycle()

    
    
    val builderDarkScheme by viewModel.currentDarkColorScheme.collectAsStateWithLifecycle()



    val shape = if (provideShape == ShapeType.RoundedRectangle) KoreDefaults.defaultShapes else KoreDefaults.defaultSquircleShapes

    KoreTheme(
        shapes = shape,
        sizes = provideSizes,
        content = content,
        colorScheme = if (isDark) builderDarkScheme else builderLightScheme
    )
}
