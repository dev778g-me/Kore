package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ButtonDocs(
    modifier: Modifier = Modifier,
){
    CodeBlock(code = """PrimaryButton(
    onClick = { /* Do something */ }
) {
    Icon(
        imageVector = PhIcons.Bold.Plus,
        contentDescription = null,
        modifier = Modifier.padding(end = 8.dp)
    )
    Text("Add New Item")
}""")
}