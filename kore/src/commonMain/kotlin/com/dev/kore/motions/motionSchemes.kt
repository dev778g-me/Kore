package com.dev.kore.motions

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import kotlin.math.abs

/**
 * Kore easing curves.
 *
 * Built-in Compose easings (FastOutSlowIn etc.) start slowly, which makes UI
 * feel sluggish. These start fast and settle softly, so the response feels
 * instant while the ending still feels smooth.
 */
internal object KoreEasing {
    /** Strong ease-out. The workhorse for most UI motion. */
    val Strong: Easing = CubicBezierEasing(0.23f, 1f, 0.32f, 1f)

    /** Softer, longer tail. For large surfaces that travel further. */
    val Soft: Easing = CubicBezierEasing(0.22f, 1f, 0.36f, 1f)
}

/**
 * The fundamental unit of motion in Kore.
 *
 * [MotionCurve] hides the physics (tween, spring, or instant) behind one call.
 * Components just ask for [spec] and never need to know which kind it is.
 *
 * Create instances with [curve], [bounce], or [instant].
 *
 * ```
 * val alpha by animateFloatAsState(
 *     targetValue = if (visible) 1f else 0f,
 *     animationSpec = KoreTheme.motion.smooth.spec()
 * )
 * ```
 *
 * Interruption: Compose animation APIs always retarget from the current
 * on-screen value. Springs also carry the current velocity through the
 * retarget, tweens do not. So anything the user can grab or reverse
 * mid-flight should use a spring tier ([MotionConfig.fluid]).
 */
@Immutable
class MotionCurve internal constructor(
    private val type: AnimationType,
    private val durationMillis: Int = 0,
    private val easing: Easing = KoreEasing.Strong,
    private val dampingRatio: Float = Spring.DampingRatioNoBouncy,
    private val stiffness: Float = Spring.StiffnessMedium,
) {
    internal enum class AnimationType { TWEEN, SPRING, SNAP }

    /**
     * Produces a [FiniteAnimationSpec] for any Compose animation API
     * (`animateFloatAsState`, `AnimatedVisibility`, `updateTransition`, ...).
     *
     * For gesture release, pass the pointer velocity to
     * `Animatable.animateTo(target, animationSpec = spec(), initialVelocity = v)`
     * so the animation continues at the finger's speed with no visible seam.
     */
    fun <T> spec(): FiniteAnimationSpec<T> = when (type) {
        AnimationType.TWEEN -> tween(durationMillis = durationMillis, easing = easing)
        AnimationType.SPRING -> spring(dampingRatio = dampingRatio, stiffness = stiffness)
        AnimationType.SNAP -> snap()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MotionCurve) return false
        return type == other.type &&
                durationMillis == other.durationMillis &&
                easing == other.easing &&
                dampingRatio == other.dampingRatio &&
                stiffness == other.stiffness
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + durationMillis
        result = 31 * result + easing.hashCode()
        result = 31 * result + dampingRatio.hashCode()
        result = 31 * result + stiffness.hashCode()
        return result
    }

    override fun toString(): String = when (type) {
        AnimationType.TWEEN -> "MotionCurve.Tween(${durationMillis}ms)"
        AnimationType.SPRING -> "MotionCurve.Spring(damping=$dampingRatio, stiffness=$stiffness)"
        AnimationType.SNAP -> "MotionCurve.Snap"
    }
}

/**
 * Tween-based [MotionCurve]: fixed duration, predictable.
 * Good for fades, color changes and state changes.
 *
 * @param durationMillis how long the animation takes
 * @param easing the shape of the motion over time
 */
fun curve(
    durationMillis: Int,
    easing: Easing = KoreEasing.Strong,
): MotionCurve = MotionCurve(
    type = MotionCurve.AnimationType.TWEEN,
    durationMillis = durationMillis,
    easing = easing,
)

/**
 * Spring-based [MotionCurve]: physics, no fixed duration.
 * Good for anything the user touches, because springs can be interrupted
 * mid-motion and continue smoothly from the current value and velocity.
 *
 * Default is critically damped (no bounce). Add bounce only when the
 * gesture itself carried momentum (a flick, a throw, a drag release).
 * Overshoot on something that just faded in feels wrong, overshoot on a
 * card you flicked feels right.
 *
 * Rough stiffness to "response" guide (time to reach the target):
 * High ~0.06s, Medium ~0.16s, MediumLow ~0.31s, Low ~0.44s.
 *
 * @param dampingRatio 1.0 = settles with no bounce. Lower = more bounce.
 * @param stiffness higher = faster and snappier.
 */
fun bounce(
    dampingRatio: Float = Spring.DampingRatioNoBouncy,
    stiffness: Float = Spring.StiffnessMedium,
): MotionCurve = MotionCurve(
    type = MotionCurve.AnimationType.SPRING,
    dampingRatio = dampingRatio,
    stiffness = stiffness,
)

/** No animation. The value jumps straight to the target. */
fun instant(): MotionCurve = MotionCurve(type = MotionCurve.AnimationType.SNAP)

/**
 * The motion configuration for the Kore design system.
 *
 * Components pick a tier by *what they are*. The active preset decides how
 * that tier feels (crisp, playful, minimal, or none).
 *
 * | Tier       | Use it for                                                    |
 * |------------|---------------------------------------------------------------|
 * | [snappy]   | Press, toggle, checkbox, icon swap, exits, hover/row feedback |
 * | [smooth]   | Default. Fades, color changes, small movements, enters        |
 * | [calm]     | Sheets, dialogs, page transitions, big surfaces               |
 * | [fluid]    | Drag, fling, swipe-to-dismiss, spring-back (gesture-driven)   |
 *
 * Guidance:
 * - High-frequency actions (typing, list rows, tab switches) use [snappy]
 *   or no animation at all. Reserve [calm] for infrequent moments.
 * - Exits should be shorter than enters: enter with [smooth], exit with [snappy].
 * - Every animated state change also needs a static cue (color, icon, label).
 *   Motion is never the only feedback channel.
 * - Enter and exit along the same path, and scale or slide from the trigger
 *   (set the transform origin to where the interaction started).
 *
 * | Preset     | Personality                                                   |
 * |------------|---------------------------------------------------------------|
 * | [Balanced] | Crisp and polished. The default.                              |
 * | [Lively]   | Playful, springy. Consumer and creative apps.                 |
 * | [Reduced]  | Very short fades, no bounce. For motion-sensitive users.      |
 * | [Still]    | No animation at all.                                          |
 */
@Immutable
class MotionConfig internal constructor(
    /** Micro-interactions: press, toggle, icon swap. */
    val snappy: MotionCurve,

    /** The default for most component animations. */
    val smooth: MotionCurve,

    /** Large surfaces and page-level transitions. */
    val calm: MotionCurve,

    /** Gesture-driven motion. Interruptible and carries momentum. */
    val fluid: MotionCurve,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MotionConfig) return false
        return snappy == other.snappy &&
                smooth == other.smooth &&
                calm == other.calm &&
                fluid == other.fluid
    }

    override fun hashCode(): Int {
        var result = snappy.hashCode()
        result = 31 * result + smooth.hashCode()
        result = 31 * result + calm.hashCode()
        result = 31 * result + fluid.hashCode()
        return result
    }

    override fun toString(): String =
        "MotionConfig(snappy=$snappy, smooth=$smooth, calm=$calm, fluid=$fluid)"

    companion object {

        /**
         * Crisp and polished. The sensible default.
         *
         * Short tweens with a strong ease-out, so everything reacts immediately
         * and settles softly. Only [fluid] uses a spring, with a slight bounce
         * because gestures carry momentum (damping 0.8, response ~0.3s, the
         * same feel as a native drawer or sheet).
         */
        val Balanced: MotionConfig = MotionConfig(
            snappy = curve(durationMillis = 120, easing = KoreEasing.Strong),
            smooth = curve(durationMillis = 220, easing = KoreEasing.Strong),
            calm = curve(durationMillis = 360, easing = KoreEasing.Soft),
            fluid = bounce(
                dampingRatio = 0.8f,
                stiffness = Spring.StiffnessMediumLow,
            ),
        )

        /**
         * Playful and springy. Best for consumer, creative or entertainment apps.
         *
         * Bounce grows with the physicality of the tier: [snappy] never
         * bounces (press feedback should feel exact), [smooth] barely does,
         * [calm] and [fluid] carry visible momentum.
         * Note: avoid bouncy tiers on alpha or color, since overshoot can push
         * values past their valid range. Use them for size, offset and scale,
         * and fade with a tween (e.g. `Balanced.smooth`) instead.
         */
        val Lively: MotionConfig = MotionConfig(
            snappy = bounce(
                dampingRatio = Spring.DampingRatioNoBouncy,
                stiffness = Spring.StiffnessHigh,
            ),
            smooth = bounce(
                dampingRatio = 0.85f,
                stiffness = Spring.StiffnessMedium,
            ),
            calm = bounce(
                dampingRatio = 0.8f,
                stiffness = Spring.StiffnessMediumLow,
            ),
            fluid = bounce(
                dampingRatio = 0.65f,
                stiffness = Spring.StiffnessLow,
            ),
        )

        /**
         * For users who prefer reduced motion.
         *
         * Very short fades, no bounce, no overshoot. Motion still gives
         * feedback, it just finishes quickly and doesn't travel. Components
         * should swap slide, scale and blur for an opacity cross-fade when
         * this preset is active, instead of removing the element instantly.
         */
        val Reduced: MotionConfig = MotionConfig(
            snappy = curve(durationMillis = 60, easing = KoreEasing.Strong),
            smooth = curve(durationMillis = 100, easing = KoreEasing.Strong),
            calm = curve(durationMillis = 160, easing = KoreEasing.Strong),
            fluid = curve(durationMillis = 100, easing = KoreEasing.Strong),
        )

        /**
         * No animation. Every tier is instant.
         *
         * Use when the user has fully disabled animations, or for
         * tests and screenshot tests.
         */
        val Still: MotionConfig = run {
            val none = instant()
            MotionConfig(
                snappy = none,
                smooth = none,
                calm = none,
                fluid = none,
            )
        }
    }
}


/**
 * CompositionLocal for the current [MotionConfig].
 *
 * Prefer `KoreTheme.motion` over reading this directly.
 */
val LocalMotionConfig = staticCompositionLocalOf { MotionConfig.Balanced }