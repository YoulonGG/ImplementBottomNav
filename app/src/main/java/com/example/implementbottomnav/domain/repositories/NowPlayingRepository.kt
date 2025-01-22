package com.example.implementbottomnav.domain.repositories

import com.example.implementbottomnav.data.dto.response.NowPlayingResponse

interface NowPlayingRepository {
    suspend fun getNowPlayingMovie() : NowPlayingResponse
}