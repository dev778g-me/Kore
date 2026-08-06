package com.dev.kore.components.buttonGroup

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.kore.components.separators.VerticalSeparator
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.LocalContentColor
import com.dev.kore.themes.LocalTextStyle


interface ButtonGroupRowScope : RowScope


private class ButtonGroupRowScopeWrapper(scope : RowScope) :
    ButtonGroupRowScope, RowScope by scope

/**
 * ButtonGroup is a component that combines multiple related button into a single unified container .
 * @param modifier the [Modifier] applied to the ButtonGroup.
 * @param shape the [Shape] of the container.
 * @param borderStroke the [BorderStroke] of the container.
 * @param content the content of the ButtonGroup [ButtonGroupRowScope].
 */
@Composable
fun ButtonGroup(
    modifier: Modifier = Modifier,
    shape: Shape = ButtonGroupDefaults.defaultButtonGroupShape,
    borderStroke: BorderStroke = BorderStroke(width = 1.dp, color = KoreTheme.colorScheme.backGroundVariant),
    content : @Composable ButtonGroupRowScope.() -> Unit
) {

    Row(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .width(IntrinsicSize.Max)
            .border(border = borderStroke, shape = shape)
            .clip(shape),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val scope = remember { ButtonGroupRowScopeWrapper(this) }

        scope.content()

    }
}

/**
 * A clickable button item designed to be used within a ButtonGroup.
 * @param onClick Will be called when the user clicks this button item.
 * @param modifier The [Modifier] to be applied to button item.
 * @param enabled Controls the enabled state of the button. When `false`, this component will* not respond to user input,
 * @param showSeparator Whether to draw a vertical separator line next to this item to visually
 * divide it from the adjacent button in the row.
 * @param separatorThickness The thickness (width) of the separator line if [showSeparator] is `true`.
 * @param colors the colors applied to the button item. Use [ButtonGroupDefaults.defaultClickableItemColors] to customize.
 * @param paddingValues The spacing values to apply to the button item's content.
 * @param interactionSource The [MutableInteractionSource] representing the stream of interactions
 * @param leadingIcon Optional composable to be displayed at the start (leading edge) of the button's [content].
 * @param trailingIcon Optional composable to be displayed at the end (trailing edge) of the button's [content].
 * @param content The primary composable content of the button, typically a `Text` [Composable].
 */
@Composable
fun ButtonGroupRowScope.ClickableButtonItem(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    showSeparator: Boolean = true,
    separatorThickness: Dp = 1.dp,
    colors: ClickableButtonColors = ButtonGroupDefaults.defaultClickableItemColors(),
    paddingValues: PaddingValues = ButtonGroupDefaults.defaultButtonGroupContentPadding,
    interactionSource: MutableInteractionSource? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }

    val containerColor by animateColorAsState(targetValue = colors.containerColor(enabled = enabled))

    val contentColor by animateColorAsState(targetValue = colors.contentColor(enabled = enabled))
    Row(
        modifier = modifier
            .defaultMinSize(minHeight = ButtonGroupDefaults.defaultButtonGroupMinHeight)
            .background(color = containerColor)
            .clickable (enabled = enabled, onClick = onClick, role = Role.Button, interactionSource = resolvedInteractionSource )
            .padding(paddingValues),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.CenterHorizontally)
    ) {
        CompositionLocalProvider(
            LocalTextStyle provides KoreTheme.typography.title2,
            LocalContentColor provides contentColor
        ){
            leadingIcon?.let {
                it()
            }
            content()

            trailingIcon?.let {
                it()
            }


        }

    }

    if (showSeparator){
        VerticalSeparator(thickness = separatorThickness, color = colors.separatorColor)
    }
}


/**
 * A toggleable button item designed to be used within a ButtonGroup.
 * @param selected Whether this button item is currently selected or unselected.
 * @param onClick Will be called when the user clicks this button item.
 * @param modifier The [Modifier] to be applied to button item.
 * @param enabled Controls the enabled state of the button. When `false`, this component will not respond to user input.
 * @param showSeparator Whether to draw a vertical separator line next to this item to visually
 * divide it from the adjacent button in the row.
 * @param separatorThickness The thickness (width) of the separator line if [showSeparator] is `true`.
 * @param colors the colors applied to the button item. Use [ButtonGroupDefaults.defaultToggleButtonColors] to customize.
 * @param paddingValues The spacing values to apply to the button item's content.
 * @param interactionSource The [MutableInteractionSource] representing the stream of interactions.
 * @param leadingIcon Optional composable to be displayed at the start (leading edge) of the button's [content].
 * @param trailingIcon Optional composable to be displayed at the end (trailing edge) of the button's [content].
 * @param content The primary composable content of the button, typically a `Text` [Composable].
 */
@Composable
fun ButtonGroupRowScope.ToggleButtonItem(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    showSeparator: Boolean = true,
    separatorThickness: Dp = 1.dp,
    colors: ToggleButtonColors = ButtonGroupDefaults.defaultToggleButtonColors(),
    paddingValues: PaddingValues = ButtonGroupDefaults.defaultButtonGroupContentPadding,
    interactionSource: MutableInteractionSource? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit
){
    val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }

    val toggleableModifier = Modifier.selectable(
        enabled = enabled,
        selected = selected,
        onClick = onClick,
        role = Role.RadioButton,
        interactionSource = resolvedInteractionSource
    )

    val containerColor by animateColorAsState(
        targetValue = colors.containerColor(selected = selected, enabled = enabled)
    )

    val contentColor by animateColorAsState(
        targetValue = colors.contentColor(selected = selected, enabled = enabled)
    )

    Row(
        modifier = modifier
            .defaultMinSize(minHeight = ButtonGroupDefaults.defaultButtonGroupMinHeight)
            .background(color = containerColor)
            .then(toggleableModifier)
            .padding(paddingValues),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterHorizontally)
    ) {
        CompositionLocalProvider(
            LocalTextStyle provides KoreTheme.typography.title2,
            LocalContentColor provides contentColor
        ){
            leadingIcon?.let {
                it()
            }
            content()

            trailingIcon?.let {
                it()
            }


        }

    }

    if (showSeparator){
        VerticalSeparator(thickness = separatorThickness, color = colors.separatorColor)
    }
}




/**
 * Contains the default values used by button groups and their associated items.
 */
object ButtonGroupDefaults {

    /**
     * The default shape applied to the button group.
     */
    val defaultButtonGroupShape: Shape
        @Composable get() = KoreTheme.shapes.sm

    /**
     * The default container color applied to the button group.
     */
    val defaultButtonGroupContainerColor: Color
        @Composable get() = KoreTheme.colorScheme.surface

    /**
     * The default minimum height for the button group.
     */
    val defaultButtonGroupMinHeight: Dp = 40.dp

    /**
     * The default spacing values to apply to the button group items' content.
     */
    val defaultButtonGroupContentPadding: PaddingValues
        @Composable get() = PaddingValues(
            horizontal = KoreTheme.sizes.sm
        )

    /**
     * Creates a [ToggleButtonColors] that represents the default colors used in a `ToggleButtonItem`.
     * @param unSelectedContainerColor The container color when the button is unselected and enabled.
     * @param selectedContainerColor The container color when the button is selected and enabled.
     * @param unselectedContentColor The content color when the button is unselected and enabled.
     * @param selectedContentColor The content color when the button is selected and enabled.
     * @param disabledContainerColor The container color when the button is disabled.
     * @param disabledContentColor The content color when the button is disabled.
     * @param separatorColor The color of the separator line next to the button item.
     */
    @Composable
    fun defaultToggleButtonColors(
        unSelectedContainerColor: Color = KoreTheme.colorScheme.surface,
        selectedContainerColor: Color = KoreTheme.colorScheme.primaryContainer,
        unselectedContentColor: Color = KoreTheme.colorScheme.onBackGround,
        selectedContentColor: Color = KoreTheme.colorScheme.onPrimaryContainer,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledContentColor: Color = KoreTheme.colorScheme.onDisabled,
        separatorColor: Color = KoreTheme.colorScheme.backGroundVariant
    ) = ToggleButtonColors(
        unSelectedContainerColor = unSelectedContainerColor,
        selectedContainerColor = selectedContainerColor,
        unselectedContentColor = unselectedContentColor,
        selectedContentColor = selectedContentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor,
        separatorColor = separatorColor
    )

    /**
     * Creates a [ClickableButtonColors] that represents the default colors used in a `ClickableButtonItem`.
     * @param containerColor The container color when the button is enabled.
     * @param contentColor The content color when the button is enabled.
     * @param separatorColor The color of the separator line next to the button item.
     * @param disabledContainerColor The container color when the button is disabled.
     * @param disabledContentColor The content color when the button is disabled.
     */
    @Composable
    fun defaultClickableItemColors(
        containerColor: Color = KoreTheme.colorScheme.surface,
        contentColor: Color = KoreTheme.colorScheme.onBackGround,
        separatorColor: Color = KoreTheme.colorScheme.backGroundVariant,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = ClickableButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        separatorColor = separatorColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )
}

data class ToggleButtonColors(
    val unSelectedContainerColor : Color,
    val selectedContainerColor : Color,
    val unselectedContentColor : Color,
    val selectedContentColor : Color,
    val disabledContainerColor : Color,
    val disabledContentColor : Color,
    val separatorColor: Color
){
    @Composable
    fun containerColor(selected: Boolean, enabled: Boolean) = when {
        !enabled -> disabledContainerColor
        selected -> selectedContainerColor
        else -> unSelectedContainerColor
    }

    @Composable
    fun contentColor(selected : Boolean, enabled: Boolean)= when{
        !enabled -> disabledContentColor
        selected -> selectedContentColor
        else -> unselectedContentColor
    }
}


data class ClickableButtonColors(
    val containerColor: Color,
    val contentColor: Color,
    val separatorColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color,
){
    @Composable
    fun containerColor(enabled: Boolean) = when {
        !enabled -> disabledContainerColor
        else -> containerColor
    }
    @Composable
    fun contentColor(enabled: Boolean) = when {
        !enabled -> disabledContentColor
        else -> contentColor
    }
}
