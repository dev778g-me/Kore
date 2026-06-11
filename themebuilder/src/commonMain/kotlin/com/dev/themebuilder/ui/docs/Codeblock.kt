package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Clipboard
import koreproject.themebuilder.generated.resources.Res
import koreproject.themebuilder.generated.resources.jetBrains_mono
import org.jetbrains.compose.resources.Font

@Composable
fun CodeBlock(
    modifier: Modifier = Modifier,
    code : String,
    language : String = "Kotlin"
){

    VerticalStack(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

                Text(
                    text = language,
                    textStyle = KoreTheme.typography.label1,
                    color = KoreTheme.colorScheme.success
                )

                CodeCopyButton(
                    copyContent = code,
                    content = "Copy Code"
                )


        }



        SelectionContainer {
            Text(
                modifier = Modifier.fillMaxWidth(),
                fontFamily = jetBrainsMono(),
                text = if (language == "Kotlin") {
                    KotlinSyntaxHighlighter.highlightWithTheme(code,)
                } else {
                    AnnotatedString(code)
                },
                textStyle = KoreTheme.typography.body2
            )
        }
        }
    }


@Composable
fun  jetBrainsMono() = FontFamily(
    fonts = listOf(
        Font(resource = Res.font.jetBrains_mono, FontWeight.Thin),
        Font(resource = Res.font.jetBrains_mono, FontWeight.ExtraLight),
        Font(resource = Res.font.jetBrains_mono, FontWeight.Light),
        Font(resource = Res.font.jetBrains_mono, FontWeight.Normal),
        Font(resource = Res.font.jetBrains_mono, FontWeight.Medium),
        Font(resource = Res.font.jetBrains_mono, FontWeight.SemiBold),
        Font(resource = Res.font.jetBrains_mono, FontWeight.Bold),
        Font(resource = Res.font.jetBrains_mono, FontWeight.ExtraBold),
        Font(Res.font.jetBrains_mono, FontWeight.Black),
    )
)
expect fun copyToClipboard(text: String)