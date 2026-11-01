package com.dev.kore.shared.components.navigation

import com.dev.kore.shared.components.ComponentEntry
import com.dev.kore.shared.components.ComponentSection
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.AppWindow
import com.phosphor.icons.regular.DotsThree
import com.phosphor.icons.regular.NavigationArrow
import com.phosphor.icons.regular.Tabs

val navigationSection = ComponentSection(
    title = "Navigation",
    entries = listOf(
        ComponentEntry(
            id = "app-bar",
            title = "App bar",
            description = "The top bar with a title, navigation icon and actions.",
            icon = PhIcons.Regular.AppWindow,
        ) { AppBarDemo() },
        ComponentEntry(
            id = "tab-row",
            title = "Tab row",
            description = "Switches panels of the same screen, scrollable when needed.",
            icon = PhIcons.Regular.Tabs,
        ) { TabRowDemo() },
        ComponentEntry(
            id = "navigation-bar",
            title = "Navigation bar",
            description = "Bottom navigation between top level destinations.",
            icon = PhIcons.Regular.NavigationArrow,
        ) { NavigationBarDemo() },
        ComponentEntry(
            id = "page-indicator",
            title = "Page indicator",
            description = "Dots that show the position inside a pager.",
            icon = PhIcons.Regular.DotsThree,
        ) { PageIndicatorDemo() },
    ),
)
