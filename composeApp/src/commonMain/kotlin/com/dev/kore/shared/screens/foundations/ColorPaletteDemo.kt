package com.dev.kore.shared.screens.foundations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dev.kore.components.tabRow.Tab
import com.dev.kore.components.tabRow.TabRow
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.theme.LocalAppSettings
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.colors.RadixColors
import com.dev.kore.themes.colors.RadixScale
import com.dev.kore.themes.colors.TailwindColors
import com.dev.kore.themes.colors.TailwindSwatch
import kotlinx.coroutines.launch

/**
 * A reference of every color scale shipped with Kore: the full Radix UI
 * palette (light and dark, 12 steps each) and the Tailwind swatches.
 */
@Composable
fun ColorPaletteDemo() {
    val settings = LocalAppSettings.current
    val isDark = settings.isDark
    val shapes = KoreTheme.shapes
    val pagerState = rememberPagerState(pageCount = { 2 })
    val scope = rememberCoroutineScope()

    DemoPage {
        TabRow(
            selectedIndex = pagerState.currentPage,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Tab(
                isSelected = pagerState.currentPage == 0,
                onClick = { scope.launch { pagerState.animateScrollToPage(0) } },
            ) {
                Text("Radix")
            }
            Tab(
                isSelected = pagerState.currentPage == 1,
                onClick = { scope.launch { pagerState.animateScrollToPage(1) } },
            ) {
                Text("Tailwind")
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth().height(600.dp),
            verticalAlignment = Alignment.Top,
        ) { page ->
            when (page) {
                0 -> {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs),
                    ) {
                        DemoBlock(title = "Radix colors") {
                            Text(
                                text = "Each scale has 12 steps: 1-2 backgrounds, 3-5 components, 6-8 borders, 9-10 solid fills, 11-12 text.",
                                textStyle = KoreTheme.typography.body3,
                                color = KoreTheme.colorScheme.onBackGroundVariant,
                            )
                        }
                        radixFamilies(isDark).forEach { (name, scale) ->
                            DemoBlock(title = "Radix $name") {
                                Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(2.dp),
                            ) {
                                    scale.steps.forEachIndexed { index, color ->
                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .height(24.dp)
                                                .clip(shapes.xs)
                                                .background(color),
                                            contentAlignment = Alignment.Center,
                                        ) {
                                            Text(
                                                text = "${index + 1}",
                                                textStyle = KoreTheme.typography.label2,
                                                color = KoreTheme.colorScheme.onBackGround,
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                1 -> {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs),
                    ) {
                        DemoBlock(title = "Tailwind colors") {
                            Text(
                                text = "Tailwind swatches, 50 to 950.",
                                textStyle = KoreTheme.typography.body3,
                                color = KoreTheme.colorScheme.onBackGroundVariant,
                            )
                        }
                        tailwindFamilies().forEach { (name, swatch) ->
                            DemoBlock(title = "Tailwind $name") {
                                Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(2.dp),
                            ) {
                                    swatch.swatches.forEach { color ->
                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .height(24.dp)
                                                .clip(shapes.xs)
                                                .background(color),
                                        )
                                    }
                                }
                            }
                        }
                        DemoBlock(title = "Tailwind Black White Transparent") {
                            Row(horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                                listOf(
                                    "Black" to TailwindColors.Black,
                                    "White" to TailwindColors.White,
                                ).forEach { (name, color) ->
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Box(
                                            modifier = Modifier
                                                .size(40.dp)
                                                .clip(shapes.sm)
                                                .background(color),
                                        )
                                        Text(text = name, textStyle = KoreTheme.typography.label2)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun radixFamilies(isDark: Boolean): List<Pair<String, RadixScale>> = listOf(
    "Gray" to (if (isDark) RadixColors.Gray.dark else RadixColors.Gray.light),
    "Mauve" to (if (isDark) RadixColors.Mauve.dark else RadixColors.Mauve.light),
    "Slate" to (if (isDark) RadixColors.Slate.dark else RadixColors.Slate.light),
    "Sage" to (if (isDark) RadixColors.Sage.dark else RadixColors.Sage.light),
    "Olive" to (if (isDark) RadixColors.Olive.dark else RadixColors.Olive.light),
    "Sand" to (if (isDark) RadixColors.Sand.dark else RadixColors.Sand.light),
    "Gold" to (if (isDark) RadixColors.Gold.dark else RadixColors.Gold.light),
    "Bronze" to (if (isDark) RadixColors.Bronze.dark else RadixColors.Bronze.light),
    "Brown" to (if (isDark) RadixColors.Brown.dark else RadixColors.Brown.light),
    "Yellow" to (if (isDark) RadixColors.Yellow.dark else RadixColors.Yellow.light),
    "Amber" to (if (isDark) RadixColors.Amber.dark else RadixColors.Amber.light),
    "Orange" to (if (isDark) RadixColors.Orange.dark else RadixColors.Orange.light),
    "Tomato" to (if (isDark) RadixColors.Tomato.dark else RadixColors.Tomato.light),
    "Red" to (if (isDark) RadixColors.Red.dark else RadixColors.Red.light),
    "Ruby" to (if (isDark) RadixColors.Ruby.dark else RadixColors.Ruby.light),
    "Crimson" to (if (isDark) RadixColors.Crimson.dark else RadixColors.Crimson.light),
    "Pink" to (if (isDark) RadixColors.Pink.dark else RadixColors.Pink.light),
    "Plum" to (if (isDark) RadixColors.Plum.dark else RadixColors.Plum.light),
    "Purple" to (if (isDark) RadixColors.Purple.dark else RadixColors.Purple.light),
    "Violet" to (if (isDark) RadixColors.Violet.dark else RadixColors.Violet.light),
    "Iris" to (if (isDark) RadixColors.Iris.dark else RadixColors.Iris.light),
    "Indigo" to (if (isDark) RadixColors.Indigo.dark else RadixColors.Indigo.light),
    "Blue" to (if (isDark) RadixColors.Blue.dark else RadixColors.Blue.light),
    "Cyan" to (if (isDark) RadixColors.Cyan.dark else RadixColors.Cyan.light),
    "Teal" to (if (isDark) RadixColors.Teal.dark else RadixColors.Teal.light),
    "Jade" to (if (isDark) RadixColors.Jade.dark else RadixColors.Jade.light),
    "Green" to (if (isDark) RadixColors.Green.dark else RadixColors.Green.light),
    "Grass" to (if (isDark) RadixColors.Grass.dark else RadixColors.Grass.light),
    "Lime" to (if (isDark) RadixColors.Lime.dark else RadixColors.Lime.light),
    "Mint" to (if (isDark) RadixColors.Mint.dark else RadixColors.Mint.light),
    "Sky" to (if (isDark) RadixColors.Sky.dark else RadixColors.Sky.light),
)

private fun tailwindFamilies(): List<Pair<String, TailwindSwatch>> = listOf(
    "Slate" to TailwindColors.Slate,
    "Gray" to TailwindColors.Gray,
    "Zinc" to TailwindColors.Zinc,
    "Neutral" to TailwindColors.Neutral,
    "Stone" to TailwindColors.Stone,
    "Red" to TailwindColors.Red,
    "Orange" to TailwindColors.Orange,
    "Amber" to TailwindColors.Amber,
    "Yellow" to TailwindColors.Yellow,
    "Lime" to TailwindColors.Lime,
    "Green" to TailwindColors.Green,
    "Emerald" to TailwindColors.Emerald,
    "Teal" to TailwindColors.Teal,
    "Cyan" to TailwindColors.Cyan,
    "Sky" to TailwindColors.Sky,
    "Blue" to TailwindColors.Blue,
    "Indigo" to TailwindColors.Indigo,
    "Violet" to TailwindColors.Violet,
    "Purple" to TailwindColors.Purple,
    "Fuchsia" to TailwindColors.Fuchsia,
    "Pink" to TailwindColors.Pink,
    "Rose" to TailwindColors.Rose,
)
