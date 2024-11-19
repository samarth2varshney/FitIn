package com.example.login_signup_domain

import com.example.util.Resource

interface LoginSignupRepository {

    suspend fun signUp(user: UserSignUpResponse.User): Resource<UserSignUpResponse>

    suspend fun login(user: UserSignUpResponse.User): Resource<UserSignUpResponse>

    suspend fun updateProfile(token:String,user: UserSignUpResponse.User): Resource<UserSignUpResponse>

    suspend fun logout(token:String,user: UserSignUpResponse.User): Resource<UserSignUpResponse>

}