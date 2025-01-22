package com.example.implementbottomnav.domain.useCase

import com.example.implementbottomnav.core.utils.BaseUseCase
import com.example.implementbottomnav.data.dto.response.NowPlayingResponse
import com.example.implementbottomnav.data.remote.common.ApiResult
import com.example.implementbottomnav.domain.repositories.NowPlayingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NowPlayingUseCase @Inject constructor (private val repository: NowPlayingRepository) :
    BaseUseCase<NowPlayingResponse>() {
    override fun execute(): Flow<ApiResult<NowPlayingResponse>> = flow {
        emit(ApiResult.Loading())
        try {
            val response = repository.getNowPlayingMovie()
            emit(ApiResult.Success(response))
        } catch (ex: Exception) {
//            emit(ex.toApiError())
        }
    }
}