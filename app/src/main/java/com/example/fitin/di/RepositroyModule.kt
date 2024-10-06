package com.example.fitin.di

import com.example.fitin.data.repository.RepositoryImpl
import com.example.fitin.domain.repository.Repository
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
    abstract fun bindYoutubeRepository(youtubeRepositoryImpl: RepositoryImpl): Repository

}