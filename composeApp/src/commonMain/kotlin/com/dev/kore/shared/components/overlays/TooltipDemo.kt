package com.dev.kore.shared.components.overlays

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.components.tooltip.Tooltip
import com.dev.kore.components.tooltip.TooltipPositions
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Copy
import com.phosphor.icons.regular.Gear
import com.phosphor.icons.regular.Heart

@Composable
fun TooltipDemo() {
    DemoPage {
        DemoBlock(title = "Above an icon button") {
            Tooltip(
                tooltipContent = { Text("Copy link") },
                position = TooltipPositions.Top,
            ) {
                GhostIconButton(onClick = {}) {
                    Icon(PhIcons.Regular.Copy, contentDescription = "Copy link")
                }
            }
        }

        DemoBlock(title = "Below a button") {
            Tooltip(
                tooltipContent = { Text("This action cannot be undone") },
                position = TooltipPositions.Bottom,
            ) {
                PrimaryButton(onClick = {}) {
                    Text("Delete")
                }
            }
        }

        DemoBlock(title = "Around plain content") {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs),
            ) {
                Tooltip(
                    tooltipContent = { Text("Liked by 128 people") },
                ) {
                    Icon(
                        imageVector = PhIcons.Regular.Heart,
                        contentDescription = "Like",
                        modifier = Modifier.padding(4.dp),
                    )
                }
                Tooltip(
                    tooltipContent = { Text("Open settings") },
                ) {
                    Icon(
                        imageVector = PhIcons.Regular.Gear,
                        contentDescription = "Settings",
                        modifier = Modifier.padding(4.dp),
                    )
                }
            }
        }

        DemoBlock(title = "Custom surface") {
            Tooltip(
                tooltipContent = { Text("Primary colored tooltip") },
                containerColor = KoreTheme.colorScheme.primary,
                contentColor = KoreTheme.colorScheme.onPrimary,
                shape = KoreTheme.shapes.sm,
                position = TooltipPositions.Top,
            ) {
                VariantRow {
                    PrimaryButton(onClick = {}) {
                        Text("Hover me")
                    }
                }
            }
        }

        DemoBlock(title = "How to trigger") {
            Text(
                text = "Hover with a mouse, or long press on a touch screen. The tooltip stays visible " +
                    "for a moment after the pointer leaves.",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
        }
    }
}
