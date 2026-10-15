package com.dev.codesamples.samples.modifierext

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.kore.components.card.Card
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.modifiers.dashedBorder
import com.dev.kore.utilities.modifiers.noRippleClickable

// <sample id="modifierext-no-ripple-clickable">
@Composable
fun NoRippleClickableSample() {
    var clickCounter by remember { mutableStateOf(0) }
    Card(
        modifier = Modifier.size(200.dp)
            .noRippleClickable(onClick = { clickCounter++ })
            .dashedBorder(
                color = KoreTheme.colorScheme.backGroundVariant,
                shape = KoreTheme.shapes.sm
            )
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = "Click to Increment\n$clickCounter",
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )
        }
    }
}
// <sample/>
