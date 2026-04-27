//[korelibrary](../../index.md)/[com.dev.korelibrary.components.stack](index.md)/[VerticalStack](-vertical-stack.md)

# VerticalStack

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [VerticalStack](-vertical-stack.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;spacing: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = KoreTheme.sizes.xs,<br>&nbsp;&nbsp;&nbsp;&nbsp;horizontalAlignment: [Alignment.Horizontal](https://developer.android.com/reference/kotlin/androidx/compose/ui/Alignment.Horizontal.html) = StackDefaults.defaultHorizontalAlignment,<br>&nbsp;&nbsp;&nbsp;&nbsp;content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[ColumnScope](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/ColumnScope.html).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

A layout component that arranges its children in a vertical sequence with standardized spacing.

#### Parameters

common

| | |
|---|---|
| modifier | The [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to the entire vertical layout. |
| spacing | The vertical space applied between each child component. Defaults to the extra-small size from [KoreTheme](../com.dev.korelibrary.themes/-kore-theme/index.md). |
| horizontalAlignment | The horizontal alignment of the children within the stack's total width. |
| content | The composable content to be displayed sequentially inside the stack. |