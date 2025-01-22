package com.example.implementbottomnav.core.utils

import com.example.implementbottomnav.data.remote.common.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class BaseUseCase<T>() {
    operator fun invoke(): Flow<ApiResult<T>> {
        return if (InternetUtil.isNetworkAvailable()) {
            execute()
        } else {
            flow {
                emit(ApiResult.Error(error = getInternetError()))
            }
        }
    }

    private fun getInternetError(): Throwable? {
        return null
    }

    protected abstract fun execute(): Flow<ApiResult<T>>
}