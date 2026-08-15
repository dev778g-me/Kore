package com.dev.kore.components.select

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberTransition
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import androidx.compose.ui.window.PopupProperties
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.LocalContentColor
import com.dev.kore.themes.LocalTextStyle


/**
 * Select allows user to select an option from a list of options.
 * @param expanded the [Boolean] state which decides select expanded state.
 * @param onExpandedChange the callback called when
 * @param onDismissRequest the callback called when select is dismissed.
 * @param modifier the [Modifier] applied to the select.
 * @param enabled the [Boolean] state which decides select enabled state.
 * @param error the [Boolean] state which decides select error state.
 * @param shape the [Shape] of the select container.
 * @param colors the [SelectColors] of the select use [SelectDefaults.defaultSelectColors] to customize.
 * @param borderWidth the width of the Select container.
 * @param contentPadding the content [PaddingValues] for select component content.
 * @param interactionSource the [MutableInteractionSource] of the select.
 * @param leadingContent the leading content of the select placed before the content [Composable].
 * @param trailingContent the trailing content of the select placed after the content [Composable].
 * @param menuContent the content of the select [Composable] recommended using [SelectGroup].
 * @param content the content of the select [Composable].
 */

@Composable
fun Select(
    expanded: Boolean,
    onExpandedChange: () -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    error: Boolean = false,
    shape: Shape = SelectDefaults.defaultSelectShape,
    colors: SelectColors = SelectDefaults.defaultSelectColors(),
    borderWidth: Dp = 1.dp,
    contentPadding: PaddingValues = SelectDefaults.defaultSelectContainerPaddingValues,
    interactionSource: MutableInteractionSource? = null,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    menuContent: @Composable () -> Unit,
    content: @Composable () -> Unit
) {

    val focusRequester = remember { FocusRequester() }

    val resolvedInteractionSource =
        interactionSource ?: remember { MutableInteractionSource() }

    val focused by resolvedInteractionSource.collectIsFocusedAsState()


    val containerColor by animateColorAsState(
        targetValue = colors.containerColor(error = error, enabled = enabled, focused = focused)
    )
    val contentColor by animateColorAsState(
        targetValue = colors.contentColor(error = error, enabled = enabled, focused = focused)
    )
    val borderColor by animateColorAsState(
        targetValue = colors.borderColor(error = error, enabled = enabled, focused = focused)
    )

    Box(
        modifier = modifier.defaultMinSize(
            minHeight = SelectDefaults.defaultSelectMinHeight,
            minWidth = SelectDefaults.defaultSelectMinWidth
        ) .width(IntrinsicSize.Max)
            .clip(shape)
            .background(color = containerColor, shape = shape)
            .border(width = borderWidth, shape = shape, color = borderColor)
            .focusRequester(focusRequester)
            .focusable(
                interactionSource = resolvedInteractionSource
            )
            .clickable(
                onClick = {
                    focusRequester.requestFocus()
                    onExpandedChange()
                },
                enabled = enabled,
                interactionSource = resolvedInteractionSource,
                indication = LocalIndication.current
            ),
        contentAlignment = Alignment.CenterStart

    ) {

        val mutableTransitionState = remember { MutableTransitionState(expanded) }
        mutableTransitionState.targetState = expanded

        val transition = rememberTransition(mutableTransitionState)

        val scale by transition.animateFloat(
            transitionSpec = {
                if (initialState isTransitioningTo targetState) {
                    spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                } else {
                    spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                }
            },


            ) {
            if (it) 1f else 0.85f
        }

        val toolTipAlpha by transition.animateFloat(
            transitionSpec = {
                if (initialState isTransitioningTo targetState) {
                    spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                } else {
                    spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessVeryLow
                    )
                }
            },
        ) { isVisible ->
            if (isVisible) 1f else 0f
        }
        val isSelectExpanded =
            mutableTransitionState.currentState || mutableTransitionState.targetState

        if (isSelectExpanded) {
            Popup(
                onDismissRequest = onDismissRequest,
                properties = PopupProperties(
                    focusable = false
                ),
                popupPositionProvider = SelectDefaults.rememberSelectPositionProvider(position = SelectPosition.Bottom)
            ) {
                Box(
                    modifier = Modifier
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                            alpha = toolTipAlpha
                        }
                        .defaultMinSize(minHeight = 100.dp, minWidth = 300.dp),
                    contentAlignment = Alignment.Center

                ) {
                    menuContent()
                }
            }
        }

        Row(
            modifier = Modifier.padding(contentPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.Start)
        ) {
            CompositionLocalProvider(
                LocalContentColor provides contentColor,
                LocalTextStyle provides KoreTheme.typography.title2
            ) {
                leadingContent?.let {
                    it()
                }

                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    content()
                }

                trailingContent?.let {
                    it()
                }
            }
        }
    }
}

/**
 * SelectGroup allows grouping of options within a select menu.
 * @param modifier the [Modifier] applied to the select group.
 * @param shape the [Shape] of the select group container.
 * @param containerColor the [Color] of the select group container.
 * @param border the [BorderStroke] of the select group container.
 * @param content the content of the select group [Composable] with [ColumnScope] recommended using [SelectGroupItem].
 */
@Composable
fun SelectGroup(
    modifier: Modifier = Modifier,
    shape: Shape = KoreTheme.shapes.sm,
    containerColor: Color = KoreTheme.colorScheme.surface,
    border : BorderStroke? = BorderStroke(width = 1.dp, color = KoreTheme.colorScheme.backGroundVariant),
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
            .width(IntrinsicSize.Max)
            .defaultMinSize(minWidth = 300.dp)
            .clip(shape = shape)
            .background(color = containerColor, shape = shape)
            .thenIfNotNull(border) { Modifier.border(it, shape) }
            .padding(
                8.dp
            ),
    ) {
        content()
    }

}

/**
 * SelectGroupItem allows user to select an individual option within a select group.
 * @param modifier the [Modifier] applied to the select group item.
 * @param selected the [Boolean] state which decides select group item selected state.
 * @param shape the [Shape] of the select group item container.
 * @param onClick the callback called when the select group item is clicked.
 * @param leadingContent the leading content of the select group item placed before the content [Composable].
 * @param trailingContent the trailing content of the select group item placed after the content [Composable].
 * @param enabled the [Boolean] state which decides select group item enabled state.
 * @param colors the [SelectItemColors] of the select group item use [SelectDefaults.defaultSelectItemColors] to customize.
 * @param content the content of the select group item [Composable].
 */
@Composable
fun SelectGroupItem(
    modifier: Modifier = Modifier,
    selected : Boolean ,
    shape: Shape = KoreTheme.shapes.xs,
    onClick: () -> Unit,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    enabled: Boolean = true,
    colors: SelectItemColors = SelectDefaults.defaultSelectItemColors(),
    content : @Composable () -> Unit
){
    val selectableModifier = Modifier.selectable(
        selected = selected,
        enabled = enabled,
        onClick = onClick,
        role = Role.RadioButton
    )

    val containerColor by animateColorAsState(
        targetValue = colors.containerColor(enabled = enabled, selected = selected))

    val contentColor by animateColorAsState(
        targetValue = colors.contentColor(enabled = enabled, selected = selected)
    )

    
    Row(
        modifier = modifier
            .defaultMinSize(
                minHeight = SelectDefaults.defaultSelectItemHeight
            )
            .fillMaxWidth()
            .clip(shape = shape)
            .background(color = containerColor, shape = shape)
            .then(selectableModifier)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        CompositionLocalProvider(
            LocalContentColor provides contentColor,
            LocalTextStyle provides KoreTheme.typography.title3
        ) {
           leadingContent?.let {
               it()
           }

           Box(
               modifier = Modifier.weight(1f)
           ) {
               content()
           }

            trailingContent?.let {
                it()
            }
        }

    }

}


object SelectDefaults{
    val defaultSelectShape: Shape
        @Composable get() = KoreTheme.shapes.sm


    val defaultSelectMinHeight: Dp = 48.dp
    val defaultSelectMinWidth: Dp = 300.dp

    val defaultSelectItemHeight: Dp = 40.dp
    val defaultSelectItemWidth = 300.dp


    val defaultSelectContainerPaddingValues: PaddingValues = PaddingValues(8.dp)


    val defaultSelectPopupSpacing : Dp = 4.dp
    @Composable
    fun defaultSelectColors(
        containerColor : Color = KoreTheme.colorScheme.background,
        contentColor : Color= KoreTheme.colorScheme.onBackGround,
        borderColor : Color= KoreTheme.colorScheme.backGroundVariant,
        focusedContainerColor: Color = KoreTheme.colorScheme.background,
        focusedContentColor : Color = KoreTheme.colorScheme.onBackGround,
        focusedBorderColor : Color= KoreTheme.colorScheme.primary,
        disabledContainerColor : Color= KoreTheme.colorScheme.background,
        disabledContentColor : Color= KoreTheme.colorScheme.onDisabled,
        disabledBorderColor : Color = KoreTheme.colorScheme.disabled,
        errorContainerColor: Color= KoreTheme.colorScheme.background,
        errorContentColor: Color = KoreTheme.colorScheme.onError,
        errorBorderColor: Color= KoreTheme.colorScheme.error,
    ) = SelectColors(
        containerColor = containerColor,
        contentColor = contentColor,
        borderColor = borderColor,
        focusedContainerColor = focusedContainerColor,
        focusedContentColor = focusedContentColor,
        focusedBorderColor = focusedBorderColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor,
        disabledBorderColor = disabledBorderColor,
        errorContainerColor = errorContainerColor,
        errorContentColor = errorContentColor,
        errorBorderColor = errorBorderColor
    )


    @Composable
    fun defaultSelectItemColors (
        unselectedContainerColor : Color = KoreTheme.colorScheme.surface,
        unselectedContentColor : Color= KoreTheme.colorScheme.onBackGround,
        selectedContainerColor : Color= KoreTheme.colorScheme.primaryContainer,
        selectedContentColor: Color= KoreTheme.colorScheme.onPrimaryContainer,
        disabledContainerColor : Color= KoreTheme.colorScheme.disabled,
        disabledContentColor : Color = KoreTheme.colorScheme.onDisabled,
    ) = SelectItemColors(
        unselectedContainerColor = unselectedContainerColor,
        unselectedContentColor = unselectedContentColor,
        selectedContainerColor = selectedContainerColor,
        selectedContentColor = selectedContentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )


    @Composable
    fun rememberSelectPositionProvider(
        position: SelectPosition = SelectPosition.Bottom,
        spacing : Dp = defaultSelectPopupSpacing
    ) : PopupPositionProvider{
        val spacePx =
            with(LocalDensity.current) { spacing.roundToPx() }
        return remember(spacing){
        object : PopupPositionProvider{
            override fun calculatePosition(
                anchorBounds: IntRect,
                windowSize: IntSize,
                layoutDirection: LayoutDirection,
                popupContentSize: IntSize
            ): IntOffset {
             val offset =  when(position){
                 SelectPosition.Top -> {
                     val x = anchorBounds.left + (anchorBounds.width - popupContentSize.width) / 2

                     var y = anchorBounds.top - popupContentSize.height - spacePx

                     if (y < 0) {
                         y = anchorBounds.bottom + spacePx
                     }

                     IntOffset(x, y)
                 }

                 SelectPosition.Bottom -> {
                     val x = anchorBounds.left + (anchorBounds.width - popupContentSize.width) / 2

                     var y = anchorBounds.bottom + spacePx

                     if (y + popupContentSize.height > windowSize.height) {
                         y = anchorBounds.top - popupContentSize.height - spacePx
                     }

                     IntOffset(x, y)
                 }


             }
               return offset
            }
        }}
    }




}

/**
 * Represents the position of the select menu.
 * @property Top the select menu will be placed at the top of the select.
 * @property Bottom the select menu will be placed at the bottom of the select.
 */
enum class SelectPosition{
    Top,
    Bottom
}

/**
 * Represents the colors used by a [Select] in different states.
 * @param containerColor the container color of the [Select]
 * @param contentColor the content color of the [Select]
 * @param borderColor the border color of the [Select]
 * @param focusedContainerColor the focused container color of the [Select]
 * @param focusedContentColor the focused content color of the [Select]
 * @param focusedBorderColor the focused border color of the [Select]
 * @param disabledContainerColor the disabled container color of the [Select]
 * @param disabledContentColor the disabled content color of the [Select]
 * @param disabledBorderColor the disabled border color of the [Select]
 * @param errorContainerColor the error container color of the [Select]
 * @param errorContentColor the error content color of the [Select]
 * @param errorBorderColor the error border color of the [Select]
 *
 * @see SelectDefaults.defaultSelectColors for the default colors used in [Select]
 */
@Immutable
class SelectColors(
    val containerColor : Color,
    val contentColor : Color,
    val borderColor : Color,
    val focusedContainerColor: Color,
    val focusedContentColor : Color,
    val focusedBorderColor : Color,
    val disabledContainerColor : Color,
    val disabledContentColor : Color,
    val disabledBorderColor : Color,
    val errorContainerColor: Color,
    val errorContentColor: Color,
    val errorBorderColor: Color,
) {

    /**
     * Returns copy of [SelectColors] which can be used to override default values .
     */
    fun copy(
         containerColor : Color = this.containerColor,
         contentColor : Color = this.contentColor,
         borderColor : Color = this.borderColor,
         focusedContainerColor: Color = this.focusedContainerColor,
         focusedContentColor : Color = this.focusedContentColor,
         focusedBorderColor : Color = this.focusedBorderColor,
         disabledContainerColor : Color = this.disabledContainerColor,
         disabledContentColor : Color = this.disabledContentColor,
         disabledBorderColor : Color = this.disabledBorderColor,
         errorContainerColor: Color = this.errorContainerColor,
         errorContentColor: Color = this.errorContentColor,
         errorBorderColor: Color = this.errorBorderColor,
    ) = SelectColors(
        containerColor.takeOrElse { this.containerColor },
        contentColor.takeOrElse { this.contentColor },
        borderColor.takeOrElse { this.borderColor },
        focusedContainerColor.takeOrElse { this.focusedContainerColor },
        focusedContentColor.takeOrElse { this.focusedContentColor },
        focusedBorderColor.takeOrElse { this.focusedBorderColor },
        disabledContainerColor.takeOrElse { this.disabledContainerColor },
        disabledContentColor.takeOrElse { this.disabledContentColor },
        disabledBorderColor.takeOrElse { this.disabledBorderColor },
        errorContainerColor.takeOrElse { this.errorContainerColor },
        errorContentColor.takeOrElse { this.errorContentColor },
        errorBorderColor.takeOrElse { this.errorBorderColor }
    )

    /**
     * Determines the container color of the [Select] based on its current state.
     *
     * @param error whether the [Select] is currently in an error state.
     * @param enabled whether the [Select] is enabled and accepts user interaction.
     * @param focused whether the [Select] currently has input focus.
     * @return The appropriate [Color] to apply to the content.
     */
    @Stable
    fun containerColor(error: Boolean, enabled: Boolean, focused: Boolean): Color {
        return when{
            error -> errorContainerColor
            !enabled -> disabledContainerColor
            focused -> focusedContainerColor
            else -> containerColor
        }
    }
    /**
     * Determines the border color of the [Select] based on its current state.
     *
     * @param error whether the [Select] is currently in an error state.
     * @param enabled whether the [Select] is enabled and accepts user interaction.
     * @param focused whether the [Select] currently has input focus.
     * @return The appropriate [Color] to apply to the content.
     */
    @Stable
    fun borderColor(error: Boolean, enabled: Boolean, focused: Boolean): Color {
        return when {
            error -> errorBorderColor
            !enabled -> disabledBorderColor
            focused -> focusedBorderColor
            else -> borderColor
        }
    }

    /**
     * Determines the content color of the [Select] based on its current state.
     *
     * @param error whether the [Select] is currently in an error state.
     * @param enabled whether the [Select] is enabled and accepts user interaction.
     * @param focused whether the [Select] currently has input focus.
     * @return The appropriate [Color] to apply to the content.
     */
    @Stable
    fun contentColor(error: Boolean, enabled: Boolean, focused: Boolean): Color {
        return when {
            error -> errorContentColor
            !enabled -> disabledContentColor
            focused -> focusedContentColor
            else -> contentColor
        }
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is SelectColors) return false
        if (containerColor != other.containerColor) return false
        if (contentColor != other.contentColor) return false
        if (borderColor != other.borderColor) return false
        if (focusedContainerColor != other.focusedContainerColor) return false
        if (focusedContentColor != other.focusedContentColor) return false
        if (focusedBorderColor != other.focusedBorderColor) return false
        if (errorContainerColor != other.errorContainerColor) return false
        if (errorContentColor != other.errorContentColor) return false
        if (errorBorderColor != other.errorBorderColor) return false
        return true
    }


    override fun hashCode(): Int {
        var result = containerColor.hashCode()
        result = 31*result + contentColor.hashCode()
        result = 31*result + borderColor.hashCode()
        result = 31*result + focusedContainerColor.hashCode()
        result = 31*result + focusedContentColor.hashCode()
        result = 31*result + focusedBorderColor.hashCode()
        result = 31*result + errorContainerColor.hashCode()
        result = 31*result + errorContentColor.hashCode()
        result = 31*result + errorBorderColor.hashCode()
        return result
    }



}

/**
 * Represents the colors used by a [SelectGroupItem] in different states.
 * @param unselectedContainerColor the container color when the [SelectGroupItem] is not selected.
 * @param unselectedContentColor the content color when the [SelectGroupItem] is not selected.
 * @param selectedContainerColor the container color when the [SelectGroupItem] is selected.
 * @param selectedContentColor the content color when the [SelectGroupItem] is selected.
 * @param disabledContainerColor the container color when the [SelectGroupItem] is disabled.
 * @param disabledContentColor the content color when the [SelectGroupItem] is disabled.
 * @see [SelectDefaults.defaultSelectItemColors] for the defaults colors used in a select Item .
 */
@Immutable
class SelectItemColors(
    val unselectedContainerColor : Color,
    val unselectedContentColor : Color,
    val selectedContainerColor : Color,
    val selectedContentColor: Color,
    val disabledContainerColor : Color,
    val disabledContentColor : Color
){

    /**
     * @return copy of [SelectItemColors] which can be used to override default values.
     */
    fun copy(
         unselectedContainerColor : Color= this.unselectedContainerColor,
         unselectedContentColor : Color = this.unselectedContentColor,
         selectedContainerColor : Color = this.selectedContainerColor,
         selectedContentColor: Color = this.selectedContentColor,
         disabledContainerColor : Color = this.disabledContainerColor,
         disabledContentColor : Color = this.disabledContentColor,
    ) = SelectItemColors(
        unselectedContainerColor.takeOrElse { this.unselectedContainerColor },
        unselectedContentColor.takeOrElse { this.unselectedContentColor },
        selectedContainerColor.takeOrElse { this.selectedContainerColor } ,
        selectedContentColor.takeOrElse { this.selectedContentColor },
        disabledContainerColor.takeOrElse { this.disabledContainerColor },
        disabledContentColor.takeOrElse { this.disabledContentColor }
    )

    /**
     * Determines the container color of the [SelectGroupItem] based on its current state.
     *
     * @param enabled whether the [SelectGroupItem] is enabled and accepts user interaction.
     * @param selected whether the [SelectGroupItem] currently selected.
     * @return The appropriate [Color] to apply to the content.
     */

    @Stable
    fun containerColor(enabled: Boolean, selected: Boolean): Color {
        return if (!enabled) disabledContainerColor else {
            if (selected) selectedContainerColor else unselectedContainerColor
        }
    }

    /**
     * Determines the content color of the [SelectGroupItem] based on its current state.
     *
     * @param enabled whether the [SelectGroupItem] is enabled and accepts user interaction.
     * @param selected whether the [SelectGroupItem] currently selected.
     * @return The appropriate [Color] to apply to the content.
     */
    @Stable
    fun contentColor(enabled: Boolean, selected: Boolean): Color {
        return if (!enabled) disabledContentColor else {
            if (selected) selectedContentColor else unselectedContentColor
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is SelectItemColors) return false
        if (unselectedContainerColor != other.unselectedContainerColor) return false
        if (unselectedContentColor != other.unselectedContentColor) return false
        if (selectedContainerColor != other.selectedContainerColor) return false
        if (selectedContentColor != other.selectedContentColor) return false
        if (disabledContainerColor != other.disabledContainerColor) return false
        if (disabledContentColor != other.disabledContentColor) return false

        return true
    }


    override fun hashCode(): Int {
        var result = unselectedContainerColor.hashCode()
        result = 31*result + unselectedContentColor.hashCode()
        result = 31*result + selectedContainerColor.hashCode()
        result = 31*result + selectedContentColor.hashCode()
        result = 31*result + disabledContainerColor.hashCode()
        result = 31*result + disabledContentColor.hashCode()
        return result
    }
}

inline fun <T> Modifier.thenIfNotNull(
    value: T?,
    builder: (T) -> Modifier
): Modifier {
    return if (value != null) this.then(builder(value)) else this
}