package com.dev.codesamples.samples.appbar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dev.kore.components.appbar.Appbar
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.House

// <sample id="appbar-custom-dimensions">

@Composable
fun AppbarCustomDimensionsSample() {
    Appbar(
        title = {
            Text(text = "Dashboard")
        },
        minimumAppBarHeight = 80.dp,
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp),
        navigationIcon = {
            Icon(imageVector = PhIcons.Regular.House, contentDescription = "Home")
        }
    )
}

// <sample/>
