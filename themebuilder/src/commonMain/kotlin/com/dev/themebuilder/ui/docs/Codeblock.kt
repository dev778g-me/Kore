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

@Composable
fun CodeBlock(
    modifier: Modifier = Modifier,
    code : String,
    language : String = "Kotlin"
){

    OutlinedCard(
        modifier = modifier
    ) {

        VerticalStack(
            spacing = 2.dp
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = language,
                    textStyle = KoreTheme.typography.label2,
                    color = KoreTheme.colorScheme.success
                )


            }

            HorizontalSeparator()

            Text(
                modifier = Modifier.fillMaxWidth(),
                fontFamily = FontFamily.Monospace,
                text = if (language == "Kotlin") {
                    KotlinSyntaxHighlighter.highlightWithTheme(code)
                } else {
                    AnnotatedString(code)
                },
                textStyle = KoreTheme.typography.body2
            )
        }
    }

}

expect fun copyToClipboard(text: String)