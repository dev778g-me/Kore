package com.dev.kore.components.card

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.LocalContentColor

/**
 * A container that groups related and action together
 * @param modifier the [Modifier] applied on the Card
 * @param shape the shape of the Card [Shape]
 * @param colors the colors of the Card [CardColors]
 * @param elevation the elevation of the Card [Dp]
 * @param contentAlignment the alignment of the content inside the Card [Alignment]
 * @param contentPaddingValues the padding values of the contents inside the Card [PaddingValues]
 * @param content the content of the Card [Composable] [ColumnScope]

 */

@Composable
fun Card(
    modifier: Modifier = Modifier,
    shape: Shape = CardDefaults.defaultCardShape,
    elevation: Dp = CardDefaults.defaultCardElevation,
    containerColor: Color = CardDefaults.defaultCardContainerColor,
    contentColor : Color = CardDefaults.defaultCardContentColor,
    contentAlignment: Alignment = Alignment.TopStart,
    contentPaddingValues: PaddingValues = CardDefaults.defaultCardContentPaddingValues,
    content: @Composable ColumnScope. () -> Unit
) {
    BaseCard(
        modifier = modifier,
        shape = shape,
        elevation = elevation,
        containerColor = containerColor,
        contentColor = contentColor,
        contentAlignment = contentAlignment,
        contentPaddingValues = contentPaddingValues
    ) {
        content()
    }
}

/**
 * A container with border that groups related contents and action together
 * @param modifier the [Modifier] applied on the OutlinedCard
 * @param shape the shape of the OutlinedCard [Shape]
 * @param elevation the elevation of the OutlinedCard [Dp]
 * @param contentAlignment the alignment of the content inside the Card [Alignment]
 * @param contentPaddingValues the paddingValues of the content inside the OutlinedCard [PaddingValues]
 * @param content the content of the OutlinedCard [Composable] [ColumnScope]
 */
@Composable
fun OutlinedCard(
    modifier: Modifier = Modifier,
    shape: Shape = CardDefaults.defaultCardShape,
    contentColor: Color= CardDefaults.defaultOutlinedContentColor,
    containerColor: Color = CardDefaults.defaultOutlinedContainerColor,
    borderStroke: BorderStroke = CardDefaults.defaultOutlinedBorderStroke,
    elevation: Dp = CardDefaults.defaultCardElevation,
    contentAlignment: Alignment = Alignment.TopStart,
    contentPaddingValues: PaddingValues = CardDefaults.defaultCardContentPaddingValues,
    content: @Composable ColumnScope. () -> Unit
) {
    BaseCard(
        modifier = modifier,
        shape = shape,
        elevation = elevation,
        containerColor = containerColor,
        contentColor = contentColor,
        borderStroke = borderStroke,
        contentAlignment = contentAlignment,
        contentPaddingValues = contentPaddingValues
    ) {
        content()
    }
}


@Composable
internal fun BaseCard(
    modifier: Modifier = Modifier,
    shape: Shape,
    containerColor: Color,
    contentColor: Color,
    borderStroke: BorderStroke? = null,
    elevation: Dp = CardDefaults.defaultCardElevation,
    contentAlignment: Alignment,
    contentPaddingValues: PaddingValues,
    content: @Composable ColumnScope. () -> Unit
) {
    Box(
        modifier = modifier
            .shadow(elevation = elevation, clip = true, shape = shape)
            .clip(shape = shape)
            .background(
                color = containerColor,
                shape = shape
            )
            .then(if (borderStroke != null) Modifier.border(borderStroke, shape) else Modifier)
            .padding(
                contentPaddingValues
            ),
        contentAlignment = contentAlignment
    ) {
        CompositionLocalProvider(
            value = LocalContentColor provides contentColor
        ) {
            Column(content = content)
        }
    }
}


/**
 * CardDefaults is the object that defines the defaultValues for the Card Composable
 * @property defaultCardShape the default shape of the Card [Shape]
 * @property defaultCardContentPaddingValues the default paddingValues of the Card [PaddingValues]
 * @property defaultOutlinedBorderStroke the default borderStroke of the OutlinedCard [BorderStroke]
 * @property defaultCardElevation the default elevation of the Card [Dp]
 * @property defaultCardContainerColor the default container color of the Card [Color]
 * @property defaultCardContentColor the default content color of the Card [Color]
 * @property defaultOutlinedContainerColor the default container of the OutlinedCard [Color]
 * @property defaultOutlinedContentColor the default content color of the OutlinedCard [Color]
 */

object CardDefaults {

    val defaultCardShape: Shape
        @Composable get() = KoreTheme.shapes.md

    val defaultCardContentPaddingValues: PaddingValues
        @Composable get() = PaddingValues(KoreTheme.sizes.md)


    val defaultOutlinedBorderStroke: BorderStroke
        @Composable get() = BorderStroke(
            width = 2.dp,
            color = KoreTheme.colorScheme.backGroundVariant,
        )

    val defaultCardElevation: Dp = 0.dp



    val defaultCardContainerColor
        @Composable get() = KoreTheme.colorScheme.surface

    val defaultCardContentColor
        @Composable get() = KoreTheme.colorScheme.onSurface

    val defaultOutlinedContainerColor
        @Composable get() = KoreTheme.colorScheme.background

    val defaultOutlinedContentColor
        @Composable get() = KoreTheme.colorScheme.onBackGround





}

/**
 * CardColors defines the colors of the Card
 */
@Immutable
data class CardColors(
    val containerColor: Color,
    val contentColor: Color
)