package com.dev.kore.shared.screens.foundations

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dev.kore.components.segmentedButton.SegmentedButtonItem
import com.dev.kore.components.segmentedButton.SingleChoiceSegmentedButtonRow
import com.dev.kore.components.slider.Slider
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.theme.LocalAppSettings
import com.dev.kore.themes.IndicationType
import com.dev.kore.themes.KoreTheme

/**
 * The acceptance test of the press indication: ripple and scale, live.
 *
 * The segmented button at the top changes the whole app. The side by side row overrides
 * the indication locally so both can be compared without leaving the screen,
 * and the slider tunes the pressed scale.
 */
@Composable
fun IndicationDemo() {
    val settings = LocalAppSettings.current

    DemoPage {
        DemoBlock(title = "App indication") {
            SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
                IndicationType.entries.forEachIndexed { index, type ->
                    SegmentedButtonItem(
                        selected = type == settings.indicationType,
                        onSelected = { settings.onIndicationChange(type) },
                        index = index,
                        itemCount = IndicationType.entries.size,
                    ) {
                        Text(type.name)
                    }
                }
            }
        }

        DemoBlock(title = "Side by side") {
            Row(horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                IndicationType.entries.forEach { type ->
                    ScopedIndication(
                        type = type,
                        pressScale = settings.pressScale,
                        modifier = Modifier.weight(1f),
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs)) {
                            Text(
                                text = if (type == settings.indicationType) "${type.name} (active)" else type.name,
                                textStyle = KoreTheme.typography.label2,
                                color = KoreTheme.colorScheme.onBackGroundVariant,
                            )
                            PressTile(
                                label = "Press",
                                modifier = Modifier.fillMaxWidth(),
                            )
                        }
                    }
                }
            }
        }

        DemoBlock(title = "Press scale") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs)) {
                Text(
                    text = "${(settings.pressScale * 100).toInt()}% of the original size when pressed" +
                        if (settings.indicationType == IndicationType.Scale) "" else " (only used by the scale indication)",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
                Slider(
                    value = settings.pressScale,
                    onValueChange = settings.onPressScaleChange,
                    valueRange = 0.5f..1f,
                )
            }
        }

        DemoBlock(title = "How it works") {
            Text(
                text = "The indication is a draw modifier node, so it only reaches the content drawn after " +
                    "it. Kore applies clip, then clickable, then background: the press effect scales or " +
                    "ripples the whole surface instead of leaking outside the corner radius.",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
        }
    }
}

@Composable
private fun ScopedIndication(
    type: IndicationType,
    pressScale: Float,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    KoreTheme(
        typography = KoreTheme.typography,
        sizes = KoreTheme.sizes,
        shapes = KoreTheme.shapes,
        colorScheme = KoreTheme.colorScheme,
        motion = KoreTheme.motion,
        indicationType = type,
        pressScale = pressScale,
    ) {
        Box(modifier = modifier) { content() }
    }
}

@Composable
private fun PressTile(label: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(KoreTheme.shapes.md)
            .clickable(onClick = {})
            .background(KoreTheme.colorScheme.primaryContainer, KoreTheme.shapes.md)
            .padding(vertical = 24.dp, horizontal = 16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = label,
            textStyle = KoreTheme.typography.title3,
            color = KoreTheme.colorScheme.onPrimaryContainer,
        )
    }
}
