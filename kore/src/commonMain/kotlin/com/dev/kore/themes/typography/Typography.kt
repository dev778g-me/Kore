package com.dev.kore.themes.typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import koreproject.kore.generated.resources.Res
import koreproject.kore.generated.resources.jetbrains_mono
import koreproject.kore.generated.resources.outfit
import org.jetbrains.compose.resources.Font

/**
 * The default font family of Kore.
 * contains all weight.
 */
@Composable
fun outfitFontFamily() = FontFamily(
    fonts = listOf(
        Font(resource = Res.font.outfit, FontWeight.Thin),
        Font(resource = Res.font.outfit, FontWeight.ExtraLight),
        Font(resource = Res.font.outfit, FontWeight.Light),
        Font(resource = Res.font.outfit, FontWeight.Normal),
        Font(resource = Res.font.outfit, FontWeight.Medium),
        Font(resource = Res.font.outfit, FontWeight.SemiBold),
        Font(resource = Res.font.outfit, FontWeight.Bold),
        Font(resource = Res.font.outfit, FontWeight.ExtraBold),
        Font(resource = Res.font.outfit, FontWeight.Black),
    )
)


/**
 * The recommended monospace font for kore
 * contains all weights
 */
@Composable
fun monospace() = FontFamily(
    fonts = listOf(
        Font(resource = Res.font.jetbrains_mono, FontWeight.Thin),
        Font(resource = Res.font.jetbrains_mono, FontWeight.ExtraLight),
        Font(resource = Res.font.jetbrains_mono, FontWeight.Light),
        Font(resource = Res.font.jetbrains_mono, FontWeight.Normal),
        Font(resource = Res.font.jetbrains_mono, FontWeight.Medium),
        Font(resource = Res.font.jetbrains_mono, FontWeight.SemiBold),
        Font(resource = Res.font.jetbrains_mono, FontWeight.Bold),
        Font(resource = Res.font.jetbrains_mono, FontWeight.ExtraBold),
        Font(resource = Res.font.jetbrains_mono, FontWeight.Black),
    )
)


