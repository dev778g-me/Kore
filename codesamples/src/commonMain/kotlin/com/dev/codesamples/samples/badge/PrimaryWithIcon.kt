package com.dev.codesamples.samples.badge

import androidx.compose.runtime.Composable
import com.dev.kore.components.badge.PrimaryBadge
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Star


// <sample id="badge-primary-with-icon">

@Composable
fun PrimaryBadgeWithIconSample(){
    PrimaryBadge(
        leadingIcon = {
            Icon(imageVector = PhIcons.Regular.Star, contentDescription = null)
        },
        content = { Text("Premium") }
    )
}

// <sample/>
