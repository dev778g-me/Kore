package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.kore.components.card.OutlinedCard
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import koreproject.themebuilder.generated.resources.Res
import koreproject.themebuilder.generated.resources.createPage
import koreproject.themebuilder.generated.resources.export_dark
import koreproject.themebuilder.generated.resources.home_dark
import org.jetbrains.compose.resources.painterResource

@Composable
fun QuickstartDocs(
    modifier: Modifier = Modifier,
) {
    val textStyle = KoreTheme.typography.body1.copy(
        fontSize = 16.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.15.sp,
        color = KoreTheme.colorScheme.onBackGround.copy(alpha = 0.85f)
    )

    val localUriHandler = LocalUriHandler.current

    VerticalStack(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp),
    ) {

        DefaultMarkdownParser(
            content = """# QuickStart

Get up and running with Kore in a few simple steps.

First, add the Kore dependency to your project:"""
        )

        OutlinedCard {
            CodeBlock(
                code = """```kotlin
implementation("io.github.dev778g-me:kore:1.0.0-alpha02")
```"""
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "While Kore works perfectly out of the box using KoreDefaults, configuring your own design system is highly recommended.",
                textStyle = textStyle
            )

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    modifier = Modifier.clickable(
                        onClick = {
                            localUriHandler.openUri("https://kore-3j8.pages.dev/#create")
                        }
                    ),
                    text = buildAnnotatedString {
                        append("Visit the")

                        withStyle(style = SpanStyle(color = KoreTheme.colorScheme.primary)){
                            append(" Kore Playground")
                        }
                    },
                    textStyle = textStyle
                )
                Image(
                    painter = painterResource(resource = Res.drawable.home_dark),
                    contentDescription = "Kore Playground Home",
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "2. Customize your design system: tweak colors (neutrals, primary, and complementary accents), shapes, and spacing.",
                    textStyle = textStyle
                )
                Image(
                    painter = painterResource(resource = Res.drawable.createPage),
                    contentDescription = "Customize Theme",
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "3. Generate and export the Theme.kt file, then drop it into your project.",
                    textStyle = textStyle
                )
                Image(
                    painter = painterResource(resource = Res.drawable.export_dark),
                    contentDescription = "Export Theme",
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Text(
                text = "4. Wrap your root composable with AppTheme (feel free to rename this inside the file).",
                textStyle = textStyle
            )

            Text(
                text = "That's it. All Kore components will now automatically adapt to your custom theme.\n\nHappy building \uD83D\uDE3B",
                textStyle = textStyle
            )
        }
    }
}
