package com.dev.themebuilder.ui.view.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.buttons.OutlinedButton
import com.dev.korelibrary.components.buttons.PrimaryButton
import com.dev.korelibrary.components.stack.HorizontalStack
import com.dev.korelibrary.components.stack.VerticalStack
import com.dev.korelibrary.components.text.Text
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.utilities.extensions.alignCenter
import com.dev.korelibrary.utilities.extensions.medium
import com.dev.korelibrary.utilities.extensions.semiBold
import com.dev.themebuilder.ui.showcase.ColorsShowCase
import com.dev.themebuilder.ui.showcase.ContactUiShowcase
import com.dev.themebuilder.ui.showcase.FileUploadUiShowcase
import com.dev.themebuilder.ui.showcase.FlightUIShowCase
import com.dev.themebuilder.ui.showcase.GithubUIShowcase
import com.dev.themebuilder.ui.showcase.LoadingUiShowcase
import com.dev.themebuilder.ui.showcase.LoginDevicesShowcase
import com.dev.themebuilder.ui.showcase.MemberUiShowCase
import com.dev.themebuilder.ui.showcase.PaywallUiShowcase
import com.dev.themebuilder.ui.showcase.ShowCase
import com.dev.themebuilder.ui.showcase.SwitchShowCase
import com.dev.themebuilder.ui.showcase.TodoUiShowcase
import com.dev.themebuilder.ui.showcase.TypographyShowcase
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.GithubLogo


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
){
    VerticalStack(
        spacing = KoreTheme.sizes.sm,
        modifier = modifier.fillMaxSize().padding(
            top = 72.dp
        ).padding(
            horizontal = 16.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalAlignment = Alignment.Top
    ) {
        Text("Build Your Own Compose Multiplatform Design System", textStyle = KoreTheme.typography.display3.semiBold().alignCenter())
        Text("Beautifully designed components you can customize, extend, and own.", textStyle = KoreTheme.typography.title3.medium().alignCenter())


       Spacer(
           modifier = Modifier.height(KoreTheme.sizes.xs)
       )


        HorizontalStack {
            PrimaryButton(
                onClick = {}
            ){
                Text("QuickStart")
            }

            OutlinedButton(
                onClick = {}
            ){
                com.dev.korelibrary.components.icon.Icon(imageVector = PhIcons.Regular.GithubLogo, contentDescription = "", modifier = Modifier.padding(end = 4.dp))
                Text("Github")
            }
        }


        Spacer(
            modifier = Modifier.height(KoreTheme.sizes.sm)
        )
        ShowCase {
            item {
                ColorsShowCase()
            }
            item {
                ContactUiShowcase()
            }
            item {
                PaywallUiShowcase()
            }

            item {
                TypographyShowcase()
            }
            item {
                MemberUiShowCase()
            }
            item {
                LoginDevicesShowcase()
            }
            item {
                FlightUIShowCase()
            }
            item {
                GithubUIShowcase()
            }
            item {
                SwitchShowCase()
            }
            item {
                TodoUiShowcase()
            }
            item { LoadingUiShowcase() }

            item { FileUploadUiShowcase() }



        }



    }
}