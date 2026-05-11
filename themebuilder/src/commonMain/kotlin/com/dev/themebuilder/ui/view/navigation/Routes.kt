package com.dev.themebuilder.ui.view.navigation

import kotlinx.serialization.Serializable


@Serializable
sealed class AppRoute(val route: String) {

    @Serializable
    data object Home : AppRoute(route = "home")

    @Serializable
    data object Create : AppRoute(route = "create")

    @Serializable
    data class Components(val path: String) : AppRoute(route = "docs")

    @Serializable
    data object ChangeLog : AppRoute(route = "changelog")
}