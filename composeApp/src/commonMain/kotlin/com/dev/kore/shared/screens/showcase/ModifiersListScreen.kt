package com.dev.kore.shared.screens.showcase

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.appbar.Appbar
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.listtile.ListTile
import com.dev.kore.components.scaffold.Scaffold
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.ComponentCatalog
import com.dev.kore.shared.screens.home.joinedBlockShape
import com.dev.kore.shared.theme.LocalAppSettings
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.CaretLeft
import com.phosphor.icons.regular.CaretRight
import com.phosphor.icons.regular.Moon
import com.phosphor.icons.regular.Sun

/**
 * A list screen (mirroring the home screen styling) of every modifier demo.
 */
@Composable
fun ModifiersListScreen(
    onBack: () -> Unit,
    onModifierClick: (String) -> Unit,
) {
    val settings = LocalAppSettings.current

    Scaffold(
        windowInsets = WindowInsets(0.dp),
        appBar = {
            Appbar(
                elevation = 0.dp,
                title = {
                    Text("Modifiers", textStyle = KoreTheme.typography.heading3)
                },
                navigationIcon = {
                    GhostIconButton(onClick = onBack) {
                        Icon(
                            imageVector = PhIcons.Regular.CaretLeft,
                            contentDescription = "Back",
                        )
                    }
                },
                appBarAction = {
                    GhostIconButton(onClick = settings.onToggleDark) {
                        AnimatedContent(settings.isDark, transitionSpec = {
                            scaleIn() + fadeIn() togetherWith scaleOut() + fadeOut()
                        }) { isDark ->
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
            items(ComponentCatalog.modifiers, key = { it.id }) { entry ->
                val isFirstEntry = ComponentCatalog.modifiers.firstOrNull()?.id == entry.id
                val isLastEntry = ComponentCatalog.modifiers.lastOrNull()?.id == entry.id

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
                        Icon(
                            imageVector = PhIcons.Regular.CaretRight,
                            contentDescription = null,
                            tint = KoreTheme.colorScheme.onBackGroundVariant,
                        )
                    },
                    onClick = { onModifierClick(entry.id) },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 1.dp),
                )
            }
        }
    }
}
