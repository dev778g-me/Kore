package com.dev.kore.components.segmentedButton

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.LocalContentColor
import com.dev.kore.themes.LocalTextStyle

/**
 * Scope for the children of [SingleChoiceSegmentedButtonRow].
 * Extends [RowScope] to provide standard layout modifiers such as [RowScope.weight].
 */
interface SingleChoiceSegmentedButtonScope : RowScope

/**
 * Scope for the children of [MultiChoiceSegmentedButtonRow].
 * Extends [RowScope] to provide standard layout modifiers such as [RowScope.weight].
 */
interface MultiChoiceSegmentedButtonScope : RowScope

/**
 * Internal implementation of [MultiChoiceSegmentedButtonScope] that delegates
 * all [RowScope] properties and functions to the provided [scope].
 *
 * @param scope the underlying [RowScope] provided by the parent layout.
 */
private class MultiChoiceSegmentedButtonScopeWrapper(scope : RowScope) :
    MultiChoiceSegmentedButtonScope, RowScope by scope

/**
 * Internal implementation of [SingleChoiceSegmentedButtonScope] that delegates
 * all [RowScope] properties and functions to the provided [scope].
 *
 * @param scope the underlying [RowScope] provided by the parent layout.
 */
private class SingleChoiceSegmentedButtonScopeWrapper(scope: RowScope) :
    SingleChoiceSegmentedButtonScope, RowScope by scope
/**
 * SegmentedButtonItem is a selectable component used inside a [SingleChoiceSegmentedButtonRow].
 * It represents a single, mutually exclusive option within the segmented control.
 *
 * @param selected whether this item is currently selected.
 * @param modifier the [Modifier] to be applied to this item.
 * @param onSelected callback to be invoked when this item is clicked.
 * @param index the index of this item within the row, used to calculate its default shape.
 * @param itemCount the total number of items in the row.
 * @param weight the proportional width of this item relative to others.
 * @param shape the [Shape] of this item. If null, a default shape is applied based on its [index].
 * @param enabled controls the enabled state of this item. When false, the item will not respond to user input.
 * @param colors the [SegmentedButtonColors] used to resolve the background and content colors in different states, use [SegmentedButtonDefaults.defaultSegmentedButtonColors] to customize.
 * @param interactionSource the [MutableInteractionSource] representing the stream of interactions for this item.
 * @param trailingContent the optional trailing content to be displayed after the main content.
 * @param leadingContent the optional leading content to be displayed before the main content.
 * @param content the main content of this item, typically a text component.
 */
@Composable
fun SingleChoiceSegmentedButtonScope.SegmentedButtonItem(
    selected: Boolean,
    modifier: Modifier = Modifier,
    onSelected: () -> Unit,
    index: Int,
    itemCount: Int,
    weight: Float = 1f,
    shape: Shape?  = null,
    enabled: Boolean = true,
    colors: SegmentedButtonColors = SegmentedButtonDefaults.defaultSegmentedButtonColors(),
    interactionSource: MutableInteractionSource? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    leadingContent: (@Composable () -> Unit)?= null,
    content: @Composable () -> Unit
) {

    val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }


    val resolvedShape = shape ?: SegmentedButtonDefaults.itemShape(index, itemCount)


    val containerColor by animateColorAsState(
        targetValue = colors.containerColor(selected= selected, enabled = enabled)
    )

    val contentColor by animateColorAsState(
        targetValue = colors.contentColor(selected = selected , enabled = enabled)
    )



    val selectableModifier = Modifier.selectable(
        selected = selected,
        onClick = onSelected,
        enabled = enabled,
        role = Role.RadioButton,
        interactionSource = resolvedInteractionSource,
    )


    Box(
        modifier = modifier
            .weight(weight)
            .defaultMinSize(minHeight = 40.dp)
            .clip(resolvedShape)
            .background(color = containerColor, shape = resolvedShape)
            .then(selectableModifier).padding(
                horizontal = 12.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        CompositionLocalProvider(
            LocalContentColor provides contentColor,
            LocalTextStyle provides KoreTheme.typography.title3
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                leadingContent?.let {
                    it()
                }


                content()

                trailingContent?.let {
                    it()
                }
            }
        }
    }

}
/**
 * SegmentedButtonItem is a toggleable component used inside a [MultiChoiceSegmentedButtonRow].
 * It represents an independent option within the segmented control, allowing multiple items to be selected at once.
 *
 * @param selected whether this item is currently selected.
 * @param modifier the [Modifier] to be applied to this item.
 * @param onSelected callback to be invoked when this item is clicked, providing the new selection state as a [Boolean].
 * @param index the index of this item within the row, used to calculate its default shape.
 * @param itemCount the total number of items in the row.
 * @param weight the proportional width of this item relative to others.
 * @param shape the [Shape] of this item. If null, a default shape is applied based on its [index].
 * @param enabled controls the enabled state of this item. When false, the item will not respond to user input.
 * @param colors the [SegmentedButtonColors] used to resolve the background and content colors in different states,use [SegmentedButtonDefaults.defaultSegmentedButtonColors] to customize..
 * @param interactionSource the [MutableInteractionSource] representing the stream of interactions for this item.
 * @param trailingContent the optional trailing content to be displayed after the main content.
 * @param leadingContent the optional leading content to be displayed before the main content.
 * @param content the main content of this item, typically a text component.
 */
@Composable
fun MultiChoiceSegmentedButtonScope.SegmentedButtonItem(
    selected: Boolean,
    modifier: Modifier = Modifier,
    onSelected: (Boolean) -> Unit,
    index: Int,
    itemCount: Int,
    weight : Float = 1f,
    shape: Shape?  = null,
    enabled: Boolean = true,
    colors: SegmentedButtonColors = SegmentedButtonDefaults.defaultSegmentedButtonColors(),
    interactionSource: MutableInteractionSource? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    leadingContent: (@Composable () -> Unit)?= null,
    content: @Composable () -> Unit
) {

    val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }


    val resolvedShape = shape ?: SegmentedButtonDefaults.itemShape(index, itemCount)


    val containerColor by animateColorAsState(
        targetValue = colors.containerColor(selected= selected, enabled = enabled)
    )

    val contentColor by animateColorAsState(
        targetValue = colors.contentColor(selected = selected , enabled = enabled)
    )



    val toggleableModifier = Modifier.toggleable(
        value = selected,
        onValueChange = onSelected,
        enabled = enabled,
        role = Role.Checkbox,
        interactionSource = resolvedInteractionSource
    )

    Box(
        modifier = modifier
            .weight(weight)
            .defaultMinSize(minHeight = 40.dp)
            .clip(resolvedShape)
            .background(color = containerColor, shape = resolvedShape)
            .then(toggleableModifier).padding(
                horizontal = 12.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        CompositionLocalProvider(
            LocalContentColor provides contentColor,
            LocalTextStyle provides KoreTheme.typography.title3
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                leadingContent?.let {
                    it()
                }


                content()

                trailingContent?.let {
                    it()
                }
            }
        }
    }

}

/**
 * SingleChoiceSegmentedButtonRow is a layout that positions and arranges [SegmentedButtonItem] horizontally.
 * each [SegmentedButtonItem] acquires an equal weight. it is used to display a single choice between multiple options, for correct semantics.
 * @param modifier the [Modifier] to be applied to the layout.
 * @param shape the [Shape] of the container.
 * @param containerColor the background [Color] of the container .
 * @param contentPadding the [PaddingValues] of the container from the content.
 * @param spacing the spacing between the [SegmentedButtonItem]s.
 * @param horizontalAlignment the alignment of the [SegmentedButtonItem]s horizontally.
 * @param content the content of the layout [SingleChoiceSegmentedButtonScope].
 */
@Composable
fun SingleChoiceSegmentedButtonRow(
    modifier: Modifier = Modifier,
    shape: Shape = SegmentedButtonDefaults.defaultSegmentedRowShape,
    containerColor: Color = KoreTheme.colorScheme.surface,
    contentPadding: PaddingValues = PaddingValues(8.dp),
    spacing: Dp = 2.dp,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable SingleChoiceSegmentedButtonScope.() -> Unit
) {
    Row(
        modifier = modifier.selectableGroup()
            .width(IntrinsicSize.Max).background(containerColor, shape).padding(contentPadding),
        horizontalArrangement = Arrangement.spacedBy(spacing, horizontalAlignment),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val scope = SingleChoiceSegmentedButtonScopeWrapper(this)
        scope.content()
    }

}

/**
 * MultiChoiceSegmentedButtonRow is a layout that positions and arranges [SegmentedButtonItem] horizontally.
 * each [SegmentedButtonItem] acquires an equal weight. it is used to display multiple choices between multiple options, for correct semantics.
 * @param modifier the [Modifier] to be applied to the layout.
 * @param shape the [Shape] of the container.
 * @param containerColor the background [Color] of the container .
 * @param contentPadding the [PaddingValues] of the container from the content.
 * @param spacing the spacing between the [SegmentedButtonItem]s.
 * @param horizontalAlignment the alignment of the [SegmentedButtonItem]s horizontally.
 * @param content the content of the layout [MultiChoiceSegmentedButtonScope].
 */
@Composable
fun MultiChoiceSegmentedButtonRow(
    modifier: Modifier = Modifier,
    shape: Shape = SegmentedButtonDefaults.defaultSegmentedRowShape,
    containerColor: Color = KoreTheme.colorScheme.surface,
    contentPadding: PaddingValues = PaddingValues(8.dp),
    spacing: Dp = 2.dp,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable MultiChoiceSegmentedButtonScope.() -> Unit
) {
    Row(
        modifier = modifier.selectableGroup()
            .width(IntrinsicSize.Max).background(containerColor, shape).padding(contentPadding),
        horizontalArrangement = Arrangement.spacedBy(spacing, horizontalAlignment),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val scope = MultiChoiceSegmentedButtonScopeWrapper(this)
        scope.content()
    }
}

/**
 * Contains default values, shapes, and utility functions used by segmented button components.
 */
object SegmentedButtonDefaults{

    /**
     * The default shape applied to the first item in a segmented button row.
     */
    val segmentedStartShape: Shape = RoundedCornerShape(topStart = 24.dp, bottomStart = 24.dp, topEnd = 4.dp, bottomEnd = 4.dp)

    /**
     * The default shape applied to middle items in a segmented button row.
     */
    val segmentedMiddleShape: Shape = RoundedCornerShape(4.dp)

    /**
     * The default shape applied to the last item in a segmented button row.
     */
    val segmentedEndShape: Shape = RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp, topEnd = 24.dp, bottomEnd = 24.dp)

    /**
     * The default shape applied to the outer container of a segmented button row.
     */
    val defaultSegmentedRowShape : Shape = CircleShape

    /**
     * Creates a [SegmentedButtonColors] instance that represents the default colors used in a segmented button.
     *
     * @param unselectedContainerColor the container color of an unselected item.
     * @param selectedContainerColor the container color of a selected item.
     * @param unselectedContentColor the content color of an unselected item.
     * @param selectedContentColor the content color of a selected item.
     * @param disabledContainerColor the container color when the item is disabled.
     * @param disabledContentColor the content color when the item is disabled.
     * @return a [SegmentedButtonColors] instance containing the resolved colors.
     */
    @Composable
    fun defaultSegmentedButtonColors(
        unselectedContainerColor : Color = KoreTheme.colorScheme.backGroundVariant ,
        selectedContainerColor : Color = KoreTheme.colorScheme.primary,
        unselectedContentColor : Color = KoreTheme.colorScheme.onBackGround,
        selectedContentColor : Color = KoreTheme.colorScheme.onPrimary,
        disabledContainerColor : Color = KoreTheme.colorScheme.disabled,
        disabledContentColor : Color = KoreTheme.colorScheme.onDisabled,
    ) = SegmentedButtonColors(
        unselectedContainerColor = unselectedContainerColor,
        selectedContainerColor = selectedContainerColor,
        unselectedContentColor = unselectedContentColor,
        selectedContentColor = selectedContentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    /**
     * Resolves and returns the appropriate [Shape] for a segmented button item based on its position.
     *
     * @param index the position of the item within the row.
     * @param itemCount the total number of items in the row.
     * @return the resolved [Shape] for the item at the given index.
     */
    fun itemShape(index: Int, itemCount: Int): Shape {
        return when (index) {
            0 -> segmentedStartShape
            itemCount - 1 -> segmentedEndShape
            else -> segmentedMiddleShape
        }
    }
}


@Immutable
data class SegmentedButtonColors(
    val unselectedContainerColor : Color ,
    val selectedContainerColor : Color,
    val unselectedContentColor : Color,
    val selectedContentColor : Color,
    val disabledContainerColor : Color,
    val disabledContentColor : Color,
)


fun SegmentedButtonColors.containerColor(selected: Boolean, enabled: Boolean) : Color {
  return  if (!enabled) disabledContainerColor else {
        if (selected) selectedContainerColor else unselectedContainerColor
    }
}

fun SegmentedButtonColors.contentColor(selected: Boolean, enabled: Boolean) : Color{
    return if (!enabled) disabledContentColor else {
        if (selected) selectedContentColor else unselectedContentColor
    }
}