package com.dev.themebuilder.ui.showcase

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.card.Card
import com.dev.kore.components.listtile.ListTile
import com.dev.kore.components.loadingIndicator.CircularLoadingIndicator
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.modifiers.shimmer

@Composable
fun LoadingUiShowcase(
    modifier: Modifier = Modifier
){
    Card (

    ) {


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .shimmer()
            )


            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(20.dp)
                        .clip(KoreTheme.shapes.xs).shimmer()
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .height(14.dp)
                        .clip(KoreTheme.shapes.xs).shimmer()
                )
            }
        }



        ListTile(
            contentPaddingValues = PaddingValues(
                vertical = 12.dp,
                horizontal = 0.dp
            ),
            title = {
                Text(
                    text = "Syncing Cloud Data",)
            },
            subtitle = {
                Text(
                    text = "Please wait while we update your files...",)
            },
            trailing = {
                CircularLoadingIndicator(
                    modifier = Modifier.size(20.dp),
                    thickness = 2.dp
                )
            }
        )




        Spacer(modifier = Modifier.weight(1f))

        PrimaryButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth(),
            enabled = false,

        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularLoadingIndicator(
                    modifier = Modifier.size(20.dp),
                    thickness = 2.dp
                )
                Text("Saving Preferences...")
            }
        }
    }
}