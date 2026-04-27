//[korelibrary](../../index.md)/[com.dev.korelibrary.components.badge](index.md)/[SecondaryBadge](-secondary-badge.md)

# SecondaryBadge

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [SecondaryBadge](-secondary-badge.md)(content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = KoreTheme.shapes.lg, badgeSizes: [BadgeSizes](-badge-sizes/index.md) = BadgeDefaults.defaultBadgeSize(), leadingIcon: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null, trailingIcon: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null, enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, badgeColors: [BadgeColors](-badge-colors/index.md) = BadgeDefaults.secondaryBadgeColors())

SecondaryBadge is a badge composable designed to highlight success action or status indicator

#### Parameters

common

| | |
|---|---|
| content | the main composable content to be displayed within the SecondaryBadge |
| modifier | is the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to the badge |
| shape | the shape of the SecondaryBadge [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| badgeSizes | the content sizes and padding values for the SecondaryBadge [BadgeSizes](-badge-sizes/index.md) |
| leadingIcon | an optional [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) appearing before the main content |
| trailingIcon | an optional [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) appearing after the main content |
| enabled | the visual state of the SecondaryBadge [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| badgeColors | the colors of the SecondaryBadge [BadgeColors](-badge-colors/index.md) |