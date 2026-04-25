package com.dev.kore.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Shape
import com.dev.korelibrary.themes.KoreColorScheme
import com.dev.korelibrary.themes.KoreShapes
import com.dev.korelibrary.themes.shapes.SquircleShape
import com.dev.korelibrary.themes.KoreSizes
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.themes.KoreTypography
import com.dev.korelibrary.themes.colors.RadixColors

val lightColorScheme = KoreColorScheme(
    background = RadixColors.Mauve.light.step4,
    onBackGround = RadixColors.Mauve.light.step12,
    backGroundVariant = RadixColors.Mauve.light.step7,
    onBackGroundVariant = RadixColors.Mauve.light.step10,
    surface = RadixColors.Mauve.light.step3,
    onSurface = RadixColors.Mauve.light.step11,
    surfaceBright = RadixColors.Mauve.light.step1,
    onSurfaceBright = RadixColors.Mauve.light.step12,
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
    disabled = RadixColors.Mauve.light.step5,
    onDisabled = RadixColors.Mauve.light.step8,
    transparent = Color(0x0)
)

val darkColorScheme = KoreColorScheme(
    background = RadixColors.Mauve.dark.step1,
    onBackGround = RadixColors.Mauve.dark.step12,
    backGroundVariant = RadixColors.Mauve.dark.step5,
    onBackGroundVariant = RadixColors.Mauve.dark.step11,
    surface = RadixColors.Mauve.dark.step2,
    onSurface = RadixColors.Mauve.dark.step11,
    surfaceBright = RadixColors.Mauve.dark.step3,
    onSurfaceBright = RadixColors.Mauve.dark.step12,
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
    disabled = RadixColors.Mauve.dark.step3,
    onDisabled = RadixColors.Mauve.dark.step8,
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
    xl = SquircleShape(34.0.dp),
    lg = SquircleShape(24.0.dp),
    md = SquircleShape(16.0.dp),
    sm = SquircleShape(12.0.dp),
    xs = SquircleShape(8.0.dp)
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