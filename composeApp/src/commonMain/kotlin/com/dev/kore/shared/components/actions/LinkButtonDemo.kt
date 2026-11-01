package com.dev.kore.shared.components.actions

import androidx.compose.runtime.Composable
import com.dev.kore.components.linkButton.LinkText
import com.dev.kore.components.text.Text
import com.dev.kore.shared.components.DemoBlock
import com.dev.kore.shared.components.DemoPage
import com.dev.kore.themes.KoreTheme

@Composable
fun LinkButtonDemo() {
    DemoPage {
        DemoBlock(title = "Inline link") {
            LinkText(
                linkLabel = "Terms of service",
                prefix = "By continuing you agree to our ",
                suffix = ".",
                onClick = {},
            )
        }

        DemoBlock(title = "Link first") {
            LinkText(
                linkLabel = "Forgot your password?",
                prefix = "",
                onClick = {},
            )
        }

        DemoBlock(title = "Custom color and style") {
            LinkText(
                linkLabel = "resend it",
                prefix = "Didn't get the email? ",
                linkColor = KoreTheme.colorScheme.complementary,
                textStyle = KoreTheme.typography.body1,
                onClick = {},
            )
        }

        DemoBlock(title = "Body styles") {
            LinkText(
                linkLabel = "support",
                prefix = "Contact ",
                suffix = " if the problem persists.",
                textStyle = KoreTheme.typography.body3,
                onClick = {},
            )
        }

        DemoBlock(title = "Note") {
            Text(
                text = "A link button is a clickable span inside a paragraph, not a standalone button.",
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant,
            )
        }
    }
}
