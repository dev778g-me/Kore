package com.dev.kore.shared.screens.foundations

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.window.Popup
import com.dev.kore.components.floatingActionButton.FloatingActionButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.segmentedButton.SegmentedButtonItem
import com.dev.kore.components.segmentedButton.SingleChoiceSegmentedButtonRow
import com.dev.kore.components.text.Text
import com.dev.kore.motions.MotionConfig
import com.dev.kore.motions.MotionCurve
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.theme.LocalAppSettings
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Play

/**
 * The four motion tiers, rendered once per preset so the difference between
 * snappy, smooth, calm and fluid is visible side by side.
 *
 * The preset segmented button switches the app wide motion config: every component of the
 * showcase reacts to it immediately. The floating play button toggles the preview
 * animation of the tiers on or off.
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

                val selectedPreset = presets.firstOrNull { it.second == settings.motion }?.first ?: "Custom"
                val presetDescription = when (selectedPreset) {
                    "Balanced" -> "Crisp and polished. The default."
                    "Lively" -> "Playful and springy. Consumer and creative apps."
                    "Reduced" -> "Very short fades. For motion-sensitive users."
                    "Still" -> "No animation at all."
                    else -> ""
                }
                Text(
                    text = selectedPreset,
                    textStyle = KoreTheme.typography.title3,
                    color = KoreTheme.colorScheme.onBackGround,
                )
                Text(
                    text = presetDescription,
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
                SingleChoiceSegmentedButtonRow {
                    presets.forEachIndexed { index, (label, config) ->
                        SegmentedButtonItem(
                            selected = config == settings.motion,
                            onSelected = { settings.onMotionChange(config) },
                            index = index,
                            itemCount = presets.size,
                        ) {
                            Text(label)
                        }
                    }
                }
                Text(
                    text = "This changes the app level animation for the whole showcase.",
                    textStyle = KoreTheme.typography.label2,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
            }
        }

        DemoBlock(title = "Tiers") {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
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

                Spacer(modifier = Modifier.size(250.dp))
            }
        }
    }

    Popup(
        alignment = Alignment.BottomEnd,
        offset = IntOffset(-24, -24),
    ) {
        FloatingActionButton(onClick = { isPlaying = !isPlaying }) {
            Icon(
                imageVector = PhIcons.Regular.Play,
                contentDescription = if (isPlaying) "Reset" else "Play",
                modifier = Modifier.size(20.dp),
            )
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
        Text(title, textStyle = KoreTheme.typography.title3, color = KoreTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
        Text(
            text = subtitle,
            textStyle = KoreTheme.typography.label3,
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
            textStyle = KoreTheme.typography.label3,
            modifier = Modifier.width(64.dp),
        )
        BoxWithConstraints(
            modifier = Modifier
                .weight(1f)
                .height(28.dp)
                .clip(CircleShape)
                .background(KoreTheme.colorScheme.backGroundVariant),
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .offset(x = (maxWidth - 20.dp) * progress)
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(KoreTheme.colorScheme.primary),
            )
        }

    }
}
