package com.c0de_h0ng.library.util

import android.util.Log
import com.c0de_h0ng.library.BuildConfig
import java.lang.StringBuilder

/**
 * Created by c0de_h0ng on 2022/02/05.
 */
object HLog {

    fun debug(msg: String?) {
        if (BuildConfig.DEBUG)
            Log.d("<Debug>", buildLogMsg(msg))
    }

    fun error(msg: String?) {
        if (BuildConfig.DEBUG)
            Log.e("<Error>", buildLogMsg(msg))
    }

    fun warning(msg: String?) {
        if (BuildConfig.DEBUG)
            Log.w("<Warning>", buildLogMsg(msg))
    }

    fun info(msg: String?) {
        if (BuildConfig.DEBUG)
            Log.i("<Info>", buildLogMsg(msg))
    }

    fun verbose(msg: String?) {
        if (BuildConfig.DEBUG)
            Log.v("<Verbose>", buildLogMsg(msg))
    }

    private fun buildLogMsg(message: String?): String {
        val ste = Thread.currentThread().stackTrace[4]
        val sb = StringBuilder()
        sb.append("[")
        sb.append(ste.fileName.replace(".java", ""))
        sb.append("::")
        sb.append(ste.methodName)
        sb.append("]")
        sb.append(message ?: "No Message")
        return sb.toString()
    }
}