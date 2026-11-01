package com.dev.kore.shared.navigation

import kotlinx.serialization.Serializable

/**
 * The home screen listing every component available in Kore.
 */
@Serializable
data object HomeRoute

/**
 * The screen showing the implementations of a single component.
 *
 * @param componentId the id of the entry in
 * [com.dev.kore.shared.components.ComponentCatalog].
 */
@Serializable
data class ShowcaseRoute(val componentId: String)
