package com.example.implementbottomnav.domain.di

import com.example.implementbottomnav.data.repositories.NowPlayingRepoImpl
import com.example.implementbottomnav.domain.repositories.NowPlayingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindContentLatestRepository(
        imageRepositoryImpl: NowPlayingRepoImpl
    ): NowPlayingRepository

}