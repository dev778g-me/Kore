package com.dev.kore.components.progress

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreTheme

/**
 * A visual Indicator that represents actual progress of a task with a known time
 * uses a horizontal line that fills as the progress of the task increases .
 * @param progress the current progress of the task
 * @param modifier the [Modifier] applied to the LinearProgressIndicator
 * @param thickness the thickness of the LinearProgressIndicator
 * @param cap the visual shape at the end of the line
 * @param colors the colors of the LinearProgressIndicator
 */
@Composable
fun LinearProgressIndicator(
    progress : Float,
    valueRange: ClosedFloatingPointRange<Float> = 0f..100f,
    modifier: Modifier = Modifier,
    thickness : Dp = ProgressIndicatorDefaults.defaultProgressBarThickness,
    cap : StrokeCap = ProgressIndicatorDefaults.defaultProgressBarCap,
    colors: ProgressIndicatorColors = ProgressIndicatorDefaults.barProgressColors(),
) {

    val resolvedProgress = progress.coerceIn(valueRange)

    // normalize to 0f..1f
    val fraction = (resolvedProgress - valueRange.start) /
            (valueRange.endInclusive - valueRange.start)



    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(thickness)
    ) {
        val yCenter = size.height/2
        val strokeWidthPx = thickness.toPx()

        val inset = if (cap == StrokeCap.Butt) 0f else strokeWidthPx /2

        val endX = size.width - inset
        val drawableWidth = endX - inset


        // track of the barrrrrrrrr

        drawLine(
            cap = StrokeCap.Round,
            color = colors.trackColor,
            strokeWidth = strokeWidthPx,
            start = Offset(x = inset, y =  yCenter),
            end = Offset(x = endX, y = yCenter)
        )
        val progressWidth =( drawableWidth * fraction) + inset

        if (resolvedProgress >0){

            drawLine(
                cap = StrokeCap.Round,
                color = colors.progressColor,
                strokeWidth = strokeWidthPx,
                start = Offset(x = inset, y =  yCenter),
                end = Offset(x = progressWidth, y = yCenter)
            )
        }

    }

}

/**
 * A circular visual Indicator that represents actual progress of a task with a known time
 * uses a horizontal line that fills as the progress of the task increases .
 * @param progress the current progress of the task
 * @param modifier the [Modifier] applied to the CircularProgressIndicator
 * @param thickness the thickness of the CircularProgressIndicator
 * @param cap the visual shape at the end of the line
 * @param colors the colors of the CircularProgressIndicator
 */
@Composable
fun CircularProgressIndicator(
    progress: Float,
    valueRange: ClosedFloatingPointRange<Float> = 0f..100f,
    modifier: Modifier = Modifier,
    thickness: Dp = ProgressIndicatorDefaults.defaultCircularBarThickness,
    size : Dp = ProgressIndicatorDefaults.defaultCircularProgressBarSize,
    cap: StrokeCap = ProgressIndicatorDefaults.defaultProgressBarCap,
    colors: ProgressIndicatorColors = ProgressIndicatorDefaults.circularProgressColors()
){


    val resolvedProgress = progress.coerceIn(valueRange)


    val fraction = (resolvedProgress - valueRange.start) /
            (valueRange.endInclusive - valueRange.start)

    Canvas(
        modifier = modifier
            .size(size)
            .padding(thickness /2)
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
          color = colors.progressColor,
          style = Stroke(width = strokeWidthPx, cap = cap),
          startAngle =  -90f,
          sweepAngle = fraction * 360f,
          useCenter = false
      )
    }


}

@Immutable
data class ProgressIndicatorColors(
    val trackColor : Color,
    val progressColor : Color,
)






object ProgressIndicatorDefaults{


    val defaultCircularBarThickness = 6.dp

    val defaultCircularProgressBarSize = 48.dp

    val defaultProgressBarCap : StrokeCap = StrokeCap.Round
    val defaultProgressBarThickness = 6.dp

   @Composable
    fun barProgressColors(
        trackColor: Color = KoreTheme.colorScheme.backGroundVariant,
        progressColor: Color = KoreTheme.colorScheme.primary,
    ) = ProgressIndicatorColors(
        trackColor = trackColor,
        progressColor = progressColor,

    )

    @Composable
    fun circularProgressColors(
        trackColor: Color = KoreTheme.colorScheme.backGroundVariant,
        progressColor: Color = KoreTheme.colorScheme.primary,
    ) = ProgressIndicatorColors(
        trackColor = trackColor,
        progressColor = progressColor,

    )



}