package com.dev.kore.utilities.extensions

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun Color.animateTo(
    target: Color,
    condition: Boolean,
    animationSpec: AnimationSpec<Color> = tween()
): Color {
    val color by animateColorAsState(
        targetValue = if (condition) target else this,
        animationSpec = animationSpec,
        label = "animateColor"
    )
    return color
}



@Composable
fun Dp.animateTo(
    target: Dp ,
    condition: Boolean,
    animationSpec: AnimationSpec<Dp> = tween()
) : Dp{
    val dp by animateDpAsState(
        targetValue = if (condition) target else this,
        animationSpec = animationSpec,
        label = "animateDp"
    )

    return dp
}



@Composable
fun Float.animateTo(
    target: Float,
    condition: Boolean,
    animationSpec: AnimationSpec<Float> = tween()
): Float{
    val float by animateFloatAsState(
        targetValue = if (condition) target else this,
        animationSpec = animationSpec,
        label = "animateFloat"
    )
    return  float
}
