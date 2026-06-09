package com.dev.kore.components.textFields

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.LocalContentColor
import com.dev.kore.themes.LocalTextStyle
import com.dev.kore.utilities.extensions.color


// the base text field which other text field with style will implement

@Composable
internal fun BaseTextField(
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    enabled : Boolean = true,
    readOnly : Boolean = false,
    singleLine: Boolean = false,
    isError: Boolean = false,
    label : @Composable (() -> Unit)? = null,
    description : @Composable (() -> Unit)? = null,
    placeholder : @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    maxLines : Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLine : Int = 1,
    shape : Shape,
    textStyle: TextStyle ?,
    textFieldColors: TextFieldColors,
    borderWidth : OutlinedBorderWidth,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    val textFieldInteractionSource = remember { MutableInteractionSource() }
    val isFocused by textFieldInteractionSource.collectIsFocusedAsState()
    val shouldShow = value.isEmpty()

    val backGroundColor by animateColorAsState(
        targetValue = textFieldColors.containerColor(
            enabled = enabled,
            isFocused = isFocused,
            error = isError,
        )
    )


    val borderColor by animateColorAsState(
        targetValue = textFieldColors.borderColor(
            enabled = enabled,
            isFocused = isFocused,
            hasError = isError
        )
    )

    val width by animateDpAsState(
        targetValue = when {
            isFocused -> borderWidth.focusedBorderWidth
            isError -> borderWidth.errorBorderWidth
            !isFocused -> borderWidth.unFocusedBorderWidth
            !enabled -> borderWidth.disabledBorderWidth
            else -> borderWidth.unFocusedBorderWidth
        }
    )

    val labelColor by animateColorAsState(
        targetValue = textFieldColors.labelColor(
            enabled = enabled,
            error = isError,
            isFocused = isFocused
        )
    )

    CompositionLocalProvider(
        LocalTextStyle provides KoreTheme.typography.title3,
        LocalContentColor provides textFieldColors.contentColor(
            enabled = enabled,
            error = isError,
            isFocused = isFocused
        )
    ) {


        Column { 
            label?.let {
               CompositionLocalProvider(
                   values = arrayOf(
                       LocalTextStyle provides KoreTheme.typography.title2,
                       LocalContentColor provides labelColor
                   )
               ) {
                   Box(
                       modifier = Modifier.Companion.padding(TextFieldDefaults.labelPaddingValues)
                   ) {
                       it()
                   }
               }
            }
            BasicTextField(
                modifier = modifier
                    .defaultMinSize(
                        minHeight = TextFieldDefaults.minimumTextFieldHeight,
                        minWidth = TextFieldDefaults.minimumTextFieldWidth
                    )
                    .clip(
                        shape = shape
                    )
                    .background(
                        shape = shape,
                        color = backGroundColor
                    )

                    .border(
                        color = borderColor,
                        width = width,
                        shape = shape
                    ),
                enabled = enabled,
                readOnly = readOnly,
                singleLine = singleLine,
                keyboardActions = keyboardActions,
                keyboardOptions = keyboardOptions,
                visualTransformation = visualTransformation,
                interactionSource = textFieldInteractionSource,
                maxLines = maxLines,
                minLines = minLine,
                textStyle = textStyle ?: LocalTextStyle.current.copy(
                    color = LocalContentColor.current
                ),
                cursorBrush = SolidColor(
                    value = textFieldColors.indicatorColor(
                        enabled = enabled,
                        error = isError,
                        isFocused = isFocused
                    )
                ),
                decorationBox = { innerField ->
                    DecorationBox(
                        innerTextField = innerField,
                        enabled = enabled,
                        singleLine = singleLine,
                        textFieldColors = textFieldColors,
                        leadingIcon = leadingIcon,
                        trailingIcon = trailingIcon,
                        placeholder = placeholder,
                        isError = isError,
                        isFocused = isFocused,
                        shouldShowPlaceholder = shouldShow,
                    )
                }, value = value, onValueChange = {
                    onValueChange.invoke(it)
                })
            description?.let {
                Box(
                    modifier = Modifier.Companion.padding(
                        TextFieldDefaults.errorLabelPaddingValues
                    )
                ) {
                    CompositionLocalProvider(
                        values = arrayOf(
                            LocalTextStyle provides KoreTheme.typography.label3,
                           LocalContentColor provides KoreTheme.colorScheme.onBackGroundVariant
                       )
                   ) {
                       it()
                   }

               }
            }

        }
    }

}

// decoration box for the text field
@Composable
fun DecorationBox(
    innerTextField : @Composable () -> Unit,
    enabled: Boolean,
    placeholder :@Composable (()-> Unit) ?,
    isError:  Boolean,
    isFocused : Boolean,
    singleLine : Boolean,
    shouldShowPlaceholder: Boolean,
    textFieldColors: TextFieldColors,
    leadingIcon : @Composable (()-> Unit) ?,
    trailingIcon: @Composable (() -> Unit)?,
    ) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.Companion
            .padding(
                TextFieldDefaults.textFieldPadding
            )
            .height(IntrinsicSize.Min)
            .width(IntrinsicSize.Max)

    ) {
        if (leadingIcon != null) {
            Box(
                modifier = Modifier
                    .defaultMinSize(
                        minWidth = TextFieldDefaults.maxLeadingIconHeight,
                        minHeight = TextFieldDefaults.maxLeadingIconHeight
                    )
                    .padding(
                        TextFieldDefaults.leadingIconPaddingValues
                    ),
                contentAlignment = Alignment.Center
            ) {
               CompositionLocalProvider(
                   value = LocalContentColor provides textFieldColors.leadingIconColor(
                       enabled = enabled,
                       error = isError,
                       isFocused = isFocused
                   )
               ) {
                   leadingIcon()
               }
            }
        }



        Box(
            modifier = Modifier.weight(
                1f
            )
        ) {

            if (shouldShowPlaceholder && placeholder != null) {
                CompositionLocalProvider(
                    value = LocalContentColor provides KoreTheme.colorScheme.onBackGroundVariant
                ) {

                    placeholder()
                }

            }
            CompositionLocalProvider(
                value = LocalTextStyle provides KoreTheme.typography.label3
            ) {
                innerTextField()
            }
        }


        if (trailingIcon != null) {
            Box(
                modifier = Modifier
                    .defaultMinSize(
                        minWidth = TextFieldDefaults.maxTrailingIconHeight,
                        minHeight = TextFieldDefaults.maxTrailingIconHeight,
                    )
                    .padding(
                        TextFieldDefaults.trailingIconPaddingValues
                    ),
                contentAlignment = Alignment.Center
            ) {
                CompositionLocalProvider(
                    value = LocalContentColor provides textFieldColors.trailingIconColor(
                        enabled = enabled,
                        error = isError,
                        isFocused = isFocused
                    )
                ) {
                    trailingIcon()
                }
            }
        }
    }}


/**
 * OutlinedTextField is an ui component which lets user enter text into ui(email, passwords, name etc.)
 * @param value the value of the textfield input [String]
 * @param onValueChange the callback to be invoked when the value of the textfield changes [String]
 * @param modifier the [Modifier] applied to the textfield.
 * @param enabled the boolean state which decides textfield enabled nature [Boolean]
 * @param readOnly the boolean state which decides textfield readOnly nature [Boolean]
 * @param textStyle the [TextStyle] of the textfield
 * @param label the label of the textfield [Composable] appears on top of outlinedTextField
 * @param placeholder the placeholder of the textfield appears when textfield is empty [Composable] (usually explaining about the input)
 * @param leadingIcon the leading icon of the textfield [Composable]
 * @param trailingIcon the trailing icon of the textfield [Composable]
 * @param description the description of the textfield [Composable] appears on bottom of the outlinedTextField .
 * @param isError the boolean state which decides textfield error nature [Boolean]
 * @param visualTransformation the [VisualTransformation] of the textfield
 * @param keyboardOptions the [KeyboardOptions] of the textfield
 * @param keyboardActions the [KeyboardActions] of the textfield
 * @param singleLine the boolean state which decides textfield singleLine nature [Boolean]
 * @param maxLines the maxLines of the textfield [Int]
 * @param minLines the minLines of the textfield [Int]
 * @param shape the shape of the textfield [Shape]
 * @param borderWidth the borderWidth of the textfield [OutlinedBorderWidth]. use [TextFieldDefaults.defaultBorderWidth] to customize
 * @param textFieldColors the colors of the outlinedTextfield [TextFieldColors] . use [TextFieldDefaults.outlinedTextFieldColors] to customize the colors
 */
@Composable
fun OutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle? = null,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    description: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    shape: Shape = TextFieldDefaults.defaultTextFieldShape,
    borderWidth: OutlinedBorderWidth = TextFieldDefaults.defaultBorderWidth(),
    textFieldColors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors()
) {
    BaseTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        description = description,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        minLine = minLines,
        shape = shape,
        borderWidth = borderWidth,
        textFieldColors = textFieldColors
    )
}





object TextFieldDefaults {
    @Composable
    fun outlinedTextFieldColors(
        focusedBorderColor: Color = KoreTheme.colorScheme.primary,
        unFocusedBorderColor: Color = KoreTheme.colorScheme.backGroundVariant,
        errorBorderColor: Color = KoreTheme.colorScheme.error,
        disabledBorderColor: Color = KoreTheme.colorScheme.disabled,
        focusedContainerColor: Color = KoreTheme.colorScheme.transparent,
        unFocusedContainerColor: Color = KoreTheme.colorScheme.transparent,
        errorContainerColor: Color = KoreTheme.colorScheme.transparent,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,
        labelColor : Color = KoreTheme.colorScheme.onBackGround,
        errorLabelColor : Color = KoreTheme.colorScheme.error,
        disabledLabelColor: Color = KoreTheme.colorScheme.disabled,
        unFocusedIndicatorColor : Color = KoreTheme.colorScheme.backGroundVariant,
        focusedIndicatorColor: Color = KoreTheme.colorScheme.primary,
        errorIndicatorColor: Color = KoreTheme.colorScheme.error,
        disabledIndicatorColor: Color = KoreTheme.colorScheme.disabled,
        focusedTextColor: Color = KoreTheme.colorScheme.onBackGround,
        unFocusedTextColor: Color = KoreTheme.colorScheme.onBackGround,
        errorTextColors: Color = KoreTheme.colorScheme.onBackGround,
        disabledTextColor: Color = KoreTheme.colorScheme.disabled,
        unFocusedLeadingIconColor: Color = KoreTheme.colorScheme.onBackGroundVariant,
        focusedLeadingIconColor: Color = KoreTheme.colorScheme.onBackGround,
        errorLeadingIconColor: Color = KoreTheme.colorScheme.error,
        disabledLeadingIconColor: Color = KoreTheme.colorScheme.onDisabled,
        unFocusedTrailingIconColor: Color  = KoreTheme.colorScheme.onBackGroundVariant,
        focusedTrailingIconColor : Color = KoreTheme.colorScheme.onBackGround,
        errorTrailingIconColor : Color = KoreTheme.colorScheme.error,
        disabledTrailingIconColor : Color = KoreTheme.colorScheme.onDisabled,
    ) = TextFieldColors(
        focusedBorderColor = focusedBorderColor,
        unFocusedBorderColor = unFocusedBorderColor,
        errorBorderColor = errorBorderColor,
        disabledBorderColor = disabledBorderColor,
        focusedContainerColor = focusedContainerColor,
        unFocusedContainerColor = unFocusedContainerColor,
        errorContainerColor = errorContainerColor,
        disabledContainerColor = disabledContainerColor,
        labelColor = labelColor,
        errorLabelColor = errorLabelColor,
        disabledLabelColor = disabledLabelColor,
        focusedIndicatorColor = focusedIndicatorColor,
        unFocusedIndicatorColor = unFocusedIndicatorColor,
        errorIndicatorColor = errorIndicatorColor,
        disabledIndicatorColor = disabledIndicatorColor,
        focusedTextColor = focusedTextColor,
        unFocusedTextColor = unFocusedTextColor,
        errorTextColor = errorTextColors,
        disabledTextColor = disabledTextColor,
        unFocusedLeadingIconColor = unFocusedLeadingIconColor,
        focusedLeadingIconColor = focusedLeadingIconColor,
        errorLeadingIconColor = errorLeadingIconColor,
        disabledLeadingIconColor = disabledLeadingIconColor,
        unFocusedTrailingIconColor = unFocusedTrailingIconColor,
        focusedTrailingIconColor = focusedTrailingIconColor,
        errorTrailingIconColor = errorTrailingIconColor,
        disabledTrailingIconColor = disabledTrailingIconColor,
    )

    @Composable
    fun defaultBorderWidth(
        focusedBorderWidth : Dp = 2.dp,
        unFocusedBorderWidth : Dp = 1.dp,
        errorBorderWidth : Dp = 2.dp,
        disabledBorderWidth : Dp = 1.dp
    ) = OutlinedBorderWidth(
        focusedBorderWidth = focusedBorderWidth,
        unFocusedBorderWidth = unFocusedBorderWidth,
        errorBorderWidth = errorBorderWidth,
        disabledBorderWidth = disabledBorderWidth,
    )

    val defaultTextFieldShape
        @Composable get() = KoreTheme.shapes.md

    val minimumTextFieldHeight = 56.dp

    val minimumTextFieldWidth = 300.dp

    val maxLeadingIconHeight = 48.dp

    val maxTrailingIconHeight = 48.dp


    val labelPaddingValues : PaddingValues = PaddingValues(
        start = 8.dp,
        bottom = 4.dp
    )

    val errorLabelPaddingValues : PaddingValues = PaddingValues(
        start = 8.dp,
        top = 4.dp
    )

    val textFieldPadding : PaddingValues = PaddingValues(
        horizontal = 12.dp,
        vertical = 8.dp
    )

    val leadingIconPaddingValues : PaddingValues = PaddingValues(
        end = 12.dp
    )

    val trailingIconPaddingValues : PaddingValues = PaddingValues(
        start = 12.dp
    )


}

@Immutable
data class TextFieldColors(
    val focusedBorderColor : Color,
    val unFocusedBorderColor : Color,
    val errorBorderColor : Color,
    val disabledBorderColor : Color,
    val focusedContainerColor : Color,
    val unFocusedContainerColor : Color,
    val errorContainerColor : Color,
    val disabledContainerColor : Color,
    val labelColor : Color,
    val errorLabelColor : Color,
    val disabledLabelColor : Color,
    val unFocusedIndicatorColor : Color,
    val focusedIndicatorColor: Color,
    val errorIndicatorColor : Color,
    val disabledIndicatorColor : Color,
    val focusedTextColor : Color,
    val unFocusedTextColor : Color,
    val errorTextColor: Color,
    val disabledTextColor: Color,
    val unFocusedLeadingIconColor: Color,
    val focusedLeadingIconColor : Color,
    val errorLeadingIconColor : Color,
    val disabledLeadingIconColor : Color,
    val unFocusedTrailingIconColor: Color,
    val focusedTrailingIconColor : Color,
    val errorTrailingIconColor : Color,
    val disabledTrailingIconColor : Color,
)

@Immutable
data class OutlinedBorderWidth(
    val focusedBorderWidth : Dp,
    val unFocusedBorderWidth : Dp,
    val errorBorderWidth : Dp,
    val disabledBorderWidth : Dp
)



private fun TextFieldColors.borderColor(
    enabled: Boolean,
    hasError: Boolean,
    isFocused: Boolean
): Color {
    val isError: Boolean = enabled && hasError
    return when {
        !enabled -> this.disabledBorderColor
        isError -> this.errorBorderColor
        isFocused -> this.focusedBorderColor
        else -> this.unFocusedBorderColor
    }
}


private fun TextFieldColors.indicatorColor(
    enabled: Boolean,
    error: Boolean,
    isFocused: Boolean
): Color {
    return when {
        !enabled -> this.disabledIndicatorColor
        error -> this.errorIndicatorColor
        isFocused -> this.focusedIndicatorColor
        else -> this.unFocusedIndicatorColor
    }
}

// function for colors of the leading icon


private fun TextFieldColors.leadingIconColor(
    enabled: Boolean,
    error : Boolean,
    isFocused: Boolean
) : Color {

    return when {
        !enabled -> this.disabledLeadingIconColor
        error -> this.errorLeadingIconColor
        isFocused -> this.focusedLeadingIconColor
        else -> this.unFocusedLeadingIconColor
    }
}

private fun TextFieldColors.trailingIconColor(
    enabled: Boolean,
    error : Boolean,
    isFocused: Boolean
) : Color {

    return when {
        !enabled -> this.disabledTrailingIconColor
        error -> this.errorTrailingIconColor
        isFocused -> this.focusedTrailingIconColor
        else -> this.unFocusedTrailingIconColor
    }
}
private fun TextFieldColors.contentColor(
    enabled: Boolean,
    error: Boolean,
    isFocused: Boolean
) : Color{

    return when {
        !enabled -> this.disabledTextColor
        error -> this.errorTextColor
        isFocused -> this.focusedTextColor
        else -> this.unFocusedTextColor
    }
}
private fun TextFieldColors.containerColor(
    enabled: Boolean,
    error: Boolean,
    isFocused: Boolean
) : Color{
    return when {
        !enabled -> this.disabledContainerColor
        error -> this.errorContainerColor
        isFocused -> this.focusedContainerColor
        else -> this.unFocusedContainerColor
    }
}

private fun TextFieldColors.labelColor(
    enabled: Boolean,
    error: Boolean,
    isFocused: Boolean
): Color{
    return when {
        !enabled -> this.disabledLabelColor
        error -> this.errorLabelColor
        isFocused -> this.labelColor
        else -> this.labelColor
    }
}







