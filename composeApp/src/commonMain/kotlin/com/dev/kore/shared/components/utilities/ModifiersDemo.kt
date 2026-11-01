package com.dev.kore.shared.components.utilities

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.modifiers.blueprintGrid
import com.dev.kore.utilities.modifiers.dashedBorder
import com.dev.kore.utilities.modifiers.dotBorder
import com.dev.kore.utilities.modifiers.horizontalFadingEdges
import com.dev.kore.utilities.modifiers.magneticPull
import com.dev.kore.utilities.modifiers.noRippleClickable
import com.dev.kore.utilities.modifiers.scaleClickable
import com.dev.kore.utilities.modifiers.verticalFadingEdges

@Composable
fun ModifiersDemo() {
    DemoPage {
        DemoBlock(title = "scaleClickable") {
            Box(
                modifier = Modifier
                    .clip(KoreTheme.shapes.md)
                    .scaleClickable(onClick = {})
                    .background(KoreTheme.colorScheme.primary, KoreTheme.shapes.md)
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Press and hold",
                    textStyle = KoreTheme.typography.title3,
                    color = KoreTheme.colorScheme.onPrimary,
                )
            }
        }

        DemoBlock(title = "noRippleClickable") {
            Box(
                modifier = Modifier
                    .clip(KoreTheme.shapes.md)
                    .noRippleClickable(onClick = {})
                    .background(KoreTheme.colorScheme.primaryContainer, KoreTheme.shapes.md)
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "No ripple, still clickable",
                    textStyle = KoreTheme.typography.title3,
                    color = KoreTheme.colorScheme.onPrimaryContainer,
                )
            }
        }

        DemoBlock(title = "dashedBorder") {
            Box(
                modifier = Modifier
                    .size(140.dp)
                    .background(KoreTheme.colorScheme.surface, KoreTheme.shapes.md)
                    .dashedBorder(
                        color = KoreTheme.colorScheme.primary,
                        thickness = 2.dp,
                        dashLength = 8.dp,
                        gapLength = 6.dp,
                        shape = KoreTheme.shapes.md,
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Text("Dashed", textStyle = KoreTheme.typography.label1)
            }
        }

        DemoBlock(title = "dotBorder") {
            Box(
                modifier = Modifier
                    .size(140.dp)
                    .background(KoreTheme.colorScheme.surface, KoreTheme.shapes.xl)
                    .dotBorder(
                        color = KoreTheme.colorScheme.complementary,
                        dotRadius = 2.dp,
                        gapLength = 6.dp,
                        shape = KoreTheme.shapes.xl,
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Text("Dotted", textStyle = KoreTheme.typography.label1)
            }
        }

        DemoBlock(title = "blueprintGrid") {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(KoreTheme.shapes.md)
                    .background(KoreTheme.colorScheme.surface)
                    .blueprintGrid(
                        gridSize = 16.dp,
                        dotRadius = 1.dp,
                        dotColor = KoreTheme.colorScheme.onBackGroundVariant,
                    ),
            )
        }

        DemoBlock(title = "verticalFadingEdges") {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(KoreTheme.shapes.md)
                    .verticalFadingEdges(fadePercentage = 0.12f)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs),
            ) {
                repeat(12) { index ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(36.dp)
                            .background(
                                KoreTheme.colorScheme.backGroundVariant,
                                KoreTheme.shapes.xs,
                            ),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text("Row $index", textStyle = KoreTheme.typography.label2)
                    }
                }
            }
        }

        DemoBlock(title = "horizontalFadingEdges") {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(KoreTheme.shapes.md)
                    .horizontalFadingEdges(fadePercentage = 0.12f)
                    .horizontalScroll(rememberScrollState()),
            ) {
                androidx.compose.foundation.layout.Row(
                    horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    repeat(12) { index ->
                        Box(
                            modifier = Modifier
                                .requiredSize(64.dp)
                                .background(
                                    KoreTheme.colorScheme.primaryContainer,
                                    KoreTheme.shapes.xs,
                                ),
                            contentAlignment = Alignment.Center,
                        ) {
                            Text("$index", textStyle = KoreTheme.typography.label2)
                        }
                    }
                }
            }
        }

        DemoBlock(title = "magneticPull") {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(KoreTheme.shapes.md)
                    .background(KoreTheme.colorScheme.backGroundVariant),
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .clip(KoreTheme.shapes.xs)
                        .magneticPull(pullStrength = 8f)
                        .background(KoreTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "drag",
                        textStyle = KoreTheme.typography.label2,
                        color = KoreTheme.colorScheme.onPrimary,
                    )
                }
            }
        }

        DemoBlock(title = "Note") {
            Text(
                text = "These modifiers are designed to be dropped in front of the background of a " +
                    "component: the visual effect only reaches what is drawn after them.",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
        }
    }
}
