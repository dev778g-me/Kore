package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.kore.components.separators.VerticalSeparator
import com.dev.kore.themes.KoreTheme
import kotlinx.serialization.Serializable

@Serializable
sealed class DocRoute {
    @Serializable
    data object Accordion : DocRoute()
    @Serializable
    data object Appbar : DocRoute()
    @Serializable
    data object Badge : DocRoute()
    @Serializable
    data object Buttons : DocRoute()
    @Serializable
    data object Card : DocRoute()
    @Serializable
    data object Checkbox : DocRoute()
    @Serializable
    data object Dialog : DocRoute()
    @Serializable
    data object Dropdown : DocRoute()
    @Serializable
    data object IconButton : DocRoute()
    @Serializable
    data object ListTile : DocRoute()
    @Serializable
    data object LoadingIndicator : DocRoute()
    @Serializable
    data object NavigationBar : DocRoute()
    @Serializable
    data object ProgressIndicator : DocRoute()
    @Serializable
    data object RadioButton : DocRoute()
    @Serializable
    data object Separator : DocRoute()
    @Serializable
    data object Slider : DocRoute()
    @Serializable
    data object Stack : DocRoute()
    @Serializable
    data object Stepper : DocRoute()
    @Serializable
    data object Switch : DocRoute()
    @Serializable
    data object TextField : DocRoute()
    @Serializable
    data object Overview : DocRoute()
    @Serializable
    data object Installation : DocRoute()
    @Serializable
    data object Quickstart : DocRoute()
    @Serializable
    data object Fallback : DocRoute()


   @Serializable
   data object ModifierExtension : DocRoute()


    @Serializable
    data object  TypographyExtensions : DocRoute()

@Serializable data object ColorsExtensions : DocRoute()
}

@Composable
 fun ScrollableDocContainer(
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .width(800.dp)
                .padding(horizontal = 24.dp)
        ) {
            content()
        }
    }
}

@Composable
fun DocsScreen(
    initialRoute: DocRoute = DocRoute.Overview,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
    onNavigate: (DocRoute) -> Unit = {},
) {

    val navItems = remember { getNavItems() }
    val navController = rememberNavController()
    var currentRoute by remember { mutableStateOf(initialRoute) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(KoreTheme.colorScheme.background),
        contentAlignment = Alignment.TopCenter
    ) {
        Row(
            modifier = Modifier
                .widthIn(max = 1200.dp)
                .fillMaxHeight()
                .padding(24.dp)
        ) {
            DocsSidebar(
                navItems = navItems,
                selectedPath = currentRoute,
                onItemClick = { path ->
                    currentRoute = path
                    navController.navigate(path)
                    onNavigate(path)
                },
                scrollState = scrollState,
                modifier = Modifier
                    .width(260.dp)
                    .fillMaxHeight()
            )
            VerticalSeparator()
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.TopCenter
            ) {
                NavHost(
                    navController = navController,
                    startDestination = initialRoute,
                    modifier = Modifier.fillMaxSize(),

                ) {
                    composable<DocRoute.Accordion> { ScrollableDocContainer({ AccordionDocs() }) }
                    composable<DocRoute.Appbar> { ScrollableDocContainer({ AppbarDocs() } )}
                    composable<DocRoute.Badge> { ScrollableDocContainer{ BadgeDocs() } }
                    composable<DocRoute.Buttons> { ScrollableDocContainer{ ButtonDocs() } }
                    composable<DocRoute.Card> { ScrollableDocContainer{ CardDocs() } }
                    composable<DocRoute.Checkbox> { ScrollableDocContainer({ CheckBoxDocs() } )}
                    composable<DocRoute.Dialog> { ScrollableDocContainer({ DialogDocs() } )}
                    composable<DocRoute.Dropdown> { ScrollableDocContainer({ DropdownDocs() } )}
                    composable<DocRoute.IconButton> { ScrollableDocContainer({ IconButtonDocs() })}
                    composable<DocRoute.ListTile> { ScrollableDocContainer({ ListTileDocs() } )}
                    composable<DocRoute.LoadingIndicator> { ScrollableDocContainer({ LoadingIndicatorDocs() } )}
                    composable<DocRoute.NavigationBar> { ScrollableDocContainer({ NavigationBarDocs() } )}
                    composable<DocRoute.ProgressIndicator> { ScrollableDocContainer({ ProgressIndicatorDocs() } )}
                    composable<DocRoute.RadioButton> { ScrollableDocContainer({ RadioButtonDocs() } )}
                    composable<DocRoute.Separator> { ScrollableDocContainer({ SeparatorDocs() } )}
                    composable<DocRoute.Slider> { ScrollableDocContainer({ SliderDocs() } )}
                    composable<DocRoute.Stack> { ScrollableDocContainer({ StackDocs() } )}
                    composable<DocRoute.Stepper> { ScrollableDocContainer({ StepperDocs() }) }
                    composable<DocRoute.Switch> { ScrollableDocContainer({ SwitchDocs() }) }
                    composable<DocRoute.TextField> { ScrollableDocContainer({ TextFieldDocs() }) }
                    composable<DocRoute.Overview> { ScrollableDocContainer({ OverviewDocs() }) }
                    composable<DocRoute.Installation> { ScrollableDocContainer({ InstallationDocs() }) }
                    composable<DocRoute.Quickstart> { ScrollableDocContainer({ QuickstartDocs() }) }
                   composable<DocRoute.ModifierExtension> {
                        ScrollableDocContainer({ ModifierExtensionDocs() })
                    }
                   composable<DocRoute.TypographyExtensions> {
                        ScrollableDocContainer({ TextStyleExtensionDocs() })
                    }
                   composable<DocRoute.ColorsExtensions> {
                        ScrollableDocContainer({ ColorExtensionDocs() })
                    }

                     composable<DocRoute.Fallback> {
                        ScrollableDocContainer({
                            DefaultMarkdownParser(
                                content = "# Coming Soon\n\nDocumentation for this component is being developed."
                            )
                        })
                    }

                }
            }
            VerticalSeparator()

        }
    }
}
