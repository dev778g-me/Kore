package com.dev.kore

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dev.korelibrary.theme.KoreTheme
import com.dev.korelibrary.theme.googleSansFlex
import kore.composeapp.generated.resources.compose_multiplatform
import kore.korelibrary.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
@Preview
fun App() {
    KoreTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
        ){
            Text(
              //  fontFamily = googleSansFlex(),
                style = KoreTheme.typography.headingLarge,
               text =  "@Composable\n" +
                    "fun KoreTheme(\n" +
                    "    isDark: Boolean = isSystemInDarkTheme(),\n" +
                    "    typography: KoreTypography = defaultTypography,\n" +
                    "    shapes: KoreShapes = KoreDefaults.defaultShapes,\n" +
                    "    content: @Composable () -> Unit\n" +
                    ") {\n" +
                    "    \n" +
                    "    val colorScheme = if (isDark) defaultDarkColorScheme else defaultLightColorScheme\n" +
                    "    val rippleIndication = remember(colorScheme) {\n" +
                    "        koreRipple(\n" +
                    "            color = colorScheme.onBackGround\n" +
                    "        )\n" +
                    "    }\n" +
                    "\n" +
                    "    CompositionLocalProvider(\n" +
                    "        LocalKoreColorScheme provides colorScheme,\n" +
                    "        LocalContentColor provides colorScheme.onBackGround,\n" +
                    "        LocalKoreTypography provides typography,\n" +
                    "        LocalTextStyle provides defaultTypography.titleSmall,\n" +
                    "        LocalIndication provides rippleIndication,\n" +
                    "        LocalKoreShapes provides shapes,\n" +
                    "        LocalKoreSizes provides defaultSizes,\n" +
                    "        content = content\n" +
                    "    )\n" +
                    "\n" +
                    "} ")
        }
    }
}