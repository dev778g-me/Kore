package com.dev.korelibrary.components.dropdown

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.window.PopupPositionProvider
import kotlin.math.max
import kotlin.math.min


/*
possibilities
*[Vertical positions]
> top to bottom - menu top align to composable (anchor)
> bottom to top  - menu bottom align to composable (anchor)
> center to top  - menu center align to top

*[Horizontal positions]
>
*/













@Stable
internal object DropDownPosition {

    // this interface ->>> calculate

    @Stable
    fun interface VerticalPosition {
        fun position(
            anchorBounds: IntRect,
            windowSize: IntSize,
            menuHeight: Int,
        ): Int
    }

@Stable
    fun interface HorizontalPosition{
        fun position(
            anchorBounds: IntRect,
            windowSize: IntSize,
            menuWidth: Int,
            layoutDirection: LayoutDirection
        ) : Int
    }


    // menu top aligns with composable -> anchor
    fun menuTopToAnchorBottom(offset: Int = 0): VerticalPosition {
        return AnchorAlignmentOffsetPosition.Vertical(
            menuAlignment = Alignment.Top,
            anchorAlignment = Alignment.Bottom,
            offset = offset
        )
    }

    fun menuBottomToAnchorTop(offset: Int = 0): VerticalPosition {
        return AnchorAlignmentOffsetPosition.Vertical(
            menuAlignment = Alignment.Bottom,
            anchorAlignment = Alignment.Top,
            offset = offset
        )
    }


    fun menuCenterToAnchorTop(offset: Int = 0) : VerticalPosition {
        return AnchorAlignmentOffsetPosition.Vertical(
            menuAlignment = Alignment.CenterVertically,
            anchorAlignment = Alignment.Top,
            offset = offset
        )
    }


    fun menuTopToWindowTop(margin: Int = 0) : VerticalPosition {
        return WindowAlignmentPosition.Vertical(
            alignment = Alignment.Top,
            margin = margin
        )
    }

    fun menuBottomToWindowBottom(margin: Int = 0) : VerticalPosition{
        return WindowAlignmentPosition.Vertical(
            alignment = Alignment.Bottom,
            margin = margin
        )
    }


    fun menuStartToAnchorStart(offset: Int = 0): HorizontalPosition {
        return AnchorAlignmentOffsetPosition.Horizontal(
            menuAlignment = Alignment.Start,
            anchorAlignment = Alignment.Start,
            offset = offset,
        )
    }

    fun menuEndToAnchorEnd(offset: Int = 0): HorizontalPosition {
        return AnchorAlignmentOffsetPosition.Horizontal(
            menuAlignment = Alignment.End,
            anchorAlignment = Alignment.End,
            offset = offset
        )
    }

    fun menuLeftToWindowLeft(margin: Int = 0) : HorizontalPosition{
        return WindowAlignmentPosition.Horizontal(
            alignment = AbsoluteAlignment.Left,
            margin = margin
        )
    }


    fun menuRightToWindowRight (margin: Int = 0) : HorizontalPosition {
        return WindowAlignmentPosition.Horizontal(
            alignment = AbsoluteAlignment.Right,
            margin = margin
        )
    }


}







@Immutable
internal object AnchorAlignmentOffsetPosition{

    @Immutable
    data class Vertical(
        private val menuAlignment: Alignment.Vertical,
        private val anchorAlignment: Alignment.Vertical,
        private val offset: Int
    ) : DropDownPosition.VerticalPosition{
        override fun position(
            anchorBounds: IntRect,
            windowSize: IntSize,
            menuHeight: Int
        ): Int {
            val anchorAlignmentOffset = anchorAlignment.align(
                size = 0,
                space = anchorBounds.height
            )

            val dropDownAlignmentOffset = - menuAlignment.align(
                size = 0,
                space = menuHeight,
            )


            val finalOffset = anchorBounds.top + anchorAlignmentOffset + dropDownAlignmentOffset + offset


            return finalOffset

        }
    }

    @Immutable
    data class Horizontal(
        private val menuAlignment: Alignment.Horizontal,
        private val anchorAlignment: Alignment.Horizontal,
        private val offset: Int
    ) : DropDownPosition.HorizontalPosition{
        override fun position(
            anchorBounds: IntRect,
            windowSize: IntSize,
            menuWidth: Int,
            layoutDirection: LayoutDirection
        ): Int {
            // align -> align the composable to box hardcoding 0 so that ancAlignOffset = width of the composable
            val anchorAlignmentOffset = anchorAlignment.align(
                size = 0,
                space = anchorBounds.width,
                layoutDirection = layoutDirection
            )

            val dropDownAlignmentOffset = - menuAlignment.align(
                size = 0,
                space = menuWidth,
                layoutDirection = layoutDirection
            )

            val finalOffset = anchorBounds.left + anchorAlignmentOffset + dropDownAlignmentOffset + offset

            return finalOffset
        }
    }

}



@Immutable
internal object WindowAlignmentPosition{


    @Immutable
    data class Vertical (
        private val alignment: Alignment.Vertical,
        private val  margin : Int,
    ) : DropDownPosition.VerticalPosition{
        override fun position(
            anchorBounds: IntRect,
            windowSize: IntSize,
            menuHeight: Int
        ): Int {
            if (menuHeight >= windowSize.height - 2 * margin){
             return Alignment.CenterVertically.align(
                 size = menuHeight,
                 space = windowSize.height
             )
            }

            val y = alignment.align(
                size = menuHeight,
                space = windowSize.height
            )

            return y.coerceIn(margin..windowSize.height - margin - menuHeight)

        }
    }


    @Immutable
    data class Horizontal(
        private val alignment: Alignment.Horizontal,
        private val margin: Int
    ) : DropDownPosition.HorizontalPosition{
        override fun position(
            anchorBounds: IntRect,
            windowSize: IntSize,
            menuWidth: Int,
            layoutDirection: LayoutDirection
        ): Int {
            if (menuWidth >= windowSize.width - 2* margin) {
                return Alignment.CenterHorizontally.align(
                    size = menuWidth,
                    space = windowSize.width,
                    layoutDirection = layoutDirection
                )
            }


            val x = alignment.align(
                size = menuWidth,
                space = windowSize.width,
                layoutDirection = layoutDirection
            )

            return x.coerceIn(margin .. windowSize.width - margin - menuWidth)

        }
    }

}




@Immutable
internal data class DropDownMenuPositionProvider(
    val contentOffset : DpOffset,
    val density: Density,
    val verticalMargin : Int = with(density) { DropdownDefaults.defaultDropDownMargin.roundToPx() },
    val onPositionCalculated : (anchorBounds : IntRect , menuBounds : IntRect) -> Unit = {_, _->}
) : PopupPositionProvider{

    // vertical positions
    private val menuTopToAnchorBottom: DropDownPosition.VerticalPosition
    private val menuBottomToAnchorTop: DropDownPosition.VerticalPosition
    private val menuCenterToAnchorTop: DropDownPosition.VerticalPosition
    private val menuTopToWindowTop: DropDownPosition.VerticalPosition
    private val menuBottomToWindowBottom: DropDownPosition.VerticalPosition


    // horizontal positions
    private val menuStartToAnchorStart : DropDownPosition.HorizontalPosition
    private val menuEndToAnchorEnd : DropDownPosition.HorizontalPosition
    private val menuLeftToWindowLeft : DropDownPosition.HorizontalPosition
    private val menuRightToWindowRight : DropDownPosition.HorizontalPosition


    init {
        val contentOffsetY = with(density) {contentOffset.y.roundToPx()}
        //vertical
        menuTopToAnchorBottom = DropDownPosition.menuTopToAnchorBottom(offset = contentOffsetY)
        menuBottomToAnchorTop = DropDownPosition.menuBottomToAnchorTop(offset = contentOffsetY)
        menuCenterToAnchorTop = DropDownPosition.menuCenterToAnchorTop(offset = contentOffsetY)
        menuTopToWindowTop = DropDownPosition.menuTopToWindowTop(margin = verticalMargin)
        menuBottomToWindowBottom = DropDownPosition.menuBottomToWindowBottom(margin = verticalMargin)


        // horizontal
        val contentOffsetX = with(density) {contentOffset.x.roundToPx()}
        menuStartToAnchorStart = DropDownPosition.menuStartToAnchorStart(offset = contentOffsetX)
        menuEndToAnchorEnd = DropDownPosition.menuEndToAnchorEnd(offset = contentOffsetX)
        menuLeftToWindowLeft = DropDownPosition.menuLeftToWindowLeft()
        menuRightToWindowRight = DropDownPosition.menuRightToWindowRight()

    }


    override fun calculatePosition(
        anchorBounds: IntRect,
        windowSize: IntSize,
        layoutDirection: LayoutDirection,
        popupContentSize: IntSize
    ): IntOffset {
        val yCandidates = listOf(
            menuTopToAnchorBottom,
            menuBottomToAnchorTop,
            menuCenterToAnchorTop,
           if (anchorBounds.center.y < windowSize.height /2){
               menuTopToWindowTop
           }else {
               menuBottomToWindowBottom
           }
        )

        var y = 0

        for (index in yCandidates.indices){
            val candidate = yCandidates[index].position(
                anchorBounds = anchorBounds,
                windowSize = windowSize,
                menuHeight = popupContentSize.height
            )

            if (index == yCandidates.lastIndex || candidate > verticalMargin && candidate + popupContentSize.height <= windowSize.height- verticalMargin){
                y = candidate
                break
            }
        }



        val xCandidates = listOf<DropDownPosition.HorizontalPosition>(
            menuStartToAnchorStart,
            menuEndToAnchorEnd,
            if (anchorBounds.center.x < windowSize.width /2){
                menuLeftToWindowLeft
            }else{
                menuRightToWindowRight
            }
        )

        var x = 0


        for (index in xCandidates.indices){
            val candidate = xCandidates[index].position(
                anchorBounds = anchorBounds,
                windowSize = windowSize,
                menuWidth = popupContentSize.width,
                layoutDirection = layoutDirection,
            )

            if (index == xCandidates.lastIndex || candidate>0 && candidate + popupContentSize.width <= windowSize.width){
                x = candidate
                break
            }
        }

        val menuOffset = IntOffset(x = x, y = y)

        onPositionCalculated(
            anchorBounds,
            IntRect(offset = menuOffset, size = popupContentSize)
        )


        return menuOffset


    }
}




//copied and pasted from m3

internal fun calculateTransformOrigin(anchorBounds: IntRect, menuBounds: IntRect): TransformOrigin {
    val pivotX =
        when {
            menuBounds.left >= anchorBounds.right -> 0f
            menuBounds.right <= anchorBounds.left -> 1f
            menuBounds.width == 0 -> 0f
            else -> {
                val intersectionCenter =
                    (max(anchorBounds.left, menuBounds.left) +
                            min(anchorBounds.right, menuBounds.right)) / 2
                (intersectionCenter - menuBounds.left).toFloat() / menuBounds.width
            }
        }
    val pivotY =
        when {
            menuBounds.top >= anchorBounds.bottom -> 0f
            menuBounds.bottom <= anchorBounds.top -> 1f
            menuBounds.height == 0 -> 0f
            else -> {
                val intersectionCenter =
                    (max(anchorBounds.top, menuBounds.top) +
                            min(anchorBounds.bottom, menuBounds.bottom)) / 2
                (intersectionCenter - menuBounds.top).toFloat() / menuBounds.height
            }
        }
    return TransformOrigin(pivotX, pivotY)
}















