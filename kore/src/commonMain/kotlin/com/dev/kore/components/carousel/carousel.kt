package com.dev.kore.components.carousel

import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.TargetedFlingBehavior
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.kore.themes.KoreTheme


/**
 * Creates and remembers a [CarouselState] that survives configuration changes and process death.
 *
 * @param initialPage The initial page index to be displayed when the state is first created.
 * @param pageCount A lambda returning the total number of pages in the carousel.
 * @return A remembered instance of [CarouselState].
 */
@Composable
fun rememberCarouselState(
    initialPage: Int,
    pageCount: () -> Int
): CarouselState{
    return rememberSaveable(saver = CarouselState.Saver){
        CarouselState(initialPage, pageCount)
    }.apply { pagerState.mutablePageCountState.value = pageCount }
}


class CarouselState(
    initialPage: Int,
    pageCount : () -> Int
) : ScrollableState{

    internal var pagerState : CarouselPagerState = CarouselPagerState(initialPage, pageCount)



    override fun dispatchRawDelta(delta: Float): Float {
          return  pagerState.dispatchRawDelta(delta)
    }

    override suspend fun scroll(
        scrollPriority: MutatePriority,
        block: suspend ScrollScope.() -> Unit
    ){
        pagerState.scroll(scrollPriority, block)
    }

    override val isScrollInProgress: Boolean
        get() = pagerState.isScrollInProgress


    /**
     * saver for carousel state
     */
    companion object {
        val Saver: Saver<CarouselState, *> =
            listSaver(
                save = {
                    listOf(
                        it.pagerState.currentPage,
                        it.pagerState.pageCount,
                    )
                },
                restore = {
                    CarouselState(
                        initialPage = it[0] as Int,
                        pageCount = {it[1] as Int}
                    )
                }
            )
    }
}

internal class CarouselPagerState(
    currentPage : Int,
    updatedPageCount : () -> Int
) : PagerState(currentPage){
    var mutablePageCountState = mutableStateOf(updatedPageCount)
    override val pageCount: Int
        get() = mutablePageCountState.value.invoke()

    companion object{
        val Saver: Saver<CarouselPagerState, *> = listSaver(
            save = {listOf(it.currentPage, it.mutablePageCountState.value)},
            restore = {
                CarouselPagerState(
                    currentPage = it[0] as Int,
                    updatedPageCount = { it[1] as Int }
                )
            }
        )
    }

}

/**
 * A component used to showcase multiple pieces of content in a compact and engaging way.
 *
 * @param state The state of the carousel, which controls scrolling and page selection.
 * @param modifier The [Modifier] applied to the carousel group layout.
 * @param carouselContentWidth The preferred width of the carousel items. If [fillContainer] is
 *        set to `false`, this width will be applied to each individual carousel item.
 * @param fillContainer A [Boolean] flag to decide whether the carousel items should fill the
 *        entire available space or use their preferred width.
 * @param orientation The [Orientation] of the carousel, defaults to [Orientation.Horizontal].
 * @param verticalAlignment The [Alignment.Vertical] to be applied to the carousel items
 *        when the [orientation] is [Orientation.Horizontal].
 * @param horizontalAlignment The [Alignment.Horizontal] to be applied to the carousel items
 *        when the [orientation] is [Orientation.Vertical].
 * @param contentPaddingValues The [PaddingValues] applied around the carousel items.
 * @param filingBehavior The [TargetedFlingBehavior] that dictates the scrolling and snapping
 *        physics of the carousel pager.
 * @param carouselItemSpacing The [Dp] spacing between each carousel item.
 * @param carouselItems The content lambda that defines the items inside the carousel,
 *        providing the [PagerScope] and the current [page] index.
 */
@Composable
fun CarouselGroup(
    state: CarouselState,
    modifier: Modifier = Modifier,
    carouselContentWidth: Dp = CarouselDefaults.defaultCarouselItemWidth,
    fillContainer: Boolean = true,
    orientation: Orientation = Orientation.Horizontal,
    verticalAlignment: Alignment.Vertical,
    horizontalAlignment: Alignment.Horizontal,
    contentPaddingValues: PaddingValues = CarouselDefaults.defaultCarouselContentPaddingValues,
    filingBehavior: TargetedFlingBehavior = PagerDefaults.flingBehavior(state.pagerState),
    carouselItemSpacing: Dp = CarouselDefaults.defaultCarouselItemSpacing,
    carouselItems: @Composable PagerScope.(page: Int) -> Unit
){

    if (orientation == Orientation.Horizontal){
        HorizontalCarouselGroup(
            state = state,
            modifier = modifier,
            carouselContentWidth = carouselContentWidth,
            verticalAlignment = verticalAlignment,
            fillContainer = fillContainer,
            filingBehavior = filingBehavior,
            contentPaddingValues = contentPaddingValues,
            carouselItemSpacing = carouselItemSpacing,
            pageContent = carouselItems
        )
    }else {
        VerticalCarouselGroup(
            state = state,
            modifier = modifier,
            carouselContentWidth = carouselContentWidth,
            horizontalAlignment = horizontalAlignment,
            fillContainer = fillContainer,
            filingBehavior = filingBehavior,
            contentPaddingValues = contentPaddingValues,
            carouselItemSpacing = carouselItemSpacing,
            pageContent = carouselItems
        )
    }

}

/**
*  horizontal layout variant of the carousel component used to showcase horizontally scrolling content.
*
* @param state The state of the carousel, which controls scrolling and page selection.
* @param modifier The [Modifier] applied to the horizontal carousel layout.
* @param carouselContentWidth The preferred width of individual carousel items when [fillContainer] is `false`.
* @param verticalAlignment The [Alignment.Vertical] applied to align carousel items vertically within the layout.
* @param fillContainer A [Boolean] flag indicating whether carousel items should fill the entire available width.
* @param filingBehavior The [TargetedFlingBehavior] governing the scrolling and snapping physics of the pager.
* @param contentPaddingValues The [PaddingValues] applied around the carousel items.
* @param carouselItemSpacing The [Dp] spacing between adjacent carousel items.
* @param pageContent The content lambda defining the individual items inside the carousel, providing the [PagerScope] and the current [page] index.
*/

@Composable
private fun HorizontalCarouselGroup(
    state: CarouselState,
    modifier: Modifier = Modifier,
    carouselContentWidth: Dp,
    verticalAlignment: Alignment.Vertical,
    fillContainer: Boolean = true,
    filingBehavior: TargetedFlingBehavior,
    contentPaddingValues: PaddingValues,
    carouselItemSpacing: Dp,
    pageContent: @Composable PagerScope.(page: Int) -> Unit,
){
    HorizontalPager(
        modifier = modifier.fillMaxWidth(),
        pageSpacing = carouselItemSpacing,
        verticalAlignment = verticalAlignment,
        flingBehavior = filingBehavior,
        pageSize = if (fillContainer) PageSize.Fill else PageSize.Fixed(carouselContentWidth),
        contentPadding = contentPaddingValues,
        state = state.pagerState,
        snapPosition = SnapPosition.End,
        pageContent = { pageContent(it) }
    )
}

/**
 *  vertical layout variant of the carousel component used to showcase vertically scrolling content.
 *
 * @param state The state of the carousel, which controls scrolling and page selection.
 * @param modifier The [Modifier] applied to the vertical carousel layout.
 * @param carouselContentWidth The preferred width of individual carousel items when [fillContainer] is `false`.
 * @param horizontalAlignment The [Alignment.Horizontal] applied to align carousel items horizontally within the layout.
 * @param fillContainer A [Boolean] flag indicating whether carousel items should fill the entire available height.
 * @param filingBehavior The [TargetedFlingBehavior] governing the scrolling and snapping physics of the pager.
 * @param contentPaddingValues The [PaddingValues] applied around the carousel items.
 * @param carouselItemSpacing The [Dp] spacing between adjacent carousel items.
 * @param pageContent The content lambda defining the individual items inside the carousel, providing the [PagerScope] and the current [page] index.
 */
@Composable
private fun VerticalCarouselGroup(
    state: CarouselState,
    modifier: Modifier = Modifier,
    carouselContentWidth: Dp,
    horizontalAlignment: Alignment.Horizontal,
    fillContainer: Boolean = true,
    filingBehavior: TargetedFlingBehavior,
    contentPaddingValues: PaddingValues,
    carouselItemSpacing: Dp,
    pageContent: @Composable PagerScope.(page: Int) -> Unit
){
    VerticalPager(
        modifier = modifier.fillMaxWidth(),
        pageSpacing = carouselItemSpacing,
        horizontalAlignment = horizontalAlignment,
        flingBehavior = filingBehavior,
        pageSize = if (fillContainer) PageSize.Fill else PageSize.Fixed(carouselContentWidth),
        contentPadding = contentPaddingValues,
        state = state.pagerState,
        snapPosition = SnapPosition.End,
        pageContent = { pageContent(it) }
    )
}


/**
 * the defaults values for CarouselGroup
 * @property defaultCarouselItemSpacing the defalut  spacing between each carousel in a carousel group .
 * @property defaultCarouselContentPaddingValues the default content padding values for carouselGroup .
 * @property defaultCarouselItemWidth the default carousel item width if fill is false,
 */
object CarouselDefaults{
    val defaultCarouselItemSpacing : Dp
        @Composable get() = KoreTheme.sizes.sm


    val defaultCarouselContentPaddingValues : PaddingValues = PaddingValues(8.dp)


    val defaultCarouselItemWidth : Dp = 300.dp

}