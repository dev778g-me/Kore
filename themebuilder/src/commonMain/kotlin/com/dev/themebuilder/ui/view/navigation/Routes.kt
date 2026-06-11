package com.dev.themebuilder.ui.view.navigation

import com.dev.themebuilder.ui.docs.DocRoute
import kotlinx.serialization.Serializable



@Serializable
sealed class AppRoute {

    @Serializable
    data object Home : AppRoute()

    @Serializable
    data object Create : AppRoute()

    @Serializable
    data class Docs(val path: DocRoute) : AppRoute()

    @Serializable
    data object ChangeLog : AppRoute()
}