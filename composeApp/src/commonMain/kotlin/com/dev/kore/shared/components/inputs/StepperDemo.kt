package com.dev.kore.shared.components.inputs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.stepper.Stepper
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Minus
import com.phosphor.icons.regular.Plus

@Composable
fun StepperDemo() {
    var quantity by remember { mutableStateOf(1) }
    var guests by remember { mutableStateOf(2) }
    var rating by remember { mutableStateOf(3) }

    DemoPage {
        DemoBlock(title = "Basic") {
            Stepper(
                label = {
                    Text(
                        text = quantity.toString(),
                        textStyle = KoreTheme.typography.heading3,
                    )
                },
                decrementButton = {
                    GhostIconButton(
                        onClick = { if (quantity > 1) quantity-- },
                        enabled = quantity > 1,
                    ) {
                        Icon(PhIcons.Regular.Minus, contentDescription = "Decrease")
                    }
                },
                incrementIcon = {
                    GhostIconButton(onClick = { quantity++ }) {
                        Icon(PhIcons.Regular.Plus, contentDescription = "Increase")
                    }
                },
            )
        }

        DemoBlock(title = "With a label and a max") {
            Stepper(
                label = {
                    Text(
                        text = "$guests guests",
                        textStyle = KoreTheme.typography.title3,
                    )
                },
                decrementButton = {
                    GhostIconButton(
                        onClick = { if (guests > 0) guests-- },
                        enabled = guests > 0,
                    ) {
                        Icon(PhIcons.Regular.Minus, contentDescription = "Remove guest")
                    }
                },
                incrementIcon = {
                    GhostIconButton(
                        onClick = { if (guests < 8) guests++ },
                        enabled = guests < 8,
                    ) {
                        Icon(PhIcons.Regular.Plus, contentDescription = "Add guest")
                    }
                },
            )
        }

        DemoBlock(title = "Bordered, without separators") {
            Stepper(
                label = {
                    Text(
                        text = "★".repeat(rating),
                        textStyle = KoreTheme.typography.title2,
                    )
                },
                decrementButton = {
                    GhostIconButton(onClick = { if (rating > 1) rating-- }) {
                        Icon(PhIcons.Regular.Minus, contentDescription = "Less")
                    }
                },
                incrementIcon = {
                    GhostIconButton(onClick = { if (rating < 5) rating++ }) {
                        Icon(PhIcons.Regular.Plus, contentDescription = "More")
                    }
                },
                separator = false,
                border = BorderStroke(
                    width = 1.dp,
                    color = KoreTheme.colorScheme.backGroundVariant,
                ),
                shape = KoreTheme.shapes.xl,
            )
        }

        DemoBlock(title = "Compact stack") {
            VariantRow {
                Stepper(
                    label = { Text("1") },
                    decrementButton = {
                        GhostIconButton(onClick = {}) {
                            Icon(PhIcons.Regular.Minus, contentDescription = null)
                        }
                    },
                    incrementIcon = {
                        GhostIconButton(onClick = {}) {
                            Icon(PhIcons.Regular.Plus, contentDescription = null)
                        }
                    },
                    shape = KoreTheme.shapes.xs,
                )
                Stepper(
                    label = { Text("2") },
                    decrementButton = {
                        GhostIconButton(onClick = {}) {
                            Icon(PhIcons.Regular.Minus, contentDescription = null)
                        }
                    },
                    incrementIcon = {
                        GhostIconButton(onClick = {}) {
                            Icon(PhIcons.Regular.Plus, contentDescription = null)
                        }
                    },
                    shape = KoreTheme.shapes.xs,
                )
            }
        }
    }
}
