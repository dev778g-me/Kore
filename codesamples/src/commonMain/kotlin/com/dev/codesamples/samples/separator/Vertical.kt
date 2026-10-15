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
import com.dev.kore.components.buttons.GhostButton
import com.dev.kore.components.separators.VerticalSeparator
import com.dev.kore.components.text.Text

// <sample id="separator-vertical">

@Composable
fun VerticalSeparatorSample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly
    ) {
        GhostButton(onClick = { }) {
            Text("Like")
        }

        VerticalSeparator(
            modifier = Modifier.padding(vertical = 8.dp)
        )

        GhostButton(onClick = { }) {
            Text("Comment")
        }

        VerticalSeparator(
            modifier = Modifier.padding(vertical = 8.dp)
        )

        GhostButton(onClick = { }) {
            Text("Share")
        }
    }
}

// <sample/>
