package com.dev.themebuilder.ui.docs

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.dev.korelibrary.themes.KoreTheme

object KotlinSyntaxHighlighter {

    private val softKeywords = setOf(
        "abstract", "actual", "annotation", "as", "break", "by", "catch", "class",
        "companion", "const", "constructor", "continue", "crossinline", "data", "do",
        "else", "enum", "expect", "external", "false", "final", "finally", "for",
        "fun", "get", "if", "import", "in", "infix", "init", "inline", "internal",
        "is", "lateinit", "noinline", "null", "object", "open", "operator", "out",
        "override", "package", "private", "protected", "public", "reified", "return",
        "sealed", "set", "super", "suspend", "this", "throw", "true", "try", "typealias",
        "typeof", "val", "var", "vararg", "when", "where", "while"
    )

    private val hardKeywords = setOf(
        "fun", "val", "var", "class", "object", "interface", "if", "else", "when",
        "for", "while", "do", "return", "import", "package", "is", "in", "as", "by",
        "null", "true", "false", "this", "super", "data", "sealed", "enum", "companion",
        "override", "private", "public", "protected", "internal", "suspend", "inline",
        "reified", "expect", "actual", "typealias", "init", "constructor", "abstract",
        "open", "final", "lateinit", "const", "operator", "infix", "crossinline",
        "noinline", "external", "annotation", "throw", "try", "catch", "finally",
        "continue", "break", "it", "get", "set", "vararg", "out", "where"
    )

    private val parameterNames = setOf(
        "onClick", "contentDescription", "modifier", "imageVector",
        "text", "enabled", "selected", "checked", "expanded", "focused",
        "leadingIcon", "trailingIcon", "icon", "label", "title", "subtitle",
        "description", "value", "onValueChange", "progress", "color", "tint",
        "size", "weight", "fillMaxWidth", "fillMaxHeight", "padding", "margin",
        "backgroundColor", "contentColor", "border", "shape", "elevation", "alpha",
        "horizontalAlignment", "verticalAlignment", "horizontalArrangement",
        "verticalArrangement", "maxLines", "minLines", "fontSize", "fontWeight",
        "fontFamily", "fontStyle", "letterSpacing", "lineHeight", "textAlign",
        "overflow", "maxWidth", "maxHeight", "width", "height", "aspectRatio"
    )

    private val builtInTypes = setOf(
        "Any", "Boolean", "Byte", "Char", "Double", "Float", "Int", "Long",
        "Nothing", "Short", "String", "Unit", "Array", "List", "Map", "Set",
        "MutableList", "MutableSet", "MutableMap", "Pair", "Triple"
    )

    fun highlight(
        code: String,
        keywordColor: Color = Color(0xFF569CD6),
        stringColor: Color = Color(0xFFCE9178),
        commentColor: Color = Color(0xFF6A9955),
        docCommentColor: Color = Color(0xFF7A7E85),
        annotationColor: Color = Color(0xFFD7BA7D),
        numberColor: Color = Color(0xFFB5CEA8),
        typeColor: Color = Color(0xFF4EC9B0),
        functionColor: Color = Color(0xFFDCDCAA),
        parameterColor: Color = Color(0xFF9CDCFE),
        defaultColor: Color = Color(0xFFD4D4D4)
    ): AnnotatedString = buildAnnotatedString {
        val tokens = tokenize(code)
        for ((type, value) in tokens) {
            val style = when (type) {
                TokenType.KEYWORD    -> SpanStyle(color = keywordColor, fontWeight = FontWeight.Bold)
                TokenType.STRING     -> SpanStyle(color = stringColor)
                TokenType.LINE_COMMENT-> SpanStyle(color = commentColor)
                TokenType.BLOCK_COMMENT-> SpanStyle(color = docCommentColor)
                TokenType.ANNOTATION -> SpanStyle(color = annotationColor)
                TokenType.NUMBER     -> SpanStyle(color = numberColor)
                TokenType.TYPE       -> SpanStyle(color = typeColor)
                TokenType.PARAMETER  -> SpanStyle(color = parameterColor)
                TokenType.OPERATOR   -> SpanStyle(color = defaultColor)
                TokenType.PUNCTUATION-> SpanStyle(color = defaultColor)
                TokenType.DEFAULT    -> SpanStyle(color = defaultColor)
            }
            withStyle(style) { append(value) }
        }
    }

    @Composable
    fun highlightWithTheme(code: String): AnnotatedString {
        val scheme = KoreTheme.colorScheme
        return highlight(
            code = code,
            keywordColor = scheme.primary,
            stringColor = scheme.complementary,
            commentColor = scheme.onBackGroundVariant.copy(alpha = 0.7f),
            docCommentColor = scheme.onBackGroundVariant.copy(alpha = 0.5f),
            annotationColor = scheme.success,
            numberColor = scheme.complementary,
            typeColor = scheme.primary,
            functionColor = scheme.complementary,
            parameterColor = scheme.onSurface,
            defaultColor = scheme.onBackGround
        )
    }

    private enum class TokenType {
        KEYWORD, STRING, LINE_COMMENT, BLOCK_COMMENT, ANNOTATION,
        NUMBER, TYPE, PARAMETER, OPERATOR, PUNCTUATION, DEFAULT
    }

    private data class Token(val type: TokenType, val value: String)

    private val tokenRegex = Regex(
        """(\n)|(\s+)|(/\*[\s\S]*?\*/)|(//[^\n]*)|("(?:\\.|[^"\\])*"|''(?:\\.|[^'\\])'')|(@\w+)|(\b0x[\da-fA-F]+[\d]*\.?[\d]*[fFdDlL]?\b|\b\d+\.?\d*[fFdDlL]?\b)|(\b[A-Z][a-zA-Z0-9_]*\b)|(\b[a-z][a-zA-Z0-9_]*\b)|([+\-*/%=<>!&|^~?:]+)|([(){}\[\];,.])"""
    )

    private fun tokenize(code: String): List<Token> {
        return tokenRegex.findAll(code).map { match ->
            val value = match.value
            when {
                match.groupValues[1].isNotEmpty() -> Token(TokenType.DEFAULT, value)
                match.groupValues[2].isNotEmpty() -> Token(TokenType.DEFAULT, value)
                match.groupValues[3].isNotEmpty() -> Token(TokenType.BLOCK_COMMENT, value)
                match.groupValues[4].isNotEmpty() -> Token(TokenType.LINE_COMMENT, value)
                match.groupValues[5].isNotEmpty() -> Token(TokenType.STRING, value)
                match.groupValues[6].isNotEmpty() -> Token(TokenType.ANNOTATION, value)
                match.groupValues[7].isNotEmpty() -> Token(TokenType.NUMBER, value)
                match.groupValues[8].isNotEmpty() -> {
                    val word = match.groupValues[8]
                    if (word in builtInTypes || word.first().isUpperCase()) Token(TokenType.TYPE, value)
                    else Token(TokenType.DEFAULT, value)
                }
                match.groupValues[9].isNotEmpty() -> {
                    val word = match.groupValues[9]
                    when {
                        word in hardKeywords || word in softKeywords -> Token(TokenType.KEYWORD, value)
                        word in parameterNames -> Token(TokenType.PARAMETER, value)
                        else -> Token(TokenType.DEFAULT, value)
                    }
                }
                match.groupValues[10].isNotEmpty() -> Token(TokenType.OPERATOR, value)
                match.groupValues[11].isNotEmpty() -> Token(TokenType.PUNCTUATION, value)
                else -> Token(TokenType.DEFAULT, value)
            }
        }.toList()
    }
}