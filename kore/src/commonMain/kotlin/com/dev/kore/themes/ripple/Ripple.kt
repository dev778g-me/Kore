package com.dev.kore.themes.ripple

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.IndicationNodeFactory
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


// ok do trying to implement a ripple effect only using the foundation of jetpack compose

//
/*
the engine it does all the work
>implements draw modifier node  to get the draw function
uses on attach and coroutine to launch the animations
this is the class which decides the ripple behaviour
*/

private const val PressedAlpha = 0.12f
private const val HoverAlpha = 0.08f

private const val PressFadeInMs = 50
private const val RippleExpandMs = 450
private const val RippleFadeOutMs = 120
private const val HoverFadeMs = 150

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
                                animationSpec = tween(PressFadeInMs, easing = LinearEasing)
                            )
                        }

                        // animating drawing the circle i mean the ripple in case
                        expandJob = scope.launch {
                            progress.animateTo(
                                targetValue = 1f,
                                animationSpec = tween(RippleExpandMs, easing = FastOutSlowInEasing)
                            )
                        }
                    }

                    is PressInteraction.Release,
                    is PressInteraction.Cancel -> {
                        fadeOutJob?.cancel()
                        fadeOutJob = scope.launch {
                            fadeInJob?.join()
                            expandJob?.join()
                            rippleAlpha.animateTo(0f, tween(RippleFadeOutMs, easing = LinearEasing))
                        }
                    }

                    is HoverInteraction.Enter -> {
                        hoverJob?.cancel()
                        hoverJob = scope.launch {
                            hoverAlpha.animateTo(HoverAlpha, tween(HoverFadeMs, easing = LinearEasing))
                        }
                    }

                    is HoverInteraction.Exit -> {
                        hoverJob?.cancel()
                        hoverJob = scope.launch {
                            hoverAlpha.animateTo(0f, tween(HoverFadeMs, easing = LinearEasing))
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
 * factory
 * job -> create the foundational ripple
 * implements equals / hashcode for the perf
 *
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

    // FIXED: Use primitive hashCode
    override fun hashCode(): Int {
        var result = color.value.hashCode()
        result = 31 * result + bounded.hashCode()
        result = 31 * result + radius.hashCode()
        return result
    }
}


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