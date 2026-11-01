package com.dev.kore.shared.components.selection

import com.dev.kore.shared.components.ComponentEntry
import com.dev.kore.shared.components.ComponentSection
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.CaretDown
import com.phosphor.icons.regular.CheckSquare
import com.phosphor.icons.regular.RadioButton
import com.phosphor.icons.regular.SlidersHorizontal
import com.phosphor.icons.regular.SquareSplitHorizontal
import com.phosphor.icons.regular.Tag
import com.phosphor.icons.regular.ToggleLeft

val selectionSection = ComponentSection(
    title = "Selection",
    entries = listOf(
        ComponentEntry(
            id = "checkbox",
            title = "Checkbox",
            description = "An independent on/off choice, alone or in a list.",
            icon = PhIcons.Regular.CheckSquare,
        ) { CheckBoxDemo() },
        ComponentEntry(
            id = "radio-button",
            title = "Radio button",
            description = "A single choice between mutually exclusive options.",
            icon = PhIcons.Regular.RadioButton,
        ) { RadioButtonDemo() },
        ComponentEntry(
            id = "switch",
            title = "Switch",
            description = "An immediate on/off toggle for a setting.",
            icon = PhIcons.Regular.ToggleLeft,
        ) { SwitchDemo() },
        ComponentEntry(
            id = "select",
            title = "Select",
            description = "A dropdown that opens a grouped list of options.",
            icon = PhIcons.Regular.CaretDown,
        ) { SelectDemo() },
        ComponentEntry(
            id = "segmented-button",
            title = "Segmented button",
            description = "Closely related choices arranged in one row.",
            icon = PhIcons.Regular.SquareSplitHorizontal,
        ) { SegmentedButtonDemo() },
        ComponentEntry(
            id = "filter-chip",
            title = "Filter chip",
            description = "A compact, multi selectable filter.",
            icon = PhIcons.Regular.Tag,
        ) { FilterChipDemo() },
        ComponentEntry(
            id = "slider",
            title = "Slider",
            description = "Picks a value from a continuous range.",
            icon = PhIcons.Regular.SlidersHorizontal,
        ) { SliderDemo() },
    ),
)
