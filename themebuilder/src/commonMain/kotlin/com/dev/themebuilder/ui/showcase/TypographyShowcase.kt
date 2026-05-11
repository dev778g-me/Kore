package com.dev.themebuilder.ui.showcase

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.card.Card
import com.dev.korelibrary.components.card.CardDefaults
import com.dev.korelibrary.components.separators.HorizontalSeparator
import com.dev.korelibrary.components.stepper.Stepper
import com.dev.korelibrary.components.text.Text
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.utilities.extensions.color

@Composable
fun TypographyShowcase(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.defaultCardColors(
            contentColor = KoreTheme.colorScheme.onBackGround
        )

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Typography System",
                fontWeight = FontWeight.Bold,
                textStyle = KoreTheme.typography.title1.color(color = KoreTheme.colorScheme.onSurface)
            )

            HorizontalSeparator()

            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                TypographyItem(
                    name = "display1",
                    textStyle = KoreTheme.typography.display1,
                    sample = "Hero Text"
                )
                TypographyItem(
                    name = "heading 2",
                    textStyle = KoreTheme.typography.heading2,
                    sample = "Section Heading"
                )
                TypographyItem(
                    name = "title1",
                    textStyle = KoreTheme.typography.title1,
                    sample = "Card Title"
                )
            }

            HorizontalSeparator()

            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                TypographyItem(
                    name = "body 1",
                    textStyle = KoreTheme.typography.body1,
                    sample = "The quick brown fox jumps over the lazy dog. This is standard paragraph text used for long-form reading."
                )
                TypographyItem(
                    name = "body 2",
                    textStyle = KoreTheme.typography.body2,
                    sample = "The quick brown fox jumps over the lazy dog. Used for secondary descriptions."
                )
            }

            HorizontalSeparator()

            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                TypographyItem(
                    name = "label 1",
                    textStyle = KoreTheme.typography.label1,
                    sample = "Section label or category name"
                )
                TypographyItem(
                    name = "label 3",
                    textStyle = KoreTheme.typography.label3,
                    sample = "Caption or tiny helper text"
                )

            }
        }
    }
}

@Composable
private fun TypographyItem(
    name: String,
    textStyle: TextStyle,
    sample: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = name,
                textStyle = KoreTheme.typography.label2,
                color = KoreTheme.colorScheme.primary
            )
            Text(
                text = "${textStyle.fontSize.value.toInt()}sp • ${textStyle.fontWeight?.weight ?: 400}",
                textStyle = KoreTheme.typography.label3,
                color = KoreTheme.colorScheme.onBackGroundVariant
            )
        }

        Text(
            text = sample,
            textStyle = textStyle,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}