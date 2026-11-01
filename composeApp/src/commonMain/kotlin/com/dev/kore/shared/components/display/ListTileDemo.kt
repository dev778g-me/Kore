package com.dev.kore.shared.components.display

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.listtile.ListTile
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Bell
import com.phosphor.icons.regular.Gear
import com.phosphor.icons.regular.User

@Composable
fun ListTileDemo() {
    val rows = listOf(
        "Notification" to "Kore 1.0 shipped with 35 components.",
        "Comment" to "You mentioned the designer in the thread.",
        "Update" to "Your branch has three new commits.",
    )

    DemoPage {
        DemoBlock(title = "List") {
            DemoPage {
                Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs)) {
                    rows.forEachIndexed { index, row ->
                        ListTile(
                            title = { Text(row.first) },
                            subtitle = { Text(row.second) },
                            leading = { Icon(PhIcons.Regular.User, contentDescription = null) },
                            trailing = { Icon(PhIcons.Regular.Gear, contentDescription = null) },
                        )
                    }
                }
            }
        }

        DemoBlock(title = "Custom shape and content padding") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs)) {
                ListTile(
                    title = { Text("Custom") },
                    shape = KoreTheme.shapes.xs,
                    contentPaddingValues = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
                )
                ListTile(
                    title = { Text("Selected") },
                    leading = { Icon(PhIcons.Regular.Bell, contentDescription = null) },
                )
            }
        }

        DemoBlock(title = "Overline") {
            ListTile(
                overline = { Text("Overline", textStyle = KoreTheme.typography.label3) },
                title = { Text("Overline title") },
                subtitle = { Text("Secondary text") },
            )
        }

        DemoBlock(title = "Clickable") {
            ListTile(
                title = { Text("Tap me") },
                subtitle = { Text("It navigates somewhere") },
                leading = { Icon(PhIcons.Regular.User, contentDescription = null) },
                onClick = { },
                modifier = Modifier.fillMaxWidth(),
            )
        }

        DemoBlock(title = "Single") {
            ListTile(
                title = { Text("A tile") },
                subtitle = { Text("With a subtitle") },
                leading = { Icon(PhIcons.Regular.User, contentDescription = null) },
            )
        }

        DemoBlock(title = "Side by side") {
            VariantRow {
                ListTile(
                    title = { Text("In column 1") },
                    modifier = Modifier.fillMaxWidth(),
                )
                ListTile(
                    title = { Text("In column 2") },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}
