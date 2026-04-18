package com.dev.korelibrary.components.stepper

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
import com.dev.korelibrary.components.separators.VerticalSeparator
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.themes.LocalTextStyle

@Composable
fun Stepper(
    modifier: Modifier = Modifier,
    separator: Boolean = true,
    containerColor: Color = StepperDefaults.defaultContainerColor,
    border: BorderStroke? = null,
    shape: Shape = StepperDefaults.defaultStepperShape,
    minLabelWidth: Dp = StepperDefaults.minimumLabelWidth,
    labelPaddingValues: PaddingValues = StepperDefaults.defaultLabelPaddingValues,
    separatorPaddingValues: PaddingValues = StepperDefaults.defaultSeparatorPaddingValues,
    decrementButton: @Composable () -> Unit,
    incrementIcon: @Composable () -> Unit,
    label: @Composable () -> Unit
    ){
    Row (
        modifier = modifier
            .animateContentSize()
            .height(IntrinsicSize.Min)
            .clip(shape)
            .background(color = containerColor, shape = shape)
            .then(if (border != null) Modifier.border(border) else Modifier),
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
            value = LocalTextStyle provides KoreTheme.typography.titleSmall
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





