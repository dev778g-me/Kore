package com.dev.themebuilder.ui.view.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import androidx.savedstate.SavedState
import androidx.savedstate.read
import androidx.savedstate.write
import com.dev.kore.components.appbar.Appbar
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.scaffold.Scaffold
import com.dev.kore.components.stack.HorizontalStack
import com.dev.kore.components.tabRow.ScrollableTabRow
import com.dev.kore.components.tabRow.Tab
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.themebuilder.ui.docs.ChangelogDocs
import com.dev.themebuilder.ui.docs.DocRoute
import com.dev.themebuilder.ui.docs.DocsScreen
import com.dev.themebuilder.ui.models.ExportUtils
import com.dev.themebuilder.ui.view.screens.HomeScreen
import com.dev.themebuilder.ui.view.screens.ThemeCreationScreen
import com.dev.themebuilder.ui.viewmodel.ThemeViewModel
import com.phosphor.icons.PhIcons
import com.phosphor.icons.filled.ClockClockwiseFill
import com.phosphor.icons.filled.HouseFill
import com.phosphor.icons.filled.PlusFill
import com.phosphor.icons.filled.SquaresFourFill
import com.phosphor.icons.regular.ClockCounterClockwise
import com.phosphor.icons.regular.FloppyDisk
import com.phosphor.icons.regular.House
import com.phosphor.icons.regular.Moon
import com.phosphor.icons.regular.Plus
import com.phosphor.icons.regular.SquaresFour
import com.phosphor.icons.regular.Sun
import kotlinx.serialization.json.Json
import kotlin.reflect.typeOf
import com.dev.themebuilder.ui.models.saveFile as saveThemeFile

@Composable
fun BuilderNavHost(
    viewModel: ThemeViewModel,
    onNavHostReady: suspend (NavController) -> Unit = {},
    onThemeChange : () -> Unit,
    isDark : Boolean,
    onOpenUrl: (String) -> Unit = {}
) {

    val navController = rememberNavController()
    LaunchedEffect(navController) {
        onNavHostReady(navController)
    }

    val docsScrollState = rememberScrollState()

    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }

    val tabBarEntries = listOf(
        BuilderTabItem("Home", PhIcons.Filled.HouseFill, PhIcons.Regular.House) {
            navController.navigate(AppRoute.Home)
        },
        BuilderTabItem("Create", PhIcons.Filled.PlusFill, PhIcons.Regular.Plus) {
            navController.navigate(AppRoute.Create)
        },
        BuilderTabItem("Components", PhIcons.Filled.SquaresFourFill, PhIcons.Regular.SquaresFour) {
            navController.navigate(AppRoute.Components(DocRoute.Overview))
        },
        BuilderTabItem(
            "Changelog",
            PhIcons.Filled.ClockClockwiseFill,
            PhIcons.Regular.ClockCounterClockwise
        ) { navController.navigate(AppRoute.ChangeLog) }
    )

    Scaffold(
        appBar = {

            val lightColorScheme by viewModel.currentLightColorScheme.collectAsStateWithLifecycle()
            val darkColorScheme by viewModel.currentDarkColorScheme.collectAsStateWithLifecycle()
            val currentSizes by viewModel.provideSizes.collectAsStateWithLifecycle()
            val currentShapeType by viewModel.currentShapeType.collectAsStateWithLifecycle()
            val currentShapes by viewModel.currentShape.collectAsStateWithLifecycle()
            val currentSource by viewModel.currentPrimaryColorSource.collectAsStateWithLifecycle()
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
                    GhostIconButton(
                        modifier = Modifier.padding(end = 8.dp),
                        onClick = {
                            onThemeChange()
                        }
                    ) {
                        AnimatedContent(
                            targetState = isDark,
                            transitionSpec = {
                                scaleIn() + fadeIn() togetherWith scaleOut() + fadeOut()
                            }
                        ){
                            Icon(
                                imageVector = if (it) PhIcons.Regular.Moon else PhIcons.Regular.Sun,
                                contentDescription = ""
                            )
                        }
                    }

                    AnimatedVisibility(
                        visible = isCreatePage,
                    ){
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
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = AppRoute.Home
        ) {
            composable<AppRoute.Home> { HomeScreen(
                onQuickStart = {

                    navController.navigate(AppRoute.Components(
                        path = DocRoute.Quickstart
                    ))
                }
            ) }
            composable<AppRoute.Create> { ThemeCreationScreen(onClick = {}, viewModel = viewModel, isDark = false) }
            composable<AppRoute.Components>(
                typeMap = mapOf(typeOf<DocRoute>() to DocRouteNavType)
            ) { entry ->
                val route = entry.toRoute<AppRoute.Components>().path
                DocsScreen(
                    initialRoute = route,
                    scrollState = docsScrollState,
                    onNavigate = { newPath ->
                        navController.navigate(AppRoute.Components(newPath))
                    }
                )
            }
            composable<AppRoute.ChangeLog> {
                ChangelogDocs()
            }
        }
    }

}



val DocRouteNavType = object : NavType<DocRoute>(isNullableAllowed = false) {
    override fun get(bundle: SavedState, key: String): DocRoute? {
        return bundle.read {
            if (contains(key)) {
                getString(key).let { Json.decodeFromString(it) }
            } else null
        }
    }

    override fun parseValue(value: String): DocRoute {
        return Json.decodeFromString(value)
    }

    override fun serializeAsValue(value: DocRoute): String {
        return Json.encodeToString(value)
    }

    override fun put(bundle: SavedState, key: String, value: DocRoute) {
        bundle.write {
            putString(key, Json.encodeToString(value))
        }
    }
}
data class BuilderTabItem(
    val name: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val onClick: (() -> Unit)?
)