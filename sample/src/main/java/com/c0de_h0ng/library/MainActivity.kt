package com.c0de_h0ng.library

import android.os.Bundle
import com.c0de_h0ng.library.base.BaseBindingActivity
import com.c0de_h0ng.library.databinding.ActivityMainBinding

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun bindingProperty() {

    }

    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.textString = "!@#1323231"
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