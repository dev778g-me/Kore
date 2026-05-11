package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.stack.VerticalStack
import com.dev.korelibrary.components.text.Text
import com.dev.korelibrary.themes.KoreTheme

@Composable
fun ChangelogDocs(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {

        Box(
            modifier = Modifier
                .width(720.dp)
                .padding(horizontal = 24.dp)
        ) {

            VerticalStack (
                modifier = Modifier.fillMaxWidth()
            ) {

                DefaultMarkdownParser(
                    content = """
# Changelog

All notable changes to Kore will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [1.0.0-alpha02] - 2026-05-12

### Added
- Kotlin/WASM & Kotlin/Js web target support
- Interactive documentation website
- Component showcase system with live previews


### Fixed
- Typography rendering and styling issues

### Improved
- Documentation UI and spacing

---

## [1.0.0-alpha01] - 2026-05-10

### Added
- First public alpha release of Kore
- 26+ pre-styled customizable UI components
- Compose Multiplatform support
- Light and dark theme support
- Typography, shape, sizes and color 
- Helpful extension functions for improved developer experience
- Companion theme builder for generating themes
"""
                )

                Spacer(
                    modifier = Modifier.height(40.dp)
                )

            }
        }
    }
}