package com.dev.themebuilder.ui.view.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AllShowCase(
    modifier: Modifier = Modifier
){
    ShowCase {
        item {
            ColorsShowCase()
        }
        item { TypographyShowcase() }
        item {
            LoginUiShowcase()
        }

        item {
            FlightUIShowCase()
        }
        item {
            MusicUiShowcase()
        }
        item {
            RadioUiShowcase()
        }
        item {
            TodoUiShowcase()
        }
        item {
            MailUiShowcase()
        }
        item {
            SwitchShowCase()
        }
        item {
            AccordionShowcase()
        }

        item { LoadingUiShowcase() }

        item { FileUploadUiShowcase() }

    }
}