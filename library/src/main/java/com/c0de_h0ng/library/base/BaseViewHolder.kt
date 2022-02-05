package com.c0de_h0ng.library.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by c0de_h0ng on 2022/02/06.
 */
abstract class BaseViewHolder<T, B: ViewDataBinding> constructor(
    @LayoutRes layoutRes: Int,
    parent: ViewGroup
) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)) {

    protected var binding: B = DataBindingUtil.bind(itemView)!!

    abstract fun bind(data: T)

    fun unbind() {
        binding.unbind()
    }

}