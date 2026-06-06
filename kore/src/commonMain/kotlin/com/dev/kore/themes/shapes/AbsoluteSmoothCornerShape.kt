package com.dev.kore.themes.shapes

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import kotlin.jvm.JvmInline
import kotlin.math.min

/**
 * A shape describing a rectangle with smooth rounded corners sometimes called a
 * Squircle or Superellipse.
 *
 * This shape will not automatically mirror the corners in [LayoutDirection.Rtl], use
 * TODO [SmoothCornerShape] for the layout direction aware version of this shape.
 *
 * @param topLeftRadius the size of the top left corner
 * @param topLeftCornerSmoothing a percentage representing how smooth the top left corner will be
 * @param topRightRadius the size of the top right corner
 * @param topRightCornerSmoothing a percentage representing how smooth the top right corner will be
 * @param bottomRightRadius the size of the bottom right corner
 * @param bottomRightCornerSmoothing a percentage representing how smooth the bottom right corner will be
 * @param bottomLeftRadius the size of the bottom left corner
 * @param bottomLeftCornerSmoothing a percentage representing how smooth the bottom left corner will be
 */
data class AbsoluteSmoothCornerShape(
    private val topLeftRadius: Dp,
    private val topLeftCornerSmoothing: CornerSmoothing = CornerSmoothing.Continuous,
    private val topRightRadius: Dp,
    private val topRightCornerSmoothing: CornerSmoothing = CornerSmoothing.Continuous,
    private val bottomRightRadius: Dp,
    private val bottomRightCornerSmoothing: CornerSmoothing = CornerSmoothing.Continuous,
    private val bottomLeftRadius: Dp,
    private val bottomLeftCornerSmoothing: CornerSmoothing = CornerSmoothing.Continuous
) : CornerBasedShape(
    topStart = CornerSize(topLeftRadius),
    topEnd = CornerSize(topRightRadius),
    bottomEnd = CornerSize(bottomRightRadius),
    bottomStart = CornerSize(bottomLeftRadius)
) {
    override fun createOutline(
        size: Size,
        topStart: Float,
        topEnd: Float,
        bottomEnd: Float,
        bottomStart: Float,
        layoutDirection: LayoutDirection
    ) = when {
        topStart + topEnd + bottomEnd + bottomStart == 0.0f -> {
            Outline.Rectangle(size.toRect())
        }
        topLeftCornerSmoothing.percent + topRightCornerSmoothing.percent +
                bottomRightCornerSmoothing.percent + bottomLeftCornerSmoothing.percent == 0 -> {
            Outline.Rounded(
                RoundRect(
                    rect = size.toRect(),
                    topLeft = CornerRadius(topStart),
                    topRight = CornerRadius(topEnd),
                    bottomRight = CornerRadius(bottomEnd),
                    bottomLeft = CornerRadius(bottomStart)
                )
            )
        }
        else -> {
            Outline.Generic(
                Path().apply {
                    val halfOfShortestSide = min(size.height, size.width) / 2
                    val smoothCornersMap = mutableMapOf<String, SmoothCorner>()

                    var selectedSmoothCorner =
                        smoothCornersMap["$topStart - $topLeftCornerSmoothing"] ?: SmoothCorner(
                            topStart,
                            topLeftCornerSmoothing.percent,
                            halfOfShortestSide
                        )

                    // Top Left Corner
                    moveTo(
                        selectedSmoothCorner.anchorPoint1.distanceToClosestSide,
                        selectedSmoothCorner.anchorPoint1.distanceToFurthestSide
                    )

                    cubicTo(
                        selectedSmoothCorner.controlPoint1.distanceToClosestSide,
                        selectedSmoothCorner.controlPoint1.distanceToFurthestSide,
                        selectedSmoothCorner.controlPoint2.distanceToClosestSide,
                        selectedSmoothCorner.controlPoint2.distanceToFurthestSide,
                        selectedSmoothCorner.anchorPoint2.distanceToClosestSide,
                        selectedSmoothCorner.anchorPoint2.distanceToFurthestSide
                    )

                    arcToRad(
                        rect = Rect(
                            top = 0f,
                            left = 0f,
                            right = selectedSmoothCorner.arcSection.radius * 2,
                            bottom = selectedSmoothCorner.arcSection.radius * 2
                        ),
                        startAngleRadians =
                            (toRadians(180.0) + selectedSmoothCorner.arcSection.arcStartAngle)
                                .toFloat(),
                        sweepAngleRadians = selectedSmoothCorner.arcSection.arcSweepAngle,
                        forceMoveTo = false
                    )

                    cubicTo(
                        selectedSmoothCorner.controlPoint2.distanceToFurthestSide,
                        selectedSmoothCorner.controlPoint2.distanceToClosestSide,
                        selectedSmoothCorner.controlPoint1.distanceToFurthestSide,
                        selectedSmoothCorner.controlPoint1.distanceToClosestSide,
                        selectedSmoothCorner.anchorPoint1.distanceToFurthestSide,
                        selectedSmoothCorner.anchorPoint1.distanceToClosestSide
                    )

                    selectedSmoothCorner =
                        smoothCornersMap["$topEnd - $topRightCornerSmoothing"] ?: SmoothCorner(
                            topEnd,
                            topRightCornerSmoothing.percent,
                            halfOfShortestSide
                        )

                    lineTo(
                        size.width - selectedSmoothCorner.anchorPoint1.distanceToFurthestSide,
                        selectedSmoothCorner.anchorPoint1.distanceToClosestSide
                    )

                    // Top Right Corner
                    cubicTo(
                        size.width - selectedSmoothCorner.controlPoint1.distanceToFurthestSide,
                        selectedSmoothCorner.controlPoint1.distanceToClosestSide,
                        size.width - selectedSmoothCorner.controlPoint2.distanceToFurthestSide,
                        selectedSmoothCorner.controlPoint2.distanceToClosestSide,
                        size.width - selectedSmoothCorner.anchorPoint2.distanceToFurthestSide,
                        selectedSmoothCorner.anchorPoint2.distanceToClosestSide,
                    )

                    arcToRad(
                        rect = Rect(
                            top = 0f,
                            left = size.width - selectedSmoothCorner.arcSection.radius * 2,
                            right = size.width,
                            bottom = selectedSmoothCorner.arcSection.radius * 2
                        ),
                        startAngleRadians =
                            (toRadians(270.0) + selectedSmoothCorner.arcSection.arcStartAngle)
                                .toFloat(),
                        sweepAngleRadians = selectedSmoothCorner.arcSection.arcSweepAngle,
                        forceMoveTo = false
                    )

                    cubicTo(
                        size.width - selectedSmoothCorner.controlPoint2.distanceToClosestSide,
                        selectedSmoothCorner.controlPoint2.distanceToFurthestSide,
                        size.width - selectedSmoothCorner.controlPoint1.distanceToClosestSide,
                        selectedSmoothCorner.controlPoint1.distanceToFurthestSide,
                        size.width - selectedSmoothCorner.anchorPoint1.distanceToClosestSide,
                        selectedSmoothCorner.anchorPoint1.distanceToFurthestSide,
                    )

                    selectedSmoothCorner =
                        smoothCornersMap["$bottomEnd - $bottomRightCornerSmoothing"] ?: SmoothCorner(
                            bottomEnd,
                            bottomRightCornerSmoothing.percent,
                            halfOfShortestSide
                        )

                    lineTo(
                        size.width - selectedSmoothCorner.anchorPoint1.distanceToClosestSide,
                        size.height - selectedSmoothCorner.anchorPoint1.distanceToFurthestSide
                    )

                    // Bottom Right Corner
                    cubicTo(
                        size.width - selectedSmoothCorner.controlPoint1.distanceToClosestSide,
                        size.height - selectedSmoothCorner.controlPoint1.distanceToFurthestSide,
                        size.width - selectedSmoothCorner.controlPoint2.distanceToClosestSide,
                        size.height - selectedSmoothCorner.controlPoint2.distanceToFurthestSide,
                        size.width - selectedSmoothCorner.anchorPoint2.distanceToClosestSide,
                        size.height - selectedSmoothCorner.anchorPoint2.distanceToFurthestSide
                    )

                    arcToRad(
                        rect = Rect(
                            top = size.height - selectedSmoothCorner.arcSection.radius * 2,
                            left = size.width - selectedSmoothCorner.arcSection.radius * 2,
                            right = size.width,
                            bottom = size.height
                        ),
                        startAngleRadians =
                            (toRadians(0.0) + selectedSmoothCorner.arcSection.arcStartAngle)
                                .toFloat(),
                        sweepAngleRadians = selectedSmoothCorner.arcSection.arcSweepAngle,
                        forceMoveTo = false
                    )

                    cubicTo(
                        size.width - selectedSmoothCorner.controlPoint2.distanceToFurthestSide,
                        size.height - selectedSmoothCorner.controlPoint2.distanceToClosestSide,
                        size.width - selectedSmoothCorner.controlPoint1.distanceToFurthestSide,
                        size.height - selectedSmoothCorner.controlPoint1.distanceToClosestSide,
                        size.width - selectedSmoothCorner.anchorPoint1.distanceToFurthestSide,
                        size.height - selectedSmoothCorner.anchorPoint1.distanceToClosestSide
                    )

                    selectedSmoothCorner =
                        smoothCornersMap["$bottomStart - $bottomLeftCornerSmoothing"] ?: SmoothCorner(
                            bottomStart,
                            bottomLeftCornerSmoothing.percent,
                            halfOfShortestSide
                        )

                    lineTo(
                        selectedSmoothCorner.anchorPoint1.distanceToFurthestSide,
                        size.height - selectedSmoothCorner.anchorPoint1.distanceToClosestSide
                    )

                    // Bottom Left Corner
                    cubicTo(
                        selectedSmoothCorner.controlPoint1.distanceToFurthestSide,
                        size.height - selectedSmoothCorner.controlPoint1.distanceToClosestSide,
                        selectedSmoothCorner.controlPoint2.distanceToFurthestSide,
                        size.height - selectedSmoothCorner.controlPoint2.distanceToClosestSide,
                        selectedSmoothCorner.anchorPoint2.distanceToFurthestSide,
                        size.height - selectedSmoothCorner.anchorPoint2.distanceToClosestSide,
                    )

                    arcToRad(
                        rect = Rect(
                            top = size.height - selectedSmoothCorner.arcSection.radius * 2,
                            left = 0f,
                            right = selectedSmoothCorner.arcSection.radius * 2,
                            bottom = size.height
                        ),
                        startAngleRadians =
                            (toRadians(90.0) + selectedSmoothCorner.arcSection.arcStartAngle)
                                .toFloat(),
                        sweepAngleRadians = selectedSmoothCorner.arcSection.arcSweepAngle,
                        forceMoveTo = false
                    )

                    cubicTo(
                        selectedSmoothCorner.controlPoint2.distanceToClosestSide,
                        size.height - selectedSmoothCorner.controlPoint2.distanceToFurthestSide,
                        selectedSmoothCorner.controlPoint1.distanceToClosestSide,
                        size.height - selectedSmoothCorner.controlPoint1.distanceToFurthestSide,
                        selectedSmoothCorner.anchorPoint1.distanceToClosestSide,
                        size.height - selectedSmoothCorner.anchorPoint1.distanceToFurthestSide
                    )

                    close()

                }
            )
        }
    }

    override fun copy(
        topStart: CornerSize,
        topEnd: CornerSize,
        bottomEnd: CornerSize,
        bottomStart: CornerSize
    ) = AbsoluteSmoothCornerShape(
        topLeftRadius,
        topLeftCornerSmoothing,
        topRightRadius,
        topRightCornerSmoothing,
        bottomRightRadius,
        bottomRightCornerSmoothing,
        bottomLeftRadius,
        bottomLeftCornerSmoothing
    )
}

/**
 * Creates AbsoluteSmoothCornerShape with the same corner radius and smoothness applied for
 * all four corners.
 *
 * @param cornerRadius the size of the corners for the shape
 * @param cornerSmoothing a percentage representing how smooth the corners will be
 */
fun AbsoluteSmoothCornerShape(cornerRadius: Dp, cornerSmoothing: CornerSmoothing = CornerSmoothing.Companion.Continuous) =
    AbsoluteSmoothCornerShape(
        topLeftRadius = cornerRadius,
        topLeftCornerSmoothing = cornerSmoothing,
        topRightRadius = cornerRadius,
        topRightCornerSmoothing = cornerSmoothing,
        bottomRightRadius = cornerRadius,
        bottomRightCornerSmoothing = cornerSmoothing,
        bottomLeftRadius = cornerRadius,
        bottomLeftCornerSmoothing = cornerSmoothing
    )



@JvmInline
value class CornerSmoothing(val percent: Int) {
    init {
        require(percent in 0..100) {
            "Corner smoothing must be between 0 and 100"
        }
    }

    companion object {
        val Subtle = CornerSmoothing(25)
        val Balanced = CornerSmoothing(50)
        val Smooth = CornerSmoothing(75)
        val Continuous = CornerSmoothing(100)
    }
}