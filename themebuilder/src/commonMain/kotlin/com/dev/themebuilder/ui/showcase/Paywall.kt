package com.dev.themebuilder.ui.showcase

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ModalDrawer
import com.dev.korelibrary.components.radio.RadioButton
import com.dev.korelibrary.components.tabRow.ScrollableTabRow
import com.dev.korelibrary.components.text.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.card.Card
import com.dev.korelibrary.components.listtile.ListTile
import com.dev.korelibrary.components.listtile.ListTileDefaults
import com.dev.korelibrary.components.stack.VerticalStack
import com.dev.korelibrary.components.tabRow.Tab
import com.dev.korelibrary.themes.KoreTheme
import org.jetbrains.skia.paragraph.Alignment

@Composable
fun PaywallUiShowcase(
    modifier: Modifier = Modifier
){
    var selectedBillingIndex by rememberSaveable { mutableStateOf(0) }
    var selectedPlanIndex by rememberSaveable { mutableStateOf(0) }

    val planTypes = listOf("Monthly", "Yearly")


    val pricingPlans = listOf(

        PaywallInfo(
            name = "Starter",
            price = "$4.99",
            endUser = "Perfect for beginners",
            feature1 = "10 Projects",
            feature2 = "Basic Analytics",
            feature3 = "Community Support"
        ),

        PaywallInfo(
            name = "Plus",
            price = "$8.99",
            endUser = "For Individual Creators",
            feature1 = "Unlimited Projects",
            feature2 = "Advanced Analytics",
            feature3 = "Priority Support"
        ),

        PaywallInfo(
            name = "Enterprise",
            price = "$19.99",
            endUser = "For Teams & Businesses",
            feature1 = "Team Collaboration",
            feature2 = "Custom Branding",
            feature3 = "Dedicated Support"
        )
    )

    
    
    Card {
        VerticalStack {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Select a Plan")
            ScrollableTabRow(
                selectedIndex = selectedBillingIndex,
                tabs = {
                    planTypes.forEachIndexed { index, item ->
                        val isSelected = index == selectedBillingIndex
                        Tab(
                            isSelected = isSelected,
                            content = {
                                Text(item)
                            },
                            onClick = {
                                selectedBillingIndex = index
                            }
                        )
                }})



        }
            pricingPlans.forEachIndexed { index, info ->
                val isSelected = index == selectedPlanIndex

                val borderColor by animateColorAsState(
                    targetValue = if (isSelected) KoreTheme.colorScheme.primary else KoreTheme.colorScheme.backGroundVariant
                )

                val borderWidth by animateDpAsState(
                    targetValue = if (isSelected) 2.dp else 1.dp
                )
                val containerColor by animateColorAsState(
                    targetValue = if (isSelected) KoreTheme.colorScheme.primary.copy(alpha = 0.1f) else KoreTheme.colorScheme.surface
                )
                ListTile(
                    colors = ListTileDefaults.defaultListTileColors(
                      containerColor =   containerColor
                    ),
                    leadingAlignment = androidx.compose.ui.Alignment.Top,
                    modifier = Modifier.border(
                        width = borderWidth,
                        color = borderColor,
                        shape = ListTileDefaults.defaultListTileShape
                    ),
                    onClick = {
                        selectedPlanIndex = index
                    },
                    leading = {
                        RadioButton(
                            selected = isSelected,
                            onClick = {
                                selectedPlanIndex = index
                            }
                        )
                    },
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(info.name)
                            Text(info.price)
                        }
                    },
                    subtitle = {
                        VerticalStack(
                            horizontalAlignment = androidx.compose.ui.Alignment.Start
                        ) {
                            Text(info.endUser)

                            AnimatedVisibility(
                                visible = isSelected
                            ) {

                               Column (
                                   modifier = Modifier.fillMaxWidth(),
                                   horizontalAlignment = androidx.compose.ui.Alignment.Start
                               ) {
                                   Text(
                                       "• ${info.feature1}",
                                       color = KoreTheme.colorScheme.onSurfaceBright
                                   )

                                   Text(
                                       "• ${info.feature2}",
                                       color = KoreTheme.colorScheme.onSurfaceBright
                                   )

                                   Text(
                                       "• ${info.feature3}",
                                       color = KoreTheme.colorScheme.onSurfaceBright
                                   )
                               }

                            }
                        }
                    }
                )
            }
    }}

}



data class PaywallInfo(
    val name : String,
    val price : String,
    val endUser : String,
    val feature1 : String ,
    val feature2 : String ,
    val feature3 : String
)