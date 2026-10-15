package com.dev.codesamples

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val params = window.location.search
        .removePrefix("?")
        .split("&")
        .mapNotNull { it.split("=").takeIf { parts -> parts.size == 2 }?.let { parts -> parts[0] to parts[1] } }
        .toMap()
    val sampleId = params["sample"]
    val isDark = params["theme"] == "dark"

    // Standalone preview (python http.server test) mounts to <body>.
    // In the Astro iframe there is no host element either — index.html is bare.
    val host = document.getElementById("codesample-preview-host") ?: document.body ?: return
    ComposeViewport(host) {
        if (sampleId != null && allSamples.containsKey(sampleId)) {
            SingleSampleApp(sampleId, isDark)
        } else {
            CodeSampleApp()
        }
    }
}
