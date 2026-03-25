package com.dev.korelibrary.themes.typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import kore.korelibrary.generated.resources.Res
import kore.korelibrary.generated.resources.google_sans_flex
import kore.korelibrary.generated.resources.google_sans_flex_black
import kore.korelibrary.generated.resources.google_sans_flex_bold
import kore.korelibrary.generated.resources.google_sans_flex_extra_bold
import kore.korelibrary.generated.resources.google_sans_flex_extra_light
import kore.korelibrary.generated.resources.google_sans_flex_light
import kore.korelibrary.generated.resources.google_sans_flex_medium
import kore.korelibrary.generated.resources.google_sans_flex_semibold
import kore.korelibrary.generated.resources.google_sans_flex_thin
import org.jetbrains.compose.resources.Font

@Composable
fun  googleSansFlex() = FontFamily(
    fonts = listOf(
        Font(resource = Res.font.google_sans_flex_thin, FontWeight.Thin),
        Font(resource = Res.font. google_sans_flex_extra_light, FontWeight.ExtraLight),
        Font(resource = Res.font.google_sans_flex_light, FontWeight.Light),
        Font(resource = Res.font.google_sans_flex, FontWeight.Normal),
        Font(resource = Res.font.google_sans_flex_medium, FontWeight.Medium),
        Font(resource = Res.font.google_sans_flex_semibold, FontWeight.SemiBold),
        Font(resource = Res.font.google_sans_flex_bold, FontWeight.Bold),
        Font(resource = Res.font.google_sans_flex_extra_bold, FontWeight.ExtraBold),
        Font(Res.font.google_sans_flex_black, FontWeight.Black),
    )
)

