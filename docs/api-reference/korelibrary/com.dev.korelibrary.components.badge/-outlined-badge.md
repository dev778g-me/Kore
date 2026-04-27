//[korelibrary](../../index.md)/[com.dev.korelibrary.components.badge](index.md)/[OutlinedBadge](-outlined-badge.md)

# OutlinedBadge

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [OutlinedBadge](-outlined-badge.md)(content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = KoreTheme.shapes.lg,<br>&nbsp;&nbsp;&nbsp;&nbsp;badgeSizes: [BadgeSizes](-badge-sizes/index.md) = BadgeDefaults.defaultBadgeSize(),<br>&nbsp;&nbsp;&nbsp;&nbsp;leadingIcon: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;trailingIcon: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true,<br>&nbsp;&nbsp;&nbsp;&nbsp;badgeColors: [BadgeColors](-badge-colors/index.md) = BadgeDefaults.outlinedBadgeColor())

OutlinedBadge is a badge composable designed to highlight success action or status indicator

#### Parameters

common

| | |
|---|---|
| content | the main composable content to be displayed within the OutlinedBadge |
| modifier | is the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to the badge |
| shape | the shape of the OutlinedBadge [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| badgeSizes | the content sizes and padding values for the OutlinedBadge [BadgeSizes](-badge-sizes/index.md) |
| leadingIcon | an optional [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) appearing before the main content |
| trailingIcon | an optional [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) appearing after the main content |
| enabled | the visual state of the OutlinedBadge [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| badgeColors | the colors of the OutlinedBadge [BadgeColors](-badge-colors/index.md) |