package com.dev.codesamples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.codesamples.samples.accordion.BasicAccordionSample
import com.dev.codesamples.samples.accordion.CustomPaddingAccordionSample
import com.dev.codesamples.samples.accordion.CustomTransitionsAccordionSample
import com.dev.codesamples.samples.badge.ErrorBadgeSample
import com.dev.codesamples.samples.badge.OutlinedBadgeSample
import com.dev.codesamples.samples.badge.PrimaryBadgeCustomSample
import com.dev.codesamples.samples.badge.PrimaryBadgeSample
import com.dev.codesamples.samples.badge.PrimaryBadgeWithIconSample
import com.dev.codesamples.samples.badge.SecondaryBadgeSample
import com.dev.codesamples.samples.badge.SuccessBadgeSample
import com.dev.codesamples.samples.buttons.CounterButtonSample
import com.dev.codesamples.samples.buttons.GhostButtonSample
import com.dev.codesamples.samples.buttons.OutlinedButtonSample
import com.dev.codesamples.samples.buttons.PrimaryButtonSample
import com.dev.codesamples.samples.buttons.PrimaryButtonWithCustomPaddingAndColors
import com.dev.codesamples.samples.buttons.PrimaryButtonWithIcon
import com.dev.codesamples.samples.buttons.SecondaryButtonSample
import com.dev.codesamples.samples.card.BasicCardSample
import com.dev.codesamples.samples.card.CustomBorderCardSample
import com.dev.codesamples.samples.card.OutlinedCardSample
import com.dev.codesamples.samples.checkbox.CheckBoxBasicSample
import com.dev.codesamples.samples.checkbox.CheckBoxCustomShapeSample
import com.dev.codesamples.samples.checkbox.CheckBoxWithLabelSample
import com.dev.codesamples.samples.dialog.BasicDialogSample
import com.dev.codesamples.samples.dialog.CustomDialogSample
import com.dev.codesamples.samples.dropdown.DropdownBasicSample
import com.dev.codesamples.samples.dropdown.DropdownDestructiveSample
import com.dev.codesamples.samples.dropdown.DropdownWithIconsSample
import com.dev.codesamples.samples.iconbuttons.GhostIconButtonSample
import com.dev.codesamples.samples.iconbuttons.OutlinedIconButtonSample
import com.dev.codesamples.samples.iconbuttons.PrimaryIconButtonSample
import com.dev.codesamples.samples.iconbuttons.PrimaryIconButtonWithCustomShapeAndColors
import com.dev.codesamples.samples.iconbuttons.SecondaryIconButtonSample
import com.dev.codesamples.samples.listtile.BasicListTileSample
import com.dev.codesamples.samples.listtile.ComplexListTileSample
import com.dev.codesamples.samples.listtile.WithSwitchListTileSample
import com.dev.codesamples.samples.loadingindicator.CircularLoadingBasicSample
import com.dev.codesamples.samples.loadingindicator.CircularLoadingCustomSample
import com.dev.codesamples.samples.loadingindicator.LinearLoadingBasicSample
import com.dev.codesamples.samples.loadingindicator.LinearLoadingCustomSample
import com.dev.codesamples.samples.progressindicator.CircularProgressBasicSample
import com.dev.codesamples.samples.progressindicator.CircularProgressCustomSample
import com.dev.codesamples.samples.progressindicator.LinearProgressBasicSample
import com.dev.codesamples.samples.progressindicator.LinearProgressValueRangeSample
import com.dev.codesamples.samples.radiobutton.RadioButtonBasicSample
import com.dev.codesamples.samples.radiobutton.RadioButtonCustomSample
import com.dev.codesamples.samples.slider.SliderBasicSample
import com.dev.codesamples.samples.slider.SliderCustomRangeSample
import com.dev.codesamples.samples.slider.SliderCustomStyleSample
import com.dev.codesamples.samples.stepper.BasicStepperSample
import com.dev.codesamples.samples.stepper.BorderedStepperSample
import com.dev.codesamples.samples.stepper.LargeNumbersStepperSample
import com.dev.codesamples.samples.switch.SwitchBasicSample
import com.dev.codesamples.samples.switch.SwitchCustomShapeSample
import com.dev.codesamples.samples.switch.SwitchThumbContentSample
import com.dev.codesamples.samples.textfield.TextFieldBasicSample
import com.dev.codesamples.samples.textfield.TextFieldMultilineSample
import com.dev.codesamples.samples.textfield.TextFieldPasswordSample
import com.dev.kore.themes.KoreDefaults.defaultDarkColorScheme
import com.dev.kore.themes.KoreDefaults.defaultLightColorScheme
import com.dev.kore.themes.KoreTheme

val accordionSamples: Map<String, @Composable () -> Unit> = mapOf(
    "accordion-basic" to { BasicAccordionSample() },
    "accordion-custom-padding" to { CustomPaddingAccordionSample() },
    "accordion-custom-transitions" to { CustomTransitionsAccordionSample() },
)

val badgeSamples: Map<String, @Composable () -> Unit> = mapOf(
    "badge-error" to { ErrorBadgeSample() },
    "badge-outlined" to { OutlinedBadgeSample() },
    "badge-primary" to { PrimaryBadgeSample() },
    "badge-primary-custom" to { PrimaryBadgeCustomSample() },
    "badge-primary-with-icon" to { PrimaryBadgeWithIconSample() },
    "badge-secondary" to { SecondaryBadgeSample() },
    "badge-success" to { SuccessBadgeSample() },
)

val buttonSamples: Map<String, @Composable () -> Unit> = mapOf(
    "counter" to { CounterButtonSample() },
    "ghost" to { GhostButtonSample() },
    "primary" to { PrimaryButtonSample() },
    "outlined" to { OutlinedButtonSample() },
    "secondary" to { SecondaryButtonSample() },
    "custom" to { PrimaryButtonWithCustomPaddingAndColors() },
    "icon" to { PrimaryButtonWithIcon() },
)

val cardSamples: Map<String, @Composable () -> Unit> = mapOf(
    "card-basic" to { BasicCardSample() },
    "card-custom-border" to { CustomBorderCardSample() },
    "card-outlined" to { OutlinedCardSample() },
)

val checkboxSamples: Map<String, @Composable () -> Unit> = mapOf(
    "checkbox-basic" to { CheckBoxBasicSample() },
    "checkbox-custom-shape" to { CheckBoxCustomShapeSample() },
    "checkbox-with-label" to { CheckBoxWithLabelSample() },
)

val dialogSamples: Map<String, @Composable () -> Unit> = mapOf(
    "dialog-basic" to { BasicDialogSample() },
    "dialog-custom" to { CustomDialogSample() },
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

val listtileSamples: Map<String, @Composable () -> Unit> = mapOf(
    "listtile-basic" to { BasicListTileSample() },
    "listtile-complex" to { ComplexListTileSample() },
    "listtile-with-switch" to { WithSwitchListTileSample() },
)

val loadingindicatorSamples: Map<String, @Composable () -> Unit> = mapOf(
    "loading-circular-basic" to { CircularLoadingBasicSample() },
    "loading-circular-custom" to { CircularLoadingCustomSample() },
    "loading-linear-basic" to { LinearLoadingBasicSample() },
    "loading-linear-custom" to { LinearLoadingCustomSample() },
)

val progressindicatorSamples: Map<String, @Composable () -> Unit> = mapOf(
    "progress-circular-basic" to { CircularProgressBasicSample() },
    "progress-circular-custom" to { CircularProgressCustomSample() },
    "progress-linear-basic" to { LinearProgressBasicSample() },
    "progress-linear-value-range" to { LinearProgressValueRangeSample() },
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

val stepperSamples: Map<String, @Composable () -> Unit> = mapOf(
    "stepper-basic" to { BasicStepperSample() },
    "stepper-bordered" to { BorderedStepperSample() },
    "stepper-large-numbers" to { LargeNumbersStepperSample() },
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
    accordionSamples +
    badgeSamples +
    buttonSamples +
    cardSamples +
    checkboxSamples +
    dialogSamples +
    dropdownSamples +
    iconButtonSamples +
    listtileSamples +
    loadingindicatorSamples +
    progressindicatorSamples +
    radiobuttonSamples +
    sliderSamples +
    stepperSamples +
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
