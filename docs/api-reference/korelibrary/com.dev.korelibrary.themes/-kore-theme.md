//[korelibrary](../../index.md)/[com.dev.korelibrary.themes](index.md)/[KoreTheme](-kore-theme.md)

# KoreTheme

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [KoreTheme](-kore-theme.md)(typography: [KoreTypography](-kore-typography/index.md) = KoreDefaults.defaultTypography,<br>&nbsp;&nbsp;&nbsp;&nbsp;sizes: [KoreSizes](-kore-sizes/index.md) = defaultSizes,<br>&nbsp;&nbsp;&nbsp;&nbsp;shapes: [KoreShapes](-kore-shapes/index.md) = defaultShapes,<br>&nbsp;&nbsp;&nbsp;&nbsp;colorScheme: [KoreColorScheme](-kore-color-scheme/index.md) = defaultLightColorScheme,<br>&nbsp;&nbsp;&nbsp;&nbsp;ripple: [IndicationNodeFactory](https://developer.android.com/reference/kotlin/androidx/compose/foundation/IndicationNodeFactory.html) = koreRipple(colorScheme.onBackGround),<br>&nbsp;&nbsp;&nbsp;&nbsp;content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))