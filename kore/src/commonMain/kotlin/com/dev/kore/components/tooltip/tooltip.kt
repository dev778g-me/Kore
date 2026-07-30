package com.dev.kore.components.tooltip

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.rememberTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.MutatorMutex
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.retain.retain
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.paneTitle
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import androidx.compose.ui.window.PopupProperties
import com.dev.kore.themes.KoreTheme
import com.dev.kore.themes.LocalContentColor
import com.dev.kore.themes.LocalTextStyle
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeout

/**
 * [Tooltip] is a popup that displays information related to children component when the component is hovered or long pressed.
 * @param modifier the modifier applied to the Tooltip [Modifier].
 * @param toolTipState the state of the tooltip [ToolTipState]
 *@param position The preferred position of the tooltip relative to the children composable [TooltipPositions] defaults to [TooltipPositions.Top].
 * @param positionProvider The [PopupPositionProvider] responsible for placing the tooltip.
 * @param containerColor the tooltip container color [Color].
 * @param contentColor the tooltip content color [Color].
 * @param shape the shape of the tooltip [Shape].
 * @param elevation the elevation of the tooltip popup [Dp].
 * @param borderStroke the optional border for the tooltip [BorderStroke]
 * @param tooltipContent the information related to the children component [Composable]
 * @param content the children composable which information to be shown [Composable]
 */
@Composable
fun Tooltip(
    modifier: Modifier = Modifier,
    toolTipState: ToolTipState = rememberTooltipState(),
    position: TooltipPositions = TooltipPositions.Top,
    positionProvider: PopupPositionProvider = TooltipDefaults.rememberTooltipPosition(tooltipPosition = position),
    containerColor: Color = KoreTheme.colorScheme.surface,
    contentColor: Color = KoreTheme.colorScheme.onSurface,
    shape: Shape = KoreTheme.shapes.xs,
    elevation: Dp = TooltipDefaults.defaultTooltipElevation,
    borderStroke: BorderStroke? = null,
    tooltipContent: @Composable () -> Unit,
    content: @Composable () -> Unit
) {


    val scope = rememberCoroutineScope()
    val mutableTransitionState = remember { MutableTransitionState(toolTipState.isVisible) }
    mutableTransitionState.targetState = toolTipState.isVisible
    val transition = rememberTransition(mutableTransitionState)

    val scale by transition.animateFloat(
        transitionSpec = {
            if (initialState isTransitioningTo targetState) {
                spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            } else {
                spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessLow
                )
            }
        },


        ) {
        if (it) 1f else 0.85f
    }

    val toolTipAlpha by transition.animateFloat(
        transitionSpec = {
            if (initialState isTransitioningTo targetState) {
                spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessLow
                )
            } else {
                spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessVeryLow
                )
            }
        },
    ) { isVisible ->
        if (isVisible) 1f else 0f
    }

    val isToolTipVisible = mutableTransitionState.currentState || mutableTransitionState.targetState

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier.handleToolTipGesture(
                enabled = true,
                state = toolTipState

            )
        ) {
            content()
        }


            if (isToolTipVisible) {
                Popup(
                    popupPositionProvider = positionProvider,
                    onDismissRequest = {
                        scope.launch {
                            toolTipState.dismiss()
                        }
                    },
                    properties = PopupProperties(focusable = false)
                ) {
                    Box(
                        modifier = Modifier
                            .graphicsLayer {
                                scaleX = scale
                                scaleY = scale
                                alpha = toolTipAlpha
                            }
                            .semantics {
                                liveRegion = LiveRegionMode.Assertive
                                paneTitle = "tooltip"
                            }.shadow(
                                elevation = elevation,
                                shape = shape,
                                clip = true
                            )
                            .clip(shape = shape)
                            .background(containerColor, shape)
                            .then(if (borderStroke != null) {
                                Modifier.border(borderStroke, shape)
                            } else Modifier)
                            .padding(8.dp)
                    ) {
                        CompositionLocalProvider(
                            LocalContentColor provides contentColor,
                            LocalTextStyle provides KoreTheme.typography.label3
                        ) {
                            tooltipContent()
                        }
                    }
                }
            }
        }

    DisposableEffect(
        toolTipState
    ) {
        onDispose {
            toolTipState.onDispose()
        }
    }

}


/**
 * [TooltipDefaults] defines the default values for the [Tooltip]
 * @property defaultTooltipElevation the default elevation of the Tooltip.
 * @property defaultVisibleDurationMillis the default Ms for which the tooltip will be visible.
 * @property rememberTooltipPosition the default position provider for the tooltip [PopupPositionProvider].
 *
 */

object TooltipDefaults{

    val defaultTooltipElevation : Dp = 2.dp


    val defaultVisibleDurationMillis : Long =  2000L
    @Composable
    fun rememberTooltipPosition(
        spacing : Dp = 4.dp,
        tooltipPosition: TooltipPositions = TooltipPositions.Top
    ) : PopupPositionProvider{
        val tooltipAnchorSpacing =
            with(LocalDensity.current) { spacing.roundToPx() }
        return remember(spacing) {
            object : PopupPositionProvider {
                override fun calculatePosition(
                    anchorBounds: IntRect,
                    windowSize: IntSize,
                    layoutDirection: LayoutDirection,
                    popupContentSize: IntSize
                ): IntOffset {

                    return when (tooltipPosition) {
                        TooltipPositions.Top -> {
                            val x = anchorBounds.left + (anchorBounds.width - popupContentSize.width) / 2

                            var y = anchorBounds.top - popupContentSize.height - tooltipAnchorSpacing

                            if (y < 0) {
                                y = anchorBounds.bottom + tooltipAnchorSpacing
                            }

                            IntOffset(x, y)
                        }

                        TooltipPositions.Right -> {
                            val y = anchorBounds.top + (anchorBounds.height - popupContentSize.height) / 2
                            var x = anchorBounds.right + tooltipAnchorSpacing
                            if (popupContentSize.width + x >= windowSize.width) {
                                x = anchorBounds.left - popupContentSize.width - tooltipAnchorSpacing
                            }
                            IntOffset(x, y)
                        }

                        TooltipPositions.Left -> {

                            val y = anchorBounds.top + (anchorBounds.height - popupContentSize.height) / 2

                            var x = anchorBounds.left - popupContentSize.width - tooltipAnchorSpacing

                            if (x < 0) {
                                x = anchorBounds.right + tooltipAnchorSpacing
                            }

                            IntOffset(x, y)
                        }

                        TooltipPositions.Bottom -> {
                            val x = anchorBounds.left + (anchorBounds.width - popupContentSize.width) / 2

                            var y = anchorBounds.bottom + tooltipAnchorSpacing

                            if (y + popupContentSize.height > windowSize.height) {
                                y = anchorBounds.top - popupContentSize.height - tooltipAnchorSpacing
                            }

                            IntOffset(x, y)
                        }
                    }
                }
            }}



    }
}

/**
 * [TooltipPositions] defines the position of the tooltip relative to the children composable.
 */
enum class TooltipPositions{
    Top,
    Left,
    Right,
    Bottom,
}


@Composable
fun rememberTooltipState(
    initialIsVisible : Boolean = false,
    isPersistent : Boolean = false,
    mutatorMutex: MutatorMutex? = null
): ToolTipState{

    val mutex = remember { mutatorMutex ?: MutatorMutex() }
    return remember (isPersistent, mutex) {
        TooltipStateImpl(
            initialIsVisible = initialIsVisible,
            isPersistent = isPersistent,
            mutatorMutex = mutex
        )
    }
}

@Stable
private class TooltipStateImpl(
    initialIsVisible: Boolean,
    override val isPersistent: Boolean,
    private val mutatorMutex: MutatorMutex
): ToolTipState{
    override val transition: MutableTransitionState<Boolean> = MutableTransitionState(initialState = initialIsVisible)


    override val isVisible: Boolean
        get() = transition.currentState || transition.targetState


    private var job : (CancellableContinuation<Unit>)? = null

    override suspend fun show(mutatePriority: MutatePriority){
        val cancellableShow : suspend () -> Unit = {
            suspendCancellableCoroutine {
                transition.targetState = true
                job = it
            }
        }


        mutatorMutex.mutate(mutatePriority) {
            try {
                if (isPersistent) {
                    cancellableShow()
                } else {
                    withTimeout(TooltipDefaults.defaultVisibleDurationMillis) {
                        cancellableShow()
                    }
                }
            } finally {
                if (mutatePriority != MutatePriority.PreventUserInput) {
                    dismiss()
                }
            }
        }
    }

    override fun dismiss() {
           transition.targetState = false
    }

    override fun onDispose(){
        job?.cancel()
    }
}

/*
 Tooltip state
 */
interface ToolTipState{

    // current transition toolTipState

    val transition : MutableTransitionState<Boolean>


    // boolean state of is visible or not
    val isVisible : Boolean

    val isPersistent : Boolean

    suspend fun show(mutatePriority: MutatePriority = MutatePriority.Default)

    fun dismiss()

    fun onDispose()

}


private fun Modifier.handleToolTipGesture(enabled: Boolean, state: ToolTipState): Modifier =
    if (enabled) {
        this.pointerInput(state) {
            coroutineScope {

                awaitEachGesture {

                    // variable to track whether it is a long press or not
                    val isLongPressed: MutableStateFlow<Boolean> = MutableStateFlow(false)

                    // the default time out to decide whether it's a long press
                    val pressTimeOut = viewConfiguration.longPressTimeoutMillis


                    // initial pass to consume children pointer events
                    val pass = PointerEventPass.Initial

                    val inputType = awaitFirstDown(
                        pass = pass
                    ).type

                    if (inputType == PointerType.Touch || inputType == PointerType.Stylus) {

                        try {
                            withTimeout(pressTimeOut) {
                                waitForUpOrCancellation(pass)
                            }
                        } catch (_: PointerEventTimeoutCancellationException) {
                            launch(start = CoroutineStart.UNDISPATCHED) {
                                try {
                                    isLongPressed.tryEmit(true)
                                    state.show(MutatePriority.PreventUserInput)
                                } finally {
                                    isLongPressed.collectLatest { isLongPressed ->
                                        if (!isLongPressed) {
                                            state.dismiss()
                                        }
                                    }

                                }
                            }

                            val upEvent = waitForUpOrCancellation(pass)
                            upEvent?.consume()

                        } finally {
                            launch {
                                // delaying the tooltip disappearance
                                delay(TooltipDefaults.defaultVisibleDurationMillis)
                                isLongPressed.tryEmit(false)
                            }
                        }

                    }

                }

            }
        }.pointerInput(state) {
            coroutineScope {
                awaitPointerEventScope {
                    val pass = PointerEventPass.Main

                    while (true) {
                        val event = awaitPointerEvent(pass)
                        val inputType = event.changes[0].type
                        if (inputType == PointerType.Mouse) {
                            when (event.type) {
                                PointerEventType.Enter -> {
                                    launch { state.show(MutatePriority.UserInput) }
                                }

                                PointerEventType.Exit -> {
                                    state.dismiss()
                                }
                            }
                        }
                    }
                }
            }
        }
    } else this

