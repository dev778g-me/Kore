package com.dev.themebuilder.ui.view.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.korelibrary.components.dropdown.DropDown
import com.dev.korelibrary.components.dropdown.DropDownItem
import com.dev.korelibrary.components.listtile.ListTile
import com.dev.korelibrary.components.badge.ErrorBadge
import com.dev.korelibrary.components.stack.VerticalStack
import com.dev.korelibrary.components.text.Text
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.utilities.extensions.color
import com.dev.themebuilder.ui.model.Sizes
import com.dev.themebuilder.ui.model.neutralColorsList
import com.dev.themebuilder.ui.model.primaryColorsList
import com.dev.themebuilder.ui.model.ShapeType
import com.dev.themebuilder.ui.viewmodel.ThemeViewModel

@Composable
fun CustomizeColumn(
    modifier: Modifier = Modifier,
    isDark : Boolean
) {

    val viewModel: ThemeViewModel = viewModel { ThemeViewModel() }

    val primary by viewModel.currentPrimaryColor.collectAsStateWithLifecycle()
    val neutral by viewModel.currentNeutralColor.collectAsStateWithLifecycle()
    val complementary by viewModel.currentComplementaryColor.collectAsStateWithLifecycle()
    val sizes by viewModel.currentSize.collectAsStateWithLifecycle()
    val shape by viewModel.provideShape .collectAsStateWithLifecycle()

    var showShapes by remember { mutableStateOf(false) }
    var showSizes by remember { mutableStateOf(false) }
    var showPrimary by remember { mutableStateOf(false) }
    var showNeutralColors by remember { mutableStateOf(false) }
    var showComplementaryColors by remember { mutableStateOf(false) }

  //  val isDark = isSystemInDarkTheme()
    VerticalStack(
        modifier = modifier.sizeIn(
            maxWidth = 200.dp
        )
    ) {
        Text(
           text = "Customize",
            textStyle = KoreTheme.typography.title2.color(color = KoreTheme.colorScheme.onBackGround)
        )

        ListTile(
            onClick = {
                showPrimary = true
            },
            modifier = Modifier.border(
                width = 2.dp,
                shape = KoreTheme.shapes.md,
                color = KoreTheme.colorScheme.backGroundVariant
            ),
            overline = {
                Text("Primary Color")
            },
            title = {
                Text(
                    text = primary.name
                )
            },
            trailing = {
                Box(
                    modifier = Modifier.size(12.dp).background(
                        color = KoreTheme.colorScheme.primary,
                        shape = CircleShape
                    )
                )

                DropDown(
                    borderStroke = BorderStroke(
                            width = 2.dp,
                            color = KoreTheme.colorScheme.backGroundVariant
                        ),
                        expanded = showPrimary,
                        onDismissRequest = {
                            showPrimary = false
                        },
                        content = {
                            primaryColorsList.forEach {
                                DropDownItem(
                                    leading = {
                                        Box(
                                            modifier = Modifier.size(12.dp)
                                                .clip(CircleShape)
                                                .background(color = it.lightScale.step9)
                                        )

                                    },
                                    title = {
                                        Text(it.name)
                                    },
                                    onClick = {
                                       viewModel.providePrimary(seedColor = it)
                                        showPrimary = false
                                    }
                                )
                            }
                        }
                    )
                }
            )
        ListTile(
            onClick = {
                showComplementaryColors = true
            },
            modifier = Modifier.border(
                width = 2.dp,
                shape = KoreTheme.shapes.md,
                color = KoreTheme.colorScheme.backGroundVariant
            ),
            overline = {
                Text("Complementary")
            },
            title = {
                Text(complementary.complementaryName!!)
            },
            trailing = {
                Box(
                    modifier = Modifier.size(12.dp).background(
                        color = KoreTheme.colorScheme.complementary,
                        shape = CircleShape
                    )
                )
                DropDown(
                    borderStroke = BorderStroke(
                        width = 2.dp,
                        color = KoreTheme.colorScheme.backGroundVariant
                    ),
                    expanded = showComplementaryColors,
                    onDismissRequest = {
                        showComplementaryColors = false
                    },

                    content = {
                        primaryColorsList.forEach {
                            DropDownItem(
                                leading = {
                                    Box(
                                        modifier = Modifier.size(12.dp)
                                            .clip(CircleShape)
                                            .background(color = it.lightScale.step9)
                                    )

                                },
                                onClick = {
                                    showComplementaryColors = false
                                    viewModel.provideComplementary(seedColor = it )
                                },
                                title = {
                                    Text(it.name)
                                }
                            )
                        }
                    }
                )
            }

        )
        ListTile(
            onClick = {
                showNeutralColors = true
            },
            modifier = Modifier.border(
                width = 2.dp,
                shape = KoreTheme.shapes.md,
                color = KoreTheme.colorScheme.backGroundVariant
            ),
            overline = {
                Text("Neutral Colors")
            },
            title = {
                Text(
                    text = neutral.name
                )
            },
            trailing = {
                Box(modifier = Modifier.size(12.dp).background(
                    color =neutral.lightScale.step9,
                    shape = CircleShape
                ))
                DropDown(
                    borderStroke = BorderStroke(
                        width = 2.dp,
                        color = KoreTheme.colorScheme.backGroundVariant
                    ),
                    expanded = showNeutralColors,
                    onDismissRequest = {
                        showNeutralColors = false
                    },
                    content = {
                        neutralColorsList.forEach {
                            DropDownItem(
                                title = {
                                    Text(it.name)
                                },
                                trailing = {
                                    Box(
                                        modifier = Modifier.size(12.dp)
                                            .clip(CircleShape)
                                            .background(color = it.lightScale.step9)
                                    )
                                },
                                onClick = {
                                  viewModel.provideNeutrals(it)
                                    showNeutralColors = false
                                }
                            )
                        }
                    }
                )
            }
        )


        ListTile(
            onClick = {
                showShapes = true
            },
            modifier = Modifier.border(
                width = 2.dp,
                shape = KoreTheme.shapes.md,
                color = KoreTheme.colorScheme.backGroundVariant
            ),
            overline = {
                Text("Shape")
            },
            title = {
                Text(shape.name)


            },
            trailing = {
                DropDown(
                    borderStroke = BorderStroke(
                        width = 2.dp,
                        color = KoreTheme.colorScheme.backGroundVariant
                    ),
                    expanded = showShapes,
                    onDismissRequest = {
                        showShapes = false
                    },
                    content = {
                        ShapeType.entries.forEach {
                            DropDownItem(
                                title = {
                                    Text(it.name)
                                },
                                onClick = {
                                   when(it){
                                       ShapeType.RoundedRectangle -> viewModel.changeRoundedRect()
                                       ShapeType.Squircle -> viewModel.changeSquircle()
                                   }
                                    showShapes = false
                                },
                                trailing = {
                                    if (it== ShapeType.Squircle){
                                        ErrorBadge(content = {Text("Expr")})
                                    }
                                }
                            )
                        }
                    }
                )
            }
        )
        ListTile(
            onClick = {
                showSizes = true
            },
            modifier = Modifier.border(
                width = 2.dp,
                shape = KoreTheme.shapes.md,
                color = KoreTheme.colorScheme.backGroundVariant
            ),
            overline = {
                Text("Sizes")
            },
            title = {
                Text(sizes.name)
            },
            trailing = {
                DropDown(
                    borderStroke = BorderStroke(
                        width = 2.dp,
                        color = KoreTheme.colorScheme.backGroundVariant
                    ),
                    expanded = showSizes,
                    onDismissRequest = {
                        showSizes = false
                    },
                    content = {
                        Sizes.entries.forEach {
                            DropDownItem(
                                onClick = {
                                    showSizes = false
                                   when(it){
                                       Sizes.Airy -> viewModel.changeToAiry()
                                       Sizes.Compact -> viewModel.changeToCompact()
                                       Sizes.Balanced -> viewModel.changeToBalanced()
                                   }
                                },
                                title = {
                                    Text(it.name)
                                }
                            )
                        }
                    }
                )
            }

        )



    }
}
