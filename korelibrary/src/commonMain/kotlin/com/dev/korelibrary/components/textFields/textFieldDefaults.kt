package com.dev.korelibrary.src.Components.TextFields

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.themes.KoreTheme

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
        labelColor : Color = KoreTheme.colorScheme.onBackGround.copy(alpha = 0.7f),
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
        unFocusedLeadingIconColor: Color = KoreTheme.colorScheme.onBackGround,
        focusedLeadingIconColor: Color = KoreTheme.colorScheme.onBackGround,
        errorLeadingIconColor: Color = KoreTheme.colorScheme.error,
        disabledLeadingIconColor: Color = KoreTheme.colorScheme.onDisabled,
        unFocusedTrailingIconColor: Color  = KoreTheme.colorScheme.onBackGround,
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

    val defaultTextFieldShape
        @Composable get() = KoreTheme.shapes.md

    val minimumTextFieldHeight = 56.dp

    val minimumTextFieldWidth = 300.dp

    val maxLeadingIconHeight = 42.dp

    val maxTrailingIconHeight = 42.dp


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

internal fun TextFieldColors.borderColor(
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


internal fun TextFieldColors.indicatorColor(
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


internal fun TextFieldColors.leadingIconColor(
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

internal fun TextFieldColors.trailingIconColor(
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
internal fun TextFieldColors.contentColor(
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
internal fun TextFieldColors.containerColor(
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
