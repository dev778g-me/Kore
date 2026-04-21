package com.dev.korelibrary.components.separators
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.themes.KoreTheme



/**
 * A horizontal line that is used to separate content
 *
 * @param modifier the [Modifier] applied to the layout
 * @param thickness the thickness of the separator in [Dp]
 * @param separatorCap the treatment of the end of line [StrokeCap]
 * @param color the color of the separator [Color]
 * */

@Composable
fun HorizontalSeparator(
    modifier: Modifier = Modifier,
    thickness : Dp= SeparatorDefaults.defaultSeparatorThickness,
    separatorCap: StrokeCap = SeparatorDefaults.defaultSeparatorCap,
    color: Color = SeparatorDefaults.defaultSeparatorColor
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(thickness)
    ){
        drawLine(
            cap = separatorCap,
            color = color,
            strokeWidth = thickness.toPx(),
            start = Offset(x = 0f, y = thickness.toPx()/2),
            end = Offset(x = size.width, y = thickness.toPx()/2)
        )
    }
}

/**
 * A horizontal line that is used to separate content
 *
 * @param modifier the [Modifier] applied to the layout
 * @param thickness the thickness of the separator in [Dp]
 * @param separatorCap the treatment of the end of line [StrokeCap]
 * @param brush the gradient color of the separator [Brush]
 * */
@Composable
fun HorizontalSeparator(
    modifier: Modifier = Modifier,
    thickness : Dp= SeparatorDefaults.defaultSeparatorThickness,
    separatorCap: StrokeCap = SeparatorDefaults.defaultSeparatorCap,
    brush: Brush,
) {

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(thickness)
    ){
        drawLine(
            cap = separatorCap,
            brush = brush,
            strokeWidth = thickness.toPx(),
            start = Offset(x = 0f, y = thickness.toPx()/2),
            end = Offset(x = size.width, y = thickness.toPx()/2)
        )
    }
}

/**
 * A vertical line that is used to separate content
 *
 * @param modifier the [Modifier] applied to the layout
 * @param thickness the thickness of the separator in [Dp]
 * @param separatorCap the treatment of the end of line [StrokeCap]
 * @param color the color of the separator [Color]
 * */
@Composable
fun VerticalSeparator(
    modifier: Modifier = Modifier,
    thickness: Dp = SeparatorDefaults.defaultSeparatorThickness,
    separatorCap: StrokeCap = SeparatorDefaults.defaultSeparatorCap,
    color: Color = SeparatorDefaults.defaultSeparatorColor
) {
    Canvas(modifier = modifier.fillMaxHeight().width(thickness)) {
        drawLine(
            cap = separatorCap,
            color = color,
            strokeWidth = thickness.toPx(),
            start = Offset(x = thickness.toPx()/2, y = 0f),
            end = Offset(x = thickness.toPx()/2, y =size.height)
        )
    }
}

/**
 * A horizontal line that is used to separate content
 *
 * @param modifier the [Modifier] applied to the layout
 * @param thickness the thickness of the separator in [Dp]
 * @param separatorCap the treatment of the end of line [StrokeCap]
 * @param brush the gradient color of the separator [Brush]
 * */
@Composable
fun VerticalSeparator(
    modifier: Modifier = Modifier,
    thickness: Dp = SeparatorDefaults.defaultSeparatorThickness,
    separatorCap: StrokeCap = SeparatorDefaults.defaultSeparatorCap,
    brush: Brush,
) {
    Canvas(modifier = modifier.fillMaxHeight().width(thickness)) {
        drawLine(
            cap = separatorCap,
            brush = brush,
            strokeWidth = thickness.toPx(),
            start = Offset(x = thickness.toPx()/2, y = 0f),
            end = Offset(x = thickness.toPx()/2, y =size.height)
        )
    }
}





object SeparatorDefaults{
    val defaultSeparatorThickness = 1.dp

    val defaultSeparatorCap : StrokeCap = StrokeCap.Round


    val defaultSeparatorColor : Color
        @Composable get() = KoreTheme.colorScheme.backGroundVariant




}

