package com.dev.kore.shared.components.selection

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.chip.FilterChip
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Check
import com.phosphor.icons.regular.X

@Composable
fun FilterChipDemo() {
    val options = listOf("Design", "Engineering", "Marketing", "Sales")
    val selectedOptions = remember { mutableStateListOf("Design") }

    DemoPage {
        DemoBlock(title = "Filter list") {
            VariantRow {
                options.forEach { option ->
                    val isSelected = selectedOptions.contains(option)
                    FilterChip(
                        selected = isSelected,
                        onClick = {
                            if (isSelected) {
                                selectedOptions.remove(option)
                            } else {
                                selectedOptions.add(option)
                            }
                        },
                        label = { Text(option) },
                        leadingIcon = if (isSelected) {
                            {
                                Icon(
                                    imageVector = PhIcons.Regular.Check,
                                    contentDescription = null,
                                    modifier = Modifier.padding(end = 4.dp),
                                )
                            }
                        } else {
                            null
                        },
                    )
                }
            }
        }

        DemoBlock(title = "With trailing icon") {
            VariantRow {
                FilterChip(
                    selected = true,
                    onClick = {},
                    label = { Text("Clear") },
                    trailingIcon = {
                        Icon(
                            imageVector = PhIcons.Regular.X,
                            contentDescription = null,
                            modifier = Modifier.padding(start = 4.dp),
                        )
                    },
                )
                FilterChip(
                    selected = false,
                    onClick = {},
                    label = { Text("Muted") },
                )
            }
        }

        DemoBlock(title = "Disabled") {
            VariantRow {
                FilterChip(
                    selected = true,
                    onClick = {},
                    enabled = false,
                    label = { Text("Disabled selected") },
                )
                FilterChip(
                    selected = false,
                    onClick = {},
                    enabled = false,
                    label = { Text("Disabled") },
                )
            }
        }

        DemoBlock(title = "Live value") {
            Text(
                text = "selected = ${selectedOptions.joinToString().ifEmpty { "none" }}",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
        }
    }
}
