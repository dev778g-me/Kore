package com.dev.kore.components.badge

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
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.LocalContentColor
import com.dev.kore.themes.LocalTextStyle


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
            LocalTextStyle provides KoreTheme.typography.label2
        )
    ) {

            Row(
                modifier = modifier
                    .background(
                        shape = shape, color = badgeColors.containerColor(enabled = enabled)
                    )
                    .then(
                        if (border != null) Modifier.border(
                            border = border,
                            shape = shape
                        ) else Modifier
                    ).padding(
                   badgeSizes.containerPadding
                )
                ,verticalAlignment = Alignment.CenterVertically
            ) {
              leadingIcon?.let {
                  Box(
                      modifier = Modifier
                          .padding(badgeSizes.leadingIconPadding)
                          .size(badgeSizes.leadingIconSize)
                  ){
                      leadingIcon()
                  }
              }

                Box(
                    modifier = Modifier.padding(
                     badgeSizes.contentPadding
                    )
                ){
                    content()
                }

                trailingIcon?.let {
                    Box(
                        modifier = Modifier
                            .padding(badgeSizes.trailingIconPadding)
                            .size(badgeSizes.trailingIconSize)
                    ) {
                        trailingIcon()
                    }
                }
            }
        }
    }



/**
 * PrimaryBadge is a badge composable designed to highlight primary action or status indicator
 * @param content the main composable content to be displayed within the badge
 * @param modifier is the [Modifier] applied to the badge
 * @param shape the shape of the primary badge [Shape]
 * @param badgeSizes the content sizes and padding values for the PrimaryBadge [BadgeSizes]
 * @param leadingIcon an optional [Composable] appearing before the main content
 * @param trailingIcon an optional [Composable] appearing after the main content
 * @param enabled the visual state of the PrimaryBadge [Boolean]
 * @param badgeColors the colors of the PrimaryBadge [BadgeColors]
 */
@Composable
fun PrimaryBadge(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = KoreTheme.shapes.lg,
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

/**
 * SuccessBadge is a badge composable designed to highlight success action or status indicator
 * @param content the main composable content to be displayed within the SuccessBadge
 * @param modifier is the [Modifier] applied to the badge
 * @param shape the shape of the SuccessBadge [Shape]
 * @param badgeSizes the content sizes and padding values for the SuccessBadge [BadgeSizes]
 * @param leadingIcon an optional [Composable] appearing before the main content
 * @param trailingIcon an optional [Composable] appearing after the main content
 * @param enabled the visual state of the SuccessBadge [Boolean]
 * @param badgeColors the colors of the SuccessBadge [BadgeColors]
 */
@Composable
fun SuccessBadge(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = KoreTheme.shapes.lg,
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

/**
 * ErrorBadge is a badge composable designed to highlight success action or status indicator
 * @param content the main composable content to be displayed within the ErrorBadge
 * @param modifier is the [Modifier] applied to the badge
 * @param shape the shape of the ErrorBadge [Shape]
 * @param badgeSizes the content sizes and padding values for the ErrorBadge [BadgeSizes]
 * @param leadingIcon an optional [Composable] appearing before the main content
 * @param trailingIcon an optional [Composable] appearing after the main content
 * @param enabled the visual state of the ErrorBadge [Boolean]
 * @param badgeColors the colors of the ErrorBadge [BadgeColors]
 */
@Composable
fun ErrorBadge(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = KoreTheme.shapes.lg,
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


/**
 * SecondaryBadge is a badge composable designed to highlight success action or status indicator
 * @param content the main composable content to be displayed within the SecondaryBadge
 * @param modifier is the [Modifier] applied to the badge
 * @param shape the shape of the SecondaryBadge [Shape]
 * @param badgeSizes the content sizes and padding values for the SecondaryBadge [BadgeSizes]
 * @param leadingIcon an optional [Composable] appearing before the main content
 * @param trailingIcon an optional [Composable] appearing after the main content
 * @param enabled the visual state of the SecondaryBadge [Boolean]
 * @param badgeColors the colors of the SecondaryBadge [BadgeColors]
 */
@Composable
fun SecondaryBadge(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = KoreTheme.shapes.lg,
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



/**
 * OutlinedBadge is a badge composable designed to highlight success action or status indicator
 * @param content the main composable content to be displayed within the OutlinedBadge
 * @param modifier is the [Modifier] applied to the badge
 * @param shape the shape of the OutlinedBadge [Shape]
 * @param badgeSizes the content sizes and padding values for the OutlinedBadge [BadgeSizes]
 * @param leadingIcon an optional [Composable] appearing before the main content
 * @param trailingIcon an optional [Composable] appearing after the main content
 * @param enabled the visual state of the OutlinedBadge [Boolean]
 * @param badgeColors the colors of the OutlinedBadge [BadgeColors]
 */
@Composable
fun OutlinedBadge(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = KoreTheme.shapes.lg,
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
        border = BorderStroke(
            width = 1.dp,
            color = if (enabled) badgeColors.contentColor else badgeColors.disabledContentColor
        ),
        enabled = enabled,
        badgeColors = badgeColors
    )
}


/**
 * BadgeDefaults is the defaults values for all badge Composables
 * @property defaultBadgeSize is the default the content sizes and padding values [BadgeSizes]
 * @property primaryBadgeColors is the default colors for the PrimaryBadge [BadgeColors]
 * @property secondaryBadgeColors is the default colors for the SecondaryBadge [BadgeColors]
 * @property outlinedBadgeColor is the default colors for the OutlinedBadge [BadgeColors]
 * @property successBadgeColors is the default colors for the SuccessBadge [BadgeColors]
 * @property errorBadgeColors is the default colors for the ErrorBadge [BadgeColors]
 */
object BadgeDefaults {

    /**
     * creates a [BadgeSizes] configuration that defines the sizing and padding values for badge
     *
     * @param leadingIconSize the default size(height & width) of the leading icon slot [Dp]
     * @param leadingIconPadding the defaultPaddingValue of the leading icon slot [PaddingValues]
     * @param trailingIconSize the default size(height & width) of the trailing icon slot [Dp]
     * @param trailingIconPadding the defaultPaddingValue of the trailing icon slot [PaddingValues]
     * @param contentPadding is the defaultPaddingValue of the main content slot [PaddingValues]
     * @param  containerPadding the defaultPaddingValue of the  whole Badge container [PaddingValues]
     */
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

    /**
     * creates a [BadgeColors] [Composable] fun to define the colors for the PrimaryBadge
     * @param containerColor the container
     */
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


    private val horizontalContentPadding = PaddingValues(
        horizontal = 4.dp
    )
    private val defaultLeadingIconSize = 18.dp

   private val defaultTrailingIconSize = 18.dp



}

/**
 * defines the colors of the badge
 */
@Immutable
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
internal fun BadgeColors.contentColor(
    enabled: Boolean
): Color {
    return if (enabled) contentColor else disabledContentColor
}


internal fun BadgeColors.containerColor(
    enabled: Boolean
): Color {
    return if (enabled) containerColor else disabledContainerColor
}

/**
 * defines badge sizes and padding
 */
@Immutable
data class BadgeSizes(
    val leadingIconSize : Dp = Dp.Unspecified,
    val leadingIconPadding : PaddingValues,
    val trailingIconSize : Dp = Dp.Unspecified,
    val trailingIconPadding : PaddingValues,
    val contentPadding : PaddingValues,
    val containerPadding : PaddingValues,
)