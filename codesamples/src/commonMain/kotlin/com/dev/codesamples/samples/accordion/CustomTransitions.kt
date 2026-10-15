package com.dev.codesamples.samples.accordion

import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.accordion.Accordion
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.bold.CaretDownBold

// <sample id="accordion-custom-transitions">
@Composable
fun CustomTransitionsAccordionSample() {
    var showAccordion by remember { mutableStateOf(false) }
    Accordion(
        expanded = showAccordion,
        onExpand = { showAccordion = !showAccordion },
        enterTransition = expandVertically(animationSpec = tween(400)),
        exitTransition = shrinkVertically(animationSpec = tween(400)),
        header = { Text("Octopuses have three hearts and blue blood") },
        expandedContent = {
            Text("Two hearts pump blood to the gills, while the third pumps it to the rest of the body.")
        },
        trailingIcon = {
            Icon(imageVector = PhIcons.Bold.CaretDownBold, contentDescription = null)
        }
    )
}
// <sample/>
