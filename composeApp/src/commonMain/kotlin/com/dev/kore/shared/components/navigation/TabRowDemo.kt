package com.dev.kore.shared.components.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.tabRow.ScrollableTabRow
import com.dev.kore.components.tabRow.Tab
import com.dev.kore.components.tabRow.TabRow
import com.dev.kore.components.tabRow.TabVariant
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Alarm
import com.phosphor.icons.regular.Bell
import com.phosphor.icons.regular.Clock
import com.phosphor.icons.regular.House
import com.phosphor.icons.regular.User

@Composable
fun TabRowDemo() {
    var primaryIndex by remember { mutableStateOf(0) }
    var surfaceIndex by remember { mutableStateOf(1) }
    var scrollableIndex by remember { mutableStateOf(0) }
    var iconIndex by remember { mutableStateOf(0) }

    val sections = listOf("Overview", "Activity", "Settings")
    val manySections = listOf("All", "Music", "Podcasts", "Audiobooks", "Live", "Downloads")
    val iconSections = listOf("Home" to PhIcons.Regular.House, "Alarms" to PhIcons.Regular.Alarm, "Profile" to PhIcons.Regular.User)

    DemoPage {
        DemoBlock(title = "Primary") {
            TabRow(
                selectedIndex = primaryIndex,
                variant = TabVariant.Primary,
                tabs = {
                    sections.forEachIndexed { index, label ->
                        Tab(
                            isSelected = primaryIndex == index,
                            onClick = { primaryIndex = index },
                            content = { Text(label) },
                        )
                    }
                },
            )
        }

        DemoBlock(title = "Surface") {
            TabRow(
                selectedIndex = surfaceIndex,
                variant = TabVariant.Surface,
                tabs = {
                    sections.forEachIndexed { index, label ->
                        Tab(
                            isSelected = surfaceIndex == index,
                            onClick = { surfaceIndex = index },
                            content = { Text(label) },
                        )
                    }
                },
            )
        }

        DemoBlock(title = "With icons") {
            TabRow(
                selectedIndex = iconIndex,
                variant = TabVariant.Surface,
                tabs = {
                    iconSections.forEachIndexed { index, (label, icon) ->
                        Tab(
                            isSelected = iconIndex == index,
                            onClick = { iconIndex = index },
                            icon = { Icon(icon, contentDescription = null) },
                            content = { Text(label) },
                        )
                    }
                },
            )
        }

        DemoBlock(title = "Scrollable") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                ScrollableTabRow(
                    selectedIndex = scrollableIndex,
                    variant = TabVariant.Primary,
                    tabs = {
                        manySections.forEachIndexed { index, label ->
                            Tab(
                                isSelected = scrollableIndex == index,
                                onClick = { scrollableIndex = index },
                                content = { Text(label) },
                            )
                        }
                    },
                )
                ScrollableTabRow(
                    selectedIndex = scrollableIndex,
                    variant = TabVariant.Surface,
                    tabs = {
                        manySections.forEachIndexed { index, label ->
                            Tab(
                                isSelected = scrollableIndex == index,
                                onClick = { scrollableIndex = index },
                                content = { Text(label) },
                            )
                        }
                    },
                )
            }
        }

        DemoBlock(title = "Selected") {
            Text(
                text = "primary = ${sections[primaryIndex]} · surface = ${sections[surfaceIndex]} · scrollable = ${manySections[scrollableIndex]}",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
        }
    }
}
