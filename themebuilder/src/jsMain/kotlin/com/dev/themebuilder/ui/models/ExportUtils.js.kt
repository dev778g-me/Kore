package com.dev.themebuilder.ui.models

import kotlinx.browser.document
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.url.URL
import org.w3c.files.Blob
import org.w3c.files.BlobPropertyBag

actual fun saveFile(content: String, fileName: String) {
    try {
        val blob = Blob(
            arrayOf(content),
            BlobPropertyBag("text/plain")
        )
        val url = URL.createObjectURL(blob)

        val link = document.createElement("a") as HTMLAnchorElement
        link.href = url
        link.download = fileName
        link.style.display = "none"
        document.body?.appendChild(link)
        link.click()
        document.body?.removeChild(link)

        URL.revokeObjectURL(url)
        println("File downloaded successfully: $fileName")
    } catch (e: Exception) {
        println("Error saving file: ${e.message}")
    }
}
