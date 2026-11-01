package com.dev.kore.shared.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.dev.kore.shared.components.ComponentCatalog
import com.dev.kore.shared.screens.home.HomeScreen
import com.dev.kore.shared.screens.showcase.ComponentScreen
import com.dev.kore.shared.screens.showcase.ModifiersListScreen
import com.dev.kore.themes.KoreTheme

/**
 * The navigation graph of the showcase app, built with the type-safe navigation
 * APIs. Every destination is wrapped in its own [com.dev.kore.components.scaffold.Scaffold].
 *
 * Enter/exit (and pop) transitions are driven by the Kore motion config
 * ([KoreTheme.motion]), using the `calm` tier since these are page-level
 * changes. The active preset (Balanced/Lively/Reduced/Still) therefore
 * changes how screens slide in and out too.
 */
@Composable
fun KoreNavHost() {
    val navController = rememberNavController()
    val motion = KoreTheme.motion

    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        enterTransition = {
            slideInHorizontally(
                animationSpec = motion.calm.spec<IntOffset>(),
                initialOffsetX = { it },
            )
        },
        exitTransition = {
            slideOutHorizontally(
                animationSpec = motion.calm.spec<IntOffset>(),
                targetOffsetX = { -it },
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                animationSpec = motion.calm.spec<IntOffset>(),
                initialOffsetX = { -it },
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                animationSpec = motion.calm.spec<IntOffset>(),
                targetOffsetX = { it },
            )
        },
    ) {
        composable<HomeRoute> {
            HomeScreen(
                onComponentClick = { componentId ->
                    if (componentId == "modifiers") {
                        navController.navigate(ModifiersRoute)
                    } else {
                        navController.navigate(ShowcaseRoute(componentId = componentId))
                    }
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

        composable<ModifiersRoute> {
            ModifiersListScreen(
                onBack = { navController.popBackStack() },
                onModifierClick = { modifierId ->
                    navController.navigate(ShowcaseRoute(componentId = modifierId))
                },
            )
        }
    }
}
