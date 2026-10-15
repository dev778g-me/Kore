package com.dev.codesamples.samples.textstyleext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dev.kore.components.card.Card
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.extensions.alignEnd

// <sample id="textstyleext-align-end">
@Composable
fun AlignEndSample() {
    Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Text(
            text = "End Aligned Text",
            textStyle = KoreTheme.typography.body1.alignEnd(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
// <sample/>
