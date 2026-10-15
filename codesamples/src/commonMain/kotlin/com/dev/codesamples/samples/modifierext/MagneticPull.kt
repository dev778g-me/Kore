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
import com.dev.kore.utilities.modifiers.magneticPull

// <sample id="modifierext-magnetic-pull">
@Composable
fun MagneticPullSample() {
    Card(
        modifier = Modifier.size(200.dp)
            .magneticPull()
            .dashedBorder(
                color = KoreTheme.colorScheme.backGroundVariant,
                shape = KoreTheme.shapes.sm
            )
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Drag Me")
        }
    }
}
// <sample/>
