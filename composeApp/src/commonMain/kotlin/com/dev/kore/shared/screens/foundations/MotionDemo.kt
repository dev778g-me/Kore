package com.dev.kore.shared.screens.foundations

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.buttons.SecondaryButton
import com.dev.kore.components.switch.Switch
import com.dev.kore.components.text.Text
import com.dev.kore.motions.MotionConfig
import com.dev.kore.motions.MotionCurve
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow
import com.dev.kore.shared.theme.LocalAppSettings
import com.dev.kore.themes.KoreTheme

/**
 * The four motion tiers, rendered once per preset so the difference between
 * snappy, smooth, calm and fluid is visible side by side.
 *
 * The preset buttons switch the app wide motion config: every component of the
 * showcase reacts to it immediately.
 */
@Composable
fun MotionDemo() {
    val settings = LocalAppSettings.current
    var isPlaying by remember { mutableStateOf(false) }

    val presets = listOf(
        "Balanced" to MotionConfig.Balanced,
        "Lively" to MotionConfig.Lively,
        "Reduced" to MotionConfig.Reduced,
        "Still" to MotionConfig.Still,
    )

    DemoPage {
        DemoBlock(title = "App motion") {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = settings.motion.toString(),
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
                VariantRow {
                    presets.forEach { (label, config) ->
                        if (config == settings.motion) {
                            PrimaryButton(onClick = { settings.onMotionChange(config) }) {
                                Text(label)
                            }
                        } else {
                            SecondaryButton(onClick = { settings.onMotionChange(config) }) {
                                Text(label)
                            }
                        }
                    }
                }

                var demoChecked by remember { mutableStateOf(false) }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Switch(checked = demoChecked, onCheckChange = { demoChecked = it })
                    Text(
                        text = "Toggle to feel the preset",
                        textStyle = KoreTheme.typography.body3,
                        color = KoreTheme.colorScheme.onBackGroundVariant,
                    )
                }
            }
        }

        DemoBlock(title = "Tiers") {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                SecondaryButton(onClick = { isPlaying = !isPlaying }) {
                    Text(if (isPlaying) "Reset" else "Play")
                }

                Tier(
                    title = "snappy",
                    subtitle = "press · toggle · icon swap",
                    configs = presets,
                    isPlaying = isPlaying,
                ) { it.snappy }
                Tier(
                    title = "smooth",
                    subtitle = "fades · color · small moves",
                    configs = presets,
                    isPlaying = isPlaying,
                ) { it.smooth }
                Tier(
                    title = "calm",
                    subtitle = "sheets · dialogs · page changes",
                    configs = presets,
                    isPlaying = isPlaying,
                ) { it.calm }
                Tier(
                    title = "fluid",
                    subtitle = "drag · fling · spring back",
                    configs = presets,
                    isPlaying = isPlaying,
                ) { it.fluid }
            }
        }
    }
}

@Composable
private fun Tier(
    title: String,
    subtitle: String,
    configs: List<Pair<String, MotionConfig>>,
    isPlaying: Boolean,
    curveOf: (MotionConfig) -> MotionCurve,
) {
    Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs)) {
        Text(title, textStyle = KoreTheme.typography.title3)
        Text(
            text = subtitle,
            textStyle = KoreTheme.typography.label2,
            color = KoreTheme.colorScheme.onBackGroundVariant,
        )
        configs.forEach { (label, config) ->
            MotionTrack(label = label, curve = curveOf(config), isPlaying = isPlaying)
        }
    }
}

@Composable
private fun MotionTrack(label: String, curve: MotionCurve, isPlaying: Boolean) {
    val progress by animateFloatAsState(
        targetValue = if (isPlaying) 1f else 0f,
        animationSpec = curve.spec(),
        label = "motion-$label",
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = label,
            textStyle = KoreTheme.typography.label2,
            modifier = Modifier.width(64.dp),
        )
        BoxWithConstraints(
            modifier = Modifier
                .weight(1f)
                .height(20.dp)
                .clip(CircleShape)
                .background(KoreTheme.colorScheme.backGroundVariant),
        ) {
            Box(
                modifier = Modifier
                    .offset(x = (maxWidth - 20.dp) * progress)
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(KoreTheme.colorScheme.primary),
            )
        }
        Text(
            text = curve.toString().substringAfter("MotionCurve."),
            textStyle = KoreTheme.typography.label2,
            color = KoreTheme.colorScheme.onBackGroundVariant,
            modifier = Modifier.width(104.dp),
        )
    }
}
