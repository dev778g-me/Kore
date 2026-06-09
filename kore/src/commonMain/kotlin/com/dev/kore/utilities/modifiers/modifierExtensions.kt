package com.dev.kore.utilities.modifiers

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreTheme
import kotlinx.coroutines.launch
import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.roundToInt


fun Modifier.scaleClickable(
    pressedScale: Float = 0.95f,
    onClick: () -> Unit,
    role: Role? = null,
    animationSpec: AnimationSpec<Float> ? = null,
    interactionSource: MutableInteractionSource ? = null,
): Modifier = composed {

    val scopedInteractionSource = remember { interactionSource ?: MutableInteractionSource() }

    val isPressed by scopedInteractionSource.collectIsPressedAsState()

    val animatedScale by animateFloatAsState(
        targetValue = if (isPressed) pressedScale else 1f,
        animationSpec = animationSpec ?: spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "pressEffect"
    )

    this
        .graphicsLayer {
            scaleX = animatedScale
            scaleY = animatedScale
        }
        .clickable(
            role = role,
            interactionSource = scopedInteractionSource,
            indication = null,
            onClick = onClick
        )
}

/**
 * Renders a strict mathematical dot grid.
 */
fun Modifier.blueprintGrid(
    gridSize: Dp = 16.dp,
    dotRadius: Dp = 1.dp,
    dotColor: Color = Color.Black
): Modifier = this.drawWithCache {
    val step = gridSize.toPx()
    val radius = dotRadius.toPx()

    val points = mutableListOf<Offset>()
    if (step > 0f) {

        val offsetX = (size.width % step) / 2f
        val offsetY = (size.height % step) / 2f

        val columns = (size.width / step).toInt()
        val rows = (size.height / step).toInt()

        for (x in 0..columns) {
            for (y in 0..rows) {
                points.add(
                    Offset(
                        x = offsetX + (x * step),
                        y = offsetY + (y * step)
                    )
                )
            }
        }
    }

    onDrawBehind {
        if (points.isNotEmpty()) {
            drawPoints(
                points = points,
                pointMode = PointMode.Points,
                color = dotColor,
                strokeWidth = radius * 2,
                cap = StrokeCap.Round
            )
        }
    }
}


/**
 * Creates a magnetic pull effect towards the user's touch/pointer location.
 * @param pullStrength Higher values mean the component moves less.
 */
fun Modifier.magneticPull(pullStrength: Float = 20f): Modifier = composed {
    val offsetX = remember { Animatable(0f) }
    val offsetY = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    this
        .graphicsLayer {
            translationX = offsetX.value
            translationY = offsetY.value
        }
        .pointerInput(Unit) {
            detectDragGestures(
                onDragEnd = {
                    scope.launch {
                        offsetX.animateTo(0f, spring(dampingRatio = 0.5f, stiffness = 500f))
                    }
                    scope.launch {
                        offsetY.animateTo(0f, spring(dampingRatio = 0.5f, stiffness = 500f))
                    }
                },
                onDragCancel = {
                    scope.launch { offsetX.animateTo(0f) }
                    scope.launch { offsetY.animateTo(0f) }
                }
            ) { change, dragAmount ->
                change.consume()
                scope.launch {
                    offsetX.snapTo(offsetX.value + (dragAmount.x / pullStrength))
                    offsetY.snapTo(offsetY.value + (dragAmount.y / pullStrength))
                }
            }
        }
}


fun Modifier.noRippleClickable(
    onClick : () -> Unit,
    enabled : Boolean = true,
    role: Role ? = null,
    interactionSource: MutableInteractionSource ? = null
) : Modifier = composed{

    val scopedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }

    this
        .clickable(
            role = role ,
            onClick = onClick,
            interactionSource = scopedInteractionSource,
            indication = null,
            enabled = enabled
        )

}





fun Modifier.shimmer(
    colors: List<Color>? = null,
    shape: Shape? = null
): Modifier = composed {

    val resolvedColors = colors ?: listOf(
        KoreTheme.colorScheme.backGroundVariant.copy(alpha = 0.7f),
        KoreTheme.colorScheme.backGroundVariant.copy(alpha = 0.3f),
        KoreTheme.colorScheme.backGroundVariant.copy(alpha = 0.7f),
    )
    val resolvedShape = shape ?: KoreTheme.shapes.md


    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition()

    val offsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2000,
            )
        )
    )

    this
        .background(
            shape = resolvedShape,
            brush = Brush.linearGradient(
                colors = resolvedColors,
                start = Offset(x = offsetX, y = 0f),
                end = Offset(x = offsetX + size.width.toFloat(), size.height.toFloat())
            )
        )
        .onGloballyPositioned {
            size = it.size
        }
}


private fun Modifier.minimumInteractiveComponentSize(): Modifier = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)

    val minWidthPx = 48.dp.roundToPx()
    val minHeightPx = 48.dp.roundToPx()

    val width = max(placeable.width, minWidthPx)
    val height = max(placeable.height, minHeightPx)

    layout(width, height) {
        val centerX = ((width - placeable.width) / 2f).roundToInt()
        val centerY = ((height - placeable.height) / 2f).roundToInt()

        placeable.place(centerX, centerY)
    }
}

/**
A utility modifier that clears the active focus state when the component is tapped.
This modifier is incredibly useful for form screens and input-heavy UIs.
By applying it to a parent container (like a Box or Column),
you can allow users to dismiss the software keyboard and drop focus from a TextField simply by tapping anywhere on the empty background space.
*/
fun Modifier.clearFocusOnTap(): Modifier = composed {
    val focusManager = LocalFocusManager.current
    this.pointerInput(Unit) {
        detectTapGestures(onTap = {
            focusManager.clearFocus()
        })
    }
}



/**
 * Applies a smooth fade to the top and bottom edges of a scrollable layout.
 * Best applied directly to the LazyColumn or verticalScroll Box.
 * @param fadePercentage The percentage of the screen width to fade on each side (0f to 1f).
 * @param edgeColor The color used at the absolute edges. Must have 0f alpha for a true fade.
 * @param solidColor The color used for the fully visible center area. Must have alpha 1
 */
fun Modifier.verticalFadingEdges(
    fadePercentage: Float = 0.05f,
    edgeColor: Color = Color.Transparent,
    solidColor: Color = Color.Black
): Modifier = this
    .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
    .drawWithContent {
        drawContent()
        drawRect(
            brush = Brush.verticalGradient(
                0f to edgeColor,
                fadePercentage to solidColor,
                (1f - fadePercentage) to solidColor,
                1f to edgeColor,
                startY = 0f,
                endY = size.height
            ),
            blendMode = BlendMode.DstIn
        )
    }


/**
 * Applies a smooth fade to the left and right edges of a horizontally scrollable layout.
 * Best applied directly to the LazyRow or horizontalScroll Box.
 * @param fadePercentage The percentage of the screen width to fade on each side (0f to 1f).
 * @param edgeColor The color used at the absolute edges. Must have 0f alpha for a true fade.
 * @param solidColor The color used for the fully visible center area. Must have 1f alpha.
 */
fun Modifier.horizontalFadingEdges(
    fadePercentage: Float = 0.05f,
    edgeColor: Color = Color.Transparent,
    solidColor: Color = Color.Black
) : Modifier   = this
    .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
    .drawWithContent {
        drawContent()
        drawRect(
            brush = Brush.horizontalGradient(
                0f to edgeColor,
                fadePercentage to solidColor,
                (1f - fadePercentage) to solidColor,
                1f to edgeColor,
                startX = 0f,
                endX = size.width
            ),
            blendMode = BlendMode.DstIn
        )
    }

/**
 * Modifies the element to add a dashed border along the outline of a specified shape.
 * Unlike a standard  border, this modifier draws dashes.
 * @param color the color of the dash border.
 * @param thickness the thickness of the border .
 * @param dashLength The length of each individual dash [Dp]. Defaults to 6.dp.
 * @param gapLength The visual empty space between the edges of consecutive dots [Dp]. Defaults to 4.dp.
 * @param shape The shape of the border to draw the dots along (e.g., RectangleShape, RoundedCornerShape).
 */
fun Modifier.dashedBorder(
    color: Color,
    thickness: Dp = 1.dp,
    dashLength: Dp = 6.dp,
    gapLength: Dp = 4.dp,
    shape: Shape
): Modifier = this.drawWithCache {
    val strokeWidthPx = thickness.toPx()
    val dashLengthPx = dashLength.toPx()
    val gapLengthPx = gapLength.toPx()

    val outline = shape.createOutline(size, layoutDirection, this)

    val borderPath = Path().apply {
        when (outline) {
            is Outline.Rounded -> addRoundRect(roundRect = outline.roundRect)
            is Outline.Rectangle -> addRect(rect = outline.rect)
            is Outline.Generic -> addPath(path = outline.path)
        }
    }
    val dashStroke = Stroke(
        width = strokeWidthPx,
        pathEffect = PathEffect.dashPathEffect(
            intervals = floatArrayOf(dashLengthPx, gapLengthPx),
            phase = 0f
        )
    )
    onDrawWithContent {
        drawContent()
        drawPath(
            color = color,
            path = borderPath,
            style = dashStroke
        )


    }
}


/**
 * Modifies the element to add a dashed border along the outline of a specified shape.
 * Unlike a standard  border, this modifier draws dashes.
 * @param brush the gradient color of the dash border.
 * @param thickness the thickness of the border .
 * @param dashLength The length of each individual dash [Dp]. Defaults to 6.dp.
 * @param gapLength The visual empty space between the edges of consecutive dots [Dp]. Defaults to 4.dp.
 * @param shape The shape of the border to draw the dots along (e.g., RectangleShape, RoundedCornerShape).
 */
fun Modifier.dashedBorder(
    brush: Brush,
    thickness: Dp = 1.dp,
    dashLength: Dp = 6.dp,
    gapLength: Dp = 4.dp,
    shape: Shape
): Modifier = this.drawWithCache {
    val strokeWidthPx = thickness.toPx()
    val dashLengthPx = dashLength.toPx()
    val gapLengthPx = gapLength.toPx()

    val outline = shape.createOutline(size, layoutDirection, this)

    val borderPath = Path().apply {
        when (outline) {
            is Outline.Rounded -> addRoundRect(roundRect = outline.roundRect)
            is Outline.Rectangle -> addRect(rect = outline.rect)
            is Outline.Generic -> addPath(path = outline.path)
        }
    }
    val dashStroke = Stroke(
        width = strokeWidthPx,
        pathEffect = PathEffect.dashPathEffect(
            intervals = floatArrayOf(dashLengthPx, gapLengthPx),
            phase = 0f
        )
    )
    onDrawWithContent {
        drawContent()
        drawPath(
            brush = brush,
            path = borderPath,
            style = dashStroke
        )


    }
}

/**
 * Modifies the element to add a dotted border along the outline of a specified shape.
 * Unlike a standard  border, this modifier draws perfect circles for each dot.
 * The total thickness of the border will be twice the [dotRadius] (the diameter).
 * @param color The color of the dotted border.
 * @param dotRadius The radius of each individual dot [Dp]. Defaults to 2.dp.
 * @param gapLength The visual empty space between the edges of consecutive dots [Dp]. Defaults to 4.dp.
 * @param shape The shape of the border to draw the dots along (e.g., RectangleShape, RoundedCornerShape).
 */
fun Modifier.dotBorder(
    color: Color,
    dotRadius: Dp = 1.dp,
    gapLength: Dp = 4.dp,
    shape: Shape
): Modifier = this.drawWithCache {
    val diameterPx = (dotRadius * 2).toPx()
    val gapLengthPx = gapLength.toPx()

    val outline = shape.createOutline(size, layoutDirection, this)

    val borderPath = Path().apply {
        when (outline) {
            is Outline.Rounded -> addRoundRect(roundRect = outline.roundRect)
            is Outline.Rectangle -> addRect(rect = outline.rect)
            is Outline.Generic -> addPath(path = outline.path)
        }
    }

    val dashStroke = Stroke(
        join = StrokeJoin.Miter,
        width = diameterPx,
        cap = StrokeCap.Round,
        pathEffect = PathEffect.dashPathEffect(
            intervals = floatArrayOf(0f, diameterPx + gapLengthPx),
            phase = 0f
        )
    )

    onDrawWithContent {
        drawContent()
        drawPath(
            color = color,
            path = borderPath,
            style = dashStroke
        )
    }
}


/**
 * Modifies the element to add a dotted border along the outline of a specified shape.
 * Unlike a standard  border, this modifier draws perfect circles for each dot.
 * The total thickness of the border will be twice the [dotRadius] (the diameter).
 * @param brush the gradient color of the dotted border.
 * @param dotRadius The radius of each individual dot [Dp]. Defaults to 2.dp.
 * @param gapLength The visual empty space between the edges of consecutive dots [Dp]. Defaults to 4.dp.
 * @param shape The shape of the border to draw the dots along (e.g., RectangleShape, RoundedCornerShape).
 */
fun Modifier.dotBorder(
    brush: Brush,
    dotRadius: Dp = 1.dp,
    gapLength: Dp = 4.dp,
    shape: Shape
): Modifier = this.drawWithCache {
    val diameterPx = (dotRadius * 2).toPx()
    val gapLengthPx = gapLength.toPx()

    val outline = shape.createOutline(size, layoutDirection, this)

    val borderPath = Path().apply {
        when (outline) {
            is Outline.Rounded -> addRoundRect(roundRect = outline.roundRect)
            is Outline.Rectangle -> addRect(rect = outline.rect)
            is Outline.Generic -> addPath(path = outline.path)
        }
    }

    val dashStroke = Stroke(
        join = StrokeJoin.Miter,
        width = diameterPx,
        cap = StrokeCap.Round,
        pathEffect = PathEffect.dashPathEffect(
            intervals = floatArrayOf(0f, diameterPx + gapLengthPx),
            phase = 0f
        )
    )

    onDrawWithContent {
        drawContent()
        drawPath(
            brush = brush,
            path = borderPath,
            style = dashStroke
        )
    }
}

