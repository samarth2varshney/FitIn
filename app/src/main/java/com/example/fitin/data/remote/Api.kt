package com.example.fitin.data.remote

import com.example.fitin.domain.data.UserSignUpResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST("signUp")
    suspend fun signUp(
        @Body request: UserSignUpResponse.User
    ): UserSignUpResponse

}