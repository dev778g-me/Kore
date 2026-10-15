package com.dev.codesamples.samples.modifierext

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.card.Card
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.modifiers.dashedBorder

// <sample id="modifierext-dashed-border">
@Composable
fun DashedBorderSample() {
    Card(
        modifier = Modifier.size(200.dp)
            .dashedBorder(
                color = KoreTheme.colorScheme.backGroundVariant,
                shape = KoreTheme.shapes.sm
            )
    ) { }
}
// <sample/>
