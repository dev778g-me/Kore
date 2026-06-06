package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.GhostButton
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.stack.HorizontalStack
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.LockKey

@Composable
fun StackDocs(
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
    ) {
        DefaultMarkdownParser(
            content = """# Stacks

Stacks are foundational layout components designed to arrange child elements sequentially (either vertically or horizontally). While they behave similarly to standard Jetpack Compose `Column` and `Row` components, Stacks automatically enforce consistent, theme-based spacing between each child item to ensure your UI looks uniform and adheres to your design system guidelines.

You can use Stacks for:
- Grouping related elements together with consistent gaps (e.g., a title, subtitle, and paragraph).
- Building toolbars or action rows where buttons need standard spacing.
- Creating forms where input fields are stacked uniformly.

When not to use Stacks:
- For overlapping elements (use a standard `Box` instead).
- For very long, scrollable lists of hundreds of items (use `LazyColumn` or `LazyRow` to preserve memory).


---

## Vertical Stack

The `VerticalStack` arranges its children from top to bottom. It is essentially a `Column` that applies an automatic gap (`spacing`) between each child.

### Basic Example 

<figure><img src="showcases/stackShowcase/vertical_stack.png" alt="Vertical Stack example image"><figcaption></figcaption></figure>


"""
        )

        ComponentShowcase(
            code = """
VerticalStack(
    spacing = KoreTheme.sizes.md, // Custom spacing override
    horizontalAlignment = Alignment.Start
) {
    Text("User Profile")
    Text("Manage your account settings below.")
    PrimaryButton(onClick = { /* ... */ }) {
        Text("Edit Profile")
    }
}
""".trimIndent(),
            content = {
                VerticalStack(
                    spacing = KoreTheme.sizes.md,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text("User Profile", textStyle = KoreTheme.typography.heading3)
                    Text("Manage your account settings below.")
                    PrimaryButton(onClick = { }) {
                        Text("Edit Profile")
                    }
                }
            }
        )

        DefaultMarkdownParser(
            content = """
### Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | Applied to the root container of the layout. |
| `spacing` | `Dp` | `KoreTheme.sizes.xs` | The vertical gap applied exactly between each child element. |
| `verticalAlignment` | `Alignment.Vertical` | `StackDefaults.defaultVerticalAlignment` | Aligns the entire block of stacked children vertically if the stack is taller than its contents. |
| `horizontalAlignment`| `Alignment.Horizontal` | `StackDefaults.defaultHorizontalAlignment`| Aligns individual children along the horizontal (cross) axis. |
| `content` | `@Composable ColumnScope.() -> Unit`| — | The elements to display vertically. |

---

## Horizontal Stack

The `HorizontalStack` arranges its children from left to right. It is essentially a `Row` that applies an automatic gap (`spacing`) between each child.

### Basic Example

<figure><img src="showcases/stackShowcase/horizontal_stack.png" alt="Horizontal example image"><figcaption></figcaption></figure>

"""
        )

        ComponentShowcase(
            code = """
HorizontalStack(
    modifier = Modifier.fillMaxWidth(),
    spacing = KoreTheme.sizes.sm,
    horizontalAlignment = Alignment.CenterHorizontally // Centers the group of buttons
) {
    GhostButton(onClick = { /* ... */ }) { Text("Cancel") }
    PrimaryButton(onClick = { /* ... */ }) { Text("Save Changes") }
}
""".trimIndent(),
            content = {
                HorizontalStack(
                    modifier = Modifier.fillMaxWidth(),
                    spacing = KoreTheme.sizes.sm,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    GhostButton(onClick = { }) { Text("Cancel") }
                    PrimaryButton(onClick = { }) { Text("Save Changes") }
                }
            }
        )

        DefaultMarkdownParser(
            content = """
### Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | Applied to the root container of the layout. |
| `spacing` | `Dp` | `KoreTheme.sizes.xs` | The horizontal gap applied exactly between each child element. |
| `horizontalAlignment`| `Alignment.Horizontal` | `StackDefaults.defaultHorizontalAlignment`| Aligns the entire block of stacked children horizontally if the stack is wider than its contents. |
| `verticalAlignment` | `Alignment.Vertical` | `StackDefaults.defaultVerticalAlignment` | Aligns individual children vertically along the cross axis. |
| `content` | `@Composable RowScope.() -> Unit` | — | The elements to display horizontally. |

---

## Customization & Layout Behavior

Because these components expose the `verticalAlignment` and `horizontalAlignment` parameters used in `Arrangement.spacedBy`, you can easily control how the stack behaves when given a strict size.

### Centered Form Box
If you give a `VerticalStack` a specific height, you can center its children perfectly while maintaining the gap between them:

<figure><img src="showcases/stackShowcase/custom_stack.png" alt="Stack example image"><figcaption></figcaption></figure>


"""
        )

        ComponentShowcase(
            code = """
VerticalStack(
    modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
        .background(KoreTheme.colorScheme.surface),
    verticalAlignment = Alignment.CenterVertically, // Centers the cluster of items
    spacing = 16.dp
) {
    Icon(imageVector = PhIcons.Regular.LockKey, contentDescription = null)
    Text("Please log in to continue")
}
""".trimIndent(),
            content = {
                VerticalStack(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(KoreTheme.colorScheme.surface),
                    verticalAlignment = Alignment.CenterVertically,
                    spacing = 16.dp
                ) {
                    Icon(imageVector = PhIcons.Regular.LockKey, contentDescription = null)
                    Text("Please log in to continue")
                }
            }
        )
    }
}