package com.dev.kore.shared.components.display

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Bell
import com.phosphor.icons.regular.Heart
import com.phosphor.icons.regular.Star

@Composable
fun IconDemo() {
    DemoPage {
        DemoBlock(title = "Sizes") {
            VariantRow {
                Icon(PhIcons.Regular.Heart, contentDescription = "Heart", modifier = Modifier.size(16.dp))
                Icon(PhIcons.Regular.Heart, contentDescription = "Heart", modifier = Modifier.size(24.dp))
                Icon(PhIcons.Regular.Heart, contentDescription = "Heart", modifier = Modifier.size(32.dp))
                Icon(PhIcons.Regular.Heart, contentDescription = "Heart", modifier = Modifier.size(48.dp))
            }
        }

        DemoBlock(title = "Tints") {
            VariantRow {
                Icon(
                    imageVector = PhIcons.Regular.Star,
                    contentDescription = null,
                    tint = KoreTheme.colorScheme.primary,
                    modifier = Modifier.size(32.dp),
                )
                Icon(
                    imageVector = PhIcons.Regular.Star,
                    contentDescription = null,
                    tint = KoreTheme.colorScheme.complementary,
                    modifier = Modifier.size(32.dp),
                )
                Icon(
                    imageVector = PhIcons.Regular.Star,
                    contentDescription = null,
                    tint = KoreTheme.colorScheme.success,
                    modifier = Modifier.size(32.dp),
                )
                Icon(
                    imageVector = PhIcons.Regular.Star,
                    contentDescription = null,
                    tint = KoreTheme.colorScheme.error,
                    modifier = Modifier.size(32.dp),
                )
                Icon(
                    imageVector = PhIcons.Regular.Star,
                    contentDescription = null,
                    tint = KoreTheme.colorScheme.onBackGroundVariant,
                    modifier = Modifier.size(32.dp),
                )
            }
        }

        DemoBlock(title = "Inside content") {
            Icon(
                imageVector = PhIcons.Regular.Bell,
                contentDescription = "Notifications",
                modifier = Modifier.size(24.dp),
            )
            Text(
                text = "Icons inherit LocalContentColor unless a tint is passed.",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
        }
    }
}
