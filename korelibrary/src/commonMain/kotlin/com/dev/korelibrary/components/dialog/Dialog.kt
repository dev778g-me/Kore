package com.dev.korelibrary.components.dialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.themes.LocalContentColor
import com.dev.korelibrary.themes.LocalTextStyle

/**
 * Alert Dialog is a popup that overlays main content to display urgent message or require a decision before user proceeds.
 * @param onDismissRequest the callback which will get called when the user tries to dismiss the dialog by clicking outside of it or pressing back button.
 * @param modifier the modifier to apply to Alert Dialog
 * @param title the title of the Dialog usually heading which conveys alert message to user .
 * @param icon the icon of the Dialog appears on top of title which usually conveys what type of action user will be performing .
 * @param description
 * @param dismissButton it is usually the action which you don't wanna execute by user .
 * @param confirmButton it is usually the action which you want user to execute ..
 * @param dialogShape the shape of the dialog Container .
 * @param dialogColors the colors of the dialogs . use [DialogDefaults.alertDialogColors] to customize .
 * @param border the border of the dialog [BorderStroke]
 * @param elevation the elevation value of the dialog [Dp]
 * @param dialogActionArrangement the horizontal arrangement of the actions(i.e. confirm button , dismiss button) .
 * @param dialogProperties the properties of the dialog .
 * @param dialogSpacing the spacing between the elements of the dialog . Use [DialogDefaults.defaultDialogSpacing] to customize .
 * @param contentPadding the padding of the dialog content .
 */
@Composable
fun AlertDialog(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    icon : (@Composable () -> Unit)? = null,
    description: (@Composable () -> Unit)? = null,
    dismissButton: (@Composable () -> Unit)? = null,
    confirmButton: @Composable () -> Unit,
    dialogShape: Shape = DialogDefaults.defaultDialogShape,
    dialogColors: DialogColors = DialogDefaults.alertDialogColors(),
    border : BorderStroke? = null,
    elevation: Dp = DialogDefaults.defaultDialogElevation,
    dialogActionArrangement: Arrangement.Horizontal = DialogDefaults.defaultActionArrangement,
    dialogProperties: DialogProperties = DialogDefaults.defaultDialogProperties,
    dialogSpacing: DialogSpacing = DialogDefaults.defaultDialogSpacing(),
    contentPadding: PaddingValues = DialogDefaults.defaultDialogPaddingValues
) {
    Dialog(
        onDismissRequest = {
            onDismissRequest.invoke()
        },
        properties = dialogProperties
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .shadow(elevation, dialogShape)
                .background(
                    color = dialogColors.containerColor,
                    shape = dialogShape
                ).then(if (border != null) Modifier.border(border, dialogShape) else Modifier)
                .padding(
                    paddingValues = contentPadding
                )
        ) {
            Column() {

                icon?.let {
                    CompositionLocalProvider(
                        value = LocalContentColor provides KoreTheme.colorScheme.primary
                    ){
                        it()
                        Spacer(
                            modifier = Modifier.height(dialogSpacing.afterIconSpacing)
                        )
                    }
                }

                // top heading
                CompositionLocalProvider(
                    LocalTextStyle provides KoreTheme.typography.title1.copy(
                        color = dialogColors.titleTextColor
                    )
                ){
                    title()
                }
                Spacer(
                    modifier = Modifier.height(dialogSpacing.afterTitleSpacing)
                )
                // middle part for explaining the intent
               description?.let {
                   CompositionLocalProvider(
                       LocalTextStyle provides KoreTheme.typography.title3.copy(
                           color = dialogColors.descriptionTextColor
                       )
                   ) {
                       it()
                       Spacer(
                           modifier = Modifier.height(dialogSpacing.afterDescriptionSpacing)
                       )
                   }
               }



                // row for actions
                Row(
                    modifier = Modifier.fillMaxWidth().semantics{
                        false
                    },
                    horizontalArrangement = dialogActionArrangement
                ) {
                    //less likely task
                    dismissButton?.let {
                        dismissButton()
                        Spacer(
                            modifier = Modifier.width(dialogSpacing.buttonSpacing)
                        )
                    }
                    // primary task y wanna execute
                    confirmButton()



                }

            }
        }
    }
}

object DialogDefaults{

    val defaultDialogShape : Shape
        @Composable get() = KoreTheme.shapes.lg
    val defaultDialogPaddingValues : PaddingValues
        @Composable get() = PaddingValues(KoreTheme.sizes.lg)


    val defaultDialogElevation : Dp = 8.dp

    val defaultDialogProperties : DialogProperties = DialogProperties(
        usePlatformDefaultWidth = true,
        dismissOnBackPress = true,
        dismissOnClickOutside = true,
    )

    @Composable
    fun defaultDialogSpacing() : DialogSpacing = DialogSpacing(
        afterIconSpacing = KoreTheme.sizes.xs,
        afterTitleSpacing = KoreTheme.sizes.xs,
        afterDescriptionSpacing = KoreTheme.sizes.sm,
        buttonSpacing = KoreTheme.sizes.xs
    )


    val defaultActionArrangement : Arrangement.Horizontal = Arrangement.End




    @Composable
    fun alertDialogColors(
        containerColor: Color = KoreTheme.colorScheme.background,
        titleTextColors: Color = KoreTheme.colorScheme.onBackGround,
        descriptionTextColor: Color = KoreTheme.colorScheme.onBackGroundVariant,
        borderColor: Color = KoreTheme.colorScheme.backGroundVariant
    ) = DialogColors(
        containerColor = containerColor,
        titleTextColor = titleTextColors,
        descriptionTextColor = descriptionTextColor,
        borderColor = borderColor
    )

}


@Immutable
data class DialogColors(
    val containerColor : Color,
    val titleTextColor : Color,
    val descriptionTextColor : Color,
    val borderColor : Color
)

@Immutable
data class DialogSpacing(
    val afterIconSpacing: Dp,
    val afterTitleSpacing: Dp,
    val afterDescriptionSpacing: Dp,
    val buttonSpacing: Dp
)




