package com.dev.kore.shared.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme

/**
 * A single captioned demo inside a component screen.
 *
 * The [title] describes the variant ("Primary", "Disabled", "With icons", ...)
 * and [content] renders the live component.
 */
@Composable
fun DemoBlock(
    title: String,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs),
    ) {
        Text(
            text = title,
            textStyle = KoreTheme.typography.label1,
            color = KoreTheme.colorScheme.onBackGroundVariant,
        )
        content()
    }
}

/**
 * The root column of a component or foundation demo.
 */
@Composable
fun DemoPage(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        content = content,
    )
}

/**
 * A wrapping row used to line up variants that do not fit on one line.
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun VariantRow(content: @Composable FlowRowScope.() -> Unit) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs),
        verticalArrangement = Arrangement.spacedBy(KoreTheme.sizes.xs),
        content = content,
    )
}
