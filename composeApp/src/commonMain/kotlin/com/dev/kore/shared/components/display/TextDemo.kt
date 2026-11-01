package com.dev.kore.shared.components.display

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.extensions.bold
import com.dev.kore.utilities.extensions.italic
import com.dev.kore.utilities.extensions.size
import com.dev.kore.utilities.extensions.strikethrough
import com.dev.kore.utilities.extensions.underline

@Composable
fun TextDemo() {
    DemoPage {
        DemoBlock(title = "Default") {
            Text("The quick brown fox jumps over the lazy dog")
        }

        DemoBlock(title = "Text styles") {
            Text("body1", textStyle = KoreTheme.typography.body1)
            Text("body2", textStyle = KoreTheme.typography.body2)
            Text("body3", textStyle = KoreTheme.typography.body3)
            Text("label1", textStyle = KoreTheme.typography.label1)
            Text("label2", textStyle = KoreTheme.typography.label2)
            Text("label3", textStyle = KoreTheme.typography.label3)
        }

        DemoBlock(title = "Weights") {
            Text("Normal", fontWeight = FontWeight.Normal)
            Text("Medium", fontWeight = FontWeight.Medium)
            Text("SemiBold", fontWeight = FontWeight.SemiBold)
            Text("Bold", fontWeight = FontWeight.Bold)
            Text("Black", fontWeight = FontWeight.Black)
        }

        DemoBlock(title = "Colors") {
            Text("primary", color = KoreTheme.colorScheme.primary)
            Text("complementary", color = KoreTheme.colorScheme.complementary)
            Text("success", color = KoreTheme.colorScheme.success)
            Text("error", color = KoreTheme.colorScheme.error)
            Text("onBackGroundVariant", color = KoreTheme.colorScheme.onBackGroundVariant)
        }

        DemoBlock(title = "Decoration") {
            Text("Underline", textDecoration = TextDecoration.Underline)
            Text("Line through", textDecoration = TextDecoration.LineThrough)
            Text("Custom size", fontSize = 24.sp)
            Text("Centered", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        }

        DemoBlock(title = "Text style extensions") {
            Text("bold()", textStyle = KoreTheme.typography.body1.bold())
            Text("italic()", textStyle = KoreTheme.typography.body1.italic())
            Text("underline()", textStyle = KoreTheme.typography.body1.underline())
            Text("strikethrough()", textStyle = KoreTheme.typography.body1.strikethrough())
            Text("size(22.sp)", textStyle = KoreTheme.typography.body1.size(22.sp))
        }

        DemoBlock(title = "Overflow") {
            Text(
                text = "This paragraph is forced on a single line and will be truncated with an ellipsis instead of wrapping.",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}
