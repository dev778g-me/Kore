package com.dev.kore.themes.typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import koreproject.kore.generated.resources.Res
import koreproject.kore.generated.resources.google_sans_flex
import koreproject.kore.generated.resources.google_sans_flex_black
import koreproject.kore.generated.resources.google_sans_flex_bold
import koreproject.kore.generated.resources.google_sans_flex_extra_bold
import koreproject.kore.generated.resources.google_sans_flex_extra_light
import koreproject.kore.generated.resources.google_sans_flex_light
import koreproject.kore.generated.resources.google_sans_flex_medium
import koreproject.kore.generated.resources.google_sans_flex_semibold
import koreproject.kore.generated.resources.google_sans_flex_thin
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



