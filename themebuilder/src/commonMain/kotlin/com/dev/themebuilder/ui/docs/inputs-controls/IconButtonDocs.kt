package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.buttons.IconButtonDefaults
import com.dev.kore.components.buttons.OutlinedIconButton
import com.dev.kore.components.buttons.PrimaryIconButton
import com.dev.kore.components.buttons.SecondaryIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.colors.RadixColors
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Asterisk
import com.phosphor.icons.regular.Plus

@Composable
fun IconButtonDocs(
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp)


    ) {
        DefaultMarkdownParser(
            content = """# Icon Buttons

An IconButton is a compact, interactive element that uses an icon instead of a text label to convey its action. They are ideal for app bars, toolbars, and inline actions where space is limited but the action is easily understood universally.

There are several types of icon buttons in Kore based on action importance: Primary, Secondary, Outlined, and Ghost. Each variant features a minimum touch target size of `48.dp` by default to ensure accessibility.

<figure><img src="showcases/iconButtonShowcase/all_icon_showcase.png" alt="IconButton example image"><figcaption></figcaption></figure>

## Primary Icon Button

The `PrimaryIconButton` is a highly prominent component used for the primary or most important tasks on a screen.

### Basic Example 

| Slot      | Description                                                                  |
|-----------|------------------------------------------------------------------------------|
| `content` | The internal element of the button. Typically contains an `Icon` composable. |


<figure><img src="showcases/iconButtonShowcase/primary_icon_button.png" alt="Primary ICon Button with icon example image "><figcaption></figcaption></figure>


"""
        )

        ComponentShowcase(
            code = """
PrimaryIconButton(
    onClick = { /* Handle click */ }
) {
    Icon(
        imageVector = PhIcons.Regular.Plus,
        contentDescription = "Add Item"
    )
}
""".trimIndent(),
            content = {
                PrimaryIconButton(
                    onClick = { }
                ) {
                    Icon(
                        imageVector = PhIcons.Regular.Plus,
                        contentDescription = "Add Item"
                    )
                }
            }
        )

        DefaultMarkdownParser(
            content = """
## Styling 

IconButtons expose several parameters to customize their appearance, shape, and interactions.

### Parameters

| Parameter                 | Type                        | Default                                        | Description                                                                                                         |
|---------------------------|-----------------------------|------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|
| `onClick`                 | `() -> Unit`                | —                                              | Called when the user clicks the icon button.                                                                        |
| `modifier`                | `Modifier`                  | `Modifier`                                     | Applied to the root container of the button.                                                                        |
| `enabled`                 | `Boolean`                   | `true`                                         | Controls the interactive and visual enabled state of the button.                                                    |
| `shape`                   | `Shape`                     | `CircleShape`                                  | Defines the button's clipping shape (defaults to perfectly round).                                                  |
| `interactionSource`       | `MutableInteractionSource?` | `null`                                         | Represents the stream of interactions (e.g., pressed, focused).                                                     |
| `primaryIconButtonColors` | `IconButtonColors`          | `IconButtonDefaults.primaryIconButtonColors()` | The resolved colors used for the background and content in different states. *(Note: Name varies per button type).* |
| `content`                 | `@Composable () -> Unit`    | —                                              | The main content to display inside the button.                                                                      |

### Custom Shape and Colors

By default, IconButtons use a `CircleShape`, but you can easily override this to create rounded rectangles or squares.

<figure><img src="showcases/iconButtonShowcase/icon_buttonwith_custom_shape_colors.png" alt="IconButton with custom shape and colors example image"><figcaption></figcaption></figure>


"""
        )

        ComponentShowcase(
            code = """
 PrimaryIconButton(
    shape = KoreTheme.shapes.sm,
    onClick = {},
    primaryIconButtonColors = IconButtonDefaults.primaryIconButtonColors(
        iconButtonContainerColor = RadixColors.Orange.dark.step9,
        iconButtonContentColor = RadixColors.Orange.dark.step12
    )
) {
    Icon(imageVector = PhIcons.Regular.Asterisk, contentDescription = "")
}
""".trimIndent(),
            content = {
                PrimaryIconButton(
                    shape = KoreTheme.shapes.sm,
                    onClick = {},
                    primaryIconButtonColors = IconButtonDefaults.primaryIconButtonColors(
                        iconButtonContainerColor = RadixColors.Orange.dark.step9,
                        iconButtonContentColor = RadixColors.Orange.dark.step12
                    )
                ) {
                    Icon(imageVector = PhIcons.Regular.Asterisk, contentDescription = "")
                }
            }
        )

        DefaultMarkdownParser(
            content = """
## Other Variants

Kore provides three other IconButton variants that follow the exact same anatomy as the `PrimaryIconButton`, differing mostly in their default emphasis and colors.

### Secondary Icon Button
Used for medium-emphasis actions that shouldn't draw as much attention as the primary action.

<figure><img src="showcases/iconButtonShowcase/secondary_icon_button.png" alt="SecondaryIconButton example image"><figcaption></figcaption></figure>


"""
        )

        ComponentShowcase(
            code = """
SecondaryIconButton(
    onClick = { /* Edit item */ }
) {
    Icon(
        imageVector = PhIcons.Regular.Asterisk,
        contentDescription = "Edit"
    )
}
""".trimIndent(),
            content = {
                SecondaryIconButton(
                    onClick = { }
                ) {
                    Icon(
                        imageVector = PhIcons.Regular.Asterisk,
                        contentDescription = "Edit"
                    )
                }
            }
        )

        DefaultMarkdownParser(
            content = """
### Outlined Icon Button
Also, a medium-emphasis action, but features a customizable `border` parameter. Useful for alternate or secondary actions.

<figure><img src="showcases/iconButtonShowcase/outlined_icon_button.png" alt="OutlinedIconButton example image"><figcaption></figcaption></figure>


"""
        )

        ComponentShowcase(
            code = """
OutlinedIconButton(
    onClick = { /* Delete item */ },
) {
    Icon(
        imageVector = PhIcons.Regular.Asterisk,
        contentDescription = "Delete"
    )
}
""".trimIndent(),
            content = {
                OutlinedIconButton(
                    onClick = { },
                ) {
                    Icon(
                        imageVector = PhIcons.Regular.Asterisk,
                        contentDescription = "Delete"
                    )
                }
            }
        )

        DefaultMarkdownParser(
            content = """
### Ghost Icon Button
A low-emphasis, transparent button used for very low priority or optional actions. It blends into the background until interacted with.

<figure><img src="showcases/iconButtonShowcase/ghostButton.png" alt="GhostIconButton example image"><figcaption></figcaption></figure>


"""
        )

        ComponentShowcase(
            code = """
GhostIconButton(
    onClick = { /* Open menu */ }
) {
    Icon(
        imageVector = PhIcons.Regular.Asterisk,
        contentDescription = "More Options"
    )
}
""".trimIndent(),
            content = {
                GhostIconButton(
                    onClick = { }
                ) {
                    Icon(
                        imageVector = PhIcons.Regular.Asterisk,
                        contentDescription = "More Options"
                    )
                }
            }
        )
    }
}