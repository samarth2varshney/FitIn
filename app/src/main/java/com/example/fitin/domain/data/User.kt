package com.example.fitin.domain.data

data class UserSignUpResponse(
    val message: String?,
    val user: User?
) {

    data class User(
        val id: String = "",
        val username: String?,
        val email: String?,
        val password: String?,
        val session: Any?,
        val role: String?,
        val mobilenumber: String?,
        val gender: String?,
        val dob: String?
    )

}


