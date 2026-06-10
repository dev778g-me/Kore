package com.dev.kore.shared.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreColorScheme
import com.dev.kore.themes.KoreShapes
import com.dev.kore.themes.shapes.AbsoluteSmoothCornerShape
import com.dev.kore.themes.KoreSizes
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.colors.TailwindColors
import com.dev.kore.themes.colors.RadixColors
import androidx.compose.ui.graphics.Color

val lightColorScheme = KoreColorScheme(
    background = RadixColors.Gray.light.step4,
    onBackGround = RadixColors.Gray.light.step12,
    backGroundVariant = RadixColors.Gray.light.step7,
    onBackGroundVariant = RadixColors.Gray.light.step10,
    surface = RadixColors.Gray.light.step3,
    onSurface = RadixColors.Gray.light.step11,
    surfaceBright = RadixColors.Gray.light.step1,
    onSurfaceBright = RadixColors.Gray.light.step12,
    primary = TailwindColors.Blue.swatch600,
    onPrimary = TailwindColors.Blue.swatch50,
    primaryContainer = TailwindColors.Blue.swatch300,
    onPrimaryContainer = TailwindColors.Blue.swatch900,
    complementary = TailwindColors.Orange.swatch600,
    onComplementary = TailwindColors.Orange.swatch50,
    complementaryContainer = TailwindColors.Orange.swatch300,
    onComplementaryContainer = TailwindColors.Orange.swatch900,
    success = TailwindColors.Green.swatch600,
    onSuccess = TailwindColors.Green.swatch50,
    error = TailwindColors.Red.swatch600,
    onError = TailwindColors.Red.swatch50,
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
    primary = TailwindColors.Blue.swatch600,
    onPrimary = TailwindColors.Blue.swatch50,
    primaryContainer = TailwindColors.Blue.swatch950,
    onPrimaryContainer = TailwindColors.Blue.swatch200,
    complementary = TailwindColors.Orange.swatch600,
    onComplementary = TailwindColors.Orange.swatch50,
    complementaryContainer = TailwindColors.Orange.swatch950,
    onComplementaryContainer = TailwindColors.Orange.swatch200,
    success = TailwindColors.Green.swatch600,
    onSuccess = TailwindColors.Green.swatch50,
    error = TailwindColors.Red.swatch600,
    onError = TailwindColors.Red.swatch50,
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