package com.dev.korelibrary.components.accordion

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.animateDpAsState
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.separators.HorizontalSeparator
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.themes.LocalContentColor
import com.dev.korelibrary.themes.LocalTextStyle


@Composable
fun Accordion(
    expanded: Boolean,
    onExpand: () -> Unit,
    modifier: Modifier = Modifier,

    header: @Composable () -> Unit,
    expandedContent: @Composable () -> Unit,

    icon: @Composable () -> Unit,
    leadingIcon: (@Composable () -> Unit)? = null,

    separator: Boolean = true,

    enterTransition: EnterTransition = AccordionDefaults.defaultExpandedContentEnterTransition,
    exitTransition: ExitTransition = AccordionDefaults.defaultExpandedContentExitTransition,

    leadingIconAlignment: Alignment.Vertical = AccordionDefaults.defaultLeadingIconAlignment,

    headerContentPaddingValues: PaddingValues = AccordionDefaults.defaultHeaderContentPadding,
    expandedContentPaddingValues: PaddingValues = AccordionDefaults.defaultExpandedContentPadding
) {

    val bottomPadding by animateDpAsState(
        targetValue = if (expanded) 8.dp else 0.dp
    )
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(KoreTheme.shapes.small)
                    .clickable(
                        onClick = {
                            onExpand.invoke()
                        })
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
                            .padding(end = 4.dp)
                            .align(leadingIconAlignment)
                    ) {
                        leadingIcon()
                    }
                }
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    header()
                }

                icon()
            }


            // animated Expanded content
            AnimatedVisibility(
                modifier = modifier.padding(
                    expandedContentPaddingValues
                ), visible = expanded, enter = enterTransition, exit = exitTransition
            ) {
                CompositionLocalProvider(
                    values = arrayOf(
                        LocalTextStyle provides KoreTheme.typography.bodySmall,
                        LocalContentColor provides KoreTheme.colorScheme.onBackGroundVariant
                    )
                ) {
                    expandedContent()
                }
            }

            Spacer(
                modifier = modifier.height(bottomPadding)
            )

           if (separator){
               HorizontalSeparator()
           }
        }
    }
}







object AccordionDefaults{
    val defaultAccordionWidth = 300.dp

    val defaultExpandedContentPadding = PaddingValues(
        horizontal = 8.dp
    )

    val defaultHeaderContentPadding = PaddingValues(
        vertical = 4.dp,
        horizontal = 4.dp
    )

    val defaultLeadingIconAlignment  = Alignment.CenterVertically

    val defaultExpandedContentEnterTransition : EnterTransition = fadeIn() + expandVertically()

    val defaultExpandedContentExitTransition : ExitTransition = fadeOut() + shrinkVertically()


}