package com.dev.kore.components.avatar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.LocalContentColor

enum class AvatarSize(val dp: Dp) {
    ExtraSmall(24.dp),
    Small(32.dp),
    Medium(48.dp),
    Large(56.dp),
    ExtraLarge(80.dp),
}

/**
 * A customizable avatar component designed to display user profile pictures or icons with an optional badge overlay.
 *
 * Provides configurations for dimensions, shape, alignment, theme-based colors, click handling,
 * accessibility support, and a badge slot for status indicators.
 *
 * @param modifier The [Modifier] to be applied to the avatar container.
 * @param avatarSize The size (width and height) of the avatar, defaulting to [AvatarDefaults.defaultAvatarSize].
 * @param shape The [Shape] used to clip the avatar container, defaulting to [AvatarDefaults.defaultAvatarShape].
 * @param contentAlignment The [Alignment] used to position the [content] inside the avatar container.
 * @param badgeAlignment The [Alignment] used to position the [badge] relative to the avatar container.
 * @param contentDescription Optional accessibility text describing the avatar for screen readers.
 * @param containerColor The background [Color] of the avatar container.
 * @param contentColor The default content [Color] applied inside the avatar container.
 * @param onClick Optional callback triggered when the avatar is clicked. If `null`, the avatar is non-clickable.
 * @param badge An optional composable slot for an overlay (e.g., online status, unread count badge), positioned via [badgeAlignment].
 * @param content The primary composable content to display within the avatar (e.g., an image or initials).
 */
@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    avatarSize : Dp = AvatarDefaults.defaultAvatarSize.dp,
    shape : Shape = AvatarDefaults.defaultAvatarShape,
    contentAlignment: Alignment = AvatarDefaults.defaultContentAlignment,
    badgeAlignment: Alignment = AvatarDefaults.defaultBadgeAlignment,
    contentDescription: String? = null,
    containerColor: Color = KoreTheme.colorScheme.surface,
    contentColor: Color = KoreTheme.colorScheme.onBackGround,
    onClick: (() -> Unit)? = null,
    badge: (@Composable BoxScope.() -> Unit)? = null,
    content : @Composable () -> Unit,
) {
    val a11y: Modifier = when {
        contentDescription != null -> Modifier.semantics {
            this.contentDescription = contentDescription
            if (onClick == null) role = Role.Image
        }
        onClick != null -> Modifier
        else -> Modifier.clearAndSetSemantics { }
    }

    Box(modifier = modifier.size(avatarSize)) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(shape)
                .background(color = containerColor, shape = shape)
                .then(
                    if (onClick != null) Modifier.clickable(onClick = onClick, role = Role.Button)
                    else Modifier
                )
                .then(a11y),
            contentAlignment = contentAlignment,
        ) {
            CompositionLocalProvider(LocalContentColor provides contentColor) {
                content()
            }
        }
        Box(modifier = Modifier.align(badgeAlignment)){
            badge?.invoke(this)
        }
    }
}

/**
 * A customizable avatar component designed to display user profiles, icons, or fallback UI with optional badge overlay.
 *
 * This component provides options for sizing, shape, alignment, custom colors, tap interactions,
 * badge positioning, and conditional fallback rendering.
 *
 * @param modifier The [Modifier] to be applied to the avatar container.
 * @param avatarSize The size (width and height) of the avatar, default is [AvatarDefaults.defaultAvatarSize].
 * @param shape The [Shape] used to clip the avatar container, default is [AvatarDefaults.defaultAvatarShape].
 * @param contentAlignment The [Alignment] used to align the main avatar content inside the container.
 * @param badgeAlignment The [Alignment] used to position the optional [badge] content relative to the container.
 * @param contentDescription Optional accessibility text describing the avatar for screen readers.
 * @param containerColor The background [Color] of the avatar container.
 * @param contentColor The default color applied to content within the avatar container.
 * @param onClick Optional callback invoked when the avatar is clicked. If null, the avatar will not be clickable.
 * @param badge An optional composable overlay slot (e.g., online status indicator, notification badge) positioned according to [badgeAlignment].
 * @param showFallback If true, renders the [fallback] content instead of the primary [content].
 * @param fallback An optional composable slot rendered when [showFallback] is set to true (e.g., placeholder initials or generic avatar icon).
 * @param content The main composable content to display inside the avatar (e.g., an image or initials).
 */
@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    avatarSize: Dp = AvatarDefaults.defaultAvatarSize.dp,
    shape: Shape = AvatarDefaults.defaultAvatarShape,
    contentAlignment: Alignment = AvatarDefaults.defaultContentAlignment,
    badgeAlignment: Alignment = AvatarDefaults.defaultBadgeAlignment,
    contentDescription: String? = null,
    containerColor: Color = KoreTheme.colorScheme.surface,
    contentColor: Color = KoreTheme.colorScheme.onBackGround,
    onClick: (() -> Unit)? = null,
    badge: (@Composable BoxScope.() -> Unit)? = null,
    showFallback: Boolean = false,
    fallback: (@Composable BoxScope.() -> Unit)? = null,
    content: @Composable BoxScope.() -> Unit,
) {
    val a11y: Modifier = when {
        contentDescription != null -> Modifier.semantics {
            this.contentDescription = contentDescription
            if (onClick == null) role = Role.Image
        }
        onClick != null -> Modifier
        else -> Modifier.clearAndSetSemantics { }
    }

    Box(modifier = modifier.size(avatarSize)) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(shape)
                .background(color = containerColor, shape = shape)
                .then(
                    if (onClick != null) Modifier.clickable(onClick = onClick, role = Role.Button)
                    else Modifier
                )
                .then(a11y),
            contentAlignment = contentAlignment,
        ) {
            CompositionLocalProvider(LocalContentColor provides contentColor) {
                if (showFallback && fallback != null) fallback() else content()
            }
        }
        Box(modifier = Modifier.align(badgeAlignment)){
            badge?.invoke(this)
        }
    }
}





object AvatarDefaults{

    val defaultContentAlignment : Alignment = Alignment.Center

    val defaultBadgeAlignment : Alignment = Alignment.BottomEnd
    val defaultAvatarShape : Shape = CircleShape

    val defaultAvatarSize : AvatarSize = AvatarSize.Medium



}







