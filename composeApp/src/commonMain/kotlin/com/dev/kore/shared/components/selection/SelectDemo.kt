package com.dev.kore.shared.components.selection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.select.Select
import com.dev.kore.components.select.SelectGroup
import com.dev.kore.components.select.SelectGroupItem
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.CaretDown
import com.phosphor.icons.regular.Globe

@Composable
fun SelectDemo() {
    val fruits = listOf("Apple", "Banana", "Cherry", "Dragon fruit", "Elderberry")
    var selected by remember { mutableStateOf(0) }
    var expanded by remember { mutableStateOf(false) }

    var timezone by remember { mutableStateOf("UTC+05:30") }
    var timezoneExpanded by remember { mutableStateOf(false) }
    val timezones = listOf("UTC-08:00", "UTC+00:00", "UTC+05:30", "UTC+09:00")

    DemoPage {
        DemoBlock(title = "Basic") {
            Select(
                expanded = expanded,
                onExpandedChange = { expanded = true },
                onDismissRequest = { expanded = false },
                modifier = Modifier.width(240.dp),
                trailingContent = {
                    Icon(PhIcons.Regular.CaretDown, contentDescription = null)
                },
                menuContent = {
                    SelectGroup {
                        fruits.forEachIndexed { index, fruit ->
                            SelectGroupItem(
                                selected = selected == index,
                                onClick = {
                                    selected = index
                                    expanded = false
                                },
                            ) {
                                Text(fruit)
                            }
                        }
                    }
                },
            ) {
                Text(fruits[selected])
            }
        }

        DemoBlock(title = "With leading icon") {
            Select(
                expanded = timezoneExpanded,
                onExpandedChange = { timezoneExpanded = true },
                onDismissRequest = { timezoneExpanded = false },
                modifier = Modifier.width(240.dp),
                leadingContent = {
                    Icon(PhIcons.Regular.Globe, contentDescription = null)
                },
                trailingContent = {
                    Icon(PhIcons.Regular.CaretDown, contentDescription = null)
                },
                menuContent = {
                    SelectGroup {
                        timezones.forEach { zone ->
                            SelectGroupItem(
                                selected = timezone == zone,
                                onClick = {
                                    timezone = zone
                                    timezoneExpanded = false
                                },
                            ) {
                                Text(zone)
                            }
                        }
                    }
                },
            ) {
                Text(timezone)
            }
        }

        DemoBlock(title = "Disabled") {
            Select(
                expanded = false,
                onExpandedChange = {},
                onDismissRequest = {},
                modifier = Modifier.width(240.dp),
                enabled = false,
                trailingContent = {
                    Icon(PhIcons.Regular.CaretDown, contentDescription = null)
                },
                menuContent = {},
            ) {
                Text("Disabled select")
            }
        }

        DemoBlock(title = "Error") {
            Select(
                expanded = false,
                onExpandedChange = {},
                onDismissRequest = {},
                modifier = Modifier.width(240.dp),
                error = true,
                trailingContent = {
                    Icon(PhIcons.Regular.CaretDown, contentDescription = null)
                },
                menuContent = {},
            ) {
                Text("Pick a required value")
            }
        }

        DemoBlock(title = "Options") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs)) {
                fruits.forEachIndexed { index, fruit ->
                    Text(
                        text = if (index == selected) "✓ $fruit" else fruit,
                        textStyle = KoreTheme.typography.body3,
                        color = if (index == selected) {
                            KoreTheme.colorScheme.primary
                        } else {
                            KoreTheme.colorScheme.onBackGroundVariant
                        },
                    )
                }
            }
        }
    }
}
