package com.dev.kore.shared.components.display

import com.dev.kore.shared.components.ComponentEntry
import com.dev.kore.shared.components.ComponentSection
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.CardsThree
import com.phosphor.icons.regular.Images
import com.phosphor.icons.regular.ListDashes
import com.phosphor.icons.regular.Minus
import com.phosphor.icons.regular.Pill
import com.phosphor.icons.regular.Stack
import com.phosphor.icons.regular.Star
import com.phosphor.icons.regular.TextT
import com.phosphor.icons.regular.UserCircle

val displaySection = ComponentSection(
    title = "Display",
    entries = listOf(
        ComponentEntry(
            id = "text",
            title = "Text",
            description = "Labels and paragraphs, with weights, colors and decorations.",
            icon = PhIcons.Regular.TextT,
        ) { TextDemo() },
        ComponentEntry(
            id = "list-tile",
            title = "List tile",
            description = "A single row of leading, title, subtitle and trailing content.",
            icon = PhIcons.Regular.ListDashes,
        ) { ListTileDemo() },
        ComponentEntry(
            id = "icon",
            title = "Icon",
            description = "A tinted vector glyph sized by its modifier.",
            icon = PhIcons.Regular.Star,
        ) { IconDemo() },
        ComponentEntry(
            id = "card",
            title = "Card",
            description = "A surface grouping related content, filled or outlined.",
            icon = PhIcons.Regular.CardsThree,
        ) { CardDemo() },
        ComponentEntry(
            id = "avatar",
            title = "Avatar",
            description = "A profile image or initials with an optional badge.",
            icon = PhIcons.Regular.UserCircle,
        ) { AvatarDemo() },
        ComponentEntry(
            id = "action-chip",
            title = "Action chip",
            description = "A compact button for secondary actions.",
            icon = PhIcons.Regular.Pill,
        ) { ActionChipDemo() },
        ComponentEntry(
            id = "accordion",
            title = "Accordion",
            description = "Expandable sections that reveal content on demand.",
            icon = PhIcons.Regular.ListDashes,
        ) { AccordionDemo() },
        ComponentEntry(
            id = "carousel",
            title = "Carousel",
            description = "A swipeable pager of related content.",
            icon = PhIcons.Regular.Images,
        ) { CarouselDemo() },
        ComponentEntry(
            id = "stack",
            title = "Stack",
            description = "Vertical and horizontal stacks with consistent spacing.",
            icon = PhIcons.Regular.Stack,
        ) { StackDemo() },
        ComponentEntry(
            id = "separators",
            title = "Separators",
            description = "Solid, dashed, dotted and gradient dividers.",
            icon = PhIcons.Regular.Minus,
        ) { SeparatorsDemo() },
    ),
)
