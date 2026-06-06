package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.card.OutlinedCard
import com.dev.kore.components.stack.VerticalStack

@Composable
fun QuickstartDocs(
    modifier: Modifier = Modifier,
) {
    VerticalStack (
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp),

    ) {

            DefaultMarkdownParser(
                content = """# QuickStart

Quickstart guide for using Kore.

Make sure you have installed the Kore library into your project:"""

            )

        OutlinedCard {
            CodeBlock(
                code = """```
implementation("io.github.dev778g-me:kore:1.0.0-alpha01")
```"""
            )
        }

        DefaultMarkdownParser(content = """Download and install the Kore companion app or web app.

<figure><img src="quickstart_images/companion_app.png" alt="companion app"><figcaption></figcaption></figure>

Although Kore comes with default themes `KoreDefaults`, you can customize it using the Kore Companion app **ThemeBuilder**. From there, choose color schemes for dark and light mode, shapes, and sizes — then hit export and you get your `theme.kt` file.

<figure><img src="quickstart_images/customize.png" alt="Customizing"><figcaption></figcaption></figure>

Add this file  to your project.

<figure><img src="quickstart_images/export.png" alt="export theme"><figcaption></figcaption></figure>

Wrap your main content with `AppTheme` (renameable inside `theme.kt`) and you're all set.



*Happy building 😻*
""")
        }
    }
