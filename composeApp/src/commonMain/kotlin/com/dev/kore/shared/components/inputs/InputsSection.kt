package com.dev.kore.shared.components.inputs

import com.dev.kore.shared.components.ComponentEntry
import com.dev.kore.shared.components.ComponentSection
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.CaretCircleDown
import com.phosphor.icons.regular.NumberCircleOne
import com.phosphor.icons.regular.Textbox

val inputsSection = ComponentSection(
    title = "Inputs",
    entries = listOf(
        ComponentEntry(
            id = "text-field",
            title = "Text field",
            description = "Free text input with labels, icons and validation.",
            icon = PhIcons.Regular.Textbox,
        ) { TextFieldDemo() },
        ComponentEntry(
            id = "dropdown",
            title = "Dropdown",
            description = "A temporary menu of actions anchored to a trigger.",
            icon = PhIcons.Regular.CaretCircleDown,
        ) { DropdownDemo() },
        ComponentEntry(
            id = "stepper",
            title = "Stepper",
            description = "A numeric value adjusted with decrement and increment buttons.",
            icon = PhIcons.Regular.NumberCircleOne,
        ) { StepperDemo() },
    ),
)
