package com.c0de_h0ng.library.network

import com.c0de_h0ng.library.util.ChlibLog
import retrofit2.Response

/**
 * Created by c0de_h0ng on 2022/02/06.
 */
suspend fun <T : Any> ApiCallWithCoroutine(call: suspend () -> Response<T>): ApiResult<T> {
    return try {
        val myResp = call.invoke()
        if (myResp.isSuccessful) {
            ApiResult.Success(myResp.body())
        } else {
            ChlibLog.debug("서버 호출 실패 " + myResp.message())
            ApiResult.Error(myResp.message(), 100)
        }
    } catch (e: Exception) {
        ChlibLog.debug("인터넷 연결 안됨 " + e.message)
        ApiResult.Error(e.message, 200)
    }
}

fun <T : Any> ApiCall(call: () -> Response<T>): ApiResult<T> {
    return try {
        val myResp = call.invoke()
        if (myResp.isSuccessful) {
            ApiResult.Success(myResp.body())
        } else {
            ChlibLog.debug("서버 호출 실패 " + myResp.message())
            ApiResult.Error(myResp.message(), 100)
        }
    } catch (e: Exception) {
        ChlibLog.debug("인터넷 연결 안됨 " + e.message)
        ApiResult.Error(e.message, 200)
    }
}