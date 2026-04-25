package com.dev.korelibrary.components.avatar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.themes.LocalContentColor


@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    avatarSize : Dp = AvatarSizes.SMALL.size,
    shape : Shape = AvatarDefaults.defaultAvatarShape,
    colors: AvatarColors = AvatarDefaults.defaultAvatarColors(),
    contentAlignment: Alignment = AvatarDefaults.defaultContentAlignment,
    content : @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .size(avatarSize)
            .clip(shape)
            .background(color = colors.containerColor, shape = shape),
        contentAlignment = contentAlignment
    ){
        CompositionLocalProvider(
            value = LocalContentColor provides colors.contentColor
        ){
            content()
        }
    }
}





object AvatarDefaults{

    val defaultContentAlignment : Alignment = Alignment.Center
    val defaultAvatarShape : Shape = CircleShape

    @Composable
    fun defaultAvatarColors(
        containerColor: Color = KoreTheme.colorScheme.surface,
        contentColor: Color = KoreTheme.colorScheme.onSurface
    ) = AvatarColors(
        containerColor = containerColor,
        contentColor = contentColor
    )

}





data class AvatarColors(
    val containerColor : Color,
    val contentColor : Color,
)





enum class AvatarSizes(val size: Dp) {
    SMALL(49.dp),
    MEDIUM(56.dp),
    LARGE(72.dp)
}