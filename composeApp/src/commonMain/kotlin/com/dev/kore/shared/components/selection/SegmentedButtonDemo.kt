package com.dev.kore.shared.components.selection

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev.kore.components.segmentedButton.MultiChoiceSegmentedButtonRow
import com.dev.kore.components.segmentedButton.SegmentedButtonItem
import com.dev.kore.components.segmentedButton.SingleChoiceSegmentedButtonRow
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.shared.components.VariantRow

@Composable
fun SegmentedButtonDemo() {
    val ranges = listOf("Day", "Week", "Month", "Year")
    var selected by remember { mutableStateOf(1) }

    val filters = listOf("Wifi", "Parking", "Pets")
    val selectedFilters = remember { mutableStateListOf(0) }

    DemoPage {
        DemoBlock(title = "Single choice") {
            SingleChoiceSegmentedButtonRow {
                ranges.forEachIndexed { index, label ->
                    SegmentedButtonItem(
                        selected = selected == index,
                        onSelected = { selected = index },
                        index = index,
                        itemCount = ranges.size,
                    ) {
                        Text(label)
                    }
                }
            }
        }

        DemoBlock(title = "Multi choice") {
            MultiChoiceSegmentedButtonRow {
                filters.forEachIndexed { index, label ->
                    SegmentedButtonItem(
                        selected = selectedFilters.contains(index),
                        onSelected = { isSelected ->
                            if (isSelected) {
                                selectedFilters.add(index)
                            } else {
                                selectedFilters.remove(index)
                            }
                        },
                        index = index,
                        itemCount = filters.size,
                    ) {
                        Text(label)
                    }
                }
            }
        }

        DemoBlock(title = "Disabled") {
            VariantRow {
                SingleChoiceSegmentedButtonRow {
                    SegmentedButtonItem(
                        selected = true,
                        onSelected = {},
                        index = 0,
                        itemCount = 2,
                        enabled = false,
                    ) {
                        Text("Left")
                    }
                    SegmentedButtonItem(
                        selected = false,
                        onSelected = {},
                        index = 1,
                        itemCount = 2,
                        enabled = false,
                    ) {
                        Text("Right")
                    }
                }
            }
        }
    }
}
