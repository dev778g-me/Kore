package com.dev.themebuilder.ui.view.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.window.core.layout.WindowSizeClass
import com.dev.korelibrary.components.appbar.Appbar
import com.dev.korelibrary.components.buttons.GhostIconButton
import com.dev.korelibrary.components.buttons.SecondaryButton
import com.dev.korelibrary.components.card.Card
import com.dev.korelibrary.components.icon.Icon
import com.dev.korelibrary.components.scaffold.Scaffold
import com.dev.korelibrary.components.Text
import com.dev.korelibrary.components.loadingIndicator.CircularLoadingIndicator
import com.dev.korelibrary.themes.KoreDefaults
import com.dev.themebuilder.ui.model.ExportUtils
import com.dev.themebuilder.ui.model.ShapeType
import com.dev.themebuilder.ui.view.components.AllShowCase
import com.dev.themebuilder.ui.view.components.CustomizeColumn
import com.dev.themebuilder.ui.view.components.PhoneScreen
import com.dev.themebuilder.ui.viewmodel.ThemeViewModel
import icons.PhIcons
import icons.duotone.ExportDuotone
import icons.duotone.NutDuotone
import icons.duotone.SunDuotone
import icons.regular.Export

@Composable
fun HomeScreen (
    modifier: Modifier = Modifier,
    onClick : ()-> Unit,
    isDark: Boolean,
){

    val currentWindowSizeClass =
        currentWindowAdaptiveInfo(supportLargeAndXLargeWidth = true).windowSizeClass
    val viewModel: ThemeViewModel = viewModel { ThemeViewModel() }

    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val currentLightColorScheme by viewModel.currentLightColorScheme.collectAsStateWithLifecycle()
    val currentDarkColorScheme by viewModel.currentDarkColorScheme.collectAsStateWithLifecycle()
    val currentSizes by viewModel.provideSizes.collectAsStateWithLifecycle()
    val currentShape by viewModel.provideShape.collectAsStateWithLifecycle()
    Scaffold(

        appBar = {
            Appbar(

                navigationIcon = {
                    GhostIconButton(
                        onClick = {}
                    ){
                        Icon(
                            imageVector = PhIcons.Duotone.NutDuotone,
                            contentDescription = ""
                        )
                    }
                },
                appBarAction = {

                      GhostIconButton(
                          onClick = {
                              onClick()
                          }
                      ){
                          Icon(
                              imageVector = PhIcons.Duotone.SunDuotone,
                              contentDescription = ""
                          )
                      }
                    Spacer(
                        modifier = Modifier.width(12.dp)
                    )
                      SecondaryButton(
                          enabled = !isLoading,
                          onClick = {
                              viewModel.makeFile(
                                  lightColorScheme = currentLightColorScheme,
                                  darkColorScheme = currentDarkColorScheme,
                                  currentSizes = currentSizes,
                                  currentShapes = if (currentShape == ShapeType.Squircle) KoreDefaults.defaultSquircleShapes else KoreDefaults.defaultShapes
                              )
                          }
                      ) {
                          AnimatedContent(
                              targetState = isLoading
                          ) {
                          if (it) {
                              CircularLoadingIndicator(
                                  modifier = Modifier.padding(end = 4.dp).size(24.dp),
                                  thickness = 2.dp
                              )
                          } else {
                              Icon(
                                  imageVector = PhIcons.Regular.Export,
                                  contentDescription = "",
                                  modifier = Modifier.padding(end = 4.dp)
                              )
                          }
                          }
                          Text("Export")
                      }

                },
               // navigationIconAlignment = Alignment.Top,
                title = {
                    Text("Kore")
                }
            )
        }
    ){ contentPadding ->
        Column(
            modifier = modifier.fillMaxSize()
                .padding(paddingValues = contentPadding)
                .padding(
                    all = 16.dp
                )
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxHeight(),
                ) {
                    CustomizeColumn(isDark = isDark)
                }

                if (currentWindowSizeClass.isAtLeastBreakpoint(
                        widthDpBreakpoint = WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND,
                        heightDpBreakpoint = WindowSizeClass.HEIGHT_DP_EXPANDED_LOWER_BOUND
                    )
                ) {
                    PhoneScreen()
                } else {
                    AllShowCase()
                }


            }

        }
    }
}