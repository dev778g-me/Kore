package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.card.Card
import com.dev.korelibrary.components.separators.HorizontalSeparator
import com.dev.korelibrary.components.text.Text
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.utilities.extensions.semiBold

@Composable
fun DocsSidebar(
    navItems: List<NavItem>,
    selectedPath: String,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card (
       modifier = modifier
    ) {


        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 8.dp)
        ) {
            navItems.forEach { section ->
                NavSection(item = section, selectedPath = selectedPath, onItemClick = onItemClick)
            }
        }
    }
}

@Composable
private fun NavSection(item: NavItem, selectedPath: String, onItemClick: (String) -> Unit) {
    Column(modifier = Modifier.padding(vertical = 2.dp)) {
        if (item.children.isEmpty()) {
            NavLinkItem(title = item.title, path = item.path ?: "", selectedPath = selectedPath, onItemClick = onItemClick)
        } else {
            Text(
                text = item.title,
                textStyle = KoreTheme.typography.label1.semiBold(),
                color = KoreTheme.colorScheme.onBackGround,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp)
            )
            item.children.forEach { child ->
                if (child.children.isEmpty()) {
                    NavLinkItem(title = child.title, path = child.path ?: "", selectedPath = selectedPath, onItemClick = onItemClick, indentDp = 12)
                } else {
                    Text(
                        text = child.title,
                        textStyle = KoreTheme.typography.label2,
                        color = KoreTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(start = 24.dp, top = 16.dp, bottom = 8.dp)
                    )
                    child.children.forEach { grandchild ->
                        NavLinkItem(title = grandchild.title, path = grandchild.path ?: "", selectedPath = selectedPath, onItemClick = onItemClick, indentDp = 24)
                    }
                }
            }
        }
    }
}

@Composable
private fun NavLinkItem(
    title: String,
    path: String,
    selectedPath: String,
    onItemClick: (String) -> Unit,
    indentDp: Int = 0
) {
    val isSelected = path == selectedPath

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = indentDp.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { onItemClick(path) }
            )
            .background(
                if (isSelected) KoreTheme.colorScheme.primaryContainer.copy(alpha = 0.3f) else Color.Transparent,
                shape = KoreTheme.shapes.sm
            )
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        Text(
            text = title,
            textStyle = KoreTheme.typography.body2,
            color = if (isSelected) KoreTheme.colorScheme.primary else KoreTheme.colorScheme.onSurface
        )
    }
}

data class NavItem(val title: String, val path: String? = null, val children: List<NavItem> = emptyList())

fun getNavItems(): List<NavItem> = listOf(
    NavItem(title = "Components", children = listOf(
        NavItem(title = "Accordion", path = "components/accordion"),
        NavItem(title = "Appbar", path = "components/appbar"),
        NavItem(title = "Badge", path = "components/badge"),
        NavItem(title = "Buttons", path = "components/buttons"),
        NavItem(title = "Card", path = "components/card"),
        NavItem(title = "Checkbox", path = "components/checkbox"),
        NavItem(title = "Dialog", path = "components/dialog"),
        NavItem(title = "Dropdown", path = "components/dropdown"),
        NavItem(title = "IconButton", path = "components/icon_button"),
        NavItem(title = "ListTile", path = "components/listTile"),
        NavItem(title = "Loading Indicator", path = "components/loadingIndicator"),
        NavItem(title = "Navigation Bar", path = "components/navigationBar"),
        NavItem(title = "Progress Indicator", path = "components/progressIndicator"),
        NavItem(title = "Radio Buttons", path = "components/radio_button"),
        NavItem(title = "Separators", path = "components/separator"),
        NavItem(title = "Slider", path = "components/slider"),
        NavItem(title = "Stack", path = "components/stack"),
        NavItem(title = "Stepper", path = "components/stepper"),
        NavItem(title = "Switch", path = "components/switch"),
        NavItem(title = "Textfield", path = "components/textfield")
    ))
)
