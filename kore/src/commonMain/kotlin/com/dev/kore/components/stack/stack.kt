package com.dev.kore.components.stack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.dev.kore.themes.KoreTheme

/**
 * A layout component that arranges its children in a vertical sequence with standardized spacing.
 * @param modifier The [Modifier] applied to the entire vertical layout.
 * @param spacing The vertical space applied between each child component. Defaults to the extra-small size from [KoreTheme].
 * @param horizontalAlignment The horizontal alignment of the children within the stack's total width.
 * @param content The composable content to be displayed sequentially inside the stack.
 */
@Composable
fun VerticalStack(
    modifier: Modifier = Modifier,
    spacing: Dp = KoreTheme.sizes.xs,
    verticalAlignment: Alignment.Vertical = StackDefaults.defaultVerticalAlignment,
    horizontalAlignment: Alignment.Horizontal = StackDefaults.defaultHorizontalAlignment,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(spacing,verticalAlignment),
        horizontalAlignment = horizontalAlignment,
        content = content
    )
}

/**
 * A layout component that arranges its children in a horizontal sequence with standardized spacing.
 * @param modifier The [Modifier] applied to the entire horizontal layout.
 * @param spacing The horizontal space applied between each child component. Defaults to the extra-small size from [KoreTheme].
 * @param verticalAlignment The vertical alignment of the children within the stack's total height.
 * @param content The composable content to be displayed sequentially inside the stack.
 */
@Composable
fun HorizontalStack(
    modifier: Modifier = Modifier,
    spacing: Dp = KoreTheme.sizes.xs,
    horizontalAlignment: Alignment.Horizontal = StackDefaults.defaultHorizontalAlignment,
    verticalAlignment: Alignment.Vertical = StackDefaults.defaultVerticalAlignment,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spacing,horizontalAlignment),
        verticalAlignment = verticalAlignment,
        content = content
    )
}

/**
 * Defines the default configurations and alignments used by [VerticalStack] and [HorizontalStack].
 */
object StackDefaults {
    val defaultHorizontalAlignment: Alignment.Horizontal =
        Alignment.CenterHorizontally

    val defaultVerticalAlignment: Alignment.Vertical =
        Alignment.CenterVertically
}