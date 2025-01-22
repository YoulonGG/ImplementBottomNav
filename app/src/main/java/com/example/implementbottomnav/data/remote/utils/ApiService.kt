package com.example.implementbottomnav.data.remote.utils

import com.example.implementbottomnav.data.dto.response.NowPlayingResponse
import retrofit2.http.GET

interface ApiService {

    @GET("movie/now_playing?language=en-US&page=1")
    suspend fun getNowPlaying(): NowPlayingResponse

}