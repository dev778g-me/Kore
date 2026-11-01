package com.dev.kore.shared.components.feedback

import com.dev.kore.shared.components.ComponentEntry
import com.dev.kore.shared.components.ComponentSection
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Hourglass
import com.phosphor.icons.regular.SealCheck
import com.phosphor.icons.regular.Sparkle
import com.phosphor.icons.regular.Spinner

val feedbackSection = ComponentSection(
    title = "Feedback",
    entries = listOf(
        ComponentEntry(
            id = "loading-indicator",
            title = "Loading indicator",
            description = "Indeterminate feedback while work of unknown length runs.",
            icon = PhIcons.Regular.Spinner,
        ) { LoadingIndicatorDemo() },
        ComponentEntry(
            id = "progress-indicator",
            title = "Progress indicator",
            description = "Determinate feedback for measurable work.",
            icon = PhIcons.Regular.Hourglass,
        ) { ProgressIndicatorDemo() },
        ComponentEntry(
            id = "badge",
            title = "Badge",
            description = "A small status label for an item.",
            icon = PhIcons.Regular.SealCheck,
        ) { BadgeDemo() },
        ComponentEntry(
            id = "shimmer",
            title = "Shimmer",
            description = "Skeleton placeholders that shimmer while content loads.",
            icon = PhIcons.Regular.Sparkle,
        ) { ShimmerDemo() },
    ),
)
