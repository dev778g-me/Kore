package com.dev.codesamples.samples.textstyleext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.dev.kore.components.card.Card
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.extensions.lineHeight

// <sample id="textstyleext-line-height">
@Composable
fun LineHeightSample() {
    Card(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Text(
            text = "Text with\ncustom line\nheight",
            textStyle = KoreTheme.typography.body1.lineHeight(32.sp)
        )
    }
}
// <sample/>
