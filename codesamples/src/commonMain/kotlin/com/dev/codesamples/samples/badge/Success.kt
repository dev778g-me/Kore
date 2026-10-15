package com.dev.codesamples.samples.badge

import androidx.compose.runtime.Composable
import com.dev.kore.components.badge.SuccessBadge
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Check


// <sample id="badge-success">

@Composable
fun SuccessBadgeSample(){
    SuccessBadge(
        leadingIcon = {
            Icon(imageVector = PhIcons.Regular.Check, contentDescription = null)
        },
        content = { Text("Approved") }
    )
}

// <sample/>
