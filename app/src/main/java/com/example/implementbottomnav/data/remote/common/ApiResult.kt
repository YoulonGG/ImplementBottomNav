package com.example.implementbottomnav.data.remote.common

sealed class ApiResult<T>(
    val data: T? = null,
    val error: Throwable? = null,
) {
    class Loading<T>(
        data: T? = null,
    ) : ApiResult<T>(data)

    class Success<T>(
        data: T,
    ) : ApiResult<T>(data)

    class Error<T>(
        error: Throwable? = null,
    ) : ApiResult<T>(null, error)
}