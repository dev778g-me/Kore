package com.dev.korelibrary.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.themes.LocalContentColor


// base icon button for all the styles
@Composable
internal fun BaseIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean,
    shape : Shape,
    border: BorderStroke ? = null,
    iconButtonColors: IconButtonColors,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        value = LocalContentColor provides if (enabled) iconButtonColors.iconButtonContentColor else
            LocalContentColor.current
    ) {
        Box(
            modifier = modifier
                .semantics{
                    role = Role.Button
                }
                .defaultMinSize(
                    minWidth = IconButtonDefaults.defaultIconButtonWidth,
                    minHeight = IconButtonDefaults.defaultIconButtonHeight
                )
                .clip(shape)
                .background(
                    shape = shape,
                    color = if (enabled) iconButtonColors.iconButtonContainerColor else iconButtonColors.disabledIconButtonColor
                )
                .then(
                    if (border != null) Modifier.border(
                        border = border,
                        shape = shape
                    ) else Modifier
                )
                .clickable(
                    role = Role.Button,
                    enabled = enabled,
                    onClick = {
                        onClick.invoke()
                    }
                )
                .padding(
                    8.dp
                ),
            contentAlignment = Alignment.Center
        ){
            content()
        }
    }
}


@Composable
fun PrimaryIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = CircleShape,
    primaryIconButtonColors: IconButtonColors = IconButtonDefaults.primaryIconButtonColors(),
    content: @Composable () -> Unit,
) {
    BaseIconButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        iconButtonColors = primaryIconButtonColors,
        content = content
    )
}


@Composable
fun SecondaryIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = CircleShape,
    secondaryIconButtonColors: IconButtonColors = IconButtonDefaults.secondaryIconButtonColors(),
    content: @Composable () -> Unit,
) {
    BaseIconButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        iconButtonColors =  secondaryIconButtonColors,
        content = content
    )
}


@Composable
fun OutlinedIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = CircleShape,
    outlinedIconButtonColors: IconButtonColors = IconButtonDefaults.outlinedIconButtonColors(),
    content: @Composable () -> Unit,
) {
    BaseIconButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        iconButtonColors = IconButtonDefaults.outlinedIconButtonColors(),
        shape = shape,
        border =  BorderStroke(width = 1.dp, color =if (enabled) outlinedIconButtonColors.iconButtonContentColor else outlinedIconButtonColors.disabledIconContentColor),
        content = content
    )
}


@Composable
fun GhostIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    enabled: Boolean = true,
    content: @Composable () -> Unit,
) {
    BaseIconButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        iconButtonColors = IconButtonDefaults.ghostIconButton(),
        content = content
    )
}









object IconButtonDefaults{


    val defaultIconButtonWidth = 40.dp

    val defaultIconButtonHeight = 40.dp

    @Composable
    fun primaryIconButtonColors(
        iconButtonContainerColor: Color = KoreTheme.colorScheme.primary,
        iconButtonContentColor: Color = KoreTheme.colorScheme.onPrimary,
        disabledIconButtonColor: Color = KoreTheme.colorScheme.disabled,
        disabledIconContentColor: Color = KoreTheme.colorScheme.onDisabled

    ) = IconButtonColors(
        iconButtonContainerColor = iconButtonContainerColor,
        iconButtonContentColor = iconButtonContentColor,
        disabledIconButtonColor = disabledIconButtonColor,
        disabledIconContentColor = disabledIconContentColor
    )


    @Composable
    fun secondaryIconButtonColors(
        iconButtonContainerColor: Color = KoreTheme.colorScheme.primaryContainer,
        iconButtonContentColor: Color = KoreTheme.colorScheme.onPrimaryContainer,
        disabledIconButtonColor: Color = KoreTheme.colorScheme.disabled,
        disabledIconContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = IconButtonColors(
        iconButtonContainerColor = iconButtonContainerColor,
        iconButtonContentColor = iconButtonContentColor,
        disabledIconButtonColor = disabledIconButtonColor,
        disabledIconContentColor = disabledIconContentColor
    )

    @Composable
    fun outlinedIconButtonColors(
        iconButtonContainerColor: Color = KoreTheme.colorScheme.primary.copy(alpha = 0.1f),
        iconButtonContentColor: Color = KoreTheme.colorScheme.primary,
        disabledIconButtonColor: Color = KoreTheme.colorScheme.transparent,
        disabledIconContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = IconButtonColors(
        iconButtonContainerColor = iconButtonContainerColor,
        iconButtonContentColor = iconButtonContentColor,
        disabledIconButtonColor = disabledIconButtonColor,
        disabledIconContentColor = disabledIconContentColor
    )


    @Composable
    fun ghostIconButton(
        iconButtonContainerColor: Color = KoreTheme.colorScheme.transparent,
        iconButtonContentColor: Color = KoreTheme.colorScheme.onBackGround,
        disabledIconButtonColor: Color = KoreTheme.colorScheme.transparent,
        disabledIconContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = IconButtonColors(
        iconButtonContainerColor = iconButtonContainerColor,
        iconButtonContentColor = iconButtonContentColor,
        disabledIconButtonColor = disabledIconButtonColor,
        disabledIconContentColor = disabledIconContentColor
    )


}





data class IconButtonColors(
    val iconButtonContainerColor : Color,
    val iconButtonContentColor : Color,
    val disabledIconButtonColor : Color,
    val disabledIconContentColor : Color
)