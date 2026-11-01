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
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
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
                stateDescription = if (!enabled) "Disabled"
                else if (checked) "On" else "Off"
                if (!enabled) {
                    disabled()
                }
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
/**
 * Defines all the colors of the Switch
 */
@Immutable
class SwitchColors(
    val checkedTrackColor: Color,
    val unCheckedTrackColor: Color,
    val disabledCheckedTrackColor: Color,
    val disabledUncheckedTrackColor: Color,
    val checkedThumbColor: Color,
    val unCheckedThumbColor: Color,
    val disabledCheckedThumbColor: Color,
    val disabledUncheckedThumbColor: Color,
    val uncheckedBorderColor: Color,
    val checkedBorderColor: Color,
    val checkedContentColor: Color,
    val uncheckedContentColor: Color,
    val disabledCheckedContentColor: Color,
    val disabledUncheckedContentColor: Color,
) {

    /**
     * Returns a copy of this [SwitchColors] with the given values overridden.
     * Passing [Color.Unspecified] keeps the current value.
     */
    fun copy(
        checkedTrackColor: Color = this.checkedTrackColor,
        unCheckedTrackColor: Color = this.unCheckedTrackColor,
        disabledCheckedTrackColor: Color = this.disabledCheckedTrackColor,
        disabledUncheckedTrackColor: Color = this.disabledUncheckedTrackColor,
        checkedThumbColor: Color = this.checkedThumbColor,
        unCheckedThumbColor: Color = this.unCheckedThumbColor,
        disabledCheckedThumbColor: Color = this.disabledCheckedThumbColor,
        disabledUncheckedThumbColor: Color = this.disabledUncheckedThumbColor,
        uncheckedBorderColor: Color = this.uncheckedBorderColor,
        checkedBorderColor: Color = this.checkedBorderColor,
        checkedContentColor: Color = this.checkedContentColor,
        uncheckedContentColor: Color = this.uncheckedContentColor,
        disabledCheckedContentColor: Color = this.disabledCheckedContentColor,
        disabledUncheckedContentColor: Color = this.disabledUncheckedContentColor,
    ) = SwitchColors(
        checkedTrackColor.takeOrElse { this.checkedTrackColor },
        unCheckedTrackColor.takeOrElse { this.unCheckedTrackColor },
        disabledCheckedTrackColor.takeOrElse { this.disabledCheckedTrackColor },
        disabledUncheckedTrackColor.takeOrElse { this.disabledUncheckedTrackColor },
        checkedThumbColor.takeOrElse { this.checkedThumbColor },
        unCheckedThumbColor.takeOrElse { this.unCheckedThumbColor },
        disabledCheckedThumbColor.takeOrElse { this.disabledCheckedThumbColor },
        disabledUncheckedThumbColor.takeOrElse { this.disabledUncheckedThumbColor },
        uncheckedBorderColor.takeOrElse { this.uncheckedBorderColor },
        checkedBorderColor.takeOrElse { this.checkedBorderColor },
        checkedContentColor.takeOrElse { this.checkedContentColor },
        uncheckedContentColor.takeOrElse { this.uncheckedContentColor },
        disabledCheckedContentColor.takeOrElse { this.disabledCheckedContentColor },
        disabledUncheckedContentColor.takeOrElse { this.disabledUncheckedContentColor },
    )

    /** The track color for the current [checked] and [enabled] state. */
    @Stable
    fun trackColor(enabled: Boolean, checked: Boolean): Color =
        if (enabled) if (checked) checkedTrackColor else unCheckedTrackColor
        else if (checked) disabledCheckedTrackColor else disabledUncheckedTrackColor

    /** The thumb color for the current [checked] and [enabled] state. */
    @Stable
    fun thumbColor(checked: Boolean, enabled: Boolean): Color =
        if (enabled) if (checked) checkedThumbColor else unCheckedThumbColor
        else if (checked) disabledCheckedThumbColor else disabledUncheckedThumbColor

    /** The content color for the current [checked] and [enabled] state. */
    @Stable
    fun contentColor(checked: Boolean, enabled: Boolean): Color =
        if (enabled) if (checked) checkedContentColor else uncheckedContentColor
        else if (checked) disabledCheckedContentColor else disabledUncheckedContentColor

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SwitchColors) return false
        return checkedTrackColor == other.checkedTrackColor &&
            unCheckedTrackColor == other.unCheckedTrackColor &&
            disabledCheckedTrackColor == other.disabledCheckedTrackColor &&
            disabledUncheckedTrackColor == other.disabledUncheckedTrackColor &&
            checkedThumbColor == other.checkedThumbColor &&
            unCheckedThumbColor == other.unCheckedThumbColor &&
            disabledCheckedThumbColor == other.disabledCheckedThumbColor &&
            disabledUncheckedThumbColor == other.disabledUncheckedThumbColor &&
            uncheckedBorderColor == other.uncheckedBorderColor &&
            checkedBorderColor == other.checkedBorderColor &&
            checkedContentColor == other.checkedContentColor &&
            uncheckedContentColor == other.uncheckedContentColor &&
            disabledCheckedContentColor == other.disabledCheckedContentColor &&
            disabledUncheckedContentColor == other.disabledUncheckedContentColor
    }

    override fun hashCode(): Int {
        var result = checkedTrackColor.hashCode()
        result = 31 * result + unCheckedTrackColor.hashCode()
        result = 31 * result + disabledCheckedTrackColor.hashCode()
        result = 31 * result + disabledUncheckedTrackColor.hashCode()
        result = 31 * result + checkedThumbColor.hashCode()
        result = 31 * result + unCheckedThumbColor.hashCode()
        result = 31 * result + disabledCheckedThumbColor.hashCode()
        result = 31 * result + disabledUncheckedThumbColor.hashCode()
        result = 31 * result + uncheckedBorderColor.hashCode()
        result = 31 * result + checkedBorderColor.hashCode()
        result = 31 * result + checkedContentColor.hashCode()
        result = 31 * result + uncheckedContentColor.hashCode()
        result = 31 * result + disabledCheckedContentColor.hashCode()
        result = 31 * result + disabledUncheckedContentColor.hashCode()
        return result
    }
}
