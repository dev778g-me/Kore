package com.dev.korelibrary.src.Components.Shimmer

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.dev.korelibrary.utilities.modifiers.shimmer
import com.dev.korelibrary.themes.KoreTheme

@Composable
fun ShimmerBox(
    modifier: Modifier = Modifier,
    shape: Shape = KoreTheme.shapes.md,
    content : (@Composable ()-> Unit)? = null
) {

    Box(
        modifier = modifier
            .shimmer(
                shape = shape
            )
    ){
       content?.invoke()
    }

}