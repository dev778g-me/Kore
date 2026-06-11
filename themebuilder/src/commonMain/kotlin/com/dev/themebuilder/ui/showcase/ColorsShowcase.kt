package com.dev.themebuilder.ui.showcase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.kore.components.card.Card
import com.dev.kore.components.card.OutlinedCard
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme

@Composable
fun ColorsShowCase(
    modifier: Modifier = Modifier
){
    Card(){
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            ColorCard(color = KoreTheme.colorScheme.primary, name = "Primary")
            ColorCard(color = KoreTheme.colorScheme.complementary, name = "Complement")
            ColorCard(color = KoreTheme.colorScheme.background, name = "Background")
            ColorCard(color = KoreTheme.colorScheme.surface, name = "Surface")
            ColorCard(color = KoreTheme.colorScheme.success, name = "Success")
            ColorCard(color = KoreTheme.colorScheme.error, name = "Error")
        }
    }
}


@Composable
fun RowScope.ColorCard(
    modifier: Modifier = Modifier,
    color: Color,
    name: String
) {
    Column(
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
    OutlinedCard(
        shape = KoreTheme.shapes.md,
        contentPaddingValues = PaddingValues(0.dp)
    ) {
        Box(
            modifier = modifier.size(60.dp).padding(KoreTheme.sizes.xxs).background(
                color = color,
                shape = KoreTheme.shapes.sm
            )
        )

        }
        Spacer(
            modifier = Modifier.height(2.dp)
        )
        Text(name, textStyle = KoreTheme.typography.label3)
    }
}