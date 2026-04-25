package com.dev.korelibrary.utilities.extensions

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit


fun TextStyle.bold(): TextStyle{
    return copy(fontWeight = FontWeight.Bold)
}

fun TextStyle.extraBold() : TextStyle {
    return copy(fontWeight = FontWeight.ExtraBold)
}

fun TextStyle.semiBold(): TextStyle{
    return copy(
        fontWeight = FontWeight.SemiBold
    )
}

fun TextStyle.medium(): TextStyle{
    return  copy(fontWeight = FontWeight.Medium)
}

fun TextStyle.light() : TextStyle {
    return  copy(fontWeight = FontWeight.Light)
}

fun TextStyle.extraLight() : TextStyle {
    return  copy(fontWeight = FontWeight.ExtraLight)
}

fun TextStyle.normal() : TextStyle {
    return copy(
        fontWeight = FontWeight.Normal
    )
}


fun TextStyle.size(size: TextUnit): TextStyle {
    return copy(fontSize = size)
}


fun TextStyle.letterSpacing(spacing: TextUnit): TextStyle {
    return copy(letterSpacing = spacing)
}

fun TextStyle.lineHeight(height: TextUnit): TextStyle {
    return copy(lineHeight = height)
}


fun TextStyle.strikethrough(): TextStyle {
  return  copy(textDecoration = TextDecoration.LineThrough)
}

fun TextStyle.underline(): TextStyle {
    return copy(textDecoration = TextDecoration.Underline)
}

fun TextStyle.italic(): TextStyle{
    return copy(fontStyle = FontStyle.Italic)
}


fun TextStyle.color(color: Color): TextStyle {
    return copy(color = color)
}


fun TextStyle.alignCenter(): TextStyle {
    return copy(textAlign = TextAlign.Center)
}

fun TextStyle.alignEnd(): TextStyle {
    return copy(textAlign = TextAlign.End)
}