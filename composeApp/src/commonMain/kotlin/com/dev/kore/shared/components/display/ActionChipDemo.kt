package com.dev.kore.shared.components.display

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.chip.ActionChip
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.ArrowRight
import com.phosphor.icons.regular.Calendar
import com.phosphor.icons.regular.MapPin
import com.phosphor.icons.regular.Plus

@Composable
fun ActionChipDemo() {
    DemoPage {
        DemoBlock(title = "Basic") {
            VariantRow {
                ActionChip(onClick = {}) { Text("Action") }
                ActionChip(onClick = {}) { Text("Another") }
            }
        }

        DemoBlock(title = "With leading icon") {
            VariantRow {
                ActionChip(
                    onClick = {},
                    leadingIcon = {
                        Icon(
                            imageVector = PhIcons.Regular.Plus,
                            contentDescription = null,
                            modifier = Modifier.padding(end = 4.dp),
                        )
                    },
                ) {
                    Text("Add")
                }
                ActionChip(
                    onClick = {},
                    leadingIcon = {
                        Icon(
                            imageVector = PhIcons.Regular.Calendar,
                            contentDescription = null,
                            modifier = Modifier.padding(end = 4.dp),
                        )
                    },
                ) {
                    Text("Today")
                }
                ActionChip(
                    onClick = {},
                    leadingIcon = {
                        Icon(
                            imageVector = PhIcons.Regular.MapPin,
                            contentDescription = null,
                            modifier = Modifier.padding(end = 4.dp),
                        )
                    },
                ) {
                    Text("Nearby")
                }
            }
        }

        DemoBlock(title = "With trailing icon") {
            ActionChip(
                onClick = {},
                trailingIcon = {
                    Icon(
                        imageVector = PhIcons.Regular.ArrowRight,
                        contentDescription = null,
                        modifier = Modifier.padding(start = 4.dp),
                    )
                },
            ) {
                Text("Open")
            }
        }

        DemoBlock(title = "Shapes") {
            VariantRow {
                ActionChip(onClick = {}, shape = KoreTheme.shapes.xs) { Text("xs") }
                ActionChip(onClick = {}, shape = KoreTheme.shapes.md) { Text("md") }
                ActionChip(onClick = {}, shape = KoreTheme.shapes.xl) { Text("xl") }
            }
        }

        DemoBlock(title = "Elevated") {
            ActionChip(
                onClick = {},
                elevation = 8.dp,
            ) {
                Text("Elevated")
            }
        }
    }
}
