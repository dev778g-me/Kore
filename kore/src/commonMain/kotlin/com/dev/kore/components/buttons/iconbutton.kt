package com.dev.kore.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.IconButtonDefaults.defaultIconButtonHeight
import com.dev.kore.components.buttons.IconButtonDefaults.defaultIconButtonWidth
import com.dev.kore.components.buttons.IconButtonDefaults.ghostIconButtonColors
import com.dev.kore.components.buttons.IconButtonDefaults.outlinedIconButtonColors
import com.dev.kore.components.buttons.IconButtonDefaults.primaryIconButtonColors
import com.dev.kore.components.buttons.IconButtonDefaults.secondaryIconButtonColors
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.LocalContentColor


// base icon button for all the styles
@Composable
internal fun BaseIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean,
    shape : Shape,
    border: BorderStroke ? = null,
    interactionSource: MutableInteractionSource ? =null,
    iconButtonColors: IconButtonColors,
    content: @Composable () -> Unit,
) {
    val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }
        Box(
            modifier = modifier
                .semantics{
                    role = Role.Button
                }
                .defaultMinSize(
                    minWidth = IconButtonDefaults.defaultIconButtonWidth,
                    minHeight = IconButtonDefaults.defaultIconButtonHeight
                )
                .clip(shape)
                .background(
                    shape = shape,
                    color = iconButtonColors.containerColor(enabled = enabled)
                )
                .then(
                    if (border != null) Modifier.border(
                        border = border,
                        shape = shape
                    ) else Modifier
                )
                .clickable(
                    interactionSource = resolvedInteractionSource,
                    role = Role.Button,
                    enabled = enabled,
                    onClick = {
                        onClick.invoke()
                    }
                ),
            contentAlignment = Alignment.Center
        ){
            CompositionLocalProvider(
                value = LocalContentColor provides iconButtonColors.contentColor(enabled = enabled)
            ) {
                content()
            }
        }
    }


/**
 * A highly prominent IconButton
 * use this composable for the primary tasks / important tasks on a screen
 * @param onClick the action to perform when this component is clicked
 * @param modifier the [Modifier] applied to PrimaryIconButton
 * @param enabled controls the enabled state of this component. When `false`, this component will not respond to user input [Boolean]
 * @param shape the shape of the PrimaryIconButton [Shape]
 * @param interactionSource the [MutableInteractionSource] representing the stream of interactions for this Composable
 * @param primaryIconButtonColors the colors of the PrimaryIconButtons [IconButtonColors]
 * @param content the content of the ICon, typically an Icon [Composable]
 */
@Composable
fun PrimaryIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = CircleShape,
    interactionSource: MutableInteractionSource ? =null,
    primaryIconButtonColors: IconButtonColors = IconButtonDefaults.primaryIconButtonColors(),
    content: @Composable () -> Unit,
) {
    BaseIconButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        interactionSource = interactionSource,
        iconButtonColors = primaryIconButtonColors,
        content = content
    )
}

/**
 * A medium-emphasis IconButton
 * use this composable for actions that shouldn't draw much attention as PrimaryIconButton / secondaryActions
 * @param onClick the action to perform when this component is clicked
 * @param modifier the [Modifier] applied to SecondaryIconButton
 * @param enabled controls the enabled state of this component. When `false`, this component will not respond to user input [Boolean]
 * @param shape the shape of the SecondaryIconButton [Shape]
 * @param interactionSource the [MutableInteractionSource] representing the stream of interactions for this Composable
 * @param secondaryIconButtonColors the colors of the SecondaryIconButtons [IconButtonColors]
 * @param content the content of the Icon, typically an Icon [Composable]
 */
@Composable
fun SecondaryIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = CircleShape,
    interactionSource: MutableInteractionSource ? =null,
    secondaryIconButtonColors: IconButtonColors = IconButtonDefaults.secondaryIconButtonColors(),
    content: @Composable () -> Unit,
) {
    BaseIconButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        interactionSource = interactionSource,
        iconButtonColors =  secondaryIconButtonColors,
        content = content
    )
}


/**
 * A medium-emphasis IconButton with an outlined border
 * use this composable for alternate actions or secondary actions
 * @param onClick the action to perform when this component is clicked
 * @param modifier the [Modifier] applied to OutlinedIconButton
 * @param enabled controls the enabled state of this component. When `false`, this component will not respond to user input [Boolean]
 * @param shape the shape of the OutlinedIconButton [Shape]
 * @param interactionSource the [MutableInteractionSource] representing the stream of interactions for this Composable
 * @param outlinedIconButtonColors the colors of the OutlinedIconButtons [IconButtonColors]
 * @param content the content of the Icon, typically an Icon [Composable]
 */
@Composable
fun OutlinedIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = CircleShape,
    interactionSource: MutableInteractionSource ? =null,
    outlinedIconButtonColors: IconButtonColors = IconButtonDefaults.outlinedIconButtonColors(),
    border: BorderStroke = BorderStroke(width = 1.dp, color = if (enabled)outlinedIconButtonColors.outlinedBorderColor!! else outlinedIconButtonColors.disabledOutlinedBorderColor!!),
    content: @Composable () -> Unit,
) {
    BaseIconButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        iconButtonColors = outlinedIconButtonColors,
        shape = shape,
        interactionSource = interactionSource,
        border = border,
        content = content
    )
}


/**
 * A low-emphasis transparent IconButton
 * use this composable for very low priority actions / optional actiions in the screen
 * @param onClick the action to perform when this component is clicked
 * @param modifier the [Modifier] applied to GhostIconButton
 * @param enabled controls the enabled state of this component. When `false`, this component will not respond to user input [Boolean]
 * @param shape the shape of the GhostIconButton [Shape]
 * @param interactionSource the [MutableInteractionSource] representing the stream of interactions for this Composable
 * @param content the content of the Icon, typically an Icon [Composable]
 */

@Composable
fun GhostIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = CircleShape,
    interactionSource: MutableInteractionSource ? =null,
    content: @Composable () -> Unit,
) {
    BaseIconButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        interactionSource = interactionSource,
        iconButtonColors = IconButtonDefaults.ghostIconButtonColors(),
        content = content
    )
}


/**
 * IconButtonDefaults is the default values for all the IconButtons Composable
 * @property defaultIconButtonWidth the minimum width for the IconButton for accessibility [Dp]
 * @property defaultIconButtonHeight the minimum height for the IconButton for accessibility [Dp]
 * @property primaryIconButtonColors the default colors for PrimaryIconButton
 * @property secondaryIconButtonColors the default colors for SecondaryIconBUtton
 * @property outlinedIconButtonColors the default colors for OutlinedIconBUtton
 * @property ghostIconButtonColors  the default colors for GhostIconButton
 *
 *
 */
object IconButtonDefaults{


    val defaultIconButtonWidth = 48.dp

    val defaultIconButtonHeight = 48.dp

    @Composable
    fun primaryIconButtonColors(
        iconButtonContainerColor: Color = KoreTheme.colorScheme.primary,
        iconButtonContentColor: Color = KoreTheme.colorScheme.onPrimary,
        disabledIconButtonColor: Color = KoreTheme.colorScheme.disabled,
        disabledIconContentColor: Color = KoreTheme.colorScheme.onDisabled

    ) = IconButtonColors(
        iconButtonContainerColor = iconButtonContainerColor,
        iconButtonContentColor = iconButtonContentColor,
        disabledIconButtonContainerColor = disabledIconButtonColor,
        disabledIconContentColor = disabledIconContentColor
    )


    @Composable
    fun secondaryIconButtonColors(
        iconButtonContainerColor: Color = KoreTheme.colorScheme.primaryContainer,
        iconButtonContentColor: Color = KoreTheme.colorScheme.onPrimaryContainer,
        disabledIconButtonColor: Color = KoreTheme.colorScheme.disabled,
        disabledIconContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = IconButtonColors(
        iconButtonContainerColor = iconButtonContainerColor,
        iconButtonContentColor = iconButtonContentColor,
        disabledIconButtonContainerColor = disabledIconButtonColor,
        disabledIconContentColor = disabledIconContentColor
    )

    @Composable
    fun outlinedIconButtonColors(
        iconButtonContainerColor: Color = KoreTheme.colorScheme.primary.copy(alpha = 0.1f),
        iconButtonContentColor: Color = KoreTheme.colorScheme.primary,
        outlinedBorderColor: Color = KoreTheme.colorScheme.primary,
        disabledOutlinedBorderColor: Color = KoreTheme.colorScheme.disabled,
        disabledIconButtonColor: Color = KoreTheme.colorScheme.transparent,
        disabledIconContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = IconButtonColors(
        iconButtonContainerColor = iconButtonContainerColor,
        iconButtonContentColor = iconButtonContentColor,
        outlinedBorderColor = outlinedBorderColor,
        disabledOutlinedBorderColor = disabledOutlinedBorderColor,
        disabledIconButtonContainerColor = disabledIconButtonColor,
        disabledIconContentColor = disabledIconContentColor
    )


    @Composable
    fun ghostIconButtonColors(
        iconButtonContainerColor: Color = KoreTheme.colorScheme.transparent,
        iconButtonContentColor: Color = KoreTheme.colorScheme.onBackGround,
        disabledIconButtonColor: Color = KoreTheme.colorScheme.transparent,
        disabledIconContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = IconButtonColors(
        iconButtonContainerColor = iconButtonContainerColor,
        iconButtonContentColor = iconButtonContentColor,
        disabledIconButtonContainerColor = disabledIconButtonColor,
        disabledIconContentColor = disabledIconContentColor
    )




}



/*
this defines all the colors for iconButtons
 */
@Immutable
data class IconButtonColors(
    val iconButtonContainerColor : Color,
    val iconButtonContentColor : Color,
    val outlinedBorderColor : Color? = null,
    val disabledOutlinedBorderColor: Color? = null,
    val disabledIconButtonContainerColor : Color,
    val disabledIconContentColor : Color
)


private fun IconButtonColors.containerColor(enabled: Boolean) : Color{
    return if (enabled) iconButtonContainerColor else disabledIconButtonContainerColor
}

private fun IconButtonColors.contentColor(enabled: Boolean) : Color{
    return  if (enabled) iconButtonContentColor else disabledIconContentColor
}

