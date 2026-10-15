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
import com.dev.kore.components.separators.VerticalDashedSeparator
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme

// <sample id="separator-vertical-dashed">

@Composable
fun VerticalDashedSeparatorSample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly
    ) {
        Text("Left")
        VerticalDashedSeparator(
            thickness = 2.dp,
            dashLength = 6.dp,
            dashGap = 4.dp,
            color = KoreTheme.colorScheme.primary
        )
        Text("Right")
    }
}

// <sample/>
