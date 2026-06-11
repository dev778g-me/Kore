package com.dev.themebuilder.ui.docs

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
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
import androidx.compose.runtime.rememberCoroutineScope
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
import com.phosphor.icons.bold.CheckBold
import com.phosphor.icons.bold.CheckCircleBold
import com.phosphor.icons.regular.Check
import com.phosphor.icons.regular.ClipboardText
import com.phosphor.icons.regular.Eye
import com.phosphor.icons.regular.EyeSlash
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
                Text("Code")
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
@Composable
fun CodeCopyButton(
    modifier: Modifier = Modifier,
    copyContent: String,
    content: String,
) {
    val icon = PhIcons.Regular.ClipboardText
    val coroutineScope = rememberCoroutineScope()

    var isCopied by remember { mutableStateOf(false) }

    val containerColor by animateColorAsState(
        targetValue = if (isCopied) KoreTheme.colorScheme.success else KoreTheme.colorScheme.backGroundVariant,
        label = "containerColorAnimation"
    )

    val contentColor by animateColorAsState(
        targetValue = if (isCopied) KoreTheme.colorScheme.onSuccess else KoreTheme.colorScheme.onBackGround,
        label = "contentColorAnimation"
    )

    SecondaryBadge(
        badgeColors = BadgeDefaults.secondaryBadgeColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        modifier = modifier
            .clip(KoreTheme.shapes.lg)
            .clickable(
                enabled = !isCopied,
                onClick = {
                    copyToClipboard(copyContent)

                    isCopied = true
                    coroutineScope.launch {
                        delay(3000)
                        isCopied = false
                    }
                }
            ),
        leadingIcon = {
            AnimatedContent(
                targetState = isCopied,
                transitionSpec = {
                    (scaleIn(tween(200)) + fadeIn(tween(200))) togetherWith
                            (scaleOut(tween(200)) + fadeOut(tween(200)))
                },
                label = "iconAnimation"
            ) { copied ->
                if (copied) {
                    Icon(imageVector = PhIcons.Bold.CheckCircleBold, contentDescription = "Copied")
                } else {
                    Icon(imageVector = icon, contentDescription = "Copy Code")
                }
            }
        },
        content = {
            AnimatedContent(
                targetState = isCopied,
                transitionSpec = {
                    if (targetState) {

                        (slideInVertically(tween(250)) { height -> height / 2 } + fadeIn(tween(250))) togetherWith
                                (slideOutVertically(tween(250)) { height -> -height / 2 } + fadeOut(tween(250)))
                    } else {
                        (slideInVertically(tween(250)) { height -> -height / 2 } + fadeIn(tween(250))) togetherWith
                                (slideOutVertically(tween(250)) { height -> height / 2 } + fadeOut(tween(250)))
                    }
                },
                label = "textAnimation"
            ) { copied ->
                if (copied) {
                    Text("Code Copied")
                } else {
                    Text(content)
                }
            }
        }
    )
}
