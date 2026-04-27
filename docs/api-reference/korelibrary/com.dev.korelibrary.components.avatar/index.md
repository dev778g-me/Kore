//[korelibrary](../../index.md)/[com.dev.korelibrary.components.avatar](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [AvatarColors](-avatar-colors/index.md) | [common]<br>data class [AvatarColors](-avatar-colors/index.md)(val containerColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val contentColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)) |
| [AvatarDefaults](-avatar-defaults/index.md) | [common]<br>object [AvatarDefaults](-avatar-defaults/index.md) |
| [AvatarSizes](-avatar-sizes/index.md) | [common]<br>enum [AvatarSizes](-avatar-sizes/index.md) : [Enum](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-enum/index.html)&lt;[AvatarSizes](-avatar-sizes/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [Avatar](-avatar.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [Avatar](-avatar.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier,<br>&nbsp;&nbsp;&nbsp;&nbsp;avatarSize: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = AvatarSizes.SMALL.size,<br>&nbsp;&nbsp;&nbsp;&nbsp;shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = AvatarDefaults.defaultAvatarShape,<br>&nbsp;&nbsp;&nbsp;&nbsp;colors: [AvatarColors](-avatar-colors/index.md) = AvatarDefaults.defaultAvatarColors(),<br>&nbsp;&nbsp;&nbsp;&nbsp;contentAlignment: [Alignment](https://developer.android.com/reference/kotlin/androidx/compose/ui/Alignment.html) = AvatarDefaults.defaultContentAlignment,<br>&nbsp;&nbsp;&nbsp;&nbsp;content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |