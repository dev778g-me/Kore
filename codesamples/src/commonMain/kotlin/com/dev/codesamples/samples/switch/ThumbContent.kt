package com.dev.codesamples.samples.switch

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.switch.Switch
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Moon
import com.phosphor.icons.regular.Sun


// <sample id="switch-thumb-content">

@Composable
fun SwitchThumbContentSample() {
    var isDarkMode by remember { mutableStateOf(false) }
    Switch(
        checked = isDarkMode,
        onCheckChange = { isDarkMode = it },
        checkThumbContent = {
            Icon(
                imageVector = PhIcons.Regular.Moon,
                contentDescription = null,
                modifier = Modifier.size(12.dp)
            )
        },
        unCheckedThumbContent = {
            Icon(
                imageVector = PhIcons.Regular.Sun,
                contentDescription = null,
                modifier = Modifier.size(12.dp)
            )
        }
    )
}

// <sample/>
