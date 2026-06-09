package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.separators.VerticalSeparator
import com.dev.kore.themes.KoreTheme

private val CHANGELOG_CONTENT ="""
# Changelog

All notable changes to Kore will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [1.0.0-alpha02] - 2026-06-09

### Added
- Kotlin/Wasm and Kotlin/JS web targets are now officially supported.
- Interactive docs site is live, complete with a component showcase and live previews.
- Theme Builder Playground app to visually tweak and generate your `Theme.kt` files.
- You can now customize shape corner radius directly in the playground.
- `TailwindColors` is now available as an optional primary color source (alongside Radix).
- Added `dashed` and `dotted` variations for Separators.
- Added a bunch of new Compose modifiers and layout util functions .

### Changed
- Tweaked some APIs and designs for a few components (Cards, Switches, and RadioButtons) so they feel a bit better.
- Ripped out the old Squircle shape implementation. Swapped it for a new `SmoothCorner` logic (based on Korner) so shapes don't look weird or clip when you pass in a really high corner radius.
- Fixed how `onAccent` colors (`onPrimary`, `onComplementary`, `onError`) are calculated. They now blend over white so they actually pass accessibility contrast checks.
- Holding off on adding brand new components this round to focus on stabilizing the core stuff.

### Fixed
- Fixed some annoying typography rendering and clipping issues.

### Improved
- Wrote better KDocs for the extension and utility functions.
- Cleaned up the docs UI and general spacing.

---

## [1.0.0-alpha01] - 2026-05-10

### Added
- First public alpha release of Kore!
- 26+ pre-styled UI components (Buttons, TextFields, Dialogs, etc.).
- Compose Multiplatform support right out of the gate.
- Light and dark theme engine.
- Full design systems for Typography, Shapes, Sizes, and Colors.
- A bunch of helpful extension functions to cut down on UI boilerplate.
- Initial concept of the companion theme builder.
""".trimIndent()

@Composable
fun ChangelogDocs(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(KoreTheme.colorScheme.background),
        contentAlignment = Alignment.TopCenter
    ) {
        Row(
            modifier = Modifier
                .widthIn(max = 800.dp)
                .fillMaxHeight()
                .padding(24.dp)
        ) {
            VerticalSeparator()

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight().padding(
                        vertical = 48.dp
                    ),
                contentAlignment = Alignment.TopCenter
            ) {
                ScrollableDocContainer {
                    DefaultMarkdownParser(
                        content = CHANGELOG_CONTENT
                    )
                }
            }

            VerticalSeparator()
        }
    }
}