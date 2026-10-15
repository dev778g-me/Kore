package com.dev.codesamples.samples.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.ButtonDefaults
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.text.Text

// <sample id="custom">

@Composable
fun PrimaryButtonWithCustomPaddingAndColors(){

    PrimaryButton(
        onClick = { /* Confirm action */ },
        shape = CircleShape,
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
        colors = ButtonDefaults.primaryButtonColors(
            containerColor = Color.Green,
            contentColor = Color.White
        )
    ) {
        Text("Confirm Everything")
    }
}

// <sample/>
