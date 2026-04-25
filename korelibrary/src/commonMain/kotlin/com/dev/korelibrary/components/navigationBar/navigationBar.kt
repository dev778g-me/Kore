package com.dev.korelibrary.components.navigationBar

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

/**
 * NavigationBar is bottom navigation that provides access to top-level destinations.
 * @param modifier the [Modifier] applied to NavigationBar
 * @param containerColor the background color of the NavigationBar [Color]
 * @param contentPadding the padding values of the NavigationBar [PaddingValues]
 * @param content the content of the NavigationBar [Composable]
 */
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

/**
 * NavigationBarItem is an individual item within a [NavigationBar]
 * @param selected the boolean state which decides item selected nature [Boolean]
 * @param onClick the callback to be invoked when this item is clicked
 * @param icon the icon of the item [Composable]
 * @param label the label of the item [Composable]
 * @param modifier the [Modifier] applied on the item
 * @param enabled the boolean state which decides item enabled nature [Boolean]
 * @param indicatorShape the shape of the indicator [Shape]
 * @param iconLabelSpacing the spacing between icon and label [Dp]
 * @param colors the colors of the item. Use [NavigationBarDefaults.defaultNavigationBarColors] to change colors
 * @param interactionSource the interaction source of the item [MutableInteractionSource]
 *
 */
@Composable
fun RowScope.NavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    indicatorShape: Shape = NavigationBarDefaults.defaultNavigationItemShape,
    iconLabelSpacing: Dp = NavigationBarDefaults.defaultIconLabelSpacing,
    colors: NavigationBarItemColor = NavigationBarDefaults.defaultNavigationBarColors(),
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


/**
 * NavigationBarDefaults defines default values for NavigationBar
 * @property defaultNavigationItemShape the default shape of the navigation item [Shape]
 * @property defaultNavigationBarPaddingValues the default padding values of the navigation bar [PaddingValues]
 * @property defaultIconLabelSpacing the default spacing between icon and label [Dp]
 * @property defaultNavigationBarColors the default colors of the navigation bar [NavigationBarItemColor]
 */
object NavigationBarDefaults{

    val defaultNavigationItemShape : Shape
     @Composable get() =  KoreTheme.shapes.md

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
    ) = NavigationBarItemColor(
        unSelectedIconColor = unSelectedIconColor,
        selectedIconColor =selectedIconColor,
        unSelectedLabelColor = unSelectedLabelColor,
        selectedLabelColor= selectedLabelColor,
        disabledIconColor =disabledIconColor,
        disabledLabelColor = disabledLabelColor
    )

}

/**
 * defines all the colors for navigationbar item
 */
@Immutable
data class NavigationBarItemColor(
    val unSelectedIconColor: Color,
    val selectedIconColor: Color,
    val unSelectedLabelColor: Color,
    val selectedLabelColor: Color,
    val disabledIconColor : Color,
    val disabledLabelColor :Color,
)


private fun NavigationBarItemColor.iconColor(
    enabled : Boolean,
    isSelected: Boolean
) : Color{
    return if (!enabled)  disabledIconColor else{
        if (isSelected) selectedIconColor else unSelectedIconColor
 }
}


private fun NavigationBarItemColor.labelColor(
    enabled: Boolean,
    isSelected: Boolean
): Color{
    return if (!enabled) disabledLabelColor else {
        if (isSelected) selectedLabelColor else unSelectedLabelColor
    }
}








