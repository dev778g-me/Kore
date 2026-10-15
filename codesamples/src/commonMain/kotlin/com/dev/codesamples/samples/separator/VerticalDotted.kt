package com.dev.codesamples.samples.separator

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.separators.VerticalDottedSeparator
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme

// <sample id="separator-vertical-dotted">

@Composable
fun VerticalDottedSeparatorSample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly
    ) {
        Text("A")
        VerticalDottedSeparator(
            dotRadius = 3.dp,
            dotGap = 6.dp,
            color = KoreTheme.colorScheme.primary
        )
        Text("B")
    }
}

// <sample/>
