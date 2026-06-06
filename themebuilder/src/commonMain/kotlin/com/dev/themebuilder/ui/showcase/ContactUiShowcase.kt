package com.dev.themebuilder.ui.showcase

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.OutlinedIconButton
import com.dev.kore.components.buttons.SecondaryIconButton
import com.dev.kore.components.card.Card
import com.dev.kore.components.listtile.ListTile
import com.dev.kore.components.listtile.ListTileDefaults
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.extensions.color
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.MapPin
import com.phosphor.icons.regular.NavigationArrow
import com.phosphor.icons.regular.Plus
import com.phosphor.icons.regular.Toolbox
import com.phosphor.icons.regular.User

@Composable
fun ContactUiShowcase(
    modifier: Modifier = Modifier,
){
    Card {
        VerticalStack {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Contact information", textStyle = KoreTheme.typography.label2.color(KoreTheme.colorScheme.onBackGround))
                Text("View Profile")
            }

            Spacer(modifier = Modifier.height(4.dp))

            ListTile(
                modifier = Modifier.border(
                    width = 2.dp,
                    color = KoreTheme.colorScheme.backGroundVariant,
                    shape = ListTileDefaults.defaultListTileShape
                ),

                leading = {
                    com.dev.kore.components.icon.Icon(
                        imageVector = PhIcons.Regular.User,
                        contentDescription = "user"
                    )
                },
                trailing = {
                    SecondaryIconButton(
                        onClick = {},
                        content = {
                            com.dev.kore.components.icon.Icon(
                                imageVector = PhIcons.Regular.Plus,
                                contentDescription = "user"
                            )
                        }
                    )
                },
                title = {
                    Text("Lena Muller")
                },
                subtitle = {
                    Text("Marketing Manager")
                }
            )

            ListTile(

                leading = {

                        com.dev.kore.components.icon.Icon(
                            imageVector = PhIcons.Regular.MapPin,
                            contentDescription = "user"
                        )

                },
                overline = {
                    Text("Location")
                },
                title = {
                    Text("Berlin,Germany", textStyle = KoreTheme.typography.title3)
                }
            )
            ListTile(

                leading = {

                        com.dev.kore.components.icon.Icon(
                            imageVector = PhIcons.Regular.Toolbox,
                            contentDescription = "user"
                        )

                },
                overline = {
                    Text("Speciality")
                },
                title = {
                    Text("Marketing,SEO,Team Leader",textStyle = KoreTheme.typography.title3)
                }
            )
            ListTile(

                leading = {

                        com.dev.kore.components.icon.Icon(
                            imageVector = PhIcons.Regular.NavigationArrow,
                            contentDescription = "user"
                        )

                },
                overline = {
                    Text("Email Address")
                },
                title = {
                    Text("Berlin,Germany",textStyle = KoreTheme.typography.title3)
                }
            )
        }
    }
}