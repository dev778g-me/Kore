package com.dev.kore.shared.components.navigation

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.dev.kore.components.pageIndicator.DotPageIndicator
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme

@Composable
fun PageIndicatorDemo() {
    var page by remember { mutableStateOf(0) }
    var verticalPage by remember { mutableStateOf(1) }

    DemoPage {
        DemoBlock(title = "Horizontal") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                DotPageIndicator(
                    selectedPage = page,
                    pageSize = 5,
                    onPageSelected = { page = it },
                )
                Text(
                    text = "page ${page + 1} of 5 · tap a dot to jump",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
            }
        }

        DemoBlock(title = "Vertical") {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.md),
            ) {
                DotPageIndicator(
                    selectedPage = verticalPage,
                    pageSize = 4,
                    orientation = Orientation.Vertical,
                    onPageSelected = { verticalPage = it },
                )
                Text(
                    text = "page ${verticalPage + 1} of 4",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
            }
        }

        DemoBlock(title = "Sizes") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                DotPageIndicator(
                    selectedPage = 1,
                    pageSize = 4,
                    indicatorSize = 6.dp,
                    spacing = 4.dp,
                )
                DotPageIndicator(
                    selectedPage = 1,
                    pageSize = 4,
                    indicatorSize = 10.dp,
                    spacing = 8.dp,
                )
                DotPageIndicator(
                    selectedPage = 1,
                    pageSize = 4,
                    indicatorSize = 14.dp,
                    spacing = 10.dp,
                )
            }
        }

        DemoBlock(title = "Colors") {
            DotPageIndicator(
                selectedPage = page,
                pageSize = 5,
                selectedIndicatorColor = KoreTheme.colorScheme.complementary,
                unSelectedIndicatorColor = KoreTheme.colorScheme.disabled,
                onPageSelected = { page = it },
            )
        }

        DemoBlock(title = "Read only") {
            DotPageIndicator(
                selectedPage = 2,
                pageSize = 5,
            )
        }
    }
}
