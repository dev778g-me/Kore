package com.dev.korelibrary.components.separators
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.themes.KoreTheme

@Composable
fun HorizontalSeparator(
    modifier: Modifier = Modifier,
    thickness : Dp= SeparatorDefaults.defaultSeparatorThickness,
    separatorCap: StrokeCap = SeparatorDefaults.defaultSeparatorCap,
    color : Color= KoreTheme.colorScheme.backGroundVariant
) {
    val density = LocalDensity.current
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(thickness)
    ){
        drawLine(
            cap = separatorCap,
            color = color,
            strokeWidth = with(density) {
                thickness.toPx()
            },
            start = Offset(x = 0f, y = thickness.toPx()/2),
            end = Offset(x = size.width, y = thickness.toPx()/2)
        )
    }
}

// gradient
@Composable
fun HorizontalGradientSeparator(
    modifier: Modifier = Modifier,
    thickness : Dp= SeparatorDefaults.defaultSeparatorThickness,
    separatorCap: StrokeCap = SeparatorDefaults.defaultSeparatorCap,
    brush: Brush= SeparatorDefaults.defaultBrush,
) {
    val density = LocalDensity.current
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(thickness)
    ){
        drawLine(
            cap = separatorCap,
            brush = brush,
            strokeWidth = with(density) {
                thickness.toPx()
            },
            start = Offset(x = 0f, y = thickness.toPx()/2),
            end = Offset(x = size.width, y = thickness.toPx()/2)
        )
    }
}


@Composable
fun VerticalSeparator(
    modifier: Modifier = Modifier,
    thickness: Dp = SeparatorDefaults.defaultSeparatorThickness,
    separatorCap: StrokeCap = SeparatorDefaults.defaultSeparatorCap,
    color: Color = KoreTheme.colorScheme.backGroundVariant
) {
    Canvas(modifier = modifier.fillMaxHeight().width(thickness)) {
        drawLine(
            cap = separatorCap,
            color = color,
            strokeWidth = thickness.toPx(),
            start = Offset(x = thickness.toPx()/2, y = 0f),
            end = Offset(x = thickness.toPx()/2, y =size.height)
        )
    }
}

// gradient Variant
@Composable
fun VerticalGradientSeparator(
    modifier: Modifier = Modifier,
    thickness: Dp = SeparatorDefaults.defaultSeparatorThickness,
    separatorCap: StrokeCap = SeparatorDefaults.defaultSeparatorCap,
    brush: Brush= SeparatorDefaults.defaultBrush,
) {
    Canvas(modifier = modifier.fillMaxHeight().width(thickness)) {
        drawLine(
            cap = separatorCap,
            brush = brush,
            strokeWidth = thickness.toPx(),
            start = Offset(x = thickness.toPx()/2, y = 0f),
            end = Offset(x = thickness.toPx()/2, y =size.height)
        )
    }
}





object SeparatorDefaults{
    val defaultSeparatorThickness = 1.dp

    val defaultSeparatorCap : StrokeCap = StrokeCap.Round

    @Composable
    fun defaultSeparatorColor(
        separatorColor: Color = KoreTheme.colorScheme.backGroundVariant
    ) = SeparatorColors(
        separatorColor = separatorColor
    )


    val defaultBrush: Brush = Brush.linearGradient(
        colors = listOf(Color.Red, Color.Blue)
    )


}

data class SeparatorColors(
    val separatorColor: Color
)