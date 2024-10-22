package com.example.fitin.data.remote

import com.example.fitin.domain.data.UserSignUpResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface Api {

    @POST("signUp")
    suspend fun signUp(
        @Body request: UserSignUpResponse.User
    ): UserSignUpResponse

    @POST("logIn")
    suspend fun login(
        @Body request: UserSignUpResponse.User
    ): UserSignUpResponse

    @PUT("update-profile")
    suspend fun updateProfile(
        @Header("authorization") token:String,
        @Body request: UserSignUpResponse.User
    ): UserSignUpResponse

    @POST("logout")
    suspend fun logout(
        @Header("authorization") token:String,
        @Body request: UserSignUpResponse.User
    ): UserSignUpResponse
}