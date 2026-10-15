package com.dev.codesamples.samples.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.card.OutlinedCard
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme

// <sample id="card-custom-border">
@Composable
fun CustomBorderCardSample() {
    OutlinedCard(
        borderStroke = BorderStroke(width = 2.dp, color = KoreTheme.colorScheme.primary),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Selected Item", textStyle = KoreTheme.typography.title1, color = KoreTheme.colorScheme.primary)
        Text("The thicker, colored border indicates this card is currently selected.")
    }
}
// <sample/>
