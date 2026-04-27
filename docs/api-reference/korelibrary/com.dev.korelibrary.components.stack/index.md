//[korelibrary](../../index.md)/[com.dev.korelibrary.components.stack](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [StackDefaults](-stack-defaults/index.md) | [common]<br>object [StackDefaults](-stack-defaults/index.md)<br>Defines the default configurations and alignments used by [VerticalStack](-vertical-stack.md) and [HorizontalStack](-horizontal-stack.md). |

## Functions

| Name | Summary |
|---|---|
| [HorizontalStack](-horizontal-stack.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [HorizontalStack](-horizontal-stack.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, spacing: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = KoreTheme.sizes.xs, verticalAlignment: [Alignment.Vertical](https://developer.android.com/reference/kotlin/androidx/compose/ui/Alignment.Vertical.html) = StackDefaults.defaultVerticalAlignment, content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[RowScope](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/RowScope.html).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>A layout component that arranges its children in a horizontal sequence with standardized spacing. |
| [VerticalStack](-vertical-stack.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [VerticalStack](-vertical-stack.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, spacing: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = KoreTheme.sizes.xs, horizontalAlignment: [Alignment.Horizontal](https://developer.android.com/reference/kotlin/androidx/compose/ui/Alignment.Horizontal.html) = StackDefaults.defaultHorizontalAlignment, content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[ColumnScope](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/ColumnScope.html).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>A layout component that arranges its children in a vertical sequence with standardized spacing. |