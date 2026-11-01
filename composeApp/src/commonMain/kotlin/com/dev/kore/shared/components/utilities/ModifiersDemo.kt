package com.dev.kore.shared.components.utilities

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
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
import com.dev.kore.utilities.modifiers.shimmer
import com.dev.kore.utilities.modifiers.verticalFadingEdges

@Composable
fun ScaleClickableDemo() {
    DemoPage {
        DemoBlock(title = "scaleClickable") {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
            ) {
                Text(
                    text = "Press and hold the surface. It scales down while pressed and springs back on release. Variations change the pressed scale and the spring.",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
                Box(
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth()
                        .clip(KoreTheme.shapes.md)
                        .scaleClickable(onClick = {}, pressedScale = 0.9f)
                        .background(KoreTheme.colorScheme.primary, KoreTheme.shapes.md),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("pressed scale 0.9", textStyle = KoreTheme.typography.title3, color = KoreTheme.colorScheme.onPrimary)
                }
                Box(
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth()
                        .clip(KoreTheme.shapes.md)
                        .scaleClickable(onClick = {}, pressedScale = 0.95f)
                        .background(KoreTheme.colorScheme.primary, KoreTheme.shapes.md),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("pressed scale 0.95", textStyle = KoreTheme.typography.title3, color = KoreTheme.colorScheme.onPrimary)
                }
                Box(
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth()
                        .clip(KoreTheme.shapes.md)
                        .scaleClickable(
                            onClick = {},
                            pressedScale = 0.85f,
                            animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow),
                        )
                        .background(KoreTheme.colorScheme.primary, KoreTheme.shapes.md),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("bouncy spring", textStyle = KoreTheme.typography.title3, color = KoreTheme.colorScheme.onPrimary)
                }
            }
        }
    }
}

@Composable
fun NoRippleClickableDemo() {
    DemoPage {
        DemoBlock(title = "noRippleClickable") {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
            ) {
                Text(
                    text = "A clickable surface with no ripple indication. Useful for custom press feedback. The disabled variant does not respond to input.",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
                Box(
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth()
                        .clip(KoreTheme.shapes.md)
                        .noRippleClickable(onClick = {})
                        .background(KoreTheme.colorScheme.primaryContainer, KoreTheme.shapes.md),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("enabled", textStyle = KoreTheme.typography.title3, color = KoreTheme.colorScheme.onPrimaryContainer)
                }
                Box(
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth()
                        .clip(KoreTheme.shapes.md)
                        .noRippleClickable(onClick = {}, enabled = false)
                        .background(KoreTheme.colorScheme.disabled, KoreTheme.shapes.md),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("disabled", textStyle = KoreTheme.typography.title3, color = KoreTheme.colorScheme.onDisabled)
                }
            }
        }
    }
}

@Composable
fun DashedBorderDemo() {
    DemoPage {
        DemoBlock(title = "dashedBorder") {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
            ) {
                Text(
                    text = "Draws a dashed border around the content. Color and brush overloads, with adjustable dash and gap lengths.",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
                Box(
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
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
                    Text("color", textStyle = KoreTheme.typography.label1)
                }
                Box(
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                        .background(KoreTheme.colorScheme.surface, KoreTheme.shapes.md)
                        .dashedBorder(
                            brush = Brush.linearGradient(
                                listOf(KoreTheme.colorScheme.primary, KoreTheme.colorScheme.complementary),
                            ),
                            thickness = 2.dp,
                            dashLength = 6.dp,
                            gapLength = 4.dp,
                            shape = KoreTheme.shapes.md,
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("brush", textStyle = KoreTheme.typography.label1)
                }
            }
        }
    }
}

@Composable
fun DotBorderDemo() {
    DemoPage {
        DemoBlock(title = "dotBorder") {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
            ) {
                Text(
                    text = "Draws a dotted border around the content. Color and brush overloads, with adjustable dot radius and gap.",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
                Box(
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                        .background(KoreTheme.colorScheme.surface, KoreTheme.shapes.xl)
                        .dotBorder(
                            color = KoreTheme.colorScheme.complementary,
                            dotRadius = 2.dp,
                            gapLength = 6.dp,
                            shape = KoreTheme.shapes.xl,
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("color", textStyle = KoreTheme.typography.label1)
                }
                Box(
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                        .background(KoreTheme.colorScheme.surface, KoreTheme.shapes.xl)
                        .dotBorder(
                            brush = Brush.verticalGradient(
                                listOf(KoreTheme.colorScheme.primary, KoreTheme.colorScheme.complementary),
                            ),
                            dotRadius = 3.dp,
                            gapLength = 4.dp,
                            shape = KoreTheme.shapes.xl,
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("brush", textStyle = KoreTheme.typography.label1)
                }
            }
        }
    }
}

@Composable
fun BlueprintGridDemo() {
    DemoPage {
        DemoBlock(title = "blueprintGrid") {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
            ) {
                Text(
                    text = "Overlays a dotted grid on the surface. Variations change grid size and dot color.",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
                Box(
                    modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth()
                        .clip(KoreTheme.shapes.md)
                        .background(KoreTheme.colorScheme.surface)
                        .blueprintGrid(
                            gridSize = 16.dp,
                            dotRadius = 1.dp,
                            dotColor = KoreTheme.colorScheme.onBackGroundVariant,
                        ),
                )
                Box(
                    modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth()
                        .clip(KoreTheme.shapes.md)
                        .background(KoreTheme.colorScheme.surface)
                        .blueprintGrid(
                            gridSize = 8.dp,
                            dotRadius = 1.5.dp,
                            dotColor = KoreTheme.colorScheme.primary,
                        ),
                )
            }
        }
    }
}

@Composable
fun VerticalFadingEdgesDemo() {
    DemoPage {
        DemoBlock(title = "verticalFadingEdges") {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
            ) {
                Text(
                    text = "Fades the top and bottom edges of a vertically scrolling list.",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .clip(KoreTheme.shapes.md)
                        .verticalFadingEdges(fadePercentage = 0.12f)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    repeat(12) { index ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.9f)
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
        }
    }
}

@Composable
fun HorizontalFadingEdgesDemo() {
    DemoPage {
        DemoBlock(title = "horizontalFadingEdges") {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
            ) {
                Text(
                    text = "Fades the left and right edges of a horizontally scrolling row.",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(KoreTheme.shapes.md)
                        .horizontalFadingEdges(fadePercentage = 0.12f)
                        .horizontalScroll(rememberScrollState()),
                ) {
                    Row(
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
        }
    }
}

@Composable
fun MagneticPullDemo() {
    DemoPage {
        DemoBlock(title = "magneticPull") {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
            ) {
                Text(
                    text = "Pulls the surface toward the pointer while dragging. Variations change pull strength.",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
                Box(
                    modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth()
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
                        Text("pull 8", textStyle = KoreTheme.typography.label2, color = KoreTheme.colorScheme.onPrimary)
                    }
                }
                Box(
                    modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth()
                        .clip(KoreTheme.shapes.md)
                        .background(KoreTheme.colorScheme.backGroundVariant),
                    contentAlignment = Alignment.Center,
                ) {
                    Box(
                        modifier = Modifier
                            .size(72.dp)
                            .clip(KoreTheme.shapes.xs)
                            .magneticPull(pullStrength = 20f)
                            .background(KoreTheme.colorScheme.primary),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text("pull 20", textStyle = KoreTheme.typography.label2, color = KoreTheme.colorScheme.onPrimary)
                    }
                }
            }
        }
    }
}

@Composable
fun ShimmerDemo() {
    DemoPage {
        DemoBlock(title = "shimmer") {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
            ) {
                Text(
                    text = "Animated shimmer placeholder for loading states. Default and custom colors.",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
                // Large skeleton card
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(KoreTheme.shapes.md)
                        .background(KoreTheme.colorScheme.surface)
                        .padding(KoreTheme.sizes.lg),
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.md)) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.md),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(KoreTheme.shapes.xl)
                                    .shimmer(shape = KoreTheme.shapes.xl),
                            )
                            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs)) {
                                Box(
                                    modifier = Modifier
                                        .width(200.dp)
                                        .height(16.dp)
                                        .clip(KoreTheme.shapes.xs)
                                        .shimmer(),
                                )
                                Box(
                                    modifier = Modifier
                                        .width(140.dp)
                                        .height(12.dp)
                                        .clip(KoreTheme.shapes.xs)
                                        .shimmer(),
                                )
                                Box(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(12.dp)
                                        .clip(KoreTheme.shapes.xs)
                                        .shimmer(),
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.85f)
                                .height(14.dp)
                                .clip(KoreTheme.shapes.xs)
                                .shimmer(),
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.6f)
                                .height(14.dp)
                                .clip(KoreTheme.shapes.xs)
                                .shimmer(),
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                            Box(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(40.dp)
                                    .clip(KoreTheme.shapes.sm)
                                    .shimmer(shape = KoreTheme.shapes.sm),
                            )
                            Box(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(40.dp)
                                    .clip(KoreTheme.shapes.sm)
                                    .shimmer(shape = KoreTheme.shapes.sm),
                            )
                        }
                    }
                }
                // Additional shimmer rows
                repeat(4) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .clip(KoreTheme.shapes.md)
                            .background(KoreTheme.colorScheme.surface)
                            .padding(KoreTheme.sizes.sm),
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(KoreTheme.shapes.xl)
                                    .shimmer(shape = KoreTheme.shapes.xl),
                            )
                            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs)) {
                                Box(
                                    modifier = Modifier
                                        .width(180.dp)
                                        .height(12.dp)
                                        .clip(KoreTheme.shapes.xs)
                                        .shimmer(),
                                )
                                Box(
                                    modifier = Modifier
                                        .width(120.dp)
                                        .height(10.dp)
                                        .clip(KoreTheme.shapes.xs)
                                        .shimmer(),
                                )
                            }
                        }
                    }
                }
                // Color variants
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .shimmer(),
                    )
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .shimmer(
                                colors = listOf(
                                    KoreTheme.colorScheme.primary.copy(alpha = 0.4f),
                                    KoreTheme.colorScheme.primary.copy(alpha = 0.1f),
                                    KoreTheme.colorScheme.primary.copy(alpha = 0.4f),
                                ),
                                shape = KoreTheme.shapes.xl,
                            ),
                    )
                }
            }
        }
    }
}
