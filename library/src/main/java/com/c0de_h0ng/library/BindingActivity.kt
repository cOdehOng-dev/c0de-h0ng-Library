package com.c0de_h0ng.library

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.c0de_h0ng.library.base.BaseActivity

/**
 * Created by c0de_h0ng on 2022/02/05.
 */
abstract class BindingActivity<V : ViewDataBinding> : BaseActivity() {

    protected lateinit var binding: V

    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        bindingProperty()
    }

    abstract fun bindingProperty()

}