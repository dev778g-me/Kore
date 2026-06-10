package com.dev.kore.shared

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.dev.kore.shared.theme.AppTheme
import com.dev.kore.components.appbar.Appbar
import com.dev.kore.components.card.Card
import com.dev.kore.components.scaffold.Scaffold
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.colors.TailwindColors
import com.dev.kore.utilities.modifiers.clearFocusOnTap
import com.dev.kore.utilities.modifiers.dotBorder


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
                    //.verticalScroll(state = scrollState)
                    .clearFocusOnTap()
                    .padding(it)
                    .padding(horizontal = 16.dp) // The parent constraints
            ) {

                //VerticalSeparator(color = Color.Red)

                var inputText by remember { mutableStateOf("") }

                Card(
                    modifier = Modifier.size(200.dp)
                        .dotBorder(
                            dotRadius = 1.5.dp,
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    TailwindColors.Blue.swatch600,
                                    TailwindColors.Rose.swatch600,
                                )
                            ),
                            shape = KoreTheme.shapes.sm
                        )
                ) {

                }

                }
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

