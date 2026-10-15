package com.dev.codesamples.samples.modifierext

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.card.Card
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.modifiers.dotBorder

// <sample id="modifierext-dot-border">
@Composable
fun DotBorderSample() {
    Card(
        modifier = Modifier.size(200.dp)
            .dotBorder(
                dotRadius = 1.5.dp,
                color = KoreTheme.colorScheme.backGroundVariant,
                shape = KoreTheme.shapes.sm
            )
    ) { }
}
// <sample/>
