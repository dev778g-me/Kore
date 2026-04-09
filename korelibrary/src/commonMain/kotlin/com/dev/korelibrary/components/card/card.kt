package com.dev.korelibrary.components.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.themes.LocalContentColor



@Composable
fun Card(
    modifier: Modifier = Modifier,
    shape: Shape = CardDefaults.defaultCardShape,
    colors: CardColors = CardDefaults.defaultCardColors(),
    contentPaddingValues: PaddingValues = CardDefaults.defaultCardContentPaddingValues,
    content: @Composable ColumnScope. () -> Unit
) {
    BaseCard(
        modifier = modifier,
        shape = shape,
        colors = colors,
        contentPaddingValues = contentPaddingValues
    ) {
        content()
    }
}


@Composable
fun OutlinedCard(
    modifier: Modifier = Modifier,
    shape: Shape = CardDefaults.defaultCardShape,
    colors: CardColors = CardDefaults.defaultOutlinedCardColors(),
    borderStroke: BorderStroke = CardDefaults.defaultOutlinedBorderStroke,
    contentPaddingValues: PaddingValues = CardDefaults.defaultCardContentPaddingValues,
    content: @Composable ColumnScope. () -> Unit
) {
    BaseCard(
        modifier = modifier,
        shape = shape,
        colors = colors,
        borderStroke = borderStroke,
        contentPaddingValues = contentPaddingValues
    ) {
        content()
    }
}


@Composable
fun BaseCard(
    modifier: Modifier = Modifier,
    shape: Shape,
    colors: CardColors,
    borderStroke: BorderStroke? = null,
    contentPaddingValues: PaddingValues,
    content: @Composable ColumnScope. () -> Unit
) {
    Box(
        modifier = modifier
            .background(
                color = colors.containerColor,
                shape = shape
            )
            .clip(shape = shape)
            .then(if (borderStroke != null) Modifier.border(borderStroke, shape) else Modifier)
            .padding(
                contentPaddingValues
            )
    ) {
        CompositionLocalProvider(
            value = LocalContentColor provides colors.contentColor
        ) {
            Column(content = content)
        }
    }
}


object CardDefaults {

    val defaultCardShape: Shape
        @Composable get() = KoreTheme.shapes.medium

    val defaultCardContentPaddingValues: PaddingValues
        @Composable get() = PaddingValues(KoreTheme.sizes.medium)


    val defaultOutlinedBorderStroke: BorderStroke
        @Composable get() = BorderStroke(
            width = 2.dp,
            color = KoreTheme.colorScheme.backGroundVariant,
        )

    @Composable
    fun defaultCardColors(
        containerColor: Color = KoreTheme.colorScheme.surface,
        contentColor: Color = KoreTheme.colorScheme.onSurface
    ) = CardColors(
        containerColor = containerColor,
        contentColor = contentColor
    )


    @Composable
    fun defaultOutlinedCardColors(
        containerColor: Color = KoreTheme.colorScheme.background,
        contentColor: Color = KoreTheme.colorScheme.onBackGround
    ) = CardColors(
        containerColor = containerColor,
        contentColor = contentColor
    )

}


@Immutable
data class CardColors(
    val containerColor: Color,
    val contentColor: Color
)