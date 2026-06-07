package com.dev.themebuilder.ui.models

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreDefaults
import com.dev.kore.themes.KoreShapes
import com.dev.kore.themes.KoreSizes
import com.dev.kore.themes.colors.RadixColors
import com.dev.kore.themes.colors.RadixScale
import com.dev.kore.themes.colors.TailwindColors
import com.dev.kore.themes.colors.TailwindSwatch
import com.dev.kore.themes.shapes.AbsoluteSmoothCornerShape

data class ColorEntry(
    val name : String,
    val lightScale : RadixScale,
    val darkScale : RadixScale,
    val complementaryName : String ? = null,
    val complementaryLight : RadixScale ? = null,
    val complementaryDark : RadixScale ? = null,
)

data class TailWindColorEntry(
    val name: String,
    val colorScale: TailwindSwatch,
    val complementaryScale: TailwindSwatch? = null,
    val complementaryName: String,
)
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
val tailWindPrimaryColorsList = listOf(
    TailWindColorEntry("Orange", TailwindColors.Orange, TailwindColors.Blue, "Blue"),
    TailWindColorEntry("Amber", TailwindColors.Amber, TailwindColors.Indigo, "Indigo"),
    TailWindColorEntry("Yellow", TailwindColors.Yellow, TailwindColors.Violet, "Violet"),
    TailWindColorEntry("Lime", TailwindColors.Lime, TailwindColors.Purple, "Purple"),
    TailWindColorEntry("Emerald", TailwindColors.Emerald, TailwindColors.Rose, "Rose"),
    TailWindColorEntry("Teal", TailwindColors.Teal, TailwindColors.Red, "Red"),
    TailWindColorEntry("Cyan", TailwindColors.Cyan, TailwindColors.Orange, "Orange"),
    TailWindColorEntry("Sky", TailwindColors.Sky, TailwindColors.Amber, "Amber"),
    TailWindColorEntry("Blue", TailwindColors.Blue, TailwindColors.Orange, "Orange"),
    TailWindColorEntry("Indigo", TailwindColors.Indigo, TailwindColors.Amber, "Amber"),
    TailWindColorEntry("Violet", TailwindColors.Violet, TailwindColors.Yellow, "Yellow"),
    TailWindColorEntry("Purple", TailwindColors.Purple, TailwindColors.Lime, "Lime"),
    TailWindColorEntry("Fuchsia", TailwindColors.Fuchsia, TailwindColors.Green, "Green"),
    TailWindColorEntry("Pink", TailwindColors.Pink, TailwindColors.Emerald, "Emerald"),
    TailWindColorEntry("Rose", TailwindColors.Rose, TailwindColors.Teal, "Teal"),
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

fun getSharpShapes(
): KoreShapes {
    return KoreShapes(
        xl = RectangleShape,
        lg = RectangleShape,
        md = RectangleShape,
        sm = RectangleShape,
        xs = RectangleShape
    )
}

fun getSmallShapes(shapeType: ShapeType): KoreShapes {
    return if (shapeType == ShapeType.SmoothCornerShape) {
        KoreShapes(
            xl = AbsoluteSmoothCornerShape(16.dp),
            lg = AbsoluteSmoothCornerShape(12.dp),
            md = AbsoluteSmoothCornerShape(8.dp),
            sm = AbsoluteSmoothCornerShape(4.dp),
            xs = AbsoluteSmoothCornerShape(2.dp)
        )
    } else {
        KoreShapes(
            xl = RoundedCornerShape(16.dp),
            lg = RoundedCornerShape(12.dp),
            md = RoundedCornerShape(8.dp),
            sm = RoundedCornerShape(4.dp),
            xs = RoundedCornerShape(2.dp)
        )
    }
}
fun getMediumShapes(shapeType: ShapeType): KoreShapes {
    return if (shapeType == ShapeType.SmoothCornerShape) {
        KoreShapes(
            xl = AbsoluteSmoothCornerShape(34.dp),
            lg = AbsoluteSmoothCornerShape(24.dp),
            md = AbsoluteSmoothCornerShape(16.dp),
            sm = AbsoluteSmoothCornerShape(12.dp),
            xs = AbsoluteSmoothCornerShape(8.dp)
        )
    } else {
        KoreShapes(
            xl = RoundedCornerShape(34.dp),
            lg = RoundedCornerShape(24.dp),
            md = RoundedCornerShape(16.dp),
            sm = RoundedCornerShape(12.dp),
            xs = RoundedCornerShape(8.dp)
        )
    }
}
fun getLargeShapes(shapeType: ShapeType): KoreShapes {
    return if (shapeType == ShapeType.SmoothCornerShape) {
        KoreShapes(
            xl = AbsoluteSmoothCornerShape(48.dp),
            lg = AbsoluteSmoothCornerShape(32.dp),
            md = AbsoluteSmoothCornerShape(24.dp),
            sm = AbsoluteSmoothCornerShape(16.dp),
            xs = AbsoluteSmoothCornerShape(12.dp)
        )
    } else {
        KoreShapes(
            xl = RoundedCornerShape(48.dp),
            lg = RoundedCornerShape(32.dp),
            md = RoundedCornerShape(24.dp),
            sm = RoundedCornerShape(16.dp),
            xs = RoundedCornerShape(12.dp)
        )
    }
}

fun getCircleShapes(): KoreShapes {
    return KoreShapes(
        xl = CircleShape,
        lg = CircleShape,
        md = CircleShape,
        sm = CircleShape,
        xs = CircleShape
    )
}



enum class ShapeType{
    RoundedRectangle,
    SmoothCornerShape,
}

enum class ShapeRadius{
    Sharp,
    Small,
    Medium,
    Large,
    Circle
}
enum class PrimaryColorSource{
    Radix,
    Tailwind,
}

fun ShapeType.toKoreShapes(): KoreShapes {
    val shape = when (this) {
        ShapeType.RoundedRectangle -> RoundedCornerShape(8.dp)
        ShapeType.SmoothCornerShape -> AbsoluteSmoothCornerShape(8.dp)
    }
    return KoreShapes(
        xl = shape.copy(CornerSize(34.dp)),
        lg = shape.copy(all = CornerSize(24.dp)),
        md = shape.copy(all = CornerSize(16.dp)),
        sm = shape.copy(all = CornerSize(12.dp)),
        xs = shape.copy(all = CornerSize(8.dp))
    )
}





