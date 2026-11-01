package com.dev.kore.shared.components.actions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.floatingActionButton.FloatingActionButton
import com.dev.kore.components.floatingActionButton.Item
import com.dev.kore.components.floatingActionButton.SplitFloatingActionButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.ArrowRight
import com.phosphor.icons.regular.NavigationArrow
import com.phosphor.icons.regular.Plus
import com.phosphor.icons.regular.ShoppingCart

@Composable
fun FloatingActionButtonDemo() {
    DemoPage {
        DemoBlock(title = "Icon only") {
            FloatingActionButton(onClick = {}) {
                Icon(PhIcons.Regular.Plus, contentDescription = "Add")
            }
        }

        DemoBlock(title = "Extended") {
            FloatingActionButton(onClick = {}) {
                Icon(
                    imageVector = PhIcons.Regular.Plus,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 8.dp),
                )
                Text("New note")
            }
        }

        DemoBlock(title = "Shapes") {
            Row(horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                FloatingActionButton(onClick = {}, shape = KoreTheme.shapes.sm) {
                    Icon(PhIcons.Regular.Plus, contentDescription = null)
                }
                FloatingActionButton(onClick = {}, shape = KoreTheme.shapes.md) {
                    Icon(PhIcons.Regular.Plus, contentDescription = null)
                }
                FloatingActionButton(onClick = {}, shape = KoreTheme.shapes.xl) {
                    Icon(PhIcons.Regular.Plus, contentDescription = null)
                }
            }
        }

        DemoBlock(title = "Disabled") {
            FloatingActionButton(onClick = {}, enabled = false) {
                Icon(PhIcons.Regular.Plus, contentDescription = null)
                Text("Disabled", modifier = Modifier.padding(start = 8.dp))
            }
        }

        DemoBlock(title = "Placement") {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                FloatingActionButton(onClick = {}) {
                    Icon(PhIcons.Regular.Plus, contentDescription = "Add")
                }
            }
        }
    }
}

@Composable
fun SplitFloatingActionButtonDemo() {
    DemoPage {
        DemoBlock(title = "Two actions") {
            SplitFloatingActionButton {
                Item(onClick = {}, showSeparator = true) {
                    Icon(PhIcons.Regular.NavigationArrow, contentDescription = null)
                    Text("Navigate", modifier = Modifier.padding(start = 8.dp))
                }
                Item(onClick = {}, showSeparator = false) {
                    Icon(PhIcons.Regular.ShoppingCart, contentDescription = null)
                    Text("Cart", modifier = Modifier.padding(start = 8.dp))
                }
            }
        }

        DemoBlock(title = "Icon only") {
            SplitFloatingActionButton(shape = KoreTheme.shapes.xl) {
                Item(onClick = {}, showSeparator = true) {
                    Icon(PhIcons.Regular.Plus, contentDescription = "Add")
                }
                Item(onClick = {}, showSeparator = false) {
                    Icon(PhIcons.Regular.ArrowRight, contentDescription = "Next")
                }
            }
        }

        DemoBlock(title = "Disabled item") {
            SplitFloatingActionButton {
                Item(onClick = {}, showSeparator = true) {
                    Icon(PhIcons.Regular.NavigationArrow, contentDescription = null)
                    Text("Navigate", modifier = Modifier.padding(start = 8.dp))
                }
                Item(onClick = {}, showSeparator = false, enabled = false) {
                    Icon(PhIcons.Regular.ShoppingCart, contentDescription = null)
                    Text("Cart", modifier = Modifier.padding(start = 8.dp))
                }
            }
        }

        DemoBlock(title = "Custom separator") {
            SplitFloatingActionButton {
                Item(onClick = {}, showSeparator = true) {
                    Icon(PhIcons.Regular.ShoppingCart, contentDescription = null)
                }
                Item(
                    onClick = {},
                    showSeparator = false,
                    separator = {
                        Box(
                            modifier = Modifier
                                .width(1.dp)
                                .height(32.dp)
                                .background(KoreTheme.colorScheme.onPrimary.copy(alpha = 0.3f)),
                        )
                    },
                ) {
                    Icon(PhIcons.Regular.Plus, contentDescription = null)
                }
            }
        }
    }
}
