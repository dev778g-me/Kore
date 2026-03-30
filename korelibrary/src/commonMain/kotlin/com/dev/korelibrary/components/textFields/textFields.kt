package com.dev.korelibrary.src.Components.TextFields

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.themes.LocalContentColor
import com.dev.korelibrary.themes.LocalTextStyle


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
    shape : androidx.compose.ui.graphics.Shape ,
    textStyle: TextStyle ?,
    textFieldColors: TextFieldColors,
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
            isFocused -> 2.dp
            isError -> 2.dp
            else -> 1.dp
        }
    )

    CompositionLocalProvider(
        LocalTextStyle provides KoreTheme.typography.titleSmall,
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
                       LocalTextStyle provides KoreTheme.typography.titleMedium,
                       LocalContentColor provides KoreTheme.colorScheme.onBackGround
                   )
               ) {
                   Box(
                       modifier = Modifier.padding(TextFieldDefaults.labelPaddingValues)
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
                   modifier = Modifier.padding(
                       TextFieldDefaults.errorLabelPaddingValues
                   )
               ){
                   CompositionLocalProvider(
                       values = arrayOf(
                           LocalTextStyle provides KoreTheme.typography.labelSmall,
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

// decoration box for the text field <idk i am so dumb idk why i am doing this>
@OptIn(ExperimentalSharedTransitionApi::class)
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
        modifier = Modifier
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
                placeholder()

            }
            CompositionLocalProvider(
                value = LocalTextStyle provides KoreTheme.typography.labelSmall
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
        textFieldColors = textFieldColors
    )
}













