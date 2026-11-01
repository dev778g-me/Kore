package com.dev.kore.shared.components.feedback

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.badge.BadgeDefaults
import com.dev.kore.components.badge.ErrorBadge
import com.dev.kore.components.badge.OutlinedBadge
import com.dev.kore.components.badge.PrimaryBadge
import com.dev.kore.components.badge.SecondaryBadge
import com.dev.kore.components.badge.SuccessBadge
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Check
import com.phosphor.icons.regular.Sparkle
import com.phosphor.icons.regular.Warning
import com.phosphor.icons.regular.X

@Composable
fun BadgeDemo() {
    DemoPage {
        DemoBlock(title = "Variants") {
            VariantRow {
                PrimaryBadge(content = { Text("New") })
                SecondaryBadge(content = { Text("Beta") })
                SuccessBadge(content = { Text("Active") })
                ErrorBadge(content = { Text("Failed") })
                OutlinedBadge(content = { Text("Draft") })
            }
        }

        DemoBlock(title = "With icons") {
            VariantRow {
                PrimaryBadge(
                    content = { Text("Featured") },
                    leadingIcon = {
                        Icon(PhIcons.Regular.Sparkle, contentDescription = null)
                    },
                )
                SuccessBadge(
                    content = { Text("Verified") },
                    leadingIcon = {
                        Icon(PhIcons.Regular.Check, contentDescription = null)
                    },
                )
                ErrorBadge(
                    content = { Text("Action needed") },
                    leadingIcon = {
                        Icon(PhIcons.Regular.Warning, contentDescription = null)
                    },
                )
                OutlinedBadge(
                    content = { Text("Removable") },
                    trailingIcon = {
                        Icon(PhIcons.Regular.X, contentDescription = null)
                    },
                )
            }
        }

        DemoBlock(title = "Sizes") {
            VariantRow {
                PrimaryBadge(content = { Text("Small") })
                PrimaryBadge(
                    content = { Text("Large") },
                    badgeSizes = BadgeDefaults.defaultBadgeSize(
                        leadingIconSize = 16.dp,
                        trailingIconSize = 16.dp,
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                        containerPadding = PaddingValues(vertical = 4.dp, horizontal = 10.dp),
                    ),
                )
            }
        }

        DemoBlock(title = "Disabled") {
            VariantRow {
                PrimaryBadge(content = { Text("Disabled") }, enabled = false)
                SuccessBadge(content = { Text("Disabled") }, enabled = false)
                ErrorBadge(content = { Text("Disabled") }, enabled = false)
            }
        }

        DemoBlock(title = "Custom shape") {
            VariantRow {
                PrimaryBadge(content = { Text("xs") }, shape = KoreTheme.shapes.xs)
                PrimaryBadge(content = { Text("md") }, shape = KoreTheme.shapes.md)
                PrimaryBadge(content = { Text("xl") }, shape = KoreTheme.shapes.xl)
                PrimaryBadge(
                    content = { Text("O", modifier = Modifier.padding(horizontal = 4.dp)) },
                    shape = androidx.compose.foundation.shape.CircleShape,
                )
            }
        }
    }
}
