package com.dev.kore.shared.components.actions

import com.dev.kore.shared.components.ComponentEntry
import com.dev.kore.shared.components.ComponentSection
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Cursor
import com.phosphor.icons.regular.CursorClick
import com.phosphor.icons.regular.DotsThreeCircle
import com.phosphor.icons.regular.Link
import com.phosphor.icons.regular.PlusCircle
import com.phosphor.icons.regular.PlusSquare

val actionsSection = ComponentSection(
    title = "Actions",
    entries = listOf(
        ComponentEntry(
            id = "buttons",
            title = "Buttons",
            description = "Primary, secondary, outlined and ghost buttons in every state.",
            icon = PhIcons.Regular.CursorClick,
        ) { ButtonsDemo() },
        ComponentEntry(
            id = "icon-buttons",
            title = "Icon buttons",
            description = "Square and circular buttons that only hold an icon.",
            icon = PhIcons.Regular.Cursor,
        ) { IconButtonsDemo() },
        ComponentEntry(
            id = "link-button",
            title = "Link button",
            description = "A clickable span inside a paragraph of text.",
            icon = PhIcons.Regular.Link,
        ) { LinkButtonDemo() },
        ComponentEntry(
            id = "floating-action-button",
            title = "Floating action button",
            description = "The elevated action anchored to the corner of a screen.",
            icon = PhIcons.Regular.PlusCircle,
        ) { FloatingActionButtonDemo() },
        ComponentEntry(
            id = "split-floating-action-button",
            title = "Split FAB",
            description = "A floating action button split into several stacked actions.",
            icon = PhIcons.Regular.PlusSquare,
        ) { SplitFloatingActionButtonDemo() },
        ComponentEntry(
            id = "button-group",
            title = "Button group",
            description = "Segmented actions and toggles living in one surface.",
            icon = PhIcons.Regular.DotsThreeCircle,
        ) { ButtonGroupDemo() },
    ),
)
