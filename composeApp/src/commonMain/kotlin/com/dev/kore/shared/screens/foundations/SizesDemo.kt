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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme

/**
 * The size scale, from xl (34dp) down to xxs (4dp).
 */
@Composable
fun SizesDemo() {
    val sizes = KoreTheme.sizes
    val shapes = KoreTheme.shapes
    val colors = KoreTheme.colorScheme

    val entries = listOf(
        "xl" to sizes.xl,
        "lg" to sizes.lg,
        "md" to sizes.md,
        "sm" to sizes.sm,
        "xs" to sizes.xs,
        "xxs" to sizes.xxs,
    )

    val max = sizes.xl

    DemoPage {
        DemoBlock(title = "Sizes") {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shapes.md)
                    .background(colors.surface)
                    .padding(sizes.md),
                verticalArrangement = Arrangement.spacedBy(sizes.md),
            ) {
                entries.forEach { (name, size) ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(sizes.sm),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        // Token name
                        Text(
                            text = name,
                            textStyle = KoreTheme.typography.label1,
                            modifier = Modifier.width(32.dp),
                        )

                        // Real-size square (fixed slot keeps rows aligned)
                        Box(
                            modifier = Modifier.size(max),
                            contentAlignment = Alignment.Center,
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(size)
                                    .clip(shapes.xs)
                                    .background(colors.primary),
                            )
                        }

                        // Relative bar
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(sizes.xs)
                                .clip(shapes.xs)
                                .background(colors.backGroundVariant),
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(size / max)
                                    .height(sizes.xs)
                                    .clip(shapes.xs)
                                    .background(colors.primary),
                            )
                        }

                        // Value pill
                        Box(
                            modifier = Modifier
                                .clip(shapes.xs)
                                .background(colors.backGroundVariant)
                                .padding(horizontal = sizes.sm, vertical = sizes.xxs),
                        ) {
                            Text(
                                text = "${size.value.toInt()}dp",
                                textStyle = KoreTheme.typography.label2,
                                color = colors.onBackGroundVariant,
                            )
                        }
                    }
                }
            }
        }
    }
}