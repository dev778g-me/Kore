package com.dev.kore.shared.components.display

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.dev.kore.components.accordion.Accordion
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.CaretDown
import com.phosphor.icons.regular.CaretUp
import com.phosphor.icons.regular.Package

@Composable
fun AccordionDemo() {
    var shippingExpanded by remember { mutableStateOf(true) }
    var returnsExpanded by remember { mutableStateOf(false) }

    DemoPage {
        DemoBlock(title = "Single") {
            Accordion(
                expanded = shippingExpanded,
                onExpand = { shippingExpanded = !shippingExpanded },
                modifier = Modifier.fillMaxWidth(),
                header = {
                    Text("Shipping", textStyle = KoreTheme.typography.title3)
                },
                expandedContent = {
                    Text(
                        text = "Orders placed before 3pm ship the same day. Weekend orders ship on Monday.",
                        textStyle = KoreTheme.typography.body3,
                        color = KoreTheme.colorScheme.onBackGroundVariant,
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = if (shippingExpanded) PhIcons.Regular.CaretUp else PhIcons.Regular.CaretDown,
                        contentDescription = null,
                    )
                },
            )
        }

        DemoBlock(title = "With leading icon") {
            Accordion(
                expanded = returnsExpanded,
                onExpand = { returnsExpanded = !returnsExpanded },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(PhIcons.Regular.Package, contentDescription = null)
                },
                header = {
                    Text("Returns", textStyle = KoreTheme.typography.title3)
                },
                expandedContent = {
                    Text(
                        text = "You have 30 days to return an item in its original packaging.",
                        textStyle = KoreTheme.typography.body3,
                        color = KoreTheme.colorScheme.onBackGroundVariant,
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = if (returnsExpanded) PhIcons.Regular.CaretUp else PhIcons.Regular.CaretDown,
                        contentDescription = null,
                    )
                },
            )
        }

        DemoBlock(title = "Group") {
            var open by remember { mutableStateOf(0) }
            val items = listOf(
                "Payment" to "We accept every major card and bank transfer.",
                "Delivery" to "Standard delivery takes 3 to 5 business days.",
                "Support" to "Our team replies within one business day.",
            )

            androidx.compose.foundation.layout.Column(
                verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs),
            ) {
                items.forEachIndexed { index, item ->
                    Accordion(
                        expanded = open == index,
                        onExpand = { open = if (open == index) -1 else index },
                        modifier = Modifier.fillMaxWidth(),
                        header = {
                            Text(item.first, textStyle = KoreTheme.typography.title3)
                        },
                        expandedContent = {
                            Text(
                                text = item.second,
                                textStyle = KoreTheme.typography.body3,
                                color = KoreTheme.colorScheme.onBackGroundVariant,
                            )
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = if (open == index) PhIcons.Regular.CaretUp else PhIcons.Regular.CaretDown,
                                contentDescription = null,
                            )
                        },
                        separator = index != items.lastIndex,
                    )
                }
            }
        }

        DemoBlock(title = "Transitions") {
            Text(
                text = "Accordions animate their content with the enter and exit transitions " +
                    "passed to Accordion, so they follow the active motion preset.",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
        }
    }
}
