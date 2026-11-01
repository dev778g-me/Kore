package com.dev.kore.shared.components.display

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.dev.kore.components.separators.HorizontalDashedSeparator
import com.dev.kore.components.separators.HorizontalDottedDivider
import com.dev.kore.components.separators.HorizontalSeparator
import com.dev.kore.components.separators.VerticalDashedSeparator
import com.dev.kore.components.separators.VerticalDottedSeparator
import com.dev.kore.components.separators.VerticalSeparator
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme

@Composable
fun SeparatorsDemo() {
    DemoPage {
        DemoBlock(title = "Horizontal") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                Text("Solid", textStyle = KoreTheme.typography.label2)
                HorizontalSeparator(modifier = Modifier.fillMaxWidth())
                Text("Dashed", textStyle = KoreTheme.typography.label2)
                HorizontalDashedSeparator(modifier = Modifier.fillMaxWidth())
                Text("Dotted", textStyle = KoreTheme.typography.label2)
                HorizontalDottedDivider(modifier = Modifier.fillMaxWidth())
            }
        }

        DemoBlock(title = "Thickness") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                HorizontalSeparator(modifier = Modifier.fillMaxWidth(), thickness = 1.dp)
                HorizontalSeparator(modifier = Modifier.fillMaxWidth(), thickness = 3.dp)
                HorizontalSeparator(modifier = Modifier.fillMaxWidth(), thickness = 6.dp)
            }
        }

        DemoBlock(title = "Gradient") {
            HorizontalSeparator(
                modifier = Modifier.fillMaxWidth(),
                thickness = 4.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        KoreTheme.colorScheme.primary,
                        KoreTheme.colorScheme.complementary,
                    ),
                ),
            )
            HorizontalDashedSeparator(
                modifier = Modifier.fillMaxWidth().padding(top = KoreTheme.sizes.sm),
                thickness = 3.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        KoreTheme.colorScheme.success,
                        KoreTheme.colorScheme.error,
                    ),
                ),
            )
        }

        DemoBlock(title = "Vertical") {
            Row(
                modifier = Modifier.height(96.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
            ) {
                VerticalSeparator(modifier = Modifier.height(64.dp))
                Text("solid", textStyle = KoreTheme.typography.label2)
                VerticalDashedSeparator(modifier = Modifier.height(64.dp))
                Text("dashed", textStyle = KoreTheme.typography.label2)
                VerticalDottedSeparator(modifier = Modifier.height(64.dp))
                Text("dotted", textStyle = KoreTheme.typography.label2)
            }
        }

        DemoBlock(title = "In a list") {
            Column {
                listOf("Profile", "Settings", "Help").forEachIndexed { index, label ->
                    Text(
                        text = label,
                        textStyle = KoreTheme.typography.body1,
                        modifier = Modifier.padding(vertical = 12.dp),
                    )
                    if (index != 2) {
                        HorizontalSeparator(modifier = Modifier.fillMaxWidth())
                    }
                }
            }
        }
    }
}
