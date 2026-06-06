package com.dev.themebuilder.ui.showcase

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.IconButtonDefaults
import com.dev.kore.components.buttons.PrimaryButton
import com.dev.kore.components.buttons.PrimaryIconButton
import com.dev.kore.components.card.Card
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.listtile.ListTile
import com.dev.kore.components.separators.HorizontalSeparator
import com.dev.kore.components.stack.HorizontalStack
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.tabRow.Tab
import com.dev.kore.components.tabRow.TabRow
import com.dev.kore.components.text.Text
import com.dev.kore.components.textFields.OutlinedTextField
import com.dev.kore.themes.KoreTheme
import com.dev.themebuilder.ui.view.navigation.BuilderTabItem
import com.phosphor.icons.PhIcons
import com.phosphor.icons.filled.GithubLogoFill
import com.phosphor.icons.filled.UsersFill
import com.phosphor.icons.regular.Envelope
import com.phosphor.icons.regular.GithubLogo
import com.phosphor.icons.regular.Plus
import com.phosphor.icons.regular.Trash
import com.phosphor.icons.regular.Users

@Composable
fun GithubUIShowcase(
    modifier: Modifier = Modifier
) {
    val tabNavItems = listOf(
        BuilderTabItem(
            onClick = {},
            name = "Team",
            selectedIcon = PhIcons.Filled.UsersFill,
            unSelectedIcon = PhIcons.Regular.Users,
        ),
        BuilderTabItem(
            name = "Github",
            selectedIcon = PhIcons.Filled.GithubLogoFill,
            unSelectedIcon = PhIcons.Regular.GithubLogo,
            onClick = {}
        )

    )
    val githubUsers = rememberSaveable {
        mutableStateListOf(
            "dev@kore.com",
            "krishna@kore.com"
        )
    }
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
    var newMembers by rememberSaveable { mutableStateOf("") }

    Card(

    ) {

        VerticalStack(
            modifier = Modifier.animateContentSize()
        ) {
            ListTile(
                title = {
                    Row {
                        Text(
                            "sanji778g@gmail.com"
                        )
                    }
                },
                subtitle = {
                    Text(
                        text = buildAnnotatedString {
                            append("Startup plan includes")

                            withStyle(
                                style = SpanStyle(
                                    color = KoreTheme.colorScheme.onBackGround,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) {
                                append(" 2/5")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = KoreTheme.colorScheme.primary,
                                    fontWeight = FontWeight.Medium
                                )
                            ) {
                                append(" Upgrade")
                            }
                        }
                    )
                }
            )

            HorizontalSeparator(modifier = Modifier.padding(
                vertical = KoreTheme.sizes.xxs
            ))


            TabRow(
                selectedIndex = selectedTabIndex,
                tabs = {
                    tabNavItems.forEachIndexed { index, item ->
                        val isSelected = index == selectedTabIndex
                        Tab(
                            isSelected = isSelected,
                            content = {
                                Text(item.name)
                            },
                            icon = {
                                Icon(
                                    imageVector = if (isSelected) item.selectedIcon else item.unSelectedIcon,
                                    contentDescription = item.name
                                )
                            },
                            onClick = {
                                selectedTabIndex = index
                            }
                        )
                    }
                }

            )

            githubUsers.forEachIndexed { index, value ->

                HorizontalStack {
                    OutlinedTextField(
                        description = {
                            val days = (1..5).random()

                            Text(
                                "Last active $days ${if (days == 1) "day" else "days"} ago"
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        value = value,
                        onValueChange = {
                            githubUsers[index] = it
                        }
                    )


                }
            }

            HorizontalSeparator(modifier = Modifier.padding(
                vertical = KoreTheme.sizes.xxs
            ))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = PhIcons.Regular.Envelope,
                        contentDescription = ""
                    )
                },
                placeholder = {
                    Text("Enter Email Address")
                },
                value = newMembers,
                onValueChange = {
                    newMembers = it
                }
            )

            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    if (newMembers.isNotEmpty() && newMembers.isNotBlank()) {
                        githubUsers.add(newMembers)
                    }
                },

                content = {
                    Icon(
                        imageVector = PhIcons.Regular.Plus,
                        contentDescription = "",
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text("Add Member")
                }
            )

            Text(
                text = buildAnnotatedString {
                    append("Startup plan includes")

                    withStyle(
                        style = SpanStyle(
                            color = KoreTheme.colorScheme.onBackGround,
                            fontWeight = FontWeight.SemiBold
                        )
                    ) {
                        append("2/5")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = KoreTheme.colorScheme.primary,
                            fontWeight = FontWeight.Medium
                        )
                    ) {
                        append("Upgrade")
                    }
                }
            )

        }

    }
}


