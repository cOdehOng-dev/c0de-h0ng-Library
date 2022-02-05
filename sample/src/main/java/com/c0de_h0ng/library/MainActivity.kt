package com.c0de_h0ng.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.c0de_h0ng.library.util.ChlibLog
import com.c0de_h0ng.library.util.DateUtil.compareCurrentInputDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  s = compareCurrentInputDate("yyyy-MM-dd HH:mm:ss", "2021.02.05 23:50:00")
        ChlibLog.debug("날짜 $s")
    }
}