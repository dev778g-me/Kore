package com.dev.kore

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.kore.theme.AppTheme
import com.dev.kore.components.appbar.Appbar
import com.dev.kore.components.buttons.PrimaryIconButton
import com.dev.kore.components.card.Card
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.listtile.ListTile
import com.dev.kore.components.scaffold.Scaffold
import com.dev.kore.components.separators.HorizontalDashedSeparator
import com.dev.kore.components.separators.HorizontalDottedDivider
import com.dev.kore.components.separators.VerticalDashedSeparator
import com.dev.kore.components.separators.VerticalDottedSeparator
import com.dev.kore.components.separators.VerticalSeparator
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.colors.TailwindColors
import com.dev.kore.utilities.modifiers.clearFocusOnTap
import com.dev.kore.utilities.modifiers.dotBorder
import com.dev.kore.utilities.modifiers.verticalFadingEdges
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Stack


@Composable
fun App() {
    var switchState by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    AppTheme {
        Scaffold(
            appBar = {
                Appbar(
                    title = {
                        Text("Blendinggg")
                    }
                )
            }
        ) {
            VerticalStack(
                verticalAlignment = Alignment.CenterVertically,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalFadingEdges(0.1f)
                    //.verticalScroll(state = scrollState)
                    .clearFocusOnTap()
                    .padding(it)
                    .padding(horizontal = 16.dp) // The parent constraints
            ) {

                //VerticalSeparator(color = Color.Red)
                HorizontalDashedSeparator(
                    thickness = if (switchState) 12.dp else 2.dp
                )

                HorizontalDottedDivider(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            TailwindColors.Red.swatch600, TailwindColors.Black
                        )
                    ),
                    dotRadius = 4.dp
                )

                PrimaryIconButton(
                    onClick = {
                        switchState = !switchState
                    }
                ){
                    Icon(
                        imageVector = PhIcons.Regular.Stack,
                        contentDescription = null
                    )
                }
//                Card(
//                    modifier = Modifier.size(200.dp)
//                        .dotBorder(
//                        color = KoreTheme.colorScheme.backGroundVariant,
//                        shape = KoreTheme.shapes.sm
//                    )
//                ) {}
//
//                    repeat(40) {
//                        ListTile(
//                            leading = {
//                                Icon(
//                                    imageVector = PhIcons.Regular.Stack,
//                                    contentDescription = null,
//                                    tint = KoreTheme.colorScheme.primary
//                                )
//                            },
//                            title = {
//                                Text("Path Effect")
//                            }
//                        )
//                    }

            }
        }
    }
}
