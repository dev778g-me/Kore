package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.loadingIndicator.CircularLoadingIndicator
import com.dev.korelibrary.components.loadingIndicator.LinearLoadingIndicator
import com.dev.korelibrary.components.loadingIndicator.LoadingIndicatorDefaults
import com.dev.korelibrary.components.stack.VerticalStack
import com.dev.korelibrary.themes.KoreTheme

@Composable
fun LoadingIndicatorDocs(
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
    ) {
        DefaultMarkdownParser(
            content = """# LoadingIndicator 

A Loading Indicator is a visual representation of an ongoing, indeterminate task. It signals to the user that the app is currently processing information, fetching data, or performing a background operation with an unspecified wait time.

When to use a Loading Indicator
- Use it for tasks that take noticeable time (like loading data or processing something)
- Use it when the app is preparing content before showing it
- Use it when the wait time is unclear and users need feedback that something is happening

When to avoid a Loading Indicator
- Avoid it for actions that feel instant
- Avoid it for fast, predictable operations
- Avoid it for small UI updates where a simple transition is enough

> Tip: If something takes less than about 300–500ms, skip the loader and show the result directly

> For deeper reference check out [Mobbin](https://mobbin.com/glossary/loading-indicator) guide on Loading Indicator


## Linear Loading Indicator

The `LinearLoadingIndicator` uses a horizontal line with an infinitely animating stroke to signal that the app is working. By default, it fills the maximum available width of its parent container.

### Basic Example 

"""
        )

        ComponentShowcase(
            code = """
// Displays a default, animating horizontal loading bar
LinearLoadingIndicator()
""".trimIndent(),
            content = {
                LinearLoadingIndicator()
            }
        )

        DefaultMarkdownParser(
            content = """
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
"""
        )

        ComponentShowcase(
            code = """
// Displays a default, spinning circular indicator
CircularLoadingIndicator()
""".trimIndent(),
            content = {
                CircularLoadingIndicator()
            }
        )

        DefaultMarkdownParser(
            content = """
### Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | Applied to the root canvas of the indicator. |
| `size` | `Dp` | `LoadingIndicatorDefaults.defaultCircularLoadingSize` | The overall width and height of the circular spinner. |
| `cap` | `StrokeCap` | `LoadingIndicatorDefaults.defaultStrokeCap` | The visual shape at the ends of the circular stroke. |
| `thickness` | `Dp` | `LoadingIndicatorDefaults.defaultCircularLoadingIndicatorStrokeWidth` | The thickness of the stroke itself. |
| `colors` | `LoadingIndicatorColors` | `LoadingIndicatorDefaults.circularLoadingIndicatorColors()` | The colors used for the animating ring and the static track behind it. |

---

## Styling

Both indicators expose parameters allowing you to heavily modify their appearance to fit different UI contexts, such as changing the stroke thickness, overall size, or component colors.

### Custom Circular Spinner

If you need a larger spinner with a custom brand color for a full-screen loading state:
"""
        )

        ComponentShowcase(
            code = """
CircularLoadingIndicator(
    size = 72.dp,
    thickness = 8.dp,
    cap = StrokeCap.Square, // Flat edges instead of rounded
    colors = LoadingIndicatorDefaults.circularLoadingIndicatorColors(
        trackColor = KoreTheme.colorScheme.surface,
        indicatorColor = KoreTheme.colorScheme.primary
    )
)
""".trimIndent(),
            content = {
                CircularLoadingIndicator(
                    size = 72.dp,
                    thickness = 8.dp,
                    cap = StrokeCap.Square,
                    colors = LoadingIndicatorDefaults.circularLoadingIndicatorColors(
                        trackColor = KoreTheme.colorScheme.surface,
                        indicatorColor = KoreTheme.colorScheme.primary
                    )
                )
            }
        )

        DefaultMarkdownParser(
            content = """
### Custom Linear Bar

If you want a very thin, subtle loading bar pinned to the top of a screen (often used in web browsers):
"""
        )

        ComponentShowcase(
            code = """
LinearLoadingIndicator(
    thickness = 2.dp,
    cap = StrokeCap.Butt,
    colors = LoadingIndicatorDefaults.linearLoadingIndictorColors(
        trackColor = Color.Transparent, // Hide the background track entirely
        indicatorColor = Color.Green
    ),
    modifier = Modifier.fillMaxWidth()
)
""".trimIndent(),
            content = {
                LinearLoadingIndicator(
                    thickness = 2.dp,
                    cap = StrokeCap.Butt,
                    colors = LoadingIndicatorDefaults.linearLoadingIndictorColors(
                        trackColor = androidx.compose.ui.graphics.Color.Transparent,
                        indicatorColor = androidx.compose.ui.graphics.Color.Green
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        )
    }
}