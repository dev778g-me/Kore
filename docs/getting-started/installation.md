###### Learn how to install and use Kore in a project 

## Add to Compose Multiplatform

<p>
Kore is distributed via <a href="https://central.sonatype.com/">Maven Central</a>. It is the primary public repository for Java and Kotlin software artifact.

To make sure you have maven central check your `settings.gradle.kts` file.<br>

```
dependencyResolutionManagement {
    repositories {
        mavenCentral() // <- add this line 
    }
}
```

#### Add to Android 
```
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.koreapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.koreapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // Compose
    implementation("androidx.compose.ui:ui:1.6.0")
    implementation("androidx.compose.material3:material3:1.2.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.0")
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.0")

    // Kore (dummy dependency)
    implementation("com.kore:kore:0.1.0")
}
```
#### Add to Compose Multiplatform
``` 
// dummy ai genn
plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    androidTarget()
    
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm("desktop")

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Compose Multiplatform
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)

                // Kore (dummy dependency)
                implementation("com.kore:kore:0.1.0")
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("androidx.activity:activity-compose:1.9.0")
            }
        }

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }

        val iosMain by creating {
            dependsOn(commonMain)
        }
    }
}

android {
    namespace = "com.example.koreapp"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
}
```

and then sync the project.



</p>