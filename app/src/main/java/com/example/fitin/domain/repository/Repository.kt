package com.example.fitin.domain.repository

import com.example.fitin.domain.data.UserSignUpResponse
import com.example.fitin.domain.util.Resource

interface Repository {

    suspend fun signUp(user: UserSignUpResponse.User): Resource<UserSignUpResponse>

    suspend fun login(user: UserSignUpResponse.User): Resource<UserSignUpResponse>

    suspend fun updateProfile(token:String,user: UserSignUpResponse.User): Resource<UserSignUpResponse>

    suspend fun logout(token:String,user: UserSignUpResponse.User): Resource<UserSignUpResponse>


}