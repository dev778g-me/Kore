package com.dev.korelibrary.src.Components.Badges

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.src.Components.Badges.BadgeDefaults.containerColor
import com.dev.korelibrary.src.Components.Badges.BadgeDefaults.contentColor
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.themes.LocalContentColor
import com.dev.korelibrary.themes.LocalTextStyle


@Composable
internal fun BaseBadge(
    content : @Composable ()-> Unit,
    modifier: Modifier = Modifier,
    shape : Shape,
    badgeSizes: BadgeSizes = BadgeDefaults.defaultBadgeSize(),
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    border : BorderStroke ? = null,
    enabled : Boolean = true,
    badgeColors: BadgeColors
) {
    CompositionLocalProvider(
        values = arrayOf(
            LocalContentColor provides badgeColors.contentColor(enabled = enabled),
            LocalTextStyle provides KoreTheme.typography.labelMedium
        )
    ) {
        Box(
            modifier = modifier
                .background(
                    shape = shape, color = badgeColors.containerColor(enabled = enabled)
                )
                .then(
                    if (border != null) Modifier.border(
                        border = border,
                        shape = shape
                    ) else Modifier
                )
        ) {
            Row(
                modifier = Modifier.padding(
                   badgeSizes.containerPadding
                )
                ,verticalAlignment = Alignment.CenterVertically
            ) {
              leadingIcon?.let {
                  Box(
                      modifier = Modifier
                          .size(badgeSizes.leadingIconSize)
                  ){
                      leadingIcon()
                  }
              }

                Box(
                    modifier = modifier.padding(
                     badgeSizes.contentPadding
                    )
                ){
                    content()
                }

                trailingIcon?.let {
                    Box(
                        modifier = Modifier
                            .size(badgeSizes.trailingIconSize)
                    ) {
                        trailingIcon()
                    }
                }
            }
        }
    }
}




// primary chip will be used for the primary actions

@Composable
fun PrimaryBadge(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = KoreTheme.shapes.large,
    badgeSizes: BadgeSizes = BadgeDefaults.defaultBadgeSize(),
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    enabled: Boolean = true,
    badgeColors: BadgeColors = BadgeDefaults.primaryBadgeColors()
) {
    BaseBadge(
        content = content,
        modifier = modifier,
        shape = shape,
        badgeSizes = badgeSizes,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        enabled = enabled,
        badgeColors = badgeColors
    )
}


@Composable
fun SuccessBadge(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = KoreTheme.shapes.large,
    badgeSizes: BadgeSizes = BadgeDefaults.defaultBadgeSize(),
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    enabled: Boolean = true,
    badgeColors: BadgeColors = BadgeDefaults.successBadgeColors()
) {
    BaseBadge(
        content = content,
        modifier = modifier,
        shape = shape,
        badgeSizes = badgeSizes,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        enabled = enabled,
        badgeColors = badgeColors
    )
}


@Composable
fun ErrorBadge(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = KoreTheme.shapes.large,
    badgeSizes: BadgeSizes = BadgeDefaults.defaultBadgeSize(),
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    enabled: Boolean = true,
    badgeColors: BadgeColors = BadgeDefaults.errorBadgeColors()
) {
    BaseBadge(
        content = content,
        modifier = modifier,
        shape = shape,
        badgeSizes = badgeSizes,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        enabled = enabled,
        badgeColors = badgeColors
    )
}

@Composable
fun SecondaryBadge(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = KoreTheme.shapes.large,
    badgeSizes: BadgeSizes = BadgeDefaults.defaultBadgeSize(),
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    enabled: Boolean = true,
    badgeColors: BadgeColors = BadgeDefaults.secondaryBadgeColors()
) {
    BaseBadge(
        content = content,
        modifier = modifier,
        shape = shape,
        badgeSizes = badgeSizes,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        enabled = enabled,
        badgeColors = badgeColors
    )
}

@Composable
fun OutlinedBadge(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = KoreTheme.shapes.large,
    badgeSizes: BadgeSizes = BadgeDefaults.defaultBadgeSize(),
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    enabled: Boolean = true,
    badgeColors: BadgeColors = BadgeDefaults.outlinedBadgeColor()
) {
    BaseBadge(
        content = content,
        modifier = modifier,
        shape = shape,
        badgeSizes = badgeSizes,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        border = androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = if (enabled) badgeColors.contentColor else badgeColors.disabledContentColor
        ),
        enabled = enabled,
        badgeColors = badgeColors
    )
}






object BadgeDefaults {

  @Composable
  fun defaultBadgeSize (
      leadingIconSize: Dp = defaultLeadingIconSize,
      leadingIconPadding: PaddingValues = PaddingValues(0.dp),
      trailingIconSize: Dp = defaultTrailingIconSize,
      trailingIconPadding: PaddingValues = PaddingValues(0.dp) ,
      contentPadding : PaddingValues = horizontalContentPadding,
      containerPadding : PaddingValues = PaddingValues(vertical = 2.dp, horizontal = 6.dp)
  )
  = BadgeSizes(
      leadingIconSize = leadingIconSize,
      leadingIconPadding = leadingIconPadding,
      trailingIconSize = trailingIconSize,
      trailingIconPadding = trailingIconPadding,
      contentPadding = contentPadding,
      containerPadding = containerPadding
  )


    @Composable
    fun primaryBadgeColors(
        containerColor: Color = KoreTheme.colorScheme.primary,
        contentColor: Color = KoreTheme.colorScheme.onPrimary,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledContentColor: Color = KoreTheme.colorScheme.onDisabled,
        leadingContentColor: Color = KoreTheme.colorScheme.onPrimary,
        disabledLeadingContentColor: Color = KoreTheme.colorScheme.onDisabled,
        trailingContentColor: Color = KoreTheme.colorScheme.onPrimary,
        disabledTrailingContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = BadgeColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor,
        leadingContentColor = leadingContentColor,
        disabledLeadingContentColor = disabledLeadingContentColor,
        trailingContentColor = trailingContentColor,
        disabledTrailingContentColor = disabledTrailingContentColor
    )

    @Composable
    fun secondaryBadgeColors(
        containerColor: Color = KoreTheme.colorScheme.primaryContainer,
        contentColor: Color = KoreTheme.colorScheme.onPrimaryContainer,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledContentColor: Color = KoreTheme.colorScheme.onDisabled,
        leadingContentColor: Color = KoreTheme.colorScheme.onBackGroundVariant,
        disabledLeadingContentColor: Color = KoreTheme.colorScheme.onDisabled,
        trailingContentColor: Color = KoreTheme.colorScheme.onBackGroundVariant,
        disabledTrailingContentColor: Color = KoreTheme.colorScheme.onDisabled
    )  =
        BadgeColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
            leadingContentColor = leadingContentColor,
            disabledLeadingContentColor = disabledLeadingContentColor,
            trailingContentColor = trailingContentColor,
            disabledTrailingContentColor = disabledTrailingContentColor,
        )

    @Composable
    fun outlinedBadgeColor(
        containerColor: Color = KoreTheme.colorScheme.transparent,
        contentColor: Color = KoreTheme.colorScheme.primary,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledContentColor: Color = KoreTheme.colorScheme.onDisabled,
        leadingContentColor: Color = KoreTheme.colorScheme.onBackGroundVariant,
        disabledLeadingContentColor: Color = KoreTheme.colorScheme.onDisabled,
        trailingContentColor: Color = KoreTheme.colorScheme.onBackGroundVariant,
        disabledTrailingContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = BadgeColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor,
        leadingContentColor = leadingContentColor,
        disabledLeadingContentColor = disabledLeadingContentColor,
        trailingContentColor = trailingContentColor,
        disabledTrailingContentColor = disabledTrailingContentColor
    )

    @Composable
    fun successBadgeColors(
        containerColor: Color = KoreTheme.colorScheme.success,
        contentColor: Color = KoreTheme.colorScheme.onSuccess,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledContentColor: Color = KoreTheme.colorScheme.onDisabled,
        leadingContentColor: Color = KoreTheme.colorScheme.onSuccess,
        disabledLeadingContentColor: Color = KoreTheme.colorScheme.onDisabled,
        trailingContentColor: Color = KoreTheme.colorScheme.onSuccess,
        disabledTrailingContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = BadgeColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor,
        leadingContentColor = leadingContentColor,
        disabledLeadingContentColor = disabledLeadingContentColor,
        trailingContentColor = trailingContentColor,
        disabledTrailingContentColor = disabledTrailingContentColor
    )

    @Composable
    fun errorBadgeColors(
        containerColor: Color = KoreTheme.colorScheme.error,
        contentColor: Color = KoreTheme.colorScheme.onError,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledContentColor: Color = KoreTheme.colorScheme.onDisabled,
        leadingContentColor: Color = KoreTheme.colorScheme.onError,
        disabledLeadingContentColor: Color = KoreTheme.colorScheme.onDisabled,
        trailingContentColor: Color = KoreTheme.colorScheme.onError,
        disabledTrailingContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = BadgeColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor,
        leadingContentColor = leadingContentColor,
        disabledLeadingContentColor = disabledLeadingContentColor,
        trailingContentColor = trailingContentColor,
        disabledTrailingContentColor = disabledTrailingContentColor
    )

   // the default size for the chip





    val horizontalContentPadding = PaddingValues(
        horizontal = 4.dp
    )
    val defaultLeadingIconSize = 18.dp

    val defaultTrailingIconSize = 18.dp


    internal fun BadgeColors.contentColor (
       enabled : Boolean
    ) : Color{
       return if (enabled) contentColor else disabledContentColor
    }


    internal fun BadgeColors.containerColor(
        enabled: Boolean
    ) : Color{
        return if (enabled) containerColor else disabledContainerColor
    }


}


data class BadgeColors(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor : Color,
    val disabledContentColor : Color,
    val leadingContentColor : Color,
    val disabledLeadingContentColor : Color,
    val trailingContentColor : Color,
    val disabledTrailingContentColor : Color
)

data class BadgeSizes(
    val leadingIconSize : Dp = Dp.Unspecified,
    val leadingIconPadding : PaddingValues,
    val trailingIconSize : Dp = Dp.Unspecified,
    val trailingIconPadding : PaddingValues,
    val contentPadding : PaddingValues,
    val containerPadding : PaddingValues,
)