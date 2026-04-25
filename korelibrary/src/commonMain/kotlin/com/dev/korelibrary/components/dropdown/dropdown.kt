package com.dev.korelibrary.components.dropdown

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.themes.LocalContentColor
import com.dev.korelibrary.utilities.modifiers.shimmer


/**
 * A Dropdown Menu presents a list of actions,options or items in a temporary surface
 * they provide access to various feature and functionalities of the app
 * @param expanded the state that defines the visibility of the dropdown menu [Boolean]
 * @param onDismissRequest the callback invoked when the user requests to dismiss the dropdown menu [Unit]
 * @param modifier the [Modifier] applied to Dropdown
 * @param offset the offset of the dropdown  [DpOffset]
 * @param shape the shape of the DropDown [Shape]
 * @param scrollState the Scroll state of the DropDown [ScrollState]
 * @param
 */
@Composable
fun DropDown(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    offset: DpOffset = DpOffset.Zero,
    shape: Shape = DropdownDefaults.defaultDropDownShape,
    scrollState: ScrollState = rememberScrollState(),
    borderStroke: BorderStroke? = null,
    containerColor: Color = DropdownDefaults.defaultContainerColor,
    itemSpacing: Dp = DropdownDefaults.defaultDropDownMargin,
    contentPaddingValues: PaddingValues = DropdownDefaults.defaultDropDownContainerPaddingValues,
    animationSpec: DropDownAnimationSpec = DropdownDefaults.defaultDropDownAnimationSpec(),
    content: @Composable ColumnScope.() -> Unit
) {
    val density = LocalDensity.current
    val expandedState = remember { MutableTransitionState(false) }
    expandedState.targetState = expanded
    val transformOriginState = remember { mutableStateOf(TransformOrigin.Center) }
    val popupPositionProvider = remember(density, offset) {
        DropDownMenuPositionProvider(
            contentOffset = offset, density = density
        ){anchorBounds, menuBounds ->
          transformOriginState.value =  calculateTransformOrigin(
                anchorBounds = anchorBounds,
                menuBounds = menuBounds
            )
        }
    }
    if (expandedState.currentState || expandedState.targetState) {



    Popup(
        popupPositionProvider = popupPositionProvider,
        onDismissRequest = onDismissRequest,
        content = {
            DropDownContent(
                expandedState = expandedState,
                modifier = modifier,
                transformOriginState =transformOriginState ,
                shape = shape,
                scrollState = scrollState,
                borderStroke = borderStroke,
                contentPaddingValues = contentPaddingValues,
                containerColor =containerColor,
                animationSpec = animationSpec,
                content = content
            )
        })

}}


@Composable
fun DropDownItem(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    onClick: () -> Unit,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    shape: Shape = KoreTheme.shapes.sm,
    colors: DropDownItemColors = DropdownDefaults.defaultDropDownItemColors(),
    paddingValues: DropDownMenuItemPaddingValues = DropdownDefaults.defaultDropDownMenuItemPaddingValues(),
    interactionSource: MutableInteractionSource? = null,
) {
    val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }


    val containerColor by animateColorAsState(targetValue = colors.containerColor(enabled = enabled))

    val contentColor by animateColorAsState(targetValue = colors.contentColor(enabled = enabled))

    val leadingContentColor by animateColorAsState(targetValue = colors.leadingContentColor(enabled = enabled))

    val trailingContentColor by animateColorAsState(targetValue = colors.trailingContentColor(enabled = enabled))
    Row(
        modifier = Modifier.fillMaxWidth()
            .sizeIn(
                minWidth = 112.dp,
                maxWidth = 200.dp
            )
            .clip(shape)
            .background(color = containerColor, shape = shape)
            .clickable(
                enabled = enabled,
                onClick = onClick,
                indication = LocalIndication.current,
                interactionSource = resolvedInteractionSource
            ).padding(paddingValues.containerPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        leading?.let { leadingContent ->
            Box(modifier = Modifier.defaultMinSize(DropdownDefaults.defaultMinLeadingSize).padding(paddingValues.leadingPaddingValues)) {
               CompositionLocalProvider(
                   value = LocalContentColor provides leadingContentColor
               ){
                   leadingContent()
               }
            }
        }

        Box(
            modifier = Modifier.weight(1f),
        ){
            CompositionLocalProvider(
                value = LocalContentColor provides contentColor
            ){
                title()
            }
        }

        trailing?.let { trailingContent ->
            Box(modifier = Modifier.defaultMinSize(DropdownDefaults.defaultMinTrailingSize).padding(paddingValues.trailingPaddingValues)) {
             CompositionLocalProvider(
                 value = LocalContentColor provides trailingContentColor
             ){
                 trailingContent()
             }
            }
        }

    }
}




@Composable
internal fun DropDownContent(
    modifier: Modifier = Modifier,
    expandedState: MutableTransitionState<Boolean>,
    transformOriginState : MutableState<TransformOrigin>,
    scrollState: ScrollState,
    contentPaddingValues: PaddingValues,
    borderStroke: BorderStroke? = null,
    itemSpacing: Dp = DropdownDefaults.defaultDropDownItemSpacing,
    itemSize: DropDownItemSize = DropdownDefaults.defaultDropDownItemSize,
    shape: Shape = DropdownDefaults.defaultDropDownShape,
    containerColor: Color = DropdownDefaults.defaultContainerColor,
    animationSpec: DropDownAnimationSpec,
    content: @Composable ColumnScope.() -> Unit
){
    val transition = rememberTransition(expandedState)

    val scale by transition.animateFloat(
        transitionSpec = {
            if (false isTransitioningTo true){
                tween(durationMillis = animationSpec.inTransitionDuration, easing = LinearOutSlowInEasing)
            }else{
                tween(durationMillis = animationSpec.outTransitionDuration, easing = FastOutLinearInEasing)
            }
        },

    ){expanded ->
        if (expanded) animationSpec.expandedScaleTarget else animationSpec.closedScaleTarget
    }

    val alpha by transition.animateFloat(
        transitionSpec = {
            if (false isTransitioningTo true){
                tween(durationMillis = animationSpec.inTransitionDuration)
            } else {
                tween(durationMillis = animationSpec.outTransitionDuration)
            }
        }
    ) {
        if(it) animationSpec.expandedAlphaTarget else animationSpec.closedAlphaTarget
    }


    val isInspecting = LocalInspectionMode.current
    Column(
        modifier = modifier
            .widthIn(min = itemSize.minWidth, max = itemSize.maxWidth)
            .verticalScroll(scrollState)
            .graphicsLayer{
                scaleX =
                    if (!isInspecting) scale
                    else if (expandedState.targetState) animationSpec.expandedScaleTarget else animationSpec.closedScaleTarget
                scaleY =
                    if (!isInspecting) scale
                    else if (expandedState.targetState) animationSpec.expandedScaleTarget else animationSpec.closedScaleTarget
                this.alpha =
                    if (!isInspecting) alpha
                    else if (expandedState.targetState) animationSpec.expandedAlphaTarget else animationSpec.closedAlphaTarget
                transformOrigin = transformOriginState.value

            }

            .clip(shape = shape)
            .background(color = containerColor, shape = shape)
            .border(2.dp, shape = shape, color = KoreTheme.colorScheme.backGroundVariant)
            .padding(contentPaddingValues)
            .width(IntrinsicSize.Max),
        content = content
    )



}










object DropdownDefaults{
    val defaultDropDownMargin = 48.dp


    val defaultDropDownShape : Shape
        @Composable get() = KoreTheme.shapes.md

    val defaultContainerColor : Color
        @Composable get() = KoreTheme.colorScheme.surface


    val defaultDropDownItemSpacing : Dp
        @Composable get() = KoreTheme.sizes.xxs


    val defaultDropDownItemSize = DropDownItemSize(
        maxWidth = 280.dp,
        minWidth = 112.dp
    )



    val defaultDropDownContainerPaddingValues : PaddingValues = PaddingValues(8.dp)


    val defaultMinLeadingSize : Dp = 24.dp


    val defaultMinTrailingSize : Dp = 24.dp





    fun defaultDropDownAnimationSpec(
        inTransitionDuration: Int = 200,
        outTransitionDuration: Int = 100,
        expandedScaleTarget: Float = 1f,
        closedScaleTarget: Float = 0.8f,
        expandedAlphaTarget: Float = 1f,
        closedAlphaTarget: Float = 0f
    ) : DropDownAnimationSpec = DropDownAnimationSpec(
        inTransitionDuration = inTransitionDuration,
        outTransitionDuration = outTransitionDuration,
        expandedScaleTarget = expandedScaleTarget,
        closedScaleTarget = closedScaleTarget,
        expandedAlphaTarget = expandedAlphaTarget,
        closedAlphaTarget = closedAlphaTarget
    )


    fun defaultDropDownMenuItemPaddingValues(
        containerPadding: PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        leadingPaddingValues: PaddingValues = PaddingValues(end = 8.dp),
        trailingPaddingValues: PaddingValues = PaddingValues(start = 8.dp)
    ) = DropDownMenuItemPaddingValues(
        containerPadding = containerPadding,
        leadingPaddingValues = leadingPaddingValues,
        trailingPaddingValues = trailingPaddingValues
    )

    @Composable
    fun defaultDropDownItemColors(
        containerColor: Color = KoreTheme.colorScheme.surface,
        contentColor: Color = KoreTheme.colorScheme.onBackGround,
        leadingContentColor: Color = KoreTheme.colorScheme.onBackGround,
        trailingContentColor: Color = KoreTheme.colorScheme.onBackGround,
        disabledContainerColor: Color = KoreTheme.colorScheme.surface,
        disabledContentColor: Color = KoreTheme.colorScheme.onDisabled,
        disabledLeadingContentColor: Color= KoreTheme.colorScheme.onDisabled,
        disabledTrailingContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = DropDownItemColors(
        containerColor = containerColor,
        contentColor = contentColor,
        leadingContentColor = leadingContentColor,
        trailingContentColor = trailingContentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor,
        disabledLeadingContentColor = disabledLeadingContentColor,
        disabledTrailingContentColor = disabledTrailingContentColor
    )

}


@Immutable
data class DropDownMenuItemPaddingValues(
    val containerPadding: PaddingValues,
    val leadingPaddingValues: PaddingValues,
    val trailingPaddingValues: PaddingValues
)

@Immutable
data class DropDownItemSize(
    val maxWidth : Dp,
    val minWidth : Dp
)





@Immutable
data class DropDownAnimationSpec(
    val inTransitionDuration: Int,
    val outTransitionDuration : Int,
    val expandedScaleTarget : Float,
    val closedScaleTarget: Float,
    val expandedAlphaTarget : Float,
    val closedAlphaTarget: Float,
)



@Immutable
data class DropDownItemColors(
    val containerColor : Color,
    val contentColor : Color,
    val leadingContentColor : Color,
    val trailingContentColor : Color,
    val disabledContainerColor : Color,
    val disabledContentColor : Color,
    val disabledLeadingContentColor: Color,
    val disabledTrailingContentColor : Color,
)



fun DropDownItemColors.containerColor(
    enabled: Boolean
) : Color {
return    if (enabled) containerColor else disabledContainerColor
}

fun DropDownItemColors.contentColor(
    enabled: Boolean
) : Color {
   return if (enabled) contentColor else disabledContentColor
}

fun DropDownItemColors.leadingContentColor(
    enabled: Boolean
) : Color {
    return if (enabled) leadingContentColor else disabledLeadingContentColor
}

fun DropDownItemColors.trailingContentColor(
    enabled: Boolean
) : Color {
    return if (enabled) trailingContentColor else disabledTrailingContentColor
}



















