package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.appbar.AppBarDefaults
import com.dev.kore.components.appbar.Appbar
import com.dev.kore.components.buttons.GhostButton
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Bell
import com.phosphor.icons.regular.CaretLeft
import com.phosphor.icons.regular.DotsThreeVertical
import com.phosphor.icons.regular.House

@Composable
fun AppbarDocs(
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp)
    ) {
        DefaultMarkdownParser(
            content = """# Appbar

an Appbar is a top-of-the screen container providing consistent navigation screen titles & core actions.<br>
it provides a set of actions / tools which are relevant to the user current task or view .

when to use Appbar :
- simple actions
- compact content
- brand recognition (showing logo /name etc)


When to avoid Appbar :
- primary actions
- rarely used actions
- too many actions


> For deeper reference, check out [Mobbin](https://mobbin.com/glossary/top-navigation-bar) guide on accordions.

<figure><img src="showcases/appbar_showcase.png" alt="Appbar example image "><figcaption></figcaption></figure>



| Slot              | Description                                                                      |
|-------------------|----------------------------------------------------------------------------------|
| `title`           | title of the appbar often brand name or appname.                                 |


## Basic Example
"""
        )

        ComponentShowcase(
            code = """

Appbar(
    title = {
        Text("Kore")
    },
    navigationIcon = {
        GhostIconButton(
            onClick = {},
            content = {
                Icon(
                    imageVector = PhIcons.Regular.CaretLeft,
                    contentDescription = ""
                )
            }
        )
    },
    appBarAction = {
        GhostIconButton(
            onClick = {},
            content = {
                Icon(
                    imageVector = PhIcons.Regular.DotsThreeVertical,
                    contentDescription = ""
                )
            }
        )
    })



""".trimIndent(),
            content = {
                Appbar(
                    title = {
                        Text("Kore")
                    },
                    navigationIcon = {
                        GhostIconButton(
                            onClick = {},
                            content = {
                                Icon(
                                    imageVector = PhIcons.Regular.CaretLeft,
                                    contentDescription = ""
                                )
                            }
                        )
                    },
                    appBarAction = {
                        GhostIconButton(
                            onClick = {},
                            content = {
                                Icon(
                                    imageVector = PhIcons.Regular.DotsThreeVertical,
                                    contentDescription = ""
                                )
                            }
                        )
                    }
                )
            }
        )

        DefaultMarkdownParser(
            content = """
## Styling
appbar exposes several param to customize the component
### Parameters

| Parameter                 | Type                                 | Default                                     | Description                                              |
|---------------------------|--------------------------------------|---------------------------------------------|----------------------------------------------------------|
| `title`                   | `@Composable () -> Unit`             | —                                           | The main text or component of the app bar.               |
| `modifier`                | `Modifier`                           | `Modifier`                                  | Applied to the root container.                           |
| `navigationIcon`          | `@Composable (() -> Unit)?`          | `null`                                      | Icon rendered on the start side of the app bar.          |
| `navigationIconAlignment` | `Alignment.Vertical`                 | `Alignment.CenterVertically`                | Vertical alignment of the navigation icon.               |
| `appBarAction`            | `@Composable (RowScope.() -> Unit)?` | `null`                                      | Actions rendered on the end side. Provides a `RowScope`. |
| `appBarAlignment`         | `Alignment.Vertical`                 | `Alignment.CenterVertically`                | Vertical alignment of the app bar actions.               |
| `windowInsets`            | `WindowInsets`                       | `WindowInsets.statusBars`                   | Insets to apply to the app bar (handles system UI).      |
| `contentPadding`          | `PaddingValues`                      | `AppBarDefaults.defaultTopAppBarPadding`    | Padding applied to the internal content slot.            |
| `minimumAppBarHeight`     | `Dp`                                 | `AppBarDefaults.defaultAppBarMinimumHeight` | The minimum height constraint for the app bar.           |
| `elevation`               | `Dp`                                 | `AppBarDefaults.defaultAppBarElevation`     | Shadow elevation applied to the app bar surface.         |


### Multiple Actions & Elevation

Because `appBarAction` provides a `RowScope`, you can easily stack multiple action icons side-by-side. You can also increase the `elevation` to cast a stronger shadow over the content below.
"""
        )

        ComponentShowcase(
            code = """
Appbar(
    title = { Text("Settings") },
    elevation = 8.dp,
    navigationIcon = {
        GhostIconButton(onClick = { }) {
            Icon(imageVector = PhIcons.Regular.CaretLeft, contentDescription = "Back")
        }
    },
    appBarAction = {
        GhostIconButton(
            onClick = {},
            content = {
                Icon(
                    imageVector = PhIcons.Regular.DotsThreeVertical,
                    contentDescription = ""
                )
            }
        )
        GhostIconButton(
            onClick = {},
            content = {
                Icon(
                    imageVector = PhIcons.Regular.Bell,
                    contentDescription = ""
                )
            }
        )
    }
)
""".trimIndent(),
            content = {
                Appbar(
                    title = { Text("Settings") },
                    elevation = 8.dp,
                    navigationIcon = {
                        GhostIconButton(onClick = { }) {
                            Icon(imageVector = PhIcons.Regular.CaretLeft, contentDescription = "Back")
                        }
                    },
                    appBarAction = {
                        GhostIconButton(
                            onClick = {},
                            content = {
                                Icon(
                                    imageVector = PhIcons.Regular.DotsThreeVertical,
                                    contentDescription = ""
                                )
                            }
                        )
                        GhostIconButton(
                            onClick = {},
                            content = {
                                Icon(
                                    imageVector = PhIcons.Regular.Bell,
                                    contentDescription = ""
                                )
                            }
                        )
                    }
                )
            }
        )

        DefaultMarkdownParser(
            content = """
### Custom Heights and Padding

You can override the default dimensions to create a taller, more spacious app bar ,often useful for specific branding requirements or larger typography.

"""
        )

        ComponentShowcase(
            code = """
Appbar(
    title = {
        Text(text = "Dashboard")
    },
    minimumAppBarHeight = 80.dp,
    contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp),
    navigationIcon = {
        Icon(imageVector = PhIcons.Regular.House, contentDescription = "Home")
    }
)


""".trimIndent(),
            content = {
                Appbar(
                    title = {
                        Text(text = "Dashboard")
                    },
                    minimumAppBarHeight = 80.dp,
                    contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp),
                    navigationIcon = {
                        Icon(imageVector = PhIcons.Regular .House, contentDescription = "Home")
                    }
                )
            }
        )
    }
}