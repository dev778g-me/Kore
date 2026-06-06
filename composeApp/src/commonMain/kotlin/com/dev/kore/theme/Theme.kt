package com.dev.kore.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreColorScheme
import com.dev.kore.themes.KoreShapes
import com.dev.kore.themes.KoreSizes
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.colors.RadixColors
import androidx.compose.ui.graphics.Color
import com.dev.kore.themes.colors.TailwindColors
import com.dev.kore.themes.shapes.AbsoluteSmoothCornerShape

val lightColorScheme = KoreColorScheme(
    background = RadixColors.Gray.light.step3,
    onBackGround = RadixColors.Gray.light.step12,
    backGroundVariant = RadixColors.Gray.light.step7,
    onBackGroundVariant = RadixColors.Gray.light.step10,
    surface = RadixColors.Gray.light.step2,
    onSurface = RadixColors.Gray.light.step11,
    surfaceBright = RadixColors.Gray.light.step1,
    onSurfaceBright = RadixColors.Gray.light.step12,
    primary = TailwindColors.Blue.swatch500,
    onPrimary = TailwindColors.Blue.swatch50,
    primaryContainer = RadixColors.Blue.light.step6,
    onPrimaryContainer = RadixColors.Blue.light.step10,
    complementary = RadixColors.Orange.light.step9,
    onComplementary = RadixColors.Orange.light.step1,
    complementaryContainer = RadixColors.Orange.light.step6,
    onComplementaryContainer = RadixColors.Orange.light.step10,
    success = RadixColors.Green.light.step9,
    onSuccess = RadixColors.Green.light.step2,
    error = RadixColors.Red.light.step9,
    onError = RadixColors.Red.light.step2,
    disabled = RadixColors.Gray.light.step5,
    onDisabled = RadixColors.Gray.light.step8,
    transparent = Color.Transparent
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
    primary = RadixColors.Blue.light.step9,
    onPrimary = RadixColors.Blue.dark.step12,
    primaryContainer = RadixColors.Blue.dark.step3,
    onPrimaryContainer = RadixColors.Blue.dark.step10,
    complementary = RadixColors.Orange.light.step9,
    onComplementary = RadixColors.Orange.dark.step12,
    complementaryContainer = RadixColors.Orange.dark.step3,
    onComplementaryContainer = RadixColors.Orange.dark.step10,
    success = RadixColors.Green.light.step9,
    onSuccess = RadixColors.Green.dark.step12,
    error = RadixColors.Red.light.step9,
    onError = RadixColors.Red.dark.step12,
    disabled = RadixColors.Gray.dark.step3,
    onDisabled = RadixColors.Gray.dark.step8,
    transparent = Color.Transparent
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
    xl = AbsoluteSmoothCornerShape(34.dp),
    lg = AbsoluteSmoothCornerShape(24.dp),
    md = AbsoluteSmoothCornerShape(16.dp),
    sm = AbsoluteSmoothCornerShape(12.dp),
    xs = AbsoluteSmoothCornerShape(8.dp)
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    shape: KoreShapes = shapes,
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