package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dev.kore.components.card.Card
import com.dev.kore.components.card.CardDefaults
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.extensions.semiBold

@Composable
fun DocsSidebar(
    navItems: List<NavItem>,
    selectedPath: DocRoute,
    onItemClick: (DocRoute) -> Unit,
    scrollState: ScrollState,
    modifier: Modifier = Modifier
) {
    Card (
       modifier = modifier,
        containerColor = KoreTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scrollState)
                .padding(horizontal = 8.dp)
        ) {
            navItems.forEach { section ->
                NavSection(item = section, selectedPath = selectedPath, onItemClick = onItemClick)
            }
        }
    }
}

@Composable
private fun NavSection(item: NavItem, selectedPath: DocRoute, onItemClick: (DocRoute) -> Unit) {
    Column(modifier = Modifier.padding(vertical = 2.dp)) {
        if (item.children.isEmpty()) {
            NavLinkItem(title = item.title, path = item.route, selectedPath = selectedPath, onItemClick = onItemClick)
        } else {
            Text(
                text = item.title,
                textStyle = KoreTheme.typography.label1.semiBold(),
                color = KoreTheme.colorScheme.onBackGround,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)
            )
            item.children.forEach { child ->
                if (child.children.isEmpty()) {
                    NavLinkItem(title = child.title, path = child.route, selectedPath = selectedPath, onItemClick = onItemClick, indentDp = 8)
                } else {
                    Text(
                        text = child.title,
                        textStyle = KoreTheme.typography.label2,
                        color = KoreTheme.colorScheme.onBackGround.copy(alpha = 0.9f),
                        modifier = Modifier.padding(start = 8.dp, top = 12.dp, bottom = 4.dp)
                    )
                    child.children.forEach { grandchild ->
                        NavLinkItem(title = grandchild.title, path = grandchild.route, selectedPath =selectedPath , onItemClick = onItemClick, indentDp = 8)
                    }
                }
            }
        }
    }
}

@Composable
private fun NavLinkItem(
    title: String,
    path: DocRoute,
    selectedPath: DocRoute,
    onItemClick: (DocRoute) -> Unit,
    indentDp: Int = 0
) {
    val isSelected = path == selectedPath

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = indentDp.dp, top = 4.dp, bottom = 4.dp)
            .clip(KoreTheme.shapes.sm)
            .clickable(
                onClick = { onItemClick(path) }
            )
            .background(
                if (isSelected) KoreTheme.colorScheme.primaryContainer else Color.Transparent,
                shape = KoreTheme.shapes.sm
            )
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        Text(
            text = title,
            textStyle = KoreTheme.typography.body2.copy(
                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
            ),
            color = if (isSelected) KoreTheme.colorScheme.onPrimaryContainer else KoreTheme.colorScheme.onSurface
        )
    }
}

data class NavItem(val title: String, val route: DocRoute , val children: List<NavItem> = emptyList())

fun getNavItems(): List<NavItem> = listOf(
    NavItem(
        title = "Getting Started",
        children = listOf(
            NavItem(title = "Overview", route = DocRoute.Overview),
            NavItem(title = "Installation", route = DocRoute.Installation),
            NavItem(title = "Quickstart", route = DocRoute.Quickstart)
        ),
        route = DocRoute.Overview
    ),
    NavItem(
        title = "Components",
        children = listOf(
            NavItem(
                title = "Foundation",
                children = listOf(
                    NavItem(title = "Separators", route = DocRoute.Separator),
                    NavItem(title = "Stack", route = DocRoute.Stack)
                ),
                route =DocRoute.Overview
            ),
            NavItem(
                title = "Inputs & Controls",
                children = listOf(
                    NavItem(title = "Buttons", route = DocRoute.Buttons),
                    NavItem(title = "IconButton", route = DocRoute.IconButton),
                    NavItem(title = "Textfield", route = DocRoute.TextField),
                    NavItem(title = "Checkbox", route = DocRoute.Checkbox),
                    NavItem(title = "Radio Buttons", route = DocRoute.RadioButton),
                    NavItem(title = "Switch", route = DocRoute.Switch),
                    NavItem(title = "Slider", route = DocRoute.Slider),
                    NavItem(title = "Dropdown", route = DocRoute.Dropdown)
                ),
                route = DocRoute.Overview
            ),
            NavItem(
                title = "Feedback & Indicators",
                children = listOf(
                    NavItem(title = "Loading Indicator", route = DocRoute.LoadingIndicator),
                    NavItem(title = "Progress Indicator", route = DocRoute.ProgressIndicator),
                    NavItem(title = "Badge", route = DocRoute.Badge),
                    NavItem(title = "Dialog", route = DocRoute.Dialog)
                ),
                route = DocRoute.Overview
            ),
            NavItem(
                title = "Data Display",
                children = listOf(
                    NavItem(title = "Card", route = DocRoute.Card),
                    NavItem(title = "ListTile", route = DocRoute.ListTile),
                    NavItem(title = "Accordion", route = DocRoute.Accordion),
                    NavItem(title = "Stepper", route = DocRoute.Stepper)
                ),
                route =DocRoute.Overview
            ),
            NavItem(
                title = "Navigation",
                children = listOf(
                    NavItem(title = "Appbar", route = DocRoute.Appbar),
                    NavItem(title = "Navigation Bar", route = DocRoute.NavigationBar)
                ),
                route = DocRoute.Overview
            )
        ),
        route =DocRoute.Overview
    ),
            NavItem(
                title = "Extensions",
                children = listOf(
                    NavItem(title = "ModifierExtensions" , route = DocRoute.ModifierExtension),
                    NavItem(title = "Typography", route = DocRoute.TypographyExtensions),
                    NavItem(title = "Colors", route = DocRoute.ColorsExtensions)
                ),
                route = DocRoute.Overview
            )
)
