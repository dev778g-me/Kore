package com.dev.codesamples.samples.accordion

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.dev.kore.components.accordion.Accordion
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.bold.CaretDownBold

// <sample id="accordion-custom-padding">
@Composable
fun CustomPaddingAccordionSample() {
    var showAccordion by remember { mutableStateOf(false) }
    Accordion(
        expanded = showAccordion,
        onExpand = { showAccordion = !showAccordion },
        headerContentPaddingValues = PaddingValues(horizontal = 20.dp, vertical = 16.dp),
        expandedContentPaddingValues = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
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
