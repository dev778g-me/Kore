package com.dev.themebuilder.ui.models

import java.awt.FileDialog
import java.awt.Frame
import java.io.File
import java.io.FileWriter

actual fun saveFile(content: String, fileName: String) {
    val dialog = FileDialog(null as Frame?, "Save Theme File", FileDialog.SAVE)
    dialog.file = fileName
    dialog.isVisible = true

    if (dialog.directory != null && dialog.file != null) {
        try {
            val file = File(dialog.directory, dialog.file)
            FileWriter(file).use { writer ->
                writer.write(content)
            }
            println("File saved successfully: ${file.absolutePath}")
        } catch (e: Exception) {
            println("Error saving file: ${e.message}")
        }
    } else {
        println("Save cancelled by user")
    }
}

