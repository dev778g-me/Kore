package com.dev.kore

import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.appbar.Appbar
import com.dev.korelibrary.components.icon.Icon
import com.dev.korelibrary.components.listItem.ListTile
import com.dev.korelibrary.components.listItem.ListTileDefaults
import com.dev.korelibrary.src.Components.CheakBox.CheckBox
import com.dev.korelibrary.src.Components.Scaffold.Scaffold
import com.dev.korelibrary.src.Components.Stack.VerticalStack
import com.dev.korelibrary.src.Components.Text
import com.dev.korelibrary.themes.AppTheme
import com.dev.korelibrary.themes.KoreTheme
import icons.PhIcons
import icons.bold.CaretLeftBold
import icons.filled.GitlabLogoFill

@Composable
@Preview
fun App() {
    var selectedIndexedValue by remember { mutableStateOf(0) }
    var check by remember { mutableStateOf(false) }
    val dragState = rememberDraggableState(onDelta = {})
    var currentOffset by remember { mutableStateOf(0f) }
    var textEmail by remember { mutableStateOf("") }
    var showAccord by remember { mutableStateOf(false) }

    var slideState by remember { mutableStateOf(30f) }

    AppTheme {

        Scaffold(
            appBar = {
                Appbar(
                    navigationIcon = {
                        Icon(
                            imageVector = PhIcons.Bold.CaretLeftBold,
                            contentDescription = ""
                        )
                    },
                    title = {
                        Text("Hello")
                    }
                )
            }
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(it)
                    .padding(
                        horizontal = 16.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                VerticalStack {
                    ListTile(
                       overline = {
                           Text("Overline")
                       },
                        subtitle = {
                            Text("Subtitle")
                        },
                        leading = {
                            CheckBox(
                                checked = check,
                                onCheckChange = {
                                    check = it
                                }
                            )
                        },
                        title = {
                            Text("Hello World")
                        }
                    )
                }
            }
        }
    }}

