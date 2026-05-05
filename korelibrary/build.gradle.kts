
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.androidLint)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.composeCompiler)
    id("maven-publish")
    id("com.vanniktech.maven.publish") version "0.36.0"
}




kotlin {

    // Target declarations - add or remove as needed below. These define
    // which platforms this KMP module supports.
    // See: https://kotlinlang.org/docs/multiplatform-discover-project.html#targets
    androidLibrary {
        namespace = "com.dev.korelibrary"
        compileSdk = 36
        minSdk = 24

        withHostTestBuilder {
        }

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    // For iOS targets, this is also where you should
    // configure native binary output. For more information, see:
    // https://kotlinlang.org/docs/multiplatform-build-native-binaries.html#build-xcframeworks

    // A step-by-step guide on how to include this library in an XCode
    // project can be found here:
    // https://developer.android.com/kotlin/multiplatform/migrate
    val xcfName = "korelibraryKit"
     jvm()
    iosX64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosSimulatorArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    // Source set declarations.
    // Declaring a target automatically creates a source set with the same name. By default, the
    // Kotlin Gradle Plugin creates additional source sets that depend on each other, since it is
    // common to share sources between related targets.
    // See: https://kotlinlang.org/docs/multiplatform-hierarchy.html
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.androidx.graphics.shapes)
                implementation(libs.kotlin.stdlib)
                implementation(libs.compose.ui)
                implementation(libs.compose.components.resources)
                api(libs.compose.foundation)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
               // implementation(libs.compose.foundation)
            }
        }

        androidMain {
            dependencies {

            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.runner)
                implementation(libs.androidx.core)
                implementation(libs.androidx.testExt.junit)
            }
        }

        iosMain {
            dependencies {
                // Add iOS-specific dependencies here. This a source set created by Kotlin Gradle
                // Plugin (KGP) that each specific iOS target (e.g., iosX64) depends on as
                // part of KMP’s default source set hierarchy. Note that this source set depends
                // on common by default and will correctly pull the iOS artifacts of any
                // KMP dependencies declared in commonMain.
            }
        }
    }

}

compose.resources {
    publicResClass = true
    generateResClass = always
}

mavenPublishing {
    coordinates(
        groupId = "io.github.dev778g-me",
        artifactId = "kore",
        version = "1.0.0-alpha01"
    )

    pom {
        name.set("kore")
        description.set("Compose Multiplatform design foundation (alpha)")
        inceptionYear.set("2026")
        url.set("https://github.com/dev778g-me/kore")

        developers {
            developer {
                id.set("dev778g-me")
                name.set("dev")
                email.set("sanji778g@gmail.com")
            }
        }

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        scm {
            url.set("https://github.com/dev778g-me/kore")
            connection.set("scm:git:git://github.com/dev778g-me/kore.git")
            developerConnection.set("scm:git:ssh://git@github.com:dev778g-me/kore.git")
        }
    }

    publishToMavenCentral(automaticRelease = false)
    signAllPublications()
}
