package com.dev.kore.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.card.CardDefaults
import com.dev.korelibrary.components.card.OutlinedCard
import com.dev.korelibrary.components.scaffold.Scaffold
import com.dev.korelibrary.themes.KoreTheme

@Composable
fun ColorScreen() {
    Scaffold {

       val colorMap : Map<String, Color> = mapOf(
           "primary" to KoreTheme.colorScheme.primary,
           "onPrimary" to KoreTheme.colorScheme.onPrimary,
           "primaryContainer" to KoreTheme.colorScheme.primaryContainer,
           "onPrimaryContainer" to KoreTheme.colorScheme.onPrimaryContainer,
           "secondary" to KoreTheme.colorScheme.complementary,
           "onSecondary" to KoreTheme.colorScheme.onComplementary,
           "background" to KoreTheme.colorScheme.background,
           "onBackground" to KoreTheme.colorScheme.onBackGround,
           "backgroundVariant" to KoreTheme.colorScheme.backGroundVariant,
           "onbackgroundVariant" to KoreTheme.colorScheme.onBackGroundVariant,
           "surface" to KoreTheme.colorScheme.surface,
           "onSurface" to KoreTheme.colorScheme.onSurface
       )





       Column(
           modifier = Modifier.fillMaxSize().padding(it)
               .padding(
                   horizontal =     16.dp
               )
       ) {
           FlowRow(
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.spacedBy(8.dp),
               verticalArrangement = Arrangement.spacedBy(8.dp),
           ) {
               colorMap.forEach {
                   ColorBox(
                       color = it.value
                   )
               }
           }

       }
    }


}



@Composable
fun ColorBox(
    color: Color
){
    OutlinedCard(
        modifier = Modifier.size(72.dp),
        colors = CardDefaults.defaultCardColors(
            containerColor = color
        )
    ){}
}