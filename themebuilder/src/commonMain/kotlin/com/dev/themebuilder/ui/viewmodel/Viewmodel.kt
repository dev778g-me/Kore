package com.dev.themebuilder.ui.viewmodel

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.korelibrary.themes.KoreColorScheme
import com.dev.korelibrary.themes.KoreDefaults
import com.dev.korelibrary.themes.KoreShapes
import com.dev.korelibrary.themes.KoreSizes
import com.dev.themebuilder.ui.model.ColorEntry
import com.dev.themebuilder.ui.model.ComplementaryColors
import com.dev.themebuilder.ui.model.ExportUtils
import com.dev.themebuilder.ui.model.balancedSizes
import com.dev.themebuilder.ui.model.NeutralColors
import com.dev.themebuilder.ui.model.PrimaryColors
import com.dev.themebuilder.ui.model.Sizes
import com.dev.themebuilder.ui.model.SuccessErrorColors
import com.dev.themebuilder.ui.model.airySizes
import com.dev.themebuilder.ui.model.compactSizes
import com.dev.themebuilder.ui.model.neutralColorsList
import com.dev.themebuilder.ui.model.primaryColorsList
import com.dev.themebuilder.ui.model.ShapeType
import com.dev.themebuilder.ui.model.lowContrastColor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ThemeViewModel : ViewModel() {


    /**
     * the current values of the themedata
     */
    private var _currentPrimaryColor = MutableStateFlow(primaryColorsList[8])
    val currentPrimaryColor : StateFlow<ColorEntry> = _currentPrimaryColor

    private var _currentNeutralColor = MutableStateFlow(neutralColorsList[3])
    val currentNeutralColor : StateFlow<ColorEntry> = _currentNeutralColor

    private var _currentComplementaryColor = MutableStateFlow(primaryColorsList[8])
    val currentComplementaryColor : StateFlow<ColorEntry> = _currentComplementaryColor



    private var _currentSize = MutableStateFlow(Sizes.Balanced)
    val currentSize : StateFlow<Sizes> = _currentSize

    private var _currentShape = MutableStateFlow(ShapeType.RoundedRectangle)
    var currentShape : StateFlow<ShapeType> = _currentShape


    /**
     *  the states that change the theme
     */
    private var _lightPrimaryColors = MutableStateFlow(PrimaryColors())
    val lightPrimaryColors : StateFlow<PrimaryColors> = _lightPrimaryColors



    private var _lightComplementaryColors = MutableStateFlow(ComplementaryColors())
    val lightComplementaryColors : StateFlow<ComplementaryColors> = _lightComplementaryColors



    private var _lightNeutralColors = MutableStateFlow(NeutralColors())
    val lightNeutralColors : StateFlow<NeutralColors> = _lightNeutralColors


    private var _lightSuccessErrorColors = MutableStateFlow(SuccessErrorColors())
    val lightSuccessErrorColors : StateFlow<SuccessErrorColors> = _lightSuccessErrorColors


    // fun to provide the light primary colors
    fun provideLightPrimaryColors(
        seedColor: ColorEntry
    ) {
        val lightScale = seedColor.lightScale

        val isLowContrast = seedColor in lowContrastColor

        if (isLowContrast) {
            val primaryLightColors = _currentLightColorScheme.value.copy(
                primary = lightScale.step9,
                onPrimary = lightScale.step12,
                primaryContainer = lightScale.step6,
                onPrimaryContainer = lightScale.step11,
            )
            _currentLightColorScheme.value = primaryLightColors

        } else {
            val primaryLightColors = _currentLightColorScheme.value.copy(
                primary = lightScale.step9,
                onPrimary = lightScale.step1,
                primaryContainer = lightScale.step6,
                onPrimaryContainer = lightScale.step10,
            )
            _currentLightColorScheme.value = primaryLightColors
        }


    }

// fun to provide the light complementary colors depending on the primary
    fun provideLightComplementaryColors(
        seedColor: ColorEntry
    ){

        val lightScheme = seedColor.complementaryLight!!
        val complementaryLightColors = _currentLightColorScheme.value.copy(
            complementary = lightScheme.step9,
            onComplementary = lightScheme.step1,
            complementaryContainer = lightScheme.step6,
            onComplementaryContainer = lightScheme.step10
        )
        _currentLightColorScheme.value = complementaryLightColors
    }


    // fun to provide the light compl
    fun provideIndividualLightComplementaryColors(

        seedColor: ColorEntry
    ){
        val lightScheme = seedColor.lightScale
        val complementaryLightColors = _currentLightColorScheme.value.copy(
            complementary = lightScheme.step9,
            onComplementary = lightScheme.step1,
            complementaryContainer = lightScheme.step6,
            onComplementaryContainer = lightScheme.step10
        )
        _currentLightColorScheme.value = complementaryLightColors
    }


    // funt to provide the light neutral colors 
    fun provideLightNeutralColors(
        seedColor: ColorEntry
    ) {
        val lightScale = seedColor.lightScale
        val neutralLightColors =  _currentLightColorScheme.value.copy(
            background = lightScale.step4,
            onBackGround = lightScale.step12,
            disabled = lightScale.step5,
            onDisabled = lightScale.step8,
            backGroundVariant = lightScale.step7,
            onBackGroundVariant = lightScale.step10,
            surface = lightScale.step3,
            onSurface = lightScale.step11,
            surfaceBright = lightScale.step1,
            onSurfaceBright = lightScale.step12,
            transparent = Color.Transparent
        )
        _currentLightColorScheme.value = neutralLightColors
    }

    fun provideLightSuccessErrorColors(
      seedColor: ColorEntry
    ){
        val lightScale = seedColor.lightScale
        val successErrorLightColors = SuccessErrorColors(
            success = lightScale.step9,
            onSuccess = lightScale.step2,
            error = lightScale.step9,
            onError = lightScale.step2
        )
        _lightSuccessErrorColors.value = successErrorLightColors
    }




    private val darkColorScheme = KoreDefaults.defaultDarkColorScheme


    private var _darkPrimaryColors = MutableStateFlow(PrimaryColors(
        primary = darkColorScheme.primary,
        onPrimary = darkColorScheme.onPrimary,
        primaryContainer = darkColorScheme.primaryContainer,
        onPrimaryContainer = darkColorScheme.onPrimaryContainer,
    ))
    val darkPrimaryColors : StateFlow<PrimaryColors> = _darkPrimaryColors

    private var _darkComplementaryColors = MutableStateFlow(ComplementaryColors(
        complementary = darkColorScheme.complementary,
        onComplementary = darkColorScheme.onComplementary,
        complementaryContainer = darkColorScheme.complementaryContainer,
        onComplementaryContainer = darkColorScheme.onComplementaryContainer
    ))
    val darkComplementaryColors : StateFlow<ComplementaryColors> = _darkComplementaryColors


    private var _darkNeutralColors = MutableStateFlow(NeutralColors(
        backGround = darkColorScheme.background,
        onBackGround = darkColorScheme.onBackGround,
        backGroundVariant = darkColorScheme.backGroundVariant,
        onBackGroundVariant = darkColorScheme.onBackGroundVariant,
        surface = darkColorScheme.surface,
        onSurface = darkColorScheme.onSurface,
        surfaceBright = darkColorScheme.surfaceBright,
        onSurfaceBright = darkColorScheme.onSurfaceBright,
        disabled = darkColorScheme.disabled,
        onDisabled = darkColorScheme.onDisabled,
        transParentColor = darkColorScheme.transparent,
    ))
    val darkNeutralColors : StateFlow<NeutralColors> = _darkNeutralColors



    private var _darkSuccessErrorColors = MutableStateFlow(SuccessErrorColors(
        success = darkColorScheme.success,
        onSuccess = darkColorScheme.onSuccess,
        error = darkColorScheme.error,
        onError = darkColorScheme.onError
    ))
    val darkSuccessErrorColors : StateFlow<SuccessErrorColors> = _darkSuccessErrorColors


    fun provideDarkPrimaryColors(
        seedColor: ColorEntry
    ) {
        val darkScale = seedColor.darkScale

        val isLowContrast = seedColor in lowContrastColor
        if (isLowContrast) {
            val primaryDarkColors = _currentDarkColorScheme.value.copy(
                primary = darkScale.step9,
                onPrimary = darkScale.step1,
                primaryContainer = darkScale.step3,
                onPrimaryContainer = darkScale.step10,
            )
            _currentDarkColorScheme.value = primaryDarkColors
        } else {
            val primaryDarkColors = _currentDarkColorScheme.value.copy(
                primary = darkScale.step9,
                onPrimary = darkScale.step12,
                primaryContainer = darkScale.step3,
                onPrimaryContainer = darkScale.step10,
            )
            _currentDarkColorScheme.value = primaryDarkColors
        }


    }


    fun provideDarkComplementaryColors(
        seedColor: ColorEntry
    ){
        val darkScale = seedColor.complementaryDark!!
        val complementaryDarkColors =  _currentDarkColorScheme.value.copy(
            complementary = darkScale.step9,
            onComplementary = darkScale.step12,
            complementaryContainer = darkScale.step3,
            onComplementaryContainer = darkScale.step10
        )
       _currentDarkColorScheme.value = complementaryDarkColors
    }

    fun provideIndividualDarkComplementaryColors(
        seedColor: ColorEntry
    ){
        val darkScale = seedColor.darkScale
        val complementaryDarkColors =  _currentDarkColorScheme.value.copy(
            complementary = darkScale.step9,
            onComplementary = darkScale.step12,
            complementaryContainer = darkScale.step3,
            onComplementaryContainer = darkScale.step10
        )
        _currentDarkColorScheme.value = complementaryDarkColors
    }

    
    fun provideDarkNeutralColors(
        seedColor: ColorEntry
    ) {
        val darkScale = seedColor.darkScale
        val neutralDarkColors = _currentDarkColorScheme.value.copy(
            background = darkScale.step1,
            onBackGround = darkScale.step12,
            disabled = darkScale.step3,
            onDisabled = darkScale.step8,
            backGroundVariant = darkScale.step5,
            onBackGroundVariant = darkScale.step11,
            surface = darkScale.step2,
            onSurface = darkScale.step11,
            surfaceBright = darkScale.step3,
            onSurfaceBright = darkScale.step12,
            transparent = Color.Transparent
        )
        _currentDarkColorScheme.value = neutralDarkColors
    }

    fun provideDarkSuccessErrorColors(
        seedColor: ColorEntry
    ) {
        val darkScale = seedColor.darkScale
        val successErrorDarkColors = SuccessErrorColors(
            success = darkScale.step9,
            onSuccess = darkScale.step12,
            error = darkScale.step9,
            onError = darkScale.step12
        )
        _darkSuccessErrorColors.value = successErrorDarkColors
    }




    fun providePrimary(seedColor: ColorEntry){
        _currentPrimaryColor.value = seedColor
        provideDarkPrimaryColors(seedColor = seedColor)
        provideLightPrimaryColors(seedColor = seedColor)
        _currentComplementaryColor.value = seedColor
        provideDarkComplementaryColors(seedColor = seedColor)
        provideLightComplementaryColors(seedColor = seedColor)
    }


    fun provideComplementary(
        seedColor: ColorEntry
    ){
        _currentComplementaryColor.value = seedColor
       provideIndividualLightComplementaryColors(seedColor)
        provideIndividualDarkComplementaryColors(seedColor)
    }


    fun provideNeutrals(seedColor: ColorEntry){
        _currentNeutralColor.value = seedColor
       provideLightNeutralColors(seedColor = seedColor)
        provideDarkNeutralColors(seedColor = seedColor)
    }

    private var _provideShape = MutableStateFlow(ShapeType.RoundedRectangle)
    val provideShape: StateFlow<ShapeType> = _provideShape

    fun changeRoundedRect(){
        _provideShape.value = ShapeType.RoundedRectangle
    }

    fun changeSquircle(){
        _provideShape.value = ShapeType.Squircle
    }


    private var _provideSizes = MutableStateFlow(balancedSizes)
    val provideSizes : StateFlow<KoreSizes> = _provideSizes


    /**
     * the current dark and light colorscheme
     */



    private val _currentLightColorScheme = MutableStateFlow(
        KoreDefaults.defaultLightColorScheme
    )

    // Expose as a read-only StateFlow for the UI to observe
    val currentLightColorScheme: StateFlow<KoreColorScheme> = _currentLightColorScheme

    private val _currentDarkColorScheme = MutableStateFlow(
        KoreDefaults.defaultDarkColorScheme
    )
    val currentDarkColorScheme: StateFlow<KoreColorScheme> = _currentDarkColorScheme

    fun changeToAiry(){
        _provideSizes.value = airySizes
        _currentSize.value = Sizes.Airy
    }

    fun changeToCompact(){
        _provideSizes.value = compactSizes
        _currentSize.value = Sizes.Compact
    }

    fun changeToBalanced(){
        _provideSizes.value = balancedSizes
        _currentSize.value = Sizes.Balanced
    }


    /**
     * Theme Exporting
     */

    private var _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    fun makeFile(
        lightColorScheme: KoreColorScheme,
        darkColorScheme: KoreColorScheme,
        currentSizes: KoreSizes,
        currentShapes: KoreShapes,
    ) {
        _isLoading.value = true
        ExportUtils.openSaveFile { selectedFile ->
            if (selectedFile != null) {
                val themeCode = ExportUtils.exportTheme(
                    darkColorScheme = darkColorScheme,
                    lightColorScheme = lightColorScheme,
                    currentSizes = currentSizes,
                    currentShapes = currentShapes
                )
                viewModelScope.launch {
                    try {
                        selectedFile.writeText(themeCode)

                    } catch (e: Exception) {
                        System.err.println(e.message)
                    }
                }
            } else {
                println("export canceled")
            }

        }
        _isLoading.value = false

    }






}