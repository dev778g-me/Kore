package com.dev.codesamples.samples.textstyleext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dev.kore.components.card.Card
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.extensions.color

// <sample id="textstyleext-color">
@Composable
fun TextStyleColorSample() {
    Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Text(
            text = "Colored Text",
            textStyle = KoreTheme.typography.body1.color(KoreTheme.colorScheme.primary)
        )
    }
}
// <sample/>
