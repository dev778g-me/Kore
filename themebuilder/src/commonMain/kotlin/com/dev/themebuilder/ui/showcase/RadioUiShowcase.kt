package com.dev.themebuilder.ui.showcase

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.buttons.SecondaryIconButton
import com.dev.korelibrary.components.card.Card
import com.dev.korelibrary.components.card.CardDefaults
import com.dev.korelibrary.components.icon.Icon
import com.dev.korelibrary.components.listtile.ListTile
import com.dev.korelibrary.components.radio.RadioButton
import com.dev.korelibrary.components.text.Text
import com.dev.korelibrary.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.bold.GlobeBold
import com.phosphor.icons.bold.LockBold

@Composable
fun RadioUiShowcase(
    modifier: Modifier = Modifier
){

    var selectedRadio by rememberSaveable(){ mutableStateOf(0) }

    Card(
        colors = CardDefaults.defaultCardColors(
            containerColor = KoreTheme.colorScheme.surface
        )
    ){

        Text(
           text =  "Access",
            textStyle = KoreTheme.typography.title2,
            color = KoreTheme.colorScheme.onBackGround
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        ListTile(
            contentPaddingValues = PaddingValues(horizontal = 0.dp, vertical = 12.dp),
            modifier = Modifier.fillMaxWidth(),
            leading = {
                SecondaryIconButton(
                    onClick = {}
                ){
                    Icon(
                        imageVector = PhIcons.Bold.LockBold,
                        contentDescription = ""
                    )
                }
            },
            title = {
                Text("Private")
            },
            subtitle = {
                Text("Only users you choose can sign-in")
            },
            trailing = {
                RadioButton(
                    selected = selectedRadio == 0,
                    onClick = {
                        selectedRadio = 0
                    }
                )
            }
        )

        ListTile(
            contentPaddingValues = PaddingValues(horizontal = 0.dp, vertical = 12.dp),
            leading = {
                SecondaryIconButton(
                    onClick = {}
                ){
                    Icon(
                        imageVector = PhIcons.Bold.GlobeBold,
                        contentDescription = ""
                    )
                }
            },
            title = {
                Text("Public")
            },
            subtitle = {
                Text("Anyone with the link can access")
            },
            trailing = {
                RadioButton(
                    selected    = selectedRadio == 1,
                    onClick = {
                        selectedRadio = 1
                    }
                )
            }
        )
    }
}