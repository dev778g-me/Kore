package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.switch.Switch
import com.dev.kore.components.switch.SwitchDefaults
import com.dev.kore.components.text.Text
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Moon
import com.phosphor.icons.regular.Sun

@Composable
fun SwitchDocs(
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
    ) {
        DefaultMarkdownParser(
            content = """# Switch

A Switch is a visual toggle that allows users to instantly change the state of a single setting between "On" and "Off". It is the digital equivalent of a physical light switch and is used to provide immediate feedback for binary choices.

You can use Switches for:
- Binary settings that take effect immediately (e.g., toggling Wi-Fi, Dark Mode, or Airplane Mode).
- Enabling or disabling specific features within a settings menu.

When not to use Switches:
- When the user must choose one option from a set of many (use RadioButtons).
- When the action requires a "Submit" or "Apply" button to take effect (use a CheckBox).
- For navigation between screens.

> For deeper reference check out [Mobbin](https://mobbin.com/glossary/switch) guide on Switch

---

## Basic Example

Like other input components in KoreLibrary, the Switch is stateless. You must hoist the checked state and update it via onCheckChange callback.

<figure><img src="showcases/switchShowcase/switch.png" alt="Switch example image"><figcaption></figcaption></figure>

"""
        )

        ComponentShowcase(
            code = """
var isEnabled by remember { mutableStateOf(false) }

Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier.fillMaxWidth()
) {
    Text("Enable Push Notifications")
    Spacer(Modifier.weight(1f))
    Switch(
        checked = isEnabled,
        onCheckChange = { isEnabled = it }
    )
}
""".trimIndent(),
            content = {
                var isEnabled by remember { mutableStateOf(false) }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                ) {
                    Text("Enable Push Notifications")
                    Spacer(Modifier.weight(1f))
                    Switch(
                        checked = isEnabled,
                        onCheckChange = { isEnabled = it }
                    )
                }
            }
        )

        DefaultMarkdownParser(
            content = """
---

## Styling 

The Switch API provides granular control over the sizes of both the track and the thumb, as well as the transition specifications for internal content.

### Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| checked | Boolean | — | Whether the switch is currently on or off. |
| onCheckChange | ((Boolean) -> Unit)? | — | Callback invoked when the user toggles the switch. |
| modifier | Modifier | Modifier | Applied to the outer track container. |
| enabled | Boolean | true | When false, the switch is greyed out and non-interactive. |
| checkThumbContent | @Composable () -> Unit | null | Optional content to show inside the thumb when checked. |
| unCheckedThumbContent| @Composable () -> Unit | null | Optional content to show inside the thumb when unchecked. |
| switchTrackWidth | Dp | SwitchDefaults.defaultSwitchTrackWidth | The total width of the switch track. |
| switchTrackHeight | Dp | SwitchDefaults.defaultSwitchHeight | The total height of the switch track. |
| thumbSize | Dp | SwitchDefaults.defaultSwitchSize | The diameter/size of the sliding thumb. |
| thumbPadding | Dp | SwitchDefaults.thumbPadding | The inset of the thumb from the track edges. |
| transitionSpec | AnimatedContentTransitionScope | SwitchDefaults.defaultTransitionSpec | Customizes the animation logic for the thumb content. |
| switchColors | SwitchColors | SwitchDefaults.defaultSwitchColors() | Defines track and thumb colors for all states. |

---

### Advanced Thumb Content

One of the standout features of the KoreLibrary Switch is the ability to add content inside the thumb that animates when the state changes. This is perfect for adding icons (like a sun/moon or check/cross) to provide extra visual clarity.


<figure><img src="showcases/switchShowcase/withThumb_Content_switch.png" alt="Switch example image"><figcaption></figcaption></figure>


"""
        )

        ComponentShowcase(
            code = """
var isDarkMode by remember { mutableStateOf(false) }

Switch(
    checked = isDarkMode,
    onCheckChange = { isDarkMode = it },
    checkThumbContent = {
        Icon(
            imageVector = PhIcons.Regular.Moon, 
            contentDescription = null, 
            modifier = Modifier.size(12.dp)
        )
    },
    unCheckedThumbContent = {
        Icon(
            imageVector = PhIcons.Regular.Sun, 
            contentDescription = null, 
            modifier = Modifier.size(12.dp)
        )
    }
)
""".trimIndent(),
            content = {
                var isDarkMode by remember { mutableStateOf(false) }
                Switch(
                    checked = isDarkMode,
                    onCheckChange = { isDarkMode = it },
                    checkThumbContent = {
                        Icon(
                            imageVector = PhIcons.Regular.Moon, 
                            contentDescription = null, 
                            modifier = Modifier.size(12.dp)
                        )
                    },
                    unCheckedThumbContent = {
                        Icon(
                            imageVector = PhIcons.Regular.Sun, 
                            contentDescription = null, 
                            modifier = Modifier.size(12.dp)
                        )
                    }
                )
            }
        )

        DefaultMarkdownParser(
            content = """
By default, the switch is pill-shaped, but you can pass custom shapes to the trackShape and thumbShape to match a more industrial or blocky design system.

<figure><img src="showcases/switchShowcase/custom_switch.png" alt="Custom Switch example image"><figcaption></figcaption></figure>


"""
        )

        ComponentShowcase(
            code = """
var checked by remember { mutableStateOf(true) }

Switch(
    checked = checked,
    onCheckChange = { checked = it },
    trackShape = RoundedCornerShape(4.dp),
    thumbShape = RoundedCornerShape(2.dp),
    switchTrackWidth = 60.dp,
    switchTrackHeight = 32.dp,
    thumbSize = 24.dp
)
""".trimIndent(),
            content = {
                var checked by remember { mutableStateOf(true) }
                Switch(
                    checked = checked,
                    onCheckChange = { checked = it },
                    trackShape = RoundedCornerShape(4.dp),
                    thumbShape = RoundedCornerShape(2.dp),
                    switchTrackWidth = 60.dp,
                    switchTrackHeight = 32.dp,
                    thumbSize = 24.dp
                )
            }
        )

        DefaultMarkdownParser(
            content = """
### Micro-Interactions
The Switch includes a built-in thumbScale animation. When the switch is checked, the thumb grows slightly (1.1f) and shrinks slightly when unchecked (0.9f), providing a tactile, "bouncy" feel to the interface.
"""
        )
    }
}