package com.dev.themebuilder.ui.showcase

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.card.Card
import com.dev.korelibrary.components.checkbox.CheckBox
import com.dev.korelibrary.components.listtile.ListTile
import com.dev.korelibrary.components.separators.HorizontalSeparator
import com.dev.korelibrary.components.stack.VerticalStack
import com.dev.korelibrary.components.text.Text
import com.dev.korelibrary.components.textFields.OutlinedTextField
import com.dev.korelibrary.themes.KoreTheme

@Composable
fun MemberUiShowCase(
    modifier: Modifier = Modifier
){

    var tag by rememberSaveable(){
        mutableStateOf("")
    }

    var displayChecked by rememberSaveable {mutableStateOf(false)}
    var disableComments by rememberSaveable {mutableStateOf(false)}


    Card {
        VerticalStack(
            horizontalAlignment = Alignment.Start
        ) {
        Text("Add Tags ", textStyle = KoreTheme.typography.label2)

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = tag,
            onValueChange = {
                tag = it
            }
        )

        Text("Member with access")

        ListTile(
            contentPaddingValues = PaddingValues(
                vertical = 8.dp, horizontal = 0.dp
            ),
            leading = {
                CheckBox(
                    checked = displayChecked,
                    onCheckChange = {
                        displayChecked = it
                    }
                )
            },
            title = {
                Text("Display on profile")
            }
        )

        ListTile(
            contentPaddingValues = PaddingValues(
                vertical = 8.dp, horizontal = 0.dp
            ),
            leading = {
                CheckBox(
                    checked = disableComments,
                    onCheckChange = {
                        disableComments = it
                    }
                )
            },
            title = {
                Text("Display on profile")
            }
        )


        HorizontalSeparator()
        ListTile(
            contentPaddingValues = PaddingValues(
                vertical = 8.dp, horizontal = 0.dp
            ),
            title = {
                Text("Add to portfolio")
            },
            subtitle = {
                Text("Choose a portfolio to add your work.")
            }
        )

        HorizontalSeparator()
        ListTile(
            contentPaddingValues = PaddingValues(
                vertical = 8.dp, horizontal = 0.dp
            ),
            title = {
                Text("Add Download File")
            },
            subtitle = {
                Text("Share your file & allow downloads.")
            }
        )
    }}
}