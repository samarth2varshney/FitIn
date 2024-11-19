package com.example.login_signup_data

import com.example.login_signup_domain.UserSignUpResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface LoginSignupApi {

    @POST("v1/user/signUp")
    suspend fun signUp(
        @Body request: UserSignUpResponse.User
    ): UserSignUpResponse

    @POST("v1/user/logIn")
    suspend fun login(
        @Body request: UserSignUpResponse.User
    ): UserSignUpResponse

    @PUT("v1/user/update-profile")
    suspend fun updateProfile(
        @Header("authorization") token:String,
        @Body request: UserSignUpResponse.User
    ): UserSignUpResponse

    @POST("v1/user/logout")
    suspend fun logout(
        @Header("authorization") token:String,
        @Body request: UserSignUpResponse.User
    ): UserSignUpResponse

}