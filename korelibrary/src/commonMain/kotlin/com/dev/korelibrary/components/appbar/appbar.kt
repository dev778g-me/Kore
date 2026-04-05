package com.dev.korelibrary.components.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.themes.LocalTextStyle

@Composable
fun Appbar(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = AppBarDefaults.defaultTopAppBarPadding,
    minimumAppBarHeight: Dp = AppBarDefaults.defaultAppBarMinimumHeight,
    windowInsets: WindowInsets = WindowInsets.statusBars,
    elevation: Dp = AppBarDefaults.defaultAppBarElevation,
    navigationIcon: (@Composable () -> Unit)? = null,
    navigationIconAlignment: Alignment.Vertical = Alignment.CenterVertically,
    appBarAction: (@Composable RowScope.() -> Unit)? = null,
    appBarAlignment: Alignment.Vertical = Alignment.CenterVertically,
    title: @Composable () -> Unit,
) {

    val layoutDirection = LocalLayoutDirection.current

   val density = LocalDensity.current
    val startPadding =  contentPadding.calculateStartPadding(layoutDirection)
    val endPadding = contentPadding.calculateEndPadding(layoutDirection)
    val topPadding = contentPadding.calculateTopPadding()
    val bottomPadding = contentPadding.calculateBottomPadding()
    val titlePadding = with(density) {
        8.dp.roundToPx()
    }


    Layout(
        modifier = modifier
            .shadow(elevation = elevation)
            .defaultMinSize(
                minHeight = minimumAppBarHeight
            )
            .background(color = KoreTheme.colorScheme.background)
            .windowInsetsPadding(insets = windowInsets),
        content = {
            Box(
                modifier = Modifier.layoutId(AppbarContents.Title)
            ){
                CompositionLocalProvider(
                    value = LocalTextStyle provides KoreTheme.typography.titleLarge
                ) {
                    title()
                }
            }
            navigationIcon?.let {
                Box(
                    modifier = Modifier.layoutId(AppbarContents.NavigationIcons)
                ){
                    it()
                }
            }
            appBarAction?.let {
                  Row(
                      modifier = Modifier.layoutId(AppbarContents.AppBarActions)
                  ) {
                      it()
                  }
            }
        }
    ){  measurables, constraints ->

        val looseConstraints = constraints.copy(minWidth = 0, minHeight = 0)


        val navigationIconPlaceable = measurables.firstOrNull {
            it.layoutId == AppbarContents.NavigationIcons
        }?.measure(looseConstraints)

        val appBarActionPlaceable = measurables.firstOrNull {
            it.layoutId == AppbarContents.AppBarActions
        }?.measure(looseConstraints)

        val titlePlaceableMaxWidth = constraints.maxWidth
            .minus(navigationIconPlaceable?.width ?: 0)
            .minus(appBarActionPlaceable?.width ?: 0)
            .minus(startPadding.roundToPx())
            .minus(endPadding.roundToPx())
            .minus(if (navigationIconPlaceable != null) titlePadding else 0)
            .coerceAtLeast(0)


        val titlePlaceable = measurables.firstOrNull {
            it.layoutId == AppbarContents.Title
        }?.measure(looseConstraints.copy(maxWidth = titlePlaceableMaxWidth))


        val maxHeight = maxOf(
            a = titlePlaceable?.height ?: 0,
            b = navigationIconPlaceable?.height ?: 0,
            c = appBarActionPlaceable?.height ?: 0
        ).plus(topPadding.roundToPx()).plus(bottomPadding.roundToPx())






        layout(height = maxHeight, width =constraints.maxWidth){

            val navigationIconPlaceableX  =  startPadding.roundToPx()
            val contentTop = topPadding.roundToPx()
            val innerHeight = maxHeight - contentTop - bottomPadding.roundToPx()

            // y will change as i will take input from user where to place it vertically



            navigationIconPlaceable?.place(
                x = navigationIconPlaceableX,
                y = topPadding.roundToPx() + navigationIconAlignment.align(size = ( navigationIconPlaceable.height), space = innerHeight )
            )


            val appBarTitleX = startPadding.roundToPx() + (navigationIconPlaceable?.width ?:0) + (if (navigationIconPlaceable != null) titlePadding else 0)

            titlePlaceable?.place(
                x = appBarTitleX,
                y = contentTop + (innerHeight - titlePlaceable.height) /2
            )

            val appBarPlaceableX =  constraints.maxWidth - endPadding.roundToPx() - (appBarActionPlaceable?.width?:0)

            appBarActionPlaceable?.place(
                x = appBarPlaceableX,
                y = contentTop + appBarAlignment.align(
                    size = appBarActionPlaceable.height,
                    space = innerHeight
                )
            )



        }
    }


}


object AppBarDefaults {


    val defaultAppBarElevation : Dp = 4.dp

    val defaultAppBarMinimumHeight : Dp = 56.dp

    val defaultTopAppBarPadding: PaddingValues = PaddingValues(
        horizontal = 12.dp,
        vertical = 4.dp
    )


}













enum class AppbarContents{
    NavigationIcons,
    AppBarActions,
    Title ,
}

