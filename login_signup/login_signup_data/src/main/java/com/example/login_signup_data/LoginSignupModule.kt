package com.example.login_signup_data

import com.example.login_signup_domain.LoginSignupRepository
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
object LoginSignupModule {

    @Provides
    @Singleton
    fun provideLoginSignupApi(retrofit: Retrofit): LoginSignupApi {
        return retrofit.create()
    }

    @Provides
    @Singleton
    fun provideLoginSignupRepository(loginSignupApi: LoginSignupApi): LoginSignupRepository {
        return LoginSignupRepositoryImpl(loginSignupApi)
    }

}
