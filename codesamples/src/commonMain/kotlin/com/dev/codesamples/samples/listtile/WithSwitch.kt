package com.dev.codesamples.samples.listtile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.listtile.ListTile
import com.dev.kore.components.switch.Switch
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.WifiHigh

// <sample id="listtile-with-switch">
@Composable
fun WithSwitchListTileSample() {
    var isWifiEnabled by remember { mutableStateOf(true) }
    ListTile(
        leading = {
            Icon(imageVector = PhIcons.Regular.WifiHigh, contentDescription = null)
        },
        title = { Text("Wi-Fi") },
        trailing = {
            Switch(
                checked = isWifiEnabled,
                onCheckChange = { isWifiEnabled = it }
            )
        },
        onClick = { isWifiEnabled = !isWifiEnabled }
    )
}
// <sample/>
