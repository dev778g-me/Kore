package com.dev.korelibrary.themes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.korelibrary.themes.colors.RadixColors
import com.dev.korelibrary.themes.typography.googleSansFlex
import com.dev.korelibrary.themes.shapes.SquircleShape

/**
 * this defines all the default values for kore design system
 * @property defaultLightColorScheme the default lightColorScheme for kore Design System [KoreColorScheme]
 * @property defaultDarkColorScheme the default darkColorScheme for kore Design System [KoreColorScheme]
 * @property defaultTypography the default Typography for Kore Design System [KoreTypography]
 * @property defaultShapes the default Shapes for the Kore Design System [KoreShapes]
 * @property defaultSquircleShapes the default Squircle shapes for the Kore Design System [KoreShapes]
 * @property defaultSizes the default sizes for Kore Design System [KoreSizes]
 *
 */
object KoreDefaults{
    val defaultLightColorScheme = KoreColorScheme(
        background = RadixColors.Gray.light.step4,
        onBackGround = RadixColors.Gray.light.step12,
        backGroundVariant = RadixColors.Gray.light.step7,
        onBackGroundVariant = RadixColors.Gray.light.step10,

        disabled = RadixColors.Gray.light.step5,
        onDisabled = RadixColors.Gray.light.step8,

        primary = RadixColors.Blue.light.step9,
        onPrimary = RadixColors.Blue.light.step1,

        primaryContainer = RadixColors.Blue.light.step6,
        onPrimaryContainer = RadixColors.Blue.light.step10,

        complementary = RadixColors.Orange.light.step9,
        onComplementary = RadixColors.Orange.light.step1,
        complementaryContainer = RadixColors.Orange.light.step6,
        onComplementaryContainer = RadixColors.Orange.light.step10,


        // success colors
        success = RadixColors.Green.light.step9,
        onSuccess = RadixColors.Green.light.step2,

        // error colors
        error = RadixColors.Red.light.step9,
        onError = RadixColors.Red.light.step2,
        transparent = Color.Transparent,

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

        // disabled colors
        disabled = RadixColors.Gray.dark.step3,
        onDisabled = RadixColors.Gray.dark.step8,

        // primary colors
        primary = RadixColors.Blue.dark.step9,
        onPrimary = RadixColors.Blue.dark.step12,

        primaryContainer = RadixColors.Blue.dark.step3,
        onPrimaryContainer = RadixColors.Blue.dark.step10,

        complementary = RadixColors.Orange.dark.step9,
        onComplementary = RadixColors.Orange.dark.step12,
        complementaryContainer = RadixColors.Orange.dark.step3,
        onComplementaryContainer = RadixColors.Orange.dark.step10,


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
           display1 = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Normal,
               fontSize = 57.sp,
               lineHeight = 64.sp,
               letterSpacing = (-0.25).sp
           ),
           display2 = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Normal,
               fontSize = 45.sp,
               lineHeight = 52.sp,
               letterSpacing = 0.sp
           ),
           display3 = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Normal,
               fontSize = 36.sp,
               lineHeight = 44.sp,
               letterSpacing = 0.sp
           ),


           heading1 = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Normal,
               fontSize = 32.sp,
               lineHeight = 40.sp,
               letterSpacing = 0.sp
           ),
           heading2 = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Normal,
               fontSize = 28.sp,
               lineHeight = 36.sp,
               letterSpacing = 0.sp
           ),
           heading3 = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Normal,
               fontSize = 24.sp,
               lineHeight = 32.sp,
               letterSpacing = 0.sp
           ),


           title1 = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Normal,
               fontSize = 22.sp,
               lineHeight = 28.sp,
               letterSpacing = 0.sp
           ),
           title2 = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Medium,
               fontSize = 16.sp,
               lineHeight = 24.sp,
               letterSpacing = 0.15.sp
           ),
           title3 = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Medium,
               fontSize = 14.sp,
               lineHeight = 20.sp,
               letterSpacing = 0.1.sp
           ),


           body1 = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Normal,
               fontSize = 16.sp,
               lineHeight = 24.sp,
               letterSpacing = 0.5.sp
           ),
           body2 = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Normal,
               fontSize = 14.sp,
               lineHeight = 20.sp,
               letterSpacing = 0.25.sp
           ),
           body3 = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Normal,
               fontSize = 12.sp,
               lineHeight = 16.sp,
               letterSpacing = 0.4.sp
           ),


           label1 = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Medium,
               fontSize = 14.sp,
               lineHeight = 20.sp,
               letterSpacing = 0.1.sp
           ),
           label2 = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Medium,
               fontSize = 12.sp,
               lineHeight = 16.sp,
               letterSpacing = 0.5.sp
           ),
           label3 = TextStyle(
               fontFamily = fontFamily,
               fontWeight = FontWeight.Medium,
               fontSize = 11.sp,
               lineHeight = 16.sp,
               letterSpacing = 0.5.sp
           )
       )
        }


    val defaultShapes = KoreShapes(
        xl = RoundedCornerShape(34.dp),
        lg = RoundedCornerShape(24.dp),
        md = RoundedCornerShape(16.dp),
        sm = RoundedCornerShape(12.dp),
        xs = RoundedCornerShape(8.dp)
    )

    val defaultSquircleShapes = KoreShapes(
        xl = SquircleShape(34.dp),
        lg = SquircleShape(24.dp),
        md =SquircleShape(16.dp),
        sm = SquircleShape(12.dp),
        xs = SquircleShape(8.dp)
    )

    val defaultSizes = KoreSizes(
        xl = 34.dp,
        lg = 24.dp,
        md = 16.dp,
        sm = 12.dp,
        xs = 8.dp,
        xxs = 4.dp
    )



}