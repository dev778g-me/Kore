package com.dev.codesamples.samples.buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Plus

// <sample id="icon">
@Composable
fun PrimaryButtonWithIcon(){
    PrimaryButton(
        onClick = { /* Do something */ }
    ) {
        Icon(
            imageVector = PhIcons.Regular.Plus,
            contentDescription = null,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text("Add New Item")
    }
}

// <sample/>
