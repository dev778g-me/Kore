package com.dev.kore.shared.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.dev.kore.shared.components.ComponentCatalog
import com.dev.kore.shared.screens.home.HomeScreen
import com.dev.kore.shared.screens.showcase.ComponentScreen

/**
 * The navigation graph of the showcase app, built with the type-safe navigation
 * APIs. Every destination is wrapped in its own [com.dev.kore.components.scaffold.Scaffold].
 */
@Composable
fun KoreNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute,
    ) {
        composable<HomeRoute> {
            HomeScreen(
                onComponentClick = { componentId ->
                    navController.navigate(ShowcaseRoute(componentId = componentId))
                },
            )
        }

        composable<ShowcaseRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<ShowcaseRoute>()
            ComponentScreen(
                entry = ComponentCatalog.find(route.componentId),
                onBack = { navController.popBackStack() },
            )
        }
    }
}
