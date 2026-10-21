package com.dev.kore.components.accordion

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.collapse
import androidx.compose.ui.semantics.expand
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp
import com.dev.kore.components.separators.HorizontalSeparator
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.LocalContentColor
import com.dev.kore.themes.LocalTextStyle

/**
 * An Accordion is a vertically stacked header that when clicked expand or collapsed to show expanded content
 * @param expanded the [Boolean] state that defines the expanded state of the accordion
 * @param onExpand the callback that gets invoked when accordion is clicked [Unit]
 * @param modifier the [Modifier] that is applied to the Accordion
 * @param header the header of the Accordion [Composable]
 * @param expandedContent the expandedContent of the Accordion [Composable]
 * @param trailingIcon the trailing content of the Accordion [Composable]
 * @param leadingIcon the leading content of the Accordion [Composable]
 * @param separator the [Boolean] value that let's show or hide the HorizontalSeparator
 * @param enterTransition the enterTransition of the expandedContent [EnterTransition]
 * @param exitTransition the exitTransition of the expandedContent [ExitTransition]
 * @param leadingIconAlignment the vertical alignment of the leadingIcon
 * @param headerContentPaddingValues the paddingValues of the header [PaddingValues]
 * @param expandedContentPaddingValues the paddingValues of the expandedContent [PaddingValues]
 */
@Composable
fun Accordion(
    expanded: Boolean,
    onExpand: () -> Unit,
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    expandedContent: @Composable () -> Unit,
    trailingIcon: @Composable () -> Unit,
    leadingIcon: (@Composable () -> Unit)? = null,
    separator: Boolean = true,
    enterTransition: EnterTransition = AccordionDefaults.defaultExpandedContentEnterTransition,
    exitTransition: ExitTransition = AccordionDefaults.defaultExpandedContentExitTransition,
    leadingIconAlignment: Alignment.Vertical = AccordionDefaults.defaultLeadingIconAlignment,
    headerContentPaddingValues: PaddingValues = AccordionDefaults.defaultHeaderContentPadding,
    expandedContentPaddingValues: PaddingValues = AccordionDefaults.defaultExpandedContentPadding
) {



    Box(
        modifier = modifier.defaultMinSize(
            minWidth = AccordionDefaults.defaultAccordionWidth
        )
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            // always showing Content

            CompositionLocalProvider(
                LocalContentColor provides KoreTheme.colorScheme.onBackGround
            ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    //.clip(KoreTheme.shapes.xs)
                    .clickable(
                        onClick = {
                            onExpand.invoke()
                        },
                        role = Role.Button,
                        onClickLabel = if (expanded) "Collapse" else "Expand"
                    )
                    .semantics {
                        role = Role.Button
                        stateDescription = if (expanded) "Expanded" else "Collapsed"
                        if (expanded) {
                            collapse(action = { onExpand.invoke(); true })
                        } else {
                            expand(action = { onExpand.invoke(); true })
                        }
                    }
                    .padding(
                        headerContentPaddingValues
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                // leading icon
                leadingIcon?.let {
                    Box(
                        modifier = modifier
                            .padding(end = 8.dp)
                            .align(leadingIconAlignment)
                    ) {
                        leadingIcon()
                    }
                }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .semantics { heading() }
                    ) {
                        header()
                    }


                trailingIcon()
            }}


            // animated Expanded content

            AnimatedVisibility(
                 visible = expanded, enter = enterTransition, exit = exitTransition
            ) {
                CompositionLocalProvider(
                    values = arrayOf(
                        LocalTextStyle provides KoreTheme.typography.body3,
                        LocalContentColor provides KoreTheme.colorScheme.onBackGroundVariant
                    )
                ) {
                    Box(Modifier.padding(expandedContentPaddingValues)) {
                        expandedContent()
                    }
                }
            }



           if (separator){
            HorizontalSeparator()
           }
        }
    }
}


/**
 * AccordionDefaults is the default values for all the Accordion Composables
 * @property defaultAccordionWidth the minimum width for the Accordion
 * @property defaultExpandedContentPadding the default expandedContent padding [PaddingValues]
 * @property defaultHeaderContentPadding the default headerContent padding [PaddingValues]
 * @property defaultLeadingIconAlignment the default Alignment of the leadingIcon [Alignment.Vertical]
 * @property defaultExpandedContentEnterTransition the default enterTransition of the expandedContent [EnterTransition]
 * @property defaultExpandedContentExitTransition the default exitTransition of the expandedContent [ExitTransition]
 */


object AccordionDefaults{
    val defaultAccordionWidth = 300.dp



    val defaultExpandedContentPadding = PaddingValues(
        horizontal = 8.dp,
        vertical = 8.dp
    )

    val defaultHeaderContentPadding = PaddingValues(
        vertical = 12.dp,
        horizontal = 8.dp
    )

    val defaultLeadingIconAlignment  = Alignment.CenterVertically

    val defaultExpandedContentEnterTransition : EnterTransition
        @Composable get() = fadeIn(
            animationSpec = KoreTheme.motion.calm .spec()
        ) + expandVertically(
            animationSpec = KoreTheme.motion.calm .spec()
        )



    val defaultExpandedContentExitTransition : ExitTransition  @Composable get() = fadeOut(animationSpec = KoreTheme.motion.calm .spec()) + shrinkVertically(animationSpec = KoreTheme.motion.calm .spec())


}