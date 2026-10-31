package com.dev.kore.themes.indication

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.node.DelegatableNode
import androidx.compose.ui.node.DrawModifierNode
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


/**
 * The class that scales the content on [Interaction]
 * @param interactionSource the source of interactions used to trigger scale effects.
 * @param pressedScale the scale factor applied to the content while it is pressed.
 */
private class FoundationPressedScaleNode(
    private val  interactionSource: InteractionSource,
    private val pressedScale: Float,
) : Modifier.Node(), DrawModifierNode {
    private var interactionJob : Job ? = null


    private var animationJob : Job ? = null

    private val scale = Animatable(1f)


    override fun onAttach() {
        super.onAttach()
        interactionJob = coroutineScope.launch {
            val scope = this



            interactionSource.interactions.collect { interaction ->

                when(interaction){
                    is PressInteraction.Press -> {
                        animationJob?.cancel()

                        animationJob = scope.launch {
                            scale.animateTo(pressedScale)

                        }

                    }
                    is PressInteraction.Release,
                    is PressInteraction.Cancel -> {

                        animationJob?.cancel()

                       animationJob = scope.launch {
                          // running?.join()
                           scale.animateTo(1f)
                       }
                    }

                }

            }

        }
    }

    override fun onDetach() {
        interactionJob?.cancel()
        animationJob?.cancel()
        super.onDetach()
    }

    override fun ContentDrawScope.draw() {
        val s = scale.value
        if (s == 1f) {
            drawContent()
        } else {
            scale(scaleX = s, scaleY = s, pivot = center, block = {
                this@draw.drawContent()
            })
        }


    }
}

/**
 * The Factory class that creates [FoundationPressedScaleNode].
 * @param pressedScale the scale factor applied to the content while it is pressed.
 */
private class FoundationPressedScaleFactory(
 private val pressedScale: Float,
) : IndicationNodeFactory{
    override fun create(interactionSource: InteractionSource): DelegatableNode {
        return FoundationPressedScaleNode(
            interactionSource = interactionSource,
            pressedScale = pressedScale
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        other as FoundationPressedScaleFactory
        return pressedScale == other.pressedScale
    }

    override fun hashCode(): Int = pressedScale.hashCode()
}

/**
 * Creates an [IndicationNodeFactory] that scales content in response to press interactions.
 *
 * @param pressedScale the scale factor applied to the content while pressed.
 * Must be in the range (0f, 1f).
 *
 * @return an [IndicationNodeFactory] that provides the press scale effect.
 *
 * @throws IllegalArgumentException if [pressedScale] is not in the range (0f, 1f).
 */
@Stable
fun koreScaleIndication(
    pressedScale : Float ,
) : IndicationNodeFactory{
    require(pressedScale in 0f..1f)
    return FoundationPressedScaleFactory(
        pressedScale
    )
}