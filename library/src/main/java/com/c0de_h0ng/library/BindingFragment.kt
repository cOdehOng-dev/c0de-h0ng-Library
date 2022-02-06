package com.c0de_h0ng.library

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Created by c0de_h0ng on 2022/02/06.
 */
abstract class BindingFragment<VD: ViewDataBinding> : Fragment() {

    lateinit var rootActivity: BindingActivity<*>

    protected lateinit var binding: VD

    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.lifecycleOwner = this
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BindingActivity<*>)
            rootActivity = context
    }

}