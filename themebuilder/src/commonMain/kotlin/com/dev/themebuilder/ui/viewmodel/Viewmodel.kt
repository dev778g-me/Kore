package com.dev.themebuilder.ui.viewmodel

import androidx.lifecycle.ViewModel
import co.touchlab.kermit.Logger
import com.dev.kore.themes.KoreColorScheme
import com.dev.kore.themes.KoreDefaults
import com.dev.kore.themes.KoreShapes
import com.dev.kore.themes.KoreSizes
import com.dev.kore.themes.colors.RadixColors
import com.dev.kore.themes.colors.TailwindColors
import com.dev.kore.themes.colors.blend
import com.dev.themebuilder.ui.models.ColorEntry
import com.dev.themebuilder.ui.models.balancedSizes
import com.dev.themebuilder.ui.models.PrimaryColorSource
import com.dev.themebuilder.ui.models.ShapeRadius
import com.dev.themebuilder.ui.models.Sizes
import com.dev.themebuilder.ui.models.airySizes
import com.dev.themebuilder.ui.models.compactSizes
import com.dev.themebuilder.ui.models.neutralColorsList
import com.dev.themebuilder.ui.models.primaryColorsList
import com.dev.themebuilder.ui.models.ShapeType
import com.dev.themebuilder.ui.models.TailWindColorEntry
import com.dev.themebuilder.ui.models.getLargeShapes
import com.dev.themebuilder.ui.models.getMediumShapes
import com.dev.themebuilder.ui.models.getSharpShapes
import com.dev.themebuilder.ui.models.getSmallShapes
import com.dev.themebuilder.ui.models.lowContrastColor
import com.dev.themebuilder.ui.models.tailWindPrimaryColorsList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ThemeViewModel : ViewModel() {


    /**
     * the current values of the themedata
     */


    private var _currentPrimaryColorSource = MutableStateFlow(value = PrimaryColorSource.Radix)
    val currentPrimaryColorSource : StateFlow<PrimaryColorSource> = _currentPrimaryColorSource

    // default radix primary
    private var _currentPrimaryColor = MutableStateFlow(primaryColorsList[8])
    val currentPrimaryColor : StateFlow<ColorEntry> = _currentPrimaryColor

    // tailwind primary
    private var _currentTailwindPrimaryColor = MutableStateFlow(tailWindPrimaryColorsList[8])
    val currentTailwindPrimaryColor : StateFlow<TailWindColorEntry> = _currentTailwindPrimaryColor

    private var _currentNeutralColor = MutableStateFlow(neutralColorsList[3])
    val currentNeutralColor : StateFlow<ColorEntry> = _currentNeutralColor

    private var _currentComplementaryColor = MutableStateFlow(primaryColorsList[1])
    val currentComplementaryColor : StateFlow<ColorEntry> = _currentComplementaryColor

    private var _currentTailwindComplementaryColor = MutableStateFlow(tailWindPrimaryColorsList[0])
    val currentTailwindComplementaryColor : StateFlow<TailWindColorEntry> = _currentTailwindComplementaryColor



    private var _currentSize = MutableStateFlow(Sizes.Balanced)
    val currentSize : StateFlow<Sizes> = _currentSize

    private var _currentShapeType = MutableStateFlow(ShapeType.RoundedRectangle)
    var currentShapeType : StateFlow<ShapeType> = _currentShapeType



    // fun to provide the light primary colors
    fun provideLightPrimaryColors(
        seedColor: ColorEntry,
        tailWindSeedColor: TailWindColorEntry,
        colorSource: PrimaryColorSource
    ) {


        if (colorSource == PrimaryColorSource.Tailwind) {
            Logger.i {
                "the current primary source is $colorSource"
            }
            val colorScale = tailWindSeedColor.colorScale

            val primaryLightColor = _currentLightColorScheme.value.copy(
                primary = colorScale.swatch600,
                onPrimary = colorScale.swatch50,
                primaryContainer = colorScale.swatch300,
                onPrimaryContainer = colorScale.swatch900,
            )

            _currentLightColorScheme.value = primaryLightColor
        } else {
            Logger.i {
                "the current primary source is $colorSource"
            }
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
                    onPrimary =  lightScale.step1.blend(blendColor = RadixColors.White.white),
                    primaryContainer = lightScale.step6,
                    onPrimaryContainer = lightScale.step10,
                )
                _currentLightColorScheme.value = primaryLightColors
            }
        }
        }

// fun to provide the light complementary colors depending on the primary
fun provideLightComplementaryColors(
    seedColor: ColorEntry,
    tailWindSeedColor: TailWindColorEntry = tailWindPrimaryColorsList[0],
    colorSource: PrimaryColorSource,
) {
    val isTailwind = colorSource == PrimaryColorSource.Tailwind

    if (isTailwind) {
        val colorScale = tailWindSeedColor.complementaryScale!!
        val complementaryLightColors = _currentLightColorScheme.value.copy(
            complementary = colorScale.swatch600,
            onComplementary = colorScale.swatch50,
            complementaryContainer = colorScale.swatch300,
            onComplementaryContainer = colorScale.swatch900,
        )
        _currentLightColorScheme.value = complementaryLightColors
    } else {
        val lightScheme = seedColor.complementaryLight!!
        val complementaryLightColors = _currentLightColorScheme.value.copy(
            complementary = lightScheme.step9,
            onComplementary = lightScheme.step1.blend(blendColor = RadixColors.White.white),
            complementaryContainer = lightScheme.step6,
            onComplementaryContainer = lightScheme.step10
        )
        _currentLightColorScheme.value = complementaryLightColors
    }
}

    // fun to provide the light compl
    fun provideIndividualLightComplementaryColors(
        seedColor: ColorEntry,
        tailWindSeedColor: TailWindColorEntry = tailWindPrimaryColorsList[8],
        colorSource: PrimaryColorSource
    ){

        if (colorSource == PrimaryColorSource.Tailwind) {
            val colorScale = tailWindSeedColor.colorScale
            val complementaryLightColors = _currentLightColorScheme.value.copy(
                complementary = colorScale.swatch600,
                onComplementary = colorScale.swatch50,
                complementaryContainer = colorScale.swatch300,
                onComplementaryContainer = colorScale.swatch900
            )
            _currentLightColorScheme.value = complementaryLightColors
        } else {
            val lightScheme = seedColor.lightScale
            val complementaryLightColors = _currentLightColorScheme.value.copy(
                complementary = lightScheme.step9,
                onComplementary = lightScheme.step1.blend(blendColor = RadixColors.White.white),
                complementaryContainer = lightScheme.step6,
                onComplementaryContainer = lightScheme.step10
            )
            _currentLightColorScheme.value = complementaryLightColors
        }
    }


    /**
     * function to provide success error color
     * by default for both the color source it is green and  red
     * for radix I can switch to grass it looks better also removing it from the primary list
     */
    fun provideSuccessColor(
        colorSource: PrimaryColorSource
    ){
        if (colorSource == PrimaryColorSource.Tailwind) {
            val lightSuccessErrorColors = _currentLightColorScheme.value.copy(
                success = TailwindColors.Green.swatch600,
                onSuccess = TailwindColors.Green.swatch50,
                error = TailwindColors.Red.swatch600,
                onError = TailwindColors.Red.swatch50,
            )
            val darkSuccessErrorColors = _currentDarkColorScheme.value.copy(
                success = TailwindColors.Green.swatch600,
                onSuccess = TailwindColors.Green.swatch50,
                error = TailwindColors.Red.swatch600,
                onError = TailwindColors.Red.swatch50,
            )
            _currentLightColorScheme.value = lightSuccessErrorColors
            _currentDarkColorScheme.value = darkSuccessErrorColors
        } else {
            val lightSuccessErrorColors = _currentLightColorScheme.value.copy(
                success = RadixColors.Grass.light.step9,
                onSuccess = RadixColors.Grass.light.step1.blend(blendColor = RadixColors.White.white),
                error = RadixColors.Red.light.step9,
                onError = RadixColors.Red.light.step1.blend(blendColor = RadixColors.White.white)
            )

            val darkSuccessErrorColors = _currentDarkColorScheme.value.copy(
                success = RadixColors.Grass.dark.step9,
                onSuccess = RadixColors.Grass.dark.step12.blend(RadixColors.White.white),
                error = RadixColors.Red.dark.step9,
                onError = RadixColors.Red.dark.step12.blend(blendColor = RadixColors.White.white)
            )
            _currentLightColorScheme.value = lightSuccessErrorColors
            _currentDarkColorScheme.value = darkSuccessErrorColors

        }
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
            transparent = lightScale.step1.copy(alpha = 0f)
        )
        _currentLightColorScheme.value = neutralLightColors
    }














    fun provideDarkPrimaryColors(
        seedColor: ColorEntry,
        tailWindSeedColor: TailWindColorEntry,
        colorSource: PrimaryColorSource
    ) {

        if (colorSource == PrimaryColorSource.Tailwind) {

            val colorScale = tailWindSeedColor.colorScale

            val primaryDarkColors = _currentDarkColorScheme.value.copy(
                primary = colorScale.swatch600,
                onPrimary = colorScale.swatch50,
                primaryContainer = colorScale.swatch950,
                onPrimaryContainer = colorScale.swatch200
            )

            _currentDarkColorScheme.value = primaryDarkColors

        } else {
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
                    onPrimary = darkScale.step12.blend(blendColor = RadixColors.White.white),
                    primaryContainer = darkScale.step3,
                    onPrimaryContainer = darkScale.step10,
                )
                _currentDarkColorScheme.value = primaryDarkColors
            }
        }

    }


    fun provideDarkComplementaryColors(
        seedColor: ColorEntry,
        tailWindSeedColor: TailWindColorEntry = tailWindPrimaryColorsList[0],
        colorSource: PrimaryColorSource,
    ){
        if (colorSource == PrimaryColorSource.Tailwind){
            val colorScale = tailWindSeedColor.complementaryScale!!

            Logger.i{
                "The Complementary scale ins $colorScale"
            }
            val complementaryDarkColors = _currentDarkColorScheme.value.copy(
                complementary = colorScale.swatch600,
                onComplementary = colorScale.swatch50,
                complementaryContainer = colorScale.swatch950,
                onComplementaryContainer = colorScale.swatch200
            )
            _currentDarkColorScheme.value = complementaryDarkColors
        } else {

        val darkScale = seedColor.complementaryDark!!
        val complementaryDarkColors =  _currentDarkColorScheme.value.copy(
            complementary = darkScale.step9,
            onComplementary = darkScale.step12.blend(RadixColors.White.white),
            complementaryContainer = darkScale.step3,
            onComplementaryContainer = darkScale.step10
        )
       _currentDarkColorScheme.value = complementaryDarkColors
    }}

    fun provideIndividualDarkComplementaryColors(
        seedColor: ColorEntry,
        tailWindSeedColor: TailWindColorEntry = tailWindPrimaryColorsList[8],
        colorSource: PrimaryColorSource
    ){

        if (colorSource == PrimaryColorSource.Tailwind){
            val colorSource = tailWindSeedColor.colorScale

            val complementaryDarkColors = _currentDarkColorScheme.value.copy(
                complementary = colorSource.swatch600,
                onComplementary = colorSource.swatch50,
                complementaryContainer = colorSource.swatch950,
                onComplementaryContainer = colorSource.swatch200
            )
            _currentDarkColorScheme.value = complementaryDarkColors

        } else {

        val darkScale = seedColor.darkScale
        val complementaryDarkColors =  _currentDarkColorScheme.value.copy(
            complementary = darkScale.step9,
            onComplementary = darkScale.step12.blend(RadixColors.White.white),
            complementaryContainer = darkScale.step3,
            onComplementaryContainer = darkScale.step10
        )
        _currentDarkColorScheme.value = complementaryDarkColors
    }}

    
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
            transparent = darkScale.step1 .copy(alpha = 0f)
        )
        _currentDarkColorScheme.value = neutralDarkColors
    }






    fun providePrimary(
        seedColor: ColorEntry,
        tailWindSeedColor: TailWindColorEntry = tailWindPrimaryColorsList[8],
        colorSource: PrimaryColorSource
    ) {

        val isTailwind = colorSource == PrimaryColorSource.Tailwind

        if (isTailwind) {
            _currentTailwindPrimaryColor.value = tailWindSeedColor
        }

        _currentPrimaryColor.value = seedColor

        // dark primary
        provideDarkPrimaryColors(
            seedColor = seedColor,
            tailWindSeedColor = tailWindSeedColor,
            colorSource = colorSource
        )
        // light primary
        provideLightPrimaryColors(
            seedColor = seedColor,
            tailWindSeedColor = tailWindSeedColor,
            colorSource = colorSource
        )
        // complementary
        _currentComplementaryColor.value = seedColor
        if (isTailwind) _currentTailwindComplementaryColor.value = tailWindSeedColor


       //  dark complementary
        provideDarkComplementaryColors(
            seedColor = seedColor,
            tailWindSeedColor = tailWindSeedColor,
            colorSource = colorSource
        )
        // light complementary
        provideLightComplementaryColors(
            seedColor = seedColor,
            tailWindSeedColor = tailWindSeedColor,
            colorSource = colorSource
        )
    }


    fun provideComplementary(
        seedColor: ColorEntry,
        tailWindSeedColor: TailWindColorEntry = tailWindPrimaryColorsList[8],
        colorSource: PrimaryColorSource
    ){
        if (colorSource == PrimaryColorSource.Tailwind){
            _currentTailwindComplementaryColor.value = tailWindSeedColor
        }
        _currentComplementaryColor.value = seedColor
        provideIndividualLightComplementaryColors(seedColor, tailWindSeedColor = tailWindSeedColor, colorSource = colorSource)
        provideIndividualDarkComplementaryColors(seedColor, tailWindSeedColor = tailWindSeedColor, colorSource = colorSource)
    }


    fun provideNeutrals(seedColor: ColorEntry){
        _currentNeutralColor.value = seedColor
       provideLightNeutralColors(seedColor = seedColor)
        provideDarkNeutralColors(seedColor = seedColor)
    }

    private var _provideShapeType = MutableStateFlow(ShapeType.RoundedRectangle)
    val provideShapeType: StateFlow<ShapeType> = _provideShapeType

    fun changeRoundedRect(){
        _provideShapeType.value = ShapeType.RoundedRectangle
    }

    fun changeSquircle(){
        _provideShapeType.value = ShapeType.SmoothCornerShape
    }

    fun changePrimaryColorSource(primaryColorSource: PrimaryColorSource){
        _currentPrimaryColorSource.value = primaryColorSource
    }

    private var _provideSizes = MutableStateFlow(balancedSizes)
    val provideSizes : StateFlow<KoreSizes> = _provideSizes


    /**
     * the current dark and light colorscheme
     */



    private val _currentLightColorScheme = MutableStateFlow(
        KoreDefaults.defaultLightColorScheme
    )

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



     private var _shapeRadius = MutableStateFlow<ShapeRadius>(ShapeRadius.Medium)
     val shaprRadius : StateFlow<ShapeRadius> = _shapeRadius


    private var _currentShape = MutableStateFlow(KoreDefaults.defaultShapes)
    val currentShape : StateFlow<KoreShapes> = _currentShape

    fun changeShapeRadius(
        shapeRadius: ShapeRadius,
        shapeType: ShapeType
    ){
        _shapeRadius.value = shapeRadius

        when (shapeRadius) {
            ShapeRadius.Sharp -> _currentShape.value = getSharpShapes()
            ShapeRadius.Small -> _currentShape.value =
                getSmallShapes(shapeType = shapeType)

            ShapeRadius.Medium -> _currentShape.value =
                getMediumShapes(shapeType = shapeType)

            ShapeRadius.Large -> _currentShape.value =
                getLargeShapes(shapeType = shapeType)

            ShapeRadius.Circle -> _currentShape.value =
                getLargeShapes(shapeType = shapeType)
        }
    }

    /**
     * Theme Exporting
     */

    private var _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
//    fun makeFile(
//        lightColorScheme: KoreColorScheme,
//        darkColorScheme: KoreColorScheme,
//        currentSizes: KoreSizes,
//        currentShapes: KoreShapes,
//    ) {
//        _isLoading.value = true
//        ExportUtils.openSaveFile { selectedFile ->
//            if (selectedFile != null) {
//                val themeCode = ExportUtils.exportTheme(
//                    darkColorScheme = darkColorScheme,
//                    lightColorScheme = lightColorScheme,
//                    currentSizes = currentSizes,
//                    currentShapes = currentShapes
//                )
//                viewModelScope.launch {
//                    try {
//                        selectedFile.writeText(themeCode)
//
//                    } catch (e: Exception) {
//                        System.err.println(e.message)
//                    }
//                }
//            } else {
//                println("export canceled")
//            }
//
//        }
//        _isLoading.value = false
//
//    }






}