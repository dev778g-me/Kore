package com.dev.kore.components.switch

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.LocalContentColor

/**
 * Switch allows users to toggle state of a single item on or off
 * @param checked the [Boolean] state that controls either switch is checked or not
 * @param onCheckChange the callback that is called when the checked state changes
 * @param modifier the [Modifier] applied to the switch
 * @param enabled controls the enabled state of the switch if false the user will not able to interact with the switch
 * @param checkThumbContent the content of the thumb when the switch is checked .
 * @param unCheckedThumbContent the content of the thumb when the switch is unchecked.
 * @param trackShape the shape of the switch Container [Shape]
 * @param thumbSize the shape of the switch thumb [Shape]
 * @param switchTrackWidth the width of the switch container [Dp]
 * @param switchTrackHeight the height of the switch container. [Dp]
 * @param thumbPadding the padding of the thumb from the switch container [Dp]
 * @param switchColors the colors of the switch. Use [SwitchDefaults.defaultSwitchColors] to change the colors.
 * @param interactionSource the interaction source of the switch.
 */
@Composable
fun Switch(
    checked: Boolean,
    onCheckChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    checkThumbContent: @Composable (() -> Unit)? = null,
    unCheckedThumbContent: @Composable (() -> Unit)? = null,
    transitionSpec:  AnimatedContentTransitionScope<Boolean>.() -> ContentTransform = SwitchDefaults.defaultTransitionSpec,
    trackShape: Shape = SwitchDefaults.defaultTrackShape,
    thumbShape: Shape = SwitchDefaults.defaultThumbShape,
    thumbSize: Dp = SwitchDefaults.defaultSwitchSize,
    switchTrackWidth: Dp = SwitchDefaults.defaultSwitchTrackWidth,
    switchTrackHeight: Dp = SwitchDefaults.defaultSwitchHeight,
    thumbPadding: Dp = SwitchDefaults.thumbPadding,
    switchColors: SwitchColors = SwitchDefaults.defaultSwitchColors(),
    interactionSource: MutableInteractionSource? = null,
) {

    val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }

    val density = LocalDensity.current
    val maxOffset = with(density) {
        (switchTrackWidth - thumbSize - thumbPadding).toPx()
    }

    val targetOffset = with(density) {
        if (checked) maxOffset else thumbPadding.toPx()
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
        targetValue = if (checked)1.1f else 0.9f
    )


    val toggle = if (onCheckChange != null){
        Modifier.toggleable(
            value = checked,
            enabled = enabled,
            role = Role.Switch,
            interactionSource = resolvedInteractionSource,
            indication = LocalIndication.current,
            onValueChange = onCheckChange
        )
    }else Modifier

    Box(
        modifier = modifier
            .semantics{
                role = Role.Switch
            }
            .size(switchTrackWidth, switchTrackHeight)
            .clip(trackShape)
            .background(trackColor, trackShape)
            .then(toggle),
        contentAlignment = Alignment.Center
    ){

        Box(
            modifier = Modifier
                .offset(
                    x = with(density) { thumbOffset.toDp() }
                )
                .align(Alignment.CenterStart)
                .size(thumbSize)
                .graphicsLayer {
                    scaleX = thumbScale
                    scaleY = thumbScale
                }
                .clip(thumbShape)
                .background(thumbColor, thumbShape)
                .padding(thumbPadding),

            contentAlignment = Alignment.Center
        ) {
            checkThumbContent?.let {
                val contentColor by animateColorAsState(
                    targetValue = switchColors.contentColor(checked = checked, enabled = enabled)
                )
                CompositionLocalProvider(
                    LocalContentColor provides contentColor
                ) {
                    AnimatedContent(
                        targetState = checked,
                        transitionSpec = transitionSpec
                    ) {
                        if (it) {
                            checkThumbContent()
                        } else {
                            unCheckedThumbContent?.invoke()
                        }
                    }
                }
            }
        }

    }
}


/**
 * SwitchDefaults defines all the default values for [Switch]
 * @property defaultSwitchSize the default size of the switch [Dp]
 * @property defaultSwitchTrackWidth the default width of the switch container [Dp]
 * @property defaultSwitchHeight the default height of the switch container [Dp]
 * @property thumbPadding the padding of the switch(thumb) from the switch container [Dp]
 * @property defaultTransitionSpec the default transition spec between switching unchecked & checked Content
 * @property defaultThumbShape the default shape of the switch container [Shape]
 * @property defaultTrackShape the default shape of the switch thumb [Shape]
 * @property defaultSwitchColors the default colors of the switch
 */
object SwitchDefaults{

    val defaultSwitchSize : Dp = 24.dp
    val defaultSwitchTrackWidth = 52.dp
    val  defaultSwitchHeight = 32.dp
    val thumbPadding = 4.dp

    val defaultTransitionSpec: AnimatedContentTransitionScope<Boolean>.() -> ContentTransform = {
        (scaleIn() + fadeIn()) togetherWith (scaleOut() + fadeOut())
    }

    val defaultTrackShape : Shape = CircleShape

    val defaultThumbShape : Shape = CircleShape
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
        checkedBorderColor: Color = KoreTheme.colorScheme.transparent,
        checkedContentColor :Color = KoreTheme.colorScheme.primary,
        uncheckedContentColor : Color = KoreTheme.colorScheme.backGroundVariant,
        disabledCheckedContentColor : Color = KoreTheme.colorScheme.disabled,
        disabledUncheckedContentColor :Color = KoreTheme.colorScheme.onDisabled,
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
        checkedBorderColor = checkedBorderColor,
        checkedContentColor = checkedContentColor,
        uncheckedContentColor = uncheckedContentColor,
        disabledCheckedContentColor = disabledCheckedContentColor,
        disabledUncheckedContentColor = disabledUncheckedContentColor
    )






}
private fun SwitchColors.trackColor(
    enabled: Boolean,
    checked: Boolean
) : Color{
    return    if (enabled) if (checked) this.checkedTrackColor else this.unCheckedTrackColor
    else if (checked) this.disabledCheckedTrackColor else this.disabledUncheckedTrackColor

}


private fun SwitchColors.thumbColor(
    checked: Boolean,
    enabled: Boolean
): Color {
    return if (enabled) if (checked) this.checkedThumbColor else this.unCheckedThumbColor
    else if (checked) this.disabledCheckedThumbColor else this.disabledUncheckedThumbColor
}


private fun SwitchColors.contentColor(
    checked: Boolean,
    enabled: Boolean
): Color{
    return  if (enabled) if (checked) checkedContentColor else uncheckedContentColor
    else if (checked) disabledCheckedContentColor else disabledUncheckedContentColor
}

/**
 * Defines all the colors of the Switch
 */
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
    val checkedBorderColor : Color,
    val checkedContentColor : Color,
    val uncheckedContentColor : Color ,
    val disabledCheckedContentColor : Color,
    val disabledUncheckedContentColor : Color,
)