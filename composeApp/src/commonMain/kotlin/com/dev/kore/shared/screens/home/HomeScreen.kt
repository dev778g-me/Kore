package com.dev.kore.shared.screens.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dev.kore.components.appbar.Appbar
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.buttons.OutlinedIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.listtile.ListTile
import com.dev.kore.components.scaffold.Scaffold
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.ComponentCatalog
import com.dev.kore.shared.theme.LocalAppSettings
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.shapes.AbsoluteSmoothCornerShape
import com.dev.kore.utilities.extensions.bold
import com.dev.kore.utilities.extensions.color
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.CaretRight
import com.phosphor.icons.regular.Moon
import com.phosphor.icons.regular.Sun

/**
 * The home screen of the showcase: every component, grouped by section.
 */
@Composable
fun HomeScreen(onComponentClick: (String) -> Unit) {
    val settings = LocalAppSettings.current

    Scaffold(
        windowInsets = WindowInsets(0.dp),
        appBar = {
            Appbar(
                elevation = 0.dp,
                title = {
                    Column {
                        Text("Kore", textStyle = KoreTheme.typography.heading3)
                        Text("Alpha 04", textStyle = KoreTheme.typography.label3
                            .bold()
                            .color(KoreTheme.colorScheme.complementary))

                    }
                },
                appBarAction = {
                    GhostIconButton(onClick = settings.onToggleDark) {
                        AnimatedContent(settings.isDark, transitionSpec = {
                            scaleIn()  + fadeIn() togetherWith scaleOut() + fadeOut()
                        }){ isDark ->
                            Icon(
                                imageVector = if (isDark) PhIcons.Regular.Sun else PhIcons.Regular.Moon,
                                contentDescription = "Toggle dark mode",
                            )
                        }
                    }
                },
            )
        },
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        ) {
            ComponentCatalog.sections.forEach { section ->
                item(key = "section-${section.title}") {
                    Text(
                        text = section.title,
                        textStyle = KoreTheme.typography.label1.color(KoreTheme.colorScheme.primary),
                        modifier = Modifier.padding(top = 16.dp, bottom = 4.dp),
                    )
                }

                items(section.entries, key = { it.id }) { entry ->
                    val isFirstEntry = section.entries.firstOrNull()?.id == entry.id
                    val isLastEntry = section.entries.lastOrNull()?.id == entry.id

                    ListTile(
                        shape = joinedBlockShape(
                            isFirst = isFirstEntry,
                            isLast = isLastEntry,
                        ),
                        title = { Text(entry.title) },
                        subtitle = {
                            Text(
                                text = entry.description,
                                textStyle = KoreTheme.typography.body3,
                                color = KoreTheme.colorScheme.onBackGroundVariant,
                            )
                        },
                        leading = {
                            Icon(
                                imageVector = entry.icon,
                                contentDescription = null,
                                tint = KoreTheme.colorScheme.onBackGroundVariant,
                            )
                        },
                        trailing = {
                            if (entry.comingSoon) {
                                Text(
                                    text = "Soon",
                                    textStyle = KoreTheme.typography.label2,
                                    color = KoreTheme.colorScheme.onDisabled,
                                )
                            } else {
                                Icon(
                                    imageVector = PhIcons.Regular.CaretRight,
                                    contentDescription = null,
                                    tint = KoreTheme.colorScheme.onBackGroundVariant,
                                )
                            }
                        },
                        onClick = if (entry.comingSoon) null else {
                            { onComponentClick(entry.id) }
                        },
                        modifier = Modifier.fillMaxWidth().padding(vertical = 1.dp),
                    )
                }


            }

            item{
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}


internal fun joinedBlockShape(isFirst: Boolean, isLast: Boolean, isSmoothCornerShape : Boolean = false): CornerBasedShape =
    if (isSmoothCornerShape){
        AbsoluteSmoothCornerShape(
            topLeftRadius = if (isFirst) 16.dp else 4.dp,
            topRightRadius = if (isFirst) 16.dp else 4.dp,
            bottomLeftRadius = if (isFirst) 16.dp else 4.dp,
            bottomRightRadius = if (isFirst) 16.dp else 4.dp,
        )
    }else {
        AbsoluteRoundedCornerShape(
            topLeft = if (isFirst) 16.dp else 4.dp,
            topRight = if (isFirst) 16.dp else 4.dp,
            bottomLeft = if (isLast) 16.dp else 4.dp,
            bottomRight = if (isLast) 16.dp else 4.dp
        )
    }