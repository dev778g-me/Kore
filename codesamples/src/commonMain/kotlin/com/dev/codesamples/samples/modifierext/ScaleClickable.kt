package com.dev.codesamples.samples.modifierext

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.card.Card
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.modifiers.dashedBorder
import com.dev.kore.utilities.modifiers.scaleClickable

// <sample id="modifierext-scale-clickable">
@Composable
fun ScaleClickableSample() {
    Card(
        modifier = Modifier.size(200.dp)
            .scaleClickable(pressedScale = 0.85f, onClick = {})
            .dashedBorder(
                color = KoreTheme.colorScheme.backGroundVariant,
                shape = KoreTheme.shapes.sm
            )
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Click to Scale")
        }
    }
}
// <sample/>
