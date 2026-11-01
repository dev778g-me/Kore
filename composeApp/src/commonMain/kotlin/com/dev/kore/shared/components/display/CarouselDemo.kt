package com.dev.kore.shared.components.display

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dev.kore.components.carousel.CarouselGroup
import com.dev.kore.components.carousel.rememberCarouselState
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme

@Composable
fun CarouselDemo() {
    val horizontalState = rememberCarouselState(initialPage = 0) { 3 }
    val smallState = rememberCarouselState(initialPage = 0) { 5 }

    DemoPage {
        DemoBlock(title = "Default") {
            CarouselGroup(
                state = horizontalState,
                verticalAlignment = Alignment.CenterVertically,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) { page ->
                CarouselCard(
                    page = page,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp),
                )
            }
        }

        DemoBlock(title = "Without filling the container") {
            CarouselGroup(
                state = smallState,
                carouselContentWidth = 140.dp,
                fillContainer = false,
                verticalAlignment = Alignment.CenterVertically,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) { page ->
                CarouselCard(
                    page = page,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                )
            }
        }

        DemoBlock(title = "Note") {
            Text(
                text = "Carousels are horizontal pagers: swipe to move between pages. " +
                    "Pair them with a page indicator when there are more than three pages.",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
        }
    }
}

@Composable
private fun CarouselCard(page: Int, modifier: Modifier = Modifier) {
    val colors = listOf(
        KoreTheme.colorScheme.primaryContainer,
        KoreTheme.colorScheme.complementaryContainer,
        KoreTheme.colorScheme.surface,
        KoreTheme.colorScheme.backGroundVariant,
        KoreTheme.colorScheme.primary,
    )
    val onColors = listOf(
        KoreTheme.colorScheme.onPrimaryContainer,
        KoreTheme.colorScheme.onComplementaryContainer,
        KoreTheme.colorScheme.onSurface,
        KoreTheme.colorScheme.onBackGroundVariant,
        KoreTheme.colorScheme.onPrimary,
    )
    val index = page % colors.size

    Box(
        modifier = modifier
            .clip(KoreTheme.shapes.md)
            .background(colors[index])
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Page ${page + 1}",
            textStyle = KoreTheme.typography.heading3,
            color = onColors[index],
        )
    }
}
