package com.dev.kore.shared.components.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.navigationBar.NavigationBar
import com.dev.kore.components.navigationBar.NavigationBarItem
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Bell
import com.phosphor.icons.regular.House
import com.phosphor.icons.regular.MagnifyingGlass
import com.phosphor.icons.regular.User

@Composable
fun NavigationBarDemo() {
    val destinations = listOf(
        "Home" to PhIcons.Regular.House,
        "Search" to PhIcons.Regular.MagnifyingGlass,
        "Alerts" to PhIcons.Regular.Bell,
        "Profile" to PhIcons.Regular.User,
    )
    var selected by remember { mutableStateOf(0) }

    DemoPage {
        DemoBlock(title = "4 destinations") {
            NavigationBar {
                destinations.forEachIndexed { index, (label, icon) ->
                    NavigationBarItem(
                        selected = selected == index,
                        onClick = { selected = index },
                        icon = { Icon(icon, contentDescription = null) },
                        label = { Text(label) },
                    )
                }
            }
        }

        DemoBlock(title = "Disabled item") {
            NavigationBar {
                destinations.forEachIndexed { index, (label, icon) ->
                    NavigationBarItem(
                        selected = selected == index,
                        onClick = { selected = index },
                        icon = { Icon(icon, contentDescription = null) },
                        label = { Text(label) },
                        enabled = index != 1,
                    )
                }
            }
        }

        DemoBlock(title = "Custom container") {
            NavigationBar(containerColor = KoreTheme.colorScheme.surface) {
                destinations.take(3).forEachIndexed { index, (label, icon) ->
                    NavigationBarItem(
                        selected = selected == index,
                        onClick = { selected = index },
                        icon = { Icon(icon, contentDescription = null) },
                        label = { Text(label) },
                        indicatorShape = KoreTheme.shapes.xs,
                    )
                }
            }
        }

        DemoBlock(title = "Selected") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs)) {
                Text(
                    text = "selected = ${destinations[selected].first}",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
            }
        }
    }
}
