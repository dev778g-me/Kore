package com.dev.codesamples.samples.navbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.navigationBar.NavigationBar
import com.dev.kore.components.navigationBar.NavigationBarItem
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Gear
import com.phosphor.icons.regular.House
import com.phosphor.icons.regular.MagnifyingGlass

// <sample id="navbar-basic">

@Composable
fun NavbarBasicSample() {
    var selectedIndex by remember { mutableStateOf(0) }
    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        NavigationBarItem(
            selected = (selectedIndex == 0),
            onClick = { selectedIndex = 0 },
            icon = {
                Icon(imageVector = PhIcons.Regular.House, contentDescription = "Home")
            },
            label = {
                Text("Home")
            }
        )
        NavigationBarItem(
            selected = (selectedIndex == 1),
            onClick = { selectedIndex = 1 },
            icon = {
                Icon(imageVector = PhIcons.Regular.MagnifyingGlass, contentDescription = "Search")
            },
            label = {
                Text("Search")
            }
        )
        NavigationBarItem(
            selected = (selectedIndex == 2),
            onClick = { selectedIndex = 2 },
            icon = {
                Icon(imageVector = PhIcons.Regular.Gear, contentDescription = "Settings")
            },
            label = {
                Text("Settings")
            }
        )
    }
}

// <sample/>
