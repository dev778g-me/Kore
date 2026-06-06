package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.dev.kore.components.radio.RadioButton
import com.dev.kore.components.radio.RadioButtonDefaults
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text

@Composable
fun RadioButtonDocs(
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
    ) {
        DefaultMarkdownParser(
            content = """# Radio Button

Radio Button is a ui component that allows user to select exactly one option from a predefined set of choices.

When to use Radio Button :
- Forms or surveys 
- Limited choice (fewer option like 4-5)
- When comparision of option is needed

When to avoid Radio Button : 
- if user needs to selecte `multiple` options (use a `CheckBox` instead)
- If there are large number of actions (more than 5 )
- For immediate actions that take effect the momment they are toggled (use a `Switch` instead)


> For deeper reference check out [Mobbin](https://mobbin.com/glossary/radio-button) guide on Radio Button


## Basic Example 

Because a Radio Button is stateless by default, you must manage the currently selected option in your parent composable and pass the `selected` state down.

<figure><img src="showcases/radioShowcase/radio_button_showcase.png" alt="Usage of Radio buttons"><figcaption></figcaption></figure>

"""
        )

        ComponentShowcase(
            code = """
val options = listOf("Standard", "Premium", "Enterprise")
var selectedOption by remember { mutableStateOf(options[0]) }

Column {
    options.forEach { text ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .selectable( // standard compose modifier for radio groups
                    selected = (text == selectedOption),
                    onClick = { selectedOption = text },
                    role = Role.RadioButton
                )
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            RadioButton(
                selected = (text == selectedOption),
                onClick = null // Handled by the Row's selectable modifier for a larger touch target
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = text)
        }
    }
}
""".trimIndent(),
            content = {
                val options = listOf("Standard", "Premium", "Enterprise")
                var selectedOption by remember { mutableStateOf(options[0]) }
                Column {
                    options.forEach { text ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = (text == selectedOption),
                                    onClick = { selectedOption = text },
                                    role = Role.RadioButton
                                )
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            RadioButton(
                                selected = (text == selectedOption),
                                onClick = null
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = text)
                        }
                    }
                }
            }
        )

        DefaultMarkdownParser(
            content = """
## Styling 

The Radio Button exposes parameters to customize its interaction and color states.

### Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `selected` | `Boolean` | — | The current selected state of the radio button. |
| `modifier` | `Modifier` | `Modifier` | Applied to the root container of the radio button. |
| `onClick` | `(() -> Unit)?` | — | Callback invoked when the radio button is clicked. If null, the button won't emit clicks. |
| `enabled` | `Boolean` | `true` | Controls the interactive and visual enabled state of the radio button. |
| `colors` | `RadioButtonColors` | `RadioButtonDefaults.defaultRadioColors()`| The resolved colors used for the inner dot and outer ring in different states. |
| `interactionSource` | `MutableInteractionSource?`| `null` | Represents the stream of interactions (e.g., pressed, hovered). |

### Radio Button with a Label (Best Practice)

A standalone Radio Button does not include a text label. To create a labeled Radio Button that has a large, accessible touch target, you should wrap it in a `Row` and handle the click at the row level (as shown in the Basic Example above). Setting the Radio Button's `onClick` to `null` prevents duplicate ripple effects.

### Custom Colors

You can override the default styling to apply specific brand colors to the unselected ring or the selected inner dot.

<figure><img src="showcases/radioShowcase/custom_radio.png" alt="Customized  Radio "><figcaption></figcaption></figure>


"""
        )

        ComponentShowcase(
            code = """
var isSelected by remember { mutableStateOf(true) }

RadioButton(
    selected = isSelected,
    onClick = { isSelected = !isSelected },
    colors = RadioButtonDefaults.defaultRadioColors(
        selectedColor = Color.Green,
        unSelectedColor = Color.DarkGray,
        disabledSelectedColor = Color.LightGray
    )
)
""".trimIndent(),
            content = {
                var isSelected by remember { mutableStateOf(true) }
                RadioButton(
                    selected = isSelected,
                    onClick = { isSelected = !isSelected },
//                    colors = RadioButtonDefaults.defaultRadioColors(
//                        selectedColor = androidx.compose.ui.graphics.Color.Green,
//                        unSelectedColor = androidx.compose.ui.graphics.Color.DarkGray,
//                        disabledSelectedColor = androidx.compose.ui.graphics.Color.LightGray
//                    )
                )
            }
        )
    }
}