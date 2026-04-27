//[korelibrary](../../index.md)/[com.dev.korelibrary.components.badge](index.md)/[SuccessBadge](-success-badge.md)

# SuccessBadge

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [SuccessBadge](-success-badge.md)(content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = KoreTheme.shapes.lg,<br>&nbsp;&nbsp;&nbsp;&nbsp;badgeSizes: [BadgeSizes](-badge-sizes/index.md) = BadgeDefaults.defaultBadgeSize(),<br>&nbsp;&nbsp;&nbsp;&nbsp;leadingIcon: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;trailingIcon: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true,<br>&nbsp;&nbsp;&nbsp;&nbsp;badgeColors: [BadgeColors](-badge-colors/index.md) = BadgeDefaults.successBadgeColors())

SuccessBadge is a badge composable designed to highlight success action or status indicator

#### Parameters

common

| | |
|---|---|
| content | the main composable content to be displayed within the SuccessBadge |
| modifier | is the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to the badge |
| shape | the shape of the SuccessBadge [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| badgeSizes | the content sizes and padding values for the SuccessBadge [BadgeSizes](-badge-sizes/index.md) |
| leadingIcon | an optional [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) appearing before the main content |
| trailingIcon | an optional [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) appearing after the main content |
| enabled | the visual state of the SuccessBadge [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| badgeColors | the colors of the SuccessBadge [BadgeColors](-badge-colors/index.md) |