package com.dev.codesamples.samples.card

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dev.kore.components.card.OutlinedCard
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme

// <sample id="card-outlined">
@Composable
fun OutlinedCardSample() {
    OutlinedCard(
        modifier = Modifier.fillMaxWidth(),
        contentPaddingValues = PaddingValues(KoreTheme.sizes.md)
    ) {
        Text(
            text = "Fus Ro Dah",
            color = KoreTheme.colorScheme.onBackGround,
            textStyle = KoreTheme.typography.title1
        )

        Spacer(modifier = Modifier.height(KoreTheme.sizes.xxs))

        Text(
            text = "The Thu'um — the ancient dragon language. Masters of the Voice can shout the very fabric of reality into submission.",
            textStyle = KoreTheme.typography.body2
        )
    }
}
// <sample/>
