package com.example.fitin.domain.data

data class UserSignUpResponse(
    val message: String?,
    val user: User?
) {

    data class User(
        var id: String = "",
        var username: String? = null,
        var email: String? = null,
        var password: String? = null,
        var session: Any? = null,
        var role: String? = null,
        var mobilenumber: String? = null,
        var gender: String? = null,
        var dob: String? = null
    )

}


