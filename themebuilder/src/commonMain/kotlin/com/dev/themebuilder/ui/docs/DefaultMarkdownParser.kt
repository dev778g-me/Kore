package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dev.korelibrary.themes.KoreTheme
import com.mikepenz.markdown.compose.Markdown
import com.mikepenz.markdown.compose.components.markdownComponents
import com.mikepenz.markdown.model.DefaultMarkdownColors
import com.mikepenz.markdown.model.DefaultMarkdownTypography



@Composable
fun DefaultMarkdownParser(
    modifier: Modifier = Modifier,
    content: String
) {
    val typography = KoreTheme.typography
    val colorScheme = KoreTheme.colorScheme

    Markdown(
        modifier = modifier.fillMaxWidth(),
        content = content,
        typography = DefaultMarkdownTypography(
            h1 = typography.display1.copy(
                fontSize = 36.sp,
                lineHeight = 44.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.5).sp
            ),
            h2 = typography.display2.copy(
                fontSize = 30.sp,
                lineHeight = 38.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.25).sp
            ),
            h3 = typography.heading1.copy(
                fontSize = 24.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight.SemiBold
            ),
            h4 = typography.heading2.copy(
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.SemiBold
            ),
            h5 = typography.title1.copy(
                fontSize = 18.sp,
                lineHeight = 26.sp,
                fontWeight = FontWeight.Medium
            ),
            h6 = typography.title2.copy(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Medium
            ),
            text = typography.body1.copy(
                fontSize = 16.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.15.sp
            ),
            code = typography.body3.copy(
                fontSize = 13.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily.Monospace
            ),
            inlineCode = typography.body3.copy(
                fontSize = 13.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Medium
            ),
            quote = typography.body1.copy(
                fontStyle = FontStyle.Italic,
                lineHeight = 28.sp
            ),
            paragraph = typography.body1.copy(
                fontSize = 16.sp,
                lineHeight = 28.sp
            ),
            ordered = typography.body1.copy(
                fontSize = 16.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Medium
            ),
            bullet = typography.body1.copy(
                fontSize = 16.sp,
                lineHeight = 28.sp
            ),
            list = typography.body1.copy(
                fontSize = 16.sp,
                lineHeight = 28.sp
            ),
            textLink = TextLinkStyles(
                style = SpanStyle(
                    color = colorScheme.primary
                )
            ),
            table = typography.body3.copy(
                fontSize = 14.sp,
                lineHeight = 22.sp
            )
        ),
        colors = DefaultMarkdownColors(
            text = colorScheme.onBackGround,
            codeBackground = colorScheme.backGroundVariant,
            inlineCodeBackground = colorScheme.surfaceBright,
            dividerColor = colorScheme.onSurface.copy(alpha = 0.2f),
            tableBackground = colorScheme.surface,
//            tableBorder = colorScheme.onSurface.copy(alpha = 0.1f)
        ),
        components = markdownComponents(
            codeBlock = {

            }
        )
    )
}
