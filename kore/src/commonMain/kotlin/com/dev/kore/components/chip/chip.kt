package com.dev.kore.components.chip

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.LocalContentColor
import com.dev.kore.themes.LocalTextStyle


/**
 * An ActionChip is an interactive UI element that triggers a specific, immediate action or process when tapped.
 * @param onClick the click callback of the action chip.
 * @param modifier the [Modifier] applied to the [ActionChip].
 * @param leadingIcon the leading content (often an image or icon) of the chip which will be placed before the label [Composable].
 * @param trailingIcon the trailing content (often an image or icon) of the chip which will be placed after the label [Composable].
 * @param shape the shape of the chip [Shape].
 * @param colors colors of the Action chip. Use [ChipDefaults.defaultActionChipColors] to customize [ActionChipColors].
 * @param elevation the elevation of the Action chip defaults to 0 [Dp].
 * @param borderWidth the border width of the Action chip defaults to 1.dp [Dp].
 * @param itemSpacing the spacing between the leadingIcon, label & trailing icon [Dp].
 * @param paddingValues the padding of the Action Chip [PaddingValues].
 * @param interactionSource the interactionSource of the Action chip [MutableInteractionSource].
 * @param label the label (generally a [com.dev.kore.components.text.Text]) of the chip which is placed between leadingIcon & trailingIcon in the Chip row.
 */

@Composable
fun ActionChip(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    shape: Shape = ChipDefaults.defaultActionChipShape,
    colors: ActionChipColors = ChipDefaults.defaultActionChipColors(),
    elevation: Dp = ChipDefaults.defaultChipElevation,
    borderWidth: Dp = 1.dp,
    itemSpacing: Dp = ChipDefaults.defaultChipSpacing,
    paddingValues: PaddingValues = ChipDefaults.defaultChipPaddingValues,
    interactionSource: MutableInteractionSource? = null,
    label: @Composable () -> Unit
){
    val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }
    Box(
        modifier = modifier
            .defaultMinSize(minHeight = ChipDefaults.defaultMinChipHeight)
            .shadow(elevation = elevation, shape = shape, clip = true)
            .clip(shape)
            .clickable(
                interactionSource = resolvedInteractionSource ,
                onClick = onClick,
                role = Role.Button
            ).background(
                shape = shape,
                color = colors.containerColor
            )
            .border(
                border = BorderStroke(borderWidth, color = colors.borderColor),
                shape = shape
            )
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ){
        CompositionLocalProvider(
            LocalContentColor provides colors.contentColor,
            LocalTextStyle provides KoreTheme.typography.label1

        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(itemSpacing),
                verticalAlignment = Alignment.CenterVertically
            ){
                leadingIcon?.let {
                    leadingIcon()
                }

                label()

                trailingIcon?.let {
                    trailingIcon()
                }
            }
        }
    }

}

/**
 * A FilterChip is an interactive UI element that uses tags or descriptive words to filter content, representing a toggleable choice.
 * @param selected the [Boolean] state which decides the selected state of the [FilterChip] .
 * @param onClick the click callback of the filter chip .
 * @param modifier the [Modifier] applied to the [FilterChip] .
 * @param enabled the [Boolean] state which decides if the filter chip is enabled or not .
 * @param leadingIcon the leading content (often an image or icon) of the chip which will be placed before the label [Composable] .
 * @param trailingIcon the trailing content (often an image or icon) of the chip which will be placed after the label [Composable] .
 * @param shape the shape of the chip [Shape].
 * @param colors colors of the Filter chip. use [ChipDefaults.defaultFilterChipColors] to customize [FilterChipColors].
 * @param elevation the elevation of the Filter chip defaults to [ChipDefaults.defaultChipElevation] [Dp]
 * @param border the border stroke of the Filter chip [BorderStroke]
 * @param itemSpacing the spacing between the leadingIcon, label & trailing icon [Dp]
 * @param paddingValues the padding of the Filter chip [PaddingValues] .
 * @param interactionSource the interactionSource of the Filter chip [MutableInteractionSource]
 * @param label the label (generally a [com.dev.kore.components.text.Text]) of the chip which is placed between leadingIcon & trailingIcon in the Chip row .
 */
@Composable
fun FilterChip(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    shape: Shape = ChipDefaults.defaultActionChipShape,
    colors: FilterChipColors = ChipDefaults.defaultFilterChipColors(),
    elevation: Dp = ChipDefaults.defaultChipElevation,
    border: BorderStroke? = null,
    itemSpacing : Dp = ChipDefaults.defaultChipSpacing,
    paddingValues: PaddingValues = ChipDefaults.defaultChipPaddingValues,
    interactionSource: MutableInteractionSource? = null,
    label: @Composable () -> Unit
){

    val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }
    val containerColor by animateColorAsState(
        targetValue =  colors.containerColor(selected = selected, enabled = enabled)
    )

    val contentColor by animateColorAsState(targetValue =  colors.contentColor(selected = selected, enabled = enabled))

    val selectableModifier = Modifier.selectable(
        selected = selected,
        enabled = enabled,
        role = Role.Checkbox,
        onClick = onClick,
        interactionSource = resolvedInteractionSource
    )

    Box(
        modifier = modifier
            .defaultMinSize(minHeight = ChipDefaults.defaultMinChipHeight)
            .shadow(elevation = elevation, shape = shape, clip = true)
            .clip(shape)
            .then(selectableModifier)
            .background(
                shape = shape,
                color = containerColor
            )
            .then(if (border != null) Modifier.border(border = border, shape = shape) else Modifier)
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        CompositionLocalProvider(
            LocalContentColor provides contentColor,
            LocalTextStyle provides KoreTheme.typography.label1

        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(itemSpacing),
                verticalAlignment = Alignment.CenterVertically
            ){
                leadingIcon?.let {
                    leadingIcon()
                }

                label()

                trailingIcon?.let {
                    trailingIcon()
                }
            }
        }
    }
}
object ChipDefaults{



    val defaultActionChipShape : Shape
        @Composable get () = KoreTheme.shapes.xs

    val defaultChipSpacing : Dp = 4.dp

    val defaultChipPaddingValues : PaddingValues
        @Composable get() =
            PaddingValues(
                horizontal = KoreTheme.sizes.sm
            )



    val defaultChipElevation : Dp = 90.dp

    val defaultLeadingTrailingIconSize : Dp = 18.dp


    val defaultMinChipHeight : Dp = 32.dp

    @Composable
    fun defaultActionChipColors(
        containerColor: Color = KoreTheme.colorScheme.surface,
        contentColor: Color = KoreTheme.colorScheme.onSurface,
        borderColor: Color = KoreTheme.colorScheme.backGroundVariant
    ) = ActionChipColors(
        containerColor = containerColor,
        contentColor = contentColor,
        borderColor = borderColor
    )

    @Composable
    fun defaultFilterChipColors(
        unSelectedContainerColor: Color = KoreTheme.colorScheme.backGroundVariant,
        selectedContainerColor: Color  = KoreTheme.colorScheme.primaryContainer,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,
        unSelectedContentColor: Color = KoreTheme.colorScheme.onBackGround,
        selectedContentColor: Color = KoreTheme.colorScheme.onPrimaryContainer,
        disabledContentColor: Color = KoreTheme.colorScheme.onDisabled,
    )= FilterChipColors(
        unSelectedContainerColor = unSelectedContainerColor,
        selectedContainerColor = selectedContainerColor,
        disabledContainerColor = disabledContainerColor,
        unSelectedContentColor = unSelectedContentColor,
        selectedContentColor = selectedContentColor,
        disabledContentColor = disabledContentColor
    )
}


@Immutable
data class ActionChipColors(
    val containerColor : Color,
    val contentColor : Color,
    val borderColor: Color,
)


@Immutable
data class FilterChipColors(
    val unSelectedContainerColor : Color,
    val selectedContainerColor  : Color,
    val disabledContainerColor : Color,
    val unSelectedContentColor : Color,
    val selectedContentColor : Color,
    val disabledContentColor : Color,

    )

private fun FilterChipColors.contentColor(
    selected: Boolean,
    enabled : Boolean
): Color{
    return  if (enabled){
        if (selected) selectedContentColor else unSelectedContentColor
    }else disabledContentColor
}

private fun FilterChipColors.containerColor(
    selected: Boolean,
    enabled : Boolean
) : Color{
    return  if (enabled){
        if (selected) selectedContainerColor else unSelectedContainerColor
    }else disabledContainerColor}
