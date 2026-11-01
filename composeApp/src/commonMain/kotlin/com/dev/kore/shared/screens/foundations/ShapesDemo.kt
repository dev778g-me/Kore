package com.dev.kore.shared.screens.foundations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.shapes.AbsoluteSmoothCornerShape

/**
 * The corner shapes of the design system, shown for both the normal rounded
 * corners and the smooth (squircle) corners.
 *
 * Both sets are built explicitly from the size scale, so the comparison does
 * not depend on which shape family the active theme happens to use.
 */
@Composable
fun ShapesDemo() {
    val shapes = KoreTheme.shapes
    val sizes = KoreTheme.sizes

    val radii = listOf(
        "xl" to sizes.xl,
        "lg" to sizes.lg,
        "md" to sizes.md,
        "sm" to sizes.sm,
        "xs" to sizes.xs,
    )

    val roundedEntries = radii.map { (name, radius) -> name to RoundedCornerShape(radius) }
    val smoothEntries = radii.map { (name, radius) -> name to AbsoluteSmoothCornerShape(radius) }

    DemoPage {
        DemoBlock(title = "Rounded corners (normal)") {
            VariantRow {
                roundedEntries.forEach { (name, shape) ->
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(shape)
                            .background(KoreTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = name,
                            textStyle = KoreTheme.typography.label1,
                            color = KoreTheme.colorScheme.onPrimaryContainer,
                        )
                    }
                }
            }
        }

        DemoBlock(title = "Smooth corners (squircle)") {
            VariantRow {
                smoothEntries.forEach { (name, shape) ->
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(shape)
                            .background(KoreTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = name,
                            textStyle = KoreTheme.typography.label1,
                            color = KoreTheme.colorScheme.onPrimaryContainer,
                        )
                    }
                }
            }
        }

        DemoBlock(title = "Nested corners (theme shapes)") {
            Box(
                modifier = Modifier
                    .size(160.dp)
                    .clip(shapes.xl)
                    .background(KoreTheme.colorScheme.backGroundVariant),
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(shapes.lg)
                        .background(KoreTheme.colorScheme.surface),
                    contentAlignment = Alignment.Center,
                ) {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(shapes.md)
                            .background(KoreTheme.colorScheme.primary),
                    )
                }
            }
        }
    }
}
