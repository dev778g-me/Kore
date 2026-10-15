package com.dev.codesamples.samples.separator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.separators.HorizontalSeparator
import com.dev.kore.components.text.Text

// <sample id="separator-horizontal">

@Composable
fun HorizontalSeparatorSample() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Account Details", modifier = Modifier.padding(16.dp))
        HorizontalSeparator()
        Text("Security Settings", modifier = Modifier.padding(16.dp))
    }
}

// <sample/>
