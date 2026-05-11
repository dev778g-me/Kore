package com.dev.themebuilder.ui.showcase

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.card.Card
import com.dev.korelibrary.components.card.CardDefaults
import com.dev.korelibrary.components.card.OutlinedCard
import com.dev.korelibrary.components.progress.LinearProgressIndicator
import com.dev.korelibrary.components.separators.HorizontalSeparator
import com.dev.korelibrary.components.separators.VerticalSeparator
import com.dev.korelibrary.components.tabRow.Tab
import com.dev.korelibrary.components.tabRow.ScrollableTabRow
import com.dev.korelibrary.components.badge.SuccessBadge
import com.dev.korelibrary.components.stack.VerticalStack
import com.dev.korelibrary.components.text.Text
import com.dev.korelibrary.themes.KoreTheme

@Composable
fun FlightUIShowCase(
    modifier: Modifier = Modifier
){
    val tabItems = listOf<String>("Departing Trip", "Returning Trip")

    var selectedTabIndex by rememberSaveable(){ mutableStateOf(0) }

    val isReturn = selectedTabIndex ==1

    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.defaultCardColors(
            containerColor = KoreTheme.colorScheme.surface
        )
    ){

        VerticalStack(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ScrollableTabRow(
            //    expandedTabs = true,
                //modifier = Modifier.fillMaxWidth(),
                selectedIndex = selectedTabIndex,
                tabs = {
                    tabItems.forEachIndexed { index, string ->
                        val isSelected = index == selectedTabIndex
                        Tab(
                            modifier = Modifier.weight(1f),
                            isSelected = isSelected,
                            onClick = {
                                selectedTabIndex = index
                            },
                            content = {
                                Text(string)
                            }
                        )
                    }
                }
            )
            Spacer(
                modifier = Modifier.height(2.dp)
            )
            HorizontalSeparator()

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    AnimatedContent(
                        targetState = isReturn,
                        transitionSpec = {

                            if (targetState > initialState) {
                                (slideInHorizontally { it / 2 } + fadeIn()) togetherWith
                                        (slideOutHorizontally { -it / 2 } + fadeOut())
                            } else {
                                (slideInHorizontally { -it / 2 } + fadeIn()) togetherWith
                                        (slideOutHorizontally { it / 2 } + fadeOut())
                            }
                        }
                    ) {
                        if (it) {
                            Text(
                                text = "Incheon",
                                textStyle = KoreTheme.typography.label3.copy(
                                    color = KoreTheme.colorScheme.onBackGroundVariant
                                )
                            )
                        } else {
                            Text(
                            text = "Jeju",
                            textStyle = KoreTheme.typography.label3.copy(
                                color = KoreTheme.colorScheme.onBackGroundVariant
                            )
                        )
                    }
                }}

                SuccessBadge(

                    content = {
                        AnimatedContent(
                            transitionSpec = {
                                (fadeIn() + scaleIn(initialScale = 0.92f)) togetherWith fadeOut()
                            },
                            targetState = isReturn
                        ){
                            if (it){
                                Text("52 min duration",textStyle = KoreTheme.typography.label3)
                            }else{
                                Text("59 min duration",textStyle = KoreTheme.typography.label3)
                            }
                        }
                    }
                )

                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    AnimatedContent(
                        targetState = isReturn,
                        transitionSpec = {

                            if (targetState > initialState) {
                                (slideInHorizontally { it / 2 } + fadeIn()) togetherWith
                                        (slideOutHorizontally { -it / 2 } + fadeOut())
                            } else {
                                (slideInHorizontally { -it / 2 } + fadeIn()) togetherWith
                                        (slideOutHorizontally { it / 2 } + fadeOut())
                            }
                        }
                    ){
                        if (it){
                            Text("Jeju",textStyle = KoreTheme.typography.label3.copy(
                                color = KoreTheme.colorScheme.onBackGroundVariant
                            ))
                        }else{
                            Text(
                                text = "Incheon",
                                textStyle = KoreTheme.typography.label3.copy(
                                    color = KoreTheme.colorScheme.onBackGroundVariant
                                )
                            )
                        }
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ){
                    AnimatedContent(
                        targetState = isReturn,
                        transitionSpec = {
                            slideInVertically { it } + fadeIn() togetherWith
                                    slideOutVertically { -it } + fadeOut()
                        }
                    ){
                        if (it){
                            Text(
                                text = "ICH",
                                textStyle = KoreTheme.typography.heading3.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = KoreTheme.colorScheme.onBackGround
                                )
                            )
                        } else {
                            Text(
                                text = "CJU",
                                textStyle = KoreTheme.typography.heading3.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = KoreTheme.colorScheme.onBackGround
                                )
                            )
                        }
                    }
                }

                LinearProgressIndicator(
                    thickness = 4.dp,
                    modifier = modifier.fillMaxWidth(0.6f),
                    progress = 50f
                )

               Box(
                   modifier = Modifier.weight(1f),
                   contentAlignment = Alignment.CenterEnd
               ){
                   AnimatedContent(
                       targetState = isReturn,
                       transitionSpec = {
                           slideInVertically { it } + fadeIn() togetherWith
                                   slideOutVertically { -it } + fadeOut()
                       }
                   ){
                       if (it){
                           Text("CJU", textStyle = KoreTheme.typography.heading3.copy(
                               fontWeight = FontWeight.Bold,
                               color = KoreTheme.colorScheme.onBackGround
                           ))
                       }else {
                           Text("ICH", textStyle = KoreTheme.typography.heading3.copy(
                               fontWeight = FontWeight.Bold,
                               color = KoreTheme.colorScheme.onBackGround
                           ))
                       }
                   }
               }




            }

            Spacer(
                modifier = Modifier.height(4.dp)
            )
            OutlinedCard {
                Row(
                    modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Airline",
                            textStyle = KoreTheme.typography.label3.copy(
                                color = KoreTheme.colorScheme.onBackGroundVariant
                            )
                        )
                       AnimatedContent(
                           targetState = isReturn,
                           transitionSpec = {
                               slideInVertically(
                               ) { it/2} + fadeIn() togetherWith
                                       slideOutVertically { -it } + fadeOut()
                           }
                       ){
                           if (it){
                               Text(
                                   text = "Jeju Air",
                                   textStyle = KoreTheme.typography.label3.copy(
                                       color = KoreTheme.colorScheme.onBackGround,
                                       fontWeight = FontWeight.Bold
                                   )
                               )
                           }else{
                               Text(
                                   text = "Korean Air",
                                   textStyle = KoreTheme.typography.label3.copy(
                                       color = KoreTheme.colorScheme.onBackGround,
                                       fontWeight = FontWeight.Bold
                                   )
                               )

                           }
                       }
                    }

                    VerticalSeparator(
                        modifier = Modifier.fillMaxHeight(),
                    )

                    Column (
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text = "Flight Code",
                            textStyle = KoreTheme.typography.label3.copy(
                                color = KoreTheme.colorScheme.onBackGroundVariant
                            )
                        )
                        AnimatedContent(
                            targetState = isReturn,
                            transitionSpec = {
                                slideInVertically { it } + fadeIn() togetherWith
                                        slideOutVertically { -it } + fadeOut()
                            }
                        ){
                            if (it){
                                Text(
                                    text = "7C 123",
                                    textStyle = KoreTheme.typography.label3.copy(
                                        color = KoreTheme.colorScheme.onBackGround,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }else{
                                Text(
                                    text = "JU 220",
                                    textStyle = KoreTheme.typography.label3.copy(
                                        color = KoreTheme.colorScheme.onBackGround,
                                        fontWeight = FontWeight.Bold
                                    )
                                )

                            }
                        }
                    }
                    VerticalSeparator(
                        modifier = Modifier.fillMaxHeight(),

                    )
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Class",
                            textStyle = KoreTheme.typography.label3.copy(
                                color = KoreTheme.colorScheme.onBackGroundVariant
                            )
                        )

                        AnimatedContent(
                            targetState = isReturn,
                            transitionSpec = {
                                slideInVertically { it } + fadeIn() togetherWith
                                        slideOutVertically { -it } + fadeOut()
                            }
                        ){
                            if (it){
                                Text(
                                    text = "Economy",
                                    textStyle = KoreTheme.typography.label3.copy(
                                        color = KoreTheme.colorScheme.onBackGround,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }else{
                                Text(
                                    text = "Economy",
                                    textStyle = KoreTheme.typography.label3.copy(
                                        color = KoreTheme.colorScheme.onBackGround,
                                        fontWeight = FontWeight.Bold
                                    )
                                )

                            }
                        }
                    }

                }
            }
        }

    }
}