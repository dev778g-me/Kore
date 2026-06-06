package com.dev.kore.themes.colors

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.graphics.toArgb


/**
 * Blends this color toward [blendColor].
 *
 * @param blendColor The target color to blend into.
 * @param blendValue Blend amount in the range `0f..1f`.
 * - `0f` returns this color.
 * - `1f` returns [blendColor].
 */
fun Color.blend(
    blendColor: Color,
    blendValue: Float = 0.85f
): Color = lerp(
    start = this,
    stop = blendColor,
    fraction = blendValue
)

fun Color.toHexString(): String {
    return "0x" + toArgb()
        .toUInt()
        .toString(16)
        .uppercase()
        .padStart(8, '0')
}