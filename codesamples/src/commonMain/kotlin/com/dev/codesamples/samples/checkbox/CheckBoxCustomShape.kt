package com.dev.codesamples.samples.checkbox

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.dev.kore.components.checkbox.CheckBox
import com.dev.kore.components.checkbox.CheckBoxDefaults
import com.dev.kore.themes.colors.TailwindColors

// <sample id="checkbox-custom-shape">

@Composable
fun CheckBoxCustomShapeSample() {
    var isChecked by remember { mutableStateOf(true) }
    CheckBox(
        checked = isChecked,
        onCheckChange = { isChecked = it },
        shape = CircleShape,
        borderWidth = 2.dp,
        colors = CheckBoxDefaults.defaultCheckBoxColors(
            checkedContainerColor = TailwindColors.Green.swatch500,
            checkedCheckColor = TailwindColors.White,
            uncheckedBorderColor = TailwindColors.Gray.swatch500
        )
    )
}

// <sample/>
