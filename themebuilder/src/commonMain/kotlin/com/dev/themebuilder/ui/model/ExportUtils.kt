package com.dev.themebuilder.ui.model

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import com.dev.korelibrary.themes.KoreColorScheme
import com.dev.korelibrary.themes.KoreShapes
import com.dev.korelibrary.themes.KoreSizes
import com.dev.korelibrary.themes.colors.RadixColors
import com.dev.korelibrary.themes.colors.RadixScale
import com.dev.korelibrary.themes.shapes.SquircleShape
import java.awt.FileDialog
import java.awt.Frame
import java.io.File

object ExportUtils {
   fun exportTheme(
      darkColorScheme: KoreColorScheme,
      lightColorScheme: KoreColorScheme,
      currentSizes: KoreSizes,
      currentShapes: KoreShapes,
   ): String {

      val isSquircleShape= currentShapes.sm is SquircleShape

      val shapeImport = if (isSquircleShape) "import com.dev.korelibrary.themes.shapes.SquircleShape" else  "import androidx.compose.foundation.shape.RoundedCornerShape"


      return """
        import androidx.compose.foundation.isSystemInDarkTheme
        import androidx.compose.runtime.Composable
        import androidx.compose.ui.graphics.Color
        import androidx.compose.ui.unit.Dp
        import androidx.compose.ui.unit.dp
        import androidx.compose.ui.graphics.Shape
        import com.dev.korelibrary.themes.KoreColorScheme
        import com.dev.korelibrary.themes.KoreShapes
        $shapeImport
        import com.dev.korelibrary.themes.KoreSizes
        import com.dev.korelibrary.themes.KoreTheme
        import com.dev.korelibrary.themes.KoreTypography
        import com.dev.korelibrary.themes.colors.RadixColors
        
        val lightColorScheme = KoreColorScheme(
            background = ${lightColorScheme.background.toRadixString()},
            onBackGround = ${lightColorScheme.onBackGround.toRadixString()},
            backGroundVariant = ${lightColorScheme.backGroundVariant.toRadixString()},
            onBackGroundVariant = ${lightColorScheme.onBackGroundVariant.toRadixString()},
            surface = ${lightColorScheme.surface.toRadixString()},
            onSurface = ${lightColorScheme.onSurface.toRadixString()},
            surfaceBright = ${lightColorScheme.surfaceBright.toRadixString()},
            onSurfaceBright = ${lightColorScheme.onSurfaceBright.toRadixString()},
            primary = ${lightColorScheme.primary.toRadixString()},
            onPrimary = ${lightColorScheme.onPrimary.toRadixString()},
            primaryContainer = ${lightColorScheme.primaryContainer.toRadixString()},
            onPrimaryContainer = ${lightColorScheme.onPrimaryContainer.toRadixString()},
            complementary = ${lightColorScheme.complementary.toRadixString()},
            onComplementary = ${lightColorScheme.onComplementary.toRadixString()},
            complementaryContainer = ${lightColorScheme.complementaryContainer.toRadixString()},
            onComplementaryContainer = ${lightColorScheme.onComplementaryContainer.toRadixString()},
            success = ${lightColorScheme.success.toRadixString()},
            onSuccess = ${lightColorScheme.onSuccess.toRadixString()},
            error = ${lightColorScheme.error.toRadixString()},
            onError = ${lightColorScheme.onError.toRadixString()},
            disabled = ${lightColorScheme.disabled.toRadixString()},
            onDisabled = ${lightColorScheme.onDisabled.toRadixString()},
            transparent = ${lightColorScheme.transparent.toRadixString()}
        )
        
        val darkColorScheme = KoreColorScheme(
            background = ${darkColorScheme.background.toRadixString()},
            onBackGround = ${darkColorScheme.onBackGround.toRadixString()},
            backGroundVariant = ${darkColorScheme.backGroundVariant.toRadixString()},
            onBackGroundVariant = ${darkColorScheme.onBackGroundVariant.toRadixString()},
            surface = ${darkColorScheme.surface.toRadixString()},
            onSurface = ${darkColorScheme.onSurface.toRadixString()},
            surfaceBright = ${darkColorScheme.surfaceBright.toRadixString()},
            onSurfaceBright = ${darkColorScheme.onSurfaceBright.toRadixString()},
            primary = ${darkColorScheme.primary.toRadixString()},
            onPrimary = ${darkColorScheme.onPrimary.toRadixString()},
            primaryContainer = ${darkColorScheme.primaryContainer.toRadixString()},
            onPrimaryContainer = ${darkColorScheme.onPrimaryContainer.toRadixString()},
            complementary = ${darkColorScheme.complementary.toRadixString()},
            onComplementary = ${darkColorScheme.onComplementary.toRadixString()},
            complementaryContainer = ${darkColorScheme.complementaryContainer.toRadixString()},
            onComplementaryContainer = ${darkColorScheme.onComplementaryContainer.toRadixString()},
            success = ${darkColorScheme.success.toRadixString()},
            onSuccess = ${darkColorScheme.onSuccess.toRadixString()},
            error = ${darkColorScheme.error.toRadixString()},
            onError = ${darkColorScheme.onError.toRadixString()},
            disabled = ${darkColorScheme.disabled.toRadixString()},
            onDisabled = ${darkColorScheme.onDisabled.toRadixString()},
            transparent = ${darkColorScheme.transparent.toRadixString()}
        )
        
        val sizes = KoreSizes(
            xl = ${currentSizes.xl},
            lg = ${currentSizes.lg},
            md = ${currentSizes.md},
            sm = ${currentSizes.sm},
            xs = ${currentSizes.xs},
            xxs = ${currentSizes.xxs}
        )
        
        val shapes = KoreShapes(
            xl = ${currentShapes.xl.toShapeString()},
            lg = ${currentShapes.lg.toShapeString()},
            md = ${currentShapes.md.toShapeString()},
            sm = ${currentShapes.sm.toShapeString()},
            xs = ${currentShapes.xs.toShapeString()}
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


   fun openSaveFile(
      fileName : String = "theme.kt",
      onResult: (File ?) -> Unit
   ){
      val dummyFrame = Frame()
      val dialog = FileDialog(dummyFrame, "export theme", FileDialog.SAVE)
      dialog.file = fileName
      dialog.isVisible = true

      if (dialog.directory != null && dialog.file != null){
         val  file = File(dialog.directory, dialog.file)
         onResult(file)
      }else {
         onResult(null)
      }
      dummyFrame.dispose()
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

internal fun Color.toRadixString() : String{
    for ((name , scales) in radixScaleMap){
        val  index = scales.steps.indexOf(this)
        if (index != -1) {
            return "RadixColors.$name.step${index + 1}"
        }

    }

    return "Color(0x${this.value.toString(8).uppercase()})"
}

internal fun Shape.toShapeString(): String {
   return when (this) {
      is RoundedCornerShape -> {
         val dp = topStart.toPx(Size(1000f, 1000f), Density(1f))
         "RoundedCornerShape(${dp}.dp)"
      }
      is SquircleShape -> {
         val dp = topStart.toPx(Size(1000f, 1000f), Density(1f))
         "SquircleShape(${dp}.dp)"
      }
      else -> this.toString()
   }
}