//[korelibrary](../../index.md)/[com.dev.korelibrary.components.stack](index.md)/[HorizontalStack](-horizontal-stack.md)

# HorizontalStack

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [HorizontalStack](-horizontal-stack.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;spacing: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = KoreTheme.sizes.xs,<br>&nbsp;&nbsp;&nbsp;&nbsp;verticalAlignment: [Alignment.Vertical](https://developer.android.com/reference/kotlin/androidx/compose/ui/Alignment.Vertical.html) = StackDefaults.defaultVerticalAlignment,<br>&nbsp;&nbsp;&nbsp;&nbsp;content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[RowScope](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/RowScope.html).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

A layout component that arranges its children in a horizontal sequence with standardized spacing.

#### Parameters

common

| | |
|---|---|
| modifier | The [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to the entire horizontal layout. |
| spacing | The horizontal space applied between each child component. Defaults to the extra-small size from [KoreTheme](../com.dev.korelibrary.themes/-kore-theme/index.md). |
| verticalAlignment | The vertical alignment of the children within the stack's total height. |
| content | The composable content to be displayed sequentially inside the stack. |