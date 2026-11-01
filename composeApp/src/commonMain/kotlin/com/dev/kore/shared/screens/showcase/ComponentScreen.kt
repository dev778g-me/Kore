package com.dev.kore.shared.screens.showcase

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.appbar.Appbar
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.scaffold.Scaffold
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.ComponentEntry
import com.dev.kore.shared.theme.LocalAppSettings
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.CaretLeft
import com.phosphor.icons.regular.Moon
import com.phosphor.icons.regular.Sun

/**
 * The generic screen rendering every implementation of a single component.
 */
@Composable
fun ComponentScreen(
    entry: ComponentEntry,
    onBack: () -> Unit,
) {
    Scaffold(
        windowInsets = WindowInsets(0.dp),
        appBar = {
            Appbar(
                elevation = 0.dp,
                title = {
                    Text(entry.title, textStyle = KoreTheme.typography.heading3)
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
                    val settings = LocalAppSettings.current
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Text(
                text = entry.description,
                textStyle = KoreTheme.typography.body2,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
            entry.demo()
        }
    }
}
