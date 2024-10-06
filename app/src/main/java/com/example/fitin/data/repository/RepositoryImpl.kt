package com.example.fitin.data.repository

import com.example.fitin.data.remote.Api
import com.example.fitin.domain.data.UserSignUpResponse
import com.example.fitin.domain.repository.Repository
import com.example.fitin.domain.util.Resource
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api:Api
) : Repository {

    override suspend fun signUp(user: UserSignUpResponse.User): Resource<UserSignUpResponse> {
        return try {
            Resource.Success(
                data = api.signUp(
                    user
                )
            )
        }catch (e: Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error")
        }
    }

}