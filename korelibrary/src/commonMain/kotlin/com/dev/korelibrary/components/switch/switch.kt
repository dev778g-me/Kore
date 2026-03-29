package com.dev.korelibrary.src.Components.Switchs

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.src.Components.Switchs.SwitchDefaults.thumbColor
import com.dev.korelibrary.src.Components.Switchs.SwitchDefaults.trackColor
import com.dev.korelibrary.themes.KoreTheme


@Composable
fun Switch(
    checked : Boolean,
    modifier: Modifier = Modifier,
    onCheckChange : ((Boolean) -> Unit)?,
    thumbContent : @Composable (() -> Unit)? = null,
    enabled : Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    switchColors: SwitchColors = SwitchDefaults.defaultSwitchColors(),
    switchHeight : Dp = SwitchDefaults.defaultSwitchHeight,
    switchWidth : Dp = SwitchDefaults.defaultSwitchTrackWidth,
    thumbPadding : Dp = SwitchDefaults.thumbPadding,
) {

    val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }

    val density = LocalDensity.current
    val maxOffset = with(density) {
        (switchWidth - 24.dp - thumbPadding).toPx()
    }

    val targetOffset = with(density) {
        when {
            checked -> maxOffset
            !checked -> thumbPadding.toPx()
            else -> 89.dp.toPx()
        }
    }
    val thumbOffset by animateFloatAsState(targetOffset, spring(stiffness = Spring.StiffnessMedium))
    val trackColor by animateColorAsState(
        targetValue = switchColors.trackColor(
            enabled = enabled,
            checked = checked
        )
    )

    val thumbColor by animateColorAsState(
        targetValue = switchColors.thumbColor(
            enabled = enabled,
            checked = checked
        )
    )


    val thumbScale by animateFloatAsState(
        targetValue = if (checked)1.2f else 0.9f
    )


    val toggle = if (onCheckChange != null){
        Modifier.toggleable(
            value = checked,
            enabled = enabled,
            role = Role.Switch,
            interactionSource = interactionSource,
            indication = LocalIndication.current,
            onValueChange = onCheckChange
        )
    }else Modifier

    Box(
        modifier = modifier
            .size(switchWidth, switchHeight)
            .clip(CircleShape)
            .background(trackColor)
            .then(toggle)
    ){
        Box(
            modifier = Modifier
                .offset(
                    x = with(density) { thumbOffset.toDp() }
                )
                .align(Alignment.CenterStart)
                .size(24.dp)
                .graphicsLayer {
                    scaleX = thumbScale
                    scaleY = thumbScale
                }.background(thumbColor, CircleShape)
                .clip(CircleShape).then(toggle)
                .padding(4.dp),

            contentAlignment = Alignment.Center
        ) {
            thumbContent?.let {
                thumbContent()
            }
        }
    }
}










object SwitchDefaults{
    val defaultSwitchTrackWidth = 52.dp
    val  defaultSwitchHeight = 32.dp
    val thumbPadding = 4.dp


    @Composable
    fun defaultSwitchColors(
        checkedTrackColor: Color = KoreTheme.colorScheme.primary,
        unCheckedTrackColor: Color = KoreTheme.colorScheme.backGroundVariant,
        disabledCheckedTrackColor: Color = KoreTheme.colorScheme.disabled,
        disabledUncheckedTrackColor: Color = KoreTheme.colorScheme.disabled,
        checkedThumbColor : Color = KoreTheme.colorScheme.onPrimary,
        unCheckedThumbColor : Color = KoreTheme.colorScheme.onBackGroundVariant,
        disabledCheckedThumbColor: Color = KoreTheme.colorScheme.onDisabled,
        disabledUncheckedThumbColor: Color = KoreTheme.colorScheme.onDisabled,
        uncheckedBorderColor: Color = KoreTheme.colorScheme.onPrimary,
        checkedBorderColor: Color = KoreTheme.colorScheme.transParentColor
    ) = SwitchColors(
        checkedTrackColor = checkedTrackColor,
        unCheckedTrackColor = unCheckedTrackColor,
        disabledCheckedTrackColor = disabledCheckedTrackColor,
        disabledUncheckedTrackColor = disabledUncheckedTrackColor,
        checkedThumbColor = checkedThumbColor,
        unCheckedThumbColor = unCheckedThumbColor,
        uncheckedBorderColor = uncheckedBorderColor,
        disabledCheckedThumbColor = disabledCheckedThumbColor,
        disabledUncheckedThumbColor = disabledUncheckedThumbColor,
        checkedBorderColor = checkedBorderColor
    )


  internal fun SwitchColors.trackColor(
        enabled: Boolean,
        checked: Boolean
    ) : Color{
    return    if (enabled) if (checked) this.checkedTrackColor else this.unCheckedTrackColor
        else if (checked) this.disabledCheckedTrackColor else this.disabledUncheckedTrackColor

    }


    internal fun SwitchColors.thumbColor(
        checked: Boolean,
        enabled: Boolean
    ): Color {
        return if (enabled) if (checked) this.checkedThumbColor else this.unCheckedThumbColor
        else if (checked) this.disabledCheckedThumbColor else this.disabledUncheckedThumbColor
    }



}


@Immutable
data class SwitchColors(
    val checkedTrackColor : Color,
    val unCheckedTrackColor: Color,
    val disabledCheckedTrackColor : Color,
    val disabledUncheckedTrackColor : Color,
    val checkedThumbColor : Color,
    val unCheckedThumbColor : Color,
    val disabledCheckedThumbColor : Color,
    val disabledUncheckedThumbColor : Color,
    val uncheckedBorderColor : Color,
    val checkedBorderColor : Color
)