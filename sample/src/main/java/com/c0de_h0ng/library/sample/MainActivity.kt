package com.c0de_h0ng.library.sample

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.c0de_h0ng.library.R
import com.c0de_h0ng.library.base.BaseActivity
import com.c0de_h0ng.library.databinding.ActivityMainBinding
import com.c0de_h0ng.library.util.ChlibLog

class MainActivity : BaseActivity() {

//    override val layoutRes: Int
//        get() = R.layout.activity_main
//
//    override fun bindingProperty() {
//
//    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ChlibLog.debug("바인딩 " + DataBindingUtil.setContentView(this, R.layout.activity_main))
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //bindingView<ActivityMainBinding>(R.layout.activity_main)
//        val  s = compareCurrentInputDate("yyyy-MM-dd HH:mm:ss", "2021.02.05 23:50:00")
//        ChlibLog.debug("날짜 $s")
        //binding.textString = "헬로 월드!"

//        Handler().postDelayed({
//            ChlibAlert.Builder(this)
//                .setTitle("알림")
//                .setContent("테스트")
//                .build()
//                .show()
//        }, 200)

//        ChlibAlert.Builder(this)
//            .setTitle("알림")
//            .setContent("테스트")
//            .build()
//            .show(R.drawable.chlib_white_radius_4dp_bg, R.drawable.chlib_white_radius_4dp_bg)
    }

}