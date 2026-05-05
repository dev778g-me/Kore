package com.dev.kore.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.themes.KoreColorScheme
import com.dev.korelibrary.themes.KoreShapes
import androidx.compose.foundation.shape.RoundedCornerShape
import com.dev.korelibrary.themes.KoreDefaults
import com.dev.korelibrary.themes.KoreSizes
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.themes.colors.RadixColors

val lightColorScheme = KoreColorScheme(
    background = RadixColors.Gray.light.step4,
    onBackGround = RadixColors.Gray.light.step12,
    backGroundVariant = RadixColors.Gray.light.step7,
    onBackGroundVariant = RadixColors.Gray.light.step10,
    surface = RadixColors.Gray.light.step3,
    onSurface = RadixColors.Gray.light.step11,
    surfaceBright = RadixColors.Gray.light.step1,
    onSurfaceBright = RadixColors.Gray.light.step12,
    primary = RadixColors.Iris.light.step9,
    onPrimary = RadixColors.Iris.light.step1,
    primaryContainer = RadixColors.Iris.light.step6,
    onPrimaryContainer = RadixColors.Iris.light.step10,
    complementary = RadixColors.Amber.light.step9,
    onComplementary = RadixColors.Amber.light.step1,
    complementaryContainer = RadixColors.Amber.light.step6,
    onComplementaryContainer = RadixColors.Amber.light.step10,
    success = RadixColors.Green.light.step9,
    onSuccess = RadixColors.Green.light.step2,
    error = RadixColors.Red.light.step9,
    onError = RadixColors.Red.light.step2,
    disabled = RadixColors.Gray.light.step5,
    onDisabled = RadixColors.Gray.light.step8,
    transparent = Color(0x0)
)

val darkColorScheme = KoreColorScheme(
    background = RadixColors.Gray.dark.step1,
    onBackGround = RadixColors.Gray.dark.step12,
    backGroundVariant = RadixColors.Gray.dark.step5,
    onBackGroundVariant = RadixColors.Gray.dark.step11,
    surface = RadixColors.Gray.dark.step2,
    onSurface = RadixColors.Gray.dark.step11,
    surfaceBright = RadixColors.Gray.dark.step3,
    onSurfaceBright = RadixColors.Gray.dark.step12,
    primary = RadixColors.Iris.light.step9,
    onPrimary = RadixColors.Iris.dark.step12,
    primaryContainer = RadixColors.Iris.dark.step3,
    onPrimaryContainer = RadixColors.Iris.dark.step10,
    complementary = RadixColors.Amber.light.step9,
    onComplementary = RadixColors.Amber.dark.step12,
    complementaryContainer = RadixColors.Amber.dark.step3,
    onComplementaryContainer = RadixColors.Amber.dark.step10,
    success = RadixColors.Green.light.step9,
    onSuccess = RadixColors.Green.dark.step12,
    error = RadixColors.Red.light.step9,
    onError = RadixColors.Red.dark.step12,
    disabled = RadixColors.Gray.dark.step3,
    onDisabled = RadixColors.Gray.dark.step8,
    transparent = Color(0x0)
)

val sizes = KoreSizes(
    xl = 34.0.dp,
    lg = 24.0.dp,
    md = 16.0.dp,
    sm = 12.0.dp,
    xs = 8.0.dp,
    xxs = 4.0.dp
)

val shapes = KoreShapes(
    xl = RoundedCornerShape(34.0.dp),
    lg = RoundedCornerShape(24.0.dp),
    md = RoundedCornerShape(16.0.dp),
    sm = RoundedCornerShape(12.0.dp),
    xs = RoundedCornerShape(8.0.dp)
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    shape: KoreShapes = KoreDefaults.defaultSquircleShapes,
    size: KoreSizes = sizes,
    content: @Composable () -> Unit
) {
    val colorScheme = if(darkTheme) darkColorScheme else lightColorScheme
    
    KoreTheme(
       shapes = shape,
       sizes = size,
       colorScheme = colorScheme,
    ) {
        content()
    }
}