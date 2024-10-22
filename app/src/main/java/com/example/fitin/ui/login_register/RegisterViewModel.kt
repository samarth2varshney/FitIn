package com.example.fitin.ui.login_register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitin.domain.data.UserSignUpResponse
import com.example.fitin.domain.repository.Repository
import com.example.fitin.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var _signUpSuccess = MutableLiveData(false)
    var signUpSuccess:LiveData<Boolean> = _signUpSuccess

    private val _toastEvent = MutableSharedFlow<String>()
    val toastEvent = _toastEvent.asSharedFlow()


    fun signUp(user: UserSignUpResponse.User){

        if (user.username.isNullOrEmpty()) {
            showToast("Username cannot be empty")
        } else if (user.dob.isNullOrEmpty()) {
            showToast("Date of Birth cannot be empty")
        } else if (user.email.isNullOrEmpty()) {
            showToast("Email cannot be empty")
        } else if (user.password.isNullOrEmpty()) {
            showToast("Password cannot be empty")
        } else if (!isValidPassword(user.password!!)) {
            showToast("Password must be at least 8 characters long, include a lowercase letter, a digit, and a special character")
        }else {

            viewModelScope.launch {

                when (val result = repository.signUp(user = user)) {
                    is Resource.Success -> {
                        _signUpSuccess.value = true
                    }

                    is Resource.Error -> {
                        Log.i("RegisterViewModel", "error message ${result.message}")
                        showToast(result.message.toString())
                    }
                }

            }

        }
    }

    private fun showToast(message: String) {
        viewModelScope.launch {
            _toastEvent.emit(message)
        }
    }

    private fun isValidPassword(password: String): Boolean {
        // Define the required conditions using regular expressions.
        val hasLowerCase = Regex("[a-z]")
        val hasSpecialCharacter = Regex("[^A-Za-z0-9]")
        val hasDigit = Regex("[0-9]")

        // Check all conditions
        return password.length >= 8 &&
                hasLowerCase.containsMatchIn(password) &&
                hasSpecialCharacter.containsMatchIn(password) &&
                hasDigit.containsMatchIn(password)
    }

}