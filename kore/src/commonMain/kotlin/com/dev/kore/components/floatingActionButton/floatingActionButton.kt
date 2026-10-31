package com.dev.kore.components.floatingActionButton

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.dev.kore.components.separators.VerticalSeparator
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.LocalContentColor
import com.dev.kore.themes.LocalTextStyle


@Composable
fun FloatingActionButton(
    onClick : () -> Unit,
    modifier: Modifier = Modifier,
    enabled : Boolean = true,
    shape: Shape = KoreTheme.shapes.sm,
    contentPaddingValues: PaddingValues = FloatingActionButtonDefaults.defaultPaddingValues,
    colors: FloatingActionButtonColors = FloatingActionButtonDefaults.defaultFloatingActionButtonColors(),
    interactionSource: MutableInteractionSource ? = null,
    content : @Composable RowScope.() -> Unit,
){

    val motionConfig = KoreTheme.motion

    val contentColor by animateColorAsState(
        targetValue = colors.contentColor(enabled),
        animationSpec = motionConfig.calm.spec()
    )

    val containerColor by animateColorAsState(
        targetValue = colors.containerColor(enabled),
        animationSpec = motionConfig.calm.spec()
    )


    CompositionLocalProvider(
        LocalContentColor provides contentColor,
        LocalTextStyle provides KoreTheme.typography.title2
    ){

        Row(
            modifier = modifier
                .shadow(elevation = 8.dp, shape)
                .defaultMinSize(minHeight = FloatingActionButtonDefaults.defaultMinFabHeight, minWidth = FloatingActionButtonDefaults.defaultMinFabHeight)
                .clip(shape = shape)
                .background(color = containerColor, shape = shape)
                .clickable(
                    onClick = onClick,
                    role = Role.Button,
                    interactionSource = interactionSource
                )
                .padding(paddingValues = contentPaddingValues)
                ,
            verticalAlignment = Alignment.CenterVertically,
        ){
          content()
        }

    }

}

interface SplitFloatingActionButtonScope : RowScope

private class  SplitFloatingButtonScopeWrapper(rowScope: RowScope) : SplitFloatingActionButtonScope , RowScope by rowScope

@Composable
fun SplitFloatingActionButton(
    modifier: Modifier = Modifier,
    shape: Shape = KoreTheme.shapes.xl,
    content:  @Composable SplitFloatingActionButtonScope.() -> Unit,
){
    Row(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .clip(shape),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val scope = remember { SplitFloatingButtonScopeWrapper(rowScope = this) }
        content(scope)
    }
}

@Composable
fun SplitFloatingActionButtonScope.Item(
    onClick: () -> Unit,
    showSeparator: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPaddingValues: PaddingValues = FloatingActionButtonDefaults.defaultSplitFloatingActionButtonItemPaddingValues,
    colors: FloatingActionButtonColors = FloatingActionButtonDefaults.defaultFloatingActionButtonColors(),
    interactionSource: MutableInteractionSource? = null,
    separator: @Composable () -> Unit = { FloatingActionButtonDefaults.DefaultSeparator() },
    content: @Composable RowScope.() -> Unit,
) {


    val containerColor by animateColorAsState(
        targetValue = colors.containerColor(enabled =enabled )
    )

    val contentColor by animateColorAsState(
        targetValue = colors.contentColor(enabled = enabled)
    )

    Row(
        modifier = modifier
            .defaultMinSize(minHeight = FloatingActionButtonDefaults.defaultMinFabHeight)
            .background(containerColor)
            .clickable(onClick = onClick, interactionSource = interactionSource, enabled = enabled, role = Role.Button)
            .padding(contentPaddingValues),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CompositionLocalProvider(
            LocalContentColor provides contentColor,
            LocalTextStyle provides KoreTheme.typography.title2
        ) {
            content()
        }
    }

    if (showSeparator) {
        separator()
    }

}


object FloatingActionButtonDefaults{


    val defaultMinFabHeight = 56.dp


    @Composable
    fun DefaultSeparator(){
        VerticalSeparator()
    }
    @Composable
    fun defaultSplitFloatingActionButtonColors(
        containerColor: Color = KoreTheme.colorScheme.primary,
        contentColor: Color = KoreTheme.colorScheme.onPrimary,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = FloatingActionButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )
    @Composable
    fun defaultFloatingActionButtonColors(
        containerColor: Color = KoreTheme.colorScheme.primary,
        contentColor: Color = KoreTheme.colorScheme.onPrimary,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = FloatingActionButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )


    val defaultPaddingValues : PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 12.dp)

    val defaultSplitFloatingActionButtonItemPaddingValues : PaddingValues = PaddingValues(horizontal = 16.dp)
}

class FloatingActionButtonColors(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor : Color,
    val disabledContentColor : Color,
){
    fun copy(
        containerColor: Color = this.containerColor,
        contentColor: Color = this.contentColor,
        disabledContainerColor: Color = this.disabledContainerColor,
        disabledContentColor: Color = this.disabledContentColor
    ) = FloatingActionButtonColors(
        containerColor.takeOrElse { this.containerColor },
        contentColor.takeOrElse { this.contentColor },
        disabledContainerColor.takeOrElse { this.disabledContainerColor },
        disabledContentColor.takeOrElse { this.disabledContentColor }
    )


    // fun to obtain content color for fab bashed on enabled state

    @Stable
    fun contentColor(enabled: Boolean) : Color{
       return if (enabled) contentColor else disabledContentColor
    }


    // fun to obtain container color for afab bashed on enabled state

    @Stable
    fun containerColor(enabled: Boolean) : Color {
        return if (enabled) containerColor else disabledContainerColor
    }


    // equal override
    override fun equals(other: Any?): Boolean {
      if (this === other) return true
      if (other == null || other !is  FloatingActionButtonColors) return  false
      if (containerColor != other.containerColor) return false
      if (contentColor != other.contentColor ) return  false
      if (disabledContainerColor != other.disabledContainerColor) return  false
      if (disabledContentColor != other.disabledContentColor) return false

      return true
    }


    // hash code override
    override fun hashCode(): Int {
        var result = containerColor.hashCode()
        result = 31 * result + contentColor.hashCode()
        result = 31* result + disabledContainerColor.hashCode()
        result = 32* result + disabledContentColor.hashCode()
        return  result
    }

}