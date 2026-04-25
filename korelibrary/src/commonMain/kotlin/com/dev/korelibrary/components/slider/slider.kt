package com.dev.korelibrary.components.slider

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.themes.KoreTheme
import kotlinx.coroutines.launch


class SliderState(
    initialValue: Float,
    onValueChange: (Float) -> Unit,
    val valueRange: ClosedFloatingPointRange<Float> = 0f..100f,

    ){
    var sliderValue by mutableFloatStateOf(initialValue)


    var trackWidth by mutableFloatStateOf(0f)



    var onValueChange by mutableStateOf(onValueChange)


    val  range = valueRange.endInclusive - valueRange.start


    val fraction : Float
        get() {
            return if (range <=0f) 0f
            else ((sliderValue - valueRange.start)/ range).coerceIn(0f..1f)
        }
    val sliderValueAnimatable = Animatable(fraction)

    suspend fun animate(fraction: Float){
        sliderValueAnimatable.animateTo(
            fraction
        )
    }

    suspend fun snapTo(fraction: Float){
        sliderValueAnimatable.snapTo(fraction)
    }

    fun updateNewValue(offsetX : Float) : Float{
        // let offser = 5
        if (trackWidth<=0f) return fraction

        // 5 / max ..coerce
        val newFraction = (offsetX / trackWidth).coerceIn(0f..1f)


        val newValue = valueRange.start + range * newFraction

        sliderValue = newValue
        onValueChange(newValue)

        return newFraction

    }


}


@Composable
fun rememberSliderState(
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float> = 0f..100f
): SliderState{
    val state = remember( valueRange){
        SliderState(
            initialValue = value,
            onValueChange = onValueChange,
            valueRange = valueRange
        )}

    SideEffect {
        state.sliderValue = value
        state.onValueChange = onValueChange

    }

    return state
}

/**
 * Slider allow user to make selection from a range of values
 * @param value the current value of the slide [Float]
 * @param onValueChange the callback that is called when the value changes i.e. when user slides the slider
 * @param modifier the [Modifier] applied to the slider
 * @param enabled the [Boolean] value which decides the slider is enabled or not i.e. the user can slide or not if false the user can't interact with slider
 * @param valueRange the value range of the slider i.e. the minimum and maximum value of the slider
 * @param thickness the thickness of the slider [Dp]
 * @param shape the shape of the slider [Shape]
 * @param colors the colors of the slider. Use [SliderDefaults.defaultSliderColors] to customize
 */
@Composable
fun Slider (
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..100f,
    thickness: Dp = SliderDefaults.defaultSliderHeight,
    shape: Shape = SliderDefaults.defaultSliderShape,
    colors: SliderColors = SliderDefaults.defaultSliderColors()
    ){
    SliderImpl(
        modifier = modifier,
        sliderState = rememberSliderState(
            value = value,
            valueRange = valueRange,
            onValueChange = onValueChange
        ),
        enabled = enabled,
        shape = shape,
        colors = colors,
        thickness = thickness

    )

}


@Composable
fun SliderImpl(
    modifier: Modifier,
    sliderState: SliderState,
    enabled: Boolean,
    shape: Shape ,
    thickness: Dp ,
    colors: SliderColors,
) {

    val scope = rememberCoroutineScope()

    val trackColor by animateColorAsState(
        targetValue = colors.trackColor(
        enabled =     enabled
        )
    )

    val progressColor by animateColorAsState(
        targetValue = colors.progressColor(
            enabled = enabled
        )
    )


    val thumbColor by animateColorAsState(
        targetValue = colors.thumbColor(
            enabled = enabled
        )
    )

    val scale = remember { Animatable(1f) }
    Layout(
        modifier = modifier
            .fillMaxWidth(),
        content = {
          // track drag touch both
            Canvas(
                modifier = Modifier
                    .layoutId(layoutId = SliderComponents.Track)
                    .fillMaxWidth()
                    .height(thickness)
                    .pointerInput(enabled) {
                        if (!enabled) return@pointerInput
                        detectTapGestures(
                            onTap = {
                                val new = sliderState.updateNewValue(
                                    offsetX = it.x
                                )
                                scope.launch {
                                        sliderState.animate(fraction = new)
                                    }

                                },
                            )
                        }.pointerInput(
                            key1 = enabled
                        ) {
                            if (!enabled) return@pointerInput
                            detectHorizontalDragGestures(
                                onDragStart = { offset ->
                                    val newValue = sliderState.updateNewValue(offsetX = offset.x)
                                    scope.launch {
                                        scale.animateTo(1.2f)
                                    }
                                    scope.launch {
                                        sliderState.snapTo(newValue)
                                    }

                                },
                                onDragEnd = {
                                    scope.launch {
                                        scale.animateTo(1f)
                                    }
                                },
                                onHorizontalDrag = { change, dragAmount ->
                                    val currentPixel =
                                        sliderState.sliderValueAnimatable.value * sliderState.trackWidth

                                    val newPixel = currentPixel + dragAmount

                                    val new = sliderState.updateNewValue(offsetX = newPixel)

                                    scope.launch {
                                        sliderState.snapTo(new)
                                    }
                                }
                            )
                        }
                ){
                    val trackSize  = Size(width = size.width, height = size.height)
                    val outline = shape.createOutline(
                        size = trackSize,
                        layoutDirection = layoutDirection,
                        density = this
                    )
                when(outline){
                    is Outline.Rectangle -> drawRect(
                        color = trackColor,
                    )

                    is Outline.Rounded ->{
                        val  path = Path().apply {
                            addRoundRect(outline.roundRect)
                        }
                        drawPath(
                            path = path,
                            color = trackColor
                        )}

                    is Outline.Generic -> drawPath(
                        path = outline.path,
                        color = trackColor
                    )
                }
                }

                Canvas(
                    modifier = Modifier
                        .layoutId(
                            layoutId = SliderComponents.Progress
                        )
                        .fillMaxWidth()  .height(thickness)
                ){
                    val progressWidth = sliderState.sliderValueAnimatable.value * size.width

                    val progressSize = Size(width = progressWidth, height = size.height)

                    val outline = shape.createOutline(
                        size = progressSize,
                        layoutDirection = layoutDirection,
                        density = this
                    )


                    when(outline){
                        is Outline.Rectangle -> drawRect(
                            color = progressColor,
                            size = progressSize
                        )

                        is Outline.Rounded ->{
                            val  path = Path().apply {
                                addRoundRect(outline.roundRect)
                            }
                            drawPath(
                            path = path,
                            color = progressColor
                        )}

                        is Outline.Generic -> drawPath(
                            path = outline.path,
                            color = progressColor
                        )
                    }
                }



            Box(
                modifier = Modifier.layoutId(SliderComponents.Thumb)
                    .size(24.dp,)
                    .graphicsLayer{
                    scaleX = scale.value
                    scaleY = scale.value
                }
                    .background(
                        color = KoreTheme.colorScheme.onPrimary,
                        shape = CircleShape
                    ).clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = thumbColor,
                        shape = CircleShape
                    )
                    .pointerInput(
                        key1 = enabled
                    ) {
                        if (!enabled) return@pointerInput
                        detectHorizontalDragGestures(
                            onDragStart = { offset ->
                                val newValue = sliderState.updateNewValue(offsetX = offset.x)
                                scope.launch {
                                    scale.animateTo(1.2f)
                                }
                                scope.launch {
                                    sliderState.snapTo(newValue)
                                }

                            },
                            onDragEnd = {
                                scope.launch {
                                    scale.animateTo(1f)
                                }
                            },
                            onHorizontalDrag = { change, dragAmount ->
                                val currentPixel =
                                    sliderState.sliderValueAnimatable.value * sliderState.trackWidth

                                val newPixel = currentPixel + dragAmount

                                val new = sliderState.updateNewValue(offsetX = newPixel)

                                scope.launch {
                                    sliderState.snapTo(new)
                                }
                            }
                        )
                    }
                ,

                contentAlignment = Alignment.Center
            ){

            }

        }
    ){measurables , constraints ->

        val looseConstraints = constraints.copy(minHeight = 0, minWidth = 0)

        val trackPlaceable  = measurables.first {
            it.layoutId == SliderComponents.Track
        }.measure(looseConstraints
        )
        sliderState.trackWidth = trackPlaceable.width.toFloat()

        val progressPlaceable = measurables.first {
            it.layoutId == SliderComponents.Progress
        }.measure(looseConstraints)

        val thumbPlaceable = measurables.first {
            it.layoutId == SliderComponents.Thumb
        }.measure(Constraints(
            minHeight = 0,
            minWidth = 0,
            maxWidth = constraints.maxWidth,
            maxHeight = Constraints.Infinity
        ))

        val totalHeight = maxOf(
            a = trackPlaceable.height,
            b = progressPlaceable.height,
            c = thumbPlaceable.height
        )

        val thumbOffset = (thumbPlaceable.width / 2)
        val thumbX = (sliderState.sliderValueAnimatable.value * trackPlaceable.width)
            .toInt()
            .minus(thumbOffset)
            .coerceIn(0, trackPlaceable.width - thumbPlaceable.width)
        layout(
            width = constraints.maxWidth,
            height = totalHeight
        ){

            val trackY = (totalHeight - trackPlaceable.height) / 2
            trackPlaceable.place(position = IntOffset(x = 0, y = trackY))

            val progressY = (totalHeight - progressPlaceable.height ) /2
            progressPlaceable.place(
                position = IntOffset(x = 0, y =progressY)
            )

            thumbPlaceable.place(
                position = IntOffset(x = thumbX, y = 0)
            )

        }



    }


}


private enum class SliderComponents{
    Thumb,
    Track,

    Progress
}


/**
 * SliderDefaults defines all the Default values for [Slider]
 * @property defaultSliderHeight the default thickness of the slider [Dp]
 * @property defaultSliderShape the default shape of the slider [Shape]
 * @property defaultSliderColors  the default colors of the slider [SliderColors]
 *
 */
object SliderDefaults{

    val defaultSliderHeight=  8.dp


    val defaultSliderShape
        @Composable get() = KoreTheme.shapes.sm

    @Composable
    fun defaultSliderColors(
        enabledTrackColor: Color = KoreTheme.colorScheme.backGroundVariant,
        disabledTrackColor: Color = KoreTheme.colorScheme.disabled,
        enabledProgressColor: Color = KoreTheme.colorScheme.primary,
        disabledProgressColor: Color = KoreTheme.colorScheme.onDisabled,
        enabledThumbColor: Color = KoreTheme.colorScheme.primary,
        disabledThumbColor: Color = KoreTheme.colorScheme.onDisabled
    ) = SliderColors(
        enabledTrackColor  = enabledTrackColor,
        disabledTrackColor =disabledTrackColor,
        enabledProgressColor =enabledProgressColor,
        disabledProgressColor =disabledProgressColor,
        enabledThumbColor = enabledThumbColor,
        disabledThumbColor =disabledThumbColor
    )



}

/**
 * Defines all slider colors
 */
@Immutable
data class SliderColors(
    val enabledTrackColor: Color,
    val disabledTrackColor: Color,
    val enabledProgressColor: Color,
    val disabledProgressColor: Color,
    val enabledThumbColor: Color,
    val disabledThumbColor: Color,
)




private fun SliderColors.trackColor(
    enabled : Boolean
) : Color{
    return  if (enabled) this.enabledTrackColor else this.disabledTrackColor
}

private fun SliderColors.progressColor(
    enabled: Boolean
) : Color {
    return  if (enabled) this.enabledProgressColor else this.disabledProgressColor
}

private fun SliderColors.thumbColor(
    enabled: Boolean
) : Color{
   return if (enabled) this.enabledThumbColor else this.disabledThumbColor
}