package com.dev.themebuilder.ui.view.navigation

import kotlinx.browser.window


//    val hash = window.location.hash.removePrefix("#").trimStart('/')
//
//    return when {
//        hash.isEmpty() || hash == RoutePaths.HOME -> AppRoute.Home
//        hash == RoutePaths.CREATE -> AppRoute.Create
//        hash == RoutePaths.CHANGELOG -> AppRoute.ChangeLog
//        hash.startsWith(RoutePaths.DOCS) -> {
//            val path = hash.removePrefix(RoutePaths.DOCS).trimStart('/')
//            if (path.isNotEmpty()) {
//                AppRoute.DocsPath(path)
//            } else {
//                AppRoute.Docs
//            }
//        }
//        else -> AppRoute.Home
//    }
