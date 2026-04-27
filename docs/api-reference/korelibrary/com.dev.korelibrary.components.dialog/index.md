//[korelibrary](../../index.md)/[com.dev.korelibrary.components.dialog](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [DialogColors](-dialog-colors/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [DialogColors](-dialog-colors/index.md)(val containerColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val titleTextColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val descriptionTextColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val borderColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)) |
| [DialogDefaults](-dialog-defaults/index.md) | [common]<br>object [DialogDefaults](-dialog-defaults/index.md) |

## Functions

| Name | Summary |
|---|---|
| [AlertDialog](-alert-dialog.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [AlertDialog](-alert-dialog.md)(onDismissRequest: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, title: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), description: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, dialogShape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = DialogDefaults.defaultDialogShape, dialogColors: [DialogColors](-dialog-colors/index.md) = DialogDefaults.alertDialogColors(), dismissButton: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, confirmButton: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, dialogProperties: [DialogProperties](https://developer.android.com/reference/kotlin/androidx/compose/ui/window/DialogProperties.html) = DialogDefaults.defaultDialogProperties, dialogPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = DialogDefaults.defaultDialogPaddingValues) |