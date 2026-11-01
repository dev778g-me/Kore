package com.dev.kore.shared.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.appbar.Appbar
import com.dev.kore.components.buttons.OutlinedIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.listtile.ListTile
import com.dev.kore.components.scaffold.Scaffold
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.ComponentCatalog
import com.dev.kore.shared.theme.LocalAppSettings
import com.dev.kore.themes.KoreTheme
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
        appBar = {
            Appbar(
                title = {
                    Text("Kore", textStyle = KoreTheme.typography.heading3)
                },
                appBarAction = {
                    OutlinedIconButton(onClick = settings.onToggleDark) {
                        Icon(
                            imageVector = if (settings.isDark) PhIcons.Regular.Sun else PhIcons.Regular.Moon,
                            contentDescription = "Toggle dark mode",
                        )
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
                        textStyle = KoreTheme.typography.heading3,
                        modifier = Modifier.padding(top = 16.dp, bottom = 4.dp),
                    )
                }

                items(section.entries, key = { it.id }) { entry ->
                    ListTile(
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
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
        }
    }
}
