package com.dev.themebuilder.ui.docs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.kore.components.card.OutlinedCard
import com.dev.kore.components.stack.VerticalStack

@Composable
fun InstallationDocs(
    modifier: Modifier = Modifier,
) {
    VerticalStack(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp)
    ) {
        DefaultMarkdownParser(
            content = """Learn how to install and use Kore in a project

## Add to Compose Multiplatform

Kore is distributed via [Maven Central](https://central.sonatype.com/). It is the primary public repository for Java and Kotlin software artifact.

To make sure you have maven central check your `settings.gradle.kts` file."""
        )

        OutlinedCard {
            CodeBlock(
                code = """dependencyResolutionManagement {
    repositories {
        mavenCentral() // <- add this line
    }
}
"""
            )
        }

        DefaultMarkdownParser(
            content = """Default:"""
        )

        OutlinedCard {
            CodeBlock(
                code = """commonMain.dependencies {
    implementation("io.github.dev778g-me:kore:1.0.0-alpha01")
}"""
            )
        }

        DefaultMarkdownParser(
            content = """or

---

#### Add to Android"""
        )

        OutlinedCard {
            CodeBlock(
                code = """implementation("io.github.dev778g-me:kore-android:1.0.0-alpha01")"""
            )
        }

        DefaultMarkdownParser(
            content = """#### Add to Ios-arm64"""
        )

        OutlinedCard {
            CodeBlock(
                code = """implementation("io.github.dev778g-me:kore-iosarm64:1.0.0-alpha01")"""
            )
        }

        DefaultMarkdownParser(
            content = """#### Add to Ios-x64"""
        )

        OutlinedCard {
            CodeBlock(
                code = """implementation("io.github.dev778g-me:kore-iosx64:1.0.0-alpha01")"""
            )
        }

        DefaultMarkdownParser(
            content = """#### Add to Jvm(desktop)"""
        )

        OutlinedCard {
            CodeBlock(
                code = """implementation("io.github.dev778g-me:kore-jvm:1.0.0-alpha01")"""
            )
        }

        DefaultMarkdownParser(
            content = """and then sync the project."""
        )
    }
}
