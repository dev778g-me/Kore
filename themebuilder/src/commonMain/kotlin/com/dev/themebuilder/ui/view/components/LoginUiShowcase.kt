package com.dev.themebuilder.ui.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.buttons.GhostIconButton
import com.dev.korelibrary.components.card.Card
import com.dev.korelibrary.components.icon.Icon
import com.dev.korelibrary.components.separators.HorizontalSeparator
import com.dev.korelibrary.components.buttons.PrimaryButton
import com.dev.korelibrary.components.buttons.SecondaryButton
import com.dev.korelibrary.components.stack.VerticalStack
import com.dev.korelibrary.components.Text
import com.dev.korelibrary.src.Components.TextFields.OutlinedTextField
import com.dev.korelibrary.themes.KoreTheme
import icons.PhIcons
import icons.regular.Envelope
import icons.regular.Eye
import icons.regular.GithubLogo
import icons.regular.Password
import kore.themebuilder.generated.resources.Res
import kore.themebuilder.generated.resources.icon_desktop
import org.jetbrains.compose.resources.painterResource

@Composable
@Preview(
    showBackground = true
)
fun LoginUiShowcase(
    modifier: Modifier = Modifier
){
    var emailText by rememberSaveable(){ mutableStateOf("") }
    var passwordText by rememberSaveable(){mutableStateOf("")}
    var showPassWord by rememberSaveable(){mutableStateOf(false)}
    Card {
        VerticalStack(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier


        ){
            Spacer(
                modifier = Modifier.height(12.dp)
            )
            Image(
                modifier = Modifier.size(
                    50.dp
                ).clip(KoreTheme.shapes.xs),
                painter = painterResource(
                    resource = Res.drawable.icon_desktop
                ),
                contentDescription = "icon"

            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                textAlign = TextAlign.Center,
                textStyle = KoreTheme.typography.title3.copy(
                    color = KoreTheme.colorScheme.onBackGroundVariant
                ),
                text = "To sign in to an account in the application enter your email and password"
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )



            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = emailText,
                onValueChange = {
                    emailText = it
                },
                placeholder = {
                    Text(
                        "Enter email here "
                    )
                },
                label = {
                    Text(
                        "Email"
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = PhIcons.Regular.Envelope,
                        contentDescription = ""
                    )
                }
            )


            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = passwordText,
                onValueChange = {
                    passwordText = it
                },
                placeholder = {
                    Text(
                        "Enter password here"
                    )
                },
                label = {
                    Text(
                        "Password"
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = PhIcons.Regular.Password,
                        contentDescription = ""
                    )
                },
                trailingIcon = {
                    GhostIconButton(
                        onClick = {}
                    ){
                        Icon(
                            imageVector = PhIcons.Regular.Eye,
                            contentDescription = ""
                        )
                    }
                }
            )


            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            ){
                Text(
                    "Sign in"
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                HorizontalSeparator(
                    modifier = Modifier.weight(1f)
                )
                Text(modifier = Modifier.padding(horizontal = 8.dp), text = "or")
                HorizontalSeparator(   modifier = Modifier.weight(1f))
            }
            SecondaryButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            ){
                Icon(
                    modifier = Modifier.padding(
                        end = 8.dp
                    ),
                    imageVector = PhIcons.Regular.GithubLogo,
                    contentDescription = ""
                )
                Text(
                    "Sign in with Github"
                )
            }
            Spacer(
                modifier = Modifier.height(12.dp)
            )
        }
    }
}