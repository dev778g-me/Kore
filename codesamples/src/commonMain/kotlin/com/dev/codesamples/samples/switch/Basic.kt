package com.dev.codesamples.samples.switch

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.switch.Switch
import com.dev.kore.components.text.Text


// <sample id="switch-basic">

@Composable
fun SwitchBasicSample() {
    var isEnabled by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        Text("Enable Push Notifications")
        Spacer(Modifier.weight(1f))
        Switch(
            checked = isEnabled,
            onCheckChange = { isEnabled = it }
        )
    }
}

// <sample/>
