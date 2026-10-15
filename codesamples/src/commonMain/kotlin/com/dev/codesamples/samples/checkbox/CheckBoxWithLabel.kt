package com.dev.codesamples.samples.checkbox

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dev.kore.components.checkbox.CheckBox
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme

// <sample id="checkbox-with-label">

@Composable
fun CheckBoxWithLabelSample() {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(KoreTheme.shapes.sm)
            .clickable { isChecked = !isChecked }
            .padding(8.dp)
    ) {
        CheckBox(
            checked = isChecked,
            onCheckChange = { isChecked = it }
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text("Subscribe to newsletter")
    }
}

// <sample/>
