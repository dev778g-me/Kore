package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.sp
import com.dev.korelibrary.components.badge.PrimaryBadge
import com.dev.korelibrary.components.text.Text
import com.dev.korelibrary.themes.KoreTheme
import com.mikepenz.markdown.annotator.AnnotatorSettings
import com.mikepenz.markdown.annotator.annotatorSettings
import com.mikepenz.markdown.compose.LocalMarkdownColors
import com.mikepenz.markdown.compose.LocalMarkdownComponents
import com.mikepenz.markdown.compose.LocalMarkdownDimens
import com.mikepenz.markdown.compose.LocalMarkdownPadding
import com.mikepenz.markdown.compose.LocalMarkdownTypography
import com.mikepenz.markdown.compose.Markdown
import com.mikepenz.markdown.compose.MarkdownElement
import com.mikepenz.markdown.compose.components.CurrentComponentsBridge
import com.mikepenz.markdown.compose.components.markdownComponents
import com.mikepenz.markdown.compose.elements.MarkdownDivider
import com.mikepenz.markdown.compose.elements.MarkdownTableBasicText
import com.mikepenz.markdown.compose.elements.MarkdownText
import com.mikepenz.markdown.model.DefaultMarkdownColors
import com.mikepenz.markdown.model.DefaultMarkdownTypography
import org.intellij.markdown.IElementType
import org.intellij.markdown.MarkdownElementTypes
import org.intellij.markdown.MarkdownElementTypes.IMAGE
import org.intellij.markdown.MarkdownTokenTypes
import org.intellij.markdown.MarkdownTokenTypes.Companion.EOL
import org.intellij.markdown.ast.ASTNode
import org.intellij.markdown.ast.findChildOfType
import org.intellij.markdown.flavours.gfm.GFMElementTypes.HEADER
import org.intellij.markdown.flavours.gfm.GFMElementTypes.ROW
import org.intellij.markdown.flavours.gfm.GFMTokenTypes.CELL
import org.intellij.markdown.flavours.gfm.GFMTokenTypes.TABLE_SEPARATOR


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
                fontSize = 30.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.5).sp
            ),
            h2 = typography.display2.copy(
                fontSize = 26.sp,
                lineHeight = 38.sp,
                fontWeight = FontWeight.SemiBold,
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
                fontFamily = jetBrainsMono()
            ),
            inlineCode = typography.body3.copy(
                fontSize = 13.sp,
                lineHeight = 20.sp,
                fontFamily = jetBrainsMono(),
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
            inlineCodeBackground = colorScheme.background,
            dividerColor = colorScheme.onSurface.copy(alpha = 0.2f),
            tableBackground = colorScheme.surface,
        ),
        components = markdownComponents(
            blockQuote = {
                DefaultMarkdownBlockQuote(
                    content = it.content,
                    node = it.node,
                    style = it.typography.quote
                )
            },

            heading1 = {
                DefaultMarkdownHeader(
                    content = it.content,
                    style = it.typography.h1,
                    node = it.node
                )
            },
            heading2 = {
                DefaultMarkdownHeader(
                    content = it.content,
                    style = it.typography.h2,
                    node = it.node
                )
            },
            heading3 = {
                DefaultMarkdownHeader(
                    content = it.content,
                    style = it.typography.h3,
                    node = it.node
                )
            },
            heading4 = {
                DefaultMarkdownHeader(
                    content = it.content,
                    style = it.typography.h4,
                    node = it.node
                )
            },
            paragraph = {
                DefaultMarkdownHeader(
                    content = it.content,
                    style = it.typography.paragraph,
                    node = it.node
                )
            },

            table = {
                ScrollableMarkdownTable(
                    content = it.content,
                    node = it.node,
                    style = it.typography.table,
                    annotatorSettings = annotatorSettings(),
                )
            })
    )
}

@Composable
fun ScrollableMarkdownTable(
    content: String,
    node: ASTNode,
    style: TextStyle,
    annotatorSettings: AnnotatorSettings = annotatorSettings(),
    headerBlock: @Composable (String, ASTNode, Dp, TextStyle) -> Unit = { content, header, tableWidth, style ->
        ScrollableMarkdownTableHeader(
            content = content, header = header, tableWidth = tableWidth, style = style, annotatorSettings = annotatorSettings,
        )
    },
    rowBlock: @Composable (String, ASTNode, Dp, TextStyle) -> Unit = { content, header, tableWidth, style ->
        ScrollableMarkdownTableRow(
            content = content, header = header, tableWidth = tableWidth, style = style, annotatorSettings = annotatorSettings,
        )
    },
) {
    val tableMaxWidth = LocalMarkdownDimens.current.tableMaxWidth
    val tableCellWidth = maxOf(LocalMarkdownDimens.current.tableCellWidth, 160.dp)
    val tableCornerSize = LocalMarkdownDimens.current.tableCornerSize

    val columnsCount = remember(node) { node.findChildOfType(HEADER)?.children?.count { it.type == CELL } ?: 0 }
    val tableWidth = columnsCount * tableCellWidth

    val backgroundCodeColor = Color.Transparent
    val scrollState = rememberScrollState()

    BoxWithConstraints(
        modifier = Modifier
            .background(backgroundCodeColor, RoundedCornerShape(tableCornerSize))
            .widthIn(max = tableMaxWidth)
    ) {
        val scrollable = maxWidth <= tableWidth
        Column(
            modifier = if (scrollable) {
                Modifier.horizontalScroll(scrollState).requiredWidth(tableWidth)
            } else Modifier.fillMaxWidth()
        ) {
            node.children.forEach {
                when (it.type) {
                    HEADER -> {
                        headerBlock(content, it, tableWidth, style)
                    }
                    ROW -> {

                        rowBlock(content, it, tableWidth, style)
                        if (it.endOffset < node.endOffset){
                            MarkdownDivider()
                        }
                    }
                    TABLE_SEPARATOR -> {
                    }
                }
            }
        }
    }
}

@Composable
fun ScrollableMarkdownTableHeader(
    content: String,
    header: ASTNode,
    tableWidth: Dp,
    style: TextStyle,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    annotatorSettings: AnnotatorSettings = annotatorSettings(),
) {
    val markdownComponents = LocalMarkdownComponents.current
    val tableCellPadding = LocalMarkdownDimens.current.tableCellPadding
    Row(
        verticalAlignment = verticalAlignment, modifier = Modifier.widthIn(tableWidth).height(IntrinsicSize.Max).background(
            KoreTheme.colorScheme.surface,
            shape = KoreTheme.shapes.md
        )
    ) {
        val cells = header.children.filter { it.type == CELL }
        cells.forEachIndexed { index, cell ->
            Column(
                modifier = Modifier.padding(tableCellPadding).weight(1f),
            ) {
                if (cell.children.any { it.type == IMAGE }) {
                    MarkdownElement(node = cell, components = markdownComponents, content = content, includeSpacer = false)
                } else {
                    MarkdownTableBasicText(
                        content = content,
                        cell = cell,
                        style = style.copy(fontWeight = FontWeight.Bold),
                        maxLines = Int.MAX_VALUE,
                        overflow = TextOverflow.Clip,
                        annotatorSettings = annotatorSettings
                    )
                }
            }

        }

    }
}

@Composable
fun ScrollableMarkdownTableRow(
    content: String,
    header: ASTNode,
    tableWidth: Dp,
    style: TextStyle,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    annotatorSettings: AnnotatorSettings = annotatorSettings(),
) {
    val markdownComponents = LocalMarkdownComponents.current
    val tableCellPadding = LocalMarkdownDimens.current.tableCellPadding
    Row(
        verticalAlignment = verticalAlignment, modifier = Modifier.widthIn(tableWidth).height(IntrinsicSize.Max).padding(
            vertical = 2.dp
        )
    ) {
        val cells = header.children.filter { it.type == CELL }
        cells.forEachIndexed { index, cell ->
            Column(
                modifier = Modifier.padding(tableCellPadding).weight(1f),
            ) {
                if (cell.children.any { it.type == IMAGE }) {
                    MarkdownElement(node = cell, components = markdownComponents, content = content, includeSpacer = false)

                } else {

                    MarkdownTableBasicText(
                        content = content,
                        cell = cell,
                        style = style,
                        maxLines = Int.MAX_VALUE,
                        overflow = TextOverflow.Clip,
                        annotatorSettings = annotatorSettings
                    )

                }
            }
            if (index < cells.lastIndex) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .background(KoreTheme.colorScheme.onSurface.copy(alpha = 0.2f))
                )
            }
        }
    }
}

@Composable
fun DefaultMarkdownHeader(
    content: String,
    node: ASTNode,
    style: TextStyle,
    contentChildType: IElementType = MarkdownTokenTypes.ATX_CONTENT,
) {
    SelectionContainer {
        MarkdownText(
            modifier = Modifier
                .padding(
                    vertical = 4.dp
                )
                .semantics {
                    heading()
                },
            content = content,
            node = node,
            style = style,
            contentChildType = contentChildType,
        )
    }
}




@Composable
fun DefaultMarkdownBlockQuote(
    content: String,
    node: ASTNode,
    style: TextStyle = LocalMarkdownTypography.current.quote,
) {
    val blockQuoteColor = if (style.color.isSpecified) {
        style.color
    } else {
        LocalMarkdownColors.current.text
    }
    val blockQuoteThickness = LocalMarkdownDimens.current.blockQuoteThickness
    val blockQuote = LocalMarkdownPadding.current.blockQuote
    val blockQuoteText = LocalMarkdownPadding.current.blockQuoteText
    val blockQuoteBar = LocalMarkdownPadding.current.blockQuoteBar
    val markdownComponents = LocalMarkdownComponents.current

    Column(
        modifier = Modifier
            .drawBehind {
                drawLine(
                    color = blockQuoteColor,
                    strokeWidth = blockQuoteThickness.toPx(),
                    start = Offset(blockQuoteBar.calculateStartPadding(LayoutDirection.Ltr).toPx(), blockQuoteBar.calculateTopPadding().toPx()),
                    end = Offset(blockQuoteBar.calculateStartPadding(LayoutDirection.Ltr).toPx(), size.height - blockQuoteBar.calculateBottomPadding().toPx())
                )
            }
            .padding(blockQuote)
    ) {
        val blockQuoteLineHeightInDp = with(LocalDensity.current) { LocalMarkdownTypography.current.quote.fontSize.toDp() }
        var priorNestedQuote = false
        node.children.onEachIndexed { index, child ->
            if (child.type == MarkdownElementTypes.BLOCK_QUOTE) {
                // if block quote is nested, and comes after non block quote, add padding
                if (!priorNestedQuote && index != 0) Spacer(Modifier.height(blockQuoteText.calculateBottomPadding()))
                DefaultMarkdownBlockQuote(content = content, node = child, style = style)
                priorNestedQuote = true
            } else if (child.type == EOL) {
                Spacer(Modifier.height(blockQuoteLineHeightInDp))
            } else {
                // if first item either completely, or after a nested quote, add top padding
                if (index == 0 || priorNestedQuote) Spacer(Modifier.height(blockQuoteText.calculateTopPadding()))
                priorNestedQuote = false
                MarkdownElement(
                    node = child,
                    components = markdownComponents,
                    content = content,
                    includeSpacer = false
                )
                // if last item, add bottom padding
                if (index == node.children.lastIndex) Spacer(Modifier.height(blockQuoteText.calculateBottomPadding()))
            }
        }
    }
}