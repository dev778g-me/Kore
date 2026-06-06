package com.dev.themebuilder.ui.showcase

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.dev.kore.components.badge.ErrorBadge
import com.dev.kore.components.badge.SecondaryBadge
import com.dev.kore.components.badge.SuccessBadge
import com.dev.kore.components.card.Card
import com.dev.kore.components.stack.VerticalStack
import com.dev.kore.components.text.Text
import com.dev.kore.themes.KoreTheme
import com.dev.kore.utilities.extensions.color
import com.phosphor.icons.PhIcons
import com.phosphor.icons.regular.DeviceMobile
import com.phosphor.icons.regular.Laptop
import org.jetbrains.skia.paragraph.Alignment

@Composable
fun LoginDevicesShowcase(
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier,
    ) {

        VerticalStack(
            horizontalAlignment = androidx.compose.ui.Alignment.Start,
            spacing = 24.dp
        ) {


            VerticalStack(
                horizontalAlignment = androidx.compose.ui.Alignment.Start,
                spacing = 8.dp
            ) {

                Text(
                    text = "Where you're logged in",
                    textStyle = KoreTheme.typography.title1.color(KoreTheme.colorScheme.onBackGround)
                )

                Text(
                    text = "We'll alert you via admin@untitled.com if there is any unusual activity on your account.",
                    textStyle = KoreTheme.typography.body2,
                    color = KoreTheme.colorScheme.onBackGroundVariant
                )
            }

            // Device List
            VerticalStack(
                spacing = 20.dp
            ) {

                DeviceLoginTile(
                    deviceName = "2018 MacBook Pro 15-inch",
                    deviceInfo = "Melbourne, Australia • 22 Jan at 10:42am",
                    imageVector = PhIcons.Regular.Laptop,
                    status = {
                        SuccessBadge(
                            content = { Text("Active now") }
                        )
                    }
                )

                DeviceLoginTile(
                    deviceName = "Google Pixel 8 Pro",
                    deviceInfo = "Melbourne, Australia • 22 Jan at 12:15pm",
                    imageVector = PhIcons.Regular.DeviceMobile,
                    status = {
                        ErrorBadge(
                            content = { Text("Error Login") }
                        )
                    }
                )

                DeviceLoginTile(
                    deviceName = "Google Pixel Fold",
                    deviceInfo = "Melbourne, Australia • 22 Jan at 15:29pm",
                    imageVector = PhIcons.Regular.DeviceMobile,
                    status = {
                        SecondaryBadge(
                            content = { Text("Inactive") }
                        )
                    }
                )
            }
        }
    }
}

@Composable
private fun DeviceLoginTile(
    deviceName: String,
    deviceInfo: String,
    imageVector: ImageVector,
    status: @Composable () -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalAlignment = androidx.compose.ui.Alignment.Top
    ) {

        com.dev.kore.components.icon.Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = KoreTheme.colorScheme.onBackGround
        )

        VerticalStack(
         horizontalAlignment = androidx.compose.ui.Alignment.Start
        ) {

            Text(
                text = deviceName,
                textStyle = KoreTheme.typography.title3.color(KoreTheme.colorScheme.onBackGround)
            )

            Text(
                text = deviceInfo,
                textStyle = KoreTheme.typography.body3,
                color = KoreTheme.colorScheme.onBackGroundVariant
            )

            status()
        }
    }
}