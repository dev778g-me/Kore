package com.dev.themebuilder.ui.view

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dev.kore.components.appbar.Appbar
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.scaffold.Scaffold
import com.dev.kore.components.stack.HorizontalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.themebuilder.ui.models.ExportUtils
import com.dev.themebuilder.ui.view.screens.ThemeCreationScreen
import com.dev.themebuilder.ui.viewmodel.ThemeViewModel
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.FloppyDisk
import com.phosphor.icons.regular.Moon
import com.phosphor.icons.regular.Sun
import com.dev.themebuilder.ui.models.saveFile as saveThemeFile

@Composable
fun BuilderScaffold(
    viewModel: ThemeViewModel,
    isDark: Boolean,
    onThemeChange: () -> Unit,
) {
    val lightColorScheme by viewModel.currentLightColorScheme.collectAsStateWithLifecycle()
    val darkColorScheme by viewModel.currentDarkColorScheme.collectAsStateWithLifecycle()
    val currentSizes by viewModel.provideSizes.collectAsStateWithLifecycle()
    val currentShapes by viewModel.currentShape.collectAsStateWithLifecycle()
    val currentSource by viewModel.currentPrimaryColorSource.collectAsStateWithLifecycle()

    Scaffold(
        appBar = {
            Appbar(
                elevation = 0.dp,
                title = {
                    Text("Create",)
                },
                appBarAction = {
                    GhostIconButton(
                        modifier = Modifier.padding(end = 8.dp),
                        onClick = onThemeChange
                    ) {
                        AnimatedContent(
                            targetState = isDark,
                            transitionSpec = {
                                scaleIn() + fadeIn() togetherWith scaleOut() + fadeOut()
                            }
                        ) {
                            Icon(
                                imageVector = if (it) PhIcons.Regular.Moon else PhIcons.Regular.Sun,
                                contentDescription = ""
                            )
                        }
                    }

                    PrimaryButton(
                        onClick = {
                            val themeCode = ExportUtils.exportTheme(
                                darkColorScheme = darkColorScheme,
                                lightColorScheme = lightColorScheme,
                                currentSizes = currentSizes,
                                currentShapes = currentShapes,
                                colorSource = currentSource
                            )
                            saveThemeFile(themeCode, "theme.kt")
                        }
                    ) {
                        HorizontalStack(spacing = 4.dp) {
                            Icon(
                                imageVector = PhIcons.Regular.FloppyDisk,
                                contentDescription = "Save",
                                modifier = Modifier.size(18.dp)
                            )
                            Text("Export")
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        ThemeCreationScreen(
            modifier = Modifier.padding(paddingValues),
            viewModel = viewModel,
        )
    }
}
