package com.dev.codesamples.samples.dropdown

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.buttons.PrimaryIconButton
import com.dev.kore.components.dropdown.DropDown
import com.dev.kore.components.dropdown.DropDownItem
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.DotsThreeVertical

// <sample id="dropdown-basic">

@Composable
fun DropdownBasicSample() {
    var expanded by remember { mutableStateOf(false) }
    Box {
        PrimaryIconButton(onClick = { expanded = true }) {
            Icon(imageVector = PhIcons.Regular.DotsThreeVertical, contentDescription = "More options")
        }
        DropDown(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropDownItem(
                title = { Text("Profile") },
                onClick = { expanded = false }
            )
            DropDownItem(
                title = { Text("Settings") },
                onClick = { expanded = false }
            )
        }
    }
}

// <sample/>
