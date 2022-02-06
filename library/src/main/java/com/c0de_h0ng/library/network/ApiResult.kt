package com.c0de_h0ng.library.network

/**
 * Created by c0de_h0ng on 2022/02/06.
 */
sealed class ApiResult<out T : Any> {
    data class Success<out T : Any>(val data: T?) : ApiResult<T>()
    data class Fail(val code: String, val message: String?) : ApiResult<Nothing>()
    data class Error(val exception: String?, val errorType: Int) : ApiResult<Nothing>()
}
