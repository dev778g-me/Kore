package com.dev.codesamples.samples.modifierext

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.SecondaryIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.modifiers.horizontalFadingEdges
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Plus

// <sample id="modifierext-horizontal-fading-edges">
@Composable
fun HorizontalFadingEdgesSample() {
    LazyRow(
        modifier = Modifier
            .horizontalFadingEdges(0.1f)
    ) {
        items(30) {
            SecondaryIconButton(
                modifier = Modifier.padding(horizontal = 8.dp),
                onClick = {}
            ) {
                Icon(
                    tint = KoreTheme.colorScheme.primary,
                    imageVector = PhIcons.Regular.Plus,
                    contentDescription = null
                )
            }
        }
    }
}
// <sample/>
