package com.dev.themebuilder.ui.view.components.logo

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RadixLogo: ImageVector
    get() {
        if (_RadixLogo != null) {
            return _RadixLogo!!
        }
        _RadixLogo = ImageVector.Builder(
            name = "RadixLogo",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(11.6f, 22f)
                curveToRelative(-3.53f, 0f, -6.4f, -2.87f, -6.4f, -6.4f)
                reflectiveCurveToRelative(2.87f, -6.4f, 6.4f, -6.4f)
                close()
                moveTo(11.6f, 2f)
                lineTo(5.2f, 2f)
                verticalLineToRelative(6.4f)
                horizontalLineToRelative(6.4f)
                close()
                moveTo(15.6f, 8.4f)
                curveToRelative(1.77f, 0f, 3.2f, -1.43f, 3.2f, -3.2f)
                reflectiveCurveTo(17.37f, 2f, 15.6f, 2f)
                reflectiveCurveToRelative(-3.2f, 1.43f, -3.2f, 3.2f)
                reflectiveCurveToRelative(1.43f, 3.2f, 3.2f, 3.2f)
            }
        }.build()

        return _RadixLogo!!
    }

@Suppress("ObjectPropertyName")
private var _RadixLogo: ImageVector? = null
