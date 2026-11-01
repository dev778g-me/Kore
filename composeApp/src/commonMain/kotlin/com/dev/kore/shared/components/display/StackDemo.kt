package com.dev.kore.shared.components.display

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.stack.HorizontalStack
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme

@Composable
fun StackDemo() {
    DemoPage {
        DemoBlock(title = "Vertical") {
            VerticalStack {
                repeat(3) { index ->
                    Box(
                        modifier = Modifier
                            .width(120.dp)
                            .height(KoreTheme.sizes.xl)
                            .background(KoreTheme.colorScheme.primaryContainer, KoreTheme.shapes.xs),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = "Item $index",
                            textStyle = KoreTheme.typography.label2,
                            color = KoreTheme.colorScheme.onPrimaryContainer,
                        )
                    }
                }
            }
        }

        DemoBlock(title = "Horizontal") {
            HorizontalStack {
                repeat(4) { index ->
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .background(KoreTheme.colorScheme.primary, KoreTheme.shapes.sm),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = "$index",
                            textStyle = KoreTheme.typography.title3,
                            color = KoreTheme.colorScheme.onPrimary,
                        )
                    }
                }
            }
        }

        DemoBlock(title = "Custom spacing") {
            VerticalStack(spacing = KoreTheme.sizes.xl) {
                Text("xl spacing", textStyle = KoreTheme.typography.body2)
                Text("between each child", textStyle = KoreTheme.typography.body2)
                Text("of the stack", textStyle = KoreTheme.typography.body2)
            }
        }

        DemoBlock(title = "Alignment") {
            HorizontalStack(
                modifier = Modifier.height(96.dp),
                horizontalAlignment = Alignment.Start,
                verticalAlignment = Alignment.Bottom,
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(KoreTheme.colorScheme.primary, KoreTheme.shapes.xs),
                )
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(KoreTheme.colorScheme.complementary, KoreTheme.shapes.xs),
                )
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(KoreTheme.colorScheme.success, KoreTheme.shapes.xs),
                )
            }
        }
    }
}
