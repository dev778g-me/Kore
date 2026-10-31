package com.dev.kore.themes.indication

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.lerp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.node.DelegatableNode
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.isSpecified
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.math.hypot


/**
 * Default constants used when drawing ripple effects in response to [Interaction] events.
 */
private const val PressedAlpha = 0.12f
private const val HoverAlpha = 0.08f

private const val PressFadeInDuration = 50
private const val RippleExpandDuration = 450
private const val RippleFadeOutDuration = 120
private const val HoverFadeDuration = 150


/**
 * Class that draws the ripple effects on [Interaction].
 * @param interactionSource the source of interactions used to trigger ripple effects.
 * @param color the color of the ripple drawn over the content.
 * @param bounded whether the ripple is clipped to the bounds of the content.
 * @param radius the radius of the ripple which decides how much bigger circle we need to draw to show the ripple effect on the content.
 *
 */
private class FoundationRippleNode(
    private val interactionSource: InteractionSource,
    private val color: Color,
    private val bounded: Boolean,
    private val radius: Dp
) : Modifier.Node(),
    DrawModifierNode {

    // job for the coroutine
    private var interactionJob: Job? = null

    // radius of the ripple circle
    private val progress = Animatable(0f)

    // alpha of the ripple circle
    private val rippleAlpha = Animatable(0f)

    // alpha of the hover
    private val hoverAlpha = Animatable(0f)

    // current touch position
    private var touchPosition = Offset.Zero


    // overriding the on attach function
    override fun onAttach() {
        super.onAttach()

        interactionJob = coroutineScope.launch {

            val scope = this

            var fadeInJob: Job? = null
            var expandJob: Job? = null
            var fadeOutJob: Job? = null
            var hoverJob: Job? = null

            // collecting interactions
            interactionSource.interactions.collect { interaction ->

                when (interaction) {

                    is PressInteraction.Press -> {
                        touchPosition = interaction.pressPosition

                        // cancel anything still running from the previous press
                        fadeInJob?.cancel()
                        expandJob?.cancel()
                        fadeOutJob?.cancel()

                        progress.snapTo(0f)
                        rippleAlpha.snapTo(0f)

                        // Start the ripple immediately

                        // animating alpha value to make the ripple visible
                        fadeInJob = scope.launch {
                            rippleAlpha.animateTo(
                                targetValue = PressedAlpha,
                                animationSpec = tween(PressFadeInDuration, easing = LinearEasing)
                            )
                        }

                        // animating drawing the circle i mean the ripple in case
                        expandJob = scope.launch {
                            progress.animateTo(
                                targetValue = 1f,
                                animationSpec = tween(RippleExpandDuration, easing = FastOutSlowInEasing)
                            )
                        }
                    }

                    is PressInteraction.Release,
                    is PressInteraction.Cancel -> {
                        fadeOutJob?.cancel()
                        fadeOutJob = scope.launch {
                            fadeInJob?.join()
                            expandJob?.join()
                            rippleAlpha.animateTo(0f, tween(RippleFadeOutDuration, easing = LinearEasing))
                        }
                    }

                    is HoverInteraction.Enter -> {
                        hoverJob?.cancel()
                        hoverJob = scope.launch {
                            hoverAlpha.animateTo(HoverAlpha, tween(HoverFadeDuration, easing = LinearEasing))
                        }
                    }

                    is HoverInteraction.Exit -> {
                        hoverJob?.cancel()
                        hoverJob = scope.launch {
                            hoverAlpha.animateTo(0f, tween(HoverFadeDuration, easing = LinearEasing))
                        }
                    }
                }
            }
        }
    }

    override fun onDetach() {
        // canceling the job on detach
        interactionJob?.cancel()
        super.onDetach()
    }

    override fun ContentDrawScope.draw() {
        drawContent()
        val alpha = rippleAlpha.value

        val hover = hoverAlpha.value

        // if alpha is 0 return the function
        if (hover <= 0f && alpha <= 0f) return

        if (bounded) clipRect { drawRipple(hover, alpha) } else drawRipple(hover, alpha)
    }

    private fun DrawScope.drawRipple(hover: Float, alpha: Float) {
        if (hover > 0f) drawRect(color.copy(alpha = hover))
        if (alpha <= 0f) return

        val p = progress.value
        val center = Offset(size.width / 2f, size.height / 2f)
        val endRadius = when {
            radius.isSpecified -> radius.toPx()
            bounded -> hypot(size.width, size.height) / 2f + 4f
            else -> size.maxDimension / 2f
        }

        drawCircle(
            color = color.copy(alpha = alpha),
            radius = endRadius * p,
            // starts at the touch point and drifts to the center as it grows
            center = lerp(if (bounded) touchPosition else center, center, p)
        )
    }
}


/**
 * The factory class that creates [FoundationRippleNode] to draw ripple effects on [Interaction].
 * @param color the color of the ripple drawn over the content.
 * @param bounded whether the ripple is clipped to the bounds of the content.
 * @param radius the radius of the ripple which decides how much bigger circle we need to draw to show the ripple effect on the content.
 */
private class FoundationRippleNodeFactory(
    private val color: Color,
    private val bounded: Boolean,
    private val radius: Dp,
) : IndicationNodeFactory {
    override fun create(interactionSource: InteractionSource): DelegatableNode {
        return FoundationRippleNode(
            interactionSource = interactionSource,
            color = color,
            bounded = bounded,
            radius = radius,
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as FoundationRippleNodeFactory

        // Compare Color using .value (ULong) instead of Color's equals
        if (color.value != other.color.value) return false
        if (bounded != other.bounded) return false
        if (radius != other.radius) return false

        return true
    }

    override fun hashCode(): Int {
        var result = color.value.hashCode()
        result = 31 * result + bounded.hashCode()
        result = 31 * result + radius.hashCode()
        return result
    }
}
/**
 * Creates an [IndicationNodeFactory] that draws ripple effects in response to press interactions.
 *
 * @param color the color of the ripple effect drawn over the content.
 * @param bounded whether the ripple is clipped to the bounds of the content.
 * @param radius the radius of the ripple effect. Defaults to [Dp.Unspecified], allowing the radius to be determined automatically.
 *
 * @return an [IndicationNodeFactory] that provides the ripple effect.
 */

@Stable
fun koreRipple(
    color: Color = Color.Black,
    bounded: Boolean = true,
    radius: Dp = Dp.Unspecified
): IndicationNodeFactory {
    return FoundationRippleNodeFactory(
        color = color,
        bounded = bounded,
        radius = radius
    )
}