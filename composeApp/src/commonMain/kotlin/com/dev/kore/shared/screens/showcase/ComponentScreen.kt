package com.dev.kore.shared.screens.showcase

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.appbar.Appbar
import com.dev.kore.components.buttons.OutlinedIconButton
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.scaffold.Scaffold
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.ComponentEntry
import com.dev.kore.themes.KoreTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.CaretLeft

/**
 * The generic screen rendering every implementation of a single component.
 */
@Composable
fun ComponentScreen(
    entry: ComponentEntry,
    onBack: () -> Unit,
) {
    Scaffold(
        appBar = {
            Appbar(
                title = {
                    Text(entry.title, textStyle = KoreTheme.typography.heading3)
                },
                navigationIcon = {
                    OutlinedIconButton(onClick = onBack) {
                        Icon(
                            imageVector = PhIcons.Regular.CaretLeft,
                            contentDescription = "Back",
                        )
                    }
                },
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Text(
                text = entry.description,
                textStyle = KoreTheme.typography.body2,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
            entry.demo()
        }
    }
}
