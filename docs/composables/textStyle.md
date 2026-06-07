# TextStyle

A set of extension functions on `TextStyle` to fluently apply typography properties like font weight, size, decoration, alignment, and color.

## Font Weight

### TextStyle.bold()

Sets the font weight to `FontWeight.Bold`.

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Bold Text",
        textStyle = KoreTheme.typography.body1.bold()
    )
}
```

### TextStyle.extraBold()

Sets the font weight to `FontWeight.ExtraBold`.

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Extra Bold Text",
        textStyle = KoreTheme.typography.body1.extraBold()
    )
}
```

### TextStyle.semiBold()

Sets the font weight to `FontWeight.SemiBold`.

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Semi Bold Text",
        textStyle = KoreTheme.typography.body1.semiBold()
    )
}
```

### TextStyle.medium()

Sets the font weight to `FontWeight.Medium`.

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Medium Weight Text",
        textStyle = KoreTheme.typography.body1.medium()
    )
}
```

### TextStyle.light()

Sets the font weight to `FontWeight.Light`.

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Light Weight Text",
        textStyle = KoreTheme.typography.body1.light()
    )
}
```

### TextStyle.extraLight()

Sets the font weight to `FontWeight.ExtraLight`.

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Extra Light Text",
        textStyle = KoreTheme.typography.body1.extraLight()
    )
}
```

### TextStyle.normal()

Sets the font weight to `FontWeight.Normal`.

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Normal Weight Text",
        textStyle = KoreTheme.typography.body1.normal()
    )
}
```

## Typography

### TextStyle.size()

Sets the `fontSize` of the text style.

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Custom Sized Text",
        textStyle = KoreTheme.typography.body1.size(24.sp)
    )
}
```

### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `size` | `TextUnit` | — | The target font size to apply to the text style. |

### TextStyle.letterSpacing()

Sets the `letterSpacing` of the text style.

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Letter Spaced Text",
        textStyle = KoreTheme.typography.body1.letterSpacing(2.sp)
    )
}
```

### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `spacing` | `TextUnit` | — | The amount of space to add between each letter. |

### TextStyle.lineHeight()

Sets the `lineHeight` of the text style.

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Text with\ncustom line\nheight",
        textStyle = KoreTheme.typography.body1.lineHeight(32.sp)
    )
}
```

### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `height` | `TextUnit` | — | The height of each line of text. |

## Decoration

### TextStyle.strikethrough()

Applies a strikethrough line through the text.

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Strikethrough Text",
        textStyle = KoreTheme.typography.body1.strikethrough()
    )
}
```

### TextStyle.underline()

Applies an underline below the text.

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Underlined Text",
        textStyle = KoreTheme.typography.body1.underline()
    )
}
```

### TextStyle.italic()

Sets the font style to `FontStyle.Italic`.

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Italic Text",
        textStyle = KoreTheme.typography.body1.italic()
    )
}
```

## Color

### TextStyle.color()

Sets the `color` of the text style.

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Colored Text",
        textStyle = KoreTheme.typography.body1.color(KoreTheme.colorScheme.primary)
    )
}
```

### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `color` | `Color` | — | The color to apply to the text. |

## Alignment

### TextStyle.alignCenter()

Sets the text alignment to `TextAlign.Center`.

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Centered Text",
        textStyle = KoreTheme.typography.body1.alignCenter(),
        modifier = Modifier.fillMaxWidth()
    )
}
```

### TextStyle.alignEnd()

Sets the text alignment to `TextAlign.End`.

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "End Aligned Text",
        textStyle = KoreTheme.typography.body1.alignEnd(),
        modifier = Modifier.fillMaxWidth()
    )
}
```
