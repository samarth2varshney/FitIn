package com.example.fitin.ui.login_register

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitin.domain.data.UserSignUpResponse
import com.example.fitin.domain.repository.Repository
import com.example.fitin.domain.util.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var signUpSuccess = false

    fun signUp(user: UserSignUpResponse.User){

        viewModelScope.launch {

            when(val result = repository.signUp(user = user)){
                is Resource.Success->{
                    signUpSuccess = true
                }
                is Resource.Error->{
                    Log.i("RegisterViewModel","error message ${result.message}")
                }
            }

        }

    }

}