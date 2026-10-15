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
import com.dev.codesamples.samples.checkbox.CheckBoxBasicSample
import com.dev.codesamples.samples.checkbox.CheckBoxCustomShapeSample
import com.dev.codesamples.samples.checkbox.CheckBoxWithLabelSample
import com.dev.codesamples.samples.dropdown.DropdownBasicSample
import com.dev.codesamples.samples.dropdown.DropdownDestructiveSample
import com.dev.codesamples.samples.dropdown.DropdownWithIconsSample
import com.dev.codesamples.samples.iconbuttons.GhostIconButtonSample
import com.dev.codesamples.samples.iconbuttons.OutlinedIconButtonSample
import com.dev.codesamples.samples.iconbuttons.PrimaryIconButtonSample
import com.dev.codesamples.samples.iconbuttons.PrimaryIconButtonWithCustomShapeAndColors
import com.dev.codesamples.samples.iconbuttons.SecondaryIconButtonSample
import com.dev.codesamples.samples.radiobutton.RadioButtonBasicSample
import com.dev.codesamples.samples.radiobutton.RadioButtonCustomSample
import com.dev.codesamples.samples.slider.SliderBasicSample
import com.dev.codesamples.samples.slider.SliderCustomRangeSample
import com.dev.codesamples.samples.slider.SliderCustomStyleSample
import com.dev.codesamples.samples.switch.SwitchBasicSample
import com.dev.codesamples.samples.switch.SwitchCustomShapeSample
import com.dev.codesamples.samples.switch.SwitchThumbContentSample
import com.dev.codesamples.samples.textfield.TextFieldBasicSample
import com.dev.codesamples.samples.textfield.TextFieldMultilineSample
import com.dev.codesamples.samples.textfield.TextFieldPasswordSample
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

val checkboxSamples: Map<String, @Composable () -> Unit> = mapOf(
    "checkbox-basic" to { CheckBoxBasicSample() },
    "checkbox-custom-shape" to { CheckBoxCustomShapeSample() },
    "checkbox-with-label" to { CheckBoxWithLabelSample() },
)

val dropdownSamples: Map<String, @Composable () -> Unit> = mapOf(
    "dropdown-basic" to { DropdownBasicSample() },
    "dropdown-destructive" to { DropdownDestructiveSample() },
    "dropdown-with-icons" to { DropdownWithIconsSample() },
)

val iconButtonSamples: Map<String, @Composable () -> Unit> = mapOf(
    "iconbutton-custom" to { PrimaryIconButtonWithCustomShapeAndColors() },
    "iconbutton-ghost" to { GhostIconButtonSample() },
    "iconbutton-outlined" to { OutlinedIconButtonSample() },
    "iconbutton-primary" to { PrimaryIconButtonSample() },
    "iconbutton-secondary" to { SecondaryIconButtonSample() },
)

val radiobuttonSamples: Map<String, @Composable () -> Unit> = mapOf(
    "radiobutton-basic" to { RadioButtonBasicSample() },
    "radiobutton-custom" to { RadioButtonCustomSample() },
)

val sliderSamples: Map<String, @Composable () -> Unit> = mapOf(
    "slider-basic" to { SliderBasicSample() },
    "slider-custom-range" to { SliderCustomRangeSample() },
    "slider-custom-style" to { SliderCustomStyleSample() },
)

val switchSamples: Map<String, @Composable () -> Unit> = mapOf(
    "switch-basic" to { SwitchBasicSample() },
    "switch-custom-shape" to { SwitchCustomShapeSample() },
    "switch-thumb-content" to { SwitchThumbContentSample() },
)

val textfieldSamples: Map<String, @Composable () -> Unit> = mapOf(
    "textfield-basic" to { TextFieldBasicSample() },
    "textfield-multiline" to { TextFieldMultilineSample() },
    "textfield-password" to { TextFieldPasswordSample() },
)

val allSamples: Map<String, @Composable () -> Unit> =
    buttonSamples +
    checkboxSamples +
    dropdownSamples +
    iconButtonSamples +
    radiobuttonSamples +
    sliderSamples +
    switchSamples +
    textfieldSamples

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
