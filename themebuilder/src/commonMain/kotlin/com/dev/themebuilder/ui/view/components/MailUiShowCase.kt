package com.dev.themebuilder.ui.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.card.Card
import com.dev.korelibrary.components.listItem.ListTile
import com.dev.korelibrary.components.separators.HorizontalSeparator
import com.dev.korelibrary.components.badge.PrimaryBadge
import com.dev.korelibrary.components.text.Text

@Composable
fun MailUiShowcase(
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Messages")

            PrimaryBadge(
                content = {
                    Text("36")
                }
            )
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )
        ListTile(
            contentPaddingValues = PaddingValues(
                horizontal = 0.dp, vertical = 12.dp

            ),
            shape = RectangleShape,
            overline = {
                Text("3:46 PM")
            },
            title = {
                Text("Justin Stewart")
            },
            subtitle = {
                Text("And than he told that it was the worst product ....")
            },
            trailing = {
                PrimaryBadge(
                    content = {
                        Text("4")
                    }
                )
            },

        )
        HorizontalSeparator()
        ListTile(
            contentPaddingValues = PaddingValues(
                horizontal = 0.dp,
                vertical = 12.dp
            ),
            shape = RectangleShape,
            overline = {
                Text("11:40 AM")
            },
            title = {
                Text("(523) 709-301")
            },
            subtitle = {
                Text("You have new test result to view in your acc..")
            },
            trailing = {
                PrimaryBadge(
                    content = {
                        Text("9")
                    }
                )
            },
        )
    }
}