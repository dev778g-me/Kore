package com.dev.themebuilder.ui.showcase

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.card.Card
import com.dev.korelibrary.components.card.CardDefaults
import com.dev.korelibrary.components.listtile.ListTile
import com.dev.korelibrary.components.slider.Slider
import com.dev.korelibrary.components.text.Text
import com.dev.korelibrary.themes.KoreTheme
import kore.themebuilder.generated.resources.Res
import kore.themebuilder.generated.resources.far
import org.jetbrains.compose.resources.painterResource

@Composable
fun MusicUiShowcase(
    modifier: Modifier = Modifier
){

    var sliderState by rememberSaveable(){mutableStateOf(40f)}
    Card(
        modifier = modifier,
        colors = CardDefaults.defaultCardColors(
            containerColor = KoreTheme.colorScheme.surface
        )
    ) {

        Image(
            modifier = Modifier.clip(
                shape = KoreTheme.shapes.sm
            ),
            painter = painterResource(
                resource = Res.drawable.far,
            ),
            contentDescription = ""
        )

        ListTile(
            contentPaddingValues = PaddingValues(horizontal = 8.dp, vertical = 12.dp),
            title = {
                Text(
                    "Far Horizons"
                )
            },
            subtitle = {
                Text(
                    text = "Jourme Soule"
                )
            }
        )

        Slider(
            value = sliderState,
            onValueChange = {
                sliderState = it
            }
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )



    }

}