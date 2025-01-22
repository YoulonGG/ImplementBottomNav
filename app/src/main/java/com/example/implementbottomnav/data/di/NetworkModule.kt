package com.example.implementbottomnav.data.di

import com.example.implementbottomnav.data.remote.utils.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideInfiniteImageApi(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .addInterceptor { chain ->
                        val request = chain.request().newBuilder()
                            .addHeader(
                                "Authorization",
                                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2NTFiY2M3MTEwZmY3NGZlMTZlNTE3NmU0NWZiZTE4MiIsIm5iZiI6MTczNzUxODE2Ni43OTksInN1YiI6IjY3OTA2YzU2ZmMyNTE5YjQzZjc3NDMyMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.B3qPp3Z0PfvzzP9LX3wU--0kPQ7skoM_Ra9Nc55XeHE"
                            )
                            .build()
                        chain.proceed(request)
                    }
                    .build()
            )
            .build()
            .create(ApiService::class.java)
    }
}