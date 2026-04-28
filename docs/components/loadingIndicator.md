# LoadingIndicator 

A Loading Indicator is a visual representation of an ongoing, indeterminate task. It signals to the user that the app is currently processing information, fetching data, or performing a background operation with an unspecified wait time.

When to use 
- long tasks 
- initialization before content is ready.

When to avoid 
- instant actions
- synchronous actions


## Linear Loading Indicator

The `LinearLoadingIndicator` uses a horizontal line with an infinitely animating stroke to signal that the app is working. By default, it fills the maximum available width of its parent container.

### Basic Example 

```kotlin
// Displays a default, animating horizontal loading bar
LinearLoadingIndicator()
```

### Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | Applied to the root canvas of the indicator. |
| `thickness` | `Dp` | `LoadingIndicatorDefaults.defaultLinearLoadingIndicatorStrokeWidth` | The vertical height/thickness of the loading line. |
| `cap` | `StrokeCap` | `LoadingIndicatorDefaults.defaultStrokeCap` | The visual shape at the end of the progress line (defaults to `Round`). |
| `colors` | `LoadingIndicatorColors` | `LoadingIndicatorDefaults.linearLoadingIndictorColors()` | The colors used for the animating indicator and the static track behind it. |

---

## Circular Loading Indicator

The `CircularLoadingIndicator` uses a spinning circular ring. It is ideal for confined spaces, empty states, or pulling-to-refresh gestures.

### Basic Example

```kotlin
// Displays a default, spinning circular indicator
CircularLoadingIndicator()
```

### Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | Applied to the root canvas of the indicator. |
| `size` | `Dp` | `LoadingIndicatorDefaults.defaultCircularLoadingSize` | The overall width and height of the circular spinner. |
| `cap` | `StrokeCap` | `LoadingIndicatorDefaults.defaultStrokeCap` | The visual shape at the ends of the circular stroke. |
| `thickness` | `Dp` | `LoadingIndicatorDefaults.defaultCircularLoadingIndicatorStrokeWidth` | The thickness of the stroke itself. |
| `colors` | `LoadingIndicatorColors` | `LoadingIndicatorDefaults.circularLoadingIndicatorColors()` | The colors used for the animating ring and the static track behind it. |

---

## Customization

Both indicators expose parameters allowing you to heavily modify their appearance to fit different UI contexts, such as changing the stroke thickness, overall size, or component colors.

### Custom Circular Spinner

If you need a larger spinner with a custom brand color for a full-screen loading state:

```kotlin
CircularLoadingIndicator(
    size = 72.dp,
    thickness = 8.dp,
    cap = StrokeCap.Square, // Flat edges instead of rounded
    colors = LoadingIndicatorDefaults.circularLoadingIndicatorColors(
        trackColor = KoreTheme.colorScheme.surface,
        indicatorColor = KoreTheme.colorScheme.primaryVariant
    )
)
```

### Custom Linear Bar

If you want a very thin, subtle loading bar pinned to the top of a screen (often used in web browsers):

```kotlin
LinearLoadingIndicator(
    thickness = 2.dp,
    cap = StrokeCap.Butt,
    colors = LoadingIndicatorDefaults.linearLoadingIndictorColors(
        trackColor = Color.Transparent, // Hide the background track entirely
        indicatorColor = Color.Green
    ),
    modifier = Modifier.fillMaxWidth()
)
```




