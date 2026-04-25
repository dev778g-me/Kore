package com.dev.themebuilder.ui.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable

@Composable
fun SmallHomeScreen(
    content : @Composable ColumnScope.() -> Unit
){
    Column {
        content()
    }
}