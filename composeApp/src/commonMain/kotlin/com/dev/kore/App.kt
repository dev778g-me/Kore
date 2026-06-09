package com.dev.kore

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.unit.sp
import com.dev.kore.theme.AppTheme
import com.dev.kore.components.appbar.Appbar
import com.dev.kore.components.buttons.SecondaryIconButton
import com.dev.kore.components.card.Card
import com.dev.kore.components.card.CardDefaults
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.listtile.ListTile
import com.dev.kore.components.scaffold.Scaffold
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.components.textFields.OutlinedTextField
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.colors.TailwindColors
import com.dev.kore.utilities.modifiers.clearFocusOnTap
import com.dev.kore.utilities.modifiers.dashedBorder
import com.dev.kore.utilities.modifiers.dotBorder
import com.dev.kore.utilities.modifiers.horizontalFadingEdges
import com.dev.kore.utilities.modifiers.verticalFadingEdges
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.Scroll


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

