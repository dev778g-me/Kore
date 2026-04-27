//[korelibrary](../../index.md)/[com.dev.korelibrary.components.accordion](index.md)/[Accordion](-accordion.md)

# Accordion

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [Accordion](-accordion.md)(expanded: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), onExpand: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, header: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), expandedContent: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), trailingIcon: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), leadingIcon: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null, separator: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, enterTransition: [EnterTransition](https://developer.android.com/reference/kotlin/androidx/compose/animation/EnterTransition.html) = AccordionDefaults.defaultExpandedContentEnterTransition, exitTransition: [ExitTransition](https://developer.android.com/reference/kotlin/androidx/compose/animation/ExitTransition.html) = AccordionDefaults.defaultExpandedContentExitTransition, leadingIconAlignment: [Alignment.Vertical](https://developer.android.com/reference/kotlin/androidx/compose/ui/Alignment.Vertical.html) = AccordionDefaults.defaultLeadingIconAlignment, headerContentPaddingValues: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = AccordionDefaults.defaultHeaderContentPadding, expandedContentPaddingValues: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = AccordionDefaults.defaultExpandedContentPadding)

An Accordion is a vertically stacked header that when clicked expand or collapsed to show expanded content

#### Parameters

common

| | |
|---|---|
| expanded | the [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) state that defines the expanded state of the accordion |
| onExpand | the callback that gets invoked when accordion is clicked [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) that is applied to the Accordion |
| header | the header of the Accordion [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |
| expandedContent | the expandedContent of the Accordion [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |
| trailingIcon | the trailing content of the Accordion [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |
| leadingIcon | the leading content of the Accordion [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) |
| separator | the [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) value that let's show or hide the HorizontalSeparator |
| enterTransition | the enterTransition of the expandedContent [EnterTransition](https://developer.android.com/reference/kotlin/androidx/compose/animation/EnterTransition.html) |
| exitTransition | the exitTransition of the expandedContent [ExitTransition](https://developer.android.com/reference/kotlin/androidx/compose/animation/ExitTransition.html) |
| leadingIconAlignment | the vertical alignment of the leadingIcon |
| headerContentPaddingValues | the paddingValues of the header [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) |
| expandedContentPaddingValues | the paddingValues of the expandedContent [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) |