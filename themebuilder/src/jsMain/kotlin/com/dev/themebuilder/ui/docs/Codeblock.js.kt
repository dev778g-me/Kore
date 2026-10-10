package com.dev.themebuilder.ui.docs

actual fun copyToClipboard(text: String) {
    js("navigator.clipboard.writeText(text)")
}
