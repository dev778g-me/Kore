package com.dev.codesamples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.codesamples.samples.buttons.CounterButtonSample
import com.dev.codesamples.samples.buttons.GhostButtonSample
import com.dev.codesamples.samples.buttons.OutlinedButtonSample
import com.dev.codesamples.samples.buttons.PrimaryButtonSample
import com.dev.codesamples.samples.buttons.PrimaryButtonWithCustomPaddingAndColors
import com.dev.codesamples.samples.buttons.PrimaryButtonWithIcon
import com.dev.codesamples.samples.buttons.SecondaryButtonSample
import com.dev.codesamples.samples.iconbuttons.GhostIconButtonSample
import com.dev.codesamples.samples.iconbuttons.OutlinedIconButtonSample
import com.dev.codesamples.samples.iconbuttons.PrimaryIconButtonSample
import com.dev.codesamples.samples.iconbuttons.PrimaryIconButtonWithCustomShapeAndColors
import com.dev.codesamples.samples.iconbuttons.SecondaryIconButtonSample
import com.dev.kore.themes.KoreDefaults.defaultDarkColorScheme
import com.dev.kore.themes.KoreDefaults.defaultLightColorScheme
import com.dev.kore.themes.KoreTheme

val buttonSamples: Map<String, @Composable () -> Unit> = mapOf(
    "counter" to { CounterButtonSample() },
    "ghost" to { GhostButtonSample() },
    "primary" to { PrimaryButtonSample() },
    "outlined" to { OutlinedButtonSample() },
    "secondary" to { SecondaryButtonSample() },
    "custom" to { PrimaryButtonWithCustomPaddingAndColors() },
    "icon" to { PrimaryButtonWithIcon() },
)

val iconButtonSamples: Map<String, @Composable () -> Unit> = mapOf(
    "iconbutton-custom" to { PrimaryIconButtonWithCustomShapeAndColors() },
    "iconbutton-ghost" to { GhostIconButtonSample() },
    "iconbutton-outlined" to { OutlinedIconButtonSample() },
    "iconbutton-primary" to { PrimaryIconButtonSample() },
    "iconbutton-secondary" to { SecondaryIconButtonSample() },
)

val allSamples: Map<String, @Composable () -> Unit> =
    buttonSamples +
    iconButtonSamples

@Composable
fun SingleSampleApp(id: String, isDark: Boolean = false) {
    val colorScheme = if (isDark) defaultDarkColorScheme else defaultLightColorScheme
    KoreTheme(colorScheme = colorScheme) {
        Box(
            modifier = Modifier.fillMaxSize().background(colorScheme.surface).padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            allSamples[id]?.invoke()
        }
    }
}
