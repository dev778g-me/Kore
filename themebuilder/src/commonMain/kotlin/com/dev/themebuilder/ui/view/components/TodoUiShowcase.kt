package com.dev.themebuilder.ui.view.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.card.Card
import com.dev.korelibrary.components.listItem.ListTile
import com.dev.korelibrary.components.checkbox.CheckBox
import com.dev.korelibrary.components.text.Text

@Composable
fun TodoUiShowcase(
    modifier: Modifier= Modifier
){

    var firstTodo by rememberSaveable(){ mutableStateOf(true) }
    var secondTodo by rememberSaveable(){ mutableStateOf(false) }

    Card() {
        ListTile(
            contentPaddingValues = PaddingValues(horizontal = 0.dp, vertical = 12.dp),
            leading = {
                CheckBox(
                    checked = firstTodo,
                    onCheckChange = {
                        firstTodo = it
                    }
                )
            },
            title = {
                Text("Weekly Sync Meeting")
            },
            subtitle = {
                Text("Discuss sprint velocity and blockers")
            }
        )
        ListTile(
            contentPaddingValues = PaddingValues(horizontal = 0.dp, vertical = 12.dp),
            leading = {
                CheckBox(
                    checked = secondTodo,
                    onCheckChange = {
                        secondTodo = it
                    }
                )
            },
            title = {
                Text("Push to Production")
            },
            subtitle = {
                Text("Release version 2.4.0 to stable branch")
            }
        )
    }
}