package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.themes.KoreTheme

@Composable
fun DocsScreen(
    modifier: Modifier = Modifier,
    initialPath: String = "components/overview.md",
    onNavigate: (String) -> Unit = {},
    onOpenUrl: (String) -> Unit = {}
) {
    var selectedPath by remember { mutableStateOf(initialPath) }
    val navItems = remember { getNavItems() }

    LaunchedEffect(initialPath) {
        selectedPath = initialPath
    }

    Row(
        modifier = modifier
            .fillMaxSize()
            .background(KoreTheme.colorScheme.background)
    ) {
        DocsSidebar(
            navItems = navItems,
            selectedPath = selectedPath,
            onItemClick = { path ->
                selectedPath = path
                onNavigate(path)
            },
            modifier = Modifier
                .width(260.dp)
                .fillMaxHeight()
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            contentAlignment = Alignment.TopCenter
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 48.dp)
                    .verticalScroll(rememberScrollState()),
                contentAlignment = Alignment.TopCenter
            ) {
                Box(
                    modifier = Modifier
                        .width(720.dp)
                        .padding(horizontal = 24.dp)
                ) {
                    DocContent(
                        path = selectedPath,
                        onOpenUrl = onOpenUrl
                    )
                }
            }
        }
    }
}

@Composable
private fun DocContent(
    path: String,
    onOpenUrl: (String) -> Unit
) {
    when {
        path.contains("buttons") -> ButtonDocs()
        else -> DefaultMarkdownParser(
            content = "# Coming Soon\n\nDocumentation for this component is being developed."
        )
    }
}
