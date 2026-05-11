package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.card.OutlinedCard
import com.dev.korelibrary.components.separators.HorizontalSeparator
import com.dev.korelibrary.components.stack.VerticalStack
import com.dev.korelibrary.components.text.Text
import com.dev.korelibrary.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Clipboard
import com.phosphor.icons.regular.Code

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

                CodeSwitch(
                    onClick = {
                        copyToClipboard(code)
                    },
                    icon = PhIcons.Regular.Clipboard,
                    content = "Copy Code"
                )


            }



            Text(
                modifier = Modifier.fillMaxWidth(),
                fontFamily = FontFamily.Monospace,
                text = if (language == "Kotlin") {
                    KotlinSyntaxHighlighter.highlightWithTheme(code)
                } else {
                    AnnotatedString(code)
                },
                textStyle = KoreTheme.typography.body2.copy(
                    fontFamily = FontFamily.Monospace
                )
            )
        }
    }



expect fun copyToClipboard(text: String)