package com.dev.kore.shared.components.overlays

import com.dev.kore.shared.components.ComponentEntry
import com.dev.kore.shared.components.ComponentSection
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.CaretDoubleDown
import com.phosphor.icons.regular.ChatCircleDots
import com.phosphor.icons.regular.Question

val overlaysSection = ComponentSection(
    title = "Overlays",
    entries = listOf(
        ComponentEntry(
            id = "dialog",
            title = "Dialog",
            description = "A modal surface for a decision that needs full attention.",
            icon = PhIcons.Regular.ChatCircleDots,
        ) { DialogDemo() },
        ComponentEntry(
            id = "tooltip",
            title = "Tooltip",
            description = "A short hint shown on hover or long press.",
            icon = PhIcons.Regular.Question,
        ) { TooltipDemo() },
        ComponentEntry(
            id = "bottom-sheet",
            title = "Bottom sheet",
            description = "A sheet sliding up from the bottom edge. Coming soon.",
            icon = PhIcons.Regular.CaretDoubleDown,
            comingSoon = true,
        ) { },
    ),
)
