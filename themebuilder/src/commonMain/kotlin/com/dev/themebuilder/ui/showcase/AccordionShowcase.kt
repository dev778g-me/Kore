package com.dev.themebuilder.ui.showcase

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dev.kore.components.accordion.Accordion
import com.dev.kore.components.card.Card
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.CaretDown

@Composable
fun AccordionShowcase(
    modifier: Modifier = Modifier
) {
    // State for each accordion item
    var showAccordion1 by rememberSaveable { mutableStateOf(false) }
    var showAccordion2 by rememberSaveable { mutableStateOf(true) }
    var showAccordion3 by rememberSaveable { mutableStateOf(false) }

    // Smooth rotation animations for the icons
    val rotation1 by animateFloatAsState(targetValue = if (showAccordion1) 180f else 0f, label = "caret1")
    val rotation2 by animateFloatAsState(targetValue = if (showAccordion2) 180f else 0f, label = "caret2")
    val rotation3 by animateFloatAsState(targetValue = if (showAccordion3) 180f else 0f, label = "caret3")

    // A single Card wrapping all items
    Card(
        modifier = modifier
            .fillMaxWidth()

    ) {
        Text(
            text = "Space Anomalies FAQ",
            fontWeight = FontWeight.Bold,
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )
            Accordion(
                expanded = showAccordion1,
                onExpand = { showAccordion1 = !showAccordion1 },
                header = {
                    Text("What lies at the center of most galaxies?")
                },
                expandedContent = {
                    Text("Millions to billions of times the mass of our Sun, supermassive black holes reside at the center of almost every large galaxy. Their gravitational pull is so intense that nothing, not even light, can escape past their event horizon.")
                },
                trailingIcon = {
                    Icon(
                        modifier = Modifier.graphicsLayer { rotationZ = rotation1 },
                        imageVector = PhIcons.Regular.CaretDown,
                        contentDescription = if (showAccordion1) "Collapse" else "Expand"
                    )
                }
            )

            Accordion(
                expanded = showAccordion2,
                onExpand = { showAccordion2 = !showAccordion2 },
                header = {
                    Text("Just how dense is a Neutron Star?")
                },
                expandedContent = {
                    Text("They are the ultra-dense collapsed cores of massive supergiant stars. Just a single teaspoon of neutron star material would weigh around a billion tons on Earth. They spin incredibly fast, sometimes emitting pulses of radiation hundreds of times per second.")
                },
                trailingIcon = {
                    Icon(
                        modifier = Modifier.graphicsLayer { rotationZ = rotation2 },
                        imageVector = PhIcons.Regular.CaretDown,
                        contentDescription = if (showAccordion2) "Collapse" else "Expand"
                    )
                }
            )


            Accordion(
                expanded = showAccordion3,
                onExpand = { showAccordion3 = !showAccordion3 },
                header = {
                    Text("Can a planet survive without a star?")
                },
                expandedContent = {
                    Text("Yes, these are known as rogue planets. They are planetary-mass objects that do not orbit a star. Instead, they drift aimlessly through the freezing darkness of galactic space, having been violently ejected from the solar systems in which they formed.")
                },
                trailingIcon = {
                    Icon(
                        modifier = Modifier.graphicsLayer { rotationZ = rotation3 },
                        imageVector = PhIcons.Regular.CaretDown,
                        contentDescription = if (showAccordion3) "Collapse" else "Expand"
                    )
                }
            )
        }
    }
