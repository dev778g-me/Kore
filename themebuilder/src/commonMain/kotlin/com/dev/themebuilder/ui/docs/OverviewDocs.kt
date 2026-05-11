package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OverviewDocs(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .width(720.dp)
                .padding(horizontal = 24.dp)
        ) {
            DefaultMarkdownParser(
                content = """# Why Kore?

So the question is — why Kore?

[Jetpack Compose](https://developer.android.com/jetpack/compose) and [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) let you build apps across platforms (Android, iOS, Desktop, Web), which is honestly amazing.

By default, though, you're working with [Material Design](https://m3.material.io/). And to be fair it's great i love it veryyy muchii Clean, polished, and well thought out.

But… it doesn't fit every product.

Not every app should look or feel like Material. And building your own design system from scratch? That's hard. It takes time, design sense, and a lot of iteration. Not everyone wants to go that deep just to make a good-looking UI.

That's where Kore comes in.

Kore helps you build your own design system without starting from zero. It gives you pre-styled components out of the box, which you can customize as much as you want. You can define colors (light and dark), shapes, typography, sizes everything.

There's also the Kore Companion app, which lets you generate your entire theme in one click. Your components automatically adapt to it. No manual setup, no hassle — just fast results.

---

## Key Features

### Fully Themeable
You can create your design system tokens manually, or just generate everything using the Kore Companion app. Either way, you're in control.

### Pre-styled
Not everyone is great at frontend design — and that's fine. Kore provides beautifully styled components by default, so you don't have to build everything from scratch.

### Customizable
You can tweak shapes, colors, typography, and sizes directly from the theme.  
Need more control? Almost everything is customizable via parameters.

And if you really want to go deep  each component is simple, self-contained, and lives in a single file. Copy, modify, and make it your own.

> Maybe a CLI in idk

### Accessible
All components are accessible out of the box, so you don't have to worry about that part.(mostly i have to work on this this is alpha so ok)
"""
            )
        }
    }
}