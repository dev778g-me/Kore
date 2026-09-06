package com.dev.kore.components.textFields

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldDecorator
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.util.fastFirstOrNull
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
            focused = isFocused,
            error = isError,
        )
    )

    val contentColor by animateColorAsState(
        targetValue = textFieldColors.textColor(
            enabled = enabled,
            error = isError,
            focused = isFocused

        )
    )


    val borderColor by animateColorAsState(
        targetValue = textFieldColors.borderColor(
            enabled = enabled,
            focused = isFocused,
            error = isError
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
        )
    )

    CompositionLocalProvider(
        LocalTextStyle provides KoreTheme.typography.title3,
        LocalContentColor provides textFieldColors.textColor(
            enabled = enabled,
            error = isError,
            focused = isFocused
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
                        color = contentColor
                    ),
                    cursorBrush = SolidColor(
                        value = textFieldColors.indicatorColor(
                            enabled = enabled,
                            error = isError,
                            focused = isFocused
                        )
                    ),
                    decorationBox = { innerField ->
                        DecorationBox(
                            innerTextField = innerField,
                            enabled = enabled,
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
            }
            description?.let {
                Box(
                    modifier = Modifier.padding(
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
@Composable
internal fun BaseTextField(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    error: Boolean = false,
    label:@Composable (() -> Unit)? = null,
    placeholder :@Composable (() -> Unit)? = null,
    description: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: Shape,
    textStyle: TextStyle?,
    textFieldColors: TextFieldColors,
    borderWidth: OutlinedBorderWidth,
    interactionSource: MutableInteractionSource? = null,
    decorator: TextFieldDecorator? = null,
    outputTransformation: OutputTransformation? = null,
    inputTransformation: InputTransformation?,
    contentPadding: PaddingValues,
    onTextLayout: (Density.(() -> TextLayoutResult?) -> Unit)?,
    onKeyboardActions: KeyboardActionHandler?,
    lineLimits: TextFieldLineLimits,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {


    val focusRequester = remember { FocusRequester() }
    val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }
    val focused by resolvedInteractionSource.collectIsFocusedAsState()
    val mergedTextStyle = textStyle ?: KoreTheme.typography.title2

    val shouldShowPlaceholder : Boolean = state.text.isEmpty()
    val labelColor by animateColorAsState(
        targetValue = textFieldColors.labelColor(
            enabled = enabled,
            error = error,
        )
    )
    val contentColor by animateColorAsState(
        targetValue = textFieldColors.textColor(enabled = enabled, error  = error, focused = focused)
    )
    val indicatorColor by animateColorAsState(
        targetValue = textFieldColors.indicatorColor(
            enabled = enabled,
            error = error,
            focused = focused
        )
    )


    TextFieldLayout(
        modifier = modifier,
        label = label,
        description = description,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        placeholder = {
            shouldShowPlaceholder.let {
                if (it){
                    CompositionLocalProvider(
                        LocalTextStyle provides mergedTextStyle
                    ){
                        placeholder?.invoke()
                    }
                }
            }
        },
        innerTextField = {
            BasicTextField(
                modifier = Modifier.focusRequester(focusRequester),
                state = state,
                enabled = enabled,
                readOnly = readOnly,
                inputTransformation = inputTransformation,
                textStyle = mergedTextStyle.color(contentColor),
                keyboardOptions = keyboardOptions,
                onKeyboardAction = onKeyboardActions,
                lineLimits = lineLimits,
                cursorBrush = SolidColor(indicatorColor),
                onTextLayout = onTextLayout,
                interactionSource = resolvedInteractionSource,
                outputTransformation = outputTransformation,
                decorator = decorator,
                scrollState = rememberScrollState()
            )
        },
        paddingValues =contentPadding,
        container = {
            TextFieldContainer(
                shape = shape, textFieldColors = textFieldColors,
                enabled = enabled,
                focused =focused,
                error = error,
                borderWidth = borderWidth,
                focusRequester = focusRequester,
                interactionSource = resolvedInteractionSource
            )

        }
    )
}
@Composable
fun TextFieldLayout(
    modifier: Modifier = Modifier,
    label : @Composable (() -> Unit)? = null,
    description :@Composable (() -> Unit)? = null,
    placeholder :@Composable (() -> Unit)? = null,
    innerTextField : @Composable () -> Unit,
    container : @Composable () -> Unit,
    leadingIcon : @Composable (() -> Unit)? = null,
    trailingIcon : @Composable (() -> Unit)? = null,
    paddingValues: PaddingValues,
){

    val layoutDirection = LocalLayoutDirection.current

    val density = LocalDensity.current

    val startPadding =
        with(density) { paddingValues.calculateStartPadding(layoutDirection).roundToPx() }
    val endPadding =
        with(density) { paddingValues.calculateEndPadding(layoutDirection).roundToPx() }
    val topPadding = with(density) { paddingValues.calculateTopPadding().roundToPx() }
    val bottomPadding = with(density) { paddingValues.calculateBottomPadding().roundToPx() }
    val itemSpacing = with(density){8.dp.roundToPx()}
    Layout(
        modifier = modifier
            .defaultMinSize(minWidth = 300.dp),
        content = {
            label?.let {
                Box(
                    modifier = Modifier.layoutId(TextFieldLayoutContents.Label), content = { it() })
            }

            description?.let {
                Box(
                    modifier = Modifier.layoutId(TextFieldLayoutContents.Description),
                    content = { it() })
            }

            Box(
                modifier = Modifier.layoutId(TextFieldLayoutContents.Container)
            ) {
                container()
            }

            placeholder?.let {
                Box(modifier = Modifier.layoutId(TextFieldLayoutContents.PlaceHolder), content = {
                    it()
                })
            }

            leadingIcon?.let {
                Box(
                    modifier = Modifier.layoutId(TextFieldLayoutContents.LeadingIcon),
                    content = { it() })
            }
            Box(
                modifier = Modifier.layoutId(TextFieldLayoutContents.InnerTextField),
                content = { innerTextField() }
            )
            trailingIcon?.let {
                Box(
                    modifier = Modifier.layoutId(TextFieldLayoutContents.TrailingIcon),
                    content = { it() })
            }

        }
    )
    { measurables, constraints ->


     val looseConstraints = constraints.copy(minWidth = 0, minHeight = 0)
        val defaultMinWidth = TextFieldDefaults.minimumTextFieldWidth .roundToPx()


        val targetWidth = defaultMinWidth
            .coerceIn(constraints.minWidth, constraints.maxWidth)
     // label placeable

     val labelPlaceable = measurables.firstOrNull { it.layoutId == TextFieldLayoutContents.Label }?.measure(looseConstraints)


     val leadingPlaceable = measurables.firstOrNull { it.layoutId == TextFieldLayoutContents.LeadingIcon }?.measure(looseConstraints)

     val leadingPlaceableHeight = leadingPlaceable?.height ?:0
     val leadingPlaceableWidth = leadingPlaceable?.width ?:0

     val trailingPlaceable = measurables.fastFirstOrNull { it.layoutId == TextFieldLayoutContents.TrailingIcon }?.measure(looseConstraints)

     val trailingPlaceableHeight = trailingPlaceable?.height ?:0
     val trailingPlaceableWidth = trailingPlaceable?.width ?:0

     val leadingTrailingWidth = (leadingPlaceableWidth + if (leadingPlaceable != null) itemSpacing + startPadding else 0) + (trailingPlaceableWidth + if(trailingPlaceable != null) itemSpacing+ endPadding else 0)



     val textFieldWidth = targetWidth - leadingTrailingWidth

     val textfieldPlaceable =
         measurables.first { it.layoutId == TextFieldLayoutContents.InnerTextField }.measure(looseConstraints.copy(maxWidth = textFieldWidth))

     val textFieldContainerHeight = maxOf(
         textfieldPlaceable.height ?: 0,
         leadingPlaceableHeight,
         trailingPlaceableHeight
     ).plus(topPadding + bottomPadding).coerceAtLeast(56.dp.roundToPx())
     val placeHolderPlaceable = measurables.fastFirstOrNull {
         it.layoutId == TextFieldLayoutContents.PlaceHolder
     }?.measure(looseConstraints.copy(maxWidth = textFieldWidth))

        val containerPlaceable = measurables.firstOrNull { it.layoutId == TextFieldLayoutContents.Container }
            ?.measure(
                Constraints.fixed(
                    width = targetWidth,
                    height = textFieldContainerHeight
                )
            )

        val descriptionPlaceable = measurables.fastFirstOrNull { it.layoutId == TextFieldLayoutContents.Description }?.measure(looseConstraints)
        val labelHeight = if (labelPlaceable != null) labelPlaceable.height + itemSpacing else 0
        val descriptionHeight = if (descriptionPlaceable != null) descriptionPlaceable.height + itemSpacing else 0
        val containerHeight = textFieldContainerHeight + labelHeight + descriptionHeight

        val labelHeightWithSpacing = if (labelPlaceable != null) labelPlaceable.height + itemSpacing else 0
        layout(
            width = targetWidth,
            height = containerHeight
        ) {
            var currentX = 0
            labelPlaceable?.placeRelative(
                x = 0,
                y = 0
            )
            val currentY = if (labelPlaceable != null) labelPlaceable.height + itemSpacing else 0
            containerPlaceable?.placeRelative(x = 0, y = currentY)

            currentX += startPadding

            leadingPlaceable?.place(
                x = currentX,
                y = labelHeightWithSpacing +(textFieldContainerHeight - leadingPlaceableHeight) / 2            )

            currentX += leadingPlaceableWidth + itemSpacing
            textfieldPlaceable?.place(
                x = currentX,
                y = labelHeightWithSpacing +(textFieldContainerHeight - textfieldPlaceable.height) /2
            )
            placeHolderPlaceable?.place(
                x = currentX,
                y = labelHeightWithSpacing +(textFieldContainerHeight - textfieldPlaceable.height) /2
            )



            currentX = targetWidth - endPadding - trailingPlaceableWidth
            trailingPlaceable?.place(
                x = currentX,
                y = labelHeightWithSpacing +(textFieldContainerHeight - trailingPlaceableHeight) /2
            )

            descriptionPlaceable?.place(
                x =  0,
                y =labelHeightWithSpacing +  textFieldContainerHeight + itemSpacing
            )


        }
}}

enum class TextFieldLayoutContents{
    Label,
    Description,
    Container,
    PlaceHolder,
    InnerTextField,
    LeadingIcon,
    TrailingIcon
}



@Composable
private fun TextFieldContainer(
    shape: Shape,
    enabled: Boolean,
    focused: Boolean,
    error: Boolean,
    focusRequester: FocusRequester,
    textFieldColors: TextFieldColors,
    borderWidth: OutlinedBorderWidth,
    interactionSource: MutableInteractionSource,
){

    val borderColor by animateColorAsState(
        targetValue = textFieldColors.borderColor(
            enabled = enabled,
            focused = focused,
            error = error
        )
    )

    val width by animateDpAsState(
        targetValue = when {
            focused -> borderWidth.focusedBorderWidth
            error -> borderWidth.errorBorderWidth
            !enabled -> borderWidth.disabledBorderWidth
            else -> borderWidth.unFocusedBorderWidth
        }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = shape)
            //.background(Color.Red)

            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    if (!focused) {
                        focusRequester.requestFocus()
                    }
                }
            )
            .border(width = width, color = borderColor, shape = shape)

    )
}

// decoration box for the text field
@Composable
private fun DecorationBox(
    innerTextField : @Composable () -> Unit,
    enabled: Boolean,
    placeholder :@Composable (()-> Unit) ?,
    isError:  Boolean,
    isFocused : Boolean,
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
                       focused = isFocused
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
                LocalTextStyle provides KoreTheme.typography.label3
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
                        focused = isFocused
                    )
                ) {
                    trailingIcon()
                }
            }
        }
    }}

@Composable
fun OutlinedTextField(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    isError: Boolean = false,
    label: @Composable (() -> Unit)? = null,
    placeholder :@Composable (() -> Unit)? = null,
    description: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: Shape = TextFieldDefaults.defaultTextFieldShape,
    textStyle: TextStyle?= null,
    textFieldColors: TextFieldColors= TextFieldDefaults.outlinedTextFieldColors(),
    borderWidth: OutlinedBorderWidth = TextFieldDefaults.defaultBorderWidth(),
    interactionSource: MutableInteractionSource ? = null,
    decorator: TextFieldDecorator? = null,
    outputTransformation: OutputTransformation? = null,
    inputTransformation: InputTransformation?= null,
    onTextLayout: (Density.(() -> TextLayoutResult?) -> Unit)? = null,
    onKeyboardActions: KeyboardActionHandler? = null,
    contentPadding: PaddingValues = TextFieldDefaults.textFieldPadding,
    lineLimits: TextFieldLineLimits= TextFieldLineLimits.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
){
    BaseTextField(
        state = state,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        error = isError,
        label = label,
        placeholder = placeholder,
        description = description,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        shape = shape,
        textStyle = textStyle,
        textFieldColors = textFieldColors,
        borderWidth = borderWidth,
        interactionSource = interactionSource,
        decorator = decorator,
        contentPadding = contentPadding,
        outputTransformation = outputTransformation,
        inputTransformation = inputTransformation,
        onTextLayout = onTextLayout,
        onKeyboardActions = onKeyboardActions,
        lineLimits = lineLimits,
        keyboardOptions = keyboardOptions
    )
}
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
        focusedTextColor: Color = KoreTheme.colorScheme.onBackGround,
        unFocusedTextColor: Color = KoreTheme.colorScheme.onBackGround,
        errorTextColors: Color = KoreTheme.colorScheme.onBackGround,
        disabledTextColor: Color = KoreTheme.colorScheme.disabled,

        focusedContainerColor: Color = KoreTheme.colorScheme.transparent,
        unFocusedContainerColor: Color = KoreTheme.colorScheme.transparent,
        errorContainerColor: Color = KoreTheme.colorScheme.transparent,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,

        focusedBorderColor: Color = KoreTheme.colorScheme.primary,
        unFocusedBorderColor: Color = KoreTheme.colorScheme.backGroundVariant,
        errorBorderColor: Color = KoreTheme.colorScheme.error,
        disabledBorderColor: Color = KoreTheme.colorScheme.disabled,

        focusedIndicatorColor: Color = KoreTheme.colorScheme.primary,
        unFocusedIndicatorColor: Color = KoreTheme.colorScheme.backGroundVariant,
        errorIndicatorColor: Color = KoreTheme.colorScheme.error,
        disabledIndicatorColor: Color = KoreTheme.colorScheme.disabled,

        labelColor: Color = KoreTheme.colorScheme.onBackGround,
        errorLabelColor: Color = KoreTheme.colorScheme.error,
        disabledLabelColor: Color = KoreTheme.colorScheme.disabled,

        descriptionColor: Color = KoreTheme.colorScheme.onBackGround,
        errorDescriptionColor: Color = KoreTheme.colorScheme.error,
        disabledDescriptionColor: Color = KoreTheme.colorScheme.disabled,


        focusedLeadingIconColor: Color = KoreTheme.colorScheme.onBackGround,
        unFocusedLeadingIconColor: Color = KoreTheme.colorScheme.onBackGroundVariant,
        errorLeadingIconColor: Color = KoreTheme.colorScheme.error,
        disabledLeadingIconColor: Color = KoreTheme.colorScheme.onDisabled,

        focusedTrailingIconColor: Color = KoreTheme.colorScheme.onBackGround,
        unFocusedTrailingIconColor: Color = KoreTheme.colorScheme.onBackGroundVariant,
        errorTrailingIconColor: Color = KoreTheme.colorScheme.error,
        disabledTrailingIconColor: Color = KoreTheme.colorScheme.onDisabled,
    ) = TextFieldColors(
        focusedTextColor = focusedTextColor,
        unFocusedTextColor = unFocusedTextColor,
        errorTextColor = errorTextColors,
        disabledTextColor = disabledTextColor,

        focusedContainerColor = focusedContainerColor,
        unFocusedContainerColor = unFocusedContainerColor,
        errorContainerColor = errorContainerColor,
        disabledContainerColor = disabledContainerColor,

        focusedBorderColor = focusedBorderColor,
        unFocusedBorderColor = unFocusedBorderColor,
        errorBorderColor = errorBorderColor,
        disabledBorderColor = disabledBorderColor,

        focusedIndicatorColor = focusedIndicatorColor,
        unFocusedIndicatorColor = unFocusedIndicatorColor,
        errorIndicatorColor = errorIndicatorColor,
        disabledIndicatorColor = disabledIndicatorColor,

        labelColor = labelColor,
        errorLabelColor = errorLabelColor,
        disabledLabelColor = disabledLabelColor,

        descriptionColor = descriptionColor,
        errorDescriptionColor = errorDescriptionColor,
        disabledDescriptionColor = disabledDescriptionColor,


        focusedLeadingIconColor = focusedLeadingIconColor,
        unFocusedLeadingIconColor = unFocusedLeadingIconColor,
        errorLeadingIconColor = errorLeadingIconColor,
        disabledLeadingIconColor = disabledLeadingIconColor,

        focusedTrailingIconColor = focusedTrailingIconColor,
        unFocusedTrailingIconColor = unFocusedTrailingIconColor,
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
class TextFieldColors(
    val focusedTextColor: Color,
    val unFocusedTextColor: Color,
    val errorTextColor: Color,
    val disabledTextColor: Color,

    val focusedContainerColor: Color,
    val unFocusedContainerColor: Color,
    val errorContainerColor: Color,
    val disabledContainerColor: Color,

    val focusedBorderColor: Color,
    val unFocusedBorderColor: Color,
    val errorBorderColor: Color,
    val disabledBorderColor: Color,

    val focusedIndicatorColor: Color,
    val unFocusedIndicatorColor: Color,
    val errorIndicatorColor: Color,
    val disabledIndicatorColor: Color,

    val labelColor: Color,
    val errorLabelColor: Color,
    val disabledLabelColor: Color,

    val descriptionColor : Color,
    val errorDescriptionColor : Color,
    val disabledDescriptionColor : Color,

    val focusedLeadingIconColor: Color,
    val unFocusedLeadingIconColor: Color,
    val errorLeadingIconColor: Color,
    val disabledLeadingIconColor: Color,

    val focusedTrailingIconColor: Color,
    val unFocusedTrailingIconColor: Color,
    val errorTrailingIconColor: Color,
    val disabledTrailingIconColor: Color,
){
    /**
     * function to get the textfield text color [Color]
     */
    fun textColor(
        enabled: Boolean,
        error: Boolean,
        focused: Boolean
    ): Color {
        return when {
            !enabled -> disabledTextColor
            error -> errorTextColor
            focused -> focusedTextColor
            else -> unFocusedTextColor
        }
    }


    //function to get the label color
    fun labelColor(
        enabled: Boolean,
        error: Boolean,
    ) : Color{
        return  when {
            !enabled -> disabledLabelColor
            error -> errorLabelColor
            else -> labelColor
        }
    }

    /**
     * function to get the containerColor  [Color]
     *
     */

    fun containerColor(
        enabled: Boolean,
        error: Boolean,
        focused: Boolean
    ): Color{
        return when {
            !enabled -> this.disabledContainerColor
            error -> this.errorContainerColor
            focused-> this.focusedContainerColor
            else -> this.unFocusedContainerColor
        }
    }

    /**
     * function to get the borderColor [Color]
     */

    fun borderColor(
        enabled: Boolean,
        error: Boolean,
        focused: Boolean
    ): Color {
        val isError: Boolean = enabled && error
        return when {
            !enabled -> disabledBorderColor
            isError -> errorBorderColor
            focused -> focusedBorderColor
            else -> unFocusedBorderColor
        }
    }

    /**
     * function to get the text handle indicator [Color]
     */

    fun indicatorColor(
        enabled: Boolean,
        error: Boolean,
        focused: Boolean
    ): Color {
        return when {
            !enabled -> this.disabledIndicatorColor
            error -> this.errorIndicatorColor
            focused -> this.focusedIndicatorColor
            else -> this.unFocusedIndicatorColor
        }
    }

    // function to get the leadin Icon color
    fun leadingIconColor(
        enabled: Boolean,
        error: Boolean,
        focused: Boolean
    ) : Color{
        return when{
            !enabled -> disabledLeadingIconColor
            error -> errorLeadingIconColor
            focused -> focusedLeadingIconColor
            else -> unFocusedLeadingIconColor
        }
    }

    // function to get the trailing Icon

    fun trailingIconColor(
        enabled: Boolean,
        error: Boolean,
        focused: Boolean
    ) : Color{
        return when {
            !enabled -> disabledTrailingIconColor
            error -> errorTrailingIconColor
            focused -> focusedTrailingIconColor
            else -> unFocusedTrailingIconColor
        }
}}

@Immutable
data class OutlinedBorderWidth(
    val focusedBorderWidth : Dp,
    val unFocusedBorderWidth : Dp,
    val errorBorderWidth : Dp,
    val disabledBorderWidth : Dp
)


