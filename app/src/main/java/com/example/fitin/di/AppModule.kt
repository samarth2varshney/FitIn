package com.example.fitin.di

import com.example.fitin.data.remote.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideData(): Api {
        return Retrofit.Builder()
            .baseUrl("http://10.22.15.92:3000/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }


}