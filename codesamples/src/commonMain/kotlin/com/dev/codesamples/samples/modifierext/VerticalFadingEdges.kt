package com.dev.codesamples.samples.modifierext

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.listtile.ListTile
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.modifiers.verticalFadingEdges
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Plus

// <sample id="modifierext-vertical-fading-edges">
@Composable
fun VerticalFadingEdgesSample() {
    LazyColumn(
        modifier = Modifier.height(400.dp)
            .verticalFadingEdges(0.1f)
    ) {
        items(30) {
            ListTile(
                modifier = Modifier.padding(vertical = 2.dp),
                leading = {
                    Icon(
                        tint = KoreTheme.colorScheme.primary,
                        imageVector = PhIcons.Regular.Plus,
                        contentDescription = null
                    )
                },
                title = { Text("Scroll me") }
            )
        }
    }
}
// <sample/>
