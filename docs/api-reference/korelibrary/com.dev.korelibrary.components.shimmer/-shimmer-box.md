//[korelibrary](../../index.md)/[com.dev.korelibrary.components.shimmer](index.md)/[ShimmerBox](-shimmer-box.md)

# ShimmerBox

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [ShimmerBox](-shimmer-box.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = KoreTheme.shapes.md,<br>&nbsp;&nbsp;&nbsp;&nbsp;content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null)

A placeholder component that displays a shimmering animation, typically used to build skeleton loading screens.

#### Parameters

common

| | |
|---|---|
| modifier | The [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to the shimmer box. |
| shape | The geometric clipping shape of the shimmer effect. Defaults to the medium shape defined in [KoreTheme](../com.dev.korelibrary.themes/-kore-theme/index.md). |
| content | Optional content to place inside the box. This is often left null for fixed-size placeholders, but can be provided to automatically size the `ShimmerBox` to match the exact dimensions of the pending UI elements. |