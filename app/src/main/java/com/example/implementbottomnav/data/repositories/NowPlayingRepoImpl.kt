package com.example.implementbottomnav.data.repositories

import com.example.implementbottomnav.data.dto.response.NowPlayingResponse
import com.example.implementbottomnav.data.remote.utils.ApiService
import com.example.implementbottomnav.domain.repositories.NowPlayingRepository
import javax.inject.Inject

class NowPlayingRepoImpl @Inject constructor(private val apiService: ApiService) :
    NowPlayingRepository {
    override suspend fun getNowPlayingMovie(): NowPlayingResponse {
        return apiService.getNowPlaying()
    }
}