package com.dev.korelibrary.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.themes.KoreTheme
import com.dev.korelibrary.themes.LocalContentColor

@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    containerColor: Color = KoreTheme.colorScheme.surface,
    contentPadding: PaddingValues = NavigationBarDefaults.defaultNavigationBarPaddingValues,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 56.dp)
            .background(color = containerColor)
            .windowInsetsPadding(insets = WindowInsets.navigationBars)
            .padding(paddingValues = contentPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        content()
    }
}


@Composable
fun RowScope.NavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    iconLabelSpacing: Dp = NavigationBarDefaults.defaultIconLabelSpacing,
    indicatorShape: Shape = NavigationBarDefaults.defaultNavigationItemShape,
    colors: NavigationBarColor = NavigationBarDefaults.defaultNavigationBarColors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {

   val iconColor by animateColorAsState(
       targetValue = colors.iconColor(
           enabled = enabled,
           isSelected = selected
       )
   )


    val labelColor by animateColorAsState(
        targetValue = colors.labelColor(
            enabled = enabled,
            isSelected = selected
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .weight(1f)
            .height(IntrinsicSize.Max)
            .selectable(
                enabled = enabled,
                selected = selected,
                onClick = onClick,
                role = Role.Tab,
                interactionSource = interactionSource,
                indication = null
            )
    ) {
        CompositionLocalProvider(
            value = LocalContentColor provides iconColor
        ){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(shape = indicatorShape )
                    .indication(interactionSource, indication = LocalIndication.current) .padding(horizontal = 12.dp, vertical = 2.dp)
            ){
                icon()
            }

        }
        Spacer(modifier = Modifier.height(iconLabelSpacing))
        CompositionLocalProvider(
            value = LocalContentColor provides labelColor
        ){
            label()

        }
    }
}




object NavigationBarDefaults{

    val defaultNavigationItemShape : Shape
     @Composable get() =  KoreTheme.shapes.medium

    val defaultNavigationBarPaddingValues : PaddingValues = PaddingValues(
        horizontal = 12.dp,
        vertical = 16.dp
    )

    val defaultIconLabelSpacing : Dp = 4.dp

    @Composable
    fun defaultNavigationBarColors(
        unSelectedIconColor: Color= KoreTheme.colorScheme.onSurface,
        selectedIconColor: Color= KoreTheme.colorScheme.primary,
        unSelectedLabelColor: Color= KoreTheme.colorScheme.onSurface,
        selectedLabelColor: Color= KoreTheme.colorScheme.primary,
        disabledIconColor : Color= KoreTheme.colorScheme.onDisabled,
        disabledLabelColor :Color= KoreTheme.colorScheme.onDisabled,
    ) = NavigationBarColor(
        unSelectedIconColor = unSelectedIconColor,
        selectedIconColor =selectedIconColor,
        unSelectedLabelColor = unSelectedLabelColor,
        selectedLabelColor= selectedLabelColor,
        disabledIconColor =disabledIconColor,
        disabledLabelColor = disabledLabelColor
    )

}


@Immutable
data class NavigationBarColor(
    val unSelectedIconColor: Color,
    val selectedIconColor: Color,
    val unSelectedLabelColor: Color,
    val selectedLabelColor: Color,
    val disabledIconColor : Color,
    val disabledLabelColor :Color,
)


private fun NavigationBarColor.iconColor(
    enabled : Boolean,
    isSelected: Boolean
) : Color{
    return if (!enabled)  disabledIconColor else{
        if (isSelected) selectedIconColor else unSelectedIconColor
 }
}


private fun NavigationBarColor.labelColor(
    enabled: Boolean,
    isSelected: Boolean
): Color{
    return if (!enabled) disabledLabelColor else {
        if (isSelected) selectedLabelColor else unSelectedLabelColor
    }
}








