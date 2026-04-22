package com.dev.korelibrary.components.icon
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import com.dev.korelibrary.themes.LocalContentColor


/**
 * icon is a composable that let's you display an icon
 * @param imageVector the [ImageVector] to display,
 * @param contentDescription is the description of the icon [String]
 * @param tint is the color of the icon [Color]
 * @param modifier is the [Modifier] applied to the icon
 */


@Composable
fun Icon(
    imageVector: ImageVector,
    contentDescription: String?,
    tint: Color  = LocalContentColor.current,
    modifier: Modifier = Modifier
) {
    Image(
        painter = rememberVectorPainter(imageVector),
        contentDescription = contentDescription,
        colorFilter = ColorFilter.tint(
            color = tint,
            blendMode = BlendMode.SrcIn
        ),
        modifier = modifier
    )
}
