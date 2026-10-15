package com.dev.codesamples.samples.listtile

import androidx.compose.runtime.Composable
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.listtile.ListTile
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.UserCircle

// <sample id="listtile-complex">
@Composable
fun ComplexListTileSample() {
    ListTile(
        overline = { Text("New Message", color = KoreTheme.colorScheme.primary) },
        title = { Text("Jane Doe") },
        subtitle = { Text("Are we still on for the meeting tomorrow at 10 AM?") },
        leading = {
            Icon(imageVector = PhIcons.Regular.UserCircle, contentDescription = "Profile")
        },
        trailing = {
            Text("9:41 AM")
        },
        onClick = { }
    )
}
// <sample/>
