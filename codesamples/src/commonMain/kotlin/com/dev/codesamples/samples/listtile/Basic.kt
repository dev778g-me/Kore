package com.dev.codesamples.samples.listtile

import androidx.compose.runtime.Composable
import com.dev.kore.components.listtile.ListTile
import com.dev.kore.components.text.Text

// <sample id="listtile-basic">
@Composable
fun BasicListTileSample() {
    ListTile(
        title = { Text("Push Notifications") },
        onClick = { }
    )
}
// <sample/>
