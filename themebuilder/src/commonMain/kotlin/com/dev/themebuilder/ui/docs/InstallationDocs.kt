package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InstallationDocs(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .width(720.dp)
                .padding(horizontal = 24.dp)
        ) {
            DefaultMarkdownParser(
                content = """Learn how to install and use Kore in a project

## Add to Compose Multiplatform

<p>
Kore is distributed via <a href="https://central.sonatype.com/">Maven Central</a>. It is the primary public repository for Java and Kotlin software artifact.

To make sure you have maven central check your `settings.gradle.kts` file.<br>

```kotlin
dependencyResolutionManagement {
    repositories {
        mavenCentral() // <- add this line 
    }
}
```

#### Add to Compose Multiplatform
```kotlin
commonMain.dependencies {
    implementation("io.github.dev778g-me:kore:1.0.0-alpha01")
}
```
or

---
#### Add to Android 
```kotlin
implementation("io.github.dev778g-me:kore-android:1.0.0-alpha01")
```

#### Add to Ios-arm64
```kotlin
implementation("io.github.dev778g-me:kore-iosarm64:1.0.0-alpha01")
```

#### Add to Ios-x64
```kotlin
implementation("io.github.dev778g-me:kore-iosx64:1.0.0-alpha01")
```

#### Add to Jvm(desktop)
```kotlin
implementation("io.github.dev778g-me:kore-jvm:1.0.0-alpha01")
```



and then sync the project.



</p>
"""
            )
        }
    }
}