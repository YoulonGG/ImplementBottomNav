package com.example.implementbottomnav.data.remote.utils

import com.example.implementbottomnav.data.dto.response.NowPlayingResponse
import retrofit2.http.GET

interface ApiService {

    @GET("now_playing")
    suspend fun getNowPlaying(): NowPlayingResponse

}