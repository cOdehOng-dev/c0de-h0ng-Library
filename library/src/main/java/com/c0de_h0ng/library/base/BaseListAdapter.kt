package com.c0de_h0ng.library.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * Created by c0de_h0ng on 2022/02/07.
 */
abstract class BaseListAdapter<T> constructor(
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
        holder.bind(getItem(position))
    }

}