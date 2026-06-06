package com.dev.kore.components.stepper

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.kore.components.separators.VerticalSeparator
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.LocalTextStyle

/**
 * horizontal layout component that groups a decrement button, a central label, and an increment button.
 * Use a `Stepper` when users need to make small, precise adjustments to a continuous or discrete
 * @param label The central content displaying the current value, usually a `Text` composable.
 * @param decrementButton The interactive component placed on the leading side, used to decrease the value.
 * @param incrementIcon The interactive component placed on the trailing side, used to increase the value.
 * @param modifier The [Modifier] applied to the stepper's outer container.
 * @param separator If true, displays a vertical divider between the buttons and the central label.
 * @param shape The geometric clipping shape of the stepper's outer container.
 * @param containerColor The background color of the stepper container.
 * @param border An optional border drawn around the outside of the stepper container.
 * @param minLabelWidth The minimum width allocated for the [label]. Setting this prevents the buttons from shifting positions horizontally when the label text changes size (e.g., changing from "9" to "10").
 * @param labelPaddingValues The padding applied immediately around the [label] content.
 * @param separatorPaddingValues The vertical padding applied to the separators, controlling how close the divider lines get to the top and bottom edges of the container.
 */
@Composable
fun Stepper(
    label: @Composable () -> Unit,
    decrementButton: @Composable () -> Unit,
    incrementIcon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    separator: Boolean = true,
    shape: Shape = StepperDefaults.defaultStepperShape,
    containerColor: Color = StepperDefaults.defaultContainerColor,
    border: BorderStroke? = null,
    minLabelWidth: Dp = StepperDefaults.minimumLabelWidth,
    labelPaddingValues: PaddingValues = StepperDefaults.defaultLabelPaddingValues,
    separatorPaddingValues: PaddingValues = StepperDefaults.defaultSeparatorPaddingValues
    ){
    Row (
        modifier = modifier
            .animateContentSize()
            .height(IntrinsicSize.Min)
            .clip(shape)
            .background(color = containerColor, shape = shape)
            .then(if (border != null) Modifier.border(border,shape) else Modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xxs)
    ){
      
       decrementButton()

        if (separator){
            VerticalSeparator(
                modifier = Modifier.padding(
                    separatorPaddingValues
                )
            )
        }
        CompositionLocalProvider(
            value = LocalTextStyle provides KoreTheme.typography.title3
        ){
            Box(
                modifier = Modifier
                    .widthIn(min = minLabelWidth)
                    .padding(labelPaddingValues),
                contentAlignment = Alignment.Center
            ){
                label()
            }
        }
       if (separator){
           VerticalSeparator(
               modifier = Modifier.padding(
                   separatorPaddingValues
               )
           )
       }
        incrementIcon()
        
    }
}


/**
 * StepperDefaults defines all the default values for [Stepper]
 * @property minimumLabelWidth the minimum width allocated for the label [Dp]
 * @property defaultSeparatorPaddingValues the vertical padding applied to the separators
 * @property defaultLabelPaddingValues the padding values of the label [PaddingValues]
 * @property defaultContainerColor the default background color of the container [Color]
 * @property defaultStepperShape the default shape of the stepper
 */
object StepperDefaults{
    val minimumLabelWidth = 38.dp

    val defaultSeparatorPaddingValues
        @Composable get() = PaddingValues(
            vertical = KoreTheme.sizes.xs,
        )

    val defaultLabelPaddingValues
        @Composable get() = PaddingValues(
            horizontal = KoreTheme.sizes.xs
        )

    val defaultContainerColor : Color
        @Composable get() = KoreTheme.colorScheme.surface


    val defaultStepperShape : Shape
        @Composable get() = KoreTheme.shapes.sm


}





