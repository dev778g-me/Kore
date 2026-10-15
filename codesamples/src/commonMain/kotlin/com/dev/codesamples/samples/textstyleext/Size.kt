package com.dev.codesamples.samples.textstyleext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.dev.kore.components.card.Card
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.extensions.size

// <sample id="textstyleext-size">
@Composable
fun SizeSample() {
    Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Text(
            text = "Custom Sized Text",
            textStyle = KoreTheme.typography.body1.size(24.sp)
        )
    }
}
// <sample/>
