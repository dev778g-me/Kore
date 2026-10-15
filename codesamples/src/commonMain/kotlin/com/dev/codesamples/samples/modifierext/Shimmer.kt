package com.dev.codesamples.samples.modifierext

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.card.Card
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.modifiers.dashedBorder
import com.dev.kore.utilities.modifiers.shimmer

// <sample id="modifierext-shimmer">
@Composable
fun ShimmerSample() {
    Card(
        modifier = Modifier.size(200.dp)
            .dashedBorder(
                color = KoreTheme.colorScheme.backGroundVariant,
                shape = KoreTheme.shapes.sm
            )
    ) {
        Box(modifier = Modifier.fillMaxSize().shimmer(shape = KoreTheme.shapes.sm), contentAlignment = Alignment.Center) { }
    }
}
// <sample/>
