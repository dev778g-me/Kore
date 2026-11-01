package com.dev.kore.components.radio

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreTheme

/**
 * Radio Button is an ui component that allows user to select exactly one option from a predefined set of choices.
 * @param selected the [Boolean] value which decides the radio is selected or not
 * @param modifier the [Modifier] applied on radioButton
 * @param onClick the callback invoked when the radio button is clicked
 * @param enabled the [Boolean] value which decides the radio is enabled or not
 * @param colors the colors of the radioButton [RadioButtonColors]
 * @param interactionSource the [MutableInteractionSource] of the radio button
 */
@Composable
fun RadioButton(
    selected : Boolean,
    modifier: Modifier = Modifier,
    onClick : (()-> Unit)?,
    enabled : Boolean= true,
    colors: RadioButtonColors= RadioButtonDefaults.defaultRadioColors(),
    interactionSource: MutableInteractionSource? = null
) {

    val dotRadius by animateDpAsState(
        targetValue = if (selected)
            RadioButtonDefaults.defaultRadioDotSize / 2
        else 0.dp,
        animationSpec = tween(400)
    )

    val dotColor = colors.radioColor(
        enabled = enabled,
        selected = selected
    )

    val containerColor = colors.containerColor(
        enabled = enabled,
        selected = selected
    )

    val selectableModifier =
        if (onClick != null) {
            Modifier.selectable(
                selected = selected,
                enabled = enabled,
                role = Role.RadioButton,
                interactionSource = interactionSource,
             //   indication = LocalIndication.current,
                onClick = onClick
            )
        } else Modifier

    Canvas(
        modifier = modifier
            .semantics{
                role = Role.RadioButton
                stateDescription = if (!enabled) "Disabled"
                else if (selected) "Selected" else "Not selected"
                if (!enabled) {
                    disabled()
                }
            }
            .clip(CircleShape)
            .then(selectableModifier)
            .padding(RadioButtonDefaults.defaultRadioButtonPadding)
            .size(RadioButtonDefaults.defaultIconSize)
    ) {

        val strokeWidth = 2.dp.toPx()

        drawCircle(
            color = containerColor,
            style = Fill
        )

        if (dotRadius > 0.dp) {
            drawCircle(
                color = dotColor,
                radius = dotRadius.toPx()
            )
        }
    }


}


/**
 * RadioButtonDefaults defines the default values for RadioButton
 * @property defaultRadioColors the default colors for radioButton
 * @property defaultRadioDotSize the default size of the dot in the radio button
 * @property defaultRadioButtonPadding the default padding of the radio button
 * @property defaultIconSize the default size of the icon in the radio button
 */

object RadioButtonDefaults{

    @Composable
    fun defaultRadioColors(
        selectedDotColor : Color = KoreTheme.colorScheme.onPrimary,
        unSelectedDotColor : Color = KoreTheme.colorScheme.transparent,
        selectedContainerColor : Color = KoreTheme.colorScheme.primary,
        unSelectedContainerColor : Color = KoreTheme.colorScheme.backGroundVariant,
        disabledDotColor : Color = KoreTheme.colorScheme.onDisabled,
        disabledContainerColor : Color = KoreTheme.colorScheme.disabled
    )= RadioButtonColors(
        selectedDotColor = selectedDotColor,
        unSelectedDotColor = unSelectedDotColor,
        selectedContainerColor = selectedContainerColor,
        unSelectedContainerColor = unSelectedContainerColor,
        disabledDotColor = disabledDotColor,
        disabledContainerColor = disabledContainerColor
    )



    val defaultRadioDotSize = 12.dp

    val defaultRadioButtonPadding = 6.dp

    val defaultIconSize = 20.dp
}


/**
 * defines all colors for radiobutton
 */
@Immutable
class RadioButtonColors(
    val selectedDotColor: Color,
    val unSelectedDotColor: Color,
    val selectedContainerColor: Color,
    val unSelectedContainerColor: Color,
    val disabledDotColor: Color,
    val disabledContainerColor: Color,
) {

    /**
     * Returns a copy of this [RadioButtonColors] with the given values overridden.
     * Passing [Color.Unspecified] keeps the current value.
     */
    fun copy(
        selectedDotColor: Color = this.selectedDotColor,
        unSelectedDotColor: Color = this.unSelectedDotColor,
        selectedContainerColor: Color = this.selectedContainerColor,
        unSelectedContainerColor: Color = this.unSelectedContainerColor,
        disabledDotColor: Color = this.disabledDotColor,
        disabledContainerColor: Color = this.disabledContainerColor,
    ) = RadioButtonColors(
        selectedDotColor.takeOrElse { this.selectedDotColor },
        unSelectedDotColor.takeOrElse { this.unSelectedDotColor },
        selectedContainerColor.takeOrElse { this.selectedContainerColor },
        unSelectedContainerColor.takeOrElse { this.unSelectedContainerColor },
        disabledDotColor.takeOrElse { this.disabledDotColor },
        disabledContainerColor.takeOrElse { this.disabledContainerColor },
    )

    /** The container color for the current [enabled] and [selected] state. */
    @Stable
    fun containerColor(enabled: Boolean, selected: Boolean): Color =
        if (enabled) if (selected) selectedContainerColor else unSelectedContainerColor
        else disabledContainerColor

    /** The dot color for the current [enabled] and [selected] state. */
    @Stable
    fun radioColor(enabled: Boolean, selected: Boolean): Color =
        if (enabled) if (selected) selectedDotColor else unSelectedDotColor
        else disabledDotColor

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RadioButtonColors) return false
        return selectedDotColor == other.selectedDotColor &&
            unSelectedDotColor == other.unSelectedDotColor &&
            selectedContainerColor == other.selectedContainerColor &&
            unSelectedContainerColor == other.unSelectedContainerColor &&
            disabledDotColor == other.disabledDotColor &&
            disabledContainerColor == other.disabledContainerColor
    }

    override fun hashCode(): Int {
        var result = selectedDotColor.hashCode()
        result = 31 * result + unSelectedDotColor.hashCode()
        result = 31 * result + selectedContainerColor.hashCode()
        result = 31 * result + unSelectedContainerColor.hashCode()
        result = 31 * result + disabledDotColor.hashCode()
        result = 31 * result + disabledContainerColor.hashCode()
        return result
    }
}
