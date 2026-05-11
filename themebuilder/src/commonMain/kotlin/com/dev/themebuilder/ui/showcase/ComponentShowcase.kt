package com.dev.themebuilder.ui.showcase

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.card.OutlinedCard


@Composable
fun ComponentShowcase(
    modifier: Modifier = Modifier,
    title : @Composable () -> Unit,
    content : @Composable () -> Unit
){
    OutlinedCard(
        modifier = modifier,
        contentPaddingValues = PaddingValues(16.dp)

    ){
        title()

        Spacer(
            modifier = Modifier.height(
                12.dp
            )
        )

       content()

    }
}