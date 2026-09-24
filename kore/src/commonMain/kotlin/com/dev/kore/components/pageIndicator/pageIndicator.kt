package com.dev.kore.components.pageIndicator

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreTheme

@Composable
fun DotPageIndicator(
    selectedPage : Int,
    pageSize : Int,
    modifier: Modifier = Modifier,
    orientation: Orientation = Orientation.Horizontal,
    indicatorShape: Shape = PageIndicatorDefaults.defaultPageIndicatorShape,
    indicatorSize: Dp = PageIndicatorDefaults.defaultPageIndicatorSize,
    spacing : Dp = 4.dp,
    selectedIndicatorColor : Color= KoreTheme.colorScheme.primary,
    unSelectedIndicatorColor : Color= KoreTheme.colorScheme.backGroundVariant
){

    if (orientation == Orientation.Horizontal){
        HorizontalDotPageIndicator(
            modifier = modifier,
            selectedPage = selectedPage,
            pageSize = pageSize,
            spacing = spacing,
            indicatorShape = indicatorShape,
            indicatorSize = indicatorSize,
            selectedIndicatorColor = selectedIndicatorColor,
            unSelectedIndicatorColor = unSelectedIndicatorColor
        )
    }else {
        VerticalDotPageIndicator(
            modifier = modifier,
            selectedPage = selectedPage,
            pageSize = pageSize,
            spacing = spacing,
            indicatorShape = indicatorShape,
            indicatorSize = indicatorSize,
            selectedIndicatorColor = selectedIndicatorColor,
            unSelectedIndicatorColor = unSelectedIndicatorColor
        )
    }

}

@Composable
private fun HorizontalDotPageIndicator(
    modifier: Modifier = Modifier,
    selectedPage: Int,
    pageSize: Int,
    spacing: Dp,
    indicatorSize : Dp,
    indicatorShape : Shape ,
    selectedIndicatorColor: Color,
    unSelectedIndicatorColor: Color,
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(spacing)
    ) {
        repeat(pageSize){ currentPage ->
            val selected = selectedPage == currentPage
            val indicatorColor by animateColorAsState(
                targetValue = if (selected) selectedIndicatorColor else unSelectedIndicatorColor
            )

            Box(
                modifier = Modifier.size(indicatorSize)
                    .background(shape = indicatorShape, color = indicatorColor)
            )
        }
    }
}

@Composable
private fun VerticalDotPageIndicator(
    modifier: Modifier = Modifier,
    selectedPage: Int,
    pageSize: Int,
    spacing: Dp,
    indicatorSize: Dp ,
    indicatorShape: Shape ,
    selectedIndicatorColor: Color,
    unSelectedIndicatorColor: Color,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(spacing)
    ) {
        repeat(pageSize) {
            repeat(pageSize) { currentPage ->
                val selected = selectedPage == currentPage
                val indicatorColor by animateColorAsState(
                    targetValue = if (selected) selectedIndicatorColor else unSelectedIndicatorColor
                )

                Box(
                    modifier = Modifier.size(indicatorSize)
                        .background(shape = indicatorShape, color = indicatorColor)
                )
            }
        }
    }

}






object PageIndicatorDefaults{

    val defaultPageIndicatorShape : Shape = CircleShape


    val defaultPageIndicatorSize : Dp = 6.dp

    val defaultIndicatorSpacing : Dp = 4.dp
}


