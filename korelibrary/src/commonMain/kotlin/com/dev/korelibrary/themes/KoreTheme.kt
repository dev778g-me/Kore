package com.dev.korelibrary.themes

import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.dev.korelibrary.themes.KoreDefaults.defaultDarkColorScheme
import com.dev.korelibrary.themes.KoreDefaults.defaultLightColorScheme
import com.dev.korelibrary.themes.KoreDefaults.defaultShapes
import com.dev.korelibrary.themes.KoreDefaults.defaultSizes
import com.dev.korelibrary.themes.ripple.koreRipple

@Immutable
data class KoreColorScheme(
    val background: Color,
    val onBackGround: Color,
    val backGroundVariant: Color,
    val onBackGroundVariant: Color,
    val surface: Color,
    val onSurface: Color,
    val surfaceBright: Color,
    val onSurfaceBright: Color,
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val secondary: Color,
    val onSecondary: Color,
    val secondaryContainer: Color,
    val onSecondaryContainer: Color,
    val accent: Color,
    val success: Color,
    val onSuccess: Color,
    val error: Color,
    val onError: Color,
    val disabled: Color,
    val onDisabled: Color,
    val transparent: Color,
)

@Immutable
data class KoreTypography(
    val displayLarge: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 57.sp,
        lineHeight    = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    val displayMedium: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 45.sp,
        lineHeight    = 52.sp,
        letterSpacing = 0.sp
    ),
    val displaySmall: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 36.sp,
        lineHeight    = 44.sp,
        letterSpacing = 0.sp
    ),
    val headingLarge: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 32.sp,
        lineHeight    = 40.sp,
        letterSpacing = 0.sp
    ),
    val headingMedium: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 28.sp,
        lineHeight    = 36.sp,
        letterSpacing = 0.sp
    ),
    val headingSmall: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 24.sp,
        lineHeight    = 32.sp,
        letterSpacing = 0.sp
    ),
    val titleLarge: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 22.sp,
        lineHeight    = 28.sp,
        letterSpacing = 0.sp
    ),
    val titleMedium: TextStyle = TextStyle(
        fontWeight    = FontWeight.Medium,
        fontSize      = 16.sp,
        lineHeight    = 24.sp,
        letterSpacing = 0.15.sp
    ),
    val titleSmall: TextStyle = TextStyle(
        fontWeight    = FontWeight.Medium,
        fontSize      = 14.sp,
        lineHeight    = 20.sp,
        letterSpacing = 0.1.sp
    ),
    val bodyLarge: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 16.sp,
        lineHeight    = 24.sp,
        letterSpacing = 0.5.sp
    ),
    val bodyMedium: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 14.sp,
        lineHeight    = 20.sp,
        letterSpacing = 0.25.sp
    ),
    val bodySmall: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 12.sp,
        lineHeight    = 16.sp,
        letterSpacing = 0.4.sp
    ),
    val labelLarge: TextStyle = TextStyle(
        fontWeight    = FontWeight.Medium,
        fontSize      = 14.sp,
        lineHeight    = 20.sp,
        letterSpacing = 0.1.sp
    ),
    val labelMedium: TextStyle = TextStyle(
        fontWeight    = FontWeight.Medium,
        fontSize      = 12.sp,
        lineHeight    = 16.sp,
        letterSpacing = 0.5.sp
    ),
    val labelSmall: TextStyle = TextStyle(
        fontWeight    = FontWeight.Medium,
        fontSize      = 11.sp,
        lineHeight    = 16.sp,
        letterSpacing = 0.5.sp
    )
)

@Immutable
data class KoreShapes(
    val extraLarge: Shape,
    val large: Shape,
    val medium: Shape,
    val normal: Shape,
    val small: Shape
)

@Immutable
data class KoreSizes(
    val extraLarge : Dp,
    val large : Dp,
    val medium : Dp,
    val normal : Dp,
    val small : Dp,
    val extraSmall : Dp
)

val LocalKoreColorScheme = staticCompositionLocalOf {
    defaultLightColorScheme
}


val LocalKoreTypography
= staticCompositionLocalOf {
    KoreTypography()
}

val LocalKoreShapes = staticCompositionLocalOf {
    defaultShapes
}

val LocalKoreSizes = staticCompositionLocalOf {
    defaultSizes
}

val LocalTextStyle = staticCompositionLocalOf { KoreTypography().titleSmall }


val LocalContentColor = staticCompositionLocalOf { defaultLightColorScheme.onBackGround }




@Composable
fun AppTheme(
    typography: KoreTypography = KoreDefaults.defaultTypography,
    shapes: KoreShapes = KoreDefaults.defaultShapes,
    darkTheme : Boolean = isSystemInDarkTheme(),
    content:  @Composable () -> Unit
){
    val colorScheme = if(darkTheme) {defaultDarkColorScheme} else {defaultLightColorScheme}

    KoreTheme(
        colorScheme = colorScheme,
        shapes = shapes,
        typography = typography
    ) {
        content()
    }
}




@Composable
fun KoreTheme(
    typography: KoreTypography = KoreDefaults.defaultTypography,
    shapes: KoreShapes = KoreDefaults.defaultShapes,
    colorScheme : KoreColorScheme= KoreDefaults.defaultLightColorScheme,
    ripple : IndicationNodeFactory = koreRipple(colorScheme.onBackGround),
    content: @Composable () -> Unit
) {


    CompositionLocalProvider(
        LocalKoreColorScheme provides colorScheme,
        LocalContentColor provides colorScheme.onBackGround,
        LocalKoreTypography provides typography,
        LocalTextStyle provides typography.titleSmall,
        LocalIndication provides ripple,
        LocalKoreShapes provides shapes,
        LocalKoreSizes provides defaultSizes,
        content = content
    )

}




object KoreTheme {
    val colorScheme : KoreColorScheme
        @Composable get() = LocalKoreColorScheme.current

    val typography : KoreTypography
        @Composable get() = LocalKoreTypography.current

    val shapes : KoreShapes
        @Composable get() = LocalKoreShapes.current

    val sizes : KoreSizes
        @Composable get() = LocalKoreSizes.current
}