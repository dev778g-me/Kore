package com.dev.kore.shared.screens.foundations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme

/**
 * The spacing scale, from xl (34dp) down to xxs (4dp).
 */
@Composable
fun SizesDemo() {
    val sizes = KoreTheme.sizes

    val entries = listOf(
        "xl" to sizes.xl,
        "lg" to sizes.lg,
        "md" to sizes.md,
        "sm" to sizes.sm,
        "xs" to sizes.xs,
        "xxs" to sizes.xxs,
    )

    DemoPage {
        DemoBlock(title = "Spacing scale") {
            Column(verticalArrangement = Arrangement.spacedBy(sizes.sm)) {
                entries.forEach { (name, size) ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(sizes.sm),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = name,
                            textStyle = KoreTheme.typography.label1,
                            modifier = Modifier.width(40.dp),
                        )
                        Box(
                            modifier = Modifier
                                .width(size * 4)
                                .height(sizes.md)
                                .background(KoreTheme.colorScheme.primary, KoreTheme.shapes.xs),
                        )
                        Text(
                            text = "${size.value.toInt()}dp",
                            textStyle = KoreTheme.typography.label2,
                            color = KoreTheme.colorScheme.onBackGroundVariant,
                        )
                    }
                }
            }
        }

        DemoBlock(title = "Nested spacing") {
            Column(
                modifier = Modifier
                    .background(KoreTheme.colorScheme.backGroundVariant, KoreTheme.shapes.md)
                    .padding(sizes.md)
                    .width(220.dp),
                verticalArrangement = Arrangement.spacedBy(sizes.xl),
            ) {
                repeat(3) {
                    Box(
                        modifier = Modifier
                            .height(sizes.md)
                            .width(160.dp)
                            .background(KoreTheme.colorScheme.primary, KoreTheme.shapes.xs),
                    )
                }
            }
        }
    }
}
