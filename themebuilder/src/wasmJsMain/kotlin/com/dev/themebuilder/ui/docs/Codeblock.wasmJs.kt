package com.dev.themebuilder.ui.docs

@OptIn(ExperimentalWasmJsInterop::class)
actual fun copyToClipboard(text: String) {
    js("navigator.clipboard.writeText(text)")
}