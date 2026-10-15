package com.dev.codesamples.samples.navbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.navigationBar.NavigationBar
import com.dev.kore.components.navigationBar.NavigationBarItem
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Bell

// <sample id="navbar-custom">

@Composable
fun NavbarCustomSample() {
    var selected by remember { mutableStateOf(true) }
    NavigationBar {
        NavigationBarItem(
            selected = selected,
            onClick = { selected = !selected },
            icon = {
                Icon(
                    imageVector = PhIcons.Regular.Bell,
                    contentDescription = "Alerts"
                )
            },
            label = {
                Text("Alerts")
            }
        )
    }
}

// <sample/>
