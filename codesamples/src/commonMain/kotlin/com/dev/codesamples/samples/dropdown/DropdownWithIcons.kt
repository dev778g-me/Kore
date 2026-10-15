package com.dev.codesamples.samples.dropdown

import androidx.compose.runtime.Composable
import com.dev.kore.components.dropdown.DropDownItem
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.CaretRight
import com.phosphor.icons.regular.ShareNetwork

// <sample id="dropdown-with-icons">

@Composable
fun DropdownWithIconsSample() {
    DropDownItem(
        title = { Text("Share Profile") },
        leading = {
            Icon(imageVector = PhIcons.Regular.ShareNetwork, contentDescription = null)
        },
        trailing = {
            Icon(imageVector = PhIcons.Regular.CaretRight, contentDescription = null)
        },
        onClick = { }
    )
}

// <sample/>
