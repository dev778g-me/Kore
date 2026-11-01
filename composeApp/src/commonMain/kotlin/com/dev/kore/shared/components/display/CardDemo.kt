package com.dev.kore.shared.components.display

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.card.Card
import com.dev.kore.components.card.OutlinedCard
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.NotePencil
import com.phosphor.icons.regular.Quotes

@Composable
fun CardDemo() {
    DemoPage {
        DemoBlock(title = "Filled") {
            Card(modifier = Modifier.fillMaxWidth()) {
                Text("Kore", textStyle = KoreTheme.typography.title1)
                Text(
                    text = "A design system built with Compose Multiplatform.",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onSurface,
                )
            }
        }

        DemoBlock(title = "Outlined") {
            OutlinedCard(modifier = Modifier.fillMaxWidth()) {
                Text("Outlined card", textStyle = KoreTheme.typography.title2)
                Text(
                    text = "The border replaces the elevation.",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onSurface,
                )
            }
        }

        DemoBlock(title = "Shapes") {
            Row(horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                Card(
                    modifier = Modifier.size(96.dp),
                    shape = KoreTheme.shapes.sm,
                ) {
                    Text("sm", textStyle = KoreTheme.typography.label2)
                }
                Card(
                    modifier = Modifier.size(96.dp),
                    shape = KoreTheme.shapes.md,
                ) {
                    Text("md", textStyle = KoreTheme.typography.label2)
                }
                Card(
                    modifier = Modifier.size(96.dp),
                    shape = KoreTheme.shapes.lg,
                ) {
                    Text("lg", textStyle = KoreTheme.typography.label2)
                }
            }
        }

        DemoBlock(title = "With content padding") {
            Card(
                modifier = Modifier.fillMaxWidth(),
                contentPaddingValues = androidx.compose.foundation.layout.PaddingValues(24.dp),
            ) {
                Text("Generous padding", textStyle = KoreTheme.typography.title2)
                Text(
                    text = "contentPaddingValues controls the inset of the whole card.",
                    textStyle = KoreTheme.typography.body3,
                )
            }
        }

        DemoBlock(title = "Clickable") {
            Card(modifier = Modifier.fillMaxWidth().clickable(onClick = {})) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
                ) {
                    Icon(PhIcons.Regular.NotePencil, contentDescription = null)
                    Column {
                        Text("Open the editor", textStyle = KoreTheme.typography.title3)
                        Text(
                            text = "Cards can wrap a single tappable action.",
                            textStyle = KoreTheme.typography.body3,
                            color = KoreTheme.colorScheme.onSurface,
                        )
                    }
                }
            }
        }

        DemoBlock(title = "Quote card") {
            Card(
                modifier = Modifier.fillMaxWidth(),
                containerColor = KoreTheme.colorScheme.primaryContainer,
                contentColor = KoreTheme.colorScheme.onPrimaryContainer,
            ) {
                Icon(PhIcons.Regular.Quotes, contentDescription = null)
                Text(
                    text = "Simple is not easy.",
                    textStyle = KoreTheme.typography.heading3,
                    color = KoreTheme.colorScheme.onPrimaryContainer,
                )
                Text(
                    text = "— Someone",
                    textStyle = KoreTheme.typography.label2,
                    color = KoreTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }
        }
    }
}
