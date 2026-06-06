package com.dev.themebuilder.ui.showcase

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.card.Card
import com.dev.kore.components.listtile.ListTile
import com.dev.kore.components.separators.HorizontalSeparator
import com.dev.kore.components.switch.Switch
import com.dev.kore.components.text.Text

@Composable
fun SwitchShowCase(
    modifier: Modifier = Modifier
) {

    var showFpsCounter by rememberSaveable { mutableStateOf(true) }
    var hardwareAcceleration by rememberSaveable { mutableStateOf(false) }




    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
        ) {
            Text(text = "Engine Settings")

            Spacer(modifier = Modifier.height(12.dp))
            HorizontalSeparator()


            ListTile(
                contentPaddingValues = PaddingValues(horizontal = 0.dp, vertical = 12.dp),
                title = { Text("Show FPS Counter") },
                trailing = {
                    Switch(
                        checked = showFpsCounter,
                        onCheckChange = { showFpsCounter = it }
                    )
                }
            )


            ListTile(
                contentPaddingValues = PaddingValues(horizontal = 0.dp, vertical = 12.dp),
                title = { Text("Hardware Acceleration") },
                trailing = {
                    Switch(
                        checked = hardwareAcceleration,
                        onCheckChange = { hardwareAcceleration = it }
                    )
                }
            )
        }
    }
}