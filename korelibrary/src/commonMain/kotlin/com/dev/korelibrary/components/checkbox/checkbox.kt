package com.dev.korelibrary.src.Components.CheakBox

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
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.themes.KoreTheme


@Composable
fun CheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckChange : (Boolean) -> Unit,
    enabled: Boolean = true,
    shape: Shape = CheckBoxDefaults.defaultCheckBoxShape,
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
                width = 2.dp,
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








object CheckBoxDefaults{
    val defaultCheckBoxSize = 24.dp


    val defaultCheckSize = 20.dp


    val defaultCheckBoxShape : Shape
        @Composable get() = KoreTheme.shapes.small


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