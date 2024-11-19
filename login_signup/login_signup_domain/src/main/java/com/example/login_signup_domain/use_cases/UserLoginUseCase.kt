package com.example.login_signup_domain.use_cases

import com.example.login_signup_domain.LoginSignupRepository
import com.example.login_signup_domain.UserSignUpResponse
import com.example.util.Resource
import javax.inject.Inject

class UseCases @Inject constructor(private val loginSignupRepository: LoginSignupRepository) {

    suspend fun login(user:UserSignUpResponse.User): Resource<UserSignUpResponse> {
        return loginSignupRepository.login(user = user)
    }

    suspend fun signup(user:UserSignUpResponse.User): Resource<UserSignUpResponse>{
        return loginSignupRepository.signUp(user)
    }

}