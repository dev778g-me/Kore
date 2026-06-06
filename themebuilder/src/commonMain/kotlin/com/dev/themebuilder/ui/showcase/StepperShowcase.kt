package com.dev.themebuilder.ui.showcase

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.buttons.GhostIconButton
import com.dev.kore.components.card.Card
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.stepper.Stepper
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.extensions.color
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Minus
import com.phosphor.icons.regular.Plus

@Composable
fun StepperShowcase(
    modifier: Modifier = Modifier,
) {

    var quantity by rememberSaveable { mutableIntStateOf(1) }

    Card(
        modifier = modifier
    ) {

        VerticalStack(

        ) {

            Text(
                text = "Quantity Stepper",
                textStyle = KoreTheme.typography.title2
            )

            Text(
                text = "Adjust the number of items",
                textStyle = KoreTheme.typography.body3
                    .color(KoreTheme.colorScheme.onBackGroundVariant)
            )

            Stepper(

                label = {
                    Text(
                        text = quantity.toString(),
                        textStyle = KoreTheme.typography.title2
                    )
                },

                decrementButton = {

                    GhostIconButton(
                        onClick = {
                            if (quantity > 0) {
                                quantity--
                            }
                        }
                    ) {

                        com.dev.kore.components.icon.Icon(
                            imageVector = PhIcons.Regular.Minus,
                            contentDescription = "decrement"
                        )
                    }
                },

                incrementIcon = {

                    GhostIconButton(
                        onClick = {
                            quantity++
                        }
                    ) {

                        com.dev.kore.components.icon.Icon(
                            imageVector = PhIcons.Regular.Plus,
                            contentDescription = "increment"
                        )
                    }
                },

                border = BorderStroke(
                    width = 1.dp,
                    color = KoreTheme.colorScheme.backGroundVariant
                ),

            //    containerColor = KoreTheme.colorScheme.backGround
            )

            Text(
                text = "Selected quantity: $quantity",
                textStyle = KoreTheme.typography.label2
                    .color(KoreTheme.colorScheme.primary)
            )
        }
    }
}