package com.c0de_h0ng.library

import android.view.View
import com.c0de_h0ng.library.databinding.ActivityMainBinding
import com.c0de_h0ng.library.util.ChlibLog

class MainActivity : BindingActivity<ActivityMainBinding>(), View.OnClickListener {

    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun bindingProperty() {
        binding.onClick = this
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_scroll_test) {
            ChlibLog.debug("스크롤 테스트")
        }
    }

}