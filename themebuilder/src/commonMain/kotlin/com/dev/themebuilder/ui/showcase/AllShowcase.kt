package com.dev.themebuilder.ui.showcase

import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.themes.KoreTheme

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