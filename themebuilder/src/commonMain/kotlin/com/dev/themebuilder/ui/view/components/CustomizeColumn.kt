package com.dev.themebuilder.ui.view.components

import co.touchlab.kermit.Logger
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import com.dev.kore.components.dropdown.DropDown
import com.dev.kore.components.dropdown.DropDownItem
import com.dev.kore.components.listtile.ListTile
import com.dev.kore.components.badge.ErrorBadge
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.listtile.ListTileDefaults
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.extensions.color
import com.dev.themebuilder.ui.models.PrimaryColorSource
import com.dev.themebuilder.ui.models.ShapeRadius
import com.dev.themebuilder.ui.models.Sizes
import com.dev.themebuilder.ui.models.neutralColorsList
import com.dev.themebuilder.ui.models.primaryColorsList
import com.dev.themebuilder.ui.models.ShapeType
import com.dev.themebuilder.ui.models.tailWindPrimaryColorsList
import com.dev.themebuilder.ui.view.components.logo.RadixLogo
import com.dev.themebuilder.ui.view.components.logo.TailwindCss
import com.dev.themebuilder.ui.viewmodel.ThemeViewModel

@Composable
fun CustomizeColumn(
    modifier: Modifier = Modifier,
    viewModel: ThemeViewModel,
) {
    val primary by viewModel.currentPrimaryColor.collectAsStateWithLifecycle()
    val tailWindPrimary by viewModel.currentTailwindPrimaryColor.collectAsStateWithLifecycle()
    val primarySource by viewModel.currentPrimaryColorSource.collectAsStateWithLifecycle()
    val neutral by viewModel.currentNeutralColor.collectAsStateWithLifecycle()
    val complementary by viewModel.currentComplementaryColor.collectAsStateWithLifecycle()
    val tailwindComplementary by viewModel.currentTailwindComplementaryColor.collectAsStateWithLifecycle()
    val sizes by viewModel.currentSize.collectAsStateWithLifecycle()
    val shapeType by viewModel.provideShapeType .collectAsStateWithLifecycle()
    val shapeRadius by viewModel.shaprRadius.collectAsStateWithLifecycle()

    var showShapeType by remember { mutableStateOf(false) }
    var showShapeRadius by remember { mutableStateOf(false) }
    var showSizes by remember { mutableStateOf(false) }
    var showPrimary by remember { mutableStateOf(false) }
    var showPrimarySource by remember { mutableStateOf(false) }
    var showNeutralColors by remember { mutableStateOf(false) }
    var showComplementaryColors by remember { mutableStateOf(false) }
    var isRectSelected by remember(shapeRadius) { mutableStateOf(shapeRadius == ShapeRadius.Sharp)  }

    val isTailwind = primarySource == PrimaryColorSource.Tailwind

    VerticalStack(
        modifier = modifier.sizeIn(
            maxWidth = 200.dp
        )
    ) {
        Text(
           text = "Customize",
            textStyle = KoreTheme.typography.title2.color(color = KoreTheme.colorScheme.onBackGround)
        )

        CustomizeColumnItem(
            overlineText = "Primary Color",
            titleText = if (isTailwind) tailWindPrimary.name else primary.name,
            onClick = { showPrimary = true },
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

                        if(isTailwind){
                            tailWindPrimaryColorsList.forEach {
                                DropDownItem(
                                    leading = {
                                        Box(
                                            modifier = Modifier.size(12.dp)
                                                .clip(CircleShape)
                                                .background(color = it.colorScale.swatch500, )
                                        )

                                    },
                                    title = {
                                        Text(it.name)
                                    },
                                    onClick = {
                                        Logger.i {
                                            "i choosed tailwind one"
                                        }
                                        viewModel.providePrimary(seedColor = primary, tailWindSeedColor =  it, colorSource = PrimaryColorSource.Tailwind)
                                        showPrimary = false
                                    }
                                )
                            }
                        }else{
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
                                    Logger.i {
                                        "i choosed radix one"
                                    }
                                    viewModel.providePrimary(seedColor = it, colorSource = PrimaryColorSource.Radix)
                                    showPrimary = false
                                }
                            )
                        }}
                    }
                )
            }
        )

        CustomizeColumnItem(
            overlineText = "Primary Color Source",
            titleText = primarySource.name,
            onClick = {
                showPrimarySource = true
            },
            trailing = {
                Icon(
                    imageVector = if (isTailwind) TailwindCss else RadixLogo,
                    contentDescription = "",
                    modifier = Modifier.size(18.dp)
                )
                DropDown(
                    borderStroke = BorderStroke(
                        width = 2.dp,
                        color = KoreTheme.colorScheme.backGroundVariant
                    ),
                    expanded = showPrimarySource,
                    onDismissRequest = {
                        showPrimarySource = false
                    },
                    content = {
                        PrimaryColorSource.entries.forEach { colorSource ->
                            DropDownItem(
                                leading = {
                                    Icon(
                                        imageVector = if (colorSource == PrimaryColorSource.Tailwind) TailwindCss else RadixLogo,
                                        contentDescription = "",
                                        modifier = Modifier.size(12.dp)
                                    )

                                },
                                title = {
                                    Text(colorSource.name)
                                },
                                onClick = {
                                    when(colorSource){
                                        PrimaryColorSource.Tailwind -> {
                                            viewModel.changePrimaryColorSource(PrimaryColorSource.Tailwind)

                                            val currentPrimary =
                                                tailWindPrimaryColorsList.find { tailWindColorEntry ->
                                                    primary.name == tailWindColorEntry.name
                                                }

                                            if (currentPrimary != null) {
                                                viewModel.providePrimary(
                                                    tailWindSeedColor = currentPrimary,
                                                    colorSource = PrimaryColorSource.Tailwind,
                                                    seedColor = primaryColorsList[8]
                                                )
                                            } else {
                                                viewModel.providePrimary(
                                                    tailWindSeedColor = tailWindPrimaryColorsList[8],
                                                    colorSource = PrimaryColorSource.Tailwind,
                                                    seedColor = primary
                                                )
                                            }
                                            viewModel.provideSuccessColor(colorSource = PrimaryColorSource.Tailwind)
                                        }
                                        PrimaryColorSource.Radix -> {
                                            viewModel.changePrimaryColorSource(PrimaryColorSource.Radix)

                                            Logger.i{
                                                "changed source to ${PrimaryColorSource.Radix}"
                                            }
                                            val currentPrimary =
                                                primaryColorsList.find { radixColorEntry ->
                                                    radixColorEntry.name == tailWindPrimary.name
                                                }
                                            if (currentPrimary != null) {
                                                Logger.i("Found Color ${currentPrimary.name}")
                                                viewModel.providePrimary(
                                                    colorSource = PrimaryColorSource.Radix,
                                                    seedColor = currentPrimary,
                                                )
                                            } else {
                                                Logger.i { "else case ran sp the default color" }
                                                viewModel.providePrimary(
                                                    colorSource = PrimaryColorSource.Radix,
                                                    seedColor = primaryColorsList[8],

                                                    )
                                            }
                                            viewModel.provideSuccessColor(colorSource = PrimaryColorSource.Radix)
                                        }
                                    }
                                    showPrimarySource = false
                                }
                            )
                        }
                    }
                )
            }
        )

        CustomizeColumnItem(
            overlineText = "Complementary",
            titleText = if(complementary == primary && tailwindComplementary == tailWindPrimary){
                if (isTailwind) tailwindComplementary.complementaryName else complementary.complementaryName!!
            }else {
                if (isTailwind) tailwindComplementary.name else complementary.name
            },
            onClick = { showComplementaryColors = true },
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
                        if (primarySource == PrimaryColorSource.Radix){
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
                                    viewModel.provideComplementary(seedColor = it, colorSource = PrimaryColorSource.Radix)
                                },
                                title = {
                                    Text(it.name)
                                }
                            )
                        }} else {
                            tailWindPrimaryColorsList.forEach {
                                DropDownItem(
                                    leading = {
                                        Box(
                                            modifier = Modifier.size(12.dp)
                                                .clip(CircleShape)
                                                .background(color = it.colorScale.swatch600)
                                        )
                                    },
                                    onClick = {
                                        showComplementaryColors = false
                                        viewModel.provideComplementary(seedColor = primaryColorsList[8], colorSource = PrimaryColorSource.Tailwind, tailWindSeedColor = it)
                                    },
                                    title = {
                                        Text(it.name)
                                    }
                                )
                            }
                        }
                    }
                )
            }
        )

        CustomizeColumnItem(
            overlineText = "Neutral Colors",
            titleText = neutral.name,
            onClick = {
                showNeutralColors = true
            },
            trailing = {
                Box(
                    modifier = Modifier.size(12.dp).background(
                        color = neutral.lightScale.step9,
                        shape = CircleShape
                    )
                )
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

        CustomizeColumnItem(
            enabled = !isRectSelected,
            overlineText = "ShapeType",
            titleText = shapeType.name,
            onClick = {
                showShapeType = true
            },
            trailing = {
                DropDown(
                    borderStroke = BorderStroke(
                        width = 2.dp,
                        color = KoreTheme.colorScheme.backGroundVariant
                    ),
                    expanded = showShapeType,
                    onDismissRequest = {
                        showShapeType = false
                    },
                    content = {
                        ShapeType.entries.forEach {
                            DropDownItem(
                                title = {
                                    Text(it.name)
                                },
                                onClick = {
                                    viewModel.changeShapeRadius(shapeRadius = shapeRadius, shapeType = it)

                                    when (it) {
                                        ShapeType.RoundedRectangle -> viewModel.changeRoundedRect()
                                        ShapeType.SmoothCornerShape -> viewModel.changeSquircle()
                                    }
                                    showShapeType = false
                                },
                                trailing = {
                                    if (it == ShapeType.SmoothCornerShape) {
                                        ErrorBadge(content = { Text("Expr") })
                                    }
                                }
                            )
                        }
                    }
                )
            }
        )

        CustomizeColumnItem(

            overlineText = "ShapeRadius",
            titleText = "$shapeRadius",
            onClick = {
                showShapeRadius = true
            },
            trailing = {
                DropDown(
                    borderStroke = BorderStroke(
                        width = 2.dp,
                        color = KoreTheme.colorScheme.backGroundVariant
                    ),
                    expanded = showShapeRadius,
                    onDismissRequest = {
                        showShapeRadius = false
                    },
                    content = {
                        ShapeRadius.entries.forEach {
                            DropDownItem(
                                onClick = {
                                    showShapeRadius = false
                                    viewModel.changeShapeRadius(shapeRadius = it, shapeType = shapeType)
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
        CustomizeColumnItem(
            overlineText = "Spacing",
            titleText = sizes.name,
            onClick = {
                showSizes = true
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
                                    when (it) {
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


@Composable
fun CustomizeColumnItem(
    overlineText : String,
    titleText : String,
    onClick : ()-> Unit,
    trailing : @Composable ()-> Unit,
    enabled : Boolean = true,
){
    ListTile(

        colors = ListTileDefaults.defaultListTileColors(
            containerColor =if (enabled)  KoreTheme.colorScheme.surface else KoreTheme.colorScheme.disabled,
            overlineContentColor = if (enabled)  KoreTheme.colorScheme.onBackGroundVariant else KoreTheme.colorScheme.onDisabled,
            titleContentColor =  if (enabled)  KoreTheme.colorScheme.onBackGround else KoreTheme.colorScheme.onDisabled,
        ),

        modifier = Modifier
            .clip(KoreTheme.shapes.md)
            .border(
                width = 2.dp,
                shape = KoreTheme.shapes.md,
                color = if (enabled) KoreTheme.colorScheme.backGroundVariant else KoreTheme.colorScheme.disabled
            ).clickable(
                onClick = onClick,
                enabled = enabled
            ),
        overline = {
            Text(overlineText)
        },
        title = {
            Text(titleText)
        },
        trailing = {
            trailing()
        }

    )
}