package com.c0de_h0ng.library.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * Created by c0de_h0ng on 2022/02/06.
 */
abstract class BaseViewPagerAdapter<T> constructor(
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, BaseViewHolder<T, *>>(diffCallback) {


    override fun onFailedToRecycleView(holder: BaseViewHolder<T, *>): Boolean {
        holder.itemView.animation?.cancel()
        return true
    }


    override fun onViewDetachedFromWindow(holder: BaseViewHolder<T, *>) {
        holder.unbind()
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T, *>, position: Int) {
        val itemList: List<T> by lazy { listOf(currentList.last()) + currentList + listOf(currentList.first()) }
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return if (currentList.isNotEmpty()) {
            val itemList: List<T> by lazy { listOf(currentList.last()) + currentList + listOf(currentList.first()) }
            itemList.count()
        } else {
            0
        }
    }

}