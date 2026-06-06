package com.dev.themebuilder.ui.docs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.dev.kore.components.badge.BadgeDefaults
import com.dev.kore.components.badge.SecondaryBadge
import com.dev.kore.components.card.OutlinedCard
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.separators.HorizontalSeparator
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Eye
import com.phosphor.icons.regular.EyeSlash

@Composable
fun ComponentShowcase(
    modifier: Modifier = Modifier,

    code: String,
    initiallyExpanded: Boolean = false,
    contentPadding: PaddingValues = PaddingValues(40.dp),
    content: @Composable () -> Unit
) {

    var showCode by remember {
        mutableStateOf(initiallyExpanded)
    }

    OutlinedCard(
        contentPaddingValues = PaddingValues(0.dp),
        modifier = modifier.fillMaxWidth().padding(
            vertical = 16.dp
        )
    ) {

        VerticalStack(
            spacing = 0.dp
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth().padding(end = 12.dp, top = 12.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                CodeSwitch(
                    onClick = {
                        showCode = !showCode
                    },
                    icon =  if (showCode) PhIcons.Regular.EyeSlash else PhIcons.Regular.Eye,
                    content = if (showCode) "Hide Code" else "Show Code"
                )

            }




            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(contentPadding),
                contentAlignment = Alignment.Center
            ) {
                content()
            }

            SecondaryBadge(content = {
                com.dev.kore.components.text.Text("Code")
            }, modifier = Modifier
                .padding(end = 12.dp, bottom = 12.dp)
                .graphicsLayer{
                alpha = 0f
            })
            AnimatedVisibility(
                visible = showCode,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {

                VerticalStack(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    HorizontalSeparator()
                    CodeBlock(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        code = code
                    )
                }

            }


        }
    }
}


@Composable
fun CodeSwitch (
    modifier: Modifier = Modifier,

    onClick : ()-> Unit,
    icon : ImageVector,
    content : String,
) {
    SecondaryBadge(
        badgeColors = BadgeDefaults.secondaryBadgeColors(
            containerColor = KoreTheme.colorScheme.backGroundVariant,
            contentColor = KoreTheme.colorScheme.onBackGround
        ),
        modifier = modifier

            .clip(KoreTheme.shapes.lg)
            .clickable(
                onClick = {
                    onClick()
                }
            ),
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = "")
        },
        content = {
            Text(content)
        }
    )
}