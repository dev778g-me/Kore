package com.dev.kore.components.shimmer

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.dev.kore.utilities.modifiers.shimmer
import com.dev.kore.themes.KoreTheme

/**
 * A placeholder component that displays a shimmering animation, typically used to build skeleton loading screens.
 * @param modifier The [Modifier] applied to the shimmer box.
 * @param shape The geometric clipping shape of the shimmer effect. Defaults to the medium shape defined in [KoreTheme].
 * @param content Optional content to place inside the box. This is often left null for fixed-size placeholders, but can be provided to automatically size the `ShimmerBox` to match the exact dimensions of the pending UI elements.
 */
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