package com.c0de_h0ng.library.util

import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by c0de_h0ng on 2022/02/06.
 */

fun onRecyclerViewScrollListener(listener: RecyclerViewScrollDetectListener): RecyclerView.OnScrollListener {
    return object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            try {
                val lastVisibleItemPosition = (recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
                recyclerView.adapter?.let {
                    val itemTotalCount = it.itemCount - 1
                    if (lastVisibleItemPosition == itemTotalCount) {
                        listener.scrollDetectLastItem()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

interface RecyclerViewScrollDetectListener {
    fun scrollDetectLastItem()
}

fun onNestedScrollDetectListener(listener: ScrollDetectListener): NestedScrollView.OnScrollChangeListener {
    return NestedScrollView.OnScrollChangeListener { v, _, scrollY, _, oldScrollY ->
        if (scrollY > oldScrollY) {
            ChlibLog.debug("스크롤 업")
            listener.scrollDetectLastItem(DetectPosition.UP)
        }
        if (scrollY < oldScrollY) {
            ChlibLog.debug("스크롤 다운")
            listener.scrollDetectLastItem(DetectPosition.DOWN)
        }
        if (scrollY == 0) {
            ChlibLog.debug("스크롤 탑")
            listener.scrollDetectLastItem(DetectPosition.TOP)
        }
        if (scrollY ==  v.getChildAt(0).measuredHeight -  v.measuredHeight) {
            ChlibLog.debug("스크롤 바닥")
            listener.scrollDetectLastItem(DetectPosition.BOTTOM)
        }
    }
}

interface ScrollDetectListener {
    fun scrollDetectLastItem(position: DetectPosition)
}

enum class DetectPosition {
    UP, DOWN, TOP, BOTTOM
}