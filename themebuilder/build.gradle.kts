import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)

}

//configurations.all {
//    exclude(group = "org.jetbrains.compose.material", module = "material")
//    exclude(group = "org.jetbrains.compose.material3", module = "material3")
//    exclude(group = "androidx.compose.material", module = "material")
//}

kotlin {
    jvm()

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }


    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.material)
            implementation(libs.adaptive)
            implementation(projects.korelibrary)
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.phosphoricon.compose)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.navigation.compose)
            implementation(libs.multiplatform.markdown.renderer)
        }

        commonTest.dependencies {
                implementation(libs.kotlin.test)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
        }


    }


}


compose.desktop {
    application {
        mainClass = "com.dev.themebuilder.MainKt"
        nativeDistributions {
            packageName = "ThemeBuilder"
            packageVersion = "1.0.0"

            linux {
                menuGroup = "Development"
                shortcut = true
            }

            targetFormats(
                TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb, TargetFormat.Exe,
                TargetFormat.AppImage, TargetFormat.Rpm
            )
        }
    }
}

compose.resources {
    publicResClass = true
    generateResClass = always
}