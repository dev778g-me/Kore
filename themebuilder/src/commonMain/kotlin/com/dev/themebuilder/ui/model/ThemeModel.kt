package com.dev.themebuilder.ui.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.themes.KoreDefaults
import com.dev.korelibrary.themes.KoreSizes
import com.dev.korelibrary.themes.colors.RadixColors
import com.dev.korelibrary.themes.colors.RadixScale


@Immutable
data class PrimaryColors(
    val primary : Color = KoreDefaults.defaultLightColorScheme.primary,
    val onPrimary : Color = KoreDefaults.defaultLightColorScheme.onPrimary,
    val primaryContainer : Color  = KoreDefaults.defaultLightColorScheme.primaryContainer,
    val onPrimaryContainer : Color = KoreDefaults.defaultLightColorScheme.onPrimaryContainer,
)

@Immutable
data class ComplementaryColors(
    val complementary : Color = KoreDefaults.defaultLightColorScheme.complementary,
    val onComplementary : Color = KoreDefaults.defaultLightColorScheme.onComplementary,
    val complementaryContainer : Color = KoreDefaults.defaultLightColorScheme.complementaryContainer,
    val onComplementaryContainer : Color = KoreDefaults.defaultLightColorScheme.onComplementaryContainer
)


@Immutable
data class NeutralColors(
    val backGround : Color = KoreDefaults.defaultLightColorScheme.background,
    val onBackGround : Color = KoreDefaults.defaultLightColorScheme.onBackGround,
    val disabled : Color = KoreDefaults.defaultLightColorScheme.disabled,
    val onDisabled : Color = KoreDefaults.defaultLightColorScheme.onDisabled,
    val backGroundVariant : Color = KoreDefaults.defaultLightColorScheme.backGroundVariant,
    val onBackGroundVariant : Color = KoreDefaults.defaultLightColorScheme.onBackGroundVariant,
    val surface : Color = KoreDefaults.defaultLightColorScheme.surface,
    val onSurface: Color = KoreDefaults.defaultLightColorScheme.onSurface,
    val surfaceBright : Color = KoreDefaults.defaultLightColorScheme.surfaceBright,
    val onSurfaceBright : Color = KoreDefaults.defaultLightColorScheme.onSurfaceBright,
    val transParentColor : Color = KoreDefaults.defaultLightColorScheme.transparent
)


@Immutable
data class SuccessErrorColors(
    val success : Color = KoreDefaults.defaultLightColorScheme.success,
    val onSuccess : Color = KoreDefaults.defaultLightColorScheme.onSuccess,
    val error : Color = KoreDefaults.defaultLightColorScheme.error,
    val onError : Color = KoreDefaults.defaultLightColorScheme.onError,
)

data class ColorEntry(
    val name : String,
    val lightScale : RadixScale,
    val darkScale : RadixScale,
    val complementaryName : String ? = null,
    val complementaryLight : RadixScale ? = null,
    val complementaryDark : RadixScale ? = null,
)


val primaryColorsList = listOf(
    ColorEntry("Tomato", RadixColors.Tomato.light, RadixColors.Tomato.dark, complementaryName = "Cyan", complementaryLight = RadixColors.Cyan.light, complementaryDark = RadixColors.Cyan.dark),
    ColorEntry("Orange", RadixColors.Orange.light, RadixColors.Orange.dark, complementaryName = "Blue", complementaryLight = RadixColors.Blue.light, complementaryDark = RadixColors.Blue.dark),
    ColorEntry("Amber", RadixColors.Amber.light, RadixColors.Amber.dark, complementaryName = "Iris", complementaryLight = RadixColors.Iris.light, complementaryDark = RadixColors.Iris.dark),
    ColorEntry("Grass", RadixColors.Grass.light, RadixColors.Grass.dark, complementaryName = "Pink", complementaryLight = RadixColors.Pink.light, complementaryDark = RadixColors.Pink.dark),
    ColorEntry("Jade", RadixColors.Jade.light, RadixColors.Jade.dark, complementaryName = "Ruby", complementaryLight = RadixColors.Ruby.light, complementaryDark = RadixColors.Ruby.dark),
    ColorEntry("Teal", RadixColors.Teal.light, RadixColors.Teal.dark, complementaryName = "Red", complementaryLight = RadixColors.Red.light, complementaryDark = RadixColors.Red.dark),
    ColorEntry("Cyan", RadixColors.Cyan.light, RadixColors.Cyan.dark, complementaryName = "Tomato", complementaryLight = RadixColors.Tomato.light, complementaryDark = RadixColors.Tomato.dark),
    ColorEntry("Sky", RadixColors.Sky.light, RadixColors.Sky.dark, complementaryName = "Orange", complementaryLight = RadixColors.Orange.light, complementaryDark = RadixColors.Orange.dark),
    ColorEntry("Blue", RadixColors.Blue.light, RadixColors.Blue.dark, complementaryName = "Orange", complementaryLight = RadixColors.Orange.light, complementaryDark = RadixColors.Orange.dark),
    ColorEntry("Indigo", RadixColors.Indigo.light, RadixColors.Indigo.dark, complementaryName = "Amber", complementaryLight = RadixColors.Amber.light, complementaryDark = RadixColors.Amber.dark),
    ColorEntry("Iris", RadixColors.Iris.light, RadixColors.Iris.dark, complementaryName = "Amber", complementaryLight = RadixColors.Amber.light, complementaryDark = RadixColors.Amber.dark),
    ColorEntry("Violet", RadixColors.Violet.light, RadixColors.Violet.dark, complementaryName = "Yellow", complementaryLight = RadixColors.Yellow.light, complementaryDark = RadixColors.Yellow.dark),
    ColorEntry("Purple", RadixColors.Purple.light, RadixColors.Purple.dark, complementaryName = "Lime", complementaryLight = RadixColors.Lime.light, complementaryDark = RadixColors.Lime.dark),
    ColorEntry("Plum", RadixColors.Plum.light, RadixColors.Plum.dark, complementaryName = "Lime", complementaryLight = RadixColors.Lime.light, complementaryDark = RadixColors.Lime.dark),
    ColorEntry("Pink", RadixColors.Pink.light, RadixColors.Pink.dark, complementaryName = "Grass", complementaryLight = RadixColors.Grass.light, complementaryDark = RadixColors.Grass.dark),
    ColorEntry("Crimson", RadixColors.Crimson.light, RadixColors.Crimson.dark, complementaryName = "Green", complementaryLight = RadixColors.Green.light, complementaryDark = RadixColors.Green.dark),
    ColorEntry("Ruby", RadixColors.Ruby.light, RadixColors.Ruby.dark, complementaryName = "Jade", complementaryLight = RadixColors.Jade.light, complementaryDark = RadixColors.Jade.dark),
    ColorEntry("Lime", RadixColors.Lime.light, RadixColors.Lime.dark, complementaryName = "Purple", complementaryLight = RadixColors.Purple.light, complementaryDark = RadixColors.Purple.dark),
)

val neutralColorsList = listOf(
    ColorEntry("Gold", RadixColors.Gold.light, RadixColors.Gold.dark),
    ColorEntry("Bronze", RadixColors.Bronze.light, RadixColors.Bronze.dark),
    ColorEntry("Brown", RadixColors.Brown.light, RadixColors.Brown.dark),
    ColorEntry("Gray", RadixColors.Gray.light, RadixColors.Gray.dark),
    ColorEntry("Mauve", RadixColors.Mauve.light, RadixColors.Mauve.dark),
    ColorEntry("Slate", RadixColors.Slate.light, RadixColors.Slate.dark),
    ColorEntry("Sage", RadixColors.Sage.light, RadixColors.Sage.dark),
    ColorEntry("Olive", RadixColors.Olive.light, RadixColors.Olive.dark),
    ColorEntry("Sand", RadixColors.Sand.light, RadixColors.Sand.dark),
)

val lowContrastColor =listOf(
    ColorEntry("Amber", RadixColors.Amber.light, RadixColors.Amber.dark, complementaryName = "Iris", complementaryLight = RadixColors.Iris.light, complementaryDark = RadixColors.Iris.dark),
    ColorEntry("Sky", RadixColors.Sky.light, RadixColors.Sky.dark, complementaryName = "Orange", complementaryLight = RadixColors.Orange.light, complementaryDark = RadixColors.Orange.dark),
    ColorEntry("Lime", RadixColors.Lime.light, RadixColors.Lime.dark, complementaryName = "Purple", complementaryLight = RadixColors.Purple.light, complementaryDark = RadixColors.Purple.dark),
)



enum class Sizes {
    Compact,
    Balanced,
    Airy,
}

val balancedSizes = KoreSizes(
    xl = KoreDefaults.defaultSizes.xl,
    lg = KoreDefaults.defaultSizes.lg,
    md = KoreDefaults.defaultSizes.md,
    sm = KoreDefaults.defaultSizes.sm,
    xs = KoreDefaults.defaultSizes.xs,
    xxs = KoreDefaults.defaultSizes.xxs
)

val airySizes = KoreSizes(
    xl = 48.dp,
    lg = 36.dp,
    md = 24.dp,
    sm = 16.dp,
    xs = 12.dp,
    xxs = 8.dp
)
val compactSizes = KoreSizes(
    xl = 24.dp,
    lg = 16.dp,
    md = 12.dp,
    sm = 8.dp,
    xs = 4.dp,
    xxs = 2.dp
)


enum class ShapeType{
    RoundedRectangle,
    Squircle,
}





