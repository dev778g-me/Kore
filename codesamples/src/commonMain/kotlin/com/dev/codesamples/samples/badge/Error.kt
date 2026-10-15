package com.dev.codesamples.samples.badge

import androidx.compose.runtime.Composable
import com.dev.kore.components.badge.ErrorBadge
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Warning


// <sample id="badge-error">

@Composable
fun ErrorBadgeSample(){
    ErrorBadge(
        leadingIcon = {
            Icon(imageVector = PhIcons.Regular.Warning, contentDescription = null)
        },
        content = { Text("Action Required") }
    )
}

// <sample/>
