package com.dev.kore.components.checkbox

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreTheme

/**
 * A CheckBox is an input control that allows user to select one or more options.
 * @param modifier the [Modifier] applied to CheckBox
 * @param checked the current checked state of the CheckBox [Boolean]
 * @param onCheckChange the callback invoked when the CheckBox is checked or unchecked
 * @param enabled the enabled state of the CheckBox [Boolean]
 * @param shape the shape of the CheckBox [Shape]
 * @param colors the colors of the CheckBox [CheckBoxColors].Use [CheckBoxDefaults.defaultCheckBoxColors]
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 */

@Composable
fun CheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckChange : (Boolean) -> Unit,
    enabled: Boolean = true,
    shape: Shape = CheckBoxDefaults.defaultCheckBoxShape,
    borderWidth : Dp = CheckBoxDefaults.defaultCheckBoxBorderWidth,
    colors: CheckBoxColors = CheckBoxDefaults.defaultCheckBoxColors(),
    interactionSource: MutableInteractionSource ? = null,
) {

    val backgroundColor by animateColorAsState(
        targetValue = colors.containerColor(checked, enabled),
        animationSpec = tween(200)
    )

    val borderColor by animateColorAsState(
        targetValue = colors.borderColor(checked, enabled),
        animationSpec = tween(200)
    )

    val checkColor by animateColorAsState(
        targetValue = colors.checkColor(checked, enabled)
    )



    val toggleModifier = Modifier.toggleable(
        enabled = enabled,
        value = checked,
        onValueChange = onCheckChange,
        role = Role.Checkbox,
        indication = LocalIndication.current,
        interactionSource = interactionSource ?: remember { MutableInteractionSource() }
    )


    Box(
        modifier = modifier
            .defaultMinSize(
                minHeight = CheckBoxDefaults.defaultCheckBoxSize,
                minWidth = CheckBoxDefaults.defaultCheckBoxSize
            )
            .clip(shape = shape) .then(toggleModifier)
            .background(
                color =backgroundColor,
                shape =shape
            )
            .border(
                width = borderWidth,
                color = borderColor,
                shape = shape
            ),
        contentAlignment = Alignment.Center
    ){

        val value by animateFloatAsState(
            targetValue = if (checked) 1f else 0f,
            animationSpec = tween(400,)
        )



        AnimatedVisibility(
            visible = checked,
            enter = scaleIn(),
            exit = scaleOut()
        ){
            Canvas(
                modifier = Modifier
                    .size(CheckBoxDefaults.defaultCheckSize)
                    .padding(CheckBoxDefaults.defaultCheckPaddingValues)
            ) {
                val checkPath = Path().apply {
                    moveTo(size.width * 0.15f, size.height * 0.56f)
                    lineTo(size.width * 0.37f, size.height * 0.78f)
                    lineTo(size.width * 0.87f, size.height * 0.28f)
                }

                val pathMeasure = PathMeasure()
                pathMeasure.setPath(
                    path = checkPath,
                    forceClosed = false
                )




                drawPath(
                    path = checkPath,
                    color = checkColor,
                    style = Stroke(
                        width = 2.dp.toPx(),
                        cap = StrokeCap.Round,
                        join = StrokeJoin.Round,
                        pathEffect = PathEffect.dashPathEffect(
                            intervals = floatArrayOf(
                                pathMeasure.length * value,
                                pathMeasure.length
                            )
                        )),
                )
            }
        }
    }



}


/**
 * CheckBoxDefaults defines the default values for checkBox
 * @property defaultCheckBoxSize the default size of the CheckBox [Dp]
 * @property defaultCheckSize the default size of the CheckMark [Dp]
 * @property defaultCheckBoxShape the default shape of the CheckBox [Shape]
 * @property defaultCheckBoxBorderWidth the default borderWidth of the CheckBox [Dp]
 * @property defaultCheckPaddingValues the default paddingValues of the CheckMark [PaddingValues]
 * @property defaultCheckBoxColors the default colors of the CheckBox [CheckBoxColors]
 */

object CheckBoxDefaults{
    val defaultCheckBoxSize = 24.dp


    val defaultCheckSize = 20.dp


    val defaultCheckBoxShape : Shape
        @Composable get() = KoreTheme.shapes.xs

    val defaultCheckBoxBorderWidth : Dp = 2.dp


    val defaultCheckPaddingValues : PaddingValues = PaddingValues(
        4.dp
    )


    @Composable
    fun defaultCheckBoxColors(
        checkedContainerColor : Color= KoreTheme.colorScheme.primary,
        uncheckedContainerColor : Color= KoreTheme.colorScheme.background,
        checkedCheckColor : Color = KoreTheme.colorScheme.onPrimary,
        uncheckedCheckColor : Color = KoreTheme.colorScheme.transparent,
        checkedBorderColor: Color = KoreTheme.colorScheme.transparent,
        uncheckedBorderColor : Color = KoreTheme.colorScheme.primary,
        disabledContainerColor : Color= KoreTheme.colorScheme.transparent,
        disabledCheckColor : Color = KoreTheme.colorScheme.onDisabled,
        disabledBorderColor: Color = KoreTheme.colorScheme.disabled
    )  = CheckBoxColors(
        checkedContainerColor = checkedContainerColor,
        uncheckedContainerColor = uncheckedContainerColor,
        checkedCheckColor = checkedCheckColor,
        uncheckedCheckColor = uncheckedCheckColor,
        checkedBorderColor = checkedBorderColor,
        uncheckedBorderColor = uncheckedBorderColor,
        disabledContainerColor = disabledContainerColor,
        disabledCheckColor = disabledCheckColor,
        disabledBorderColor = disabledBorderColor
    )
}




private fun CheckBoxColors.containerColor(
    checked : Boolean,
    enabled : Boolean
)  : Color{
     return if (!enabled) {
         disabledContainerColor
     }else {
         if (checked) checkedContainerColor else uncheckedContainerColor
     }
}


private fun CheckBoxColors.borderColor(
    checked : Boolean,
    enabled: Boolean
) : Color{
    return if (!enabled){
        disabledBorderColor
    } else {
        if (checked) checkedBorderColor else uncheckedBorderColor
    }
}



private fun CheckBoxColors.checkColor(
    checked : Boolean,
    enabled: Boolean
) : Color{
    return if (!enabled){
        disabledCheckColor
    } else {
        if (checked) checkedCheckColor else uncheckedCheckColor
    }

}


/**
 * defines all the colors for the checkBox
 */
@Immutable
data class CheckBoxColors(
    val checkedContainerColor : Color,
    val uncheckedContainerColor : Color,
    val checkedCheckColor : Color,
    val uncheckedCheckColor : Color,
    val checkedBorderColor : Color,
    val uncheckedBorderColor : Color,
    val disabledContainerColor : Color,
    val disabledCheckColor : Color,
   val  disabledBorderColor : Color
)