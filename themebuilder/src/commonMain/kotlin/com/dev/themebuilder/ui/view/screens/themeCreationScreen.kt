package com.dev.themebuilder.ui.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.dev.kore.components.card.Card
import com.dev.themebuilder.ui.showcase.AllShowCase
import com.dev.themebuilder.ui.view.components.CustomizeColumn
import com.dev.themebuilder.ui.view.components.PhoneScreen
import com.dev.themebuilder.ui.viewmodel.ThemeViewModel

@Composable
fun ThemeCreationScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    viewModel: ThemeViewModel,
    isDark: Boolean,
) {
    val currentWindowSizeClass =
        currentWindowAdaptiveInfo(supportLargeAndXLargeWidth = true).windowSizeClass


    Column(
        modifier = modifier.fillMaxSize()
            .padding(
                all = 16.dp
            )
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxHeight(),
            ) {
                CustomizeColumn( viewModel = viewModel)
            }

            val windowWidthDp = with(LocalDensity.current) {
                LocalWindowInfo.current.containerSize.width.toDp()
            }

            if (windowWidthDp >= 1200.dp) {
                PhoneScreen()
            } else {
                AllShowCase()
            }


        }

    }
}
