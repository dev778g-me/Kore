package com.dev.korelibrary.themes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.korelibrary.themes.colors.RadixColors
import com.dev.korelibrary.themes.colors.TailwindColors
import com.dev.korelibrary.themes.typography.googleSansFlex
import io.jadu.nivi.presentation.utils.squircleShape.SquircleShape

object KoreDefaults{
    val defaultLightColorScheme = KoreColorScheme(
        background = RadixColors.Gray.Light.step4,
        onBackGround = RadixColors.Gray.Light.step12,
        backGroundVariant = RadixColors.Gray.Light.step7,
        onBackGroundVariant = RadixColors.Gray.Light.step10,
        accent = RadixColors.Blue.Light.step3,

        disabled = RadixColors.Gray.Light.step5,
        onDisabled = RadixColors.Gray.Light.step8,

        primary = RadixColors.Blue.Light.step9,
        onPrimary = RadixColors.Blue.Light.step1,

        primaryContainer = RadixColors.Blue.Light.step6,
        onPrimaryContainer = RadixColors.Blue.Light.step10,

        secondary = TailwindColors.Sky500,
        onSecondary = TailwindColors.Sky100,
        secondaryContainer = TailwindColors.Sky300,
        onSecondaryContainer = TailwindColors.Sky900,


        // success colors
        success = RadixColors.Green.Light.step9,
        onSuccess = RadixColors.Green.Light.step3,

        // error colors
        error = RadixColors.Red.Light.step9,
        onError = RadixColors.Red.Light.step3,
        transparent = Color.Companion.Transparent,

        surface = RadixColors.Gray.Light.step3,
        onSurface = RadixColors.Gray.Light.step11,
        surfaceBright = RadixColors.Gray.Light.step1,
        onSurfaceBright = RadixColors.Gray.Light.step12
    )


    val defaultDarkColorScheme = KoreColorScheme(
        // background and background variant
        background = RadixColors.Gray.Dark.step1,
        onBackGround = RadixColors.Gray.Dark.step12,

        backGroundVariant = RadixColors.Gray.Dark.step5,
        onBackGroundVariant = RadixColors.Gray.Dark.step11,
        accent = RadixColors.Blue.Dark.step1,
        // disabled colors
        disabled = RadixColors.Gray.Dark.step3,
        onDisabled = RadixColors.Gray.Dark.step8,

        // primary colors
        primary = RadixColors.Blue.Dark.step9,
        onPrimary = RadixColors.Blue.Dark.step12,

        primaryContainer = RadixColors.Blue.Dark.step3,
        onPrimaryContainer = RadixColors.Blue.Dark.step10,

        secondary = TailwindColors.Sky600,
        onSecondary = TailwindColors.Sky900,
        secondaryContainer = TailwindColors.Sky700,
        onSecondaryContainer = TailwindColors.Blue700,


        // success colors
        success = RadixColors.Green.Dark.step9,
        onSuccess = RadixColors.Green.Dark.step12,

        // error colors
        error = RadixColors.Red.Dark.step9,
        onError = RadixColors.Red.Dark.step12,
        transparent = Color.Transparent,
        surface = RadixColors.Gray.Dark.step2,
        onSurface = RadixColors.Gray.Dark.step11,

        surfaceBright = RadixColors.Gray.Dark.step3,
        onSurfaceBright = RadixColors.Gray.Dark.step12
    )


    val defaultTypography : KoreTypography
        @Composable get() {
         val fontFamily = googleSansFlex()

       return KoreTypography(
           displayLarge = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Companion.Normal,
               fontSize = 57.sp,
               lineHeight = 64.sp,
               letterSpacing = (-0.25).sp
           ),
           displayMedium = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Companion.Normal,
               fontSize = 45.sp,
               lineHeight = 52.sp,
               letterSpacing = 0.sp
           ),
           displaySmall = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Companion.Normal,
               fontSize = 36.sp,
               lineHeight = 44.sp,
               letterSpacing = 0.sp
           ),


           headingLarge = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Companion.Normal,
               fontSize = 32.sp,
               lineHeight = 40.sp,
               letterSpacing = 0.sp
           ),
           headingMedium = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Companion.Normal,
               fontSize = 28.sp,
               lineHeight = 36.sp,
               letterSpacing = 0.sp
           ),
           headingSmall = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Companion.Normal,
               fontSize = 24.sp,
               lineHeight = 32.sp,
               letterSpacing = 0.sp
           ),


           titleLarge = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Companion.Normal,
               fontSize = 22.sp,
               lineHeight = 28.sp,
               letterSpacing = 0.sp
           ),
           titleMedium = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Companion.Medium,
               fontSize = 16.sp,
               lineHeight = 24.sp,
               letterSpacing = 0.15.sp
           ),
           titleSmall = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Companion.Medium,
               fontSize = 14.sp,
               lineHeight = 20.sp,
               letterSpacing = 0.1.sp
           ),


           bodyLarge = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Companion.Normal,
               fontSize = 16.sp,
               lineHeight = 24.sp,
               letterSpacing = 0.5.sp
           ),
           bodyMedium = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Companion.Normal,
               fontSize = 14.sp,
               lineHeight = 20.sp,
               letterSpacing = 0.25.sp
           ),
           bodySmall = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Companion.Normal,
               fontSize = 12.sp,
               lineHeight = 16.sp,
               letterSpacing = 0.4.sp
           ),


           labelLarge = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Companion.Medium,
               fontSize = 14.sp,
               lineHeight = 20.sp,
               letterSpacing = 0.1.sp
           ),
           labelMedium = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Companion.Medium,
               fontSize = 12.sp,
               lineHeight = 16.sp,
               letterSpacing = 0.5.sp
           ),
           labelSmall = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Companion.Medium,
               fontSize = 11.sp,
               lineHeight = 16.sp,
               letterSpacing = 0.5.sp
           )
       )
        }


    val defaultShapes = KoreShapes(
        extraLarge = RoundedCornerShape(34.dp),
        large = androidx.compose.foundation.shape.RoundedCornerShape(24.dp),
        medium = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
        normal = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
        small = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
    )

    val defaultSquircleShapes = KoreShapes(
        extraLarge = SquircleShape(34.dp),
        large = io.jadu.nivi.presentation.utils.squircleShape.SquircleShape(24.dp),
        medium = io.jadu.nivi.presentation.utils.squircleShape.SquircleShape(16.dp),
        normal = io.jadu.nivi.presentation.utils.squircleShape.SquircleShape(12.dp),
        small = io.jadu.nivi.presentation.utils.squircleShape.SquircleShape(8.dp)
    )

    val defaultSizes = KoreSizes(
        extraLarge = 34.dp,
        large = 24.dp,
        medium = 16.dp,
        normal = 12.dp,
        small = 8.dp,
        extraSmall = 4.dp
    )


}