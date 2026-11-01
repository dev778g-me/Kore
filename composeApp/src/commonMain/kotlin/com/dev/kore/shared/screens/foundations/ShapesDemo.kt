package com.dev.kore.shared.screens.foundations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
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

/**
 * The five corner shapes of the design system, drawn on the same surface.
 */
@Composable
fun ShapesDemo() {
    val shapes = KoreTheme.shapes

    val entries = listOf(
        "xl" to shapes.xl,
        "lg" to shapes.lg,
        "md" to shapes.md,
        "sm" to shapes.sm,
        "xs" to shapes.xs,
    )

    DemoPage {
        DemoBlock(title = "Corner shapes") {
            VariantRow {
                entries.forEach { (name, shape) ->
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

        DemoBlock(title = "Nested corners") {
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
