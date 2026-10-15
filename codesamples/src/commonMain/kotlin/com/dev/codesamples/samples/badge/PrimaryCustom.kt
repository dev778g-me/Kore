package com.dev.codesamples.samples.badge

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.RectangleShape
import com.dev.kore.components.badge.BadgeDefaults
import com.dev.kore.components.badge.PrimaryBadge
import com.dev.kore.components.text.Text
import com.dev.kore.themes.colors.TailwindColors


// <sample id="badge-primary-custom">

@Composable
fun PrimaryBadgeCustomSample(){
    PrimaryBadge(
        shape = RectangleShape,
        badgeColors = BadgeDefaults.primaryBadgeColors(
            containerColor = TailwindColors.Red.swatch400,
            contentColor = TailwindColors.Red.swatch50
        ),
        content = { Text("99+") }
    )
}

// <sample/>
