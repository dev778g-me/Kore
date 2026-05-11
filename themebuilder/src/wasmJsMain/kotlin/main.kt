package com.dev.webtesting

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.bindToBrowserNavigation
import androidx.navigation.toRoute
import com.dev.themebuilder.ui.ThemeApp
import com.dev.themebuilder.ui.theme.BuilderTheme
import com.dev.themebuilder.ui.view.navigation.AppRoute
import com.dev.themebuilder.ui.view.screens.HomeScreen
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class, ExperimentalBrowserHistoryApi::class)
fun main() {
    val body = document.body ?: return
    ComposeViewport(body) {
        BuilderTheme(isDark = false) {
            ThemeApp(
                onNavHostReady = { navController ->
                    navController.bindToBrowserNavigation(){entry ->
                        val route = entry.destination.route.orEmpty()

                        when{
                            route.startsWith(AppRoute.Home.serializer().descriptor.serialName) ->{
                                "#home"
                            }

                            route.startsWith(AppRoute.Docs.serializer().descriptor.serialName) ->{
                                val args = entry.toRoute<AppRoute.Docs>()

                                "#docs/${args.path}"
                            }

                            route.startsWith(AppRoute.Create.serializer().descriptor.serialName)->{
                                "#create"
                            }



                            route.startsWith(AppRoute.ChangeLog.serializer().descriptor.serialName)->{
                                "#changelog"
                            }

                            else -> ""
                        }
                    }
                }
            )
        }
    }
}