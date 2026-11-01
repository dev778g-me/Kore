package com.dev.kore.shared.components.utilities

import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.ComponentEntry
import com.dev.kore.shared.components.ComponentSection
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Wrench

val utilitiesSection = ComponentSection(
    title = "Utilities",
    entries = listOf(
        ComponentEntry(
            id = "modifiers",
            title = "Modifiers",
            description = "Press feedback, borders, grids, fading edges and magnetic pull.",
            icon = PhIcons.Regular.Wrench,
        ) { Text("Modifiers") },
    ),
)
