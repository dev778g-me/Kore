package com.dev.themebuilder.ui.view.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.dev.korelibrary.components.appbar.Appbar
import com.dev.korelibrary.components.buttons.PrimaryButton
import com.dev.korelibrary.components.icon.Icon
import com.dev.korelibrary.components.scaffold.Scaffold
import com.dev.korelibrary.components.stack.HorizontalStack
import com.dev.korelibrary.components.stack.VerticalStack
import com.dev.korelibrary.components.tabRow.ScrollableTabRow
import com.dev.korelibrary.components.tabRow.Tab
import com.dev.korelibrary.components.text.Text
import com.dev.korelibrary.themes.KoreTheme
import com.dev.themebuilder.ui.docs.DocsScreen
import com.dev.themebuilder.ui.models.ExportUtils
import com.dev.themebuilder.ui.models.saveFile as saveThemeFile
import com.dev.themebuilder.ui.models.toKoreShapes
import com.dev.themebuilder.ui.theme.LocalThemeViewModel
import com.dev.themebuilder.ui.view.screens.HomeScreen
import com.dev.themebuilder.ui.view.screens.ThemeCreationScreen
import com.phosphor.icons.PhIcons
import com.phosphor.icons.filled.ClockClockwiseFill
import com.phosphor.icons.filled.FileMdFill
import com.phosphor.icons.filled.HouseFill
import com.phosphor.icons.filled.PlusFill
import com.phosphor.icons.regular.ClockCounterClockwise
import com.phosphor.icons.regular.FileMd
import com.phosphor.icons.regular.House
import com.phosphor.icons.regular.Plus
import com.phosphor.icons.regular.FloppyDisk

@Composable
fun BuilderNavHost(
    onNavHostReady: suspend (NavController) -> Unit = {},
    onOpenUrl: (String) -> Unit = {}
) {

    val navController = rememberNavController()

    LaunchedEffect(navController) {
        onNavHostReady(navController)
    }

    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }

    val tabBarEntries = listOf(
        BuilderTabItem("Home", PhIcons.Filled.HouseFill, PhIcons.Regular.House) {
            navController.navigate(AppRoute.Home)
        },
        BuilderTabItem("Create", PhIcons.Filled.PlusFill, PhIcons.Regular.Plus) {
            navController.navigate(AppRoute.Create)
        },
        BuilderTabItem("Docs", PhIcons.Filled.FileMdFill, PhIcons.Regular.FileMd) {
            navController.navigate(AppRoute.Docs("components/overview.md"))
        },
        BuilderTabItem(
            "Changelog",
            PhIcons.Filled.ClockClockwiseFill,
            PhIcons.Regular.ClockCounterClockwise,
            null
        )
    )

    Scaffold(
        appBar = {
            val viewModel = LocalThemeViewModel.current
            val lightColorScheme by viewModel.currentLightColorScheme.collectAsStateWithLifecycle()
            val darkColorScheme by viewModel.currentDarkColorScheme.collectAsStateWithLifecycle()
            val currentSizes by viewModel.provideSizes.collectAsStateWithLifecycle()
            val currentShapes by viewModel.currentShape.collectAsStateWithLifecycle()

            val isCreatePage = selectedTabIndex == 1

            Appbar(
                elevation = 0.dp,
                title = {
                    HorizontalStack {
                        ScrollableTabRow(selectedIndex = selectedTabIndex, tabs = {
                            tabBarEntries.forEachIndexed { index, item ->
                                val isSelected = index == selectedTabIndex
                                Tab(
                                    isSelected = isSelected,
                                    onClick = {
                                        selectedTabIndex = index
                                        item.onClick?.invoke()
                                    },
                                    content = {
                                        Text(
                                            item.name,
                                            textStyle = KoreTheme.typography.title3
                                        )
                                    },
                                    icon = {
                                        Icon(
                                            if (isSelected) item.selectedIcon else item.unSelectedIcon,
                                            item.name
                                        )
                                    }
                                )
                            }
                        })
                    }
                },
                appBarAction = {
                    if (isCreatePage) {
                        PrimaryButton(
                            onClick = {
                                val shapes = currentShapes.toKoreShapes()
                                val themeCode = ExportUtils.exportTheme(
                                    darkColorScheme = darkColorScheme,
                                    lightColorScheme = lightColorScheme,
                                    currentSizes = currentSizes,
                                    currentShapes = shapes
                                )
                                saveThemeFile(themeCode, "Theme.kt")
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
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = AppRoute.Home
        ) {
            composable<AppRoute.Home> { HomeScreen() }
            composable<AppRoute.Create> { ThemeCreationScreen(onClick = {}, isDark = false) }
            composable<AppRoute.Docs> {
                val path = it.toRoute<AppRoute.Docs>().path
                DocsScreen(
                    initialPath = path,
                    onNavigate = { newPath ->
                        navController.navigate(AppRoute.Docs(newPath))
                    }
                )
            }
        }
    }

}
data class BuilderTabItem(
    val name: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val onClick: (() -> Unit)?
)