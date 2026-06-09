package com.dev.kore.components.separators
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreTheme



/**
 * A horizontal line that is used to separate content
 *
 * @param modifier the [Modifier] applied to the layout
 * @param thickness the thickness of the separator in [Dp]
 * @param separatorCap the treatment of the end & start of line [StrokeCap]
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
 * A horizontal dashed line  that is used to separate content
 *
 * @param modifier the [Modifier] applied to the layout
 * @param thickness the thickness of the separator in [Dp]
 * @param dashLength the length of each dash [Dp]
 * @param dashGap the gap between each gap [Dp]
 * @param separatorCap the treatment of the end and start of the dash [StrokeCap]
 * @param color the color of the separator [Color]
 * */
@Composable
fun HorizontalDashedSeparator(
    modifier: Modifier = Modifier,
    thickness: Dp = SeparatorDefaults.defaultSeparatorThickness,
    dashLength: Dp = 4.dp,
    dashGap: Dp = 4.dp,
    separatorCap: StrokeCap = SeparatorDefaults.defaultSeparatorCap,
    color: Color = SeparatorDefaults.defaultSeparatorColor
) {

    val density = LocalDensity.current

    val pathEffect = remember( dashLength, dashGap,density){
        with(density){
            PathEffect.dashPathEffect(
                intervals = floatArrayOf(dashLength.toPx(), dashGap.toPx()),
                phase = 0f
            )
        }
    }

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
            end = Offset(x = size.width, y = thickness.toPx()/2),
            pathEffect = pathEffect
        )
    }
}

/**
 * A horizontal dashed line  that is used to separate content
 *
 * @param modifier the [Modifier] applied to the layout
 * @param thickness the thickness of the separator in [Dp]
 * @param dashLength the length of each dash [Dp]
 * @param dashGap the gap between each gap [Dp]
 * @param separatorCap the treatment of the end and start of the dash [StrokeCap]
 * @param brush the brush gradient of the separator [Color]
 * */
@Composable
fun HorizontalDashedSeparator(
    modifier: Modifier = Modifier,
    thickness: Dp = SeparatorDefaults.defaultSeparatorThickness,
    dashLength: Dp = 4.dp,
    dashGap: Dp = 4.dp,
    separatorCap: StrokeCap = SeparatorDefaults.defaultSeparatorCap,
    brush: Brush
) {

    val density = LocalDensity.current

    val pathEffect = remember( dashLength, dashGap,density){
        with(density){
            PathEffect.dashPathEffect(
                intervals = floatArrayOf(dashLength.toPx(), dashGap.toPx()),
                phase = 0f
            )
        }
    }

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
            end = Offset(x = size.width, y = thickness.toPx()/2),
            pathEffect = pathEffect
        )
    }
}


/**
 * A horizontal dotted line that is used to separate content
 *
 * @param modifier the [Modifier] applied to the layout
 * @param dotRadius the thickness of the separator in [Dp]
 * @param dotGap the gap between each dot [Dp]
 * @param color the color of the separator [Color]
 * */

@Composable
fun HorizontalDottedDivider(
    modifier: Modifier = Modifier,
    dotRadius: Dp = 2.dp,
    dotGap: Dp = 4.dp,
    color: Color = SeparatorDefaults.defaultSeparatorColor
) {

    val density = LocalDensity.current

    val pathEffect = remember(dotGap, density, dotRadius){
        with(density){
            PathEffect.dashPathEffect(
                intervals = floatArrayOf(0f, dotRadius.toPx() + dotGap.toPx(), ),
                phase = 0f
            )
        }
    }
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(dotRadius)
    ) {
        val diameterPx = dotRadius.toPx()

        drawLine(
            color = color,
            cap = StrokeCap.Round,
            strokeWidth = diameterPx,
            start = Offset(x = 0f, y = diameterPx / 2f),
            end = Offset(x = size.width, y = diameterPx / 2f),
            pathEffect = pathEffect
        )
    }
}


@Composable
fun HorizontalDottedDivider(
    modifier: Modifier = Modifier,
    dotRadius: Dp = 2.dp,
    dotGap: Dp = 4.dp,
    brush: Brush
) {

    val density = LocalDensity.current

    val pathEffect = remember(dotGap, density, dotRadius){
        with(density){
            PathEffect.dashPathEffect(
                intervals = floatArrayOf(0f, dotRadius.toPx() + dotGap.toPx(), ),
                phase = 0f
            )
        }
    }
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(dotRadius)
    ) {
        val diameterPx = dotRadius.toPx()

        drawLine(
            brush = brush,
            cap = StrokeCap.Round,
            strokeWidth = diameterPx,
            start = Offset(x = 0f, y = diameterPx / 2f),
            end = Offset(x = size.width, y = diameterPx / 2f),
            pathEffect = pathEffect
        )
    }
}


/**
 * A vertical line that is used to separate content
 *
 * @param modifier the [Modifier] applied to the layout
 * @param thickness the thickness of the separator in [Dp]
 * @param separatorCap the treatment of the end & start of line [StrokeCap]
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
 * A vertical line that is used to separate content
 *
 * @param modifier the [Modifier] applied to the layout
 * @param thickness the thickness of the separator in [Dp]
 * @param separatorCap the treatment of the end & start of line [StrokeCap]
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


/**
 * A vertical dashed line  that is used to separate content

 * @param modifier the [Modifier] applied to the layout
 * @param thickness the thickness of the separator in [Dp]
 * @param dashLength the length of each dash [Dp]
 * @param dashGap the gap between each gap [Dp]
 * @param separatorCap the treatment of the end and start of the dash [StrokeCap]
 * @param color the color of the separator [Color]
 * */
@Composable
fun VerticalDashedSeparator(
    modifier: Modifier = Modifier,
    thickness: Dp = SeparatorDefaults.defaultSeparatorThickness,
    dashLength: Dp = 4.dp,
    dashGap: Dp = 4.dp,
    separatorCap: StrokeCap = SeparatorDefaults.defaultSeparatorCap,
    color: Color = SeparatorDefaults.defaultSeparatorColor
){
    val density = LocalDensity.current
    val pathEffect = remember(dashLength,dashGap, density){
        with(density){
            PathEffect.dashPathEffect(
                phase = 0f,
                intervals = floatArrayOf(dashLength.toPx(), dashGap.toPx())
            )
        }
    }

    Canvas(modifier = modifier.fillMaxHeight().width(thickness)){
        drawLine(
            cap = separatorCap,
            color = color,
            strokeWidth = thickness.toPx(),
            start = Offset(x = thickness.toPx() / 2 , y = 0f),
            end = Offset(x = thickness.toPx() /2 , y = size.height),
            pathEffect = pathEffect
        )
    }

}


/**
 * A vertical dashed line  that is used to separate content
 *
 * @param modifier the [Modifier] applied to the layout
 * @param thickness the thickness of the separator in [Dp]
 * @param dashLength the length of each dash [Dp]
 * @param dashGap the gap between each gap [Dp]
 * @param separatorCap the treatment of the end and start of the dash [StrokeCap]
 * @param brush the brush gradient of the separator [Color]
 * */
@Composable
fun VerticalDashedSeparator(
    modifier: Modifier = Modifier,
    thickness: Dp = SeparatorDefaults.defaultSeparatorThickness,
    dashLength: Dp = 4.dp,
    dashGap: Dp = 4.dp,
    separatorCap: StrokeCap = SeparatorDefaults.defaultSeparatorCap,
    brush: Brush
){
    val density = LocalDensity.current
    val pathEffect = remember(dashLength,dashGap, density){
        with(density){
            PathEffect.dashPathEffect(
                phase = 0f,
                intervals = floatArrayOf(dashLength.toPx(), dashGap.toPx())
            )
        }
    }

    Canvas(modifier = modifier.fillMaxHeight().width(thickness)){
        drawLine(
            cap = separatorCap,
            brush = brush,
            strokeWidth = thickness.toPx(),
            start = Offset(x = thickness.toPx() / 2 , y = 0f),
            end = Offset(x = thickness.toPx() /2 , y = size.height),
            pathEffect = pathEffect
        )
    }

}


/**
 * A vertical dotted line  that is used to separate content
 *
 * @param modifier the [Modifier] applied to the layout
 * @param dotRadius the radius of the dots in separators [Dp]
 * @param dotGap the gap between each gap [Dp]
 * @param color the color of the dot across separator [Color]
 * */
@Composable
fun VerticalDottedSeparator(
    modifier: Modifier = Modifier,
    dotRadius : Dp = 2.dp,
    dotGap : Dp = 8.dp,
    color: Color= SeparatorDefaults.defaultSeparatorColor,
){

    val density = LocalDensity.current

    val pathEffect = remember(dotGap, dotRadius,density){
        with(density){
            PathEffect.dashPathEffect(
                phase = 0f,
                intervals = floatArrayOf(0f, dotGap.toPx() + dotRadius.toPx())
            )
        }
    }

    Canvas(
        modifier = modifier.fillMaxHeight()
            .width(dotRadius)
    ){
        val diameterPx = dotRadius.toPx()
        drawLine(
            cap = StrokeCap.Round,
            color = color,
            strokeWidth = diameterPx,
            start = Offset(x = diameterPx / 2 , y = 0f),
            end = Offset(x = diameterPx /2 , y = size.height),
            pathEffect = pathEffect
        )
    }
}

/**
 * A vertical dotted line  that is used to separate content
 *
 * @param modifier the [Modifier] applied to the layout
 * @param dotRadius the radius of the dots in separators [Dp]
 * @param dotGap the gap between each gap [Dp]
 * @param brush the gradient color of the dot across separator [Color]
 * */
@Composable
fun VerticalDottedSeparator(
    modifier: Modifier = Modifier,
    dotRadius : Dp = 2.dp,
    dotGap : Dp = 8.dp,
    brush: Brush,
){

    val density = LocalDensity.current

    val pathEffect = remember(dotGap, dotRadius,density){
        with(density){
            PathEffect.dashPathEffect(
                phase = 0f,
                intervals = floatArrayOf(0f, dotGap.toPx() + dotRadius.toPx())
            )
        }
    }

    Canvas(
        modifier = modifier.fillMaxHeight()
            .width(dotRadius)
    ){
        val diameterPx = dotRadius.toPx()
        drawLine(
            cap = StrokeCap.Round,
            brush = brush,
            strokeWidth = diameterPx,
            start = Offset(x = diameterPx / 2 , y = 0f),
            end = Offset(x = diameterPx /2 , y = size.height),
            pathEffect = pathEffect
        )
    }
}

object SeparatorDefaults{
    val defaultSeparatorThickness = 1.dp

    val defaultSeparatorCap : StrokeCap = StrokeCap.Round


    val defaultSeparatorColor : Color
        @Composable get() = KoreTheme.colorScheme.backGroundVariant




}

