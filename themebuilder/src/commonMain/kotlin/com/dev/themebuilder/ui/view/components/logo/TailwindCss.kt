package com.dev.themebuilder.ui.view.components.logo

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val TailwindCss: ImageVector
    get() {
        if (_TailwindCss != null) {
            return _TailwindCss!!
        }
        _TailwindCss = ImageVector.Builder(
            name = "TailwindCss",
            defaultWidth = 128.dp,
            defaultHeight = 128.dp,
            viewportWidth = 128f,
            viewportHeight = 128f
        ).apply {
            path(fill = SolidColor(Color(0xFF38BDF8))) {
                moveTo(64f, 25.6f)
                curveToRelative(-17.07f, 0f, -27.73f, 8.53f, -32f, 25.6f)
                curveToRelative(6.4f, -8.53f, 13.87f, -11.73f, 22.4f, -9.6f)
                curveToRelative(4.87f, 1.21f, 8.35f, 4.75f, 12.21f, 8.66f)
                curveTo(72.88f, 56.63f, 80.14f, 64f, 96f, 64f)
                curveToRelative(17.07f, 0f, 27.73f, -8.53f, 32f, -25.6f)
                curveToRelative(-6.4f, 8.54f, -13.87f, 11.73f, -22.4f, 9.6f)
                curveToRelative(-4.87f, -1.22f, -8.35f, -4.75f, -12.21f, -8.66f)
                curveToRelative(-6.27f, -6.37f, -13.53f, -13.74f, -29.39f, -13.74f)
                close()
                moveTo(32f, 64f)
                curveToRelative(-17.07f, 0f, -27.73f, 8.53f, -32f, 25.6f)
                curveTo(6.4f, 81.07f, 13.87f, 77.87f, 22.4f, 80f)
                curveToRelative(4.87f, 1.22f, 8.35f, 4.75f, 12.21f, 8.66f)
                curveToRelative(6.27f, 6.37f, 13.54f, 13.74f, 29.4f, 13.74f)
                curveToRelative(17.07f, 0f, 27.73f, -8.53f, 32f, -25.6f)
                curveToRelative(-6.4f, 8.53f, -13.87f, 11.73f, -22.4f, 9.6f)
                curveToRelative(-4.87f, -1.21f, -8.35f, -4.75f, -12.21f, -8.66f)
                curveTo(55.13f, 71.37f, 47.87f, 64f, 32f, 64f)
                close()
                moveTo(32f, 64f)
            }
        }.build()

        return _TailwindCss!!
    }

@Suppress("ObjectPropertyName")
private var _TailwindCss: ImageVector? = null
