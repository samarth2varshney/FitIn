package com.example.login_signup_data

import com.example.login_signup_domain.LoginSignupRepository
import com.example.login_signup_domain.UserSignUpResponse
import com.example.util.NetworkErrorParser
import com.example.util.Resource
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginSignupRepositoryImpl @Inject constructor(
    private val api: LoginSignupApi
) : LoginSignupRepository {

    override suspend fun signUp(user: UserSignUpResponse.User): Resource<UserSignUpResponse> {
        return try {
            Resource.Success(
                data = api.signUp(
                    user
                )
            )
        } catch (e: HttpException) {
            e.printStackTrace()
            val errorBody = e.response()?.errorBody()?.string()
            val errorMessage = if (errorBody != null) {
                try {
                    val json = JSONObject(errorBody)
                    json.getString("message")
                } catch (jsonException: Exception) {
                    "An error occurred: ${e.message()}"
                }
            } else {
                e.message() ?: "An unknown error occurred"
            }
            Resource.Error(errorMessage)
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Error("Network error: ${e.message}")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An unexpected error occurred: ${e.localizedMessage}")
        }
    }

    override suspend fun login(user: UserSignUpResponse.User): Resource<UserSignUpResponse> {
        return try {
            Resource.Success(
                data = api.login(
                    user
                )
            )
        } catch (e: HttpException) {
            e.printStackTrace()
            val errorBody = e.response()?.errorBody()?.string()
            val errorMessage = if (errorBody != null) {
                try {
                    val json = JSONObject(errorBody)
                    json.getString("message")
                } catch (jsonException: Exception) {
                    "An error occurred: ${e.message()}"
                }
            } else {
                e.message() ?: "An unknown error occurred"
            }
            Resource.Error(errorMessage)
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Error("Network error: ${e.message}")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An unexpected error occurred: ${e.localizedMessage}")
        }
    }

    override suspend fun updateProfile(
        token: String,
        user: UserSignUpResponse.User
    ): Resource<UserSignUpResponse> {
        return try {
            Resource.Success(
                data = api.updateProfile(
                    token,
                    user
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(NetworkErrorParser.parse(e))
        }
    }

    override suspend fun logout(
        token: String,
        user: UserSignUpResponse.User
    ): Resource<UserSignUpResponse> {
        return try {
            Resource.Success(
                data = api.logout(
                    token,
                    user
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(NetworkErrorParser.parse(e))
        }
    }


}