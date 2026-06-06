package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.ButtonDefaults
import com.dev.kore.components.buttons.GhostButton
import com.dev.kore.components.buttons.OutlinedButton
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.buttons.SecondaryButton
import com.dev.kore.components.card.OutlinedCard
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Plus

@Composable
fun ButtonDocs(
    modifier: Modifier = Modifier,
){

    VerticalStack(

    ) {
        DefaultMarkdownParser(
            content = """# Buttons

A **Button** is an interactive element that signals the user to take a specific action, such as making a purchase, submitting a form, or navigating to a new screen.

The button's content (label) expresses what action will occur when the user interacts with it. There are several types of buttons in Kore based on action importance (e.g., Primary, Secondary, Outlined, Ghost). Each button has a different level of emphasis, representing the intent and importance of the action.

<figure><img src="showcases/buttonShowcase/button_showcase.png" alt="All Button example image "><figcaption></figcaption></figure>

For deeper reference, check out [Mobbin](https://mobbin.com/glossary/button) guide on Badges.

---

## Primary Button

The `PrimaryButton` is a highly prominent component used for the main action you want the user to take on a given screen.




### Basic Example

| Slot      | Description                                                             |
|-----------|-------------------------------------------------------------------------|
| `content` | Typically contains a `Text` composable, but can also include an `Icon`. |
"""
        )


     ComponentShowcase(
         code = """
             PrimaryButton(
                 onClick = { /* Handle click */ }
             ) {
                 Text("Submit")
             }
         """.trimIndent()

     ){
         PrimaryButton(onClick = {}) {
             Text("Submit")
         }
     }

        DefaultMarkdownParser(
            content = """
---

## Styling

The button exposes several parameters to customize its appearance and behavior.

### Parameters

| Parameter        | Type                              | Default                                 | Description                                                 |
|------------------|-----------------------------------|-----------------------------------------|-------------------------------------------------------------|
| `onClick`        | `() -> Unit`                      | —                                       | Called when the user clicks the button.                     |
| `modifier`       | `Modifier`                        | `Modifier`                              | Applied to the root container of the button.                |
| `enabled`        | `Boolean`                         | `true`                                  | Controls whether the button is interactive.                 |
| `contentPadding` | `PaddingValues`                   | `ButtonDefaults.defaultButtonPadding()` | Internal spacing between container and content.             |
| `colors`         | `ButtonColors`                    | `ButtonDefaults.primaryButtonColors()`  | Colors used for background and content in different states. |
| `shape`          | `Shape`                           | `ButtonDefaults.defaultButtonShape`     | Defines the button's shape (e.g., rounded corners).         |
| `content`        | `@Composable RowScope.() -> Unit` | —                                       | Content inside the button, arranged via `RowScope`.         |

---


## With Icon and Text
"""
        )

        ComponentShowcase(
            code = """PrimaryButton(
    onClick = { /* Do something */ }
) {
    Icon(
        imageVector = PhIcons.Regular.Plus,
        contentDescription = null,
        modifier = Modifier.padding(end = 8.dp)
    )
    Text("Add New Item")
}""",
            content = {
                PrimaryButton(
                    onClick = { /* Do something */ }
                ) {
                    Icon(
                        imageVector = PhIcons.Regular.Plus,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text("Add New Item")
                }
            }
        )

        DefaultMarkdownParser(
            content = """### Custom Shape Padding and Colors

You can override the default shape to be perfectly round or drastically change the padding and colors.
"""
        )

        ComponentShowcase(
            code = """PrimaryButton(
    onClick = { /* Confirm action */ },
    shape = CircleShape,
    contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
    colors = ButtonDefaults.primaryButtonColors(
        containerColor = Color.Green,
        contentColor = Color.White
    )
) {
    Text("Confirm Everything")
}""",
            content = {
                PrimaryButton(
                    onClick = { /* Confirm action */ },
                    shape = CircleShape,
                    contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
                    colors = ButtonDefaults.primaryButtonColors(
                        containerColor = Color.Green,
                        contentColor = Color.White
                    )
                ) {
                    Text("Confirm Everything")
                }
            }
        )

        DefaultMarkdownParser(
            content = """## Other Variants

Kore provides three other Button variants that follow the exact same anatomy as the `PrimaryButton`, differing mostly in their default emphasis and colors.

"""
        )

        ComponentShowcase(
            code = """
                SecondaryButton(
                    onClick = { /* Save as draft */ }
                ) {
                    Text("Save as Draft")
                }
            """.trimIndent(),
            content = {
                SecondaryButton(
                    onClick = { /* Save as draft */ }
                ) {
                    Text("Save as Draft")
                }
            }
        )

        DefaultMarkdownParser(content = """## Outlined Button

A medium-emphasis action with a visible border. Useful for secondary actions that still need clear affordance.
""")

        ComponentShowcase(
            code = """OutlinedButton(
    onClick = { /* Delete action */ },
) {
    Text("Delete Permanently")
}""",
            content = {
                OutlinedButton(
                    onClick = { /* Delete action */ },
                ) {
                    Text("Delete Permanently")
                }
            }
        )

        DefaultMarkdownParser(content = """
            ## Ghost Button

            A low-emphasis, transparent button used for less important or optional actions like “Cancel” or “Learn More”.

        """.trimIndent())

        ComponentShowcase(
            code = """GhostButton(
    onClick = { /* Cancel action */ }
) {
    Text("Cancel")
}""",
            content = {
                GhostButton(
                    onClick = { /* Cancel action */ }
                ) {
                    Text("Cancel")
                }
            }
        )
}
}