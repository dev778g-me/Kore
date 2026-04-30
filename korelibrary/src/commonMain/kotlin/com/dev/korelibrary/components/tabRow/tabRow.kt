package com.dev.korelibrary.components.tabRow

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.themes.LocalContentColor


/**
 * A Tab row is a horizontal container that allows user to switch between multiple tabs
 * here all Tabs have Equal width by default
 * @param selectedIndex the index of currentSelectedTab [Int]
 * @param modifier the [Modifier] applied to TabRow
 * @param shape the Shape of the TabRow [Shape]
 * @param tabSpacing the horizontal spacing between Tabs
 * @param indicatorColor the color of the tab indicator i.e - which indicates the current selected tab visually [Color]
 * @param indicatorShape the shape of the tab indicator [Shape]
 * @param indicator the Tab indicator [Composable]
 * @param tabs the tabs in teh tab row [Composable]
 */
@Composable
fun TabRow (
    selectedIndex: Int,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = TabRowDefaults.defaultTabRowPaddingValues,
    tabSpacing: Dp = TabRowDefaults.defaultTabSpacing,
    shape: Shape = TabRowDefaults.defaultTabRowShape,
    containerColor: Color = KoreTheme.colorScheme.backGroundVariant,
    indicatorColor: Color = KoreTheme.colorScheme.primary,
    indicatorShape: Shape = TabRowDefaults.defaultIndicatorShape,
    indicator: @Composable (tabPositions: List<TabPosition>) -> Unit = { tabPositions ->
        TabIndicator(tabPositions[selectedIndex], indicatorColor = indicatorColor, shape = indicatorShape)
    },
    tabs: @Composable () -> Unit
){

    SubcomposeLayout(
        modifier = modifier
            .selectableGroup()
            .clip(shape)
            .background(containerColor, shape = shape)
            .padding(contentPadding)
    ){ constraints ->
        val tabMeasurables = subcompose(slotId = TabRowItem.Tab, content = tabs)

        val spacingPx = tabSpacing.roundToPx()
        val tabCount = tabMeasurables.size
        val totalSpacingPx = if (tabCount > 1) spacingPx * (tabCount - 1) else 0


        val tabWidth = if (tabCount>0) (constraints.maxWidth- totalSpacingPx)  / tabCount else {0}

        val exactWidthConstraints = constraints.copy(
            minWidth = tabWidth,
            maxWidth = tabWidth,
            minHeight = 0
        )

        val tabPlaceable = tabMeasurables.map { measurables ->
            measurables.measure(exactWidthConstraints)
        }

        val maxHeight = tabPlaceable.maxOfOrNull { it.height } ?:0

        val tabPosition = List(tabCount) {
            val leftPx = it * (tabWidth + spacingPx)
            TabPosition(
                left = leftPx.toDp(),
                width = tabWidth.toDp()
            )
        }



        val indicatorPlaceable = subcompose(slotId = TabRowItem.Indicator){
            indicator(tabPosition)
        }.map { measurable ->
            measurable.measure(
                constraints = Constraints.fixed(
                    width = constraints.maxWidth ,
                    height = maxHeight
                )
            )
        }


            layout(constraints.maxWidth, maxHeight){
                indicatorPlaceable.forEach {
                    it.placeRelative(x = 0, y = 0)
                }

                var x = 0
                tabPlaceable.forEach {  placeable ->
                    //x = placeable.width + tabSpacing.roundToPx()
                    placeable.placeRelative(
                        x = x, y = 0
                    )
                    x += placeable.width + spacingPx

                }

            }
    }

}


/**
 * A ScrollableTabRow is a horizontal scrollable container that allows user to switch between multiple tabs
 * here all Tabs have widths according to the content of the tabs
 * @param selectedIndex the index of currentSelectedTab [Int]
 * @param modifier the [Modifier] applied to TabRow
 * @param shape the Shape of the TabRow [Shape]
 * @param tabSpacing the horizontal spacing between Tabs
 * @param indicatorColor the color of the tab indicator i.e - which indicates the current selected tab visually [Color]
 * @param indicatorShape the shape of the tab indicator [Shape]
 * @param indicator the Tab indicator [Composable]
 * @param tabs the tabs in teh tab row [Composable]
 */

@Composable
fun ScrollableTabRow(
    selectedIndex: Int,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = TabRowDefaults.defaultTabRowPaddingValues,
    tabSpacing: Dp = TabRowDefaults.defaultTabSpacing,
    shape: Shape = TabRowDefaults.defaultTabRowShape,
    containerColor: Color = KoreTheme.colorScheme.backGroundVariant,
    indicatorShape: Shape = TabRowDefaults.defaultIndicatorShape,
    indicatorColor: Color = KoreTheme.colorScheme.primary,
    indicator: @Composable (tabPositions: List<TabPosition>) -> Unit = { tabPositions ->
        TabIndicator(tabPositions[selectedIndex], indicatorColor = indicatorColor, shape = indicatorShape)
    },
    tabs: @Composable () -> Unit
) {

    val density = LocalDensity.current
    val scrollState = rememberScrollState()
    var newPositions by remember { mutableStateOf(listOf<TabPosition>()) }

    LaunchedEffect(selectedIndex, newPositions) {
        if (newPositions.isNotEmpty() && selectedIndex in newPositions.indices) {
            // the selected tab
            val targetPos = newPositions[selectedIndex]
            val viewportWidth = scrollState.viewportSize
            // centering the tab
            val scrollOffset = with(density) {
                (targetPos.left + targetPos.width / 2).roundToPx() - viewportWidth / 2
            }
            scrollState.animateScrollTo(scrollOffset.coerceAtLeast(0))
        }
    }


        SubcomposeLayout(
            modifier = modifier
                .selectableGroup()
                .background(
                    color = containerColor,
                    shape = shape
                )
                .horizontalScroll(
                    state = scrollState
                )
                .padding(contentPadding)
        ) { constraints ->

            val looseConstraints = constraints.copy(minWidth = 0, minHeight = 0)

            val spacingPx = tabSpacing.roundToPx()

            val tabMeasurables = subcompose(slotId = TabRowItem.Tab, content = tabs)


            val tabPlaceable = tabMeasurables.map {
                it.measure(looseConstraints)
            }

            var currentLeft = 0


            val tabPosition = tabPlaceable
                .map { placeable ->
                    val position =
                        TabPosition(left = currentLeft.toDp(), width = placeable.width.toDp())
                    currentLeft += placeable.width + spacingPx
                    position
                }

            if (tabPosition != newPositions) {
                newPositions = tabPosition
            }


            val totalWidth =
                tabPlaceable.mapIndexed { index, placeable ->
                    placeable.width + if (index == tabPlaceable.lastIndex) 0 else spacingPx
                }.sum()
            val maxHeight = tabPlaceable.maxOfOrNull { it.height } ?: 0

            val indicatorPlaceable = subcompose(slotId = TabRowItem.Indicator) {
                indicator(tabPosition)
            }.map {
                it.measure(
                    constraints = Constraints.fixed(
                        width = totalWidth,
                        height = maxHeight
                    )
                )
            }



            layout(width = totalWidth, height = maxHeight) {
                indicatorPlaceable.forEach { placeable ->
                    placeable.placeRelative(x = 0, y = 0)
                }

                var x = 0
                tabPlaceable.forEach { placeable ->
                    placeable.placeRelative(x = x, y = 0)
                    x += placeable.width + spacingPx
                }

         }

     }
}


/**
 * Tab indicator is a composable that represents current selected tab visually
 * @param tabPosition the position of the tab [TabPosition]
 * @param modifier the [Modifier] applied to TabIndicator
 * @param indicatorColor the color of the indicator [Color]
 * @param shape the shape of the Indicator [Shape]
 */
@Composable
 fun TabIndicator(
    tabPosition: TabPosition,
    modifier: Modifier = Modifier,
    indicatorColor: Color,
    shape: Shape,
) {
    val offsetAnim by animateDpAsState(
        targetValue = tabPosition.left,

        label = "indicator_offset"
    )
    val widthAnim by animateDpAsState(
        targetValue = tabPosition.width,
        label = "indicator_width"
    )



    Box(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = offsetAnim)
                .width(widthAnim)
                .fillMaxHeight()
                .background(
                    color = indicatorColor,
                    shape = shape
                )
        )
    }
}

/**
 * A Tab is an individual interactive element within a Tab Row that represents a distinct, selectable panel of content or a specific view.
 * @param isSelected the boolean state which decides tab selected nature [Boolean]
 * @param onClick the callback to be invoked when this tab is clicked
 * @param modifier the [Modifier] applied on the tab
 * @param enabled the boolean state which decides tab enabled nature [Boolean]
 * @param contentPadding the contentPadding values of the tab [PaddingValues]
 * @param iconPadding the iconPadding values of the tab [PaddingValues]
 * @param shape the shape of the Tab
 * @param selectedContentColor the selectedContentColor of the tab i.e. color of the content when tab is selected [Color]
 * @param unselectedContentColor the unselectedContentColor of the tab i.e. color of the content when tab is not selected [Color]
 * @param icon the icon of the tab [Composable]
 * @param content the content of the tab [Composable]
 */

@Composable
fun Tab(
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = TabRowDefaults.defaultTabPadding,
    iconPadding: PaddingValues = TabRowDefaults.defaultIconPaddingValues,
    shape: Shape = TabRowDefaults.defaultTabShape,
    selectedContentColor: Color = KoreTheme.colorScheme.onPrimary,
    unselectedContentColor: Color = KoreTheme.colorScheme.onBackGround,
    icon: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val contentColor by animateColorAsState(
        targetValue = if (isSelected) selectedContentColor else unselectedContentColor
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .selectable(
                enabled = enabled,
                selected = isSelected,
                role = Role.Tab,
                onClick = onClick
            )
            .padding(contentPadding),
        contentAlignment = Alignment.Center
    ) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                icon?.let {
                    Box(modifier = Modifier.padding(iconPadding)) { it() }
                }
                content()
            }
        }
    }
}


/**
 * The content of the tab row
 */

internal enum class TabRowItem{
    Tab,
    Indicator
}


/**
 * TabRowDefaults defines Default values for tab & tab rows
 * @property defaultTabRowShape the default tabRowShape for tabRow[Shape]
 * @property defaultTabRowPaddingValues the default padding values for the tab row [PaddingValues]
 * @property defaultTabShape the default shape for the tab [Shape]
 * @property defaultIndicatorShape the default shape for the tab indicator [Shape]
 * @property defaultTabSpacing the default tab spacing [Dp]
 * @property defaultIconPaddingValues the default icon padding values [PaddingValues]
 * @property defaultTabPadding the default tab padding values [PaddingValues]
 */
object TabRowDefaults{




    val defaultTabRowShape : Shape
        @Composable get() = KoreTheme.shapes.md
    val defaultTabRowPaddingValues = PaddingValues(
        all = 4.dp
    )
    val defaultTabShape : Shape
        @Composable get() = KoreTheme.shapes.sm
    val defaultIndicatorShape : Shape
        @Composable get() = KoreTheme.shapes.sm


    val defaultTabSpacing = 2.dp


    val  defaultIconPaddingValues : PaddingValues = PaddingValues(
        end = 4.dp
    )

    val defaultTabPadding : PaddingValues = PaddingValues(
        horizontal = 12.dp,
        vertical = 4.dp
    )






}

/**
 * the tab position of the tab
 * @param left starting of the tab
 * @param width ending of the tab
 */
@Immutable
data class TabPosition(val left: Dp, val width: Dp)






