package com.example.login_signup_domain

import com.example.login_signup_domain.use_cases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginSignupDomainModule {

    @Provides
    @Singleton
    fun provideUserLoginUseCase(loginSignupRepository: LoginSignupRepository): UseCases {
        return UseCases(loginSignupRepository)
    }

}