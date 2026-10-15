package com.dev.codesamples.samples.dropdown

import androidx.compose.runtime.Composable
import com.dev.kore.components.dropdown.DropDownItem
import com.dev.kore.components.dropdown.DropdownDefaults
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Trash

// <sample id="dropdown-destructive">

@Composable
fun DropdownDestructiveSample() {
    DropDownItem(
        title = { Text("Delete Permanently") },
        leading = {
            Icon(imageVector = PhIcons.Regular.Trash, contentDescription = null)
        },
        colors = DropdownDefaults.defaultDropDownItemColors(
            contentColor = KoreTheme.colorScheme.error,
            leadingContentColor = KoreTheme.colorScheme.error
        ),
        onClick = { }
    )
}

// <sample/>
