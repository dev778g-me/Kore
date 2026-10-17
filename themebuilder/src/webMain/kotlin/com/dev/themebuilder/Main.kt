package com.dev.themebuilder

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.bindToBrowserNavigation
import androidx.navigation.toRoute
import com.dev.themebuilder.ui.ThemeApp
import com.dev.themebuilder.ui.theme.BuilderTheme
import com.dev.themebuilder.ui.view.navigation.AppRoute
import com.dev.themebuilder.ui.viewmodel.ThemeViewModel
import kotlinx.browser.document
import kotlinx.browser.window

@OptIn(ExperimentalComposeUiApi::class, ExperimentalBrowserHistoryApi::class)
fun main() {
    val body = document.body ?: return

    // Embedded under /create on the Astro site: boot straight into the builder.
    // Standalone deployments keep the previous Home start.
    val embedded = window.location.pathname.startsWith("/create")
    val startDestination =
        if (embedded) AppRoute.Create
        else AppRoute.Home

    ComposeViewport(body) {
        val viewModel: ThemeViewModel = viewModel { ThemeViewModel() }
        BuilderTheme(isDark = false, viewModel = viewModel) {
            ThemeApp(
                startDestination = startDestination,
                embedded = embedded,
                onNavHostReady = { navController ->
                    navController.bindToBrowserNavigation() { entry ->
                        val route = entry.destination.route.orEmpty()

                        when {
                            route.startsWith(AppRoute.Home.serializer().descriptor.serialName) -> {
                                "#home"
                            }

                            route.startsWith(AppRoute.Docs.serializer().descriptor.serialName) -> {
                                val args = entry.toRoute<AppRoute.Docs>()

                                "#docs/${args.path}"
                            }

                            route.startsWith(AppRoute.Create.serializer().descriptor.serialName) -> {
                                "#create"
                            }

                            route.startsWith(AppRoute.ChangeLog.serializer().descriptor.serialName) -> {
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
