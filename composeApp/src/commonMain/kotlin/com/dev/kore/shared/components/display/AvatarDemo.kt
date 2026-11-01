package com.dev.kore.shared.components.display

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.avatar.Avatar
import com.dev.kore.components.badge.PrimaryBadge
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.User

@Composable
fun AvatarDemo() {
    DemoPage {
        DemoBlock(title = "Sizes") {
            Row(
                horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Avatar(avatarSize = 32.dp) { Text("K") }
                Avatar(avatarSize = 40.dp) { Text("Ko") }
                Avatar(avatarSize = 56.dp) { Text("Kor") }
                Avatar(avatarSize = 72.dp) { Text("Kore") }
            }
        }

        DemoBlock(title = "With an icon or initials") {
            VariantRow {
                Avatar {
                    Text("AL")
                }
                Avatar(
                    containerColor = KoreTheme.colorScheme.primaryContainer,
                    contentColor = KoreTheme.colorScheme.onPrimaryContainer,
                ) {
                    Text("KO")
                }
                Avatar {
                    Icon(PhIcons.Regular.User, contentDescription = "User")
                }
            }
        }

        DemoBlock(title = "Shapes") {
            VariantRow {
                Avatar(shape = CircleShape) { Text("C") }
                Avatar(shape = KoreTheme.shapes.md) { Text("md") }
                Avatar(shape = KoreTheme.shapes.xs) { Text("xs") }
            }
        }

        DemoBlock(title = "With a badge") {
            VariantRow {
                Avatar(
                    avatarSize = 56.dp,
                    badge = { PrimaryBadge(content = { Text("3") }) },
                ) { Text("AL") }
                Avatar(
                    avatarSize = 56.dp,
                    badge = {
                        PrimaryBadge(
                            content = { Icon(PhIcons.Regular.User, contentDescription = null) },
                            shape = CircleShape,
                        )
                    },
                ) { Text("KO") }
            }
        }

        DemoBlock(title = "Clickable") {
            VariantRow {
                Avatar(avatarSize = 56.dp, onClick = {}) { Text("Tap") }
                Avatar(avatarSize = 56.dp) { Text("Static") }
            }
        }

        DemoBlock(title = "Fallback") {
            VariantRow {
                Avatar(
                    avatarSize = 56.dp,
                    showFallback = true,
                    fallback = { Icon(PhIcons.Regular.User, contentDescription = null) },
                ) {
                    Text("")
                }
            }
        }
    }
}
