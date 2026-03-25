package com.dev.korelibrary.src.Components.Themes.Ripple




import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.node.DelegatableNode
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.unit.Dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


// ok do trying to implement a ripple effect only using the foundation of jetpack compose

//
/*
the engine it does all the work
>implements draw modifier node  to get the draw function
uses on attach and coroutine to launch the animations
this is the class which decides the ripple behaviour
*/

private class FoundationRippleNode(
    private val interactionSource: InteractionSource,
    private val color: Color,
    private val bounded: Boolean,
    private val radius : Dp
) : Modifier.Node(),
    DrawModifierNode{

    // job for the coroutine
    private var interactionJob: Job? = null

    // radius of the ripple circle
    private val animatedRadiusPercent = Animatable(0f)

    // alpha of the ripple circle
    private val animatedAlpha = Animatable(0f)

    // current touch position
    private var touchPosition = Offset.Zero


  // overriding the on attach function
    override fun onAttach() {
        super.onAttach()


        interactionJob = coroutineScope.launch {

            // collecting interactions
            interactionSource.interactions.collect { interaction ->

                when (interaction) {


                    is PressInteraction.Press -> {

                        touchPosition = interaction.pressPosition


                        //touchPosition = interaction.pressPosition

                        animatedRadiusPercent.snapTo(0f)

                        animatedAlpha.snapTo(0f)



                        launch {
                            animatedAlpha.animateTo(
                                targetValue = 0.12f,
                                animationSpec = tween(100, easing = LinearEasing)
                            )
                        }




                        launch {
                           animatedRadiusPercent.animateTo(
                               targetValue = 1f,
                               animationSpec = tween(450, easing = FastOutSlowInEasing)
                           )
                        }



                    }

                    is PressInteraction.Cancel ->{
                        animatedAlpha.animateTo(
                            targetValue = 0f,
                            animationSpec = tween(200)
                        )
                    }


                    is PressInteraction.Release -> {
                        coroutineScope.launch {
                            animatedRadiusPercent.animateTo(
                                targetValue = 1f,
                                animationSpec = tween(300,)
                            )

                            animatedAlpha.animateTo(0f, animationSpec = tween(350))
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
        val alpha = animatedAlpha.value

        // if alpha is 0 return the function

        if (alpha<= 0f) return

        val targetRadius = if (radius != Dp.Unspecified) {
            radius.toPx()
        } else {
            val dx = maxOf(touchPosition.x, size.width - touchPosition.x)
            val dy = maxOf(touchPosition.y, size.height - touchPosition.y)
            kotlin.math.sqrt(dx * dx + dy * dy) * 1.1f
        }


        // getting the radius
        val currentRadius = targetRadius * animatedRadiusPercent.value
        val rippleColor  = color.copy(alpha = alpha)


        if (bounded){
            clipRect(

            ) {
                drawCircle(
                    center = touchPosition ,
                    color = rippleColor,
                    radius = currentRadius
                )
            }
        } else {
            drawCircle(
                center = touchPosition,
                color = rippleColor,
                radius = size.maxDimension
            )
        }


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
): IndicationNodeFactory{
    return FoundationRippleNodeFactory(
        color = color,
        bounded = bounded,
        radius = radius
    )
}


