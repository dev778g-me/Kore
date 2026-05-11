package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.stack.VerticalStack
import com.dev.korelibrary.components.tabRow.ScrollableTabRow
import com.dev.korelibrary.components.tabRow.Tab
import com.dev.korelibrary.components.text.Text
import com.dev.korelibrary.themes.KoreTheme

enum class CodeSwitcherTab {
    Code,
    Example
}

@Composable
fun CodeSwitcher(
    modifier: Modifier = Modifier,
    code: String,
    example: @Composable () -> Unit
) {
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }

    val tabs = CodeSwitcherTab.entries

    VerticalStack(modifier = modifier) {
        ScrollableTabRow(
            selectedIndex = selectedTabIndex,
            tabs = {
                tabs.forEachIndexed { index, tab ->
                    val isSelected = index == selectedTabIndex
                    Tab(
                        isSelected = isSelected,
                        onClick = { selectedTabIndex = index },
                        content = {
                            Text(
                                text = tab.name,
                            )
                        }
                    )
                }
            }
        )

        when (tabs[selectedTabIndex]) {
            CodeSwitcherTab.Code -> {
                CodeBlock(code = code)
            }
            CodeSwitcherTab.Example -> {
                example()
            }
        }
    }
}