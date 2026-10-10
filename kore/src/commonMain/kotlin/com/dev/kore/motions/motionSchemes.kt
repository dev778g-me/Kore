package com.dev.kore.motions

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf



/**
 * The fundamental unit of motion in Kore.
 *
 * [MotionCurve] encapsulates the physics and feel of an animation
 * without exposing the underlying implementation to components.
 * Components call [spec] to obtain a ready-to-use Compose
 * [FiniteAnimationSpec] without knowing whether the motion is
 * tween-based, spring-based, or instantaneous.
 *
 * Create instances using [curve], [bounce], or [instant].
 *
 * ```
 * // Component usage — physics are hidden:
 * val alpha by animateFloatAsState(
 *     targetValue = if (visible) 1f else 0f,
 *     animationSpec = KoreTheme.motion.standard.spec()
 * )
 * ```
 */
@Immutable
class MotionCurve internal constructor(
    private val type: Type,
    private val durationMillis: Int = 0,
    private val easing: Easing = FastOutSlowInEasing,
    private val dampingRatio: Float = Spring.DampingRatioNoBouncy,
    private val stiffness: Float = Spring.StiffnessMedium,
) {
    internal enum class Type { TWEEN, SPRING, SNAP }

    /**
     * Produces a [FiniteAnimationSpec] for use with any Compose animation API
     * such as `animateFloatAsState`, `animateColorAsState`, `AnimatedVisibility`,
     * `updateTransition`, etc.
     */
    fun <T> spec(): FiniteAnimationSpec<T> = when (type) {
        Type.TWEEN -> tween(durationMillis = durationMillis, easing = easing)
        Type.SPRING -> spring(dampingRatio = dampingRatio, stiffness = stiffness)
        Type.SNAP -> snap()
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
        Type.TWEEN -> "MotionCurve.Tween(${durationMillis}ms)"
        Type.SPRING -> "MotionCurve.Spring(damping=$dampingRatio, stiffness=$stiffness)"
        Type.SNAP -> "MotionCurve.Snap"
    }
}



/**
 * Creates a tween-based [MotionCurve] with the given duration and easing.
 *
 * Use for predictable, duration-based motion like fades, slides, and state changes.
 *
 * @param durationMillis duration of the animation in milliseconds
 * @param easing the easing curve to apply
 */
fun curve(
    durationMillis: Int,
    easing: Easing = FastOutSlowInEasing,
): MotionCurve = MotionCurve(
    type = MotionCurve.Type.TWEEN,
    durationMillis = durationMillis,
    easing = easing,
)

/**
 * Creates a spring-based [MotionCurve] with the given physical properties.
 *
 * Use for natural, physics-based motion like gestures, bounces, and snapping.
 *
 * @param dampingRatio controls how quickly the spring settles. Lower values = more bounce.
 * @param stiffness controls the spring's responsiveness. Higher values = faster.
 *
 * @see Spring.DampingRatioNoBouncy
 * @see Spring.DampingRatioLowBouncy
 * @see Spring.DampingRatioMediumBouncy
 * @see Spring.StiffnessLow
 * @see Spring.StiffnessMedium
 * @see Spring.StiffnessHigh
 */
fun bounce(
    dampingRatio: Float = Spring.DampingRatioNoBouncy,
    stiffness: Float = Spring.StiffnessMedium,
): MotionCurve = MotionCurve(
    type = MotionCurve.Type.SPRING,
    dampingRatio = dampingRatio,
    stiffness = stiffness,
)

/**
 * Creates an instantaneous [MotionCurve] with no visible animation.
 *
 * Used internally for [MotionConfig.Still] accessibility preset. Can also be used
 * when a component should skip animation entirely.
 */
fun instant(): MotionCurve = MotionCurve(
    type = MotionCurve.Type.SNAP,
)



/**
 * The motion configuration for the Kore design system.
 *
 * [MotionConfig] provides four speed tiers. Components simply pick how
 * fast the animation should feel - the active preset decides the character
 * (smooth, bouncy, minimal, or none).
 *
 * ```
 * // Toggle thumb sliding:
 * val thumbSpec = KoreTheme.motion.quick.spec<Dp>()
 *
 * // Page transition:
 * val pageSpec = KoreTheme.motion.gentle.spec<IntOffset>()
 *
 * // Most things — just use standard:
 * val colorSpec = KoreTheme.motion.standard.spec<Color>()
 * ```
 *
 * ## Speed tiers
 *
 * | Tier         | When to use                                                  |
 * |--------------|--------------------------------------------------------------|
 * | [quick]      | Micro-interactions  -button press, toggle, icon swap.        |
 * | [standard]   | General-purpose - most component animations land here.       |
 * | [gentle]     | Large or cinematic - page transitions, hero moments.         |
 * | [expressive] | Gesture-driven or playfu- drag, fling, spring-back.        |
 *
 * ## Built-in presets
 *
 * | Preset       | Personality                                               |
 * |--------------|-----------------------------------------------------------|
 * | [Balanced]   | Responsive and polished. Tween-based. The sensible default.|
 * | [Lively]     | Playful, spring-based with bounce for consumer/creative.  |
 * | [Reduced]    | Shorter, damped curves for motion-sensitive users.        |
 * | [Still]      | Instant - all slots produce `snap()`.                     |
 *
 * @see MotionCurve
 */
@Immutable
class MotionConfig internal constructor(

    /** Snappy motion for micro-interactions - toggles, button presses, icon swaps. */
    val quick: MotionCurve,

    /** Standard motion for general component animations  */
    val standard: MotionCurve,

    /** Slow, cinematic motion for page transitions and hero moments. */
    val gentle: MotionCurve,

    /** Physics-driven motion for gestures, drag, fling, and spring-back. */
    val expressive: MotionCurve,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MotionConfig) return false
        return quick == other.quick &&
            standard == other.standard &&
            gentle == other.gentle &&
            expressive == other.expressive
    }

    override fun hashCode(): Int {
        var result = quick.hashCode()
        result = 31 * result + standard.hashCode()
        result = 31 * result + gentle.hashCode()
        result = 31 * result + expressive.hashCode()
        return result
    }

    override fun toString(): String =
        "MotionConfig(" +
            "quick=$quick, " +
            "standard=$standard, " +
            "gentle=$gentle, " +
            "expressive=$expressive)"

    companion object {

        /**
         * Responsive and polished motion. The sensible default.
         *
         * Tween-based with moderate durations and standard easings.
         * Works well for most apps without drawing attention to itself.
         */
        val Balanced: MotionConfig = MotionConfig(
            quick      = curve(durationMillis = 100, easing = FastOutSlowInEasing),
            standard   = curve(durationMillis = 300, easing = FastOutSlowInEasing),
            gentle     = curve(durationMillis = 500, easing = LinearOutSlowInEasing),
            expressive = bounce(
                dampingRatio = Spring.DampingRatioNoBouncy,
                stiffness    = Spring.StiffnessMedium,
            ),
        )

        /**
         * Playful and dynamic motion.
         *
         * Spring-based across the board with varying bounce.
         * Best for consumer-facing, creative, or entertainment apps.
         */
        val Lively: MotionConfig = MotionConfig(
            quick = bounce(
                dampingRatio = 0.7f,
                stiffness = Spring.StiffnessHigh,
            ),
            standard = bounce(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessMedium,
            ),
            gentle = bounce(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessMediumLow,
            ),
            expressive = bounce(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessMedium,
            ),
        )


        /**
         * Minimal, shortened motion for users with reduced-motion preferences.
         *
         * Very short tweens, no bounce. Animations still exist — they just
         * finish quickly and don't overshoot, reducing potential discomfort.
         */
        val Reduced: MotionConfig = MotionConfig(
            quick = curve(durationMillis = 50, easing = FastOutLinearInEasing),
            standard = curve(durationMillis = 100, easing = FastOutLinearInEasing),
            gentle = curve(durationMillis = 150, easing = FastOutLinearInEasing),
            expressive = curve(durationMillis = 100, easing = FastOutLinearInEasing),
        )

        /**
         * No animation -z every slot produces an instantaneous [snap].
         *
         * Use for accessibility when the user has fully disabled animations,
         * or for testing/snapshot purposes.
         */
        val Still: MotionConfig = run {
            val snap = instant()
            MotionConfig(
                quick = snap,
                standard = snap,
                gentle = snap,
                expressive = snap,
            )
        }
    }
}



/**
 * CompositionLocal for the current [MotionConfig] in the composition tree.
 *
 * Prefer using `KoreTheme.motion` over accessing this directly.
 */
val LocalMotionConfig = staticCompositionLocalOf { MotionConfig.Balanced }
