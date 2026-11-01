package com.dev.kore.shared.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.actions.actionsSection
import com.dev.kore.shared.components.display.displaySection
import com.dev.kore.shared.components.feedback.feedbackSection
import com.dev.kore.shared.components.inputs.inputsSection
import com.dev.kore.shared.components.navigation.navigationSection
import com.dev.kore.shared.components.overlays.overlaysSection
import com.dev.kore.shared.components.selection.selectionSection
import com.dev.kore.shared.components.utilities.utilitiesSection
import com.dev.kore.shared.screens.foundations.ColorsDemo
import com.dev.kore.shared.screens.foundations.IndicationDemo
import com.dev.kore.shared.screens.foundations.MotionDemo
import com.dev.kore.shared.screens.foundations.ShapesDemo
import com.dev.kore.shared.screens.foundations.SizesDemo
import com.dev.kore.shared.screens.foundations.TypographyDemo
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.HandTap
import com.phosphor.icons.regular.Palette
import com.phosphor.icons.regular.Ruler
import com.phosphor.icons.regular.Shapes
import com.phosphor.icons.regular.TextAa
import com.phosphor.icons.regular.Warning
import com.phosphor.icons.regular.Waveform

/**
 * One entry of the home screen list.
 *
 * @param id stable identifier used by the type safe navigation route.
 * @param title the name shown in the list and in the app bar of the screen.
 * @param description a sentence explaining what the component is for.
 * @param icon the leading icon of the list tile.
 * @param comingSoon entries that exist in Kore but are not implemented yet.
 * They are shown but cannot be opened.
 * @param demo the actual implementations of the component.
 */
data class ComponentEntry(
    val id: String,
    val title: String,
    val description: String,
    val icon: ImageVector,
    val comingSoon: Boolean = false,
    val demo: @Composable () -> Unit,
)

/**
 * A titled group of entries ("Actions", "Selection", ...).
 */
data class ComponentSection(
    val title: String,
    val entries: List<ComponentEntry>,
)

/**
 * The single source of truth of every component shipped by Kore.
 */
object ComponentCatalog {

    private val foundations = ComponentSection(
        title = "Foundations",
        entries = listOf(
            ComponentEntry(
                id = "colors",
                title = "Colors",
                description = "The semantic color roles of the active light or dark scheme.",
                icon = PhIcons.Regular.Palette,
            ) { ColorsDemo() },
            ComponentEntry(
                id = "typography",
                title = "Typography",
                description = "The fifteen type styles, from display to label.",
                icon = PhIcons.Regular.TextAa,
            ) { TypographyDemo() },
            ComponentEntry(
                id = "shapes",
                title = "Shapes",
                description = "The five corner shapes used across every component.",
                icon = PhIcons.Regular.Shapes,
            ) { ShapesDemo() },
            ComponentEntry(
                id = "sizes",
                title = "Sizes",
                description = "The spacing scale of the design system.",
                icon = PhIcons.Regular.Ruler,
            ) { SizesDemo() },
            ComponentEntry(
                id = "motion",
                title = "Motion",
                description = "The snappy, smooth, calm and fluid motion tiers.",
                icon = PhIcons.Regular.Waveform,
            ) { MotionDemo() },
            ComponentEntry(
                id = "indication",
                title = "Indication",
                description = "Ripple and scale press feedback, side by side.",
                icon = PhIcons.Regular.HandTap,
            ) { IndicationDemo() },
        ),
    )

    /**
     * Every section, in the order they are shown on the home screen.
     */
    val sections: List<ComponentSection> = listOf(
        foundations,
        actionsSection,
        selectionSection,
        inputsSection,
        feedbackSection,
        displaySection,
        navigationSection,
        overlaysSection,
        utilitiesSection,
    )

    private val byId: Map<String, ComponentEntry> =
        sections.flatMap { it.entries }.associateBy { it.id }

    /**
     * Resolves a route id, falling back to a "not found" screen so an old
     * deep link can never crash the app.
     */
    fun find(id: String): ComponentEntry = byId[id] ?: ComponentEntry(
        id = id,
        title = "Not found",
        description = "There is no component with the id \"$id\".",
        icon = PhIcons.Regular.Warning,
    ) {
        Text("Nothing to show here.")
    }
}
