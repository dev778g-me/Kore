/*
 * Portions adapted from Scaffold.kt in AndroidX Compose Material:
 * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:compose/material3/material3/src/commonMain/kotlin/androidx/compose/material3/Scaffold.kt
 * Copyright The Android Open Source Project, licensed under the Apache License 2.0
 */

package com.dev.kore.components.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.MutableWindowInsets
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.onConsumedWindowInsetsChanged
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.LocalContentColor
import com.dev.kore.themes.LocalKoreColorScheme


internal  val WindowInsets.Companion.systemBarsForVisualComponents: WindowInsets
    @Composable get() = systemBars

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Scaffold(
    modifier: Modifier = Modifier,
    appBar: @Composable () -> Unit = {},
    navigationBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonAlignment: Alignment.Horizontal = Alignment.End,
    windowInsets: WindowInsets = WindowInsets.systemBarsForVisualComponents,
    containerColor: Color = LocalKoreColorScheme.current.background,
    contentColor: Color = LocalKoreColorScheme.current.onBackGround,
    content: @Composable (PaddingValues) -> Unit
) {
    val safeInsets = remember(windowInsets) { MutableWindowInsets(windowInsets) }
    CompositionLocalProvider(
        LocalContentColor provides contentColor
    ) {
        Box(
            modifier = modifier.onConsumedWindowInsetsChanged {
                safeInsets.insets = windowInsets.exclude(it)
            }.background(
                color = containerColor
            )
        ) {
            ScaffoldImpl(
                appBar = appBar,
                navigationBar = navigationBar,
                floatingActionButton = floatingActionButton,
                floatingActionButtonAlignment = floatingActionButtonAlignment,
                windowInsets = windowInsets,
                content = content
            )
        }

    }
}

@Composable
internal fun ScaffoldImpl(
    appBar: @Composable () -> Unit = {},
    navigationBar: @Composable () -> Unit = {},
    floatingActionButton : @Composable () -> Unit = {},
    floatingActionButtonAlignment: Alignment.Horizontal= Alignment.End,
    windowInsets: WindowInsets = WindowInsets.systemBarsForVisualComponents,
    content: @Composable (PaddingValues) -> Unit
) {

    val paddingValues = remember {
        object  : PaddingValues{
            var holder by mutableStateOf(PaddingValues(0.dp))

            override fun calculateLeftPadding(layoutDirection: LayoutDirection): Dp {
               return holder.calculateStartPadding(layoutDirection)
            }

            override fun calculateRightPadding(layoutDirection: LayoutDirection): Dp {
                return holder.calculateRightPadding(layoutDirection)
            }


            override fun calculateTopPadding(): Dp {
                return holder.calculateTopPadding()
            }

            override fun calculateBottomPadding(): Dp {
                return  holder.calculateBottomPadding()
            }
        }
    }

    val appBarContent : @Composable () -> Unit = remember (appBar){ {Box(){appBar()} } }
    val navigationBar : @Composable () -> Unit = remember (appBar){ {Box(){navigationBar()} } }
    val floatingActionButtonContent : @Composable () -> Unit = remember (appBar){ {Box(){floatingActionButton()} } }

    val bodyContent : @Composable () -> Unit = remember(content,paddingValues){{Box(){content(paddingValues)} }}


    SubcomposeLayout { constraints ->

        val maxLayoutWidth = constraints.maxWidth

        val maxLayoutHeight = constraints.maxHeight

        val looseConstraints = constraints.copy(minHeight = 0, minWidth =  0)


        val appBarPlaceable = subcompose(slotId = ScaffoldLayoutContent.Appbar, content = appBarContent).first().measure(looseConstraints)


        val navigationBarPlaceable = subcompose(slotId = ScaffoldLayoutContent.NavigationBar, content = navigationBar).first().measure(looseConstraints)


        val fabPlaceable  = subcompose(slotId = ScaffoldLayoutContent.FloatingActionButton, content = floatingActionButtonContent).first().measure(looseConstraints)


        val bodyContent = subcompose(slotId = ScaffoldLayoutContent.BodyContent , content = bodyContent).first().measure(looseConstraints)



        val isNoNavigationBar = navigationBarPlaceable.width == 0 && navigationBarPlaceable.height == 0



        // y of fab
        val fabY = if (isNoNavigationBar){
            fabPlaceable.height + FabSpacing.roundToPx() + windowInsets.getBottom(this)
        }else {navigationBarPlaceable.height + fabPlaceable.height + FabSpacing.roundToPx()}


        val insets = windowInsets.asPaddingValues(this)

        val fabSpacingPx = FabSpacing.roundToPx()

        paddingValues.holder = PaddingValues(
            top = if(appBarPlaceable.height == 0 && appBarPlaceable.width == 0){
                  insets.calculateTopPadding()
            }else appBarPlaceable.height.toDp(),

            bottom = if (navigationBarPlaceable.width == 0 && navigationBarPlaceable.height == 0){insets.calculateBottomPadding()} else navigationBarPlaceable.height.toDp(),

            start = insets.calculateStartPadding(layoutDirection),

            end = insets.calculateEndPadding(layoutDirection)
        )


        layout(height = maxLayoutHeight, width = maxLayoutWidth){

            appBarPlaceable.place(x = 0, y = 0)

            bodyContent.place(x =  0, y =  0)

            val fabX = fabSpacingPx + floatingActionButtonAlignment.align(
                size = fabPlaceable.width,
                space = maxLayoutWidth - 2 * fabSpacingPx,
                layoutDirection = layoutDirection
            )

            fabPlaceable.place(
                x = fabX,
                y = maxLayoutHeight - fabY
            )

            navigationBarPlaceable.place(
                x = 0, y = maxLayoutHeight - navigationBarPlaceable.height
            )



        }

    }



}





private val FabSpacing = 16.dp




private enum class ScaffoldLayoutContent{
    Appbar,
    BodyContent,
    NavigationBar,

    FloatingActionButton,
}