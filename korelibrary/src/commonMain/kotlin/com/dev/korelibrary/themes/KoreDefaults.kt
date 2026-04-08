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
        background = RadixColors.Gray.light.step4,
        onBackGround = RadixColors.Gray.light.step12,
        backGroundVariant = RadixColors.Gray.light.step7,
        onBackGroundVariant = RadixColors.Gray.light.step10,
        accent = RadixColors.Blue.light.step3,

        disabled = RadixColors.Gray.light.step5,
        onDisabled = RadixColors.Gray.light.step8,

        primary = RadixColors.Blue.light.step9,
        onPrimary = RadixColors.Blue.light.step1,

        primaryContainer = RadixColors.Blue.light.step6,
        onPrimaryContainer = RadixColors.Blue.light.step10,

        secondary = TailwindColors.Sky500,
        onSecondary = TailwindColors.Sky100,
        secondaryContainer = TailwindColors.Sky300,
        onSecondaryContainer = TailwindColors.Sky900,


        // success colors
        success = RadixColors.Green.light.step9,
        onSuccess = RadixColors.Green.light.step3,

        // error colors
        error = RadixColors.Red.light.step9,
        onError = RadixColors.Red.light.step3,
        transparent = Color.Companion.Transparent,

        surface = RadixColors.Gray.light.step3,
        onSurface = RadixColors.Gray.light.step11,
        surfaceBright = RadixColors.Gray.light.step1,
        onSurfaceBright = RadixColors.Gray.light.step12
    )


    val defaultDarkColorScheme = KoreColorScheme(
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
        primary = RadixColors.Blue.dark.step9,
        onPrimary = RadixColors.Blue.dark.step12,

        primaryContainer = RadixColors.Blue.dark.step3,
        onPrimaryContainer = RadixColors.Blue.dark.step10,

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