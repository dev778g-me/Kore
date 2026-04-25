package com.dev.korelibrary.components.buttons

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
import com.dev.korelibrary.themes.LocalTextStyle


@Composable
internal fun BaseButton (
    onClick : () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    contentPadding: PaddingValues,
    colors: ButtonColors,
    border : BorderStroke ? = null,
    shape: Shape,
    content: @Composable RowScope.() -> Unit
){

    val contentColor by animateColorAsState(
        targetValue = colors.contentColor(enabled = enabled)
    )

    val containerColor by animateColorAsState(
        targetValue = colors.containerColor(enabled = enabled)
    )

    CompositionLocalProvider(
        values = arrayOf(
            LocalTextStyle provides KoreTheme.typography.title2,
            LocalContentColor provides contentColor
        )
    ) {
        Row(
            modifier = modifier
                .defaultMinSize(
                    minHeight = ButtonDefaults.defaultMinHeight
                )
                .semantics {
                    role = Role.Button
                }
                .clip(shape = shape)
                .background(
                    color = containerColor,
                    shape = shape
                )
                .then(
                    if (border != null) Modifier.border(
                        border = border,
                        shape = shape
                    ) else Modifier
                )
                .clickable(
                    enabled = enabled,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = LocalIndication.current,
                    role = Role.Button,
                    onClick = {
                        onClick.invoke()
                    }
                )
                .padding(contentPadding
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            content()
        }
    }
}


/**
 * Primary button is a highly prominent button for primary actions / actions which you want user to do
 * @param onClick the callback to be invoked when PrimaryButton is clicked
 * @param modifier the [Modifier] applied on PrimaryButton
 * @param enabled the boolean state which decides tab enabled nature [Boolean]
 * @param contentPadding the contentPaddingValues of PrimaryButton [PaddingValues]
 * @param colors the colors of the buttons  [ButtonColors]
 * @param shape the shape of the button  [Shape]
 * @param content the content to be displayed on the PrimaryButton [Composable]
 */
@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.defaultButtonPadding(),
    colors: ButtonColors = ButtonDefaults.primaryButtonColors(),
    shape: Shape = ButtonDefaults.defaultButtonShape,
    content: @Composable RowScope.() -> Unit
) {

    BaseButton(
        onClick = onClick,
        modifier =modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        colors = colors,
        shape = shape,
        content = content
    )
}


/**
 * SecondaryButton is a medium-emphasis button for action which are less important or less prominent
 * @param onClick the callback invoked when the SecondaryButton is clicked
 * @param modifier the [Modifier] applied to SecondaryButton
 * @param enabled the boolean state which decides tab enabled nature [Boolean]
 * @param contentPadding the contentPaddingValues of SecondaryButton [PaddingValues]
 * @param colors the colors of the SecondaryButton [ButtonColors]
 * @param shape the shape of the button [shape]
 * @param content the content to be displayed on the SecondayButton
 */


@Composable
fun SecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.defaultButtonPadding(),
    colors: ButtonColors = ButtonDefaults.secondaryButtonColors(),
    shape: Shape = ButtonDefaults.defaultButtonShape,
    content: @Composable RowScope.() -> Unit
) {

    BaseButton(
        onClick = onClick,
        modifier =modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        colors = colors,
        shape = shape,
        content = content
    )
}


/**
 * OutlinedButton is a medium-emphasis button with a border around it for action which are less important or less prominent
 * @param modifier the [Modifier] applied to OutlinedButton
 * @param enabled the boolean state which decides tab enabled nature [Boolean]
 * @param contentPadding the contentPaddingValues of OutlinedButton [PaddingValues]
 * @param colors the colors of the OutlinedButton [ButtonColors]
 * @param shape the shape of the button [shape]
 * @param content the content to be displayed on the OutlinedButton
 */

@Composable
fun OutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.defaultButtonPadding(),
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    shape: Shape = ButtonDefaults.defaultButtonShape,
    content: @Composable RowScope.() -> Unit
) {

    BaseButton(
        onClick = onClick,
        modifier =modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        colors = colors,
        shape = shape,
        border = BorderStroke(width = 1.dp, color =if (enabled) colors.buttonContentColor else colors.disabledButtonContentColor),
        content = content
    )
}


/**
 * A low-emphasis button for the action which are least prominent / or you don't want user to perform
 * @param modifier the [Modifier] applied to GhostButton
 * @param enabled the boolean state which decides tab enabled nature [Boolean]
 * @param contentPadding the contentPaddingValues of GhostButton [PaddingValues]
 * @param colors the colors of the GhostButton [ButtonColors]
 * @param shape the shape of the button [shape]
 * @param content the content to be displayed on the SecondayButton
 */

@Composable
fun GhostButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.defaultButtonPadding(),
    colors: ButtonColors = ButtonDefaults.ghostButtonColors(),
    shape: Shape = ButtonDefaults.defaultButtonShape,
    content: @Composable RowScope.() -> Unit
) {

    BaseButton(
        onClick = onClick,
        modifier =modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        colors = colors,
        shape = shape,
        content = content
    )
}


/**
 * ButtonDefault defines the default values for buttons
 * @property defaultButtonShape the default button shape for button
 * @property defaultMinWidth the default min width for button [Dp]
 * @property defaultMinHeight the default min height for the button [Dp]
 * @property primaryButtonColors the default Colors for PrimaryButtons [ButtonColors]
 * @property secondaryButtonColors the default Colors for SecondayButtons [ButtonColors]
 * @property outlinedButtonColors the default Colors for OutlinedButton [ButtonColors]
 * @property ghostButtonColors the default Colors for GhostButton [ButtonColors]
 * @property defaultButtonPadding the default content padding for the button
 */
object ButtonDefaults{



    val defaultButtonShape : Shape
        @Composable get() = KoreTheme.shapes.sm

    val defaultMinWidth = 58.dp

    val defaultMinHeight = 40.dp





    /// color value for the primary button
    @Composable
    fun primaryButtonColors(
        containerColor : Color = KoreTheme.colorScheme.primary,
        contentColor: Color = KoreTheme.colorScheme.onPrimary,
        disabledButtonContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledButtonContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = ButtonColors(
        buttonContainerColor = containerColor,
        buttonContentColor = contentColor,
        disabledButtonContainerColor = disabledButtonContainerColor,
        disabledButtonContentColor = disabledButtonContentColor,
    )

    @Composable
    fun secondaryButtonColors (
        containerColor: Color = KoreTheme.colorScheme.primaryContainer,
        contentColor : Color = KoreTheme.colorScheme.onPrimaryContainer,
        disabledButtonContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledButtonContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = ButtonColors(
        buttonContainerColor = containerColor,
        buttonContentColor = contentColor,
        disabledButtonContainerColor = disabledButtonContainerColor,
        disabledButtonContentColor =disabledButtonContentColor
    )

    @Composable
    fun outlinedButtonColors(
        containerColor: Color = KoreTheme.colorScheme.primary.copy(alpha = 0.1f),
        contentColor: Color = KoreTheme.colorScheme.primary,
        disabledButtonContainerColor: Color = KoreTheme.colorScheme.transparent,
        disabledButtonContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = ButtonColors(
        buttonContainerColor = containerColor,
        buttonContentColor = contentColor,
        disabledButtonContainerColor =disabledButtonContainerColor ,
        disabledButtonContentColor = disabledButtonContentColor
    )


    @Composable
    fun ghostButtonColors(
        containerColor: Color = Color.Transparent,
        contentColor: Color = KoreTheme.colorScheme.primary,
        disabledButtonContainerColor: Color = KoreTheme.colorScheme.transparent,
        disabledButtonContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = ButtonColors(
        buttonContainerColor = containerColor,
        buttonContentColor = contentColor,
        disabledButtonContainerColor = disabledButtonContainerColor,
        disabledButtonContentColor = disabledButtonContentColor
    )



    @Composable
    fun defaultButtonPadding(
        contentPadding: PaddingValues = PaddingValues(
            horizontal = KoreTheme .sizes.md,
            vertical = KoreTheme .sizes.xs
        )
    ) = contentPadding



}


/**
 * defines all colors for the button
 */
@Immutable
data class ButtonColors(
    val buttonContainerColor : Color,
    val buttonContentColor : Color,
    val disabledButtonContainerColor : Color,
    val disabledButtonContentColor: Color
)


private fun ButtonColors.containerColor(
    enabled: Boolean
) : Color{
    return if (enabled) buttonContainerColor else disabledButtonContainerColor
}


private fun ButtonColors.contentColor(
    enabled: Boolean
)  : Color{
    return if (enabled) buttonContentColor else disabledButtonContentColor
}