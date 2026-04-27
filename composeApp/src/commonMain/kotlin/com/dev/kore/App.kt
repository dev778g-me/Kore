package com.dev.kore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.kore.theme.AppTheme
import com.dev.korelibrary.components.navigationBar.NavigationBar
import com.dev.korelibrary.components.navigationBar.NavigationBarItem
import com.dev.korelibrary.components.appbar.Appbar
import com.dev.korelibrary.components.buttons.GhostIconButton
import com.dev.korelibrary.components.icon.Icon
import com.dev.korelibrary.components.listItem.ListTile
import com.dev.korelibrary.components.scaffold.Scaffold
import com.dev.korelibrary.components.stack.VerticalStack
import com.dev.korelibrary.components.text.Text
import com.dev.korelibrary.components.buttons.ButtonDefaults
import com.dev.korelibrary.components.buttons.PrimaryIconButton
import com.dev.korelibrary.components.buttons.SecondaryButton
import com.dev.korelibrary.components.card.Card
import com.dev.korelibrary.components.progress.LinearProgressIndicator
import com.dev.korelibrary.components.progress.ProgressIndicatorDefaults
import com.dev.korelibrary.components.separators.HorizontalSeparator
import com.dev.korelibrary.components.switch.Switch
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.utilities.extensions.bold
import com.dev.korelibrary.utilities.extensions.color
import icons.PhIcons
import icons.bold.CheckBold
import icons.bold.NutBold
import icons.bold.PersonBold
import icons.bold.PlusBold
import icons.filled.ChartLineUpFill
import icons.filled.CompassFill
import icons.filled.CookingPotFill
import icons.filled.SunFill
import icons.regular.CaretLeft
import icons.regular.CaretRight
import icons.regular.DotsThree
import icons.regular.PencilLine
import icons.thin.ChartLineThin
import icons.thin.CompassThin
import icons.thin.CookingPotThin
import icons.thin.SunThin


@Composable
@Preview
fun App() {
    AppTheme {
      Scaffold {
         Column(
             modifier = Modifier.fillMaxSize(),
             verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally
         ) {
             var sliderState by remember { mutableStateOf(false) }


             Switch(
                 checkThumbContent = {
                     Icon(
                         imageVector = PhIcons.Bold.CheckBold,
                         contentDescription = ""
                     )
                 },
                 unCheckedThumbContent = {
                     Icon(
                         imageVector = PhIcons.Bold.PlusBold,
                         contentDescription = ""
                     )
                 },
                 checked = sliderState,
                 onCheckChange = {
                     sliderState = it
                 }
             )

         }
      }
    }
}

@Composable
fun PhoneUI(
    modifier: Modifier = Modifier
){

    var selectedIndex by remember{ mutableStateOf(0) }
    val bottomNavItems = listOf(
        BottomNav(
            label = "Today",
            unSelectedIcon = PhIcons.Thin.SunThin,
            selectedIcon = PhIcons.Filled.SunFill
        ),
        BottomNav(
            label = "Progress",
            unSelectedIcon = PhIcons.Thin.ChartLineThin,
            selectedIcon = PhIcons.Filled.ChartLineUpFill
        ),
        BottomNav(
            label = "Recipes",
            unSelectedIcon = PhIcons.Thin.CookingPotThin,
            selectedIcon = PhIcons.Filled.CookingPotFill
        ),
        BottomNav(
            label = "Discover",
            unSelectedIcon = PhIcons.Thin.CompassThin,
            selectedIcon = PhIcons.Filled.CompassFill
        ),
    )

    val aspectRatio = 448f / 997f
    Box(

    ){
        Scaffold(
            appBar = {
                Appbar(
                    modifier = Modifier.padding( start = 4.dp),
                    elevation = 0.dp,
                    navigationIcon = {
                        GhostIconButton(
                            onClick = {},
                            content = {
                                Icon(
                                    imageVector = PhIcons.Bold.NutBold,
                                    contentDescription = ""
                                )
                            }
                        )
                    },
                    appBarAction = {
                        PrimaryIconButton(
                            onClick = {},
                            content = {
                                Icon(
                                    imageVector = PhIcons.Bold.PersonBold,
                                    contentDescription = ""
                                )
                            }
                        )
                    },
                    title = {
                        Text("Log now", fontWeight = FontWeight.Bold)
                    }
                )
            },
            navigationBar = {
                NavigationBar(
                    content = {
                        bottomNavItems.forEachIndexed { index, nav ->
                            val isSelected = index == selectedIndex
                            NavigationBarItem(
                                icon = {
                                    Icon(
                                        imageVector = if (isSelected) nav.selectedIcon else nav.unSelectedIcon,
                                        contentDescription = nav.label
                                    )
                                },
                                label = { Text(text = nav.label) },
                                selected = isSelected,
                                onClick = {
                                    selectedIndex = index
                                }
                            )
                        }
                    }
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(it).padding(
                    horizontal = 16.dp
                ),
                verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)
            ) {


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    GhostIconButton(
                        onClick = {}
                    ) {
                        Icon(imageVector = PhIcons.Regular.CaretLeft, contentDescription = "")
                    }

                    Text(
                        text = "Today, March 28"
                    )
                    GhostIconButton(
                        onClick = {}
                    ) {
                        Icon(imageVector = PhIcons.Regular.CaretRight, contentDescription = "")
                    }
                }


                DailyProgressCard()
                BreakFastCard()

                LunchCard()


            }



        }


    }
}


@Composable
fun DailyProgressCard(){
    Card {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Daily Progress (KCAl)", textStyle = KoreTheme.typography.title3.color(
                KoreTheme.colorScheme.onBackGroundVariant))

            GhostIconButton(
                onClick = {}
            ){
                Icon(
                    imageVector = PhIcons.Regular.PencilLine,
                    contentDescription = ""
                )
            }
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                textStyle = KoreTheme.typography.heading3.bold().color(KoreTheme.colorScheme.onBackGround),
                text = buildAnnotatedString {
                    append("1,078")
                    withStyle(
                        style = SpanStyle(
                            fontSize = 16.sp
                        )
                    ){
                        append(" left")
                    }
                }
            )

            Column {
                Text("1022 eaten", textStyle = KoreTheme.typography.label3)
                Text("0 burned",  textStyle = KoreTheme.typography.label3)
            }
        }
        Spacer(modifier = Modifier.height(KoreTheme.sizes.sm))
        LinearProgressIndicator(
            progress = 40f / 100f
        )
        Spacer(modifier = Modifier.height(KoreTheme.sizes.sm))

        HorizontalSeparator()
        Spacer(modifier = Modifier.height(KoreTheme.sizes.sm))
        Text("Micronutrients")
        Spacer(modifier = Modifier.height(KoreTheme.sizes.sm))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            VerticalStack(
                modifier = Modifier.weight(1f)
                    .padding(horizontal = KoreTheme.sizes.sm)
            ) {
                Text(
                    "Carbs",
                    textStyle = KoreTheme.typography.label3.bold().color(
                        KoreTheme.colorScheme.onBackGround
                    )
                )

                LinearProgressIndicator(
                    colors = ProgressIndicatorDefaults.barProgressColors(
                        trackColor = KoreTheme.colorScheme.error.copy(alpha = 0.3f),
                        progressColor = KoreTheme.colorScheme.error
                    ),
                    thickness = 4.dp,
                    modifier = Modifier.fillMaxWidth(1f),
                    progress = 45f / 100f
                )

                Text(
                    textStyle = KoreTheme.typography.label3.bold().color(
                        KoreTheme.colorScheme.onBackGround
                    ),
                    text = buildAnnotatedString {
                        append("135/")
                        withStyle(
                            style = SpanStyle(
                                color = KoreTheme.colorScheme.onBackGroundVariant
                            )
                        ) {
                            append("267 g")
                        }
                    }
                )
            }
            VerticalStack(
                modifier = Modifier.weight(1f)
                    .padding(horizontal = KoreTheme.sizes.sm)
            ) {
                Text(
                    "Carbs",
                    textStyle = KoreTheme.typography.label3.bold().color(
                        KoreTheme.colorScheme.onBackGround
                    )
                )

                LinearProgressIndicator(
                    colors = ProgressIndicatorDefaults.barProgressColors(
                        trackColor = KoreTheme.colorScheme.complementary.copy(alpha = 0.3f),
                        progressColor = KoreTheme.colorScheme.complementary
                    ),
                    thickness = 4.dp,
                    modifier = Modifier.fillMaxWidth(1f),
                    progress = 45f / 100f
                )

                Text(
                    textStyle = KoreTheme.typography.label3.bold().color(
                        KoreTheme.colorScheme.onBackGround
                    ),
                    text = buildAnnotatedString {
                        append("135/")
                        withStyle(
                            style = SpanStyle(
                                color = KoreTheme.colorScheme.onBackGroundVariant
                            )
                        ) {
                            append("267 g")
                        }
                    }
                )
            }
            VerticalStack(
                modifier = Modifier.weight(1f)
                    .padding(horizontal = KoreTheme.sizes.sm)
            ) {
                Text(
                    "Carbs",
                    textStyle = KoreTheme.typography.label3.bold().color(
                        KoreTheme.colorScheme.onBackGround
                    )
                )

                LinearProgressIndicator(
                    colors = ProgressIndicatorDefaults.barProgressColors(
                        trackColor = KoreTheme.colorScheme.success.copy(alpha = 0.3f),
                        progressColor = KoreTheme.colorScheme.success
                    ),
                    thickness = 4.dp,
                    //   modifier = Modifier.fillMaxWidth(1f),
                    progress = 45f / 100f
                )

                Text(
                    textStyle = KoreTheme.typography.label3.bold().color(
                        KoreTheme.colorScheme.onBackGround
                    ),
                    text = buildAnnotatedString {
                        append("135/")
                        withStyle(
                            style = SpanStyle(
                                color = KoreTheme.colorScheme.onBackGroundVariant
                            )
                        ) {
                            append("267 g")
                        }
                    }
                )
            }
        }

    }
}


@Composable
fun BreakFastCard() {
    Card {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Breakfast",
                textStyle = KoreTheme.typography.title2.bold()
                    .color(KoreTheme.colorScheme.onBackGround)
            )

            GhostIconButton(
                onClick = {},
                content = {
                    Icon(imageVector = PhIcons.Regular.DotsThree, contentDescription = "")
                }
            )


        }

        Spacer(
            modifier = Modifier.height(KoreTheme.sizes.sm)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                textStyle = KoreTheme.typography.title1,
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = KoreTheme.colorScheme.onBackGround)){
                        append("193")
                    }
                    append("/437 kcal")
                }
            )


            SecondaryButton(
                colors = ButtonDefaults.secondaryButtonColors(
                    containerColor = KoreTheme.colorScheme.complementaryContainer,
                    contentColor = KoreTheme.colorScheme.onComplementaryContainer
                ),
                contentPadding = PaddingValues(
                    vertical = 4.dp,
                    horizontal = 12.dp
                ),
                onClick = {},
                content = {

                    Text("Add food", textStyle = KoreTheme.typography.label2)
                }
            )
        }
        Spacer(
            modifier = Modifier.height(KoreTheme.sizes.sm)
        )
        ListTile(
            contentPaddingValues = PaddingValues(
                horizontal = 0.dp,
                vertical = KoreTheme.sizes.sm
            ),
            title = {
                Text("Lowfat Beef & Pork Bologna")
            },
            subtitle = {
                Text("3 slice , NFS 84g")
            },
            trailing = {
                Text("122 kcal",color = KoreTheme.colorScheme.onBackGround, fontWeight = FontWeight.Bold)
            }
        )
        ListTile(
            contentPaddingValues = PaddingValues(
                horizontal = 0.dp,
                vertical = KoreTheme.sizes.sm
            ),
            title = {
                Text("Poppadoms with Salsa")
            },
            subtitle = {
                Text("1 slice ,  94g")
            },
            trailing = {
                Text("90 kcal", color = KoreTheme.colorScheme.onBackGround, fontWeight = FontWeight.Bold)
            }
        )
    }
}


@Composable
fun LunchCard(){
    Card {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Lunch",
                textStyle = KoreTheme.typography.title2.bold()
                    .color(KoreTheme.colorScheme.onBackGround)
            )

            GhostIconButton(
                onClick = {},
                content = {
                    Icon(imageVector = PhIcons.Regular.DotsThree, contentDescription = "")
                }
            )


        }

        Spacer(
            modifier = Modifier.height(KoreTheme.sizes.sm)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                textStyle = KoreTheme.typography.title1,
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = KoreTheme.colorScheme.onBackGround)){
                        append("100")
                    }
                    append("/500 kcal")
                }
            )


            SecondaryButton(
                colors = ButtonDefaults.secondaryButtonColors(
                    containerColor = KoreTheme.colorScheme.complementaryContainer,
                    contentColor = KoreTheme.colorScheme.onComplementaryContainer
                ),
                contentPadding = PaddingValues(
                    vertical = 4.dp,
                    horizontal = 12.dp
                ),
                onClick = {},
                content = {

                    Text("Add food", textStyle = KoreTheme.typography.label2)
                }
            )
        }
        Spacer(
            modifier = Modifier.height(KoreTheme.sizes.sm)
        )
        ListTile(
            contentPaddingValues = PaddingValues(
                horizontal = 0.dp,
                vertical = KoreTheme.sizes.sm
            ),
            title = {
                Text("Lowfat Beef & Pork Bologna")
            },
            subtitle = {
                Text("3 slice , NFS 84g")
            },
            trailing = {
                Text("122 kcal",color = KoreTheme.colorScheme.onBackGround, fontWeight = FontWeight.Bold)
            }
        )
        ListTile(
            contentPaddingValues = PaddingValues(
                horizontal = 0.dp,
                vertical = KoreTheme.sizes.sm
            ),
            title = {
                Text("Poppadoms with Salsa")
            },
            subtitle = {
                Text("1 slice ,  94g")
            },
            trailing = {
                Text("90 kcal", color = KoreTheme.colorScheme.onBackGround, fontWeight = FontWeight.Bold)
            }
        )
    }
}







data class BottomNav(
    val label : String,
    val unSelectedIcon : ImageVector,
    val selectedIcon : ImageVector,
)