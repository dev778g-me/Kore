package com.dev.themebuilder.ui.models

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import com.dev.kore.themes.KoreColorScheme
import com.dev.kore.themes.KoreShapes
import com.dev.kore.themes.KoreSizes
import com.dev.kore.themes.colors.RadixColors
import com.dev.kore.themes.colors.RadixScale
import com.dev.kore.themes.colors.TailwindColors
import com.dev.kore.themes.colors.TailwindSwatch
import com.dev.kore.themes.colors.toHexString
import com.dev.kore.themes.shapes.AbsoluteSmoothCornerShape

object ExportUtils {
    fun exportTheme(
      darkColorScheme: KoreColorScheme,
      lightColorScheme: KoreColorScheme,
      colorSource: PrimaryColorSource,
      currentSizes: KoreSizes,
      currentShapes: KoreShapes,
   ): String {

      val isSmoothCornerShapes= currentShapes.sm is AbsoluteSmoothCornerShape

      val shapeImport = if (isSmoothCornerShapes) "import com.dev.kore.themes.shapes.AbsoluteSmoothCornerShape" else  "import androidx.compose.foundation.shape.RoundedCornerShape"

       val isTailwind = colorSource == PrimaryColorSource.Tailwind

      return $$"""
        import androidx.compose.foundation.isSystemInDarkTheme
        import androidx.compose.runtime.Composable
        import androidx.compose.ui.unit.dp
        import androidx.compose.ui.graphics.Shape
        import com.dev.kore.themes.KoreColorScheme
        import com.dev.kore.themes.KoreShapes
        $$shapeImport
        import com.dev.kore.themes.KoreSizes
        import com.dev.kore.themes.KoreTheme
        import com.dev.kore.themes.KoreTypography
        import com.dev.kore.themes.colors.RadixColors
        import androidx.compose.ui.graphics.Color
        
       val lightColorScheme = KoreColorScheme(
          background = $${lightColorScheme.background.toRadixString()},
          onBackGround = $${lightColorScheme.onBackGround.toRadixString()},
          backGroundVariant = $${lightColorScheme.backGroundVariant.toRadixString()},
          onBackGroundVariant = $${lightColorScheme.onBackGroundVariant.toRadixString()},
          surface = $${lightColorScheme.surface.toRadixString()},
          onSurface = $${lightColorScheme.onSurface.toRadixString()},
          surfaceBright = $${lightColorScheme.surfaceBright.toRadixString()},
          onSurfaceBright = $${lightColorScheme.onSurfaceBright.toRadixString()},
          primary = $${if (isTailwind) lightColorScheme.primary.toTailwindString() else lightColorScheme.primary.toRadixString()},
          onPrimary = $${if (isTailwind) lightColorScheme.onPrimary.toTailwindString() else lightColorScheme.onPrimary.toRadixString()},
          primaryContainer = $${if (isTailwind) lightColorScheme.primaryContainer.toTailwindString() else lightColorScheme.primaryContainer.toRadixString()},
          onPrimaryContainer = $${if (isTailwind) lightColorScheme.onPrimaryContainer.toTailwindString() else lightColorScheme.onPrimaryContainer.toRadixString()},
          complementary = $${if (isTailwind) lightColorScheme.complementary.toTailwindString() else lightColorScheme.complementary.toRadixString()},
          onComplementary = $${if (isTailwind) lightColorScheme.onComplementary.toTailwindString() else lightColorScheme.onComplementary.toRadixString()},
          complementaryContainer = $${if (isTailwind) lightColorScheme.complementaryContainer.toTailwindString() else lightColorScheme.complementaryContainer.toRadixString()},
          onComplementaryContainer = $${if (isTailwind) lightColorScheme.onComplementaryContainer.toTailwindString() else lightColorScheme.onComplementaryContainer.toRadixString()},
          success = $${if (isTailwind) lightColorScheme.success.toTailwindString() else lightColorScheme.success.toRadixString()},
          onSuccess = $${if (isTailwind) lightColorScheme.onSuccess.toTailwindString() else lightColorScheme.onSuccess.toRadixString()},
          error = $${if (isTailwind) lightColorScheme.error.toTailwindString() else lightColorScheme.error.toRadixString()},
          onError = $${if (isTailwind) lightColorScheme.onError.toTailwindString() else lightColorScheme.onError.toRadixString()},
          disabled = $${lightColorScheme.disabled.toRadixString()},
          onDisabled = $${lightColorScheme.onDisabled.toRadixString()},
          transparent = Color.Transparent
        )
        
        val darkColorScheme = KoreColorScheme(
          background = $${darkColorScheme.background.toRadixString()},
          onBackGround = $${darkColorScheme.onBackGround.toRadixString()},
          backGroundVariant = $${darkColorScheme.backGroundVariant.toRadixString()},
          onBackGroundVariant = $${darkColorScheme.onBackGroundVariant.toRadixString()},
          surface = $${darkColorScheme.surface.toRadixString()},
          onSurface = $${darkColorScheme.onSurface.toRadixString()},
          surfaceBright = $${darkColorScheme.surfaceBright.toRadixString()},
          onSurfaceBright = $${darkColorScheme.onSurfaceBright.toRadixString()},
          primary = $${if (isTailwind) darkColorScheme.primary.toTailwindString() else darkColorScheme.primary.toRadixString()},
          onPrimary = $${if (isTailwind) darkColorScheme.onPrimary.toTailwindString() else darkColorScheme.onPrimary.toRadixString()},
          primaryContainer = $${if (isTailwind) darkColorScheme.primaryContainer.toTailwindString() else darkColorScheme.primaryContainer.toRadixString()},
          onPrimaryContainer = $${if (isTailwind) darkColorScheme.onPrimaryContainer.toTailwindString() else darkColorScheme.onPrimaryContainer.toRadixString()},
          complementary = $${if (isTailwind) darkColorScheme.complementary.toTailwindString() else darkColorScheme.complementary.toRadixString()},
          onComplementary = $${if (isTailwind) darkColorScheme.onComplementary.toTailwindString() else darkColorScheme.onComplementary.toRadixString()},
          complementaryContainer = $${if (isTailwind) darkColorScheme.complementaryContainer.toTailwindString() else darkColorScheme.complementaryContainer.toRadixString()},
          onComplementaryContainer = $${if (isTailwind) darkColorScheme.onComplementaryContainer.toTailwindString() else darkColorScheme.onComplementaryContainer.toRadixString()},
          success = $${if (isTailwind) darkColorScheme.success.toTailwindString() else darkColorScheme.success.toRadixString()},
          onSuccess = $${if (isTailwind) darkColorScheme.onSuccess.toTailwindString() else darkColorScheme.onSuccess.toRadixString()},
          error = $${if (isTailwind) darkColorScheme.error.toTailwindString() else darkColorScheme.error.toRadixString()},
          onError = $${if (isTailwind) darkColorScheme.onError.toTailwindString() else darkColorScheme.onError.toRadixString()},
          disabled = $${darkColorScheme.disabled.toRadixString()},
          onDisabled = $${darkColorScheme.onDisabled.toRadixString()},
          transparent = Color.Transparent
         )
        
        val sizes = KoreSizes(
            xl = $${currentSizes.xl},
            lg = $${currentSizes.lg},
            md = $${currentSizes.md},
            sm = $${currentSizes.sm},
            xs = $${currentSizes.xs},
            xxs = $${currentSizes.xxs}
        )
        
        val shapes = KoreShapes(
            xl = $${currentShapes.xl.toShapeString()},
            lg = $${currentShapes.lg.toShapeString()},
            md = $${currentShapes.md.toShapeString()},
            sm = $${currentShapes.sm.toShapeString()},
            xs = $${currentShapes.xs.toShapeString()}
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
        """.trimIndent()
   }




}




 internal  val radixScaleMap: Map<String, RadixScale> = mapOf(
    "White" to RadixColors.White.scale,
    "Black" to RadixColors.Black.scale,

    "Gray.light" to RadixColors.Gray.light,
    "Gray.dark" to RadixColors.Gray.dark,

    "Mauve.light" to RadixColors.Mauve.light,
    "Mauve.dark" to RadixColors.Mauve.dark,

    "Slate.light" to RadixColors.Slate.light,
    "Slate.dark" to RadixColors.Slate.dark,

    "Sage.light" to RadixColors.Sage.light,
    "Sage.dark" to RadixColors.Sage.dark,

    "Olive.light" to RadixColors.Olive.light,
    "Olive.dark" to RadixColors.Olive.dark,

    "Sand.light" to RadixColors.Sand.light,
    "Sand.dark" to RadixColors.Sand.dark,

    "Gold.light" to RadixColors.Gold.light,
    "Gold.dark" to RadixColors.Gold.dark,

    "Bronze.light" to RadixColors.Bronze.light,
    "Bronze.dark" to RadixColors.Bronze.dark,

    "Brown.light" to RadixColors.Brown.light,
    "Brown.dark" to RadixColors.Brown.dark,

    "Yellow.light" to RadixColors.Yellow.light,
    "Yellow.dark" to RadixColors.Yellow.dark,

    "Amber.light" to RadixColors.Amber.light,
    "Amber.dark" to RadixColors.Amber.dark,

    "Orange.light" to RadixColors.Orange.light,
    "Orange.dark" to RadixColors.Orange.dark,

    "Tomato.light" to RadixColors.Tomato.light,
    "Tomato.dark" to RadixColors.Tomato.dark,

    "Red.light" to RadixColors.Red.light,
    "Red.dark" to RadixColors.Red.dark,

    "Ruby.light" to RadixColors.Ruby.light,
    "Ruby.dark" to RadixColors.Ruby.dark,

    "Crimson.light" to RadixColors.Crimson.light,
    "Crimson.dark" to RadixColors.Crimson.dark,

    "Pink.light" to RadixColors.Pink.light,
    "Pink.dark" to RadixColors.Pink.dark,

    "Plum.light" to RadixColors.Plum.light,
    "Plum.dark" to RadixColors.Plum.dark,

    "Purple.light" to RadixColors.Purple.light,
    "Purple.dark" to RadixColors.Purple.dark,

    "Violet.light" to RadixColors.Violet.light,
    "Violet.dark" to RadixColors.Violet.dark,

    "Iris.light" to RadixColors.Iris.light,
    "Iris.dark" to RadixColors.Iris.dark,

    "Indigo.light" to RadixColors.Indigo.light,
    "Indigo.dark" to RadixColors.Indigo.dark,

    "Blue.light" to RadixColors.Blue.light,
    "Blue.dark" to RadixColors.Blue.dark,

    "Cyan.light" to RadixColors.Cyan.light,
    "Cyan.dark" to RadixColors.Cyan.dark,

    "Teal.light" to RadixColors.Teal.light,
    "Teal.dark" to RadixColors.Teal.dark,

    "Jade.light" to RadixColors.Jade.light,
    "Jade.dark" to RadixColors.Jade.dark,

    "Green.light" to RadixColors.Green.light,
    "Green.dark" to RadixColors.Green.dark,

    "Grass.light" to RadixColors.Grass.light,
    "Grass.dark" to RadixColors.Grass.dark,

    "Lime.light" to RadixColors.Lime.light,
    "Lime.dark" to RadixColors.Lime.dark,

    "Mint.light" to RadixColors.Mint.light,
    "Mint.dark" to RadixColors.Mint.dark,

    "Sky.light" to RadixColors.Sky.light,
    "Sky.dark" to RadixColors.Sky.dark
)

internal val tailwindSwatchMap: Map<String, TailwindSwatch> =
   tailWindPrimaryColorsList.associate {
      it.name to it.colorScale
   }


private val shadeNames = listOf(
   "swatch50",
   "swatch100",
   "swatch200",
   "swatch300",
   "swatch400",
   "swatch500",
   "swatch600",
   "swatch700",
   "swatch800",
   "swatch900",
   "swatch950"
)

internal fun Color.toTailwindString(): String? =
   tailwindSwatchMap.entries.firstNotNullOfOrNull { (name, swatch) ->
      val index = swatch.swatches.indexOf(this)
      if (index >= 0) {
         "TailwindColors.$name.${shadeNames[index]}"
      } else {
         return "Color(0x${this.toHexString().uppercase()})"
      }
   }


internal fun Color.toRadixString(): String {
   for ((name, scales) in radixScaleMap) {
      val index = scales.steps.indexOf(this)
      if (index >= 0) {
         return "RadixColors.$name.step${index + 1}"
      }

   }

   return "Color(0x${this.toHexString().uppercase()})"
}

internal fun Shape.toShapeString(): String {
   return when (this) {
      is RoundedCornerShape -> {
         val dp = topStart.toPx(Size(1000f, 1000f), Density(1f))
         "RoundedCornerShape(${dp}.dp)"
      }
      is AbsoluteSmoothCornerShape -> {
         val dp = topStart.toPx(Size(1000f, 1000f), Density(1f))
         "AbsoluteSmoothCornerShape(${dp}.dp)"
      }
      else -> this.toString()
   }
}