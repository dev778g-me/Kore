package com.dev.korelibrary.components.loadingIndicator

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.themes.KoreTheme


/**
 * A visual indicator that represents an ongoing task with an unspecified wait time .
 * uses a horizontal line to signal the user that the app is working.
 * @param modifier the [Modifier] applied to LinearLoadingIndicator.
 * @param thickness the thickness of the indicator [Dp]
 * @param cap the visual shape at the end of the progress line [StrokeCap].
 * @param colors the colors of the indicator [LoadingIndicatorColors]
 */
@Composable
fun LinearLoadingIndicator(
    modifier: Modifier = Modifier,
    thickness: Dp = LoadingIndicatorDefaults.defaultLinearLoadingIndicatorStrokeWidth,
    cap: StrokeCap = LoadingIndicatorDefaults.defaultStrokeCap,
    colors: LoadingIndicatorColors = LoadingIndicatorDefaults.linearLoadingIndictorColors()
) {


    val transition = rememberInfiniteTransition()


    val startOffsetX by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500,  easing = FastOutLinearInEasing)
        )
    )

    val endOffsetX by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearOutSlowInEasing)
        )
    )


    Canvas(
        modifier = modifier.fillMaxWidth()
            .height(thickness)

    ){
        val strokeWidthPx = thickness.toPx()

        drawLine(
            cap =cap,
            strokeWidth = strokeWidthPx,
            color = colors.trackColor,
            start = Offset(x = 0f, y = size.height / 2),
            end = Offset(x = size.width  , y = size.height /2)
        )

        drawLine(
            cap = cap,
            strokeWidth = strokeWidthPx,
            color = colors.indicatorColor,
            start = Offset(x =  size.width * startOffsetX, y = size.height / 2),
            end = Offset(x =  size.width * endOffsetX , y = size.height /2)
        )


    }
}


/**
 * A visual indicator that represents an ongoing task with an unspecified wait time .
 * uses a circular indicator to signal the user that the app is working.
 * @param modifier the [Modifier] applied to LinearLoadingIndicator.
 * @param size the size of CircularLoadingIndicator [Dp]
 * @param cap the visual shape at the end of the progress line [StrokeCap].
 * @param thickness the thickness of the indicator [Dp]
 * @param colors the colors of the indicator [LoadingIndicatorColors]
 */
@Composable
fun CircularLoadingIndicator(
    modifier: Modifier = Modifier,
    size : Dp = LoadingIndicatorDefaults.defaultCircularLoadingSize,
    cap: StrokeCap = LoadingIndicatorDefaults.defaultStrokeCap,
    thickness : Dp = LoadingIndicatorDefaults.defaultCircularLoadingIndicatorStrokeWidth,
    colors: LoadingIndicatorColors = LoadingIndicatorDefaults.circularLoadingIndicatorColors()
) {


    val transition = rememberInfiniteTransition()

    val rotation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            repeatMode = RepeatMode.Restart,
            animation = tween(durationMillis = 2000, easing = LinearEasing)
        )
    )


    val sweepAngle by transition.animateFloat(
        initialValue = 30f,
        targetValue = 270f,
        animationSpec = infiniteRepeatable(
            repeatMode = RepeatMode.Reverse,
            animation = tween(1100, easing = CubicBezierEasing(0.4f, 0f, 0.2f, 1f)),
        )
    )

    val arcStart by transition.animateValue(
        initialValue = 0f ,
        targetValue = 360f,
        typeConverter = Float.VectorConverter,
        animationSpec = infiniteRepeatable(
            repeatMode = RepeatMode.Restart,
            animation = tween( durationMillis = 2000, easing = LinearEasing)
        )
    )

    Canvas(
        modifier = modifier
            .size(size)
            .padding(thickness / 2)
            .graphicsLayer {
                rotationZ = rotation
            }
    ) {
        val strokeWidthPx = thickness.toPx()

        drawArc(
            color = colors.trackColor,
            style = Stroke(width = strokeWidthPx, cap = cap),
            startAngle =  -90f,
            sweepAngle =  360f,
            useCenter = false
        )
        drawArc(
            color = colors.indicatorColor,
            style = Stroke(width = strokeWidthPx, cap = cap, ),
            startAngle =  arcStart -90f,
            sweepAngle = sweepAngle,
            useCenter = false
        )
    }

}







object LoadingIndicatorDefaults{


  // defaults values for circular loading indicator
   val defaultCircularLoadingSize = 48.dp

    val defaultStrokeCap : StrokeCap = StrokeCap.Round

    val defaultCircularLoadingIndicatorStrokeWidth = 6.dp



    @Composable
    fun circularLoadingIndicatorColors(
        trackColor: Color = KoreTheme.colorScheme.backGroundVariant,
        indicatorColor: Color = KoreTheme.colorScheme.primary,
    ) = LoadingIndicatorColors(
        trackColor = trackColor,
        indicatorColor = indicatorColor
    )


    // defaults vals for linear -> line loading indicator


    val defaultLinearLoadingIndicatorStrokeWidth = 6.dp

    @Composable
    fun linearLoadingIndictorColors(
        trackColor: Color = KoreTheme.colorScheme.backGroundVariant,
        indicatorColor: Color = KoreTheme.colorScheme.primary,
    ) = LoadingIndicatorColors(
        trackColor = trackColor,
        indicatorColor = indicatorColor
    )
}






















@Immutable
data class LoadingIndicatorColors(
    val  trackColor : Color,
    val indicatorColor : Color,
)