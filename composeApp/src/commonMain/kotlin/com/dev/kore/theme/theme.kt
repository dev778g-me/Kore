package com.dev.kore.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.dev.korelibrary.themes.KoreColorScheme
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.themes.colors.RadixColors
import com.dev.korelibrary.themes.colors.TailwindColors

val lightColorScheme = KoreColorScheme(
    background = RadixColors.Gray.light.step5,
    onBackGround = RadixColors.Gray.light.step12,

    backGroundVariant = RadixColors.Gray.light.step7,
    onBackGroundVariant = RadixColors.Gray.light.step10,
    accent = RadixColors.Blue.light.step4,

    disabled = RadixColors.Gray.light.step6,
    onDisabled = RadixColors.Gray.light.step8,

    primary = RadixColors.Gold.light.step9,
    onPrimary = RadixColors.Gold.light.step2,

    primaryContainer = RadixColors.Gold.light.step6,
    onPrimaryContainer = RadixColors.Gold.light.step10,

    secondary = TailwindColors.Sky500,
    onSecondary = TailwindColors.Sky100,
    secondaryContainer = TailwindColors.Sky300,
    onSecondaryContainer = TailwindColors.Sky900,

    success = RadixColors.Green.light.step9,
    onSuccess = RadixColors.Green.light.step3,

    error = RadixColors.Red.light.step9,
    onError = RadixColors.Red.light.step3,
    transparent = Color.Transparent,

    surface = RadixColors.Gray.light.step4,
    onSurface = RadixColors.Gray.light.step11,
    surfaceBright = RadixColors.Gray.light.step2,
    onSurfaceBright = RadixColors.Gray.light.step12
)

val darkColorScheme = KoreColorScheme(
    // background and background variant
    background = RadixColors.Gray.dark.step1,
    onBackGround = RadixColors.Gray.dark.step12,

    backGroundVariant = RadixColors.Gray.dark.step5,
    onBackGroundVariant = RadixColors.Gray.dark.step11,
    accent = RadixColors.Blue.dark.step1,
    // disabled colors
    disabled = RadixColors.Gray.dark.step3,
    onDisabled = RadixColors.Gray.dark.step8,

    // primary colors
    primary = RadixColors.Gold.dark.step9,
    onPrimary = RadixColors.Gold.dark.step12,

    primaryContainer = RadixColors.Gold.dark.step3,
    onPrimaryContainer = RadixColors.Gold.dark.step10,

    secondary = TailwindColors.Sky600,
    onSecondary = TailwindColors.Sky900,
    secondaryContainer = TailwindColors.Sky700,
    onSecondaryContainer = TailwindColors.Blue700,


    // success colors
    success = RadixColors.Green.dark.step9,
    onSuccess = RadixColors.Green.dark.step12,

    // error colors
    error = RadixColors.Red.dark.step9,
    onError = RadixColors.Red.dark.step12,
    transparent = Color.Transparent,
    surface = RadixColors.Gray.dark.step2,
    onSurface = RadixColors.Gray.dark.step11,

    surfaceBright = RadixColors.Gray.dark.step3,
    onSurfaceBright = RadixColors.Gray.dark.step12
)

@Composable
fun too(
 content : @Composable () -> Unit
){
    if (isSystemInDarkTheme()) darkColorScheme else lightColorScheme
    KoreTheme(
        colorScheme = darkColorScheme
    ){
content()
    }
}



