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
class LoginViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var _loginSuccess = MutableLiveData(false)
    var loginSuccess: LiveData<Boolean> = _loginSuccess

    private val _toastEvent = MutableSharedFlow<String>()
    val toastEvent = _toastEvent.asSharedFlow()

    fun login(emailName:String,password:String){

        val user = UserSignUpResponse.User(password = password)

        if(isEmail(emailName)){
            user.email = emailName
        }else{
            user.username = emailName
        }

        user.role = "User"

        viewModelScope.launch {

            when (val result = repository.login(user = user)) {
                is Resource.Success -> {
                    _loginSuccess.value = true
                }

                is Resource.Error -> {
                    Log.i("RegisterViewModel", "error message ${result.message}")
                    showToast(result.message.toString())
                }
            }

        }

    }

    private fun showToast(message: String) {
        viewModelScope.launch {
            _toastEvent.emit(message)
        }
    }

    private fun isEmail(input: String): Boolean {
        // Regex pattern to validate email
        return android.util.Patterns.EMAIL_ADDRESS.matcher(input).matches()
    }


}