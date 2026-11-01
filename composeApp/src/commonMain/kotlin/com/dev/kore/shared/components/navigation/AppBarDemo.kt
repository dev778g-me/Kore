package com.dev.kore.shared.components.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dev.kore.components.appbar.Appbar
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.buttons.OutlinedIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.CaretLeft
import com.phosphor.icons.regular.DotsThreeVertical
import com.phosphor.icons.regular.MagnifyingGlass
import com.phosphor.icons.regular.ShareNetwork

@Composable
fun AppBarDemo() {
    DemoPage {
        DemoBlock(title = "Title only") {
            Appbar(
                title = { Text("Inbox", textStyle = KoreTheme.typography.heading3) },
                windowInsets = WindowInsets(0, 0, 0, 0),
            )
        }

        DemoBlock(title = "With a navigation icon") {
            Appbar(
                title = { Text("Details", textStyle = KoreTheme.typography.heading3) },
                navigationIcon = {
                    OutlinedIconButton(onClick = {}) {
                        Icon(PhIcons.Regular.CaretLeft, contentDescription = "Back")
                    }
                },
                windowInsets = WindowInsets(0, 0, 0, 0),
            )
        }

        DemoBlock(title = "With actions") {
            Appbar(
                title = { Text("Photos", textStyle = KoreTheme.typography.heading3) },
                navigationIcon = {
                    OutlinedIconButton(onClick = {}) {
                        Icon(PhIcons.Regular.CaretLeft, contentDescription = "Back")
                    }
                },
                appBarAction = {
                    GhostIconButton(onClick = {}) {
                        Icon(PhIcons.Regular.MagnifyingGlass, contentDescription = "Search")
                    }
                    GhostIconButton(onClick = {}) {
                        Icon(PhIcons.Regular.ShareNetwork, contentDescription = "Share")
                    }
                    GhostIconButton(onClick = {}) {
                        Icon(PhIcons.Regular.DotsThreeVertical, contentDescription = "More")
                    }
                },
                windowInsets = WindowInsets(0, 0, 0, 0),
            )
        }

        DemoBlock(title = "Tall app bar") {
            Appbar(
                title = { Text("Dashboard", textStyle = KoreTheme.typography.heading2) },
                minimumAppBarHeight = 88.dp,
                windowInsets = WindowInsets(0, 0, 0, 0),
            )
        }

        DemoBlock(title = "Stacked") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                Appbar(
                    title = { Text("Top") },
                    windowInsets = WindowInsets(0, 0, 0, 0),
                )
                Text(
                    text = "The app bar is a slot based row: navigation icon, title and actions.",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
            }
        }
    }
}
