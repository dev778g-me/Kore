//[korelibrary](../../index.md)/[com.dev.korelibrary.components.dropdown](index.md)/[DropDown](-drop-down.md)

# DropDown

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [DropDown](-drop-down.md)(expanded: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;onDismissRequest: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html),<br>&nbsp;&nbsp;&nbsp;&nbsp;modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;offset: [DpOffset](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/DpOffset.html) = DpOffset.Zero,<br>&nbsp;&nbsp;&nbsp;&nbsp;shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = DropdownDefaults.defaultDropDownShape,<br>&nbsp;&nbsp;&nbsp;&nbsp;scrollState: [ScrollState](https://developer.android.com/reference/kotlin/androidx/compose/foundation/ScrollState.html) = rememberScrollState(),<br>&nbsp;&nbsp;&nbsp;&nbsp;borderStroke: [BorderStroke](https://developer.android.com/reference/kotlin/androidx/compose/foundation/BorderStroke.html)? = null,<br>&nbsp;&nbsp;&nbsp;&nbsp;containerColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) = DropdownDefaults.defaultContainerColor,<br>&nbsp;&nbsp;&nbsp;&nbsp;itemSpacing: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = DropdownDefaults.defaultDropDownMargin,<br>&nbsp;&nbsp;&nbsp;&nbsp;contentPaddingValues: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = DropdownDefaults.defaultDropDownContainerPaddingValues,<br>&nbsp;&nbsp;&nbsp;&nbsp;animationSpec: [DropDownAnimationSpec](-drop-down-animation-spec/index.md) = DropdownDefaults.defaultDropDownAnimationSpec(),<br>&nbsp;&nbsp;&nbsp;&nbsp;content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[ColumnScope](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/ColumnScope.html).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

A Dropdown Menu presents a list of actions,options or items in a temporary surface they provide access to various feature and functionalities of the app

#### Parameters

common

| | |
|---|---|
| expanded | the state that defines the visibility of the dropdown menu [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| onDismissRequest | the callback invoked when the user requests to dismiss the dropdown menu [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| modifier | the [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) applied to Dropdown |
| offset | the offset of the dropdown  [DpOffset](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/DpOffset.html) |
| shape | the shape of the DropDown [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) |
| scrollState | the Scroll state of the DropDown [ScrollState](https://developer.android.com/reference/kotlin/androidx/compose/foundation/ScrollState.html) |
|  |