package com.c0de_h0ng.library.util

import com.c0de_h0ng.library.const.Const.HOUR
import com.c0de_h0ng.library.const.Const.MIN
import com.c0de_h0ng.library.const.Const.SEC
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by c0de_h0ng on 2022/02/05.
 */
/**
 * 현재 날짜와 비교 날짜를 방금, 몇 분전, 몇 시간전, 어제 게시 날짜로 변환
 * @param datePattern 날짜 패턴 ex) yyyy-MM-dd HH:mm:ss
 * @param compareDate 비교 날짜
 */
fun compareCurrentInputDate(datePattern: String, compareDate: String): String {
    val formatAlarmCreateDate = compareDate.substring(0, compareDate.indexOf(" "))
    try {
        val date = SimpleDateFormat(datePattern, Locale.getDefault()).parse(compareDate)
        return if (date != null) {
            val curTime = System.currentTimeMillis()
            val regTime: Long = date.time
            var diffTime = (curTime - regTime) / 1000
            val msg: String
            when {
                diffTime < SEC -> { // 1분이하 -> 방금전
                    msg = "방금전"
                }
                SEC.let { diffTime /= it; diffTime } < MIN -> { //1분이상 60분이하 -> n분전
                    msg = diffTime.toString() + "분전"
                }
                MIN.let { diffTime /= it; diffTime } < HOUR -> { //1시간이상 24시간이하 -> n시간전
                    msg = diffTime.toString() + "시간전"
                }
                else -> {
                    msg = formatAlarmCreateDate
                }
            }
            msg
        } else {
            formatAlarmCreateDate
        }
    } catch (e: Exception) {
        return formatAlarmCreateDate
    }
}