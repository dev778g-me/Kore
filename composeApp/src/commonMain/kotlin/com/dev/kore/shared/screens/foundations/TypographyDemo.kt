package com.dev.kore.shared.screens.foundations

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme

/**
 * The complete type scale of Kore: three displays, three headings, three
 * titles, three body styles and three label styles.
 */
@Composable
fun TypographyDemo() {
    val typography = KoreTheme.typography

    val styles = listOf(
        "display1" to typography.display1,
        "display2" to typography.display2,
        "display3" to typography.display3,
        "heading1" to typography.heading1,
        "heading2" to typography.heading2,
        "heading3" to typography.heading3,
        "title1" to typography.title1,
        "title2" to typography.title2,
        "title3" to typography.title3,
        "body1" to typography.body1,
        "body2" to typography.body2,
        "body3" to typography.body3,
        "label1" to typography.label1,
        "label2" to typography.label2,
        "label3" to typography.label3,
    )

    DemoPage {
        styles.forEach { (name, style) ->
            DemoBlock(title = name) {
                TypeSpecimen(name = name, style = style)
            }
        }
    }
}

@Composable
private fun TypeSpecimen(name: String, style: TextStyle) {
    Text(
        text = "The quick brown fox jumps over the lazy dog",
        textStyle = style,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.fillMaxWidth(),
    )
    Text(
        text = "${style.fontSize.value.toInt()}sp / ${style.lineHeight.value.toInt()}sp · weight ${style.fontWeight?.weight ?: 400} · $name",
        textStyle = KoreTheme.typography.label2,
        color = KoreTheme.colorScheme.onBackGroundVariant,
    )
}
