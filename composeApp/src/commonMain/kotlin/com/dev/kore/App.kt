package com.dev.kore

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.theme.AppTheme
import com.dev.korelibrary.components.buttons.PrimaryButton
import com.dev.korelibrary.components.buttons.SecondaryButton
import com.dev.korelibrary.components.card.Card
import com.dev.korelibrary.components.stack.VerticalStack
import com.dev.korelibrary.components.text.Text
import com.dev.korelibrary.themes.DefaultKoreTheme
import com.dev.korelibrary.utilities.modifiers.noRippleClickable
import com.dev.korelibrary.utilities.modifiers.scaleClickable


@Composable
fun App() {
    DefaultKoreTheme {
        com.dev.korelibrary.components.scaffold.Scaffold {
            VerticalStack(
                verticalAlignment = Alignment.CenterVertically,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize().padding(it).padding(horizontal = 16.dp)
            ) {
                Text(
                    text = """
        Alongside the library itself, Kore also includes a companion theme builder application inspired by tools like Material Theme Builder. The goal of the companion app is to simplify the process of generating themes visually without requiring manual configuration or deep knowledge of design systems. Developers can experiment with colors, typography, shapes, and component styling in real time. Currently, the companion app is available for Windows and Linux, with a web version planned for a future release.

        Kore is still in active development and continues to evolve with new components, improvements, and tooling updates. The project focuses heavily on developer experience, customization, clean architecture, and making Compose Multiplatform UI development more approachable for everyone.
    """.trimIndent()
                )
                
                
                val interaction1 = remember { MutableInteractionSource() }
                PrimaryButton(
                    interactionSource = interaction1,
                    onClick = {},
                    modifier = Modifier.noRippleClickable(
                        interactionSource = interaction1, onClick = {})) {
                    Text("hello")
                }



                SecondaryButton(
                    onClick = {}
                ){
                    Text("hello")
                }
            }
        }
    }
}
