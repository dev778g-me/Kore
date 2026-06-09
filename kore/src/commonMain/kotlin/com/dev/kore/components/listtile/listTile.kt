package com.dev.kore.components.listtile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.LocalContentColor
import com.dev.kore.themes.LocalTextStyle


/**
 * A list tile is a single row in a list that shows one piece of information or one option.
 * It usually includes a label (text) and sometimes an icon or action, and all items look similar so they’re easy to scan and use.
 * @param title the title of the list Item [Composable]
 * @param modifier the [Modifier] applied to the list item
 * @param onClick called when user clicks the tile. if null the tile will not be interactable and will not have ripple effects
 * @param leading the leading content (often an image or icon) of the list tile which will be placed before the title in the row [Composable]
 * @param leadingAlignment the vertical alignment of the leading content with respect to the row
 * @param overline the overline content . it will appear over the title of the list tile [Composable]
 * @param subtitle the subtitle of the list tile . it will appear below the title
 * @param trailing the trailing content (often a switch or icon button) of the list tile which will be placed after the title in the row [Composable]
 * @param trailingAlignment the vertical alignment of the trailing content with respect to the row
 * @param shape the shape of the list tile [Shape]
 * @param colors the colors of the List tile . to change color use [ListTileDefaults.defaultListTileColors]
 * @param contentPaddingValues the padding values of the all content from the container of the list tile
 */

@Composable
fun ListTile(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    leading: (@Composable () -> Unit)? = null,
    leadingAlignment: Alignment.Vertical = ListTileDefaults.defaultLeadingAlignment,
    overline: (@Composable () -> Unit)? = null,
    subtitle: (@Composable () -> Unit)? = null,
    trailing: (@Composable () -> Unit)? = null,
    trailingAlignment: Alignment.Vertical = ListTileDefaults.defaultTrailingAlignment,
    shape: Shape = ListTileDefaults.defaultListTileShape,
    colors: ListTileColors = ListTileDefaults.defaultListTileColors(),
    contentPaddingValues: PaddingValues = ListTileDefaults.defaultListItemPaddingValues
) {
    val layoutDirection = LocalLayoutDirection.current
    val startPadding = contentPaddingValues.calculateStartPadding(layoutDirection)
    val endPadding = contentPaddingValues.calculateEndPadding(layoutDirection)
    val topPadding = contentPaddingValues.calculateTopPadding()
    val bottomPadding = contentPaddingValues.calculateBottomPadding()
    val itemSpacing = ListTileDefaults.itemSpacing
    val textSpacing = ListTileDefaults.textItemSpacing
    Layout(
        modifier = modifier
            .clip(shape)
            .background(
                color = colors.containerColor,
                shape = shape
            ).then(if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier)

            ,
        content = {
            Box(Modifier.layoutId(ListTileContents.Title)) {
                CompositionLocalProvider(
                    values = arrayOf(
                        LocalTextStyle provides KoreTheme.typography.title2,
                        LocalContentColor provides colors.titleContentColor
                    )
                ) {
                    title()
                }
            }
            subtitle?.let { Box(Modifier.layoutId(ListTileContents.Subtitle)) {
                CompositionLocalProvider(
                    values = arrayOf(
                        LocalTextStyle provides KoreTheme.typography.label1,
                        LocalContentColor provides colors.subTitleContentColor
                    )
                ) {
                    it()
                }
            }
            }
            leading?.let {
                Box(Modifier.layoutId(ListTileContents.Leading)) {
                    CompositionLocalProvider(
                        value = LocalContentColor provides colors.leadingContentColor
                    ) { it() }
                }
            }
            trailing?.let {
                Box(Modifier.layoutId(ListTileContents.Trailing)) {
                    CompositionLocalProvider(
                        value = LocalContentColor provides colors.trailingContentColor
                    ) {
                        it()
                    }
                }
            }
            overline?.let {
                Box(Modifier.layoutId(ListTileContents.Overline)) {
                    CompositionLocalProvider(
                        values = arrayOf(
                            LocalTextStyle provides KoreTheme.typography.label3.copy(
                                fontWeight = FontWeight.SemiBold
                            ),
                            LocalContentColor provides colors.overlineContentColor
                        )
                    ) {
                        it()
                    }
                }
            }
        }

    ) { measurables, constraints ->

       val  leadingPlaceable = measurables
           .firstOrNull { it.layoutId == ListTileContents.Leading }
           ?.measure(constraints = constraints.copy(minWidth = 0, minHeight = 0))

       val trailingPlaceable = measurables
           .firstOrNull {
               it.layoutId == ListTileContents.Trailing
           }?.measure(constraints = constraints.copy(minHeight = 0, minWidth = 0))

        val resolvedContentWidth = constraints.maxWidth
            .minus(leadingPlaceable?.width ?: 0)
            .minus(trailingPlaceable?.width ?: 0)
            .minus(startPadding.roundToPx())
            .minus(endPadding.roundToPx())
            .minus(if (leadingPlaceable != null) itemSpacing.roundToPx() else 0)
            .minus(if (trailingPlaceable != null) itemSpacing.roundToPx() else 0)
            .coerceAtLeast(0)

       val  textColumnWidth = resolvedContentWidth.coerceIn(0, constraints.maxWidth)

        // the column
        val titlePlaceable = measurables.firstOrNull {
            it.layoutId == ListTileContents.Title
        }?.measure(constraints = constraints.copy(minWidth = 0 , maxWidth = textColumnWidth))


        val subTitlePlaceable = measurables.firstOrNull {
            it.layoutId == ListTileContents.Subtitle
        }?.measure(constraints = constraints.copy(minWidth = 0, maxWidth = textColumnWidth))

        val overlinePlaceable = measurables.firstOrNull {
            it.layoutId == ListTileContents.Overline
        }?.measure(constraints = constraints.copy(minWidth = 0, maxWidth = textColumnWidth))

        val overlineTitleSpacing = if (overlinePlaceable !=null) textSpacing.roundToPx() else 0
        val titleSubtitleSpacing = if (subTitlePlaceable != null) textSpacing.roundToPx() else 0

        val textColumnHeight =
            (overlinePlaceable?.height ?: 0) + overlineTitleSpacing +
                    (titlePlaceable?.height ?: 0) + titleSubtitleSpacing +
                    (subTitlePlaceable?.height ?: 0)

        val maxHeight = maxOf(
            a = leadingPlaceable?.height ?:0,
            b = trailingPlaceable?.height ?:0,
            c = textColumnHeight,
        ).plus(topPadding.roundToPx()).plus(bottomPadding.roundToPx())




        layout(height = maxHeight, width = constraints.maxWidth) {

            val leadingX = startPadding.roundToPx()
            leadingPlaceable?.place(
                x = leadingX,
                y = topPadding.roundToPx() + leadingAlignment.align(
                    size = leadingPlaceable.height,
                    space = maxHeight - (topPadding.roundToPx() + bottomPadding.roundToPx())
                )
            )


            // start of column
            val textStartX = leadingX +
                    (leadingPlaceable?.width ?: 0) +
                    (if (leadingPlaceable != null) itemSpacing.roundToPx() else 0)


           // y coordinates
            var currentY = topPadding.roundToPx() +
                    (maxHeight - topPadding.roundToPx() - bottomPadding.roundToPx() - textColumnHeight) / 2


            // overline
            overlinePlaceable?.place(
                x = textStartX,
                y = currentY
            )

            currentY += (overlinePlaceable?.height?:0) + overlineTitleSpacing
            // title
            titlePlaceable?.place(
                x = textStartX,
                y = currentY
            )

            currentY += (titlePlaceable?.height ?: 0) + titleSubtitleSpacing

            subTitlePlaceable?.place(
                x = textStartX,
                y = currentY
            )



            trailingPlaceable?.place(
                x = (constraints.maxWidth - endPadding.roundToPx()) - trailingPlaceable.width,
                y =  topPadding.roundToPx().plus(
                    trailingAlignment.align(
                        size = trailingPlaceable.height,
                        space = maxHeight.minus(topPadding.roundToPx() + bottomPadding.roundToPx())
                    )
                )
            )


        }
    }

}


/**
 * ListTileDefaults defines the defaults values for listTile
 * @property defaultListTileColors this defines all the default colors for the listTile
 * @property defaultTrailingAlignment the default alignment for trailing content
 * @property defaultLeadingAlignment the default alignment for leading content
 * @property defaultListItemPaddingValues this defines the content padding values for the List tile
 * @property defaultListTileShape defines the default shape for list tile
 */
object ListTileDefaults{

    @Composable
    fun defaultListTileColors(
        containerColor: Color= KoreTheme.colorScheme.surface,
        titleContentColor: Color= KoreTheme.colorScheme.onBackGround,
        subTitleContentColor: Color= KoreTheme.colorScheme.onBackGroundVariant,
        overlineContentColor : Color= KoreTheme.colorScheme.onBackGroundVariant,
        leadingContentColor : Color= KoreTheme.colorScheme.onSurface,
        trailingContentColor : Color= KoreTheme.colorScheme.onSurface,
    ) = ListTileColors(
        containerColor = containerColor,
        titleContentColor = titleContentColor,
        subTitleContentColor = subTitleContentColor,
        overlineContentColor = overlineContentColor,
        leadingContentColor = leadingContentColor,
        trailingContentColor = trailingContentColor
    )


    val defaultTrailingAlignment : Alignment.Vertical = Alignment.CenterVertically

    val defaultLeadingAlignment : Alignment.Vertical = Alignment.CenterVertically




   val defaultListItemPaddingValues : PaddingValues
       @Composable get() = PaddingValues(
           horizontal = KoreTheme.sizes.md,
           vertical = KoreTheme.sizes.sm
       )

   val defaultListTileShape  : Shape
       @Composable get() = KoreTheme.shapes.md




    val textItemSpacing : Dp
        @Composable get ()= KoreTheme.sizes.xxs




    val itemSpacing : Dp
        @Composable get ()= KoreTheme.sizes.xs

}


/**
 * all contents of list tile
 */
internal enum class ListTileContents{
    Leading,
    Title,
    Subtitle,
    Overline,
    Trailing
}


/**
 * defines colors for list tile
 */
@Immutable
data class ListTileColors(
    val containerColor : Color,
    val titleContentColor : Color,
    val subTitleContentColor : Color,
    val overlineContentColor : Color,
    val leadingContentColor : Color,
    val trailingContentColor : Color,

)







