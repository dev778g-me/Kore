package com.dev.kore.shared.components.feedback

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.shimmer.ShimmerBox
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.modifiers.shimmer

@Composable
fun ShimmerDemo() {
    DemoPage {
        DemoBlock(title = "Skeleton list") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                repeat(3) {
                    Row(horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                        ShimmerBox(
                            modifier = Modifier.size(48.dp),
                            shape = CircleShape,
                        )
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs),
                        ) {
                            ShimmerBox(
                                modifier = Modifier.fillMaxWidth().height(16.dp),
                                shape = KoreTheme.shapes.xs,
                            )
                            ShimmerBox(
                                modifier = Modifier.fillMaxWidth(0.6f).height(16.dp),
                                shape = KoreTheme.shapes.xs,
                            )
                        }
                    }
                }
            }
        }

        DemoBlock(title = "Card placeholder") {
            ShimmerBox(
                modifier = Modifier.fillMaxWidth().height(120.dp),
                shape = KoreTheme.shapes.lg,
            )
        }

        DemoBlock(title = "Sizing to its content") {
            ShimmerBox(shape = KoreTheme.shapes.md) {
                Text(
                    text = "This text defines the size of the shimmer.",
                    textStyle = KoreTheme.typography.body1,
                    modifier = Modifier.padding(12.dp),
                )
            }
        }

        DemoBlock(title = "Shimmer modifier") {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .background(KoreTheme.colorScheme.surface, KoreTheme.shapes.md)
                    .shimmer(shape = KoreTheme.shapes.md),
            )
        }
    }
}
