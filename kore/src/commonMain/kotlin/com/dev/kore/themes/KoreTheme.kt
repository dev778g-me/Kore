package com.dev.kore.themes

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
import com.dev.kore.themes.KoreDefaults.defaultDarkColorScheme
import com.dev.kore.themes.KoreDefaults.defaultLightColorScheme
import com.dev.kore.themes.KoreDefaults.defaultShapes
import com.dev.kore.themes.KoreDefaults.defaultSizes
import com.dev.kore.themes.ripple.koreRipple

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
    val complementary: Color,
    val onComplementary: Color,
    val complementaryContainer: Color,
    val onComplementaryContainer: Color,
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
    val display1: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 57.sp,
        lineHeight    = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    val display2: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 45.sp,
        lineHeight    = 52.sp,
        letterSpacing = 0.sp
    ),
    val display3: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 36.sp,
        lineHeight    = 44.sp,
        letterSpacing = 0.sp
    ),
    val heading1: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 32.sp,
        lineHeight    = 40.sp,
        letterSpacing = 0.sp
    ),
    val heading2: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 28.sp,
        lineHeight    = 36.sp,
        letterSpacing = 0.sp
    ),
    val heading3: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 24.sp,
        lineHeight    = 32.sp,
        letterSpacing = 0.sp
    ),
    val title1: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 22.sp,
        lineHeight    = 28.sp,
        letterSpacing = 0.sp
    ),
    val title2: TextStyle = TextStyle(
        fontWeight    = FontWeight.Medium,
        fontSize      = 16.sp,
        lineHeight    = 24.sp,
        letterSpacing = 0.15.sp
    ),
    val title3: TextStyle = TextStyle(
        fontWeight    = FontWeight.Medium,
        fontSize      = 14.sp,
        lineHeight    = 20.sp,
        letterSpacing = 0.1.sp
    ),
    val body1: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 16.sp,
        lineHeight    = 24.sp,
        letterSpacing = 0.5.sp
    ),
    val body2: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 14.sp,
        lineHeight    = 20.sp,
        letterSpacing = 0.25.sp
    ),
    val body3: TextStyle = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 12.sp,
        lineHeight    = 16.sp,
        letterSpacing = 0.4.sp
    ),
    val label1: TextStyle = TextStyle(
        fontWeight    = FontWeight.Medium,
        fontSize      = 14.sp,
        lineHeight    = 20.sp,
        letterSpacing = 0.1.sp
    ),
    val label2: TextStyle = TextStyle(
        fontWeight    = FontWeight.Medium,
        fontSize      = 12.sp,
        lineHeight    = 16.sp,
        letterSpacing = 0.5.sp
    ),
    val label3: TextStyle = TextStyle(
        fontWeight    = FontWeight.Medium,
        fontSize      = 11.sp,
        lineHeight    = 16.sp,
        letterSpacing = 0.5.sp
    )
)

@Immutable
data class KoreShapes(
    val xl: Shape,
    val lg: Shape,
    val md: Shape,
    val sm: Shape,
    val xs: Shape
)

@Immutable
data class KoreSizes(
    val xl : Dp,
    val lg : Dp,
    val md : Dp,
    val sm : Dp,
    val xs : Dp,
    val xxs : Dp
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

val LocalTextStyle = staticCompositionLocalOf { KoreTypography().title3 }


val LocalContentColor = staticCompositionLocalOf { defaultLightColorScheme.onBackGround }




@Composable
fun DefaultKoreTheme(
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
    sizes: KoreSizes = defaultSizes,
    shapes: KoreShapes = defaultShapes,
    colorScheme : KoreColorScheme= defaultLightColorScheme,
    ripple : IndicationNodeFactory = koreRipple(colorScheme.onBackGround),
    content: @Composable () -> Unit
) {


    CompositionLocalProvider(
        LocalKoreColorScheme provides colorScheme,
        LocalContentColor provides colorScheme.onBackGround,
        LocalKoreTypography provides typography,
        LocalTextStyle provides typography.title3,
        LocalIndication provides ripple,
        LocalKoreShapes provides shapes,
        LocalKoreSizes provides sizes,
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