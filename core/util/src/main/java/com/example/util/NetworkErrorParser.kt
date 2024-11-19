package com.example.util

import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException

object NetworkErrorParser {
    fun parse(e: Exception): String {
        return when (e) {
            is HttpException -> {
                val errorBody = e.response()?.errorBody()?.string()
                if (errorBody != null) {
                    try {
                        val json = JSONObject(errorBody)
                        json.getString("message")
                    } catch (jsonException: Exception) {
                        "An error occurred: ${e.message()}"
                    }
                } else {
                    e.message() ?: "An unknown error occurred"
                }
            }
            is IOException -> "Network error: ${e.message}"
            else -> "An unexpected error occurred: ${e.localizedMessage}"
        }
    }
}