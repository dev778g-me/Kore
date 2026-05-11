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
import com.dev.themebuilder.ui.docs.AccordionDocs
import com.dev.themebuilder.ui.docs.AppbarDocs
import com.dev.themebuilder.ui.docs.BadgeDocs
import com.dev.themebuilder.ui.docs.CardDocs
import com.dev.themebuilder.ui.docs.CheckBoxDocs
import com.dev.themebuilder.ui.docs.DialogDocs
import com.dev.themebuilder.ui.docs.DropdownDocs
import com.dev.themebuilder.ui.docs.IconButtonDocs
import com.dev.themebuilder.ui.docs.ListTileDocs
import com.dev.themebuilder.ui.docs.LoadingIndicatorDocs
import com.dev.themebuilder.ui.docs.NavigationBarDocs
import com.dev.themebuilder.ui.docs.ProgressIndicatorDocs
import com.dev.themebuilder.ui.docs.RadioButtonDocs
import com.dev.themebuilder.ui.docs.SeparatorDocs
import com.dev.themebuilder.ui.docs.SliderDocs
import com.dev.themebuilder.ui.docs.StepperDocs
import com.dev.themebuilder.ui.docs.StackDocs
import com.dev.themebuilder.ui.docs.SwitchDocs
import com.dev.themebuilder.ui.docs.TextFieldDocs
import com.dev.themebuilder.ui.docs.InstallationDocs
import com.dev.themebuilder.ui.docs.OverviewDocs
import com.dev.themebuilder.ui.docs.QuickstartDocs

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
        path.contains("icon_button") -> IconButtonDocs()
        path.contains("textfield") -> TextFieldDocs()
        path.contains("checkbox") -> CheckBoxDocs()
        path.contains("radio_button") -> RadioButtonDocs()
        path.contains("switch") -> SwitchDocs()
        path.contains("slider") -> SliderDocs()
        path.contains("dropdown") -> DropdownDocs()
        path.contains("loadingIndicator") -> LoadingIndicatorDocs()
        path.contains("progressIndicator") -> ProgressIndicatorDocs()
        path.contains("badge") -> BadgeDocs()
        path.contains("dialog") -> DialogDocs()
        path.contains("card") -> CardDocs()
        path.contains("listTile") -> ListTileDocs()
        path.contains("accordion") -> AccordionDocs()
        path.contains("stepper") -> StepperDocs()
        path.contains("separator") -> SeparatorDocs()
        path.contains("stack") -> StackDocs()
        path.contains("appbar") -> AppbarDocs()
        path.contains("navigationBar") -> NavigationBarDocs()
        path.contains("getting-started/overview") -> OverviewDocs()
        path.contains("getting-started/installation") -> InstallationDocs()
        path.contains("getting-started/quickstart") -> QuickstartDocs()
        else -> DefaultMarkdownParser(
            content = "# Coming Soon\n\nDocumentation for this component is being developed."
        )
    }
}
