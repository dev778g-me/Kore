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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastMap
import androidx.compose.ui.util.fastMaxBy
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
    windowInsets: WindowInsets = WindowInsets.systemBarsForVisualComponents,
    containerColor: Color = LocalKoreColorScheme.current.background,
    contentColor: Color = LocalKoreColorScheme.current.onBackGround,
    content: @Composable (PaddingValues) -> Unit
) {
    val safeInsets = remember(windowInsets) { MutableWindowInsets(windowInsets) }
    CompositionLocalProvider(
        LocalContentColor provides contentColor
    ){
        Box(
            modifier = modifier.onConsumedWindowInsetsChanged{
                safeInsets.insets =  windowInsets.exclude(it)
            }.background(
                color = containerColor
            )
        ) {
            SubcomposeLayout(
                modifier = modifier
            ) { constraints ->

                val maxLayOutWidth = constraints.maxWidth

                val maxLayOUtHeight = constraints.maxHeight


                val looseConstraints = constraints.copy(minWidth = 0, minHeight = 0)

                // variable for appbar placeable
                val appBarPlaceable =
                    subcompose(slotId = ScaffoldLayoutContent.APPBAR, content = appBar).fastMap {
                        it.measure(looseConstraints)
                    }

                // getting the maximum height of the app bar
                val appBarHeight = appBarPlaceable.fastMaxBy { it.height }?.height ?: 0


                //variable for navigation bar placeables
                val navigationBarPlaceable = subcompose(slotId = ScaffoldLayoutContent.NAVIGATIONBAR, content = navigationBar).fastMap {
                    it.measure(looseConstraints)
                }


                // getting maximum height of the navigation bar
                val navigationBarHeight = navigationBarPlaceable.fastMaxBy { it.height }?.height ?: 0



                val bodyContentPlaceable = subcompose(slotId = ScaffoldLayoutContent.BODYCONTENT,){
                    val insets = windowInsets.asPaddingValues(this@SubcomposeLayout)
                    val contentPadding  = PaddingValues(
                        top = if (appBarPlaceable.isEmpty()){
                            insets.calculateTopPadding()
                        }else {
                            appBarHeight.toDp()
                        },
                        bottom = if (navigationBarPlaceable.isEmpty()){
                            insets.calculateBottomPadding()
                        }else{
                            navigationBarHeight.toDp()
                        },
                        start = insets.calculateStartPadding(this@SubcomposeLayout.layoutDirection),
                        end = insets.calculateEndPadding(this@SubcomposeLayout.layoutDirection)
                    )
                    content(contentPadding)
                }.fastMap {
                    it.measure(looseConstraints)
                }

                layout(
                    width = maxLayOutWidth,
                    height = maxLayOUtHeight
                ){
                    bodyContentPlaceable.fastForEach {
                        it.place(
                            x = 0,
                            y = 0
                        )
                    }


                    appBarPlaceable.fastForEach {
                        it.place(
                            x = 0,
                            y = 0
                        )
                    }

                    navigationBarPlaceable.fastForEach {
                        it.place(
                            x = 0,
                            y = maxLayOUtHeight - navigationBarHeight
                        )
                    }
                }




            }
        }
    }
    }













private enum class ScaffoldLayoutContent{
    APPBAR,
    BODYCONTENT,
    NAVIGATIONBAR,
}