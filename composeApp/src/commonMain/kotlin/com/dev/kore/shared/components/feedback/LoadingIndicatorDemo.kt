package com.dev.kore.shared.components.feedback

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.loadingIndicator.CircularLoadingIndicator
import com.dev.kore.components.loadingIndicator.LinearLoadingIndicator
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme

@Composable
fun LoadingIndicatorDemo() {
    DemoPage {
        DemoBlock(title = "Linear") {
            Column(verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.sm)) {
                LinearLoadingIndicator(modifier = Modifier.fillMaxWidth())
                LinearLoadingIndicator(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 6.dp,
                )
            }
        }

        DemoBlock(title = "Circular") {
            Row(
                horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.md),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CircularLoadingIndicator(size = 20.dp)
                CircularLoadingIndicator(size = 32.dp)
                CircularLoadingIndicator(size = 48.dp)
                CircularLoadingIndicator(
                    size = 64.dp,
                    thickness = 6.dp,
                )
            }
        }

        DemoBlock(title = "Inline with text") {
            Row(
                horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CircularLoadingIndicator(size = 16.dp)
                Text(
                    text = "Saving changes…",
                    textStyle = KoreTheme.typography.body3,
                    color = KoreTheme.colorScheme.onBackGroundVariant,
                )
            }
        }

        DemoBlock(title = "Note") {
            Text(
                text = "Loading indicators are indeterminate: use them while the duration is unknown. " +
                    "Use a progress indicator when the amount of work is measurable.",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
        }
    }
}
